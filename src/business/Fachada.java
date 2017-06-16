package business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Controllers.ControlePaciente;
import Controllers.ControllerMedicamentos;
import Controllers.ControllerUnidades;
import Controllers.ControllerUsuario;
import Controllers.ControllersFornecedor;
import Controllers.ControllersPrograma;
import Controllers.IControlePaciente;
import Controllers.IControllerMedicamentos;
import Controllers.IControllerUnidades;
import Controllers.IControllerUsuario;
import Controllers.IControllersFornecedor;
import Controllers.IControllersPrograma;

public class Fachada {
	private static Fachada instancia=null;
	
	private Fachada(){
		
	}
	public static Fachada getInstancia(){
		if(instancia==null)
			instancia = new Fachada();
		return instancia;
		
	}
	//---------UNIDADES----------
	public boolean inserirUnidade(Unidades unidade){
		IControllerUnidades unidadeController=  new ControllerUnidades();
		return unidadeController.inserirUnidade(unidade);
	}
	public List<Unidades> pegartodasUnidades(){
		IControllerUnidades unidadeController=  new ControllerUnidades();
		return unidadeController.pegarAllUnidades();
	}
	public List<Unidades> pegarUnidadesResponsavel(String responsavel){
		IControllerUnidades unidadeController=  new ControllerUnidades();
		return unidadeController.pegarUnidadesResponsavel(responsavel);
	}
	public List<Unidades> pegarUnidadesTipo(String tipo){
		IControllerUnidades unidadeController=  new ControllerUnidades();
		return unidadeController.pegarUnidadesTipo(tipo);
	}
	public Unidades pegarUnidade(Unidades unidade){
		IControllerUnidades unidadeController=  new ControllerUnidades();
		return unidadeController.pegarUnidade(unidade);
	}
	public boolean atualizarUnidade(Unidades unidade){
		IControllerUnidades unidadeController=  new ControllerUnidades();
		return unidadeController.atualizarUnidade(unidade);
	}
	public boolean excluirUnidade(Unidades unidade){
		IControllerUnidades unidadeController=  new ControllerUnidades();
		return unidadeController.excluirUnidade(unidade);
	}
	public boolean excluirTodasUnidades(){
		IControllerUnidades unidadeController=  new ControllerUnidades();
		return unidadeController.excluirAllUnidades();
	}
	public String validarUnidade(Unidades unidade){
		IControllerUnidades unidadeController=  new ControllerUnidades();
		return unidadeController.validarUnidade(unidade);
	}
	//------USUARIOS
	public boolean inserirUsuario(Usuario user){
		IControllerUsuario usuarioController= new ControllerUsuario();
		return usuarioController.inserirUsuario(user);
	}
	public List<Usuario> pegarTodosUsuarios(){
		IControllerUsuario usuarioController= new ControllerUsuario();
		return usuarioController.pegarAllUsuarios();
	}
	public List<Usuario> pegarUsuariosNome(String nome){
		IControllerUsuario usuarioController= new ControllerUsuario();
		return usuarioController.pegarUsuariosNome(nome);
	}
	public List<Usuario> pegarUsuariosCargo(String cargo){
		IControllerUsuario usuarioController= new ControllerUsuario();
		return usuarioController.pegarUsuariosCargo(cargo);
	}
	public Usuario pegarUsuario(Usuario user){
		IControllerUsuario usuarioController= new ControllerUsuario();
		return usuarioController.pegarUsuario(user);
	}
	public Usuario pegarUsuarioLogin(Usuario user){
		IControllerUsuario usuarioController= new ControllerUsuario();
		return usuarioController.pegarUsuarioLogin(user);
	}
	public Usuario pegarEValidarUsuario(Usuario user){
		IControllerUsuario usuarioController= new ControllerUsuario();
		return usuarioController.pegarEValidarUsuario(user);
	}
	public boolean atualizarUsuario(Usuario user){
		IControllerUsuario usuarioController= new ControllerUsuario();
		return usuarioController.atualizarUsuario(user);
	}
	public boolean excluirUsuario(Usuario user){
		IControllerUsuario usuarioController= new ControllerUsuario();
		return usuarioController.excluirUsuario(user);
	}
	public boolean excluirTodosUsuarios(){
		IControllerUsuario usuarioController= new ControllerUsuario();
		return usuarioController.excluirAllUsuarios();
	}
	public String validarUsuario(Usuario user,String confirmaSenha){
		IControllerUsuario usuarioController= new ControllerUsuario();
		return usuarioController.validarUsuario(user, confirmaSenha);
	}
	//---- Programas
	
