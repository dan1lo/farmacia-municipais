package view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import business.Usuario;
import javax.swing.JLabel;
import java.awt.Rectangle;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private Usuario usuarioPrivado;
	private JPanel jContentPane = null;
	private JMenuBar Menu = null;
	private JMenu menuCadastro = null;
	private JMenu menuEditar = null;
	private JMenuItem itemUsuario = null;
	private JMenuItem itemUnidade = null;
	private JMenuItem menuPaciente = null;
	private JMenuItem itemMedicamento = null;
	private JMenuItem CitemUsuario = null;
	private JMenuItem CitemUnidade = null;
	private JMenuItem CitemPaciente = null;
	private JMenuItem CitemMedicamento = null;
	private JMenu menuUsuario = null;
	private JMenuItem itemAlterarSenha = null;
	private JMenu menuMedicamentos = null;
	private JMenuItem itemReceberMedicamento = null;
	private JMenuItem itemDistribuirMedicamento = null;
	private JLabel jLabel = null;
	private JMenuItem CitemPrograma = null;
	private JMenuItem CitemFornecedor = null;
	private JMenuItem itemPrograma = null;
	private JMenuItem itemFornecedor = null;

	/**
	 * This is the default constructor
	 */
	public Principal() {
		super();
		initialize();
	}
	public Principal(Usuario user) {
		super();
		initialize();
		if(user!=null)
			this.usuarioPrivado=user;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(606, 558);
		this.setJMenuBar(getMenu());
		this.setContentPane(getJContentPane());
		this.setTitle("Farmacia - Sistema de gestão de medicamentos");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setIcon(new ImageIcon(getClass().getResource("/imagens/farmacia.jpg")));
			jLabel.setBounds(new Rectangle(6, 1, 491, 435));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel, null);
			jContentPane.setBackground(Color.WHITE);
		}
		return jContentPane;
	}

	/**
	 * This method initializes Menu	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getMenu() {
		if (Menu == null) {
			Menu = new JMenuBar();
			Menu.setPreferredSize(new Dimension(0,25));
			Menu.add(getMenuCadastro());
			Menu.add(getMenuEditar());
			Menu.add(getMenuUsuario());
			Menu.add(getMenuMedicamentos());
		}
		return Menu;
	}

	/**
	 * This method initializes menuCadastro	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getMenuCadastro() {
		if (menuCadastro == null) {
			menuCadastro = new JMenu("Cadastro");
			menuCadastro.add(getCitemUsuario());
			menuCadastro.add(getCitemUnidade());
			menuCadastro.add(getCitemPaciente());
			menuCadastro.add(getCitemMedicamento());
			menuCadastro.add(getCitemPrograma());
			menuCadastro.add(getCitemFornecedor());
		}
		return menuCadastro;
	}

	/**
	 * This method initializes menuEditar	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getMenuEditar() {
		if (menuEditar == null) {
			menuEditar = new JMenu("Manutenção");
			menuEditar.add(getItemUsuario());
			menuEditar.add(getItemUnidade());
			menuEditar.add(getMenuPaciente());
			menuEditar.add(getItemMedicamento());
			menuEditar.add(getItemPrograma());
			menuEditar.add(getItemFornecedor());
		}
		return menuEditar;
	}

	/**
	 * This method initializes itemUsuario	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemUsuario() {
		if (itemUsuario == null) {
			itemUsuario = new JMenuItem("Usuario");
			itemUsuario.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					new UsuarioCRUD();
				}
			});
		}
		return itemUsuario;
	}

	/**
	 * This method initializes itemUnidade	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemUnidade() {
		if (itemUnidade == null) {
			itemUnidade = new JMenuItem("Unidade");
			itemUnidade.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					 new UnidadeCRUD();
				}
			});
		}
		return itemUnidade;
	}

	/**
	 * This method initializes menuPaciente	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMenuPaciente() {
		if (menuPaciente == null) {
			menuPaciente = new JMenuItem("Paciente");
			menuPaciente.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return menuPaciente;
	}

	/**
	 * This method initializes itemMedicamento	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemMedicamento() {
		if (itemMedicamento == null) {
			itemMedicamento = new JMenuItem("Medicamento");
			itemMedicamento.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					new ListarMedicamentos();
				}
			});
		}
		return itemMedicamento;
	}

	/**
	 * This method initializes CitemUsuario	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getCitemUsuario() {
		if (CitemUsuario == null) {
			CitemUsuario = new JMenuItem("Usuario");
			CitemUsuario.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					new CadastrarUsuario();
				}
			});
		}
		return CitemUsuario;
	}

	/**
	 * This method initializes CitemUnidade	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getCitemUnidade() {
		if (CitemUnidade == null) {
			CitemUnidade = new JMenuItem("Unidade");
			CitemUnidade.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					 new CadastrarUnidade();
				}
			});
		}
		return CitemUnidade;
	}

	/**
	 * This method initializes CitemPaciente	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getCitemPaciente() {
		if (CitemPaciente == null) {
			CitemPaciente = new JMenuItem("Paciente");
			CitemPaciente.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					new CadastrarPaciente();
				}
			});
		}
		return CitemPaciente;
	}

	/**
	 * This method initializes CitemMedicamento	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getCitemMedicamento() {
		if (CitemMedicamento == null) {
			CitemMedicamento = new JMenuItem("Medicamento");
			CitemMedicamento.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					new TelaCadMedicamentos(null).abrirtela();
				}
			});
		}
		return CitemMedicamento;
	}

	/**
	 * This method initializes menuUsuario	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getMenuUsuario() {
		if (menuUsuario == null) {
			menuUsuario = new JMenu("Usuario");
			menuUsuario.add(getItemAlterarSenha());
		}
		return menuUsuario;
	}

	/**
	 * This method initializes itemAlterarSenha	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemAlterarSenha() {
		if (itemAlterarSenha == null) {
			itemAlterarSenha = new JMenuItem("Alterar senha");
			itemAlterarSenha.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					new AlteraSenha(usuarioPrivado);
				}
			});
		}
		return itemAlterarSenha;
	}

	/**
	 * This method initializes menuMedicamentos	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getMenuMedicamentos() {
		if (menuMedicamentos == null) {
			menuMedicamentos = new JMenu("Medicamentos");
			menuMedicamentos.add(getItemReceberMedicamento());
			menuMedicamentos.add(getItemDistribuirMedicamento());
		}
		return menuMedicamentos;
	}

	/**
	 * This method initializes itemReceberMedicamento	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemReceberMedicamento() {
		if (itemReceberMedicamento == null) {
			itemReceberMedicamento = new JMenuItem("Receber Medicamento");
			itemReceberMedicamento.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return itemReceberMedicamento;
	}

	/**
	 * This method initializes itemDistribuirMedicamento	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemDistribuirMedicamento() {
		if (itemDistribuirMedicamento == null) {
			itemDistribuirMedicamento = new JMenuItem("Distribuir Medicamento");
			itemDistribuirMedicamento
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							new PegarMedicamento(null);
							
						}
					});
		}
		return itemDistribuirMedicamento;
	}
	/**
	 * This method initializes CitemPrograma	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getCitemPrograma() {
		if (CitemPrograma == null) {
			CitemPrograma = new JMenuItem("Programa");
			CitemPrograma.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
				      new CadastrarPrograma();
				}
			});
			CitemPrograma.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return CitemPrograma;
	}
	/**
	 * This method initializes CitemFornecedor	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getCitemFornecedor() {
		if (CitemFornecedor == null) {
			CitemFornecedor = new JMenuItem("Fornecedor");
			CitemFornecedor.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					CadastrarFornecedor fornecedor= new CadastrarFornecedor();
					fornecedor.abrircadastro();
				}
			});
		}
		return CitemFornecedor;
	}
	/**
	 * This method initializes itemPrograma	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemPrograma() {
		if (itemPrograma == null) {
			itemPrograma = new JMenuItem("Programa");
			itemPrograma.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					new ListarPrograma();
				}
			});
		}
		return itemPrograma;
	}
	/**
	 * This method initializes itemFornecedor	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemFornecedor() {
		if (itemFornecedor == null) {
			itemFornecedor = new JMenuItem("Fornecedor");
			itemFornecedor.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					new ListarFornecedor();
				}
			});
		}
		return itemFornecedor;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
