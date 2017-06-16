package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import business.Medicamentos;
import business.Paciente;


public class PacienteDAO implements IPacienteDAO{
	private Connection conexao;
	private PreparedStatement stmt;
	private ResultSet tupla;
	private List<Paciente> pacientesList= new ArrayList<Paciente>();
	private static PacienteDAO instancia=null;
	
	public static PacienteDAO getInstancia(){
		if(instancia==null)
			return new PacienteDAO();
		return instancia;
	}
	
	
	public boolean CadastrarPaciente(Paciente paciente){
		this.conexao=ConnectionFactory.getConnection();
		try{
			this.conexao.createStatement();
			this.stmt=this.conexao.prepareStatement("INSERT INTO paciente (nome,cpf_paci,rg,orgao,data_emissao,sexo,data_nascimento,idade,logradouro,numero,bairro,cidade,cep,data_inclusao,nome_user,cnes) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			this.stmt.setString(1, paciente.getNome());
			this.stmt.setString(2, paciente.getCpf_paci());
			this.stmt.setString(3, paciente.getRg());
			this.stmt.setString(4, paciente.getOrgao());
			this.stmt.setString(5, paciente.getData_emissao());
			this.stmt.setString(6, paciente.getSexo());
			this.stmt.setString(7, paciente.getData_nascimento());
			this.stmt.setString(8, paciente.getIdade());
			this.stmt.setString(9, paciente.getLogradouro());
			this.stmt.setString(10, paciente.getNumero());
			this.stmt.setString(11, paciente.getBairro());
			this.stmt.setString(12, paciente.getCidade());
			this.stmt.setString(13, paciente.getCep());
			this.stmt.setString(14, paciente.getData_inclusao());
			this.stmt.setString(15, paciente.getNome_user());
			this.stmt.setString(16, paciente.getCnes());
			this.stmt.execute();
			this.stmt.close();
			this.conexao.close();
			return true;
			}
			catch(Exception e){
				System.out.println("Exceção lançada: "+e.toString());
				return false;
			}
	}
			public List<Paciente> ListarPacientes(){
				this.conexao=ConnectionFactory.getConnection();
				try{
					this.conexao.createStatement();
					this.stmt=conexao.prepareStatement("SELECT * FROM paciente");
					this.pacientesList.clear();
					this.tupla=stmt.executeQuery();
					while(this.tupla.next()){
						Paciente pac= new Paciente();
						pac.setNome(this.tupla.getString("nome"));
						pac.setCpf_paci(this.tupla.getString("cpf_paci"));
						pac.setRg(this.tupla.getString("rg"));
						pac.setOrgao(this.tupla.getString("orgao"));
						pac.setData_emissao(this.tupla.getString("data_emisao"));
						pac.setSexo(this.tupla.getString("sexo"));
						pac.setData_nascimento(this.tupla.getString("data_nascimento"));
						pac.setIdade(this.tupla.getString("idade"));
						pac.setLogradouro(this.tupla.getString("logradouro"));
						pac.setNumero(this.tupla.getString("numero"));
						pac.setBairro(this.tupla.getString("bairro"));
						pac.setCidade(this.tupla.getString("cidade"));
						pac.setCep(this.tupla.getString("cep"));
						pac.setData_inclusao(this.tupla.getString("data_inclusao"));
						pac.setNome_user(this.tupla.getString("nome_user"));
						pac.setCnes(this.tupla.getString("cnes"));
						
						
						this.pacientesList.add(pac);
					}
					this.tupla.close();
					this.stmt.close();
					if(this.pacientesList.size()>0)
						return this.pacientesList;
					return null;
				}
				catch(Exception e){
					System.out.println("Exceção lançada: "+e.toString());
					return null;
				}
	}
			public List<Paciente> PesquisarPacientesNome(String nome){
				this.conexao=ConnectionFactory.getConnection();
				try{
					this.conexao.createStatement();
					this.stmt=conexao.prepareStatement("SELECT * FROM paciente WHERE nome LIKE '"+nome+"%'");
					this.pacientesList.clear();
					this.tupla=stmt.executeQuery();
					while(this.tupla.next()){
						Paciente pac= new Paciente();
						pac.setNome(this.tupla.getString("nome"));
						pac.setCpf_paci(this.tupla.getString("cpf_paci"));
						pac.setRg(this.tupla.getString("rg"));
						pac.setOrgao(this.tupla.getString("orgao"));
						pac.setData_emissao(this.tupla.getString("data_emisao"));
						pac.setSexo(this.tupla.getString("sexo"));
						pac.setData_nascimento(this.tupla.getString("data_nascimento"));
						pac.setIdade(this.tupla.getString("idade"));
						pac.setLogradouro(this.tupla.getString("logradouro"));
						pac.setNumero(this.tupla.getString("numero"));
						pac.setBairro(this.tupla.getString("bairro"));
						pac.setCidade(this.tupla.getString("cidade"));
						pac.setCep(this.tupla.getString("cep"));
						pac.setData_inclusao(this.tupla.getString("data_inclusao"));
						pac.setNome_user(this.tupla.getString("nome_user"));
						pac.setCnes(this.tupla.getString("cnes"));
						this.pacientesList.add(pac);
					}
					this.tupla.close();
					this.stmt.close();
					this.conexao.close();
					if(this.pacientesList.size()>0)
						return this.pacientesList;
					return null;
				}
				catch(Exception e){
					System.out.println("Exceção lançada: "+e.toString());
					return null;
				}
			}
			public boolean AtualizarPaciente(Paciente pac){
				this.conexao=ConnectionFactory.getConnection();
				try{
					this.conexao.createStatement();
					this.stmt=this.conexao.prepareStatement("UPDATE usuario SET nome=?,cpf_paci=?,rg=?,orgao=?,data_emisao=?,sexo=?,data_nascimento=?,idade=?,logradouro=?,numero=?,bairro=?,cidade=?,cep=?data_inclusao=?,nome_user=?,cnes=? WHERE cpf_paci=?");
					this.stmt.setString(1, pac.getNome());
					this.stmt.setString(2, pac.getCpf_paci());
					this.stmt.setString(3, pac.getRg());
					this.stmt.setString(4, pac.getOrgao());
					this.stmt.setString(5, pac.getData_emissao());
					this.stmt.setString(6, pac.getSexo());
					this.stmt.setString(7, pac.getData_nascimento());
					this.stmt.setString(8, pac.getIdade());
					this.stmt.setString(9, pac.getLogradouro());
					this.stmt.setString(10, pac.getNumero());
					this.stmt.setString(11, pac.getBairro());
					this.stmt.setString(12, pac.getCidade());
					this.stmt.setString(13, pac.getCep());
					this.stmt.setString(14, pac.getData_inclusao());
					this.stmt.setString(15, pac.getNome_user());
					this.stmt.setString(16, pac.getCnes());
					this.stmt.execute();
					this.stmt.close();
					this.conexao.close();
					return true;
				}
				catch(Exception e){
					System.out.println("Exceção lançada: "+e.toString());
					return false;
				}
				
			}
			
public boolean ExcluirPaciente(Paciente pac){
				this.conexao=ConnectionFactory.getConnection();
				try{
					this.conexao.createStatement();
					this.stmt=conexao.prepareStatement("DELETE FROM paciente WHERE cpf_paciente=?");
					this.stmt.setString(1, pac.getCpf_paci());
					this.stmt.execute();
					this.stmt.close();
					this.conexao.close();
					return true;
				}
				catch(Exception e){
					System.out.println("Exceção lançada: "+e.toString());
					return false;
				}
				
			}


@Override
public boolean PesquisarPacientesNome(Paciente pac) {
	this.conexao = ConnectionFactory.getConnection();
	try {
		this.stmt = conexao.prepareStatement("SELECT * FROM paciente WHERE nome = ?");
		this.stmt.setString(1, pac.getNome());
		this.tupla = this.stmt.executeQuery();
		
		while (tupla.next()){
						
			Paciente paciente = new Paciente();
			
			paciente.setNome(this.tupla.getString("nome"));
			paciente.setCpf_paci(this.tupla.getString("cpf_paci"));
			paciente.setRg(this.tupla.getString("rg"));
			paciente.setOrgao(this.tupla.getString("orgao"));
			paciente.setData_emissao(this.tupla.getString("data_emisao"));
			paciente.setSexo(this.tupla.getString("sexo"));
			paciente.setData_nascimento(this.tupla.getString("data_nascimento"));
			paciente.setIdade(this.tupla.getString("idade"));
			paciente.setLogradouro(this.tupla.getString("logradouro"));
			paciente.setNumero(this.tupla.getString("numero"));
			paciente.setBairro(this.tupla.getString("bairro"));
			paciente.setCidade(this.tupla.getString("cidade"));
			paciente.setCep(this.tupla.getString("cep"));
			paciente.setData_inclusao(this.tupla.getString("data_inclusao"));
			paciente.setNome_user(this.tupla.getString("nome_user"));
			paciente.setCnes(this.tupla.getString("cnes"));
			}
		stmt.close();
		conexao.close();
		return true;
	}
	catch (Exception e){
		e.printStackTrace();
		return false;
	}
 }
	public Paciente PesquisaPaciente(Paciente paciente){
		this.conexao = ConnectionFactory.getConnection();
		Paciente PacienteConsult = null;
		try {
			ResultSet rs = null;
			this.stmt = conexao.prepareStatement("SELECT nome FROM paciente WHERE cpf_paci = ?");
			this.stmt.setString(1, paciente.getCpf_paci());		
			rs = stmt.executeQuery();
			
			while(rs.next()){
				if (rs.getString("cpf_paci")==(paciente.getCpf_paci())){
					PacienteConsult = new Paciente();
					PacienteConsult.setNome(rs.getString("nome"));
					paciente.setNome(PacienteConsult.getNome());
					
				}
			}
			stmt.close();
			conexao.close();
			return paciente;
			
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
   }
}