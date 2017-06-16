package DAO;

import java.sql.ResultSet;
import java.util.List;

import business.Documento;

public interface IDocumentoDAO {
	
	public boolean inserirDocumento(Documento documento);
	public boolean atualizarDocumento(Documento documento);
	public void removerDocumento(Documento documento);
	public ResultSet consultarDocumento(String numero_nota);
	public ResultSet listarDocumento(ResultSet rs);
	public List<Documento> listarTodosDocumentos();
}
