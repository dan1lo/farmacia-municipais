package DAO;

import java.util.List;
import business.Paciente;

public interface IPacienteDAO {
	public boolean CadastrarPaciente (Paciente paciente);
	public List<Paciente> ListarPacientes();
	public boolean PesquisarPacientesNome (Paciente pac);
	public boolean AtualizarPaciente (Paciente pac);
	public boolean ExcluirPaciente (Paciente pac);
	public Paciente PesquisaPaciente(Paciente paciente);

}
