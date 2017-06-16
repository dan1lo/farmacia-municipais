package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import business.Medicamentos;
public class MedicamentosDAO implements IMedicamentosDAO {
	
	private static MedicamentosDAO instancia=null;
	public static MedicamentosDAO getInstancia(){
		if(instancia==null)
			return new MedicamentosDAO();
		return instancia;
		}
	
	@Override
	public boolean criarMedicamentos(Medicamentos medicamento) {
		
		try{
			Connection connection = ConnectionFactory.getConnection();
			connection.createStatement();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO medicamento (nome, quantidade,grupo,tipo_solucao) VALUES (?,?,?,?)");
			stmt.setString(1, medicamento.getNome());
			stmt.setInt(2, medicamento.getQuant());
			stmt.setString(3, medicamento.getGrupo());
			stmt.setString(4, medicamento.getSolucao());

			stmt.execute();
			stmt.close();
			connection.close();
			return true;
			
		}catch(Exception e){
			System.out.println(e);
			return false;
		 
		}
	}	
		public ResultSet listarMedicamentos(ResultSet rs)throws SQLException{
			try {
				Connection conexao = ConnectionFactory.getConnection();
				PreparedStatement st = conexao.prepareStatement("SELECT * FROM medicamento");
				
				ResultSet rs2 = st.executeQuery();
				
				return (rs2);
			}
			catch (SQLException e){
				return null;
			}
		}

		@Override
		public ResultSet consultarMedicamentos(String nome) throws SQLException {
			try {
				Connection conexao = ConnectionFactory.getConnection();
				PreparedStatement st = conexao.prepareStatement("SELECT * FROM medicamento WHERE nome LIKE '%"+nome+"%'");
				ResultSet rs = st.executeQuery();
				return (rs);
			}
			catch (SQLException e){
				e.printStackTrace();
				return null;
			}
		}
		public boolean excluirMedicamentos(Medicamentos medicamento){
			Connection conexao;
			try {
				conexao = ConnectionFactory.getConnection();
				
				conexao.createStatement();
				PreparedStatement stmt=conexao.prepareStatement("DELETE FROM medicamento WHERE cod_medic=?");
				stmt.setInt(1,medicamento.getCodigo());
				stmt.execute();
				stmt.close();
				conexao.close();
				return true;
				
			} catch (SQLException e1) {
				
				System.out.println("Exceção lançada: "+e1.toString());
				return false;
			}
	
			
		   }
		
		public boolean atualizarMedicamentos(Medicamentos medicamento){
			
			try{

				Connection conexao = ConnectionFactory.getConnection();
				PreparedStatement  stmt = conexao.prepareStatement("UPDATE medicamento SET  nome=?, quantidade=?,grupo=?,tipo_solucao=? WHERE cod_medic=?");
				stmt.setString(1,medicamento.getNome());
				stmt.setInt(2, medicamento.getQuant());
				stmt.setString(3, medicamento.getGrupo());
				stmt.setString(4, medicamento.getSolucao());
				stmt.setInt(5, medicamento.getCodigo());
				stmt.execute();
				stmt.close();
				conexao.close();
				return true;
			}catch(Exception e){
				System.out.println("Ocorreu um erro");
				return false;
			}
			
			}
		public Medicamentos consultarUmMedicamento(Medicamentos medicamento){
			Medicamentos medicameConsult = null ;
			try{
				PreparedStatement st=null;
				ResultSet rs = null;
				System.out.println(medicamento.getCodigo());
				Connection conexao = ConnectionFactory.getConnection();
				st = conexao.prepareStatement("SELECT * FROM medicamento WHERE cod_medic= ?");
				st.setInt(1, medicamento.getCodigo());
				rs = st.executeQuery();
				
				while(rs.next()){
					if (rs.getInt("cod_medic")==(medicamento.getCodigo())){
						medicameConsult = new Medicamentos();
						medicameConsult.setNome(rs.getString("nome"));
						medicameConsult.setGrupo(rs.getString("Grupo"));
						medicameConsult.setSolucao(rs.getString("tipo_solucao"));
						medicameConsult.setQuant(rs.getInt("quantidade"));
						medicamento.setNome(medicameConsult.getNome());
					}
				}
				
				st.close();
				conexao.close();
				return medicameConsult;
			}
			catch (Exception e){
				e.printStackTrace();
				return null;
			}
			
		}
		
		}
		
		
		
	

	








