package business;

import util.ValidarDados;

public class ValidarUnidade {
	
	public String validarUnidade(Unidades unidade){
		if(!ValidarDados.validar("[^0-9]+", unidade.getBairro()))
			return "Bairro est� vazio ou cont�m n�meros!";
		if(!ValidarDados.validar("[^0-9]+",unidade.getCidade()))
			return "Cidade est� vazio ou cont�m n�meros!";
		if(unidade.getLogradouro().equals(""))
			return "Endere�o est� vazio!";
		if(!ValidarDados.validar("[^0-9]+", unidade.getNomeResponsavel()))
			return "Respons�vel est� vazio ou cont�m n�meros!";
		if(!ValidarDados.validar("\\d{8}", unidade.getCep()))
			return "CEP deve conter 8 d�gitos!";
		if(!ValidarDados.validar("\\d{8}", unidade.getCnes()))
			return "C�digo CNES deve conter 8 d�gitos!";
		if(!ValidarDados.validar("\\d{10}", unidade.getFone()))
			return "Telefone de conter 10 d�gitos!";
		return null;
		
	}

}
