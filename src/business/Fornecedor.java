package business;

public class Fornecedor {
	private String cnpj;
	private String razao_social;
	private String nome_fantasia;
	private String email;
	private String telefone;
	private String logradouro;
	private String numero;
	private String cep;
	private String cidade;
	private String bairro;
	
	public Fornecedor(String cnpj,String razao_social,String nome_fantasia,String email,String telefone,String logradouro,String numero,String cep,String cidade,String bairro) {
		super();
		setBairro(bairro);
		setCep(cep);
		setCidade(cidade);
		setCnpj(cnpj);
		setEmail(email);
		setLogradouro(logradouro);
		setNome_fantasia(nome_fantasia);
		setNumero(numero);
		setRazao_social(razao_social);
		setTelefone(telefone);
	}
	
	public Fornecedor(){
		super();
	}
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazao_social() {
		return razao_social;
	}
	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}
	public String getNome_fantasia() {
		return nome_fantasia;
	}
	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
}
