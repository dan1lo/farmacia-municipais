package view;


import javax.swing.JPanel;
import java.awt.Rectangle;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import util.Criptografia;

import business.Fachada;
import business.Usuario;
import java.awt.Color;

public class AlteraSenha extends JDialog {
	
	private Usuario usuarioPrivado= new Usuario();  //  @jve:decl-index=0:

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel lblSenhaAtual = null;
	private JPasswordField txtNovaSenha = null;
	private JLabel lblNovaSenha = null;
	private JButton btnCancelar = null;
	private JButton btnAlterar = null;
	private JPasswordField txtSenhaAtual = null;
	private JLabel jLabel = null;
	public AlteraSenha(Usuario user) {
		super();
		initialize();
		if(user!=null)
			this.usuarioPrivado=user;
	}
	public AlteraSenha() {
		super();
		initialize();
	}

	
	private void initialize() {
		this.setSize(415, 234);
		this.setContentPane(getJContentPane());
		this.setTitle("Alterar Senha");
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setVisible(true);
		
	}

	
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(1, 1, 409, 211));
			jLabel.setIcon(new ImageIcon(getClass().getResource("/imagens/brancoazul2.jpg")));
			jLabel.setBackground(new Color(233, 233, 233));
			jLabel.setText("JLabel");
			lblNovaSenha = new JLabel();
			lblNovaSenha.setBounds(new Rectangle(11, 90, 73, 22));
			lblNovaSenha.setText("Nova senha");
			lblSenhaAtual = new JLabel();
			lblSenhaAtual.setBounds(new Rectangle(12, 52, 72, 23));
			lblSenhaAtual.setText("Senha atual");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(lblSenhaAtual, null);
			jContentPane.add(getTxtNovaSenha(), null);
			jContentPane.add(lblNovaSenha, null);
			jContentPane.add(getBtnCancelar(), null);
			jContentPane.add(getBtnAlterar(), null);
			jContentPane.add(getTxtSenhaAtual(), null);
			jContentPane.add(jLabel, null);
		}
		return jContentPane;
	}

	
	private JPasswordField getTxtNovaSenha() {
		if (txtNovaSenha == null) {
			txtNovaSenha = new JPasswordField();
			txtNovaSenha.setBounds(new Rectangle(104, 91, 265, 28));
			txtNovaSenha.setDocument(new business.NumeroMaximoCaracteres(15));
		}
		return txtNovaSenha;
	}

	
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton();
			btnCancelar.setBounds(new Rectangle(241, 150, 127, 28));
			btnCancelar.setText("Cancelar");
			btnCancelar.setIcon(new ImageIcon(getClass().getResource("/imagens/cancelar.png")));
			btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					try{
					dispose();
					}catch (Exception farmacia) {
						JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado\n" +
								"por favor contate o administrador do sistema!","Farmacia",JOptionPane.ERROR_MESSAGE,null);
					}
				}
			});
		}
		return btnCancelar;
	}

	
	private JButton getBtnAlterar() {
		if (btnAlterar == null) {
			btnAlterar = new JButton();
			btnAlterar.setBounds(new Rectangle(36, 150, 165, 29));
			btnAlterar.setIcon(new ImageIcon(getClass().getResource("/imagens/alterar.png")));
			btnAlterar.setText("Alterar Senha");
			btnAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					try{
					String senha= new String(txtSenhaAtual.getPassword());
					senha=Criptografia.encripta(senha);
					Usuario user;
					user=Fachada.getInstancia().pegarEValidarUsuario(usuarioPrivado);
					if(senha.equals(usuarioPrivado.getSenha()) && user!=null){
							String novaSenha=new String(txtNovaSenha.getPassword());
							novaSenha=Criptografia.encripta(novaSenha);
							usuarioPrivado.setSenha(novaSenha);
							if(Fachada.getInstancia().atualizarUsuario(usuarioPrivado)){
								JOptionPane.showMessageDialog(null, "Senha modificada com sucesso!");
							}
							else{
								JOptionPane.showMessageDialog(null, "Falha na modificação da senha!");
								usuarioPrivado.setSenha(senha);
							}
							dispose();
						}
					else if(!senha.equals(usuarioPrivado.getSenha()))
						JOptionPane.showMessageDialog(null, "Senha atual inválida!");
				}catch (Exception farmacia) {
					JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado\n" +
							"por favor contate o administrador do sistema!","Farmacia",JOptionPane.ERROR_MESSAGE,null);
				}
				}
			});
		}
		return btnAlterar;
	}

	
	private JPasswordField getTxtSenhaAtual() {
		if (txtSenhaAtual == null) {
			txtSenhaAtual = new JPasswordField();
			txtSenhaAtual.setBounds(new Rectangle(103, 53, 266, 24));
			txtSenhaAtual.setDocument(new business.NumeroMaximoCaracteres(15));
		}
		return txtSenhaAtual;
	}

}  
