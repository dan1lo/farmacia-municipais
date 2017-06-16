package DAO;

import java.util.List;

import business.Usuario;

public interface IUsuarioDAO {
	public boolean inserirUsuario(Usuario user);
	public List<Usuario> pegarTodosUsuario();
	public List<Usuario> pegarUsuariosNome(String nome);
	public List<Usuario> pegarUsuariosCargo(String cargo);
	public Usuario pegarUsuario(Usuario usuario);
	public Usuario pegarEValidarUsuario(Usuario usuario);
	public Usuario pegarUsuarioLogin(Usuario usuario);
	public boolean atualizarUsuario(Usuario user);
	public boolean excluirUsuario(Usuario user);
	public boolean excluirTodosUsuario();

}
