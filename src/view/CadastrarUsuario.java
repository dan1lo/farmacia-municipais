package view;


import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

import business.Fachada;
import business.Usuario;

import java.awt.ComponentOrientation;

import util.Criptografia;
import util.Maskara;

public class CadastrarUsuario extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTextField txtNome = null;
	private JLabel lblNome = null;
	private JLabel lblCpf = null;
	private JTextField txtCpf = null;
	private JLabel lblCargo = null;
	private JTextField txtCargo = null;
	private JLabel lblSenha = null;
	private JLabel lblConfirmaSenha = null;
	private JLabel lblLogin = null;
	private JTextField txtLogin = null;
	private JButton btnCadastrar = null;
	private JButton btnCancelar = null;
	private JButton btnLimpar = null;
	private JPasswordField txtSenha = null;
	private JPasswordField txtConfirmaSenha = null;
	private JLabel lblDica = null;
	private JLabel jLabel = null;
	
	public CadastrarUsuario() {
		super();
		initialize();
	}

	
	private void initialize() {
		this.setSize(518, 337);
		this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		this.setContentPane(getJContentPane());
		this.setTitle("Cadastrar Usuário");
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setVisible(true);
	}

	
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(2, 2, 510, 305));
			jLabel.setIcon(new ImageIcon(getClass().getResource("/imagens/brancoazul2.jpg")));
			lblDica = new JLabel();
			lblDica.setBounds(new Rectangle(15, 278, 217, 16));
			lblDica.setText("* Campos obrigatórios");
			lblLogin = new JLabel();
			lblLogin.setBounds(new Rectangle(16, 84, 44, 23));
			lblLogin.setText("Login:*");
			lblConfirmaSenha = new JLabel();
			lblConfirmaSenha.setBounds(new Rectangle(15, 166, 112, 22));
			lblConfirmaSenha.setText("Repetir senha:*");
			lblSenha = new JLabel();
			lblSenha.setBounds(new Rectangle(15, 123, 53, 21));
			lblSenha.setText("Senha:*");
			lblCargo = new JLabel();
			lblCargo.setBounds(new Rectangle(244, 50, 59, 24));
			lblCargo.setText("Cargo:*");
			lblCpf = new JLabel();
			lblCpf.setBounds(new Rectangle(16, 48, 38, 20));
			lblCpf.setText("CPF:*");
			lblNome = new JLabel();
			lblNome.setBounds(new Rectangle(15, 16, 52, 21));
			lblNome.setText("Nome:*");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getTxtNome(), null);
			jContentPane.add(lblNome, null);
			jContentPane.add(lblCpf, null);
			jContentPane.add(getTxtCpf(), null);
			jContentPane.add(lblCargo, null);
			jContentPane.add(getTxtCargo(), null);
			jContentPane.add(lblSenha, null);
			jContentPane.add(lblConfirmaSenha, null);
			jContentPane.add(getTxtConfirmaSenha(), null);
			jContentPane.add(getTxtSenha(), null);
			jContentPane.add(lblLogin, null);
			jContentPane.add(getTxtLogin(), null);
			jContentPane.add(getBtnCadastrar(), null);
			jContentPane.add(getBtnCancelar(), null);
			jContentPane.add(getBtnLimpar(), null);
			jContentPane.add(lblDica, null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getTxtConfirmaSenha(), null);
			jContentPane.add(getTxtSenha(), null);
		}
		return jContentPane;
	}

	
	private JTextField getTxtNome() {
		if (txtNome == null) {
			txtNome = new JTextField();
			txtNome.setBounds(new Rectangle(71, 12, 416, 26));
			txtNome.setDocument(new business.NumeroMaximoCaracteres(30));
		}
		return txtNome;
	}

	
	private JTextField getTxtCpf() {
		if (txtCpf == null) {
			txtCpf = Maskara.getMascara("###########");//new JTextField();
			txtCpf.setBounds(new Rectangle(71, 45, 157, 27));
			//txtCpf.setDocument(new business.NumeroMaximoCaracteres(11));
		}
		return txtCpf;
	}

	
	private JTextField getTxtCargo() {
		if (txtCargo == null) {
			txtCargo = new JTextField();
			txtCargo.setBounds(new Rectangle(315, 45, 168, 28));
			txtCargo.setDocument(new business.NumeroMaximoCaracteres(15));
		}
		return txtCargo;
	}

	
	private JTextField getTxtLogin() {
		if (txtLogin == null) {
			txtLogin = new JTextField();
			txtLogin.setBounds(new Rectangle(73, 84, 412, 26));
			txtLogin.setDocument(new business.NumeroMaximoCaracteres(15));
		}
		return txtLogin;
	}

	
	private JButton getBtnCadastrar() {
		if (btnCadastrar == null) {
			btnCadastrar = new JButton();
			btnCadastrar.setBounds(new Rectangle(40, 227, 121, 29));
			btnCadastrar.setIcon(new ImageIcon(getClass().getResource("/imagens/salvar.png")));
			btnCadastrar.setText("Cadastrar");
			btnCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					try{
						String senha,senhaCrip,valida;
						Usuario user= new Usuario();
						user.setCargo(txtCargo.getText());
						user.setCpf(txtCpf.getText());
						user.setLogin(txtLogin.getText());
						user.setNome(txtNome.getText());
						senha=new String(txtSenha.getPassword());
						senhaCrip=Criptografia.encripta(senha);
						user.setSenha(senhaCrip);
						valida=Fachada.getInstancia().validarUsuario(user,Criptografia.encripta(new String(txtConfirmaSenha.getPassword())));
					if(valida!=null){
						JOptionPane.showMessageDialog(null, valida);
					}
					else{	
					Usuario userReserva;
					userReserva=Fachada.getInstancia().pegarUsuarioLogin(user);
					if(userReserva==null && !senha.equals(senhaCrip)){
						if(Fachada.getInstancia().inserirUsuario(user)){
							CadastrarUsuario.this.limparDados();
							JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
						}
						else
							JOptionPane.showMessageDialog(null, "Falha no cadastro do usuário!");
					} 
					else if(userReserva.getCpf().equals(user.getCpf())){
						JOptionPane.showMessageDialog(null, "Usuário já está cadastrado!\nNome: "+userReserva.getNome());
						CadastrarUsuario.this.limparDados();
					}
					else if(senha.equals(senhaCrip)){
						JOptionPane.showMessageDialog(null, "Erro ao criptografar a senha!", "Farmacia",
								JOptionPane.INFORMATION_MESSAGE, null);
						limparDados();
					}
					else {
						JOptionPane.showMessageDialog(null, "Login já existe forneça outro!");
						txtLogin.setText(null);
					}
						
					}
				}catch (Exception farmacia) {
					JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado\n" +
							"por favor contate o administrador do sistema!","Farmacia",JOptionPane.ERROR_MESSAGE,null);
				}
				}
			});
		}
		return btnCadastrar;
	}

	
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton();
			btnCancelar.setBounds(new Rectangle(187, 228, 123, 29));
			btnCancelar.setIcon(new ImageIcon(getClass().getResource("/imagens/cancelar.png")));
			btnCancelar.setText("Cancelar");
			btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					try{
					CadastrarUsuario.this.dispose();
					}catch (Exception farmacia) {
						JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado\n" +
								"por favor contate o administrador do sistema!","Farmacia",JOptionPane.ERROR_MESSAGE,null);
					}
					
				}
			});
		}
		return btnCancelar;
	}

	
	private JButton getBtnLimpar() {
		if (btnLimpar == null) {
			btnLimpar = new JButton();
			btnLimpar.setBounds(new Rectangle(335, 227, 109, 30));
			btnLimpar.setIcon(new ImageIcon(getClass().getResource("/imagens/limpar.png")));
			btnLimpar.setText("Limpar");
			btnLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					try{
						CadastrarUsuario.this.limparDados();
					}catch (Exception farmacia) {
						JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado\n" +
								"por favor contate o administrador do sistema!","Farmacia",JOptionPane.ERROR_MESSAGE,null);
					}
				}
			});
		}
		return btnLimpar;
	}
	
	
	private JPasswordField getTxtSenha() {
		if (txtSenha == null) {
			txtSenha = new JPasswordField();
			txtSenha.setBounds(new Rectangle(75, 123, 293, 27));
			txtSenha.setDocument(new business.NumeroMaximoCaracteres(15));
		}
		return txtSenha;
	}

	
	private JPasswordField getTxtConfirmaSenha() {
		if (txtConfirmaSenha == null) {
			txtConfirmaSenha = new JPasswordField();
			txtConfirmaSenha.setBounds(new Rectangle(148, 166, 221, 28));
			txtConfirmaSenha.setDocument(new business.NumeroMaximoCaracteres(15));
		}
		return txtConfirmaSenha;
	}

//---------------------------METODOS FATORADOS
	
	//limpa os campos da tela
	public void limparDados(){
		this.txtCargo.setText(null);
		this.txtConfirmaSenha.setText(null);
		this.txtCpf.setText(null);
		this.txtLogin.setText(null);
		this.txtNome.setText(null);
		this.txtSenha.setText(null);
	}

}  