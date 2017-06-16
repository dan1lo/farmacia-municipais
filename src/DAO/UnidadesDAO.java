package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import business.Unidades;

public class UnidadesDAO implements IUnidadesDAO{
	List<Unidades> unidadesList= new ArrayList<Unidades>();
	Connection conexao;
	PreparedStatement stmt;
	ResultSet tupla;
	
	public boolean inserirUnidade(Unidades unidade){
		this.conexao=ConnectionFactory.getConnection();
		try{
			this.conexao.createStatement();
			this.stmt=this.conexao.prepareStatement("INSERT INTO unidade (bairro,cep,cidade,complemento,logradouro,telefone,responsavel,tipo,cnes) VALUES(?,?,?,?,?,?,?,?,?)");
			this.stmt.setString(1,unidade.getBairro());
			this.stmt.setString(2, unidade.getCep());
			this.stmt.setString(3, unidade.getCidade());
			this.stmt.setString(4, unidade.getComplemento());
			this.stmt.setString(5, unidade.getLogradouro());
			this.stmt.setString(6, unidade.getFone());
			this.stmt.setString(7, unidade.getNomeResponsavel());
			this.stmt.setString(8, unidade.getTipoUnidade());
			this.stmt.setString(9, unidade.getCnes());
			this.stmt.execute();
			this.stmt.close();
			this.conexao.close();
			return true;
		}
		catch(Exception e){
			System.out.println("Exceção lançada: "+e.toString());
			return false;
		}
		
	}
	public List<Unidades> pegarTodasUnidades(){
		this.conexao=ConnectionFactory.getConnection();
		Unidades unidade;
		try{
			this.conexao.createStatement();
			this.stmt=this.conexao.prepareStatement("SELECT * FROM unidade");
			this.tupla=this.stmt.executeQuery();
			this.unidadesList.clear();
			while(tupla.next()){
				unidade= new Unidades();
				unidade.setBairro(tupla.getString("bairro"));
				unidade.setCep(tupla.getString("cep"));
				unidade.setCidade(tupla.getString("cidade"));
				unidade.setCnes(tupla.getString("cnes"));
				unidade.setComplemento(tupla.getString("complemento"));
				unidade.setFone(tupla.getString("telefone"));
				unidade.setLogradouro(tupla.getString("logradouro"));
				unidade.setNomeResponsavel(tupla.getString("responsavel"));
				unidade.setTipoUnidade(tupla.getString("tipo"));
				this.unidadesList.add(unidade);
				
			}
			this.stmt.close();
			this.tupla.close();
			this.conexao.close();
			if(this.unidadesList.size()>0)
				return this.unidadesList;
			return null;
		}
		catch (Exception e) {
			System.out.println("Exceção lançada: "+e.toString());
			return null;
		}
	}
	public List<Unidades> pegarUnidadesResponsavel(String responsavel){
		this.conexao=ConnectionFactory.getConnection();
		Unidades unidade;
		try{
			this.conexao.createStatement();
			this.stmt=this.conexao.prepareStatement("SELECT * FROM unidade WHERE responsavel LIKE '"+responsavel+"%'");
			this.tupla=this.stmt.executeQuery();
			this.unidadesList.clear();
			while(tupla.next()){
				unidade= new Unidades();
				unidade.setBairro(tupla.getString("bairro"));
				unidade.setCep(tupla.getString("cep"));
				unidade.setCidade(tupla.getString("cidade"));
				unidade.setCnes(tupla.getString("cnes"));
				unidade.setComplemento(tupla.getString("complemento"));
				unidade.setFone(tupla.getString("telefone"));
				unidade.setLogradouro(tupla.getString("logradouro"));
				unidade.setNomeResponsavel(tupla.getString("responsavel"));
				unidade.setTipoUnidade(tupla.getString("tipo"));
				this.unidadesList.add(unidade);
				
			}
			this.stmt.close();
			this.tupla.close();
			this.conexao.close();
			if(this.unidadesList.size()>0)
				return this.unidadesList;
			return null;
		}
		catch (Exception e) {
			System.out.println("Exceção lançada: "+e.toString());
			return null;
		}
	}
	public List<Unidades> pegarUnidadesTipo(String tipo){
		this.conexao=ConnectionFactory.getConnection();
		Unidades unidade;
		try{
			this.conexao.createStatement();
			this.stmt=this.conexao.prepareStatement("SELECT * FROM unidade WHERE tipo LIKE '"+tipo+"%'");
			this.tupla=this.stmt.executeQuery();
			this.unidadesList.clear();
			while(tupla.next()){
				unidade= new Unidades();
				unidade.setBairro(tupla.getString("bairro"));
				unidade.setCep(tupla.getString("cep"));
				unidade.setCidade(tupla.getString("cidade"));
				unidade.setCnes(tupla.getString("cnes"));
				unidade.setComplemento(tupla.getString("complemento"));
				unidade.setFone(tupla.getString("telefone"));
				unidade.setLogradouro(tupla.getString("logradouro"));
				unidade.setNomeResponsavel(tupla.getString("responsavel"));
				unidade.setTipoUnidade(tupla.getString("tipo"));
				this.unidadesList.add(unidade);
				
			}
			this.stmt.close();
			this.tupla.close();
			this.conexao.close();
			if(this.unidadesList.size()>0)
				return this.unidadesList;
			return null;
		}
		catch (Exception e) {
			System.out.println("Exceção lançada: "+e.toString());
			return null;
		}
	}
	public Unidades pegarUnidade(Unidades unida){
		this.conexao=ConnectionFactory.getConnection();
		Unidades unidade;
		try{
			this.conexao.createStatement();
			this.stmt=this.conexao.prepareStatement("SELECT* FROM unidade WHERE cnes=?");
			this.stmt.setString(1, unida.getCnes().toString());
			this.tupla=this.stmt.executeQuery();
			this.unidadesList.clear();
			while(tupla.next()){
				unidade= new Unidades();
				unidade.setBairro(tupla.getString("bairro"));
				unidade.setCep(tupla.getString("cep"));
				unidade.setCidade(tupla.getString("cidade"));
				unidade.setCnes(tupla.getString("cnes"));
				unidade.setComplemento(tupla.getString("complemento"));
				unidade.setFone(tupla.getString("telefone"));
				unidade.setLogradouro(tupla.getString("logradouro"));
				unidade.setNomeResponsavel(tupla.getString("responsavel"));
				unidade.setTipoUnidade(tupla.getString("tipo"));
				this.unidadesList.add(unidade);
			}
			this.stmt.close();
			this.tupla.close();
			this.conexao.close();
			if(this.unidadesList.size()>0)
				return this.unidadesList.get(0);
			return null;
		}
		catch (Exception e) {
			System.out.println("Exceção lançada: "+e.toString());
			return null;
		}
	}
	public boolean atualizarUnidade(Unidades unidade){
		this.conexao=ConnectionFactory.getConnection();
		try{
			this.conexao.createStatement();
			this.stmt=this.conexao.prepareStatement("UPDATE unidade SET bairro=?,cep=?,cidade=?,complemento=?,logradouro=?,telefone=?,responsavel=?," +
					"tipo=?,cnes=? WHERE cnes=?");
			this.stmt.setString(1,unidade.getBairro());
			this.stmt.setString(2, unidade.getCep());
			this.stmt.setString(3, unidade.getCidade());
			this.stmt.setString(4, unidade.getComplemento());
			this.stmt.setString(5, unidade.getLogradouro());
			this.stmt.setString(6, unidade.getFone());
			this.stmt.setString(7, unidade.getNomeResponsavel());
			this.stmt.setString(8, unidade.getTipoUnidade());
			this.stmt.setString(9, unidade.getCnes().toString());
			this.stmt.setString(10, unidade.getCnes().toString());
			this.stmt.execute();
			this.stmt.close();
			this.conexao.close();
			return true;
		}
		catch(Exception e){
			System.out.println("Exceção lançada: "+e.toString());
			return false;
		}
		
	}
	public boolean excluirTodasUnidades(){
		this.conexao=ConnectionFactory.getConnection();
		try{
			this.conexao.createStatement();
			this.stmt=this.conexao.prepareStatement("DELETE FROM unidade");
			this.stmt.execute();
			this.stmt.close();
			this.conexao.close();
			return true;
			
		}
		catch (Exception e) {
			System.out.println("Exceção lançada: "+e.toString());
			return false;
		}
	}
	public boolean excluirUnidade(Unidades unidade){
		this.conexao=ConnectionFactory.getConnection();
		try{
			this.conexao.createStatement();
			this.stmt=this.conexao.prepareStatement("DELETE FROM unidade WHERE cnes=?");
			this.stmt.setString(1,unidade.getCnes());
			this.stmt.execute();
			this.stmt.close();
			this.conexao.close();
			return true;
			
		}
		catch (Exception e) {
			System.out.println("Exceção lançada: "+e.toString());
			return false;
		}
	}
}
