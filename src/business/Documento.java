package business;

public class Documento {
	private String numero_nota;
	private double valor_total;
	private String data_emissao;
	private String tipo;
	private String cnpj;
	
	public Documento (){
		super();
	}
	
	public Documento (String numero_nota,double valor_total,String data_emissao, String tipo, String cnpj){
		super();
		setNumero_nota(numero_nota);
		setValor_total(valor_total);
		setData_emissao(data_emissao);
		setTipo(tipo);
		setCnpj(cnpj);
		
	}
	
	public String getNumero_nota() {
		return numero_nota;
	}
	public void setNumero_nota(String numero_nota) {
		this.numero_nota = numero_nota;
	}
	public double getValor_total() {
		return valor_total;
	}
	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}
	public String getData_emissao() {
		return data_emissao;
	}
	public void setData_emissao(String data_emissao) {
		this.data_emissao = data_emissao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
