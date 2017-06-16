package business;

public class Medicamentos {
	private int cod_medic;
	private String nome;
	private int quantidade;
	private String grupo;
	private String tipo_solucao;
	
	
	public Medicamentos(String nome, int quantidade, String grupo, String tipo_solucao){
		System.out.println("medicamentos 1");
		setNome(nome);
		setQuant(quantidade);
		setGrupo(grupo);
		setSolucao(tipo_solucao);

	}
	public Medicamentos (String nome,int quantidade,String grupo,String tipo_solucao, String cod_medic){
		System.out.println("medicamentos 2");
		setNome(nome);
		setQuant(quantidade);
		setGrupo(grupo);
		setSolucao(tipo_solucao);
		setCod(cod_medic);
	
		
	}


	public Medicamentos() {

	}


	public int getCodigo() {
		return cod_medic;
	}


	public void setCodigo(int cod_medic) {
		this.cod_medic = cod_medic;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getQuant() {
		return quantidade;
	}


	public void setQuant(int quantidade) {
		this.quantidade = quantidade;
	}


	public String getGrupo() {
		return grupo;
	}


	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}


	public String getSolucao() {
		return tipo_solucao;
	}


	public void setSolucao(String tipo_solucao) {
		this.tipo_solucao = tipo_solucao;
	}
	public int intQuant (String Quant){
		int quanti = Integer.parseInt(Quant);
		this.quantidade = quanti;
		return quantidade;
	}
	public int setCod(String cod){
		int codi = Integer.parseInt(cod);
		this.cod_medic = codi;
		return cod_medic;
	}
		
}
