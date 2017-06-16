package view;



import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

import java.awt.Color;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import util.ImprimirJTable;
import util.Maskara;
import business.Fachada;
import business.Unidades;


public class UnidadeCRUD extends JDialog {
	
	private Unidades unidadePrivada=null;  //  @jve:decl-index=0:
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTextField txtCodigo = null;
	private JLabel lblCodigo = null;
	private JTextField txtNome = null;
	private JLabel lblNome = null;
	private JLabel lblEndereco = null;
	private JTextField txtEndereco = null;
	private JLabel lblComplemento = null;
	private JTextField txtComplemento = null;
	private JLabel lblBairro = null;
	private JTextField txtBairro = null;
	private JLabel lblCidade = null;
	private JTextField txtCidade = null;
	private JLabel lblCep = null;
	private JTextField txtCep = null;
	private JLabel lblTipo = null;
	private JComboBox cboxTipo = null;
	private JLabel lblFone = null;
	private JTextField txtFone = null;
	private JButton btnAtualizar = null;
	private JButton btnExcluir = null;
	private JLabel lblLinha1 = null;
	private JLabel lblLinha2 = null;
	private JLabel lblPesquisa = null;
	private JTextField txtPesquisa = null;
	private JButton btnListar = null;
	private JLabel lblFiltrar = null;
	private JComboBox cboxFiltro = null;
	private JButton btnPesquisar = null;
	private JScrollPane jScrollPane = null;
	private JTable tblListar = null;
	private JButton btnLimpar = null;
	private JButton btnImprimir = null;
	private JLabel jLabel = null;
	
