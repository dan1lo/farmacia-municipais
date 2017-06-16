package view;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.Frame;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Vector;

import javax.swing.JTextField;

import business.Fachada;
import business.Medicamentos;
import business.Paciente;

import javax.swing.JButton;

public class PegarMedicamento extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel lblCPF = null;
	private JLabel lblCodigo = null;
	private JTextField edtCPF = null;
	private JTextField edtCodigo = null;

	private JButton btn_nome = null;
	private JButton btn_remedio = null;
	private JButton btn_confirmar = null;
	private JButton btn_limpar = null;

	/**
	 * @param owner
	 */
	public PegarMedicamento(Frame owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(684, 310);
		this.setContentPane(getJContentPane());
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setVisible(true);
		this.setTitle("Pegar Medicamento");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lblCodigo = new JLabel();
			lblCodigo.setBounds(new Rectangle(13, 50, 146, 16));
			lblCodigo.setText("Codigo do medicamento");
			lblCPF = new JLabel();
			lblCPF.setBounds(new Rectangle(15, 14, 97, 16));
			lblCPF.setText("CPF do Paciente");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(lblCPF, null);
			jContentPane.add(lblCodigo, null);
			jContentPane.add(getEdtCPF(), null);
			jContentPane.add(getEdtCodigo(), null);
			jContentPane.add(getBtn_nome(), null);
			jContentPane.add(getBtn_remedio(), null);
			jContentPane.add(getBtn_confirmar(), null);
			jContentPane.add(getBtn_limpar(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes edtCPF	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getEdtCPF() {
		if (edtCPF == null) {
			edtCPF = new JTextField();
			edtCPF.setBounds(new Rectangle(179, 13, 130, 20));
		}
		return edtCPF;
	}

	/**
	 * This method initializes edtCodigo	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getEdtCodigo() {
		if (edtCodigo == null) {
			edtCodigo = new JTextField();
			edtCodigo.setBounds(new Rectangle(182, 49, 126, 21));
		}
		return edtCodigo;
	}


/**
 * This method initializes btn_nome	
 * 	
 * @return javax.swing.JButton	
 */
private JButton getBtn_nome() {
	if (btn_nome == null) {
		btn_nome = new JButton();
		btn_nome.setBounds(new Rectangle(359, 16, 139, 18));
		btn_nome.setText("Verificar Paciente");
		btn_nome.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				int opcao;
				String nome;
				Paciente paciente = new Paciente();
				paciente.setCpf_paci(edtCPF.getText());
				Fachada.getInstancia().PesquisarPaciente(paciente);
				
				String[] valores={"Sim", "Não"};
				if (paciente.getNome()!=null){
				opcao=JOptionPane.showOptionDialog(null, "O nome do Paciente é :"+paciente.getNome(), 
						"Farmacia", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,
						null, valores, valores[0]);
				if(opcao==JOptionPane.YES_OPTION){
												
	
				} else{
					LimparPaciente();
					}
				}else{
					JOptionPane.showOptionDialog(null, "Paciente não encontrado", 
							"Farmacia", JOptionPane.CLOSED_OPTION,JOptionPane.QUESTION_MESSAGE,
							null, null, null);
				}
			}
		}
	);
	}
	return btn_nome;
}

/**
 * This method initializes btn_remedio	
 * 	
 * @return javax.swing.JButton	
 */
private JButton getBtn_remedio() {
	if (btn_remedio == null) {
		btn_remedio = new JButton();
		btn_remedio.setBounds(new Rectangle(357, 52, 144, 20));
		btn_remedio.setText("Verificar Remedio");
		btn_remedio.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				int opcao;
				Medicamentos medicamento = new Medicamentos();
				medicamento.setCod(edtCodigo.getText());
				Fachada.getInstancia().consultarUmMedicamento(medicamento);
				String[] valores={"Sim", "Não"};
				if (medicamento.getNome()!=null){
				opcao=JOptionPane.showOptionDialog(null, "O nome do Medicamento é : "+medicamento.getNome(), 
						"Farmacia", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,
						null, valores, valores[0]);
				if(opcao==JOptionPane.YES_OPTION){
												
	
				} else{
					LimparMedicamento();
					}
				}else{
					JOptionPane.showOptionDialog(null, "Mediamento não encontrado", 
							"Farmacia", JOptionPane.CLOSED_OPTION,JOptionPane.QUESTION_MESSAGE,
							null, null, null);
				}
			}
		}
	);
	
	}
	return btn_remedio;
}
public void LimparTudo(){
	edtCPF.setText(null);
	edtCodigo.setText(null);

	
}
public void LimparPaciente(){
	edtCPF.setText(null);
	
}
public void LimparMedicamento(){
	edtCodigo.setText(null);
}
/**
 * This method initializes btn_confirmar	
 * 	
 * @return javax.swing.JButton	
 */
private JButton getBtn_confirmar() {
	if (btn_confirmar == null) {
		btn_confirmar = new JButton();
		btn_confirmar.setBounds(new Rectangle(132, 93, 95, 28));
		btn_confirmar.setText("Confirmar");
	}
	return btn_confirmar;
}

/**
 * This method initializes btn_limpar	
 * 	
 * @return javax.swing.JButton	
 */
private JButton getBtn_limpar() {
	if (btn_limpar == null) {
		btn_limpar = new JButton();
		btn_limpar.setBounds(new Rectangle(249, 92, 102, 29));
		btn_limpar.setText("Limpar");
		btn_limpar.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent e){
				LimparTudo();
			}
		});
	}
	return btn_limpar;
}
}  //  @jve:decl-index=0:visual-constraint="10,10"
