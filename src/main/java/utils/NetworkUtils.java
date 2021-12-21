package utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v96.fetch.Fetch;
import org.openqa.selenium.devtools.v96.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v96.network.Network;
import org.openqa.selenium.devtools.v96.network.model.ErrorReason;

import java.util.Arrays;
import java.util.List;

import static java.util.Optional.*;
import java.util.Optional;

public class NetworkUtils {

    private WebDriver driver;
    private DevTools devTools;

    private static int bufferSize = 100000000;

    public NetworkUtils(WebDriver driver){
        this.driver = driver;
        try{
            this.devTools = ((ChromeDriver)driver).getDevTools();
        } catch (Error error){
            throw new Error("Typecasting error. Do not attempt to use Network Utils class with a browser other than chrome.");
        }
    }

    public NetworkUtils startSession(){
        devTools.createSession();
        return this;
    }

    public void blockRequest(String urlContains){
        RequestPattern pattern = new RequestPattern(of("*" + urlContains + "*"), empty(), empty());
        List<RequestPattern> patternList = Arrays.asList((pattern));

        devTools.send(Fetch.enable(of(patternList), empty()));
        devTools.addListener(Fetch.requestPaused(), request -> {
            String url = request.getRequest().getUrl();
            url.replace(urlContains, "randomgibberish");
            devTools.send(Fetch.continueRequest(request.getRequestId(),
                    Optional.of(url),
                    Optional.of(request.getRequest().getMethod()),
                    request.getRequest().getPostData(),
                    request.getResponseHeaders(),
                    Optional.of(false)));
            System.out.println("This request was blocked:");
            System.out.println("url: " + request.getRequest().getUrl());
            System.out.println("method: " + request.getRequest().getMethod());
            System.out.println("body(if POST): " + request.getRequest().getPostData());
        });
    }

    public void blockPostRequest(String urlContains){
        RequestPattern pattern = new RequestPattern(of("*" + urlContains + "*"), empty(), empty());
        List<RequestPattern> patternList = Arrays.asList((pattern));

        devTools.send(Fetch.enable(of(patternList), empty()));
        devTools.addListener(Fetch.requestPaused(), request -> {
            if(request.getRequest().getMethod().equals("POST")){
                String url = request.getRequest().getUrl();
                url.replace(urlContains, "randomgibberish");
                devTools.send(Fetch.continueRequest(request.getRequestId(),
                        Optional.of(url),
                        Optional.of(request.getRequest().getMethod()),
                        request.getRequest().getPostData(),
                        request.getResponseHeaders(),
                        Optional.of(false)));
                System.out.println("This request was blocked:");
                System.out.println("url: " + request.getRequest().getUrl());
                System.out.println("method: " + request.getRequest().getMethod());
                System.out.println("body: " + request.getRequest().getPostData());
            }
        });
    }

    public NetworkUtils stopSession(){
        devTools.send(Network.disable());
        return this;
    }
}
