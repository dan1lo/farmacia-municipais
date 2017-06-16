package business;

import util.ValidarDados;

public class ValidarUsuario {
	
	public String validarUsuario(Usuario user, String confirmaSenha){
		if(!ValidarDados.validar("[^0-9]+", user.getCargo()) )
			return "Campo cargo está vazio ou contém números!";
		if(user.getLogin().isEmpty())
			return "Campo Login está vazio!";
		if(!ValidarDados.validar("[^0-9]+", user.getNome()))
			return "Campo Nome não pode conter números ou ficar vazio!";
		if(!user.getSenha().equals(confirmaSenha))
			return "Os campos Senha e Repetir senha não coincidem!";
		
		return null;
		
	}

}