	public UnidadeCRUD() {
		super();
		initialize();
	}

	
	private void initialize() {
		this.setSize(573, 669);
		this.setContentPane(getJContentPane());
		this.setTitle("Consulta de unidades");
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setVisible(true);
		
	}

	
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(2, 2, 564, 638));
			jLabel.setIcon(new ImageIcon(getClass().getResource("/imagens/brancoazul2.jpg")));
			lblFiltrar = new JLabel();
			lblFiltrar.setBounds(new Rectangle(15, 418, 75, 25));
			lblFiltrar.setText("Filtrar por:");
			lblPesquisa = new JLabel();
			lblPesquisa.setBounds(new Rectangle(16, 379, 74, 27));
			lblPesquisa.setText("Pesquisa:");
			lblLinha2 = new JLabel();
			lblLinha2.setBounds(new Rectangle(-1, 445, 589, 19));
			lblLinha2.setForeground(new Color(0, 0, 214));
			lblLinha2.setText("___________________________________________________________________________________");
			lblLinha2.setFont(new Font("Dialog", Font.BOLD, 12));
			lblLinha1 = new JLabel();
			lblLinha1.setBounds(new Rectangle(-2, 348, 584, 18));
			lblLinha1.setText("_______________________________________________________________________________________");
			lblLinha1.setForeground(new Color(0, 0, 214));
			lblFone = new JLabel();
			lblFone.setBounds(new Rectangle(287, 275, 60, 23));
			lblFone.setText("Telefone:*");
			lblTipo = new JLabel();
			lblTipo.setBounds(new Rectangle(14, 272, 100, 24));
			lblTipo.setText("Tipo de Unidade:*");
			lblCep = new JLabel();
			lblCep.setBounds(new Rectangle(293, 234, 32, 23));
			lblCep.setText("CEP:*");
			lblCidade = new JLabel();
			lblCidade.setBounds(new Rectangle(15, 231, 85, 25));
			lblCidade.setText("Cidade:*");
			lblBairro = new JLabel();
			lblBairro.setBounds(new Rectangle(15, 192, 85, 25));
			lblBairro.setText("Bairro:*");
			lblComplemento = new JLabel();
			lblComplemento.setBounds(new Rectangle(15, 150, 86, 25));
			lblComplemento.setText("Complemento:");
			lblEndereco = new JLabel();
			lblEndereco.setBounds(new Rectangle(14, 102, 86, 27));
			lblEndereco.setText("Endereço:*");
			lblEndereco.setFont(new Font("Dialog", Font.BOLD, 12));
			lblNome = new JLabel();
			lblNome.setBounds(new Rectangle(13, 58, 88, 24));
			lblNome.setText("Responsável:*");
			lblNome.setFont(new Font("Dialog", Font.BOLD, 12));
			lblCodigo = new JLabel();
			lblCodigo.setBounds(new Rectangle(15, 16, 86, 23));
			lblCodigo.setText("Código CNES:*");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getTxtCodigo(), null);
			jContentPane.add(lblCodigo, null);
			jContentPane.add(getTxtNome(), null);
			jContentPane.add(lblNome, null);
			jContentPane.add(lblEndereco, null);
			jContentPane.add(getTxtEndereco(), null);
			jContentPane.add(lblComplemento, null);
			jContentPane.add(getTxtComplemento(), null);
			jContentPane.add(lblBairro, null);
			jContentPane.add(getTxtBairro(), null);
			jContentPane.add(lblCidade, null);
			jContentPane.add(getTxtCidade(), null);
			jContentPane.add(lblCep, null);
			jContentPane.add(getTxtCep(), null);
			jContentPane.add(lblTipo, null);
			jContentPane.add(getCboxTipo(), null);
			jContentPane.add(lblFone, null);
			jContentPane.add(getTxtFone(), null);
			jContentPane.add(getBtnAtualizar(), null);
			jContentPane.add(getBtnExcluir(), null);
			jContentPane.add(lblLinha1, null);
			jContentPane.add(lblLinha2, null);
			jContentPane.add(lblPesquisa, null);
			jContentPane.add(getTxtPesquisa(), null);
			jContentPane.add(getBtnListar(), null);
			jContentPane.add(lblFiltrar, null);
			jContentPane.add(getCboxFiltro(), null);
			jContentPane.add(getBtnPesquisar(), null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(getBtnLimpar(), null);
			jContentPane.add(getBtnImprimir(), null);
			jContentPane.add(jLabel, null);
		}
		return jContentPane;
	}

	
	private JTextField getTxtCodigo() {
		if (txtCodigo == null) {
			txtCodigo = Maskara.getMascara("########");
			txtCodigo.setBounds(new Rectangle(118, 17, 229, 27));
			txtCodigo.setEditable(false);
			//txtCodigo.setDocument(new business.NumeroMaximoCaracteres(8));
		}
		return txtCodigo;
	}

	private JTextField getTxtNome() {
		if (txtNome == null) {
			txtNome = new JTextField();
			txtNome.setBounds(new Rectangle(119, 58, 361, 28));
			txtNome.setDocument(new business.NumeroMaximoCaracteres(30));
		}
		return txtNome;
	}

	
	private JTextField getTxtEndereco() {
		if (txtEndereco == null) {
			txtEndereco = new JTextField();
			txtEndereco.setBounds(new Rectangle(118, 102, 362, 27));
			txtEndereco.setDocument(new business.NumeroMaximoCaracteres(30));
		}
		return txtEndereco;
	}

	
	private JTextField getTxtComplemento() {
		if (txtComplemento == null) {
			txtComplemento = new JTextField();
			txtComplemento.setBounds(new Rectangle(118, 146, 362, 29));
			txtComplemento.setDocument(new business.NumeroMaximoCaracteres(30));
		}
		return txtComplemento;
	}

	
	private JTextField getTxtBairro() {
		if (txtBairro == null) {
			txtBairro = new JTextField();
			txtBairro.setBounds(new Rectangle(119, 191, 360, 28));
			txtBairro.setDocument(new business.NumeroMaximoCaracteres(15));
		}
		return txtBairro;
	}

	
	private JTextField getTxtCidade() {
		if (txtCidade == null) {
			txtCidade = new JTextField();
			txtCidade.setBounds(new Rectangle(119, 231, 159, 26));
			txtCidade.setDocument(new business.NumeroMaximoCaracteres(30));
		}
		return txtCidade;
	}

	
	private JTextField getTxtCep() {
		if (txtCep == null) {
			txtCep = Maskara.getMascara("########");
			txtCep.setBounds(new Rectangle(339, 232, 139, 28));
			//txtCep.setDocument(new business.NumeroMaximoCaracteres(8));
		}
		return txtCep;
	}

	
	private JComboBox getCboxTipo() {
		if (cboxTipo == null) {
			cboxTipo = new JComboBox();
			cboxTipo.setBounds(new Rectangle(122, 272, 154, 25));
		}
		return cboxTipo;
	}

	
	private JTextField getTxtFone() {
		if (txtFone == null) {
			txtFone = Maskara.getMascara("##########");
			txtFone.setBounds(new Rectangle(357, 271, 122, 29));
			//txtFone.setDocument(new business.NumeroMaximoCaracteres(10));
		}
		return txtFone;
	}

	private JButton getBtnLimpar() {
		if (btnLimpar == null) {
			btnLimpar = new JButton();
			btnLimpar.setBounds(new Rectangle(436, 319, 107, 27));
			btnLimpar.setIcon(new ImageIcon(getClass().getResource("/imagens/limpar.png")));
			btnLimpar.setText("Limpar");
			btnLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					try{
						limparDados();
					}catch (Exception farmacia) {
						JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado\n" +
								"por favor contate o administrador do sistema!","Farmacia",JOptionPane.ERROR_MESSAGE,null);
					}
				}
			});
		}
		return btnLimpar;
	}

	
	private JButton getBtnImprimir() {
		if (btnImprimir == null) {
			btnImprimir = new JButton();
			btnImprimir.setBounds(new Rectangle(12, 320, 132, 26));
			btnImprimir.setIcon(new ImageIcon(getClass().getResource("/imagens/print.png")));
			btnImprimir.setText("Imprimir");
			btnImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					new ImprimirJTable(tblListar,"Unidades do sistema");
				}
			});
		}
		return btnImprimir;
	}
	
	private JButton getBtnAtualizar() {
		if (btnAtualizar == null) {
			btnAtualizar = new JButton();
			btnAtualizar.setBounds(new Rectangle(167, 319, 112, 28));
			btnAtualizar.setText("Atualizar");
			btnAtualizar.setIcon(new ImageIcon(getClass().getResource("/imagens/atualizar.png")));
			btnAtualizar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
				  try{
					  String valida,menssagem;
					  if(unidadePrivada!=null){
						    unidadePrivada.setBairro(txtBairro.getText());
							unidadePrivada.setCep(txtCep.getText());
							unidadePrivada.setCidade(txtCidade.getText());
							unidadePrivada.setCnes(txtCodigo.getText());
							unidadePrivada.setComplemento(txtComplemento.getText());
							unidadePrivada.setFone(txtFone.getText());
							unidadePrivada.setLogradouro(txtEndereco.getText());
							unidadePrivada.setNomeResponsavel(txtNome.getText());
							unidadePrivada.setTipoUnidade(cboxTipo.getSelectedItem().toString());
						    valida=Fachada.getInstancia().validarUnidade(unidadePrivada);
					  		if(valida!=null){
					  			JOptionPane.showMessageDialog(null, valida, 
					  					"Farmacia", JOptionPane.INFORMATION_MESSAGE, null);
					  		}
					  		else if(valida==null){
					  			menssagem=atualizarUnidade(unidadePrivada);
					  			JOptionPane.showMessageDialog(null, menssagem, 
					  					"Farmacia", JOptionPane.INFORMATION_MESSAGE, null);
					  		}
				  }
				  }catch (Exception farmacia) {
						JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado\n" +
								"por favor contate o administrador do sistema!","Farmacia",JOptionPane.ERROR_MESSAGE,null);
					}
				}
			});
		}
		return btnAtualizar;
	}

	
	private JButton getBtnExcluir() {
		if (btnExcluir == null) {
			btnExcluir = new JButton();
			btnExcluir.setBounds(new Rectangle(304, 319, 112, 26));
			btnExcluir.setText("Excluir");
			btnExcluir.setIcon(new ImageIcon(getClass().getResource("/imagens/coisa.png")));
			btnExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
				  try{
					if(unidadePrivada!=null){
						int opcao;
						String[] valores={"Sim", "Não"};
						opcao=JOptionPane.showOptionDialog(null, "Deseja realmente excluir a unidade?", 
								"Farmacia", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,
								null, valores, valores[0]);
						if(opcao==JOptionPane.YES_OPTION){
							String menssagem=excluirUnidade(unidadePrivada);
							JOptionPane.showMessageDialog(null, menssagem, 
									"Farmacia", JOptionPane.INFORMATION_MESSAGE, null);
						}
					}
				  }catch (Exception farmacia) {
						JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado\n" +
								"por favor contate o administrador do sistema!","Farmacia",JOptionPane.ERROR_MESSAGE,null);
					}
				}
			});
		}
		return btnExcluir;
	}

	
	private JTextField getTxtPesquisa() {
		if (txtPesquisa == null) {
			txtPesquisa = new JTextField();
			txtPesquisa.setBounds(new Rectangle(108, 379, 208, 27));
		}
		return txtPesquisa;
	}

	
	private JButton getBtnListar() {
		if (btnListar == null) {
			btnListar = new JButton();
			btnListar.setBounds(new Rectangle(340, 374, 158, 30));
			btnListar.setIcon(new ImageIcon(getClass().getResource("/imagens/cliente.png")));
			btnListar.setText("Listar Todos");
			btnListar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					try{
						atualizarTabela();
					}catch (Exception farmacia) {
						JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado\n" +
								"por favor contate o administrador do sistema!","Farmacia",JOptionPane.ERROR_MESSAGE,null);
					}
				}
			});
		}
		return btnListar;
	}

	
	private JComboBox getCboxFiltro() {
		if (cboxFiltro == null) {
			cboxFiltro = new JComboBox();
			cboxFiltro.setBounds(new Rectangle(106, 417, 208, 25));
			cboxFiltro.addItem("Responsável");
			cboxFiltro.addItem("Tipo de unidade");
		}
		return cboxFiltro;
	}

	
	private JButton getBtnPesquisar() {
		if (btnPesquisar == null) {
			btnPesquisar = new JButton();
			btnPesquisar.setBounds(new Rectangle(342, 413, 158, 31));
			btnPesquisar.setIcon(new ImageIcon(getClass().getResource("/imagens/consultar.png")));
			btnPesquisar.setText("Pesquisar");
			btnPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
				  try{
					String pesquisa=txtPesquisa.getText();
					if(!pesquisa.isEmpty()){
						JTable table=tabelaPesquisa(pesquisa, cboxFiltro.getSelectedItem().toString());
						if(table!=null){
							tblListar=table;
						jScrollPane.setViewportView(tblListar);
						}
						else{
							JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado!");
						}
						txtPesquisa.setText(null);
					}
				}catch (Exception farmacia) {
					JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado\n" +
							"por favor contate o administrador do sistema!","Farmacia",JOptionPane.ERROR_MESSAGE,null);
				}
				}
			});
		}
		return btnPesquisar;
	}

	
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(5, 473, 476, 152));
			jScrollPane.setViewportView(getTblListar());
		}
		return jScrollPane;
	}

	
	private JTable getTblListar() {
		if (tblListar == null) {
			String[] cabecalho= new String[]{"RESPONSAVEL","CÓDIGO CNES","TIPO UNIDADE"};
			List<Unidades> linhas=Fachada.getInstancia().pegartodasUnidades();
			if(linhas!=null){
				int size=linhas.size();
				String[][] dados= new String[size][3];
				for(int i=0;i<size;i++){
					dados[i][0]=linhas.get(i).getNomeResponsavel();
					dados[i][1]=linhas.get(i).getCnes();
					dados[i][2]=linhas.get(i).getTipoUnidade();
				}
				DefaultTableModel modelo = new DefaultTableModel(dados,cabecalho);
				tblListar = new JTable(modelo);
				tblListar.setRowHeight(25);
				tblListar.setShowGrid(true);
				tblListar.setEnabled(true);
				tblListar.setFont(new Font("Dialog", Font.PLAIN, 14));
				tblListar.setRowSelectionAllowed(true);
				tblListar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tblListar.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent e) {
						try{
							String cpf=getRowSelected();
							if(cpf!=null){
								unidadePrivada= new Unidades();
								unidadePrivada.setCnes(cpf);
								unidadePrivada=Fachada.getInstancia().pegarUnidade(unidadePrivada);
								if(unidadePrivada!=null)
									preencherDados(unidadePrivada);
							}
						}catch (Exception farmacia) {
							JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado\n" +
									"por favor contate o administrador do sistema!","Farmacia",JOptionPane.ERROR_MESSAGE,null);
						}				}
				});
			}
			else{
				tblListar = new JTable();
			}
		}
		
		return tblListar;
	}
	//-------------------------------------------------metodos fatorados
	
	//limpa os campos da tela
	public void limparDados(){
		this.txtBairro.setText(null);
		this.txtCep.setText(null);
		this.txtCidade.setText(null);
		this.txtCodigo.setText(null);
		this.txtComplemento.setText(null);
		this.txtEndereco.setText(null);
		this.txtFone.setText(null);
		this.txtNome.setText(null);
		cboxTipo.removeAllItems();
		unidadePrivada=null;
	}
	//atualiza a tabela
	private void atualizarTabela(){
		String[] cabecalho= new String[]{"RESPONSAVEL","CÓDIGO CNES","TIPO UNIDADE"};
		List<Unidades> linhas=Fachada.getInstancia().pegartodasUnidades();
		if(linhas!=null){
			int size=linhas.size();
			String[][] dados= new String[size][3];
			for(int i=0;i<size;i++){
				dados[i][0]=linhas.get(i).getNomeResponsavel();
				dados[i][1]=linhas.get(i).getCnes();
				dados[i][2]=linhas.get(i).getTipoUnidade();
			}
			DefaultTableModel modelo = new DefaultTableModel(dados,cabecalho);
			tblListar = new JTable(modelo);
			tblListar.setRowHeight(25);
			tblListar.setShowGrid(true);
			tblListar.setEnabled(true);
			tblListar.setFont(new Font("Dialog", Font.PLAIN, 14));
			tblListar.setRowSelectionAllowed(true);
			tblListar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tblListar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					try{
						String cpf=getRowSelected();
						if(cpf!=null){
							unidadePrivada= new Unidades();
							unidadePrivada.setCnes(cpf);
							unidadePrivada=Fachada.getInstancia().pegarUnidade(unidadePrivada);
							if(unidadePrivada!=null)
								preencherDados(unidadePrivada);
						}
					}catch (Exception farmacia) {
						JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado\n" +
								"por favor contate o administrador do sistema!","Farmacia",JOptionPane.INFORMATION_MESSAGE,null);
					}				}
			});
			this.jScrollPane.setViewportView(this.tblListar);
		}
	else{
		tblListar = new JTable();
		this.jScrollPane.setViewportView(this.tblListar);
	}
	}
	//Devolve uma nova tabela com os dados da consulta
	private JTable tabelaPesquisa(String pesquisa,String filtro){
		String[] cabecalho= new String[]{"RESPONSAVEL","CÓDIGO CNES","TIPO UNIDADE"};
		List<Unidades> linhas=null;
		if(filtro.equals("Responsável"))
			linhas=Fachada.getInstancia().pegarUnidadesResponsavel(pesquisa);
		else if(filtro.equals("Tipo de unidade"))
			linhas=Fachada.getInstancia().pegarUnidadesTipo(pesquisa);
		if(linhas!=null){
			int size=linhas.size();
			String[][] dados= new String[size][3];
			for(int i=0;i<size;i++){
				dados[i][0]=linhas.get(i).getNomeResponsavel();
				dados[i][1]=linhas.get(i).getCnes();
				dados[i][2]=linhas.get(i).getTipoUnidade();
			}
			DefaultTableModel modelo = new DefaultTableModel(dados,cabecalho);
			JTable tabela = new JTable(modelo);
			tabela.setRowHeight(25);
			tabela.setShowGrid(true);
			tabela.setEnabled(true);
			tabela.setFont(new Font("Dialog", Font.PLAIN, 14));
			tabela.setRowSelectionAllowed(true);
			tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tabela.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					try{
						String cpf=getRowSelected();
						if(cpf!=null){
							unidadePrivada= new Unidades();
							unidadePrivada.setCnes(cpf);
							unidadePrivada=Fachada.getInstancia().pegarUnidade(unidadePrivada);
							if(unidadePrivada!=null)
								preencherDados(unidadePrivada);
						}
					}catch (Exception farmacia) {
						JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado\n" +
								"por favor contate o administrador do sistema!","Farmacia",JOptionPane.INFORMATION_MESSAGE,null);
					}
				}
			});
			return tabela;
		}
		return null;
	}
	//exclui unidade
	private String excluirUnidade(Unidades unidade){
		if(Fachada.getInstancia().excluirUnidade(unidade)){
			atualizarTabela();
			limparDados();
			unidadePrivada=null;
			return "Unidade excluída com sucesso!";
		}
		else{
			limparDados();
			unidadePrivada=null;
			return "Falha na exclusão da unidade!";
		}
	}
	//prenche os campos da tela
	private void preencherDados(Unidades unidade){
		txtBairro.setText(unidade.getBairro());
		txtCep.setText(unidade.getCep());
		txtCidade.setText(unidade.getCidade());
		txtCodigo.setText(unidade.getCnes());
		txtComplemento.setText(unidade.getComplemento());
		txtEndereco.setText(unidade.getLogradouro());
		txtFone.setText(unidade.getFone());
		txtNome.setText(unidade.getNomeResponsavel());
		cboxTipo.addItem(unidade.getTipoUnidade());
	}
	//pega a linha selecionada na tabela
	private String getRowSelected(){
		int linha= tblListar.getSelectedRow();
		if(linha>=0){
			return tblListar.getValueAt(linha, 1).toString();
		}
		return null;
	}
	//atualiza unidade
	private String atualizarUnidade(Unidades unidade){
		if(Fachada.getInstancia().atualizarUnidade(unidade)){
			limparDados();
			atualizarTabela();
			unidadePrivada=null;
			return "Unidade atualizada com sucesso!";
		}
		else{
			limparDados();
			unidadePrivada=null;
			return "Falha na atualização da unidade!";
		}
	} 
	
	

}  
