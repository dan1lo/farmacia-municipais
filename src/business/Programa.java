package business;

public class Programa {
	private int cod_prog;
	private String nome;
	private String text;
	
	public Programa(int cod_prog, String nome, String text){
		super();
		this.cod_prog = cod_prog;
		this.nome = nome;
		this.text = text;
	}
	
	public Programa() {
		super();
	}
	
	public int getCod_prog() {
		return cod_prog;
	}
	public void setCod_prog(int cod_prog) {
		this.cod_prog = cod_prog;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}
