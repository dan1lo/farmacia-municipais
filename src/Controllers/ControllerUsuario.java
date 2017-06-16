package Controllers;

import java.util.List;

import DAO.IUsuarioDAO;
import DAO.UsuarioDAO;
import business.Usuario;
import business.ValidarUsuario;

public class ControllerUsuario implements IControllerUsuario{
	
	public List<Usuario> pegarAllUsuarios(){
		IUsuarioDAO usuarioDao= new UsuarioDAO();
		return usuarioDao.pegarTodosUsuario();
	}
	public List<Usuario> pegarUsuariosNome(String nome){
		IUsuarioDAO usuarioDao= new UsuarioDAO();
		if(nome!=null)
			return usuarioDao.pegarUsuariosNome(nome);
		return null;
	}
	public List<Usuario> pegarUsuariosCargo(String cargo){
		IUsuarioDAO usuarioDao= new UsuarioDAO();
		if(cargo!=null)
			return usuarioDao.pegarUsuariosCargo(cargo);
		return null;
	}
	public Usuario pegarUsuario(Usuario user){
		IUsuarioDAO usuarioDao= new UsuarioDAO();
		if(user!=null)
			return usuarioDao.pegarUsuario(user);
		return null;
	}
	public Usuario pegarUsuarioLogin(Usuario user){
		IUsuarioDAO usuarioDao= new UsuarioDAO();
		if(user!=null)
			return usuarioDao.pegarUsuarioLogin(user);
		return null;
	}
	public Usuario pegarEValidarUsuario(Usuario user){
		IUsuarioDAO usuarioDao= new UsuarioDAO();
		if(user!=null)
			return usuarioDao.pegarEValidarUsuario(user);
		return null;
	}
	public boolean inserirUsuario(Usuario user){
		IUsuarioDAO usuarioDao= new UsuarioDAO();
		if(user!=null)
			return usuarioDao.inserirUsuario(user);
		return false;
	}
	public boolean excluirUsuario(Usuario user){
		IUsuarioDAO usuarioDao= new UsuarioDAO();
		if(user!=null)
			return usuarioDao.excluirUsuario(user);
		return false;
	}
	public boolean atualizarUsuario(Usuario user){
		IUsuarioDAO usuarioDao= new UsuarioDAO();
		if(user!=null)
			return usuarioDao.atualizarUsuario(user);
		return false;
	}
	public boolean excluirAllUsuarios(){
		IUsuarioDAO usuarioDao= new UsuarioDAO();
		return usuarioDao.excluirTodosUsuario();
	}
	public String validarUsuario(Usuario user,String confirmaSenha){
			return new ValidarUsuario().validarUsuario(user, confirmaSenha);
	}

}
