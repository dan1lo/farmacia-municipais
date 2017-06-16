package business;

public class Paciente {
	private String cpf_paci;
	private String rg;
	private String idade;
	private String data_emissao;
	private String data_nascimento;
	private String cep;
	private String data_inclusao;
	private String numero;
	private String orgao,sexo,nome,logradouro,cidade,bairro,nome_user,cnes;
	public String getCpf_paci() {
		return cpf_paci;
	}
	public void setCpf_paci(String cpf_paci) {
		this.cpf_paci = cpf_paci;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public String getData_emissao() {
		return data_emissao;
	}
	public void setData_emissao(String data_emissao) {
		this.data_emissao = data_emissao;
	}
	public String getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
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
	public String getData_inclusao() {
		return data_inclusao;
	}
	public void setData_inclusao(String data_inclusao) {
		this.data_inclusao = data_inclusao;
	}
	public String getOrgao() {
		return orgao;
	}
	public void setOrgao(String orgao) {
		this.orgao = orgao;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
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
	public String getNome_user() {
		return nome_user;
	}
	public void setNome_user(String nome_user) {
		this.nome_user = nome_user;
	}
	public String getCnes() {
		return cnes;
	}
	public void setCnes(String cnes) {
		this.cnes = cnes;
	}
	
	public Paciente(){
		super();
	}
	public Paciente(String nome, String cpf_paci, String rg, String orgao, String data_emisao, String sexo, String data_nascimento, String idade, String logradouro, String numero, String bairro, String cidade, String cep, String data_inclusao, String nome_user, String cnes){
		super();
		setNome(nome);
		setCpf_paci(cpf_paci);
		setRg(rg);
		setOrgao(orgao);
		setData_emissao(data_emisao);
		setSexo(sexo);
		setData_nascimento(data_nascimento);
		setIdade(idade);
		setLogradouro(logradouro);
		setNumero(numero);
		setBairro(bairro);
		setCidade(cidade);
		setCep(cep);
		setData_inclusao(data_inclusao);
		setNome_user(nome_user);
		setCnes(cnes);
	}

}
