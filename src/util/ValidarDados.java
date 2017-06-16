package util;
import java.util.regex.*;

public class ValidarDados {
	private static Pattern padrao;
	private static Matcher matches;
	
	public static boolean validar(String expresao, String string){
		padrao= Pattern.compile(expresao);
		matches=padrao.matcher(string);
		return matches.matches();
		
	}

}
