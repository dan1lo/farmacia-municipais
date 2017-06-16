package Controllers;
import java.util.List;

import DAO.IUnidadesDAO;
import DAO.UnidadesDAO;
import business.Unidades;
import business.ValidarUnidade;

public class ControllerUnidades implements IControllerUnidades{
	
	
	public List<Unidades> pegarAllUnidades(){
		IUnidadesDAO unidadeDAO=  new UnidadesDAO();
		return unidadeDAO.pegarTodasUnidades();
	}
	public List<Unidades> pegarUnidadesResponsavel(String responsavel){
		IUnidadesDAO unidadeDAO= new UnidadesDAO();
		if(responsavel!=null)
			return unidadeDAO.pegarUnidadesResponsavel(responsavel);
		return null;
	}
	public List<Unidades> pegarUnidadesTipo(String tipo){
		IUnidadesDAO unidadeDAO= new UnidadesDAO();
		if(tipo!=null)
			return unidadeDAO.pegarUnidadesTipo(tipo);
		return null;
	}
	public Unidades pegarUnidade(Unidades unidade){
		IUnidadesDAO unidadeDAO= new UnidadesDAO();
		if(unidade!=null)
			return unidadeDAO.pegarUnidade(unidade);
		return null;
	}
	public boolean inserirUnidade(Unidades unidade){
		IUnidadesDAO unidadeDAO= new UnidadesDAO();
		if(unidade!=null){
			return unidadeDAO.inserirUnidade(unidade);
		}
		return false;
	}
	public boolean excluirUnidade(Unidades unidade){
		IUnidadesDAO unidadeDAO= new UnidadesDAO();
		if(unidade!=null)
			return unidadeDAO.excluirUnidade(unidade);
		return false;
	}
	public boolean atualizarUnidade(Unidades unidade){
		IUnidadesDAO unidadeDAO= new UnidadesDAO();
		if(unidade!=null)
			return unidadeDAO.atualizarUnidade(unidade);
		return false;
	}
	public boolean excluirAllUnidades(){
		IUnidadesDAO unidadeDAO= new UnidadesDAO();
		return unidadeDAO.excluirTodasUnidades();
	}
	public String validarUnidade(Unidades unidade){
		ValidarUnidade valida= new ValidarUnidade();
		return valida.validarUnidade(unidade);
	}

}
