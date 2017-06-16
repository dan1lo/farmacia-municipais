package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.Rectangle;

import javax.swing.JDialog;

import business.Fachada;
import business.Medicamentos;

public class TelaCadMedicamentos extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel lblNome = null;
	private JTextField edtNome = null;
	private JLabel lblGrupo = null;
	private JTextField edtGrupo = null;  //  @jve:decl-index=0:visual-constraint="572,3"
	private JLabel lblQuant = null;
	private JTextField edtQuant = null;
	private JLabel lblTipo = null;
	private JTextField edtTipo = null;
	private JButton btnMandar = null;
	private JButton Limpar = null;
	/**
	 * @param owner
	 */
	public TelaCadMedicamentos(Frame owner) {
		super(owner);
		//initialize();
		this.setTitle("Cadastro De Medicamentos");
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setModal(true);
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
		
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lblTipo = new JLabel();
			lblTipo.setBounds(new Rectangle(28, 87, 104, 19));
			lblTipo.setText("Tipo de Solução");
			lblQuant = new JLabel();
			lblQuant.setBounds(new Rectangle(350, 55, 66, 16));
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

			
		}
		return jContentPane;
	}
	private JTextField getEdtNome() {
		if (edtNome == null) {
			edtNome = new JTextField();
			edtNome.setBounds(new Rectangle(96, 25, 233, 20));
			edtNome.setDocument(new business.NumeroMaximoCaracteres(30));
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
			edtGrupo.setDocument(new business.NumeroMaximoCaracteres(20));
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
			edtTipo.setDocument(new business.NumeroMaximoCaracteres(40));
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
			btnMandar.setText("Enviar");
			btnMandar.setIcon(new ImageIcon(getClass().getResource("/imagens/action_add.png")));
			btnMandar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					try{if ((edtNome.getText().equals("")) || (edtQuant.getText().equals(""))||(edtGrupo.getText().equals(""))||(edtTipo.getText().equals(""))){
						JOptionPane.showMessageDialog(null, "Algum campo está vazio", "Farmacias Municipais", JOptionPane.INFORMATION_MESSAGE, null);
					}else{
						Medicamentos medicamento = new Medicamentos();
						medicamento.setNome(edtNome.getText());
						medicamento.setGrupo(edtGrupo.getText());
						medicamento.setSolucao(edtTipo.getText());
					 	int quantidade = Integer.parseInt(edtQuant.getText());
						medicamento.setQuant(quantidade);
						Fachada.getInstancia().criarMedicamentos(medicamento);
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
	public void abrirtela(){
		initialize();
	}
		
	

}
