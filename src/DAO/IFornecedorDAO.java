package DAO;

import java.sql.ResultSet;
import java.util.List;

import business.Fornecedor;

public interface IFornecedorDAO {
	public boolean atualizarFornecedor(Fornecedor fornecedor) ;
	public boolean inserirFornecedor(Fornecedor fornecedor)  ;
	public void removerFornecedor(Fornecedor fornecedor)  ;
	public ResultSet consultarFornecedorNome(String nome)  ;
	public ResultSet consultarFornecedorCnpj(String cnpj)  ;
	public Fornecedor consultarumFornecedor(Fornecedor fornecedor)  ;
	public ResultSet listarFornecedor(ResultSet rs);
	public List<Fornecedor> listarTodosFornecedores ();
	
}
