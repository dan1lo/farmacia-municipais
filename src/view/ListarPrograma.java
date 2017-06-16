package view;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import javax.swing.JTable;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Point;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JLabel;

import util.ImprimirJTable;

import business.Fachada;
import business.Programa;
import java.awt.Font;

public class ListarPrograma extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane;
	private JButton btnAtualizar = null;
	private JButton btnAlterar = null;
	private JButton btnExcluir = null;
	private JButton btnPrint = null;
	private JButton btnSair = null;
	private JButton btnCadastrar = null;
	private JButton btnBuscar = null;
	private JTextField edtConsulta = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	private JLabel labelNumFounds = null;
	private JLabel lblPrograma = null;
	private JLabel lblTextoContador = null;
	/**
	 * This is the default constructor
	 * @throws SQLException 
	 */
	public ListarPrograma()  {
		super();
		initialize();
	}
	
	public void abrirPrograma(){
		this.initialize();
	}
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 * @throws SQLException 
	 */
	private void initialize() {
		this.setSize(633, 305);
		this.setContentPane(getJContentPane());
		this.setTitle("Gerenciador de Programas");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setVisible(true);
		this.setResizable(false);
		//this.setModal(true);
		//this.setIconImage(new  getIconImage().getClass().getResource("/imagens/atualizar.png"));
		//this.setIconImage(new ImageIcon(getClass().getResource("/imagens/atualizar.png"))); //("/imagens/atualizar.png"));
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 * @throws SQLException 
	 */
	private JPanel getJContentPane()  {
		if (jContentPane == null) {
			lblTextoContador = new JLabel();
			lblTextoContador.setBounds(new Rectangle(29, 208, 153, 16));
			lblTextoContador.setText("Programas Encontrados:");
			lblPrograma = new JLabel();
			lblPrograma.setBounds(new Rectangle(66, 23, 70, 16));
			lblPrograma.setText("Programa:");
			labelNumFounds = new JLabel();
			labelNumFounds.setBounds(new Rectangle(176, 205, 69, 20));
			labelNumFounds.setText("Contador");
			labelNumFounds.setFont(new Font("Dialog", Font.BOLD, 14));
			labelNumFounds.setVisible(true);
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getBtnAtualizar(), null);
			jContentPane.add(getBtnAlterar(), null);
			jContentPane.add(getBtnExcluir(), null);
			jContentPane.add(getBtnPrint(), null);
			jContentPane.add(getBtnSair(), null);
			jContentPane.add(getBtnCadastrar(), null);
			jContentPane.add(getBtnBuscar(), null);
			jContentPane.add(getEdtConsulta(), null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(jScrollPane, null);
			jContentPane.add(labelNumFounds, null);
			jContentPane.add(lblPrograma, null);
			jContentPane.add(lblTextoContador, null);
	}
		return jContentPane;
	}

	
	private void refreshTable()
	{
		jContentPane.remove(jScrollPane);
		jScrollPane = null;
		//jScrollPane.setBounds(new Rectangle(509, 85, 52, 32));
		jContentPane.repaint();
		try {
			jContentPane.add(getJScrollPane());
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	}
	/**
	 * This method initializes btnAtualizar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnAtualizar() {
		if (btnAtualizar == null) {
			btnAtualizar = new JButton();
			btnAtualizar.setBounds(new Rectangle(25, 232, 117, 30));
			btnAtualizar.setIcon(new ImageIcon(getClass().getResource("/imagens/atualizar.png")));
			
			btnAtualizar.setText("Atualizar");
			btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					refreshTable();
				}
			});
		
		}
		return btnAtualizar;
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
			btnAlterar.setLocation(new Point(158, 232));
			btnAlterar.setSize(new Dimension(106, 30));
			btnAlterar.setIcon(new ImageIcon(getClass().getResource("/imagens/alterar.png")));
			btnAlterar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (jTable.getSelectedRow() < 0){
						JOptionPane.showMessageDialog(null, "Selecione uma linha primeiro", "Farmacias Municipais", JOptionPane.INFORMATION_MESSAGE, null);
					}
					else {
						int row = jTable.getSelectedRow();
						
						Programa programaalterar = new Programa();
						Programa programaconsultar = new Programa();
						
						programaconsultar.setNome(jTable.getValueAt(row, 1).toString());
						
						int codigoProgramaAlterar = Integer.parseInt(jTable.getValueAt(row, 0).toString());
						
						try{
							programaalterar = Fachada.getInstancia().consultarUmPrograma(programaconsultar);
							new CadastrarPrograma().abrir(programaalterar, codigoProgramaAlterar);
						}
						catch (Exception e1){
							e1.printStackTrace();
						}
						refreshTable();
						
						
					}
					
				}
			});
		}
		return btnAlterar;
	}

	/**
	 * This method initializes btnExcluir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnExcluir() {
		if (btnExcluir == null) {
			btnExcluir = new JButton();
			btnExcluir.setText("Excluir");
			btnExcluir.setLocation(new Point(280, 232));
			btnExcluir.setSize(new Dimension(97, 30));
			btnExcluir.setIcon(new ImageIcon(getClass().getResource("/imagens/action_remove.png")));
			btnExcluir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (jTable.getSelectedRow() < 0){
						JOptionPane.showMessageDialog(null, "Selecione Primeiro uma linha","Farmacias Municipais",JOptionPane.INFORMATION_MESSAGE,null);
					}
					else{
						int opcao;
						
						Object[] botoes = {"Sim", "Não"};
						
						opcao = JOptionPane.showOptionDialog(null, "Deseja realmente Excluir","Sim",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE, null, botoes,botoes[0]);
						
						if(opcao == JOptionPane.YES_OPTION){
							int row = jTable.getSelectedRow();
							
							int codigoprogramaremover = Integer.parseInt(jTable.getValueAt(row, 0).toString());
							
							Programa excluirPrograma = new Programa();
							
							excluirPrograma.setCod_prog(codigoprogramaremover);
							
							Fachada.getInstancia().removerPrograma(excluirPrograma);
							JOptionPane.showMessageDialog(null, "Exlusão realizada com Sucesso!","Farmacias Municipais",JOptionPane.INFORMATION_MESSAGE,null);
							refreshTable();
						}
					}
					
					
				}
			});
		}
		return btnExcluir;
	}

	/**
	 * This method initializes btnPrint	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnPrint() {
		if (btnPrint == null) {
			btnPrint = new JButton();
			btnPrint.setText("Imprimir");
			btnPrint.setLocation(new Point(392, 232));
			btnPrint.setSize(new Dimension(114, 30));
			btnPrint.setIcon(new ImageIcon(getClass().getResource("/imagens/print.png")));
			btnPrint.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try{
						new ImprimirJTable(jTable,"Programas");
					}
					catch (Exception e2){
						JOptionPane.showMessageDialog(null, "Impossível Imprimir", "Farmacias Municipias", JOptionPane.INFORMATION_MESSAGE, null);
						e2.printStackTrace();
					}
					
				}
			});
		}
		return btnPrint;
	}

	/**
	 * This method initializes btnSair	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnSair() {
		if (btnSair == null) {
			btnSair = new JButton();
			btnSair.setText("Sair");
			btnSair.setLocation(new Point(520, 232));
			btnSair.setSize(new Dimension(87, 30));
			btnSair.setIcon(new ImageIcon(getClass().getResource("/imagens/sair.png")));
			btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					try {
						int opcao;
						
						Object[] botoes = {"Sim", "Não"};
						
						opcao = JOptionPane.showOptionDialog(null, "Deseja realmente Sair","Sim",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE, null, botoes,botoes[0]);
						
						if(opcao == JOptionPane.YES_OPTION){
						dispose();
						System.out.println("Sair"); 
						}
					} catch (Exception e2) {
						e2.printStackTrace();
						JOptionPane.showMessageDialog(null, "Não foi possível fechar,tente novamente", "Farmacias Municipais", JOptionPane.ERROR_MESSAGE, null);
					}
				
				}
			});
		}
		return btnSair;
	}

	/**
	 * This method initializes btnCadastrar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnCadastrar() {
		if (btnCadastrar == null) {
			btnCadastrar = new JButton();
			btnCadastrar.setText("Cadastrar");
			btnCadastrar.setLocation(new Point(480, 13));
			btnCadastrar.setSize(new Dimension(117, 30));
			btnCadastrar.setIcon(new ImageIcon(getClass().getResource("/imagens/action_add.png")));
			btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try{
						new CadastrarPrograma().abrircadastro();
						
					}
					catch (Exception e4){
						e4.printStackTrace();
						JOptionPane.showMessageDialog(null, "Não foi possível Abrir a tela de cadastro", "Farmacias Municipais", JOptionPane.ERROR_MESSAGE, null);
					}
				}
			});
		}
		return btnCadastrar;
	}

	/**
	 * This method initializes btnBuscar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnBuscar() {
		if (btnBuscar == null) {
			btnBuscar = new JButton();
			btnBuscar.setIcon(new ImageIcon(getClass().getResource("/imagens/consultar.png")));
			btnBuscar.setLocation(new Point(282, 14));
			btnBuscar.setSize(new Dimension(117, 30));
			btnBuscar.setText("Buscar");
			btnBuscar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if((edtConsulta.getText().equals(""))){
						JOptionPane.showMessageDialog(null, "Digete algo no campo Programa", "Farmácia Municipal", JOptionPane.INFORMATION_MESSAGE, null);
						edtConsulta.requestFocus();
					}
					else{
						ResultSet rs;
						
						String nome = edtConsulta.getText();
						
						rs = Fachada.getInstancia().consultarPrograma(nome);
						
						if(rs==null){
						//	JOptionPane.showMessageDialog(null, "Neanhum resultado encontrado!", "Farmacias Municipais", JOptionPane.INFORMATION_MESSAGE, null);
							//System.out.println("Erro 1");
							edtConsulta.setText("");
							edtConsulta.requestFocus();
						}else{
							jContentPane.remove(jScrollPane);
							jScrollPane = null;
							jContentPane.repaint();
							try {
								jContentPane.add(jScrollPane = new JScrollPane(displayResultSet(rs)));
								jScrollPane.setBounds(new Rectangle(29, 55, 571, 139));
								labelNumFounds.setText(String.valueOf(jTable.getRowCount()));
								edtConsulta.requestFocus();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
					}
					
				}
			});
		}
		return btnBuscar;
	}

	/**
	 * This method initializes edtConsulta	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getEdtConsulta() {
		if (edtConsulta == null) {
			edtConsulta = new JTextField();
			edtConsulta.setBounds(new Rectangle(131, 22, 148, 20));
		}
		return edtConsulta;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 * @throws SQLException 
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(29, 55, 571, 139));
			jScrollPane.setViewportView(getJTable());

			labelNumFounds.setText(String.valueOf(jTable.getRowCount()));
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	
	private Vector getNextRow(ResultSet rs, ResultSetMetaData rsmd) throws SQLException {
		Vector currentRow = new Vector();
		for (int i = 1; i<=rsmd.getColumnCount(); i++)
			switch (rsmd.getColumnType(i)) {
			case Types.VARCHAR: currentRow.addElement(rs.getString(i));
				break;
			case Types.INTEGER: currentRow.addElement(new Long (rs.getLong(i)));
			break;
			case Types.DOUBLE: currentRow.addElement(rs.getDouble(i));
			break;
			}
		return currentRow;
	}
	
	 private JTable createTable(Vector rows, Vector columnHeads)  
	    {  
	       jTable = new JTable(rows, columnHeads);  
	       
	    
	       return(jTable);  
	    }
	
	private JTable displayResultSet(ResultSet rs) throws SQLException{
		boolean moreRecords = rs.next();
		Vector columnHeads = new Vector();
		Vector rows = new Vector();
		
		if(! moreRecords){
			ResultSetMetaData rsmd = rs.getMetaData();

			for(int i = 1; i <= rsmd.getColumnCount(); i++){
				columnHeads.addElement(rsmd.getColumnName(i));
			}
			JOptionPane.showMessageDialog(null, "Nenhum Valor registrado!", "Farmacia Municipal", JOptionPane.INFORMATION_MESSAGE,null);
		}
			else {
				try{
					ResultSetMetaData rsmd = rs.getMetaData();
					String columnName;
					for (int i = 1; i<= rsmd.getColumnCount(); i++){
						columnName = rsmd.getColumnName(i);
						columnHeads.addElement(columnName);
					}
					do{
						rows.addElement(getNextRow(rs, rsmd));
					}while (rs.next());
				}
				catch (SQLException e){
					e.printStackTrace();
				}
			}
		rs.close();
		return (createTable(rows, columnHeads));
		
	}
	
	private JTable getJTable() {
		ResultSet resultset = null;
		try {
			resultset = Fachada.getInstancia().listarPrograma(resultset);
			return (displayResultSet(resultset));
		} 
		catch (SQLException e2) {
			e2.printStackTrace();
		}
		return (jTable);
	}

}  //  @jve:decl-index=0:visual-constraint="37,36"
