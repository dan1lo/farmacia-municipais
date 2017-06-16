package business;

import util.ValidarDados;

public class ValidarUnidade {
	
	public String validarUnidade(Unidades unidade){
		if(!ValidarDados.validar("[^0-9]+", unidade.getBairro()))
			return "Bairro está vazio ou contém números!";
		if(!ValidarDados.validar("[^0-9]+",unidade.getCidade()))
			return "Cidade está vazio ou contém números!";
		if(unidade.getLogradouro().equals(""))
			return "Endereço está vazio!";
		if(!ValidarDados.validar("[^0-9]+", unidade.getNomeResponsavel()))
			return "Responsável está vazio ou contém números!";
		if(!ValidarDados.validar("\\d{8}", unidade.getCep()))
			return "CEP deve conter 8 dígitos!";
		if(!ValidarDados.validar("\\d{8}", unidade.getCnes()))
			return "Código CNES deve conter 8 dígitos!";
		if(!ValidarDados.validar("\\d{10}", unidade.getFone()))
			return "Telefone de conter 10 dígitos!";
		return null;
		
	}

}
