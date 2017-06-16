package view;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import business.Fachada;
import business.Paciente;
import business.Programa;

import javax.swing.JComboBox;
import javax.swing.text.MaskFormatter;

public class CadastrarPaciente extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTextField edtNome = null;
	private JLabel jLabel = null;
	private JTextField edtCpf = null;
	private JLabel jLabel1 = null;
	private JTextField edtRg = null;
	private JLabel jLabel2 = null;
	private JTextField edtOrgao = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JTextField edtEmissao = null;
	private JLabel jLabel5 = null;
	private JTextField edtSexo = null;
	private JButton Cadastrar = null;
	private JLabel jLabel6 = null;
	private JTextField edtNascimento = null;
	private JLabel jLabel7 = null;
	private JTextField edtIdade = null;
	private JLabel jLabel8 = null;
	private JTextField edtLogradouro = null;
	private JLabel jLabel9 = null;
	private JTextField edtNumero = null;
	private JLabel jLabel10 = null;
	private JTextField edtBairro = null;
	private JLabel jLabel11 = null;
	private JTextField edtCidade = null;
	private JLabel jLabel12 = null;
	private JTextField edtCEP = null;
	private JLabel jLabel13 = null;
	private JTextField edtInclussao = null;
	private JButton btnLimpar = null;
	private JButton btnSair = null;
	private JComboBox cbxPrograma = null;
	private JLabel lblPrograma = null;
	private JButton btnAlterar = null;
	/**
	 * This is the default constructor
	 */
	public CadastrarPaciente() {
		super();
		initialize();
	}

	// ----- Mascara
	public MaskFormatter setMascara(String mascara){  
		MaskFormatter mask = null;  
		try{  
			mask = new MaskFormatter(mascara); 
			mask.setPlaceholderCharacter('_'); 
		}catch(java.text.ParseException ex){}  
		return mask;  
	}
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(630, 285);
		this.setContentPane(getJContentPane());
		this.setTitle("Cadastrar Paciente");
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setVisible(true);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lblPrograma = new JLabel("Programa:");
			lblPrograma.setBounds(new Rectangle(281, 165, 70, 16));
			jLabel13 = new JLabel();
			jLabel13.setBounds(new Rectangle(15, 165, 108, 16));
			jLabel13.setText("Data de Inclussão:");
			jLabel12 = new JLabel();
			jLabel12.setBounds(new Rectangle(443, 135, 38, 16));
			jLabel12.setText("CEP:");
			jLabel11 = new JLabel();
			jLabel11.setBounds(new Rectangle(227, 137, 51, 16));
			jLabel11.setText("Cidade:");
			jLabel10 = new JLabel();
			jLabel10.setBounds(new Rectangle(16, 136, 44, 16));
			jLabel10.setText("Bairro:");
			jLabel9 = new JLabel();
			jLabel9.setBounds(new Rectangle(490, 105, 53, 16));
			jLabel9.setText("Número:");
			jLabel8 = new JLabel();
			jLabel8.setBounds(new Rectangle(16, 105, 64, 16));
			jLabel8.setText("Endereço:");
			jLabel7 = new JLabel();
			jLabel7.setBounds(new Rectangle(539, 74, 38, 16));
			jLabel7.setText("Idade:");
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(309, 76, 126, 16));
			jLabel6.setText("Data de Nascimento:");
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(225, 75, 38, 16));
			jLabel5.setText("Sexo:");
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(15, 74, 105, 16));
			jLabel4.setText("Data de Emissão:");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(463, 45, 38, 16));
			jLabel3.setText("Orgão:");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(239, 45, 38, 16));
			jLabel2.setText("RG:");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(15, 45, 38, 16));
			jLabel1.setText("CPF:");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(13, 15, 38, 16));
			jLabel.setText("Nome:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getEdtNome(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getEdtCpf(), null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(getEdtRg(), null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(getEdtOrgao(), null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(jLabel4, null);
			jContentPane.add(getEdtEmissao(), null);
			jContentPane.add(jLabel5, null);
			jContentPane.add(getEdtSexo(), null);
			jContentPane.add(getCadastrar(), null);
			jContentPane.add(jLabel6, null);
			jContentPane.add(getEdtNascimento(), null);
			jContentPane.add(jLabel7, null);
			jContentPane.add(getEdtIdade(), null);
			jContentPane.add(jLabel8, null);
			jContentPane.add(getEdtLogradouro(), null);
			jContentPane.add(jLabel9, null);
			jContentPane.add(getEdtNumero(), null);
			jContentPane.add(jLabel10, null);
			jContentPane.add(getEdtBairro(), null);
			jContentPane.add(jLabel11, null);
			jContentPane.add(getEdtCidade(), null);
			jContentPane.add(jLabel12, null);
			jContentPane.add(getEdtCEP(), null);
			jContentPane.add(jLabel13, null);
			jContentPane.add(getEdtInclussao(), null);
			jContentPane.add(getBtnLimpar(), null);
			jContentPane.add(getBtnSair(), null);
			jContentPane.add(getCbxPrograma(), null);
			jContentPane.add(lblPrograma, null);
			jContentPane.add(getBtnAlterar(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes edtNome	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getEdtNome() {
		if (edtNome == null) {
			edtNome = new JTextField();
			edtNome.setBounds(new Rectangle(61, 14, 547, 20));
		}
		return edtNome;
	}

	/**
	 * This method initializes edtCpf	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getEdtCpf() {
		if (edtCpf == null) {
			edtCpf = new JTextField();
			edtCpf = new JFormattedTextField(setMascara("###.###.###-##"));
			edtCpf.setBounds(new Rectangle(61, 44, 159, 20));
		}
		return edtCpf;
	}

	/**
	 * This method initializes edtRg	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getEdtRg() {
		if (edtRg == null) {
			edtRg = new JTextField();
			edtRg.setBounds(new Rectangle(286, 43, 156, 20));
		}
		return edtRg;
	}

	/**
	 * This method initializes edtOrgao	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getEdtOrgao() {
		if (edtOrgao == null) {
			edtOrgao = new JTextField();
			edtOrgao.setBounds(new Rectangle(512, 43, 96, 20));
		}
		return edtOrgao;
	}

	/**
	 * This method initializes edtEmissao	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getEdtEmissao() {
		if (edtEmissao == null) {
			edtEmissao = new JTextField();
			edtEmissao = new JFormattedTextField(setMascara("##/##/####"));
			edtEmissao.setBounds(new Rectangle(128, 73, 92, 20));
		}
		return edtEmissao;
	}

	/**
	 * This method initializes edtSexo	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getEdtSexo() {
		if (edtSexo == null) {
			edtSexo = new JTextField();
			edtSexo.setBounds(new Rectangle(271, 74, 29, 20));
		}
		return edtSexo;
	}

	/**
	 * This method initializes Cadastrar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCadastrar() {
		if (Cadastrar == null) {
			Cadastrar = new JButton("Cadastrar");
			Cadastrar.setBounds(new Rectangle(18, 198, 161,44));
			Cadastrar.setIcon(new ImageIcon(getClass().getResource("/imagens/action_add.png")));
			Cadastrar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					if (edtBairro.getText().equals("")||edtCEP.getText().equals("")||edtCidade.getText().equals("")||edtCpf.getText().equals("")||edtEmissao.getText().equals("")||edtIdade.getText().equals("")||edtInclussao.getText().equals("")||edtLogradouro.getText().equals("")||edtNascimento.getText().equals("")||edtNome.getText().equals("")||edtNumero.getText().equals("")||edtOrgao.getText().equals("")||edtRg.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Campo Vazio", "Farmacia Municipal", JOptionPane.INFORMATION_MESSAGE, null);
					}
					else{
					String nome, cpf_paci, rg, orgao, data_emisao, sexo, data_nascimento, idade, logradouro, numero, bairro, cidade, cep, data_inclusao, nome_user, cnes;
					nome=edtNome.getText();
					cpf_paci=edtCpf.getText();
					rg=edtRg.getText();
					orgao=edtOrgao.getText();
					data_emisao=edtEmissao.getText();
					sexo=edtSexo.getText();
					data_nascimento=edtNascimento.getText();
					idade=edtIdade.getText();
					logradouro=edtLogradouro.getText();
					numero=edtNumero.getText();
					bairro=edtBairro.getText();
					cidade=edtCidade.getText();
					cep=edtCEP.getText();
					data_inclusao=edtInclussao.getText();
					
					Fachada.getInstancia().CadastrarPaciente(nome, cpf_paci, rg, orgao, data_emisao, sexo, data_nascimento, idade, logradouro, numero, bairro, cidade, cep, data_inclusao, "Marola", "2319284");
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso", "Farmacia Municipal", JOptionPane.INFORMATION_MESSAGE, null);
					dispose();
					}
					
				}
			});
			}
		return Cadastrar;
	}

	/**
	 * This method initializes edtNascimento	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getEdtNascimento() {
		if (edtNascimento == null) {
			edtNascimento = new JTextField();
			edtNascimento = new JFormattedTextField(setMascara("##/##/####"));
			edtNascimento.setBounds(new Rectangle(435, 73, 96, 20));
		}
		return edtNascimento;
	}

	/**
	 * This method initializes edtIdade	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getEdtIdade() {
		if (edtIdade == null) {
			edtIdade = new JTextField();
			edtIdade.setBounds(new Rectangle(580, 72, 28, 20));
		}
		return edtIdade;
	}

	/**
	 * This method initializes edtLogradouro	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getEdtLogradouro() {
		if (edtLogradouro == null) {
			edtLogradouro = new JTextField();
			edtLogradouro.setBounds(new Rectangle(87, 104, 390, 20));
		}
		return edtLogradouro;
	}

	/**
	 * This method initializes edtNumero	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getEdtNumero() {
		if (edtNumero == null) {
			edtNumero = new JTextField();
			edtNumero.setBounds(new Rectangle(553, 104, 54, 20));
		}
		return edtNumero;
	}

	/**
	 * This method initializes edtBairro	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getEdtBairro() {
		if (edtBairro == null) {
			edtBairro = new JTextField();
			edtBairro.setBounds(new Rectangle(73, 133, 143, 20));
		}
		return edtBairro;
	}

	/**
	 * This method initializes edtCidade	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getEdtCidade() {
		if (edtCidade == null) {
			edtCidade = new JTextField();
			edtCidade.setBounds(new Rectangle(283, 134, 146, 20));
		}
		return edtCidade;
	}

	/**
	 * This method initializes edtCEP	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getEdtCEP() {
		if (edtCEP == null) {
			edtCEP = new JTextField();
			edtCEP = new JFormattedTextField(setMascara("##.###-###"));
			edtCEP.setBounds(new Rectangle(487, 134, 114, 20));
		}
		return edtCEP;
	}

	/**
	 * This method initializes edtInclussao	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getEdtInclussao() {
		if (edtInclussao == null) {
			edtInclussao = new JTextField();
			edtInclussao = new JFormattedTextField(setMascara("##/##/####"));
			edtInclussao.setBounds(new Rectangle(136, 163, 128, 20));
		}
		return edtInclussao;
	}

	/**
	 * This method initializes btnLimpar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	
	public void limpar(){
		edtNome.setText("");
		edtCpf.setText("");
		edtRg.setText("");
		edtOrgao.setText("");
		edtEmissao.setText("");
		edtSexo.setText("");
		edtNascimento.setText("");
		edtIdade.setText("");
		edtLogradouro.setText("");
		edtNumero.setText("");
		edtBairro.setText("");
		edtCidade.setText("");
		edtCEP.setText("");
		edtInclussao.setText("");
	}
	
	private JButton getBtnLimpar() {
		if (btnLimpar == null) {
			btnLimpar = new JButton("Limpar");
			btnLimpar.setBounds(new Rectangle(230, 198, 161, 44));
			btnLimpar.setIcon(new ImageIcon(getClass().getResource("/imagens/limpar.png")));
			btnLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					limpar();
					JOptionPane.showMessageDialog(null, "Limpeza realizada com sucesso!", "Farmárcia Municipal", JOptionPane.INFORMATION_MESSAGE,null);
				}
			});
		}
		return btnLimpar;
	}

	/**
	 * This method initializes btnSair	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnSair() {
		if (btnSair == null) {
			btnSair = new JButton("Sair");
			btnSair.setBounds(new Rectangle(438, 198, 161, 44));
			btnSair.setIcon(new ImageIcon(getClass().getResource("/imagens/sair.png")));
			btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					try {
						int opcao;
						
						Object[] botoes = {"Sim", "Não"};
						
						opcao = JOptionPane.showOptionDialog(null, "Deseja realmente Sair","Sim",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE, null, botoes,botoes[0]);
						
						if(opcao == JOptionPane.YES_OPTION){
						dispose();
						}
					}
					catch (Exception e2){
						e2.printStackTrace();
						JOptionPane.showMessageDialog(null, "Não foi possível fechar a janela,tente novamente", "Farmacia Municipal", JOptionPane.INFORMATION_MESSAGE, null);
					}
					
				}
			});
		}
		return btnSair;
	}

	/**
	 * This method initializes cbxPrograma	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCbxPrograma() {
		if (cbxPrograma == null) {
			cbxPrograma = new JComboBox();
			
			List<Programa> listp;
			listp = Fachada.getInstancia().listarTodosPrograma();
			if(listp!=null){
				int i=listp.size();
				int	j=0;
				while (j<i){
					cbxPrograma.addItem(listp.get(j).getNome());
					j++;
				}
			}
			
			cbxPrograma.setBounds(new Rectangle(349, 165, 132, 20));
			
		}
		return cbxPrograma;
	}

	/**
	 * This method initializes btnAlterar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnAlterar() {
		if (btnAlterar == null) {
			btnAlterar = new JButton("Alterar");
			btnAlterar.setBounds(new Rectangle(18, 198, 161,44));
			btnAlterar.setIcon(new ImageIcon(getClass().getResource("/imagens/alterar.png")));
			btnAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if (edtBairro.getText().equals("")||edtCEP.getText().equals("")||edtCidade.getText().equals("")||edtCpf.getText().equals("")||edtEmissao.getText().equals("")||edtIdade.getText().equals("")||edtInclussao.getText().equals("")||edtLogradouro.getText().equals("")||edtNascimento.getText().equals("")||edtNome.getText().equals("")||edtNumero.getText().equals("")||edtOrgao.getText().equals("")||edtRg.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Campo Vazio", "Farmacia Municipal", JOptionPane.INFORMATION_MESSAGE, null);
					}
					else{
					String nome, cpf_paci, rg, orgao, data_emisao, sexo, data_nascimento, idade, logradouro, numero, bairro, cidade, cep, data_inclusao, nome_user, cnes;
					nome=edtNome.getText();
					cpf_paci=edtCpf.getText();
					rg=edtRg.getText();
					orgao=edtOrgao.getText();
					data_emisao=edtEmissao.getText();
					sexo=edtSexo.getText();
					data_nascimento=edtNascimento.getText();
					idade=edtIdade.getText();
					logradouro=edtLogradouro.getText();
					numero=edtNumero.getText();
					bairro=edtBairro.getText();
					cidade=edtCidade.getText();
					cep=edtCEP.getText();
					data_inclusao=edtInclussao.getText();
					
					Fachada.getInstancia().AtualizarPaciente(nome, cpf_paci, rg, orgao, data_emisao, sexo, data_nascimento, idade, logradouro, numero, bairro, cidade, cep, data_inclusao, "Marola", "2319284");
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso", "Farmacia Municipal", JOptionPane.INFORMATION_MESSAGE, null);
					dispose();
					}
				}
			});
		}
		return btnAlterar;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
