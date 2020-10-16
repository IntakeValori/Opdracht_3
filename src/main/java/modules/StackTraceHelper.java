package modules;

public class StackTraceHelper {

	public static String getMethodNameCaller() {
		return StackWalker.getInstance().walk(s -> s.skip(1).findFirst().get().getMethodName());
	}

}