	public boolean inserirPrograma(Programa programa) {
		IControllersPrograma contPrograma = new ControllersPrograma();
		//IControllersPrograma contPrograma = null;
		System.out.println("Controllers");
		return contPrograma.inserirPrograma(programa);
	}
	
	public boolean atualizarPrograma(Programa programa) {
		IControllersPrograma contPrograma = new ControllersPrograma();
		//IControllersPrograma contPrograma = null;
		return contPrograma.atualizarPrograma(programa);
	}
		
	public void removerPrograma(Programa programa) {
		IControllersPrograma contPrograma = new ControllersPrograma();
		//IControllersPrograma contPrograma = null;
		contPrograma.removerPrograma(programa);
	}
	
	public ResultSet consultarPrograma(String nome) {
		IControllersPrograma contPrograma = new ControllersPrograma();
		//IControllersPrograma contPrograma = null;
		return contPrograma.consultarPrograma(nome);
	}
	
	public Programa consultarUmPrograma(Programa programa) {
		IControllersPrograma contPrograma = new ControllersPrograma();
		//IControllersPrograma contPrograma = null;
		return contPrograma.consultarUmPrograma(programa);
	}
	
	public ResultSet listarPrograma(ResultSet rs) {
		IControllersPrograma contPrograma = new ControllersPrograma();
		//IControllersPrograma contPrograma = null;
		return contPrograma.listarPrograma(rs);
	}
	
	public List<Programa> listarTodosPrograma() {
		IControllersPrograma contPrograma = new ControllersPrograma();
		//IControllersPrograma contPrograma = null;
		return contPrograma.listarTodosPrograma();
	}
	
	// ------ Fornecedores
		
		public boolean atualizarFornecedor(Fornecedor fornecedor) {
			IControllersFornecedor contFornecedor = new ControllersFornecedor();
			return contFornecedor.atualizarFornecedor(fornecedor);
			}
		
		public boolean inserirFornecedor(Fornecedor fornecedor) {
			IControllersFornecedor contFornecedor = new ControllersFornecedor();
			return contFornecedor.inserirFornecedor(fornecedor);
		}
		
		public void removerFornecedor(Fornecedor fornecedor) {
			IControllersFornecedor contFornecedor = new ControllersFornecedor();
			contFornecedor.removerFornecedor(fornecedor);
		}
		
		public ResultSet consultarFornecedorNome(String nome) {
			IControllersFornecedor contFornecedor = new ControllersFornecedor();
			return contFornecedor.consultarFornecedorNome(nome);
		}
		
		public ResultSet consultarFornecedorCnpj(String cnpj){
			IControllersFornecedor contFornecedor = new ControllersFornecedor();
			return contFornecedor.consultarFornecedorCnpj(cnpj);
		}
		
		public Fornecedor consultarumFornecedor(Fornecedor fornecedor){
			IControllersFornecedor contFornecedor = new ControllersFornecedor();
			return contFornecedor.consultarumFornecedor(fornecedor);
		}
		
		public ResultSet listarFornecedor(ResultSet rs) {
			IControllersFornecedor contFornecedor = new ControllersFornecedor();
			return contFornecedor.listarFornecedor(rs);
		}
		
		public List<Fornecedor> listarTodosFornecedores (){
			IControllersFornecedor contFornecedor = new ControllersFornecedor();
			return contFornecedor.listarTodosFornecedores();
		}
		//medicamentos

