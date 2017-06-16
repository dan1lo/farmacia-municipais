package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.Rectangle;

import javax.swing.JDialog;

import business.Fachada;
import business.Medicamentos;

public class AtualizarDados extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private JPanel jContentPane = null;
	private JLabel lblNome = null;
	private JTextField edtNome = null;
	private JLabel lblGrupo = null;
	private JTextField edtGrupo = null;
	private JLabel lblQuant = null;
	private JTextField edtQuant = null;
	private JLabel lblTipo = null;
	private JTextField edtTipo = null;
	private JButton btnMandar = null;
	private JButton Limpar = null;
	private JLabel lbl_cod = null;
	private JTextField edtCod = null;
	/**
	 * This method initializes this
	 * 
	 */

	/**
	 * @param owner
	 */
	public AtualizarDados(Frame owner) {
		super(owner);
		//initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(550, 229);		
		this.setContentPane(getJContentPane());
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setVisible(true);
		this.setTitle("Atualização de dados");	}
	private void initialize(int codAlterar, String nomeAlterar, int quantAlterar, String grupoAlterar, String tipoAlterar){
	
		this.setSize(550, 229);		
		this.setContentPane(getJContentPane());
		edtNome.setText(nomeAlterar);
    	edtQuant.setText(Integer.toString(quantAlterar));
		edtGrupo.setText(grupoAlterar);
	    edtTipo.setText(tipoAlterar);
		edtCod.setText(Integer.toString(codAlterar));
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setVisible(true);
		this.setTitle("Atualização de dados");
		}
	
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lbl_cod = new JLabel();
			lbl_cod.setBounds(new Rectangle(335, 21, 138, 16));
			lbl_cod.setText("Codigo Medicamento");
			lblTipo = new JLabel();
			lblTipo.setBounds(new Rectangle(28, 87, 104, 19));
			lblTipo.setText("Tipo de Solução");
			lblQuant = new JLabel();
			lblQuant.setBounds(new Rectangle(333, 58, 66, 16));
			lblQuant.setText("Quantidade");
			lblGrupo = new JLabel();
			lblGrupo.setBounds(new Rectangle(31, 59, 38, 16));
			lblGrupo.setText("Grupo");
			lblNome = new JLabel();
			lblNome.setBounds(new Rectangle(31, 29, 38, 16));
			lblNome.setText("Nome");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(lblNome, null);
			jContentPane.add(getEdtNome(), null);
			jContentPane.add(lblGrupo, null);
			jContentPane.add(getEdtGrupo(), null);
			jContentPane.add(lblQuant, null);
			jContentPane.add(getEdtQuant(), null);
			jContentPane.add(lblTipo, null);
			jContentPane.add(getEdtTipo(), null);
			jContentPane.add(getBtnMandar(), null);
			jContentPane.add(getLimpar(), null);
			jContentPane.add(lbl_cod, null);
			jContentPane.add(getEdtCod(), null);
		}
		return jContentPane;
	}
	private JTextField getEdtNome() {
		if (edtNome == null) {
			edtNome = new JTextField();
			edtNome.setBounds(new Rectangle(96, 25, 233, 20));
		}
		return edtNome;
	}

	/**
	 * This method initializes txtGrupo	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getEdtGrupo() {
		if (edtGrupo == null) {
			edtGrupo = new JTextField();
			edtGrupo.setBounds(new Rectangle(95, 57, 233, 20));
		}
		return edtGrupo;
	}


	/**
	 * This method initializes edtQuant	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getEdtQuant() {
		if (edtQuant == null) {
			edtQuant = new JTextField();
			edtQuant.setBounds(new Rectangle(459, 52, 60, 21));
		}
		return edtQuant;
	}

	/**
	 * This method initializes edtTipo	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getEdtTipo() {
		if (edtTipo == null) {
			edtTipo = new JTextField();
			edtTipo.setBounds(new Rectangle(143, 88, 184, 21));
		}
		return edtTipo;
	}

	/**
	 * This method initializes btnMandar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnMandar() {
		if (btnMandar == null) {
			btnMandar = new JButton();
			btnMandar.setBounds(new Rectangle(116, 134, 107, 33));
			btnMandar.setText("Atualizar");
			btnMandar.setIcon(new ImageIcon(getClass().getResource("/imagens/action_add.png")));
			btnMandar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					try{if ((edtNome.getText().equals("")) || (edtQuant.getText().equals(""))||(edtCod.getText().equals(""))||(edtGrupo.getText().equals(""))||(edtTipo.getText().equals(""))){
						JOptionPane.showMessageDialog(null, "Algum campo está vazio", "Farmacias Municipais", JOptionPane.INFORMATION_MESSAGE, null);
					}else{
						
						Medicamentos medicamento = new Medicamentos();
						medicamento.setNome(edtNome.getText());
						medicamento.setGrupo(edtGrupo.getText());
						medicamento.setSolucao(edtTipo.getText());
						medicamento.setCod(edtCod.getText());
					 	medicamento.intQuant(edtQuant.getText());
						Fachada.getInstancia().atualizarMedicamentos(medicamento);
						
						JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso", "Farmacia Municipal", JOptionPane.INFORMATION_MESSAGE, null);
						
					  }
					}
						catch(Exception e2){
							e2.printStackTrace();
							JOptionPane.showMessageDialog(null, "Erro no atualização, contate o desenvolvedor", "Farmacia Municipal", JOptionPane.ERROR_MESSAGE, null);
						}
					}
				});
			}
		return btnMandar;
		}
		

public void LimparTudo(){
	edtNome.setText(null);
	edtGrupo.setText(null);
	edtQuant.setText(null);
	edtTipo.setText(null);
	
}
	/**
	 * This method initializes Limpar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getLimpar() {
		if (Limpar == null) {
			Limpar = new JButton();
			Limpar.setBounds(new Rectangle(264, 135, 101, 33));
			Limpar.setText("Limpar");
			Limpar.setIcon(new ImageIcon(getClass().getResource("/imagens/action_remove.png")));
			Limpar.addMouseListener(new java.awt.event.MouseAdapter(){
				public void mouseClicked(java.awt.event.MouseEvent e){
					LimparTudo();
				}
			});
		}
		return Limpar;
	}

	/**
	 * This method initializes edtCod	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getEdtCod() {
		if (edtCod == null) {
			edtCod = new JTextField();
			edtCod.setBounds(new Rectangle(460, 21, 63, 20));
			edtCod.setText("");
		}
		return edtCod;
	}
	public void abrir (int codAlterar, String nomeAlterar, int quantAlterar, String grupoAlterar, String tipoAlterar){
		initialize(codAlterar, nomeAlterar,quantAlterar,grupoAlterar,tipoAlterar);	
		
	}
	
}
