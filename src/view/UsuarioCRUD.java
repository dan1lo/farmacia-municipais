package view;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import business.Fachada;
import business.Usuario;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;

import util.ImprimirJTable;
import util.Maskara;

public class UsuarioCRUD extends JDialog {

	private Usuario usuarioPrivado= null;  //  @jve:decl-index=0:
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTextField txtNome = null;
	private JLabel lblNome = null;
	private JLabel lblCpf = null;
	private JTextField txtCpf = null;
	private JLabel lblCargo = null;
	private JTextField txtCargo = null;
	private JLabel lblLogin = null;
	private JTextField txtLogin = null;
	private JScrollPane jScrollPane = null;
	private JTable tblListar = null;
	private JLabel lblPesquisa = null;
	private JTextField txtPesquisa = null;
	private JLabel lblFiltrar = null;
	private JComboBox cboxFiltro = null;
	private JButton btnPesquisar = null;
	private JLabel lblLinha1 = null;
	private JLabel lblLinha2 = null;
	private JButton btnListar = null;
	private JButton btnAtualizar = null;
	private JButton btnExcluir = null;
	private JButton btnLimpar = null;
	private JButton btnImprimir = null;
	private JLabel jLabel = null;
	
	
	public UsuarioCRUD() {
		super();
		initialize();
	}

	
	private void initialize() {
		this.setSize(564, 526);
		this.setContentPane(getJContentPane());
		this.setTitle("Consulta de Usuários");
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setVisible(true);
		
	}

	
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(0, 0, 556, 495));
			jLabel.setIcon(new ImageIcon(getClass().getResource("/imagens/brancoazul2.jpg")));
			lblLinha2 = new JLabel();
			lblLinha2.setBounds(new Rectangle(2, 241, 572, 14));
			lblLinha2.setFont(new Font("Dialog", Font.BOLD, 12));
			lblLinha2.setForeground(new Color(0, 0, 214));
			lblLinha2.setText("_______________________________________________________________________________");
			lblLinha1 = new JLabel();
			lblLinha1.setBounds(new Rectangle(-4, 136, 571, 18));
			lblLinha1.setForeground(new Color(0, 0, 214));
			lblLinha1.setText("_______________________________________________________________________________");
			lblFiltrar = new JLabel();
			lblFiltrar.setBounds(new Rectangle(13, 205, 72, 21));
			lblFiltrar.setText("Filtrar por:");
			lblPesquisa = new JLabel();
			lblPesquisa.setBounds(new Rectangle(13, 167, 70, 19));
			lblPesquisa.setText("Pesquisa:");
			lblLogin = new JLabel();
			lblLogin.setBounds(new Rectangle(12, 73, 54, 22));
			lblLogin.setText("Login:");
			lblCargo = new JLabel();
			lblCargo.setBounds(new Rectangle(313, 38, 53, 23));
			lblCargo.setText("Cargo:");
			lblCpf = new JLabel();
			lblCpf.setBounds(new Rectangle(11, 40, 55, 21));
			lblCpf.setText("CPF:");
			lblNome = new JLabel();
			lblNome.setBounds(new Rectangle(12, 10, 54, 20));
			lblNome.setText("Nome:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getTxtNome(), null);
			jContentPane.add(lblNome, null);
			jContentPane.add(lblCpf, null);
			jContentPane.add(getTxtCpf(), null);
			jContentPane.add(lblCargo, null);
			jContentPane.add(getTxtCargo(), null);
			jContentPane.add(lblLogin, null);
			jContentPane.add(getTxtLogin(), null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(lblPesquisa, null);
			jContentPane.add(getTxtPesquisa(), null);
			jContentPane.add(lblFiltrar, null);
			jContentPane.add(getCboxFiltro(), null);
			jContentPane.add(getBtnPesquisar(), null);
			jContentPane.add(lblLinha1, null);
			jContentPane.add(lblLinha2, null);
			jContentPane.add(getBtnListar(), null);
			jContentPane.add(getBtnAtualizar(), null);
			jContentPane.add(getBtnExcluir(), null);
			jContentPane.add(getBtnLimpar(), null);
			jContentPane.add(getBtnImprimir(), null);
			jContentPane.add(jLabel, null);
		}
		return jContentPane;
	}

	
	private JTextField getTxtNome() {
		if (txtNome == null) {
			txtNome = new JTextField();
			txtNome.setBounds(new Rectangle(74, 4, 456, 26));
			txtNome.setDocument(new business.NumeroMaximoCaracteres(30));
		}
		return txtNome;
	}
	

	
	private JTextField getTxtCpf() {
		if (txtCpf == null) {
			txtCpf = Maskara.getMascara("###########");
			txtCpf.setBounds(new Rectangle(73, 38, 231, 24));
			txtCpf.setEditable(false);
			//txtCpf.setDocument(new business.NumeroMaximoCaracteres(11));
		}
		return txtCpf;
	}

	
	private JTextField getTxtCargo() {
		if (txtCargo == null) {
			txtCargo = new JTextField();
			txtCargo.setBounds(new Rectangle(372, 38, 156, 24));
			txtCargo.setDocument(new business.NumeroMaximoCaracteres(15));
		}
		return txtCargo;
	}

	
	private JTextField getTxtLogin() {
		if (txtLogin == null) {
			txtLogin = new JTextField();
			txtLogin.setBounds(new Rectangle(72, 72, 229, 24));
			txtLogin.setDocument(new business.NumeroMaximoCaracteres(15));
		}
		return txtLogin;
	}

	
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(7, 273, 520, 208));
			jScrollPane.setViewportView(getTblListar());
		}
		return jScrollPane;
	}

	
	private JTable getTblListar() {
		if (tblListar == null) {
			String[] cabecalho= new String[]{"NOME    ","CPF    ","CARGO   "};
			List<Usuario> linhas=Fachada.getInstancia().pegarTodosUsuarios();
			if(linhas!=null){
				int size=linhas.size();
				String[][] dados= new String[size][3];
				for(int i=0;i<size;i++){
					dados[i][0]=linhas.get(i).getNome();
					dados[i][1]=linhas.get(i).getCpf();
					dados[i][2]=linhas.get(i).getCargo();
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
						if(cpf!=null ){
							usuarioPrivado= new Usuario();
							usuarioPrivado.setCpf(cpf);
							usuarioPrivado=Fachada.getInstancia().pegarUsuario(usuarioPrivado);
							if(usuarioPrivado!=null)
								preencherDados(usuarioPrivado);
						}
					}catch (Exception farmacia) {
						JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado\n" +
								"por favor contate o administrador do sistema!","Farmacia",JOptionPane.ERROR_MESSAGE,null);
					}
					}
				});
			}
			else{
				tblListar = new JTable();
			}
		}
		return tblListar;
	}

	
	private JTextField getTxtPesquisa() {
		if (txtPesquisa == null) {
			txtPesquisa = new JTextField();
			txtPesquisa.setBounds(new Rectangle(91, 165, 228, 26));
		}
		return txtPesquisa;
	}

	
	private JComboBox getCboxFiltro() {
		if (cboxFiltro == null) {
			cboxFiltro = new JComboBox();
			cboxFiltro.setBounds(new Rectangle(92, 202, 227, 27));
			this.cboxFiltro.addItem("Nome");
			this.cboxFiltro.addItem("Cargo");
		}
		return cboxFiltro;
	}

	
	private JButton getBtnPesquisar() {
		if (btnPesquisar == null) {
			btnPesquisar = new JButton();
			btnPesquisar.setBounds(new Rectangle(355, 203, 170, 30));
			btnPesquisar.setIcon(new ImageIcon(getClass().getResource("/imagens/consultar.png")));
			btnPesquisar.setText("Pesquisar");
			btnPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					try{
						JTable busca=null;
						if(!txtPesquisa.getText().isEmpty()){
							busca=getPesquisa(txtPesquisa.getText(),cboxFiltro.getSelectedItem().toString());
							if(busca!=null){
								tblListar=busca;
								jScrollPane.setViewportView(tblListar);
							}
							else {
								JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado!", 
										"Farmacia", JOptionPane.INFORMATION_MESSAGE, null);
							}
						}
					txtPesquisa.setText(null);
				}catch (Exception farmacia) {
					JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado\n" +
							"por favor contate o administrador do sistema!","Farmacia",JOptionPane.ERROR_MESSAGE,null);
				}
				}
			});
		}
		return btnPesquisar;
	}
	
	private JButton getBtnListar() {
		if (btnListar == null) {
			btnListar = new JButton();
			btnListar.setBounds(new Rectangle(354, 165, 174, 30));
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
	private JButton getBtnAtualizar() {
		if (btnAtualizar == null) {
			btnAtualizar = new JButton();
			btnAtualizar.setBounds(new Rectangle(151, 108, 116, 26));
			btnAtualizar.setIcon(new ImageIcon(getClass().getResource("/imagens/atualizar.png")));
			btnAtualizar.setText("Atualizar");
			btnAtualizar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					try{
						if(usuarioPrivado!=null){
							usuarioPrivado.setCargo(txtCargo.getText());
							usuarioPrivado.setLogin(txtLogin.getText());
							usuarioPrivado.setNome(txtNome.getText());
							String valida=Fachada.getInstancia().validarUsuario(usuarioPrivado, usuarioPrivado.getSenha());
							if(valida!=null ){
								JOptionPane.showMessageDialog(null, valida, "Farmacia",
										JOptionPane.INFORMATION_MESSAGE, null);
							}
							else if(valida==null ){
								String message= atualizaUsuario(usuarioPrivado);
								JOptionPane.showMessageDialog(null, message, "Farmacia",
										JOptionPane.INFORMATION_MESSAGE, null);
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
			btnExcluir.setBounds(new Rectangle(295, 106, 116, 28));
			btnExcluir.setIcon(new ImageIcon(getClass().getResource("/imagens/coisa.png")));
			btnExcluir.setText("Excluir");
			btnExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					try{
					if(usuarioPrivado!=null ){
						int opcao;
						String[] valores={"Sim", "Não"};
						opcao=JOptionPane.showOptionDialog(null, "Deseja realmente excluir a unidade?", 
								"Farmacia", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,
								null, valores, valores[0]);
						if(opcao==JOptionPane.YES_OPTION){
							String message= excluirUsuario(usuarioPrivado);
							JOptionPane.showMessageDialog(null, message, "Farmacia", 
									JOptionPane.INFORMATION_MESSAGE, null);
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
	
	private JButton getBtnLimpar() {
		if (btnLimpar == null) {
			btnLimpar = new JButton();
			btnLimpar.setBounds(new Rectangle(422, 107, 105, 26));
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
			btnImprimir.setBounds(new Rectangle(22, 107, 110, 26));
			btnImprimir.setText("Imprimir");
			btnImprimir.setIcon(new ImageIcon(getClass().getResource("/imagens/print.png")));
			btnImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					new ImprimirJTable(tblListar,"Usuários do sistema");
				
				}
			});
		}
		return btnImprimir;
	}

//------------------------------METODOS FATORADOS
	
	//atualiza a tabela
	private void atualizarTabela(){
		String[] cabecalho= new String[]{"NOME    ","CPF    ","CARGO   "};
		List<Usuario> linhas=Fachada.getInstancia().pegarTodosUsuarios();
		if(linhas!=null){
			int size=linhas.size();
			String[][] dados= new String[size][3];
			for(int i=0;i<size;i++){
				dados[i][0]=linhas.get(i).getNome();
				dados[i][1]=linhas.get(i).getCpf();
				dados[i][2]=linhas.get(i).getCargo();
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
						usuarioPrivado= new Usuario();
						usuarioPrivado.setCpf(cpf);
						usuarioPrivado=Fachada.getInstancia().pegarUsuario(usuarioPrivado);
						if(usuarioPrivado!=null)
							preencherDados(usuarioPrivado);
					}
					}catch (Exception farmacia) {
						JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado\n" +
								"por favor contate o administrador do sistema!","Farmacia",JOptionPane.INFORMATION_MESSAGE,null);
					}
				}
			});
			this.jScrollPane.setViewportView(this.tblListar);
		}
		else{
			tblListar= new JTable();
			this.jScrollPane.setViewportView(this.tblListar);
		}
	}
	//limpa os campos da tela
	private void limparDados(){
		txtNome.setText(null);
		txtCargo.setText(null);
		txtLogin.setText(null);
		txtCpf.setText(null);
		usuarioPrivado=null;
	}

	// atualiza a tabela
	private String atualizaUsuario(Usuario user){
		if(Fachada.getInstancia().atualizarUsuario(user)){
			limparDados();
			atualizarTabela();
			usuarioPrivado=null;
			return "Usuário atualizado com sucesso";
		}
		else{
			limparDados();
			usuarioPrivado=null;
			return "Falha na atualização do usuário!";
		}
	}
	// prenche os capos da tela
	private void preencherDados(Usuario user){
		txtNome.setText(user.getNome());
		txtCargo.setText(user.getCargo());
		txtLogin.setText(user.getLogin());
		txtCpf.setText(user.getCpf());
	}
	// pega a linha selecionada
	private String getRowSelected(){
		int linha= tblListar.getSelectedRow();
		if(linha>=0){
			return tblListar.getValueAt(linha, 1).toString();
		}
		return null;
	}
	//exclui usuario
	private String excluirUsuario(Usuario user){
		if(Fachada.getInstancia().excluirUsuario(user)){
			limparDados();
			usuarioPrivado=null;
			atualizarTabela();
			return "Usuário excluído com sucesso!";
		}
		else{
			limparDados();
			usuarioPrivado=null;
			return	"Falha na exclusão do usuário!";
		}

	}
	//devolve uma tabela com os dados da consulta
	private JTable getPesquisa(String pesquisa, String filtro){
		List<Usuario> usuarios=null;
		JTable tabela=null;
		if(filtro.equals("Nome"))
			usuarios=Fachada.getInstancia().pegarUsuariosNome(pesquisa);
		else if(filtro.equals("Cargo"))
			usuarios=Fachada.getInstancia().pegarUsuariosCargo(pesquisa);
		if(usuarios!=null){
			String[] cabecalho= new String[]{"NOME    ","CPF    ","CARGO   "};
			int size=usuarios.size();
			String[][] dados= new String[size][3];
			for(int i=0;i<size;i++){
				dados[i][0]=usuarios.get(i).getNome();
				dados[i][1]=usuarios.get(i).getCpf();
				dados[i][2]=usuarios.get(i).getCargo();
			}
			DefaultTableModel modelo = new DefaultTableModel(dados,cabecalho);
			tabela = new JTable(modelo);
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
						usuarioPrivado= new Usuario();
						usuarioPrivado.setCpf(cpf);
						usuarioPrivado=Fachada.getInstancia().pegarUsuario(usuarioPrivado);
						if(usuarioPrivado!=null)
							preencherDados(usuarioPrivado);
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

	
}  