		public boolean criarMedicamentos(Medicamentos medicamento) {
			
			IControllerMedicamentos dados = new ControllerMedicamentos();
			return dados.criarMedicamentos(medicamento);
			
		}
		public ResultSet consultarMedicamentos(String nome) throws SQLException{
			IControllerMedicamentos dados = new ControllerMedicamentos();
			return dados.consultarMedicamentos(nome);
		}
		public ResultSet listarMedicamentos(ResultSet rs)throws SQLException{
			IControllerMedicamentos dados = new ControllerMedicamentos();
			return dados.listarMedicamentos(rs);
		}
		public boolean excluirMedicamentos(Medicamentos medicamento){
			IControllerMedicamentos dados = new ControllerMedicamentos();
			return dados.excluirMedicamentos(medicamento);
		}
		public boolean atualizarMedicamentos(Medicamentos medicamento){
			
			IControllerMedicamentos dados = new ControllerMedicamentos();
			return dados.atualizarMedicamentos(medicamento);
			
		}
		public Medicamentos consultarMedic(Medicamentos medicamento){
			IControllerMedicamentos dados = new ControllerMedicamentos();
			return dados.consultarUmMedicamento(medicamento);
		}
		public Medicamentos consultarUmMedicamento(Medicamentos medicamento){
			IControllerMedicamentos dados = new ControllerMedicamentos();
			return dados.consultarUmMedicamento(medicamento);
		}
		
		//Paciente

		public boolean CadastrarPaciente(String nome, String cpf_paci, String rg, String orgao, String data_emisao, String sexo, String data_nascimento, String idade, String logradouro, String numero, String bairro, String cidade, String cep, String data_inclusao, String nome_user, String cnes){
			Paciente paciente = new Paciente(nome, cpf_paci, rg, orgao, data_emisao, sexo, data_nascimento, idade, logradouro, numero, bairro, cidade, cep, data_inclusao, nome_user, cnes);
			IControlePaciente dados = ControlePaciente.getInstancia();
			if(dados.CadastrarPaciente(paciente))
				return true;
			return false;
			}
		
		public List<Paciente> ListarPacientes(){
			IControlePaciente dados=ControlePaciente.getInstancia();
			return dados.ListarPacientes();
		}
		
		public boolean PesquisarPacientesNome(String nome, String cpf_paci, String rg, String orgao, String data_emisao, String sexo, String data_nascimento, String idade, String logradouro, String numero, String bairro, String cidade, String cep, String data_inclusao, String nome_user, String cnes){
			Paciente paciente = new Paciente(nome, cpf_paci, rg, orgao, data_emisao, sexo, data_nascimento, idade, logradouro, numero, bairro, cidade, cep, data_inclusao, nome_user, cnes);
			IControlePaciente dados = ControlePaciente.getInstancia();
			if(dados.CadastrarPaciente(paciente))
				return true;
			return false;
			}
		
		public boolean AtualizarPaciente(String nome, String cpf_paci, String rg, String orgao, String data_emisao, String sexo, String data_nascimento, String idade, String logradouro, String numero, String bairro, String cidade, String cep, String data_inclusao, String nome_user, String cnes){
			Paciente paciente = new Paciente(nome, cpf_paci, rg, orgao, data_emisao, sexo, data_nascimento, idade, logradouro, numero, bairro, cidade, cep, data_inclusao, nome_user, cnes);
			IControlePaciente dados = ControlePaciente.getInstancia();
			if(dados.CadastrarPaciente(paciente))
				return true;
			return false;
			}
		
		public boolean ExcluirPaciente(String nome, String cpf_paci, String rg, String orgao, String data_emisao, String sexo, String data_nascimento, String idade, String logradouro, String numero, String bairro, String cidade, String cep, String data_inclusao, String nome_user, String cnes){
			Paciente paciente = new Paciente(nome, cpf_paci, rg, orgao, data_emisao, sexo, data_nascimento, idade, logradouro, numero, bairro, cidade, cep, data_inclusao, nome_user, cnes);
			IControlePaciente dados = ControlePaciente.getInstancia();
			if(dados.ExcluirPaciente(paciente))
				return true;
			return false;
			}

		public Paciente PesquisarPaciente(Paciente paciente){
			IControlePaciente dados = new ControlePaciente();
			return dados.PacientePesquisar(paciente);
			
		}
}

