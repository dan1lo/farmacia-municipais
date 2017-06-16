package Controllers;

import java.util.List;
import business.Paciente;

public interface IControlePaciente {
	public boolean CadastrarPaciente (Paciente paciente);
	public List<Paciente> ListarPacientes();
	public boolean PesquisarPacientesNome (Paciente pac);
	public boolean AtualizarPaciente (Paciente pac);
	public boolean ExcluirPaciente (Paciente pac);
	public Paciente PacientePesquisar(Paciente paciente);

}
