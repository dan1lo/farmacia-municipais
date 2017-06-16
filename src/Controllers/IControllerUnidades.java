package Controllers;
import java.util.List;

import business.Unidades;

public interface IControllerUnidades {
	public List<Unidades> pegarAllUnidades();
	public List<Unidades> pegarUnidadesResponsavel(String responsavel);
	public List<Unidades> pegarUnidadesTipo(String tipo);
	public Unidades pegarUnidade(Unidades unidade);
	public boolean inserirUnidade(Unidades unidade);
	public boolean excluirUnidade(Unidades unidade);
	public boolean atualizarUnidade(Unidades unidade);
	public boolean excluirAllUnidades();
	public String validarUnidade(Unidades unidade);

}
