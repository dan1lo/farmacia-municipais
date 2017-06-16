package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import business.Programa;

public class ProgramaDAO implements IProgramaDAO {
	
	private static ProgramaDAO instancia = null;
	
	public static ProgramaDAO getInstancia (){
		if (instancia == null){
			instancia = new ProgramaDAO();
			return instancia;
		}
		else{
			return instancia;
		}
	}
	
	
	
	@Override
	public boolean atualizarPrograma(Programa programa) {
		try{
			Connection conexao = ConnectionFactory.getConnection();
			
			PreparedStatement st = conexao.prepareStatement("UPDATE programa SET nome=?, descricao=? WHERE cod_prog=?");
			st.setString(1, programa.getNome());
			st.setString(2, programa.getText());
			st.setInt(3, programa.getCod_prog());
			st.execute();
			st.close();
			conexao.close();
			return true;
		}
		catch (SQLException e){
			return false;
		}
	}

	@Override
	public ResultSet consultarPrograma(String nome) {
		try{
			Connection conexao = ConnectionFactory.getConnection();
			PreparedStatement st = conexao.prepareStatement("SELECT * FROM programa WHERE nome LIKE '"+nome+"%'");
			ResultSet rs1 = st.executeQuery();
			return (rs1);
		}
		catch (SQLException e){
			return null;
		}
	}

	@Override
	public Programa consultarUmPrograma(Programa programa) {
		PreparedStatement st = null;
		ResultSet rs = null;
		Programa programaConsulta = null;
		try{
			Connection conexao = ConnectionFactory.getConnection();
			st = conexao.prepareStatement("SELECT * FROM programa WHERE nome = ?");
			st.setString(1, programa.getNome());
			rs = st.executeQuery();
			
			while(rs.next()){
				if(rs.getString("nome").equals(String.valueOf(programa.getNome())));
					programaConsulta = new Programa();
					
					programaConsulta.setCod_prog(rs.getInt("cod_prog"));
					programaConsulta.setNome(rs.getString("nome"));
					programaConsulta.setText(rs.getString("descricao"));
					
			}
			st.close();
			conexao.close();
			
		}
		catch (SQLException e){
			return null;
		}
		return programaConsulta;
	}

	@Override
	public boolean inserirPrograma(Programa programa)  {
		System.out.println("Aki");
		try {
			System.out.println("Ta no Banco 1");
					
			Connection conexao = ConnectionFactory.getConnection();
			System.out.println("Ta no Banco 2");
			PreparedStatement st = conexao.prepareStatement("INSERT INTO programa (nome, descricao) VALUES (?, ?)");
			st.setString(1, programa.getNome());
			st.setString(2, programa.getText());
			st.execute();
			st.close();
			conexao.close();
			System.out.println("Ta no Banco3");
			return true;
		}
		catch (SQLException e){
			return false;	
		}
	}

	@Override
	public ResultSet listarPrograma(ResultSet rs) {
		try {
			Connection conexao = ConnectionFactory.getConnection();
			PreparedStatement st = conexao.prepareStatement("SELECT * FROM programa");
			
			ResultSet rs2 = st.executeQuery();
			
			return (rs2);
		}
		catch (SQLException e){
			return null;
		}
	}

	@Override
	public void removerPrograma(Programa programa) {
		try{
			Connection conexao = ConnectionFactory.getConnection();
			
			PreparedStatement st = conexao.prepareStatement("DELETE FROM programa WHERE cod_prog=?");
			st.setInt(1, programa.getCod_prog());
			st.execute();
			st.close();
			conexao.close();		
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}



	@Override
	public List<Programa> listarTodosPrograma()  {
		try {
			Connection conexao = ConnectionFactory.getConnection();
			PreparedStatement st = conexao.prepareStatement("SELECT nome FROM programa ORDER BY nome");
			
			ResultSet rs2 = st.executeQuery();
			
			List<Programa> list = new ArrayList<Programa>();
			
			
			
			while (rs2.next()){
				Programa programaL = new Programa();
				
				programaL.setNome(rs2.getString("nome"));
				list.add(programaL);
			}
			
			return (list);
		}
		catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}
}
