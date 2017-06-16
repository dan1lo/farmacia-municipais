package view;




import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.ImageIcon;

import business.Fachada;
import business.Programa;

public class CadastrarPrograma extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel lblNome = null;
	private JLabel lblDescricao = null;
	private JTextField edtNome = null;
	private JTextField edtDescricao = null;
	private JButton btnCadastrar = null;
	private JButton btnLimpar = null;
	private JButton btnSair = null;
	private JButton btnAlterar = null;

	/**
	 * This is the default constructor
	 */
	public CadastrarPrograma() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	
	Programa programaAlterar = new Programa();  //  @jve:decl-index=0:
	
	public void abrir (Programa programa,int codigoalterar){
		this.setTitle("Alteração de Programa");
		btnCadastrar.setVisible(false);
		programaAlterar.setCod_prog(codigoalterar);
		edtNome.setText(programa.getNome());
		edtDescricao.setText(programa.getText());
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setModal(true);
		
	}
	
	public void abrircadastro(){
		this.setVisible(true);
		
	}
	
	private void initialize() {
		this.setLocationRelativeTo(null);
		this.setSize(327, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("Cadastro de Programa");
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setVisible(true);
		
	}
	
	public void limpar(){
		edtDescricao.setText("");
		edtNome.setText("");
		JOptionPane.showMessageDialog(null, "Limpeza execuda com sucesso", "Farmácia Municipal", JOptionPane.INFORMATION_MESSAGE, null);
	}
	
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lblDescricao = new JLabel();
			lblDescricao.setBounds(new Rectangle(19, 57, 65, 16));
			lblDescricao.setText("Descrição:");
			lblNome = new JLabel();
			lblNome.setBounds(new Rectangle(45, 23, 38, 16));
			lblNome.setText("Nome:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(lblNome, null);
			jContentPane.add(lblDescricao, null);
			jContentPane.add(getEdtNome(), null);
			jContentPane.add(getEdtDescricao(), null);
			jContentPane.add(getBtnCadastrar(), null);
			jContentPane.add(getBtnLimpar(), null);
			jContentPane.add(getBtnSair(), null);
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
			edtNome.setBounds(new Rectangle(94, 23, 203, 20));
		}
		return edtNome;
	}

	/**
	 * This method initializes edtDescricao	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getEdtDescricao() {
		if (edtDescricao == null) {
			edtDescricao = new JTextField();
			edtDescricao.setBounds(new Rectangle(95, 58, 202, 20));
		}
		return edtDescricao;
	}

	/**
	 * This method initializes btnCadastrar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnCadastrar() {
		if (btnCadastrar == null) {
			btnCadastrar = new JButton();
			btnCadastrar.setBounds(new Rectangle(3, 110, 115, 33));
			btnCadastrar.setIcon(new ImageIcon(getClass().getResource("/imagens/action_add.png")));
			btnCadastrar.setText("Cadastrar");
			btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					try{
						if ((edtNome.getText().equals(""))|| (edtDescricao.getText().equals(""))){
							JOptionPane.showMessageDialog(null, "Algum campo está vazio", "Farmacias Municipais", JOptionPane.INFORMATION_MESSAGE, null);
						}
						else{
						Programa programa = new Programa();
						
						programa.setNome(edtNome.getText());
						programa.setText(edtDescricao.getText());
						
						Fachada.getInstancia().inserirPrograma(programa);
						System.out.println("Fachada Executada");
						JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso", "Farmacia Municipal", JOptionPane.INFORMATION_MESSAGE, null);
						dispose();
						}
					}
					catch(Exception e2){
						e2.printStackTrace();
						JOptionPane.showMessageDialog(null, "Erro no cadastro, contate o desenvolvedor", "Farmacia Municipal", JOptionPane.ERROR_MESSAGE, null);
					}
				}
			});
		}
		return btnCadastrar;
	}

	/**
	 * This method initializes btnLimpar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnLimpar() {
		if (btnLimpar == null) {
			btnLimpar = new JButton();
			btnLimpar.setLocation(new Point(123, 110));
			btnLimpar.setText("Limpar");
			btnLimpar.setIcon(new ImageIcon(getClass().getResource("/imagens/limpar.png")));
			btnLimpar.setSize(new Dimension(102, 33));
			btnLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					limpar();
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
			btnSair = new JButton();
			btnSair.setLocation(new Point(229, 110));
			btnSair.setText("Sair");
			btnSair.setIcon(new ImageIcon(getClass().getResource("/imagens/sair.png")));
			btnSair.setSize(new Dimension(87, 33));
			btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					try{
						int opcao;
						
						Object[] botoes = {"Sim", "Não"};
						
						opcao = JOptionPane.showOptionDialog(null, "Deseja realmente Sair","Sim",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE, null, botoes,botoes[0]);
						
						if(opcao == JOptionPane.YES_OPTION){
						dispose();
						System.out.println("Sair"); 
						}
					}
					catch (Exception e1){
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Não foi possível fechar a janela,tente novamente", "Farmacia Municipal", JOptionPane.INFORMATION_MESSAGE, null);
					}
					// TODO Auto-generated Event stub mouseClicked()
				}
			});
		}
		return btnSair;
	}

	/**
	 * This method initializes btnAlterar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnAlterar() {
		if (btnAlterar == null) {
			btnAlterar = new JButton();
			btnAlterar.setText("Alterar");
			btnAlterar.setBounds(new Rectangle(6, 110, 112, 32));
			btnAlterar.setIcon(new ImageIcon(getClass().getResource("/imagens/alterar.png")));
			btnAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if((edtNome.getText().equals("")) || (edtDescricao.getText().equals(""))){
						JOptionPane.showMessageDialog(null, "Campo Vazio", "Farmacia Municipal", JOptionPane.INFORMATION_MESSAGE, null);
					}
					else{
					programaAlterar.setNome(edtNome.getText());
					programaAlterar.setText(edtDescricao.getText());
					
					Fachada.getInstancia().atualizarPrograma(programaAlterar);
					JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!", "Farmacia Municipal", JOptionPane.INFORMATION_MESSAGE, null);
					dispose();
					}
				}
			});
		}
		return btnAlterar;
	}

}  //  @jve:decl-index=0:visual-constraint="67,15"
