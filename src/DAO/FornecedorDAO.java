package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import business.Fornecedor;

public class FornecedorDAO implements IFornecedorDAO{

	private static FornecedorDAO instacia = null;
	
	public static FornecedorDAO getInstancia(){
		if(instacia == null){
			instacia = new FornecedorDAO();
			return instacia;
		}
		else{
			return instacia;
		}
	}
	
	
	@Override
	public boolean atualizarFornecedor(Fornecedor fornecedor)
			 {
		try{
			Connection conexao = ConnectionFactory.getConnection();
			PreparedStatement st = conexao.prepareStatement("UPDATE fornecedor SET razao_social= ?, nome_fantasia= ?, email= ?, telefone= ?, logradouro= ?, numero= ?, cep= ?, cidade= ?, bairro = ? WHERE cnpj = ?");
			st.setString(1, fornecedor.getRazao_social()); 
			st.setString(2, fornecedor.getNome_fantasia());
			st.setString(3, fornecedor.getEmail());
			st.setString(4, fornecedor.getTelefone());
			st.setString(5, fornecedor.getLogradouro());
			st.setString(6, fornecedor.getNumero());
			st.setString(7, fornecedor.getCep());
			st.setString(8, fornecedor.getCidade());
			st.setString(9, fornecedor.getBairro());
			st.setString(10, fornecedor.getCnpj());
			st.execute();
			st.close();
			conexao.close();
			return true;
		}
		catch (SQLException e){
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public Fornecedor consultarumFornecedor(Fornecedor fornecedor)
			 {
		PreparedStatement st = null;
		ResultSet rs = null;
		Fornecedor fornecedorConsulta = null;
		try{
			Connection conexao = ConnectionFactory.getConnection();
			st = conexao.prepareStatement("SELECT * FROM fornecedor WHERE nome_fantasia = ?");
			st.setString(1, fornecedor.getNome_fantasia());
			rs = st.executeQuery();
			
			while(rs.next()){
				if (rs.getString("nome_fantasia").equals(String.valueOf(fornecedor.getNome_fantasia()))){
					fornecedorConsulta = new Fornecedor();
					fornecedorConsulta.setBairro(rs.getString("bairro"));
					fornecedorConsulta.setCep(rs.getString("cep"));
					fornecedorConsulta.setCidade(rs.getString("cidade"));
					fornecedorConsulta.setCnpj(rs.getString("cnpj"));
					fornecedorConsulta.setEmail(rs.getString("email"));
					fornecedorConsulta.setLogradouro(rs.getString("logradouro"));
					fornecedorConsulta.setNome_fantasia(rs.getString("nome_fantasia"));
					fornecedorConsulta.setRazao_social(rs.getString("razao_social"));
					fornecedorConsulta.setTelefone(rs.getString("telefone"));
					fornecedorConsulta.setNumero(rs.getString("numero"));
					
				}
			}
			st.close();
			conexao.close();
		
		}
		catch (SQLException e){
			e.printStackTrace();
			return null;
		}
		return fornecedorConsulta;
	}

	@Override
	public boolean inserirFornecedor(Fornecedor fornecedor){
		try{
			System.out.println("Ta no Banco 1");
			Connection conexao = ConnectionFactory.getConnection();
			System.out.println("Ta no Banco 2");
			PreparedStatement st = conexao.prepareStatement("INSERT INTO fornecedor (cnpj, razao_social, nome_fantasia, email, telefone, logradouro, numero, cep, cidade, bairro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			System.out.println("Ta no Banco 3");
			st.setString(1, fornecedor.getCnpj());
			System.out.println("Ta no Banco 4");
			st.setString(2, fornecedor.getRazao_social());
			System.out.println("Ta no Banco 5");
			st.setString(3, fornecedor.getNome_fantasia());
			System.out.println("Ta no Banco 6");
			st.setString(4, fornecedor.getEmail());
			System.out.println("Ta no Banco 7");
			st.setString(5, fornecedor.getTelefone());
			System.out.println("Ta no Banco 8");
			st.setString(6, fornecedor.getLogradouro());
			System.out.println("Ta no Banco 9");
			st.setString(7, fornecedor.getNumero());
			System.out.println("Ta no Banco 10");
			st.setString(8, fornecedor.getCep());
			System.out.println("Ta no Banco 11");
			st.setString(9, fornecedor.getCidade());
			System.out.println("Ta no Banco 12");
			st.setString(10, fornecedor.getBairro());
			System.out.println("Ta no Banco 13");
			st.execute();
			System.out.println("Ta no Banco 14");
			st.close();
			System.out.println("Ta no Banco 15");
			conexao.close();
			return true;
		}
		catch (SQLException e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ResultSet listarFornecedor(ResultSet rs)  {
		try{
			Connection conexao = ConnectionFactory.getConnection();
			PreparedStatement st = conexao.prepareStatement("SELECT * FROM fornecedor");
			
			ResultSet rs2 = st.executeQuery();
			
			return (rs2);
		}
		catch (SQLException e){
			return null;
		}
	}

	@Override
	public void removerFornecedor(Fornecedor fornecedor) {
		try{
			Connection conexao = ConnectionFactory.getConnection();
			PreparedStatement st = conexao.prepareStatement("DELETE FROM fornecedor WHERE cnpj = ?");
			st.setString(1, fornecedor.getCnpj());
			st.execute();
			st.close();
			conexao.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		
		
	}


	@Override
	public ResultSet consultarFornecedorCnpj(String cnpj)  {
		try {
			Connection conexao = ConnectionFactory.getConnection();
			System.out.println("Antes");
			PreparedStatement st = conexao.prepareStatement("SELECT * FROM fornecedor WHERE cnpj LIKE '%"+cnpj+"%'");
			System.out.println("Depois");
			ResultSet rs = st.executeQuery();
			return (rs);
		}
		catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public ResultSet consultarFornecedorNome(String nome)  {
		try{
			Connection conexao = ConnectionFactory.getConnection();
			System.out.println("Antes 2");
			PreparedStatement st = conexao.prepareStatement("SELECT * FROM fornecedor WHERE nome_fantasia LIKE '%"+nome+"%'");
			System.out.println("Depois 2");
			ResultSet rs = st.executeQuery();
			return (rs);
		}
		catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public List<Fornecedor> listarTodosFornecedores() {
		try{
			Connection conexao = ConnectionFactory.getConnection();
			PreparedStatement st = conexao.prepareStatement("SELECT nome_fantasia FROM fornecedor ORDER BY nome_fantasia");
			
			ResultSet rs = st.executeQuery();
			
			List<Fornecedor> listar = new ArrayList<Fornecedor>();
			
			while (rs.next()){
				Fornecedor fornecedorlista = new Fornecedor();
				
				fornecedorlista.setNome_fantasia(rs.getString("nome_fantasia"));
				listar.add(fornecedorlista);
			}
			return (listar);
		}
		catch (SQLException e){
			e.printStackTrace();
			return null;
		}
		
	}
}
