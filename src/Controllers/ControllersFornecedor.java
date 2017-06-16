package Controllers;

import java.sql.ResultSet;
import java.util.List;

import DAO.FornecedorDAO;
import DAO.IFornecedorDAO;
import business.Fornecedor;

public class ControllersFornecedor implements IControllersFornecedor {

	
	
	@Override
	public boolean atualizarFornecedor(Fornecedor fornecedor)
			{
		IFornecedorDAO DAOFornecedor = new FornecedorDAO();
		try{
			DAOFornecedor.atualizarFornecedor(fornecedor);
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ResultSet consultarFornecedorCnpj(String cnpj){
		IFornecedorDAO DAOFornecedor = new FornecedorDAO();
		try{
			return DAOFornecedor.consultarFornecedorCnpj(cnpj);
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ResultSet consultarFornecedorNome(String nome) {
		IFornecedorDAO DAOFornecedor = new FornecedorDAO();
		try {
			return DAOFornecedor.consultarFornecedorNome(nome);
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Fornecedor consultarumFornecedor(Fornecedor fornecedor)
			 {
		IFornecedorDAO DAOFornecedor = new FornecedorDAO();
		try{
			return DAOFornecedor.consultarumFornecedor(fornecedor);
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean inserirFornecedor(Fornecedor fornecedor) {
		IFornecedorDAO DAOFornecedor = new FornecedorDAO();
		try {
			DAOFornecedor.inserirFornecedor(fornecedor);
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ResultSet listarFornecedor(ResultSet rs) {
		IFornecedorDAO DAOFornecedor = new FornecedorDAO();
		try{
			return DAOFornecedor.listarFornecedor(rs);
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void removerFornecedor(Fornecedor fornecedor) {
		IFornecedorDAO DAOFornecedor = new FornecedorDAO();
		try{
			DAOFornecedor.removerFornecedor(fornecedor);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<Fornecedor> listarTodosFornecedores() {
		IFornecedorDAO DAOFornecedor = new FornecedorDAO();
		try{
			return DAOFornecedor.listarTodosFornecedores();
			
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
}