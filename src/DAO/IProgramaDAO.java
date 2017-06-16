package DAO;

import java.sql.ResultSet;
import java.util.List;

import business.Programa;

public interface IProgramaDAO {
	
	public boolean inserirPrograma(Programa programa);
	public boolean atualizarPrograma(Programa programa) ;
	public void removerPrograma(Programa programa) ;
	public ResultSet consultarPrograma(String nome) ;
	public Programa consultarUmPrograma(Programa programa) ;
	public ResultSet listarPrograma(ResultSet rs) ;
	public List<Programa> listarTodosPrograma();
	
}
