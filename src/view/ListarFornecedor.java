package view;

import javax.swing.JPanel;
import java.awt.Frame;
import javax.swing.JDialog;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Vector;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.text.MaskFormatter;
import javax.swing.JTable;

import util.ImprimirJTable;

import business.Fachada;
import business.Fornecedor;

public class ListarFornecedor extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JButton btnAtualizar = null;
	private JButton btnAlterar = null;
	private JButton btnPrint = null;
	private JButton btnExcluir = null;
	private JButton btnSair = null;
	private JButton btnBuscar = null;
	private JButton btnCadastrar = null;
	private JLabel labelNumFounds = null;
	private JLabel lblTextoContador = null;
	private JTextField edtBuscarNome = null;
	private JComboBox cbxBuscar = null;
	private JTextField edtBuscarCnpj = null;
	private JLabel lblCnpj = null;
	private JLabel lblNome = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;


	/**
	 * @param owner
	 * @throws SQLException 
	*/
	
	public ListarFornecedor(){
		super();
		initialize();
	}
	
	public void abrirFornecedor() {
		this.setVisible(true);
		lblCnpj.setVisible(false);
		edtBuscarCnpj.setVisible(false);
		initialize();
	}
	
	public ListarFornecedor(Frame owner)  {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 * @throws SQLException 
	 */
	private void initialize() {
		this.setSize(715, 305);
		this.setTitle("Gerenciador de Fornecedores");
		this.setContentPane(getJContentPane());
		this.setModal(true);
		this.setVisible(true);
	}

	//Utilizando mascara
	public MaskFormatter setMascara(String mascara){  
		MaskFormatter mask = null;  
		try{  
			mask = new MaskFormatter(mascara); 
			mask.setPlaceholderCharacter('_'); 
		}catch(java.text.ParseException ex){}  
		return mask;  
	}
	
	
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 * @throws SQLException 
	 */
	

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lblNome = new JLabel("NOME:");
			lblNome.setBounds(new Rectangle(8, 26, 38, 16));
			lblCnpj = new JLabel("CPNJ:");
			lblCnpj.setBounds(new Rectangle(8, 26, 38, 16));
			lblCnpj.setVisible(false);
			lblTextoContador = new JLabel();
			lblTextoContador.setBounds(new Rectangle(460, 201, 167, 16));
			lblTextoContador.setText("Fornecedores Encontrados:");
			labelNumFounds = new JLabel();
			labelNumFounds.setFont(new Font("Dialog", Font.BOLD, 14));
			labelNumFounds.setBounds(new Rectangle(625, 200, 65, 19));
			labelNumFounds.setText("Contador");
			labelNumFounds.setVisible(true);
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getBtnAtualizar(), null);
			jContentPane.add(getBtnAlterar(), null);
			jContentPane.add(getBtnPrint(), null);
			jContentPane.add(getBtnExcluir(), null);
			jContentPane.add(getBtnSair(), null);
			jContentPane.add(getBtnBuscar(), null);
			jContentPane.add(getBtnCadastrar(), null);
			jContentPane.add(labelNumFounds, null);
			jContentPane.add(lblTextoContador, null);
			jContentPane.add(getEdtBuscarNome(), null);
			jContentPane.add(getCbxBuscar(), null);
			jContentPane.add(getEdtBuscarCnpj(), null);
			jContentPane.add(lblCnpj, null);
			jContentPane.add(lblNome, null);
			jContentPane.add(getJScrollPane(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes btnAtualizar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnAtualizar() {
		if (btnAtualizar == null) {
			btnAtualizar = new JButton();
			btnAtualizar.setText("Atualizar");
			btnAtualizar.setBounds(new Rectangle(15, 228, 112, 30));
			btnAtualizar.setIcon(new ImageIcon(getClass().getResource("/imagens/atualizar.png")));
			btnAtualizar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
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
			btnAlterar.setBounds(new Rectangle(138, 228, 101, 30));
			btnAlterar.setIcon(new ImageIcon(getClass().getResource("/imagens/alterar.png")));
			btnAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if (jTable.getSelectedRow() <0){
						JOptionPane.showMessageDialog(null, "Selecione uma linha primeiro", "Farmacias Municipais", JOptionPane.INFORMATION_MESSAGE, null);
					}
					else {
						
						int row = jTable.getSelectedRow();
						Fornecedor fornecedorAlterar = new Fornecedor();
						Fornecedor fornecedorConsultar = new Fornecedor();
						
						fornecedorConsultar.setNome_fantasia(jTable.getValueAt(row, 2).toString());
						String codigoFornecedorAlterar  = jTable.getValueAt(row, 0).toString();
						
						try {
							fornecedorAlterar = Fachada.getInstancia().consultarumFornecedor(fornecedorConsultar);
							CadastrarFornecedor entrar = new CadastrarFornecedor();
							System.out.println("Não entrou aki");
							//System.out.println(fornecedorAlterar.getNome_fantasia());
							System.out.println(codigoFornecedorAlterar);
							entrar.abrir(fornecedorAlterar, codigoFornecedorAlterar);
							System.out.println("Não entrou aki 2");
						}
						catch (Exception e1){
							e1.printStackTrace();
						}
					}
				}
			});
		}
		return btnAlterar;
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
			btnPrint.setPreferredSize(new Dimension(110, 30));
			btnPrint.setBounds(new Rectangle(358, 228, 110, 30));
			btnPrint.setIcon(new ImageIcon(getClass().getResource("/imagens/print.png")));
			btnPrint.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					try{
						new ImprimirJTable(jTable,"Fornecedores");
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
	 * This method initializes btnExcluir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnExcluir() {
		if (btnExcluir == null) {
			btnExcluir = new JButton();
			btnExcluir.setText("Excluir");
			btnExcluir.setBounds(new Rectangle(250, 228, 97, 30));
			btnExcluir.setIcon(new ImageIcon(getClass().getResource("/imagens/action_remove.png")));
			btnExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if (jTable.getSelectedRow() < 0){
						JOptionPane.showMessageDialog(null, "Selecione Primeiro uma linha","Farmacias Municipais",JOptionPane.INFORMATION_MESSAGE,null);
					}
					else{
						int opcao;
						
						Object[] botoes = {"Sim", "Não"};
						
						opcao = JOptionPane.showOptionDialog(null, "Deseja realmente Excluir","Sim",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE, null, botoes,botoes[0]);
						
						if(opcao == JOptionPane.YES_OPTION){
							int row = jTable.getSelectedRow();
							
							String codigoprogramaremover = jTable.getValueAt(row, 0).toString();
							
							Fornecedor excluirFornecedor = new Fornecedor();
							
							excluirFornecedor.setCnpj(codigoprogramaremover);
							
							Fachada.getInstancia().removerFornecedor(excluirFornecedor);
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
	 * This method initializes btnSair	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnSair() {
		if (btnSair == null) {
			btnSair = new JButton();
			btnSair.setText("Sair");
			btnSair.setPreferredSize(new Dimension(85, 30));
			btnSair.setBounds(new Rectangle(479, 228, 106, 30));
			btnSair.setIcon(new ImageIcon(getClass().getResource("/imagens/sair.png")));
			btnSair.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
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
	 * This method initializes btnBuscar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnBuscar() {
		if (btnBuscar == null) {
			btnBuscar = new JButton();
			btnBuscar.setText("Buscar");
			btnBuscar.setBounds(new Rectangle(368, 19, 103, 34));
			btnBuscar.setIcon(new ImageIcon(getClass().getResource("/imagens/consultar.png")));
			btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if(cbxBuscar.getSelectedItem().toString().equals("NOME")){
						System.out.println("t 1");
						if(edtBuscarNome.getText().equals("")){
							JOptionPane.showMessageDialog(null, "Digete algo no campo Nome", "Farmácia Municipal", JOptionPane.INFORMATION_MESSAGE, null);
							edtBuscarNome.requestFocus();
							System.out.println("t 2");
						}
						else{
							ResultSet rs;
							String nome = edtBuscarNome.getText();
							System.out.println(nome);
							rs = Fachada.getInstancia().consultarFornecedorNome(nome);
							
							if (rs==null){
								//JOptionPane.showMessageDialog(null, "Neanhum resultado encontrado!", "Farmacias Municipais", JOptionPane.INFORMATION_MESSAGE, null);
								edtBuscarNome.setText("");
								edtBuscarNome.requestFocus();
							}
							else{
								jContentPane.remove(jScrollPane);
								jScrollPane = null;
								jContentPane.repaint();
								try{						
									jContentPane.add(jScrollPane = new JScrollPane(displayResultSet(rs)));
									jScrollPane.setBounds(new Rectangle(18, 70, 670, 125));
									labelNumFounds.setText(String.valueOf(jTable.getRowCount()));
									edtBuscarNome.requestFocus();
								}
								catch (SQLException e2){
									e2.printStackTrace();
								}
							}
						}
					}
					else if(cbxBuscar.getSelectedItem().toString().equals("CNPJ")){
						System.out.println("t 1");
						if(edtBuscarCnpj.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Digete algo no campo CNPJ", "Farmácia Municipal", JOptionPane.INFORMATION_MESSAGE, null);
						edtBuscarCnpj.requestFocus();
						System.out.println("t 2");
					}
					else{
						ResultSet rs;
						String cnpj = edtBuscarCnpj.getText();
						System.out.println(cnpj);
						rs = Fachada.getInstancia().consultarFornecedorCnpj(cnpj);
						System.out.println("t 3");
						if (rs==null){
							//JOptionPane.showMessageDialog(null, "Neanhum resultado encontrado!", "Farmacias Municipais", JOptionPane.INFORMATION_MESSAGE, null);
							edtBuscarNome.setText("");
							edtBuscarNome.requestFocus();
							System.out.println("t 4");
						}
						else{
							jContentPane.remove(jScrollPane);
							jScrollPane = null;
							jContentPane.repaint();
							System.out.println("t 5");
							try{
								System.out.println("t 66");
								jContentPane.add(jScrollPane = new JScrollPane(displayResultSet(rs)));
								jScrollPane.setBounds(new Rectangle(18, 70, 670, 125));
								labelNumFounds.setText(String.valueOf(jTable.getRowCount()));
								edtBuscarNome.requestFocus();
								System.out.println("t 67");
							}
							catch (SQLException e2){
								e2.printStackTrace();
							}
						}
					}
				}
				}
			});
		}
		return btnBuscar;
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
			btnCadastrar.setPreferredSize(new Dimension(111, 30));
			btnCadastrar.setBounds(new Rectangle(565, 16, 117, 34));
			btnCadastrar.setIcon(new ImageIcon(getClass().getResource("/imagens/action_add.png")));
			btnCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					CadastrarFornecedor entrar = new CadastrarFornecedor();
					entrar.abrircadastro();
					System.out.println("mouseClicked()"); // TODO Auto-generated Event stub mouseClicked()
				}
			});
		}
		return btnCadastrar;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */


	/**
	 * This method initializes edtBuscarNome	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getEdtBuscarNome() {
		if (edtBuscarNome == null) {
			edtBuscarNome = new JTextField();
			edtBuscarNome.setBounds(new Rectangle(52, 28, 165, 20));
		}
		return edtBuscarNome;
	}

	/**
	 * This method initializes cbxBuscar	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCbxBuscar() {
		if (cbxBuscar == null) {
			cbxBuscar = new JComboBox();
			cbxBuscar.addItem("NOME");
			cbxBuscar.addItem("CNPJ");
			cbxBuscar.setBounds(new Rectangle(233, 23, 119, 24));
			cbxBuscar.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					System.out.println("itemStateChanged()"); // TODO Auto-generated Event stub itemStateChanged()
					if(cbxBuscar.getSelectedItem().toString().equals("NOME")){
						edtBuscarNome.setVisible(true);
						edtBuscarCnpj.setVisible(false);
						lblNome.setVisible(true);
						lblCnpj.setVisible(false);
					}
					else if (cbxBuscar.getSelectedItem().toString().equals("CNPJ")){
						edtBuscarNome.setVisible(false);
						edtBuscarCnpj.setVisible(true);
						lblNome.setVisible(false);
						lblCnpj.setVisible(true);
					}
				}
			});
			
				
			
		}
		return cbxBuscar;
	}

	/**
	 * This method initializes edtBuscarCnpj	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getEdtBuscarCnpj() {
		if (edtBuscarCnpj == null) {
			edtBuscarCnpj = new JTextField();
			edtBuscarCnpj = new JFormattedTextField(setMascara("##.###.###/####-##"));
			edtBuscarCnpj.setVisible(false);
			edtBuscarCnpj.setBounds(new Rectangle(52, 28, 125, 20));
		}
		return edtBuscarCnpj;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 * @throws SQLException 
	 */
	
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
	
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			
			jScrollPane.setBounds(new Rectangle(18, 70, 670, 125));
			jScrollPane.setViewportView(getJTable());
			labelNumFounds.setText(String.valueOf(jTable.getRowCount()));
		}
		return jScrollPane;
	}
	
	/*private Fachada getFachada(){
		if (fachada == null){
			return fachada = new Fachada();
		}
		else {
			return fachada;
		}
	}*/
	
	private Vector getNextRow(ResultSet rs, ResultSetMetaData rsmd) throws SQLException{
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
	
	private JTable createTable (Vector rows, Vector columnHeads){
		jTable = new JTable(rows,columnHeads);
		
		return(jTable);
	}
	
	private JTable displayResultSet(ResultSet rs) throws SQLException {
		boolean moreRecords = rs.next();
		Vector columnHeads = new Vector();
		Vector rows = new Vector();
		
		if(!moreRecords){
			ResultSetMetaData rsmd = rs.getMetaData();
			for(int i = 1;i<=rsmd.getColumnCount(); i++){
				columnHeads.addElement(rsmd.getColumnName(i));
			}
			JOptionPane.showMessageDialog(null, "Nenhum Valor registrado!", "Farmacia Municipal", JOptionPane.INFORMATION_MESSAGE,null);
		}
			else {
				try{
					ResultSetMetaData rsmd = rs.getMetaData();
					String columnName;
					for (int i=1; i<=rsmd.getColumnCount(); i++){
						columnName = rsmd.getColumnName(i);
						columnHeads.addElement(columnName);
					}
					do {
						rows.addElement(getNextRow(rs, rsmd));
					}while (rs.next());
				}
				catch (SQLException e1){
					e1.printStackTrace();
				}
			}
		rs.close();
		return (createTable(rows, columnHeads));
	}
	

	private JTable getJTable() {
		ResultSet resultset = null;
		try{
			resultset = Fachada.getInstancia().listarFornecedor(resultset);
			return(displayResultSet(resultset));
		}
		catch (SQLException e2){
			e2.printStackTrace();
		}
		return (jTable);
	}
	
}  //  @jve:decl-index=0:visual-constraint="-40,10"
