package view;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import util.Maskara;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import business.Fachada;
import business.Unidades;

public class CadastrarUnidade extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel lblNome = null;
	private JTextField txtNome = null;
	private JLabel lblEndereco = null;
	private JTextField txtEndereco = null;
	private JLabel lblCodigo = null;
	private JTextField txtCodigo = null;
	private JLabel lblComplemento = null;
	private JTextField txtComplemento = null;
	private JLabel lblCidade = null;
	private JTextField txtCidade = null;
	private JLabel lblBairro = null;
	private JTextField txtBairro = null;
	private JLabel lblFone = null;
	private JTextField txtFone = null;
	private JLabel lblTipo = null;
	private JComboBox cboxTipo = null;
	private JLabel lblCep = null;
	private JTextField txtCep = null;
	private JButton btnCadastrar = null;
	private JButton btnCancelar = null;
	private JButton btnLimpar = null;
	private JLabel lblDica = null;
	private JLabel jLabel = null;
	/**
	 * This is the default constructor
	 */
	public CadastrarUnidade() {
		super();
		initialize();
	}

	
	private void initialize() {
		this.setSize(546, 395);
		this.setFont(new Font("Verdana", Font.PLAIN, 14));
		this.setContentPane(getJContentPane());
		this.setTitle("Cadastro de Unidade");
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setVisible(true);
	}

	
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(-1, 2, 540, 365));
			jLabel.setIcon(new ImageIcon(getClass().getResource("/imagens/brancoazul2.jpg")));
			lblDica = new JLabel();
			lblDica.setBounds(new Rectangle(38, 349, 146, 16));
			lblDica.setText("* Campos obrigatórios");
			lblCep = new JLabel();
			lblCep.setBounds(new Rectangle(325, 168, 53, 23));
			lblCep.setText("CEP:*");
			lblTipo = new JLabel();
			lblTipo.setBounds(new Rectangle(7, 252, 104, 24));
			lblTipo.setText("Tipo de Unidade:*");
			lblFone = new JLabel();
			lblFone.setBounds(new Rectangle(323, 210, 58, 22));
			lblFone.setText("Telefone:*");
			lblBairro = new JLabel();
			lblBairro.setBounds(new Rectangle(10, 132, 94, 21));
			lblBairro.setText("Bairro:*");
			lblCidade = new JLabel();
			lblCidade.setBounds(new Rectangle(8, 167, 96, 26));
			lblCidade.setText("Cidade:*");
			lblComplemento = new JLabel();
			lblComplemento.setBounds(new Rectangle(8, 92, 97, 23));
			lblComplemento.setText("Complemento:");
			lblCodigo = new JLabel();
			lblCodigo.setBounds(new Rectangle(8, 208, 93, 23));
			lblCodigo.setText("Código CNES:*");
			lblEndereco = new JLabel();
			lblEndereco.setBounds(new Rectangle(10, 53, 95, 24));
			lblEndereco.setFont(new Font("Dialog", Font.BOLD, 12));
			lblEndereco.setText("Endereço:*");
			lblNome = new JLabel();
			lblNome.setBounds(new Rectangle(9, 9, 95, 26));
			lblNome.setFont(new Font("Dialog", Font.BOLD, 12));
			lblNome.setText("Responsável:*");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(lblNome, null);
			jContentPane.add(getTxtNome(), null);
			jContentPane.add(lblEndereco, null);
			jContentPane.add(getTxtEndereco(), null);
			jContentPane.add(lblCodigo, null);
			jContentPane.add(getTxtCodigo(), null);
			jContentPane.add(lblComplemento, null);
			jContentPane.add(getTxtComplemento(), null);
			jContentPane.add(lblCidade, null);
			jContentPane.add(getTxtCidade(), null);
			jContentPane.add(lblBairro, null);
			jContentPane.add(getTxtBairro(), null);
			jContentPane.add(lblFone, null);
			jContentPane.add(getTxtFone(), null);
			jContentPane.add(lblTipo, null);
			jContentPane.add(getCboxTipo(), null);
			jContentPane.add(lblCep, null);
			jContentPane.add(getTxtCep(), null);
			jContentPane.add(getBtnCadastrar(), null);
			jContentPane.add(getBtnCancelar(), null);
			jContentPane.add(getBtnLimpar(), null);
			jContentPane.add(lblDica, null);
			jContentPane.add(jLabel, null);
		}
		return jContentPane;
	}
	
	private JTextField getTxtNome() {
		if (txtNome == null) {
			txtNome = new JTextField();
			txtNome.setBounds(new Rectangle(113, 9, 402, 26));
			txtNome.setDocument(new business.NumeroMaximoCaracteres(30));
		}
		return txtNome;
	}

	
	private JTextField getTxtEndereco() {
		if (txtEndereco == null) {
			txtEndereco = new JTextField();
			txtEndereco.setBounds(new Rectangle(114, 51, 400, 26));
			txtEndereco.setDocument(new business.NumeroMaximoCaracteres(30));
		}
		return txtEndereco;
	}

	
	private JTextField getTxtCodigo() {
		if (txtCodigo == null) {
			txtCodigo = Maskara.getMascara("########");
			txtCodigo.setBounds(new Rectangle(113, 208, 201, 27));
		}
		return txtCodigo;
	}

	
	private JTextField getTxtComplemento() {
		if (txtComplemento == null) {
			txtComplemento = new JTextField();
			txtComplemento.setBounds(new Rectangle(115, 91, 398, 26));
			txtComplemento.setDocument(new business.NumeroMaximoCaracteres(30));
		}
		return txtComplemento;
	}

	
	private JTextField getTxtCidade() {
		if (txtCidade == null) {
			txtCidade = new JTextField();
			txtCidade.setBounds(new Rectangle(113, 168, 202, 27));
			txtCidade.setDocument(new business.NumeroMaximoCaracteres(30));
		}
		return txtCidade;
	}

	
	private JTextField getTxtBairro() {
		if (txtBairro == null) {
			txtBairro = new JTextField();
			txtBairro.setBounds(new Rectangle(115, 130, 397, 25));
			txtBairro.setDocument(new business.NumeroMaximoCaracteres(15));
		}
		return txtBairro;
	}

	
	private JTextField getTxtFone() {
		if (txtFone == null) {
			txtFone = Maskara.getMascara("##########");
			txtFone.setBounds(new Rectangle(391, 207, 119, 26));
		}
		return txtFone;
	}

	
	private JComboBox getCboxTipo() {
		if (cboxTipo == null) {
			String[] items={"Unidade de saude","Unidade Mista"};
			cboxTipo = new JComboBox(items);
			cboxTipo.setBounds(new Rectangle(119, 250, 195, 25));
			cboxTipo.setEditable(false);
		}
		return cboxTipo;
	}

	
	private JTextField getTxtCep() {
		if (txtCep == null) {
			txtCep = Maskara.getMascara("########");
			txtCep.setBounds(new Rectangle(388, 168, 123, 26));
		}
		return txtCep;
	}

	
	private JButton getBtnCadastrar() {
		if (btnCadastrar == null) {
			btnCadastrar = new JButton();
			btnCadastrar.setBounds(new Rectangle(36, 300, 125, 29));
			btnCadastrar.setIcon(new ImageIcon(getClass().getResource("/imagens/salvar.png")));
			btnCadastrar.setText("Cadastrar");
			btnCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					try{
						Unidades unidadeAuxi,unidade= new Unidades();
						unidade.setBairro(txtBairro.getText());
						unidade.setCep(txtCep.getText());
						unidade.setCidade(txtCidade.getText());
						unidade.setCnes(txtCodigo.getText());
						unidade.setComplemento(txtComplemento.getText());
						unidade.setFone(txtFone.getText());
						unidade.setLogradouro(txtEndereco.getText());
						unidade.setNomeResponsavel(txtNome.getText());
						unidade.setTipoUnidade(cboxTipo.getSelectedItem().toString());
						String valida=Fachada.getInstancia().validarUnidade(unidade);
					if(valida!=null)
						JOptionPane.showMessageDialog(null, valida);
					else{
						unidadeAuxi=Fachada.getInstancia().pegarUnidade(unidade);
						if(unidadeAuxi==null){
							if(Fachada.getInstancia().inserirUnidade(unidade)){
								CadastrarUnidade.this.limparDados();
								JOptionPane.showMessageDialog(null, "Unidade cadastrada com sucesso!");
							}
							else
								JOptionPane.showMessageDialog(null, "Falha no cadastro da unidade!");
						}
						else {
							JOptionPane.showMessageDialog(null, "Unidade já está cadastrada!\n" +
								"Responsável: "+unidadeAuxi.getNomeResponsavel());
							CadastrarUnidade.this.limparDados();
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
			btnCancelar.setBounds(new Rectangle(191, 300, 115, 30));
			btnCancelar.setIcon(new ImageIcon(getClass().getResource("/imagens/cancelar.png")));
			btnCancelar.setText("Cancelar");
			btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					try{
					CadastrarUnidade.this.dispose();
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
			btnLimpar.setBounds(new Rectangle(337, 300, 108, 29));
			btnLimpar.setIcon(new ImageIcon(getClass().getResource("/imagens/limpar.png")));
			btnLimpar.setText("Limpar");
			btnLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					try{
					CadastrarUnidade.this.limparDados();
					}catch (Exception farmacia) {
						JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado\n" +
								"por favor contate o administrador do sistema!","Farmacia",JOptionPane.ERROR_MESSAGE,null);
					}
				}
			});
		}
		return btnLimpar;
	}
	//------------------------METODOS FATORADOS
	
	//limpa os dados dos campos da tela
	public void limparDados(){
		this.txtBairro.setText(null);
		this.txtCep.setText(null);
		this.txtCidade.setText(null);
		this.txtCodigo.setText(null);
		this.txtComplemento.setText(null);
		this.txtEndereco.setText(null);
		this.txtFone.setText(null);
		this.txtNome.setText(null);
	}
	

}  
