package util;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

public class Maskara {
	
	public static JFormattedTextField getMascara(String mascara){
		if(mascara!=null){
			 MaskFormatter mask = null;  
			       try{  
			          mask = new MaskFormatter(mascara);                    
			          }catch(java.text.ParseException ex){
			        	  return new JFormattedTextField();
			          } 
			 return new JFormattedTextField(mask);
			}
		return new JFormattedTextField();
	}


}
