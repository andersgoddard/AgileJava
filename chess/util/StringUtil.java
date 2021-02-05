package util;

public class StringUtil {
	
	public static final String NEWLINE = System.getProperty("line.separator");
	
	private StringUtil() {}
	
	public static String appendNewLine(String s){		
		return s + NEWLINE;
	}
	
}