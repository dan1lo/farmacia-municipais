package view;

import javax.swing.JPanel;
import java.awt.Frame;
import javax.swing.JDialog;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.text.MaskFormatter;

import business.Fachada;
import business.Fornecedor;
import java.awt.Color;

public class CadastrarFornecedor extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel lblCnpj = null;
	private JTextField edtCnpj = null;
	private JLabel lblRazao_social = null;
	private JTextField edtRazao_social = null;
	private JLabel lblNome_fantasia = null;
	private JTextField edtNome_fantasia = null;
	private JLabel lblLogradouro = null;
	private JTextField edtLogradouro = null;
	private JLabel lblNumero = null;
	private JTextField edtNumero = null;
	private JLabel lblCep = null;
	private JTextField edtCep = null;
	private JLabel lblCidade = null;
	private JTextField edtCidade = null;
	private JLabel lblBairro = null;
	private JTextField edtBairro = null;
	private JLabel lblEmail = null;
	private JTextField edtEmail = null;
	private JLabel lblTelefone = null;
	private JTextField edtTelefone = null;
	private JButton btnCadastrar = null;
	private JButton btnLimpar = null;
	private JButton btnSair = null;
	private JButton btnAlterar = null;

	
	public MaskFormatter setMascara(String mascara){  
		MaskFormatter mask = null;  
		try{  
			mask = new MaskFormatter(mascara); 
			mask.setPlaceholderCharacter('_'); 
		}catch(java.text.ParseException ex){}  
		return mask;  
	}
	
	
	public CadastrarFornecedor() {
		super();
		initialize();
	}
	
	public CadastrarFornecedor(Frame owner) {
		super(owner);
		initialize();
	}

	
	public void abrircadastro(){
		this.setVisible(true);
	}
	
	
	Fornecedor fornecedorAlterar = new Fornecedor(); 
	
	public void abrir (Fornecedor fornecedor,String cnpjalterar){
		this.setTitle("Alteração de Programa");
		btnCadastrar.setVisible(false);
		fornecedorAlterar.setCnpj(cnpjalterar);
		System.out.println("Erro aki 1");
		edtBairro.setText(fornecedor.getBairro());
		System.out.println("Erro aki 2");
		edtCep.setText(fornecedor.getCep());
		System.out.println("Erro aki 2");
		edtCidade.setText(fornecedor.getCidade());
		edtCnpj.setText(fornecedor.getCnpj());
		edtEmail.setText(fornecedor.getEmail());
		edtLogradouro.setText(fornecedor.getLogradouro());
		edtNome_fantasia.setText(fornecedor.getNome_fantasia());
		edtNumero.setText(fornecedor.getNumero());
		edtRazao_social.setText(fornecedor.getRazao_social());
		edtTelefone.setText(fornecedor.getTelefone());
		edtCnpj.setEnabled(false);
		edtCnpj.setBackground(Color.gray);
		this.setModal(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setTitle("Alteração de Fornecedor");
		
	}
	
	private void initialize() {
		this.setSize(527, 253);
		this.setContentPane(getJContentPane());
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setVisible(true);
		this.setTitle("Cadastro de Fornecedor");
	}

	
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lblTelefone = new JLabel();
			lblTelefone.setBounds(new Rectangle(192, 107, 52, 16));
			lblTelefone.setText("Telefone:");
			lblEmail = new JLabel();
			lblEmail.setBounds(new Rectangle(15, 107, 38, 16));
			lblEmail.setText("E-mail:");
			lblBairro = new JLabel();
			lblBairro.setBounds(new Rectangle(142, 76, 45, 16));
			lblBairro.setText("Bairro:");
			lblCidade = new JLabel();
			lblCidade.setBounds(new Rectangle(316, 76, 46, 16));
			lblCidade.setText("Cidade:");
			lblCep = new JLabel();
			lblCep.setBounds(new Rectangle(15, 76, 38, 16));
			lblCep.setText("CEP:");
			lblNumero = new JLabel();
			lblNumero.setBounds(new Rectangle(451, 47, 17, 16));
			lblNumero.setText("Nº");
			lblLogradouro = new JLabel();
			lblLogradouro.setBounds(new Rectangle(251, 46, 61, 16));
			lblLogradouro.setText("Endereço:");
			lblNome_fantasia = new JLabel();
			lblNome_fantasia.setBounds(new Rectangle(15, 46, 87, 16));
			lblNome_fantasia.setText("Nome Fantasia:");
			lblRazao_social = new JLabel();
			lblRazao_social.setBounds(new Rectangle(210, 17, 80, 16));
			lblRazao_social.setText("Razão Social:");
			lblCnpj = new JLabel();
			lblCnpj.setBounds(new Rectangle(16, 17, 38, 16));
			lblCnpj.setText("CNPJ:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(lblCnpj, null);
			jContentPane.add(getEdtCnpj(), null);
			jContentPane.add(lblRazao_social, null);
			jContentPane.add(getEdtRazao_social(), null);
			jContentPane.add(lblNome_fantasia, null);
			jContentPane.add(getEdtNome_fantasia(), null);
			jContentPane.add(lblLogradouro, null);
			jContentPane.add(getEdtLogradouro(), null);
			jContentPane.add(lblNumero, null);
			jContentPane.add(getEdtNumero(), null);
			jContentPane.add(lblCep, null);
			jContentPane.add(getEdtCep(), null);
			jContentPane.add(lblCidade, null);
			jContentPane.add(getEdtCidade(), null);
			jContentPane.add(lblBairro, null);
			jContentPane.add(getEdtBairro(), null);
			jContentPane.add(lblEmail, null);
			jContentPane.add(getEdtEmail(), null);
			jContentPane.add(lblTelefone, null);
			jContentPane.add(getEdtTelefone(), null);
			jContentPane.add(getBtnCadastrar(), null);
			jContentPane.add(getBtnLimpar(), null);
			jContentPane.add(getBtnSair(), null);
			jContentPane.add(getBtnAlterar(), null);
		}
		return jContentPane;
	}

	
	private JTextField getEdtCnpj() {
		if (edtCnpj == null) {
			edtCnpj = new JTextField();
			edtCnpj.setBounds(new Rectangle(55, 12, 125, 20));
			edtCnpj = new JFormattedTextField(setMascara("##.###.###/####-##"));
			edtCnpj.setBounds(new Rectangle(60, 15, 125, 20));
			edtCnpj.setBackground(Color.white);
			edtCnpj.setEnabled(true);
		}
		return edtCnpj;
	}

	
	private JTextField getEdtRazao_social() {
		if (edtRazao_social == null) {
			edtRazao_social = new JTextField();
			edtRazao_social.setBounds(new Rectangle(298, 15, 199, 20));
		}
		return edtRazao_social;
	}

	
	private JTextField getEdtNome_fantasia() {
		if (edtNome_fantasia == null) {
			edtNome_fantasia = new JTextField();
			edtNome_fantasia.setBounds(new Rectangle(104, 44, 135, 20));
		}
		return edtNome_fantasia;
	}

	
	private JTextField getEdtLogradouro() {
		if (edtLogradouro == null) {
			edtLogradouro = new JTextField();
			edtLogradouro.setBounds(new Rectangle(314, 44, 134, 20));
		}
		return edtLogradouro;
	}

	
	private JTextField getEdtNumero() {
		if (edtNumero == null) {
			edtNumero = new JTextField();
			edtNumero.setBounds(new Rectangle(473, 45, 24, 20));
		}
		return edtNumero;
	}

	
	private JTextField getEdtCep() {
		if (edtCep == null) {
			edtCep = new JTextField();
			edtCep.setBounds(new Rectangle(48, 75, 81, 20));
		}
		return edtCep;
	}

	
	private JTextField getEdtCidade() {
		if (edtCidade == null) {
			edtCidade = new JTextField();
			edtCidade.setBounds(new Rectangle(364, 75, 117, 20));
		}
		return edtCidade;
	}

	
	private JTextField getEdtBairro() {
		if (edtBairro == null) {
			edtBairro = new JTextField();
			edtBairro.setBounds(new Rectangle(183, 75, 116, 20));
		}
		return edtBairro;
	}

	
	private JTextField getEdtEmail() {
		if (edtEmail == null) {
			edtEmail = new JTextField();
			edtEmail.setBounds(new Rectangle(61, 105, 120, 20));
		}
		return edtEmail;
	}

	
	private JTextField getEdtTelefone() {
		if (edtTelefone == null) {
			edtTelefone = new JTextField();
			edtTelefone = new JFormattedTextField(setMascara("####-####"));
			edtTelefone.setBounds(new Rectangle(247, 105, 117, 20));
		}
		return edtTelefone;
	}

	
	private JButton getBtnCadastrar() {
		if (btnCadastrar == null) {
			btnCadastrar = new JButton();
			btnCadastrar.setLocation(new Point(31, 158));
			btnCadastrar.setIcon(new ImageIcon(getClass().getResource("/imagens/action_add.png")));
			btnCadastrar.setText("Cadastrar");
			btnCadastrar.setSize(new Dimension(112, 32));
			btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if((edtBairro.getText().equals(""))||(edtCep.getText().equals(""))||(edtCidade.getText().equals(""))||(edtCnpj.getText().equals(""))||(edtEmail.getText().equals(""))||(edtLogradouro.getText().equals(""))||(edtNome_fantasia.getText().equals(""))||(edtNumero.getText().equals(""))||(edtRazao_social.getText().equals(""))||(edtTelefone.getText().equals(""))){
						JOptionPane.showMessageDialog(null, "Algum campo está vazio", "Farmácia Municipal", JOptionPane.INFORMATION_MESSAGE, null);
					}
					else{
						Fornecedor fornecedor = new Fornecedor();
						
						fornecedor.setBairro(edtBairro.getText());
						fornecedor.setCep(edtCep.getText());
						fornecedor.setCidade(edtCidade.getText());
						fornecedor.setCnpj(edtCnpj.getText());
						fornecedor.setEmail(edtEmail.getText());
						fornecedor.setLogradouro(edtLogradouro.getText());
						fornecedor.setNome_fantasia(edtNome_fantasia.getText());
						fornecedor.setNumero(edtNumero.getText());
						fornecedor.setRazao_social(edtRazao_social.getText());
						fornecedor.setTelefone(edtTelefone.getText());
						
						String telefone1 = edtTelefone.getText();
						String cpnj1 = edtCnpj.getText();
						
						System.out.println(telefone1);
						System.out.println(cpnj1);
						
						Fachada.getInstancia().inserirFornecedor(fornecedor);
						
						JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso", "Farmácia Municipal", JOptionPane.INFORMATION_MESSAGE, null);
						dispose();
					}
				}
			});
		}
		return btnCadastrar;
	}

	
	
	//-----Função Limpar
	
	public void limpar(){
		edtBairro.setText("");
		edtCep.setText("");
		edtCidade.setText("");
		edtCnpj.setText(null);
		edtEmail.setText("");
		edtLogradouro.setText("");
		edtNome_fantasia.setText("");
		edtNumero.setText("");
		edtRazao_social.setText("");
		edtTelefone.setText(null);
		JOptionPane.showMessageDialog(null, "Limpeza execuda com sucesso", "Farmácia Municipal", JOptionPane.INFORMATION_MESSAGE, null);
	}
	
	private JButton getBtnLimpar() {
		if (btnLimpar == null) {
			btnLimpar = new JButton();
			btnLimpar.setLocation(new Point(158, 158));
			btnLimpar.setIcon(new ImageIcon(getClass().getResource("/imagens/limpar.png")));
			btnLimpar.setText("Limpar");
			btnLimpar.setSize(new Dimension(112, 32));
			btnLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					limpar();
				}
			});
		}
		return btnLimpar;
	}

	
	private JButton getBtnSair() {
		if (btnSair == null) {
			btnSair = new JButton();
			btnSair.setLocation(new Point(286, 158));
			btnSair.setIcon(new ImageIcon(getClass().getResource("/imagens/sair.png")));
			btnSair.setText("Sair");
			btnSair.setSize(new Dimension(112, 32));
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

	
	private JButton getBtnAlterar() {
		if (btnAlterar == null) {
			btnAlterar = new JButton();
			btnAlterar.setIcon(new ImageIcon(getClass().getResource("/imagens/alterar.png")));
			btnAlterar.setBounds(new Rectangle(31, 158, 112, 32));
			btnAlterar.setText("Alterar");
			btnAlterar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if ((edtBairro.getText().equals(""))||(edtCep.getText().equals(""))||(edtCidade.getText().equals(""))||(edtCnpj.getText().equals(""))||(edtEmail.getText().equals(""))||(edtLogradouro.getText().equals(""))||(edtNome_fantasia.getText().equals(""))||(edtNumero.getText().equals(""))||(edtRazao_social.getText().equals(""))||(edtTelefone.getText().equals(""))){
						JOptionPane.showMessageDialog(null, "Campo Vazio", "Farmacias Municipais", JOptionPane.INFORMATION_MESSAGE, null);
					}
					else{
						//Fornecedor fornecedorAlterar = new Fornecedor();
						
						fornecedorAlterar.setBairro(edtBairro.getText());
						fornecedorAlterar.setCep(edtCep.getText());
						fornecedorAlterar.setCidade(edtCidade.getText());
						//fornecedorAlterar.setCnpj(edtCnpj.getText());
						fornecedorAlterar.setEmail(edtEmail.getText());
						fornecedorAlterar.setLogradouro(edtLogradouro.getText());
						fornecedorAlterar.setNome_fantasia(edtNome_fantasia.getText());
						fornecedorAlterar.setNumero(edtNumero.getText());
						fornecedorAlterar.setRazao_social(edtRazao_social.getText());
						fornecedorAlterar.setTelefone(edtTelefone.getText());
						
						
						
						Fachada.getInstancia().atualizarFornecedor(fornecedorAlterar);
						JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!", "Farmacia Municipal", JOptionPane.INFORMATION_MESSAGE, null);
						dispose();
						
					}
				}
			});
		}
		return btnAlterar;
	}

}
