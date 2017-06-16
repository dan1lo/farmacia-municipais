package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import business.Usuario;

public class UsuarioDAO implements IUsuarioDAO{
	private Connection conexao;
	private PreparedStatement stmt;
	private ResultSet tupla;
	private List<Usuario> usuariosList= new ArrayList<Usuario>(); 
	
	
	public boolean inserirUsuario(Usuario user){
		this.conexao=ConnectionFactory.getConnection();
		try{
			this.conexao.createStatement();
			this.stmt=this.conexao.prepareStatement("INSERT INTO usuario (cpf_user,nome,cargo,login,senha) VALUES(?,?,?,?,?)");
			this.stmt.setString(1, user.getCpf());
			this.stmt.setString(2,user.getNome());
			this.stmt.setString(3, user.getCargo());
			this.stmt.setString(4, user.getLogin());
			this.stmt.setString(5, user.getSenha());
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
	public List<Usuario> pegarTodosUsuario(){
		this.conexao=ConnectionFactory.getConnection();
		try{
			this.conexao.createStatement();
			this.stmt=conexao.prepareStatement("SELECT * FROM usuario");
			this.usuariosList.clear();
			this.tupla=stmt.executeQuery();
			while(this.tupla.next()){
				Usuario user= new Usuario();
				user.setCargo(this.tupla.getString("cargo"));
				user.setCpf(this.tupla.getString("cpf_user"));
				user.setLogin(this.tupla.getString("login"));
				user.setNome(this.tupla.getString("nome"));
				user.setSenha(this.tupla.getString("senha"));
				this.usuariosList.add(user);
			}
			this.tupla.close();
			this.stmt.close();
			if(this.usuariosList.size()>0)
				return this.usuariosList;
			return null;
		}
		catch(Exception e){
			System.out.println("Exceção lançada: "+e.toString());
			return null;
		}
	}
	public List<Usuario> pegarUsuariosNome(String nome){
		this.conexao=ConnectionFactory.getConnection();
		try{
			this.conexao.createStatement();
			this.stmt=conexao.prepareStatement("SELECT * FROM usuario WHERE nome LIKE '"+nome+"%'");
			this.usuariosList.clear();
			this.tupla=stmt.executeQuery();
			while(this.tupla.next()){
				Usuario user= new Usuario();
				user.setCargo(this.tupla.getString("cargo"));
				user.setCpf(this.tupla.getString("cpf_user"));
				user.setLogin(this.tupla.getString("login"));
				user.setNome(this.tupla.getString("nome"));
				user.setSenha(this.tupla.getString("senha"));
				this.usuariosList.add(user);
			}
			this.tupla.close();
			this.stmt.close();
			this.conexao.close();
			if(this.usuariosList.size()>0)
				return this.usuariosList;
			return null;
		}
		catch(Exception e){
			System.out.println("Exceção lançada: "+e.toString());
			return null;
		}
	}
	public List<Usuario> pegarUsuariosCargo(String cargo){
		this.conexao=ConnectionFactory.getConnection();
		try{
			this.conexao.createStatement();
			this.stmt=conexao.prepareStatement("SELECT * FROM usuario WHERE cargo LIKE '"+cargo+"%'");
			this.usuariosList.clear();
			this.tupla=stmt.executeQuery();
			while(this.tupla.next()){
				Usuario user= new Usuario();
				user.setCargo(this.tupla.getString("cargo"));
				user.setCpf(this.tupla.getString("cpf_user"));
				user.setLogin(this.tupla.getString("login"));
				user.setNome(this.tupla.getString("nome"));
				user.setSenha(this.tupla.getString("senha"));
				this.usuariosList.add(user);
			}
			this.tupla.close();
			this.stmt.close();
			this.conexao.close();
			if(this.usuariosList.size()>0)
				return this.usuariosList;
			return null;
		}
		catch(Exception e){
			System.out.println("Exceção lançada: "+e.toString());
			return null;
		}
	}


	public Usuario pegarUsuario(Usuario usuario){
		this.conexao=ConnectionFactory.getConnection();
		try{
			this.conexao.createStatement();
			this.stmt=this.conexao.prepareStatement("SELECT * FROM usuario WHERE cpf_user=?");
			stmt.setString(1, usuario.getCpf());
			this.usuariosList.clear();
			this.tupla=stmt.executeQuery();
			while(this.tupla.next()){
				Usuario user= new Usuario();
				user.setCargo(this.tupla.getString("cargo"));
				user.setCpf(this.tupla.getString("cpf_user"));
				user.setLogin(this.tupla.getString("login"));
				user.setNome(this.tupla.getString("nome"));
				user.setSenha(this.tupla.getString("senha"));
				this.usuariosList.add(user);
			}
			this.tupla.close();
			this.stmt.close();
			this.conexao.close();
			if(this.usuariosList.size()>0)
				return this.usuariosList.get(0);
			return null;
		}
		catch(Exception e){
			System.out.println("Exceção lançada: "+e.toString());
			return null;
		}
	}
	public Usuario pegarEValidarUsuario(Usuario usuario){
		this.conexao=ConnectionFactory.getConnection();
		try{
			this.conexao.createStatement();
			this.stmt=this.conexao.prepareStatement("SELECT * FROM usuario WHERE login=? AND senha=?");
			this.stmt.setString(1, usuario.getLogin());
			this.stmt.setString(2, usuario.getSenha());
			this.usuariosList.clear();
			this.tupla=stmt.executeQuery();
			while(this.tupla.next()){
				Usuario user= new Usuario();
				user.setCargo(this.tupla.getString("cargo"));
				user.setCpf(this.tupla.getString("cpf_user"));
				user.setLogin(this.tupla.getString("login"));
				user.setNome(this.tupla.getString("nome"));
				user.setSenha(this.tupla.getString("senha"));
				this.usuariosList.add(user);
			}
			this.tupla.close();
			this.stmt.close();
			this.conexao.close();
			if(this.usuariosList.size()>0)
				return this.usuariosList.get(0);
			return null;
		}
		catch(Exception e){
			System.out.println("Exceção lançada: "+e.toString());
			return null;
		}
	}
	public Usuario pegarUsuarioLogin(Usuario usuario){
		this.conexao=ConnectionFactory.getConnection();
		try{
			this.conexao.createStatement();
			this.stmt=this.conexao.prepareStatement("SELECT * FROM usuario WHERE cpf_user=? OR login=?");
			this.stmt.setString(1, usuario.getCpf());
			this.stmt.setString(2, usuario.getLogin());
			this.usuariosList.clear();
			this.tupla=stmt.executeQuery();
			while(this.tupla.next()){
				Usuario user= new Usuario();
				user.setCargo(this.tupla.getString("cargo"));
				user.setCpf(this.tupla.getString("cpf_user"));
				user.setLogin(this.tupla.getString("login"));
				user.setNome(this.tupla.getString("nome"));
				user.setSenha(this.tupla.getString("senha"));
				this.usuariosList.add(user);
			}
			this.tupla.close();
			this.stmt.close();
			this.conexao.close();
			if(this.usuariosList.size()>0)
				return this.usuariosList.get(0);
			return null;
		}
		catch(Exception e){
			System.out.println("Exceção lançada: "+e.toString());
			return null;
		}
	}
	public boolean atualizarUsuario(Usuario user){
		this.conexao=ConnectionFactory.getConnection();
		try{
			this.conexao.createStatement();
			this.stmt=this.conexao.prepareStatement("UPDATE usuario SET cargo=?,cpf_user=?,login=?,nome=?,senha=? WHERE cpf_user=?");
			this.stmt.setString(1, user.getCargo());
			this.stmt.setString(2,user.getCpf());
			this.stmt.setString(3, user.getLogin());
			this.stmt.setString(4, user.getNome());
			this.stmt.setString(5, user.getSenha());
			this.stmt.setString(6, user.getCpf());
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
	public boolean excluirUsuario(Usuario user){
		this.conexao=ConnectionFactory.getConnection();
		try{
			this.conexao.createStatement();
			this.stmt=conexao.prepareStatement("DELETE FROM usuario WHERE cpf_user=?");
			this.stmt.setString(1, user.getCpf());
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
	public boolean excluirTodosUsuario(){
		this.conexao=ConnectionFactory.getConnection();
		try{
			this.conexao.createStatement();
			this.stmt=this.conexao.prepareStatement("DELETE FROM usuario ");
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
}
