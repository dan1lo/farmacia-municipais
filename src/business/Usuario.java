package business;

public class Usuario {
	private String nome;
	private String login;
	private String senha;
	private String cpf;
	private String cargo;
	
	public Usuario(){
		
	}
	public Usuario(String nome,String login,String senha,String cargo,String cpf){
		this.cargo=cargo;
		this.cpf=cpf;
		this.login=login;
		this.nome=nome;
		this.senha=senha;
	}
	public boolean validarAlteracaoSenha(Usuario user){
		if(this.cpf.equals(user.getCpf()) && this.senha.equals(user.getSenha()))
			return true;
		return false;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	

}
