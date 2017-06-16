package DAO;

import java.util.List;

import business.Unidades;

public interface IUnidadesDAO {
	public boolean inserirUnidade(Unidades unidade);
	public List<Unidades> pegarTodasUnidades();
	public List<Unidades> pegarUnidadesResponsavel(String responsavel);
	public List<Unidades> pegarUnidadesTipo(String tipo);
	public Unidades pegarUnidade(Unidades unida);
	public boolean atualizarUnidade(Unidades unidade);
	public boolean excluirTodasUnidades();
	public boolean excluirUnidade(Unidades unidade);

}
