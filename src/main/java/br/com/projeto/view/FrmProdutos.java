package br.com.projeto.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.com.projeto.dao.DAO;
import br.com.projeto.dao.WebServiceCep;
import br.com.projeto.model.Cliente;

@SuppressWarnings("serial")
public class FrmProdutos extends JFrame {

	private JPanel FrmProdutos;
	private JTextField field_codigo;
	private JTextField field_nome_prod;
	private JTextField field_preco;
	private JTextField field_qtd_estoque;
	private JTextField field_consul_nome;
	private JComboBox<String> box_fornecedor;
	

	private JTable tabelaProdutos;
	
	


	public FrmProdutos() throws ParseException {
//		setIconImage(Toolkit.getDefaultToolkit().getImage("//images/icon1.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 761, 606);
		FrmProdutos = new JPanel();
		FrmProdutos.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(FrmProdutos);
		FrmProdutos.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(5, 5, 735, 68);
		FrmProdutos.add(panel);
		panel.setLayout(null);
		
		JLabel titulo = new JLabel("Cadastro de Produtos");
		titulo.setFont(new Font("Arial Black", Font.BOLD, 25));
		titulo.setBounds(10, 25, 351, 32);
		titulo.setForeground(SystemColor.text);
		titulo.setBackground(new Color(240, 240, 240));
		titulo.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(titulo);
		
		JTabbedPane janelas = new JTabbedPane(JTabbedPane.TOP);
		janelas.setBounds(15, 84, 720, 424);
		FrmProdutos.add(janelas);
		
		
//		MaskFormatter formatTextCelField = new MaskFormatter("(##) #####-####");
//		
//		MaskFormatter formatTextTelField = new MaskFormatter("(##) ####-####");
//		
//		MaskFormatter formatTextCPFField = new MaskFormatter("###.###.###-##");
//		MaskFormatter formatTextCEPField = new MaskFormatter("#####-###");
//		
	
		
		JPanel DadosPessoais = new JPanel();
		janelas.addTab("Dados do Produto", null, DadosPessoais, null);
		DadosPessoais.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(35, 40, 46, 21);
		DadosPessoais.add(lblNewLabel_1);
		
		field_codigo = new JTextField();
		field_codigo.setEditable(false);
		field_codigo.setColumns(10);
		field_codigo.setBounds(78, 40, 99, 20);
		DadosPessoais.add(field_codigo);
		
		JLabel lb_nomeProd = new JLabel("Nome:");
		lb_nomeProd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lb_nomeProd.setBounds(35, 75, 46, 21);
		DadosPessoais.add(lb_nomeProd);
		
		field_nome_prod = new JTextField();
		field_nome_prod.setColumns(10);
		field_nome_prod.setBounds(78, 75, 253, 20);
		DadosPessoais.add(field_nome_prod);
		
		JLabel lb_preco = new JLabel("Preço:");
		lb_preco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lb_preco.setBounds(35, 118, 58, 21);
		DadosPessoais.add(lb_preco);
		
		field_preco = new JTextField();
		field_preco.setColumns(10);
		field_preco.setBounds(78, 118, 99, 20);
		DadosPessoais.add(field_preco);
		
		JLabel lb_qtd_estoque = new JLabel("Qtd.Estoque:");
		lb_qtd_estoque.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lb_qtd_estoque.setBounds(187, 118, 86, 21);
		DadosPessoais.add(lb_qtd_estoque);
		
		field_qtd_estoque = new JTextField();
		field_qtd_estoque.setColumns(10);
		field_qtd_estoque.setBounds(268, 119, 114, 20);
		DadosPessoais.add(field_qtd_estoque);
		
		JLabel lb_fornecedor = new JLabel("Fornecedor:");
		lb_fornecedor.setBounds(35, 160, 86, 21);
		DadosPessoais.add(lb_fornecedor);
		
		box_fornecedor = new JComboBox<String>();
		box_fornecedor.setModel(new DefaultComboBoxModel<String>(new String[] {"Fornecedor 1 ", "Fornecedor 2", "Fornecedor 3", "Fornecedor 4"}));
		box_fornecedor.setSelectedIndex(0);
		box_fornecedor.setBounds(119, 160, 212, 22);
		DadosPessoais.add(box_fornecedor);
		
		
		JPanel ConsultarCliente = new JPanel();
		janelas.addTab("Consultar Produtos", null, ConsultarCliente, null);
		ConsultarCliente.setLayout(null);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Nome:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_2.setBounds(29, 47, 46, 21);
		ConsultarCliente.add(lblNewLabel_1_1_2);
		
		field_consul_nome = new JTextField();
		field_consul_nome.setColumns(10);
		field_consul_nome.setBounds(72, 47, 253, 20);
		ConsultarCliente.add(field_consul_nome);
		
		//ao clicar na linha selecionada na tabela
		//os dados serao enviados para os respectivos campos na janela Dados pessoais
		//ao clicar em editar os dados serao atualizados
		tabelaProdutos = new JTable();
		tabelaProdutos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				janelas.setSelectedIndex(0);
				
				 field_codigo.setText( tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(),0).toString());
				 field_nome_prod.setText((String) tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(),1).toString());
				 field_preco.setText((String) tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(),11).toString());
				 field_qtd_estoque.setText((String) tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(),12).toString());
				 box_fornecedor.setSelectedItem(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 13).toString());
				
			}
		});
		tabelaProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelaProdutos.setShowVerticalLines(true);
		tabelaProdutos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tabelaProdutos.setSurrendersFocusOnKeystroke(true);
		tabelaProdutos.setToolTipText("");
		tabelaProdutos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Descri\u00E7\u00E3o", "Pre\u00E7o", "Qtd. Estoque", "Fornecedor"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		JButton bt_pesquisar = new JButton("Pesquisar");
		bt_pesquisar.setBounds(335, 47, 103, 23);
		bt_pesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarClientes();
			}
		});
		ConsultarCliente.add(bt_pesquisar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 158, 676, 141);
		scrollPane.setViewportView(tabelaProdutos);
		ConsultarCliente.add(scrollPane);
		
		JButton bt_novo = new JButton("Limpar");
		bt_novo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparFormulario();
			}
		});
		bt_novo.setBounds(25, 519, 89, 23);
		FrmProdutos.add(bt_novo);
		
		JButton bt_salvar = new JButton("Cadastrar");
		bt_salvar.setBounds(124, 519, 102, 23);
		bt_salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarCliente();
			}
		});
		FrmProdutos.add(bt_salvar);
		
		JButton bt_editar = new JButton("Alterar");
		bt_editar.setBounds(233, 519, 89, 23);
		bt_editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarCliente();
			}
		});
		FrmProdutos.add(bt_editar);
		
		JButton bt_excluir = new JButton("Excluir");
		bt_excluir.setBounds(333, 519, 89, 23);
		bt_excluir.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				excluirCliente();
			}
		});
		FrmProdutos.add(bt_excluir);
		
		
		
	}
	public TableModel getTableModel() {
		return tabelaProdutos.getModel();
	}
	public void setTableModel(TableModel model) {
		tabelaProdutos.setModel(model);
	}
	
	//botao Novo
	public void limparFormulario() {
		 field_codigo.setText("");
		 field_nome_prod.setText("");
		 field_preco.setText("");
		 field_qtd_estoque.setText("");
		 field_consul_nome.setText("");
		 
		 tabelaProdutos.clearSelection();
	};
	
	public void cadastrarCliente() {
		Cliente c = new Cliente();
		DAO<Cliente> dao_cliente = new DAO<>(Cliente.class);
			c.setNome(field_nome_prod.getText());
			c.setBairro(field_preco.getText());
			c.setCidade(field_qtd_estoque.getText());
			c.setEstado(box_fornecedor.getItemAt(box_fornecedor.getSelectedIndex()));
			
		dao_cliente.incluirAtomico(c);
		JOptionPane.showMessageDialog(FrmProdutos,"Novo usuário cadastrado!\nNome: "+ c.getNome());
	}
	
	public void listarClientes() {
		DAO<Cliente> dao_cliente = new DAO<>(Cliente.class);
		String parametro = field_consul_nome.getText()+"%";
		
		List<Cliente> lista = dao_cliente
			.consultar("consultarPorNome","nome", parametro);
		
		DefaultTableModel dados_tabela = (DefaultTableModel) tabelaProdutos.getModel();
		//limpa a tabela
		dados_tabela.setNumRows(0);
		
		for(Cliente c: lista) {
			dados_tabela.addRow(new Object[]{
					c.getId(),
					c.getNome(),
					c.getEmail(),
					c.getCelular(),
					c.getTelefone(),
					c.getCpf(),
					c.getRg(),
					c.getCep(),
					c.getEndereco(),
					c.getNumero(),
					c.getComplemento(),
					c.getBairro(),
					c.getCidade(),
					c.getEstado()
			});
		}
	}
	
	public void alterarCliente() {
		Cliente c = new Cliente();
		DAO<Cliente> dao_cliente = new DAO<>(Cliente.class);
		Integer parametro = Integer.parseInt(field_codigo.getText());
		
		c = dao_cliente.consultar("consultarPorId","id",parametro).get(0);
		
		c.setNome(field_nome_prod.getText());
		c.setBairro(field_preco.getText());
		c.setCidade(field_qtd_estoque.getText());
		c.setEstado(box_fornecedor.getItemAt(box_fornecedor.getSelectedIndex()));
		
		dao_cliente.alterar(c);
		limparFormulario();
		JOptionPane.showMessageDialog(FrmProdutos,"Usuário: "+ c.getNome()+"\nDados atualizados!");
	}
	
	public void excluirCliente() {
		Cliente c = new Cliente();
		DAO<Cliente> dao_cliente = new DAO<>(Cliente.class);
		Integer parametro = Integer.parseInt(field_codigo.getText());
		
		c = dao_cliente.consultar("consultarPorId","id",parametro).get(0);
		
		dao_cliente.excluir(c);
		limparFormulario();
		JOptionPane.showMessageDialog(FrmProdutos,"Usuário: "+ c.getNome()+"\nDados excluídos!");
	}
	
	  public Cliente buscaCep(String cep) {
	       
	        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
	       

	        Cliente obj = new Cliente();

	        if (webServiceCep.wasSuccessful()) {
	            obj.setEndereco(webServiceCep.getLogradouroFull());
	            obj.setCidade(webServiceCep.getCidade());
	            obj.setBairro(webServiceCep.getBairro());
	            obj.setEstado(webServiceCep.getEstado());
	            return obj;
	        } else {
	            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
	            JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
	            return null;
	        }

	    }
		
		
	
}//FimJanela
