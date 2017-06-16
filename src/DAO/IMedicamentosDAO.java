package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import business.Medicamentos;


public interface IMedicamentosDAO {
	public boolean criarMedicamentos(Medicamentos medicamento);
	public ResultSet listarMedicamentos(ResultSet rs)throws SQLException;
	public ResultSet consultarMedicamentos(String nome) throws SQLException;
	public boolean excluirMedicamentos(Medicamentos medicamento);
	public boolean atualizarMedicamentos(Medicamentos medicamento);
	public Medicamentos consultarUmMedicamento(Medicamentos medicamento);
}
