package view;


import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import util.Criptografia;

import business.Fachada;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTextField txtLogin = null;
	private JLabel lblLogin = null;
	private JLabel lblSenha = null;
	private JPasswordField txtSenha = null;
	private JButton btnEntrar = null;
	private JButton btnSair = null;
	private JLabel jLabel = null;

	
	public Login() {
		super();
		initialize();
	}

	
	private void initialize() {
		this.setSize(449, 197);
		this.setContentPane(getJContentPane());
		this.setTitle("Login do Sistema");
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(0, 1, 440, 167));
			jLabel.setIcon(new ImageIcon(getClass().getResource("/imagens/brancoazul2.jpg")));
			lblSenha = new JLabel();
			lblSenha.setBounds(new Rectangle(30, 77, 51, 25));
			lblSenha.setText("Senha");
			lblLogin = new JLabel();
			lblLogin.setBounds(new Rectangle(29, 28, 52, 27));
			lblLogin.setText("Login");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getTxtLogin(), null);
			jContentPane.add(lblLogin, null);
			jContentPane.add(lblSenha, null);
			jContentPane.add(getTxtSenha(), null);
			jContentPane.add(getBtnEntrar(), null);
			jContentPane.add(getBtnSair(), null);
			jContentPane.add(jLabel, null);
		}
		return jContentPane;
	}

	
	private JTextField getTxtLogin() {
		if (txtLogin == null) {
			txtLogin = new JTextField();
			txtLogin.setBounds(new Rectangle(102, 28, 300, 27));
			txtLogin.setDocument(new business.NumeroMaximoCaracteres(15));
		}
		return txtLogin;
	}

	
	private JPasswordField getTxtSenha() {
		if (txtSenha == null) {
			txtSenha = new JPasswordField();
			txtSenha.setBounds(new Rectangle(101, 76, 299, 27));
			txtSenha.setDocument(new business.NumeroMaximoCaracteres(15));
		}
		return txtSenha;
	}

	
	private JButton getBtnEntrar() {
		if (btnEntrar == null) {
			btnEntrar = new JButton();
			btnEntrar.setBounds(new Rectangle(94, 120, 132, 32));
			btnEntrar.setIcon(new ImageIcon(getClass().getResource("/imagens/cliente.png")));
			btnEntrar.setText("Entrar");
			btnEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					try{
					String senhaCrip,senha=new String(txtSenha.getPassword());
					senhaCrip=Criptografia.encripta(senha);
					if(!senha.isEmpty() && !txtLogin.getText().isEmpty() && !senha.equals(senhaCrip)){
						business.Usuario user= new business.Usuario();
						user.setLogin(txtLogin.getText());
						user.setSenha(senhaCrip);
						user=Fachada.getInstancia().pegarEValidarUsuario(user);
						if(user!=null){
							new Principal(user);
							dispose();
						}
						txtLogin.setText(null);
						txtSenha.setText(null);
					}
					else if(senha.equals(senhaCrip)){
						JOptionPane.showMessageDialog(null, "Erro ao criptografar a senha!", "Farmacia",
								JOptionPane.INFORMATION_MESSAGE, null);
					}
				}catch (Exception farmacia) {
					JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado\n" +
							"por favor contate o administrador do sistema!","Farmacia",JOptionPane.ERROR_MESSAGE,null);
				}
				}
			});
		}
		return btnEntrar;
	}

	
	private JButton getBtnSair() {
		if (btnSair == null) {
			btnSair = new JButton();
			btnSair.setBounds(new Rectangle(280, 120, 115, 32));
			btnSair.setIcon(new ImageIcon(getClass().getResource("/imagens/sair.png")));
			btnSair.setText("Sair");
			btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
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
		return btnSair;
	}
	public static void main(String[] agv){
		new Login();
	}

}  
