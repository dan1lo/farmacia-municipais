package business;

import util.ValidarDados;

public class ValidarUsuario {
	
	public String validarUsuario(Usuario user, String confirmaSenha){
		if(!ValidarDados.validar("[^0-9]+", user.getCargo()) )
			return "Campo cargo est� vazio ou cont�m n�meros!";
		if(user.getLogin().isEmpty())
			return "Campo Login est� vazio!";
		if(!ValidarDados.validar("[^0-9]+", user.getNome()))
			return "Campo Nome n�o pode conter n�meros ou ficar vazio!";
		if(!user.getSenha().equals(confirmaSenha))
			return "Os campos Senha e Repetir senha n�o coincidem!";
		
		return null;
		
	}

}
