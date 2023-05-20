package api;

import entities.Persona;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import javax.net.ssl.SSLHandshakeException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class RandomApi {
    private JSONObject getJson(URL url) throws Exception {
        try {
            String json = IOUtils.toString(url, StandardCharsets.UTF_8);
            return new JSONObject(json);
        } catch (SSLHandshakeException exception) {
            throw new Exception("Missing SSL certificate within the JRE", exception);
        }
    }

    public Persona getRandomPersona() throws Exception {
        JSONObject jsonObject = this.getJson(new URL("https://randomuser.me/api/"));
        JSONObject firstResult = jsonObject.getJSONArray("results").getJSONObject(0);

        Persona persona = new Persona();
        persona.firstName = firstResult.getJSONObject("name").getString("first");
        persona.lastName = firstResult.getJSONObject("name").getString("last");
        persona.email = firstResult.getString("email");

        return persona;
    }
}