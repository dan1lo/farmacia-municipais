package view;

import java.awt.BorderLayout;
import java.awt.Point;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import util.ImprimirJTable;

import business.Fachada;
import business.Medicamentos;
import business.Programa;

public class ListarMedicamentos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JButton btn_confirma = null;
	private JButton btn_cadastrar = null;
	private JTextField edt_buscar = null;
	private JLabel lbl_buscar = null;
	private JButton btn_atualizar = null;
	private JButton btn_excluir = null;
	private Fachada fachada = null;
	private JButton btnSair = null;
	private JButton btnPrint = null;
	private JButton btnAtualizar = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	private Medicamentos medica = null;

	public ListarMedicamentos() {
		super();
		initialize();
	}

	private void initialize() {
		this.setSize(738, 576);
		this.setContentPane(getJContentPane());
		this.setTitle("Gerenciador de medicamentos");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		

	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lbl_buscar = new JLabel();
			lbl_buscar.setBounds(new Rectangle(50, 10, 61, 16));
			lbl_buscar.setText("Buscar");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getBtn_confirma(), null);
			jContentPane.add(getBtn_cadastrar(), null);
			jContentPane.add(getEdt_buscar(), null);
			jContentPane.add(lbl_buscar, null);
			jContentPane.add(getBtn_atualizar(), null);
			jContentPane.add(getBtnSair2(), null);
			jContentPane.add(getBtnPrint(), null);
			jContentPane.add(getBtnAtualizar(), null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(getBtn_excluir(), null);
		}
		return jContentPane;
	}

	private JButton getBtn_confirma() {
		if (btn_confirma == null) {
			btn_confirma = new JButton();
			btn_confirma.setBounds(new Rectangle(361, 8, 112, 23));
			btn_confirma.setText("Buscar ");
			btn_confirma.setIcon(new ImageIcon(getClass().getResource("/imagens/consultar.png")));
			btn_confirma.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if((edt_buscar.getText().equals(""))){
						JOptionPane.showMessageDialog(null, "Digite algo no campo de busca", "Farmácia Municipal", JOptionPane.INFORMATION_MESSAGE, null);
						edt_buscar.requestFocus();
					}
					else{
						ResultSet rs;
						
						try{
							String nome = edt_buscar.getText();
							
							rs = Fachada.getInstancia().consultarMedicamentos(nome);
							
							if(rs==null){
							
								edt_buscar.setText("");
								edt_buscar.requestFocus();
							}else{
								jContentPane.remove(jScrollPane);
								jScrollPane = null;
								jContentPane.repaint();
								try{
									jContentPane.add(jScrollPane = new JScrollPane(displayResultSet(rs)));
									jScrollPane.setBounds(new Rectangle(52, 58, 453, 121));
									
									edt_buscar.requestFocus();
								}
								catch (SQLException e1){
									e1.printStackTrace();
								}
							}
						}
						catch (SQLException e2){
							JOptionPane.showMessageDialog(null, "Erro Contate o administrador!", "Farmacias municipais", JOptionPane.INFORMATION_MESSAGE, null);
						}
					}
					
				}
			});
		}
		return btn_confirma;
	}


	private JButton getBtn_cadastrar() {
		if (btn_cadastrar == null) {
			btn_cadastrar = new JButton();
			btn_cadastrar.setBounds(new Rectangle(240, 363, 131, 28));
			btn_cadastrar.setText("Cadastrar");
			btn_cadastrar.setIcon(new ImageIcon(getClass().getResource("/imagens/alterar.png")));
			btn_cadastrar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try{
						new TelaCadMedicamentos(null).abrirtela();
					}
					catch (Exception e4){
						e4.printStackTrace();
						JOptionPane.showMessageDialog(null, "Não foi possível Abrir a tela de cadastro", "Farmacias Municipais", JOptionPane.ERROR_MESSAGE, null);
					}
					
				}
			});
		}
		return btn_cadastrar;
	}


	private JTextField getEdt_buscar() {
		if (edt_buscar == null) {
			edt_buscar = new JTextField();
			edt_buscar.setBounds(new Rectangle(161, 8, 181, 20));
		}
		return edt_buscar;
	}


	private JButton getBtn_atualizar() {
		if (btn_atualizar == null) {
			btn_atualizar = new JButton();
			btn_atualizar.setBounds(new Rectangle(126, 363, 114, 28));
			btn_atualizar.setText("Alterar");
			btn_atualizar.setIcon(new ImageIcon(getClass().getResource("/imagens/atualizar.png")));
			btn_atualizar.addActionListener(new  java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (jTable.getSelectedRow() < 0){
						JOptionPane.showMessageDialog(null, "Selecione a linha primeiro", "Farmacias Municipais", JOptionPane.INFORMATION_MESSAGE, null);
					}
					else {
						int row = jTable.getSelectedRow();
						Medicamentos consultar = new Medicamentos();
						Medicamentos alterar = new Medicamentos();
						
						
						consultar.setCod(jTable.getValueAt(row,0).toString());
						
						int codAlterar = Integer.parseInt(jTable.getValueAt(row, 0).toString());
						int quantAlterar = Integer.parseInt(jTable.getValueAt(row, 2).toString());
						String nomeAlterar = (jTable.getValueAt(row, 1).toString());
						String grupoAlterar = (jTable.getValueAt(row, 3).toString());
						String tipoAlterar  =(jTable.getValueAt(row, 4).toString());
						
						try{
							new AtualizarDados(null).abrir(codAlterar,nomeAlterar,quantAlterar,grupoAlterar,tipoAlterar);
						}
						catch (Exception e1){
							e1.printStackTrace();
						}
						refreshTable();
						
						
					}
					
				}
			});
		}
		return btn_atualizar;
	}


	private JButton getBtn_excluir() {
		if (btn_excluir == null) {
			btn_excluir = new JButton();
			btn_excluir.setText("Excluir");
			btn_excluir.setBounds(new Rectangle(4, 363, 122, 28));
			btn_excluir.setIcon(new ImageIcon(getClass().getResource("/imagens/coisa.png")));
			btn_excluir.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					
					  
						  if (jTable.getSelectedRow() < 0){
								JOptionPane.showMessageDialog(null, "Selecione Primeiro uma linha","Farmacias Municipais",JOptionPane.INFORMATION_MESSAGE,null);
							}else{
							int opcao;
							
							String[] valores={"Sim", "Não"};
							opcao=JOptionPane.showOptionDialog(null, "Deseja realmente excluir o Medicamento?", 
									"Farmacia", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,
									null, valores, valores[0]);
							if(opcao==JOptionPane.YES_OPTION){
								int row = jTable.getSelectedRow();								
								int codigoMedicamento = Integer.parseInt(jTable.getValueAt(row, 0).toString());
								Medicamentos excluir = new Medicamentos();								
								excluir.setCodigo(codigoMedicamento);
							
								Fachada.getInstancia().excluirMedicamentos(excluir);					
								refreshTable();
								JOptionPane.showMessageDialog(null, "excluiu", 
										"Farmacia", JOptionPane.INFORMATION_MESSAGE, null);
								
								}
						}
					  }
					}
				);
			}
		
		return btn_excluir;
	}
	private JButton getBtnSair2() {
		if (btnSair == null) {
			btnSair = new JButton();
			btnSair.setText("Sair");
			btnSair.setLocation(new Point(630, 363));
			btnSair.setSize(new Dimension(87, 28));
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
					} catch (Exception e2) {
						e2.printStackTrace();
						JOptionPane.showMessageDialog(null, "Não foi possível fechar,tente novamente", "Farmacias Municipais", JOptionPane.ERROR_MESSAGE, null);
					}
					
				}
			});
		}
		return btnSair;
	}
	private JButton getBtnPrint() {
		if (btnPrint == null) {
			btnPrint = new JButton();
			btnPrint.setText("Imprimir");
			btnPrint.setLocation(new Point(370, 363));
			btnPrint.setSize(new Dimension(123, 28));
			btnPrint.setIcon(new ImageIcon(getClass().getResource("/imagens/print.png")));
			btnPrint.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try{
						new ImprimirJTable(jTable,"Medicamentos");
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



	private JButton getBtnAtualizar() {
		if (btnAtualizar == null) {
			btnAtualizar = new JButton();
			btnAtualizar.setBounds(new Rectangle(488, 363, 144, 28));
			btnAtualizar.setIcon(new ImageIcon(getClass().getResource("/imagens/cliente.png")));
			btnAtualizar.setText("Atualizar");
			btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					refreshTable();
				}
			});
		
		}
		return btnAtualizar;
	}

	private void refreshTable()
	{
		jContentPane.remove(jScrollPane);
		jScrollPane = null;
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
			jScrollPane.setBounds(new Rectangle(52, 58, 453, 121));
			jScrollPane.setViewportView(getJTable());
			
		}
		return jScrollPane;
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
			JOptionPane.showMessageDialog(null, "Nenhum Valor registrado ou Primeira vez executado!", "Farmacias Municipais", JOptionPane.INFORMATION_MESSAGE,null);
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
	
	private JTable getJTable(){
		ResultSet resultset =null;
		
		try{
			resultset = Fachada.getInstancia().listarMedicamentos(resultset);
			return (displayResultSet(resultset));
		}
		catch (SQLException e){
			JOptionPane.showMessageDialog(null, "Erro","Farmacias Municipais", JOptionPane.ERROR_MESSAGE, null);
		}
		return (jTable);
	}
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
	
		
}  
