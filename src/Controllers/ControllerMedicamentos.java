package Controllers;

import java.sql.ResultSet;
import java.sql.SQLException;


import business.Medicamentos;
import DAO.IMedicamentosDAO;
import DAO.MedicamentosDAO;

public class ControllerMedicamentos implements IControllerMedicamentos {
	
	private static ControllerMedicamentos instancia = null;
	
	public static ControllerMedicamentos getInstancia(){
		if(instancia == null)
			return new ControllerMedicamentos();
		return instancia;
	}
		public boolean criarMedicamentos(Medicamentos medicamento)  {
			IMedicamentosDAO dados = new MedicamentosDAO();
	
				dados.criarMedicamentos(medicamento);
			
			return true;
		}
		public ResultSet listarMedicamentos(ResultSet rs)throws SQLException{
			IMedicamentosDAO dados = new MedicamentosDAO();
			try{
				return dados.listarMedicamentos(rs);
			}catch(SQLException e){
				throw new SQLException("Erro ao listar");
			}
			}
		public ResultSet consultarMedicamentos(String nome)throws SQLException{
			IMedicamentosDAO dados = new MedicamentosDAO();
			try{
				return dados.consultarMedicamentos(nome);
			}
			catch (SQLException e){
				throw new SQLException("Erro na Consulta");
			}
			
			
		}
		public boolean excluirMedicamentos(Medicamentos medicamento){
			IMedicamentosDAO dados =new MedicamentosDAO();
			return dados.excluirMedicamentos(medicamento);
		}
		public boolean atualizarMedicamentos(Medicamentos medicamento){
			IMedicamentosDAO dados = new MedicamentosDAO();
			return dados.atualizarMedicamentos(medicamento);
		}
		public Medicamentos consultarUmMedicamento(Medicamentos medicamento){
			IMedicamentosDAO dados = new MedicamentosDAO();
			return dados.consultarUmMedicamento(medicamento);
		}
}	
		
		

		
	
