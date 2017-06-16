package Controllers;

import java.sql.ResultSet;
import java.util.List;

import DAO.IProgramaDAO;
import DAO.ProgramaDAO;
import business.Programa;

public class ControllersPrograma implements IControllersPrograma{
	
	private static ControllersPrograma instacia = null;
	
	public static ControllersPrograma getInstancia(){
		if(instacia == null){
			instacia = new ControllersPrograma();
			return instacia;
		}
		else{
			return instacia;
		}
	}
			
	@Override
	public boolean atualizarPrograma(Programa programa)   {
		IProgramaDAO DAOPrograma = ProgramaDAO.getInstancia();
		try{
			DAOPrograma.atualizarPrograma(programa);
		}
		catch (Exception e1){
			e1.printStackTrace();
			
		}
		return true;
	}

	@Override
	public ResultSet consultarPrograma(String nome){
		IProgramaDAO DAOPrograma = ProgramaDAO.getInstancia();
		try{
			return DAOPrograma.consultarPrograma(nome);
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
		
		
	}

	@Override
	public Programa consultarUmPrograma(Programa programa)   {
		IProgramaDAO DAOPrograma = ProgramaDAO.getInstancia();
		try{
			return DAOPrograma.consultarUmPrograma(programa);
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean inserirPrograma(Programa programa)   {
		IProgramaDAO DAOPrograma = ProgramaDAO.getInstancia();
		try{
			DAOPrograma.inserirPrograma(programa);
			System.out.println("DAO");
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public ResultSet listarPrograma(ResultSet rs)   {
		IProgramaDAO DAOPrograma = ProgramaDAO.getInstancia();
		try{
			return DAOPrograma.listarPrograma(rs);
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public void removerPrograma(Programa programa) {
		IProgramaDAO DAOPrograma = ProgramaDAO.getInstancia();
		try{
			DAOPrograma.removerPrograma(programa);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List<Programa> listarTodosPrograma() {
		IProgramaDAO DAOPrograma = ProgramaDAO.getInstancia();
		try {
			return DAOPrograma.listarTodosPrograma();
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
