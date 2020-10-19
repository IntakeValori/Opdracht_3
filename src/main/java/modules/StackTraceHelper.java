package modules;

public class StackTraceHelper {
	// TODO only works with java 9...
	public static String getMethodNameCaller() {
		return StackWalker.getInstance().walk(s -> s.skip(1).findFirst().get().getMethodName());
	}

}