package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class Criptografia {
	
	 public static String encripta (String senha) {     
		        try {     
		                   MessageDigest digest = MessageDigest.getInstance("MD5");      
		                   digest.update(senha.getBytes());      
		                  BASE64Encoder encoder = new BASE64Encoder ();      
		                  return encoder.encode (digest.digest ());      
		        } catch (NoSuchAlgorithmException ns) {     
		                 ns.printStackTrace ();      
		               return senha;      
		           }      
		         }
	 public static void main(String[] argv){
		 String senha=Criptografia.encripta("123456789012345");
		 System.out.println(senha+"   "+senha.length());
		 System.out.println(Criptografia.encripta("123456789012345"));
	 }

}
