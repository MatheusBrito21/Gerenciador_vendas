package br.com.projeto.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class FrmMenu extends JFrame {

	private JPanel Menu;
	JLabel lb_usuarioConectado;
	JLabel lb_nivel_acesso;
	

	ImageIcon icon = new ImageIcon(getClass().getResource("/images/fundo2.jpg"));
	Image image = icon.getImage();
	
	private final JDesktopPane desktopPane = new JDesktopPane() {
		
		public void paintComponent(Graphics g) {
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		}
	};

	/**
	 * Create the frame.
	 */
	public FrmMenu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmMenu.class.getResource("/images/vendas.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JMenuBar barra_menu = new JMenuBar();
		setJMenuBar(barra_menu);
		
		JMenuItem menu_cliente = new JMenuItem("Clientes");
		menu_cliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				FrmClientes janelaClientes;
				try {
					janelaClientes = new FrmClientes();
					janelaClientes.setVisible(true);
					janelaClientes.setLocationRelativeTo(null);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		barra_menu.add(menu_cliente);
		
		JMenuItem menu_funcionarios = new JMenuItem("Funcionários");
		menu_funcionarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				FrmFuncionarios janelaFuncionarios;
				try {
					janelaFuncionarios = new FrmFuncionarios();
					janelaFuncionarios.setVisible(true);
					janelaFuncionarios.setLocationRelativeTo(null);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		barra_menu.add(menu_funcionarios);
		
		JMenuItem menu_fornecedor = new JMenuItem("Fornecedores");
		menu_fornecedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmFornecedores janelaFornecedores;
				try {
					janelaFornecedores = new FrmFornecedores();
					janelaFornecedores.setVisible(true);
					janelaFornecedores.setLocationRelativeTo(null);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		barra_menu.add(menu_fornecedor);
		
		JMenuItem menu_produtos = new JMenuItem("Produtos");
		menu_produtos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmProdutos janelaProdutos;
				try {
					janelaProdutos = new FrmProdutos();
					janelaProdutos.setVisible(true);
					janelaProdutos.setLocationRelativeTo(null);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		barra_menu.add(menu_produtos);
		
		JMenuItem menu_vendas = new JMenuItem("Vendas");
		menu_vendas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmVendas janelaVendas;
				try {
					janelaVendas = new FrmVendas();
					janelaVendas.setVisible(true);
					janelaVendas.setLocationRelativeTo(null);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		barra_menu.add(menu_vendas);
		
		JMenu menu_config = new JMenu("Configurações");
		barra_menu.add(menu_config);
		
		JButton bt_logout = new JButton("Logout");
		bt_logout.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				fecharAplicacao();
				FrmLogin janelaLogin;
				
				janelaLogin = new FrmLogin();
				janelaLogin.setVisible(true);
				janelaLogin.setLocationRelativeTo(null);
			}
		});
		menu_config.add(bt_logout);
		
		JButton bt_sair = new JButton("Sair");
		bt_sair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fecharAplicacao();
			}
		});
		menu_config.add(bt_sair);
		Menu = new JPanel();
		Menu.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Menu);
		Menu.setLayout(null);
		desktopPane.setBounds(0, 0, 784, 533);
		Menu.add(desktopPane);
		desktopPane.setLayout(null);
		
		JPanel painel_status = new JPanel();
		painel_status.setBounds(0, 503, 784, 30);
		desktopPane.add(painel_status);
		painel_status.setLayout(null);
		
		JLabel lb_usuario = new JLabel("Usuário:");
		lb_usuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_usuario.setBounds(40, 11, 64, 14);
		painel_status.add(lb_usuario);
		
		lb_usuarioConectado = new JLabel("user");
		lb_usuarioConectado.setForeground(Color.BLUE);
		lb_usuarioConectado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_usuarioConectado.setBounds(100, 11, 249, 14);
		painel_status.add(lb_usuarioConectado);
		
		JLabel lb_acesso = new JLabel("Nivel de Acesso:");
		lb_acesso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_acesso.setBounds(378, 11, 106, 14);
		painel_status.add(lb_acesso);
		
		lb_nivel_acesso = new JLabel("default");
		lb_nivel_acesso.setForeground(new Color(0, 100, 0));
		lb_nivel_acesso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_nivel_acesso.setBounds(490, 11, 196, 14);
		painel_status.add(lb_nivel_acesso);
		
	}
	
	public void fecharAplicacao() {
		this.dispose();
	}
}
