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
import br.com.projeto.model.Fornecedor;
import br.com.projeto.model.Produto;

@SuppressWarnings("serial")
public class FrmProdutos extends JFrame {

	private JPanel FrmProdutos;
	private JTextField field_codigo;
	private JTextField field_nome_prod;
	private JTextField field_preco;
	private JTextField field_qtd_estoque;
	private JTextField field_consul_nome;
	private JComboBox<Fornecedor> box_fornecedor;
	

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
		
		box_fornecedor = new JComboBox<Fornecedor>();
		box_fornecedor.removeAll();
		for(Fornecedor f : listarFornecedor()) {
			box_fornecedor.addItem(f);
		}
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
				 field_preco.setText((String) tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(),2).toString());
				 field_qtd_estoque.setText((String) tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(),3).toString());
				 box_fornecedor.setSelectedItem(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 4).toString());
				
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
				listarProdutos();
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
				cadastrarProduto();
			}
		});
		FrmProdutos.add(bt_salvar);
		
		JButton bt_editar = new JButton("Alterar");
		bt_editar.setBounds(233, 519, 89, 23);
		bt_editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarProduto();
			}
		});
		FrmProdutos.add(bt_editar);
		
		JButton bt_excluir = new JButton("Excluir");
		bt_excluir.setBounds(333, 519, 89, 23);
		bt_excluir.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				excluirProduto();
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
	
	public List<Fornecedor> listarFornecedor() {
		
		DAO<Fornecedor> dao_f = new DAO<>(Fornecedor.class);
		List<Fornecedor>lista_f = dao_f.abriT().obterTodosP();
	
		return lista_f;
	}
	
	public void cadastrarProduto() {
		Produto p = new Produto();
		DAO<Produto> dao_produto = new DAO<>(Produto.class);
			p.setNome(field_nome_prod.getText());
			
			//converte o valor para o formato correto para Double
			if(field_preco.getText().contains(",")) {
				String preco_format = field_preco.getText().replace(",", ".");
				p.setPreco(Double.parseDouble(preco_format));
			}else {
				p.setPreco(Double.parseDouble(field_preco.getText()));				
			}
			p.setQtd_estoque(Integer.parseInt(field_qtd_estoque.getText()));
			p.setFornecedor((Fornecedor)box_fornecedor.getSelectedItem());
			
		dao_produto.incluirAtomico(p);
		JOptionPane.showMessageDialog(FrmProdutos,"Novo produto cadastrado!\nNome: "+ p.getNome());
	}
	
	public void listarProdutos() {
		DAO<Produto> dao_prod = new DAO<>(Produto.class);
		String parametro = field_consul_nome.getText()+"%";
		
		List<Produto> lista = dao_prod
			.consultar("consultarProdPorNome","nome", parametro);
		
		DefaultTableModel dados_tabela = (DefaultTableModel) tabelaProdutos.getModel();
		//limpa a tabela
		dados_tabela.setNumRows(0);
		
		for(Produto p: lista) {
			dados_tabela.addRow(new Object[]{
					p.getId(),
					p.getNome(),
					p.getPreco(),
					p.getQtd_estoque(),
					p.getFornecedor()
		
			});
		}
	}
	
	public void alterarProduto() {
		Produto p = new Produto();
		DAO<Produto> dao_produto = new DAO<>(Produto.class);
		Integer parametro = Integer.parseInt(field_codigo.getText());
		
		p = dao_produto.consultar("consultarProdPorId","id",parametro).get(0);
		
		p.setNome(field_nome_prod.getText());
		p.setPreco(Double.parseDouble(field_preco.getText()));
		p.setQtd_estoque(Integer.parseInt(field_qtd_estoque.getText()));
		p.setFornecedor((Fornecedor)box_fornecedor.getSelectedItem());
		
		dao_produto.alterar(p);
		limparFormulario();
		JOptionPane.showMessageDialog(FrmProdutos,"Produtos: "+ p.getNome()+"\nDados atualizados!");
	}
	
	public void excluirProduto() {
		Produto p = new Produto();
		DAO<Produto> dao_produto = new DAO<>(Produto.class);
		Integer parametro = Integer.parseInt(field_codigo.getText());
		
		p = dao_produto.consultar("consultarProdPorId","id",parametro).get(0);
		
		dao_produto.excluir(p);
		limparFormulario();
		JOptionPane.showMessageDialog(FrmProdutos,"Produto: "+ p.getNome()+"\nDados excluídos!");
	}
	
	
		
		
	
}//FimJanela
