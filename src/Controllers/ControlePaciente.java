package Controllers;

import java.util.List;

import DAO.IPacienteDAO;
import DAO.PacienteDAO;
import business.Paciente;

public class ControlePaciente implements IControlePaciente{
	
	//private static  ControlePaciente PacienteDAO = null;
	private static ControlePaciente instancia=null;
	
	public static ControlePaciente getInstancia(){
		if (instancia==null)
			return new ControlePaciente();
		return instancia;
	}

	@Override
	public boolean AtualizarPaciente(Paciente pac) {
		IPacienteDAO dados = PacienteDAO.getInstancia();
		try{
			dados.AtualizarPaciente(pac);
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean CadastrarPaciente(Paciente paciente) {
		IPacienteDAO dados = PacienteDAO.getInstancia();
		try{
			dados.CadastrarPaciente(paciente);
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean ExcluirPaciente(Paciente pac) {
		IPacienteDAO dados = PacienteDAO.getInstancia();
		try{
			dados.ExcluirPaciente(pac);
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Paciente> ListarPacientes() {
		IPacienteDAO dados = PacienteDAO.getInstancia();
		try{
			return dados.ListarPacientes();
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean PesquisarPacientesNome(Paciente pac) {
		IPacienteDAO dados = PacienteDAO.getInstancia();
		try {
			dados.PesquisarPacientesNome(pac);
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public Paciente PacientePesquisar(Paciente paciente){
		IPacienteDAO dados = PacienteDAO.getInstancia();
	
			return dados.PesquisaPaciente(paciente);
		
	}

}
