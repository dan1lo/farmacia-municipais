package Controllers;
import java.util.List;

import business.Usuario;

public interface IControllerUsuario {
	public List<Usuario> pegarAllUsuarios();
	public List<Usuario> pegarUsuariosNome(String nome);
	public List<Usuario> pegarUsuariosCargo(String cargo);
	public Usuario pegarUsuario(Usuario user);
	public Usuario pegarUsuarioLogin(Usuario user);
	public Usuario pegarEValidarUsuario(Usuario user);
	public boolean inserirUsuario(Usuario user);
	public boolean excluirUsuario(Usuario user);
	public boolean atualizarUsuario(Usuario user);
	public boolean excluirAllUsuarios();
	public String validarUsuario(Usuario user,String confirmaSenha);

}
