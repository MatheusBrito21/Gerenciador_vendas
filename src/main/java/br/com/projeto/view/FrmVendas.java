package br.com.projeto.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.projeto.dao.DAO;
import br.com.projeto.model.Cliente;
import br.com.projeto.model.Item_venda;
import br.com.projeto.model.Produto;

@SuppressWarnings("serial")
public class FrmVendas extends JFrame {

	private JPanel FrmVendas;
	private JTextField field_nome;
	private JTextField field_cod_prod;
	private JTextField field_prod_nome;
	private JTextField field_qtd_prod;
	private JTextField field_preco_prod;
	private JTable tabela_itens_venda;
	private JTextField field_total_venda;
	
	private Produto produto_item = new Produto();

	//parametros que serao passados no construtor do recibo
	private List<Item_venda> lista_itens_venda = new ArrayList<>();
	private Cliente cliente;
	private Date data_venda;
	private double valor_total;
	
	public Date getData_venda() {
		return data_venda;
	}

	public void setData_venda(Date data_venda) {
		this.data_venda = data_venda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	


	public double getValor_total() {
		return valor_total;
	}

	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}

	public List<Item_venda> getLista_itens_venda() {
		return lista_itens_venda;
	}

	public void setLista_itens_venda(List<Item_venda> lista_itens_venda) {
		this.lista_itens_venda = lista_itens_venda;
	}

	public Produto getProduto_item() {
		return produto_item;
	}

	public void setProduto_item(Produto produto_item) {
		this.produto_item = produto_item;
	}

	public FrmVendas() throws ParseException {
//		setIconImage(Toolkit.getDefaultToolkit().getImage("//images/icon1.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 761, 606);
		FrmVendas = new JPanel();
		FrmVendas.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(FrmVendas);
		FrmVendas.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(5, 5, 735, 68);
		FrmVendas.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel titulo = new JLabel("Painel de Vendas");
		titulo.setFont(new Font("Arial Black", Font.BOLD, 25));
		titulo.setForeground(SystemColor.text);
		titulo.setBackground(new Color(240, 240, 240));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(titulo, BorderLayout.CENTER);
		
		JPanel painel_cliente = new JPanel();
		painel_cliente.setBackground(Color.GRAY);
		painel_cliente.setForeground(Color.GRAY);
		painel_cliente.setBounds(5, 98, 386, 118);
		FrmVendas.add(painel_cliente);
		painel_cliente.setLayout(null);
		
		JLabel lb_cpf = new JLabel("CPF:");
		lb_cpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_cpf.setBounds(24, 27, 40, 14);
		painel_cliente.add(lb_cpf);
		
		MaskFormatter cpf_format_text = new MaskFormatter("###.###.###-##");
		JFormattedTextField field_cpf_cliente = new JFormattedTextField(cpf_format_text);
		field_cpf_cliente.setBounds(55, 26, 100, 20);
		painel_cliente.add(field_cpf_cliente);
		
		JLabel lb_nome = new JLabel("Nome:");
		lb_nome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_nome.setBounds(24, 71, 46, 14);
		painel_cliente.add(lb_nome);
		
		field_nome = new JTextField();
		field_nome.setBounds(69, 70, 183, 20);
		painel_cliente.add(field_nome);
		field_nome.setColumns(10);
		
		JLabel lb_data_venda = new JLabel("Data:");
		lb_data_venda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_data_venda.setBounds(165, 27, 46, 14);
		painel_cliente.add(lb_data_venda);
		
//		MaskFormatter data_format_text = new MaskFormatter("##/##/####");
		JTextField field_data_venda = new JTextField();
		field_data_venda.setBounds(207, 26, 164, 20);
		painel_cliente.add(field_data_venda);
		
		JButton bt_pesquisar_cliente = new JButton("Pesquisar");
		bt_pesquisar_cliente.addActionListener(new ActionListener() {
			
		
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Cliente c = consultarCliente();
				//armazena o cliente em uma variavel do painel de venda
				//para ser enviado passado no construtor do recibo
				setCliente(c);
				
				field_nome.setText(c.getNome());
				field_cpf_cliente.setText(c.getCpf());
				Date data = new Date();
				setData_venda(data);
				field_data_venda.setText(data.toGMTString());
				
			}
		});
		bt_pesquisar_cliente.setBounds(262, 69, 110, 23);
		painel_cliente.add(bt_pesquisar_cliente);
		
		
		
		JPanel painel_produto = new JPanel();
		painel_produto.setBackground(Color.LIGHT_GRAY);
		painel_produto.setBounds(5, 227, 386, 316);
		FrmVendas.add(painel_produto);
		painel_produto.setLayout(null);
		
		JLabel lb_codigo = new JLabel("Código:");
		lb_codigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_codigo.setBounds(32, 45, 67, 14);
		painel_produto.add(lb_codigo);
		
		JLabel lb_produto = new JLabel("Produto:");
		lb_produto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_produto.setBounds(10, 71, 78, 14);
		painel_produto.add(lb_produto);
		
		JLabel lb_qtd = new JLabel("Qtd.");
		lb_qtd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_qtd.setBounds(32, 138, 46, 14);
		painel_produto.add(lb_qtd);
		
		JLabel lb_preco = new JLabel("Preço Unit.");
		lb_preco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_preco.setBounds(162, 138, 73, 23);
		painel_produto.add(lb_preco);
		
		JButton bt_adicionar_prod = new JButton("Adicionar Item");
		bt_adicionar_prod.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bt_adicionar_prod.setBounds(190, 224, 126, 21);
		bt_adicionar_prod.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				adicionarItem(produto_item);
				setValor_total(obterTotal());
				
				field_total_venda.setText(Double.toString(getValor_total()));
			}
		});
		painel_produto.add(bt_adicionar_prod);
		
		field_cod_prod = new JTextField();
		field_cod_prod.setBounds(86, 44, 86, 20);
		painel_produto.add(field_cod_prod);
		field_cod_prod.setColumns(10);
		
		field_prod_nome = new JTextField();
		field_prod_nome.setColumns(10);
		field_prod_nome.setBounds(86, 70, 230, 20);
		painel_produto.add(field_prod_nome);
		
		field_qtd_prod = new JTextField();
		field_qtd_prod.setColumns(10);
		field_qtd_prod.setBounds(66, 137, 86, 20);
		painel_produto.add(field_qtd_prod);
		
		field_preco_prod = new JTextField();
		field_preco_prod.setColumns(10);
		field_preco_prod.setBounds(230, 137, 86, 20);
		painel_produto.add(field_preco_prod);
		
		JButton bt_pesquisar_item = new JButton("Pesquisar");
		bt_pesquisar_item.setBounds(206, 45, 110, 19);
		bt_pesquisar_item.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Produto p = consultarProduto();
				setProduto_item(p);
				
				field_cod_prod.setText(Integer.toString(p.getId()));
				field_prod_nome.setText(p.getNome());
				field_preco_prod.setText(Double.toString(p.getPreco()));
				
			}
		});
		painel_produto.add(bt_pesquisar_item);
		
		JButton bt_limpar = new JButton("Limpar");
		bt_limpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bt_limpar.setBounds(63, 224, 109, 21);
		bt_limpar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				limparFormularioProd();
			}
		});
		painel_produto.add(bt_limpar);
		
		JPanel painel_venda = new JPanel();
		painel_venda.setBackground(SystemColor.inactiveCaption);
		painel_venda.setBounds(401, 98, 334, 446);
		FrmVendas.add(painel_venda);
		painel_venda.setLayout(null);
		
		
		String[]colunas ={
				"C\u00F3digo", "Produto", "Qtd", "Pre\u00E7o", "Subtotal"
			};
		Object[][] dados = {
			{null, null, null, null, null}};
		
		tabela_itens_venda = new JTable(dados,colunas);
		tabela_itens_venda.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tabela_itens_venda.setShowVerticalLines(true);
		tabela_itens_venda.setAutoResizeMode(NORMAL);
		tabela_itens_venda.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tabela_itens_venda.setSurrendersFocusOnKeystroke(true);
		tabela_itens_venda.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Produto", "Qtd", "Pre\u00E7o", "Subtotal"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabela_itens_venda.getColumnModel().getColumn(0).setPreferredWidth(49);
		tabela_itens_venda.getColumnModel().getColumn(1).setPreferredWidth(135);
		tabela_itens_venda.getColumnModel().getColumn(2).setPreferredWidth(46);
		tabela_itens_venda.getColumnModel().getColumn(3).setPreferredWidth(65);
		tabela_itens_venda.getColumnModel().getColumn(4).setPreferredWidth(58);
		
		JScrollPane scrollPane = new JScrollPane(tabela_itens_venda);
		tabela_itens_venda.setFillsViewportHeight(true);
		scrollPane.setBounds(0, 0, 334, 262);
		painel_venda.add(scrollPane);
		
		
		JPanel painel_total = new JPanel();
		painel_total.setBackground(SystemColor.activeCaptionBorder);
		painel_total.setBounds(10, 290, 279, 61);
		painel_venda.add(painel_total);
		painel_total.setLayout(null);
		
		JLabel lb_total = new JLabel("Total: R$");
		lb_total.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lb_total.setBounds(10, 25, 74, 25);
		painel_total.add(lb_total);
		
		field_total_venda = new JTextField();
		field_total_venda.setFont(new Font("Tahoma", Font.PLAIN, 16));
		field_total_venda.setBounds(90, 25, 137, 24);
		field_total_venda.setAlignmentX(LEFT_ALIGNMENT);
		painel_total.add(field_total_venda);
		field_total_venda.setColumns(10);
		
		JButton bt_finalizar = new JButton("Finalizar");
		bt_finalizar.setBounds(24, 381, 115, 23);
		bt_finalizar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ReciboVenda telaRecibo = new ReciboVenda(cliente, lista_itens_venda, data_venda,valor_total);
				telaRecibo.setVisible(true);
				telaRecibo.setLocationRelativeTo(null);
				
			}
		});
		painel_venda.add(bt_finalizar);
		
		JButton bt_cancelar = new JButton("Cancelar");
		bt_cancelar.setBounds(149, 381, 115, 23);
		bt_cancelar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				cancelarVenda();
				field_total_venda.setText("");
			}
		});
		painel_venda.add(bt_cancelar);
		
		
	
	}
	
	public Cliente consultarCliente() {
		DAO<Cliente> dao_cliente = new DAO<>(Cliente.class);
		String parametro = field_nome.getText()+"%";
		
		List<Cliente> lista = dao_cliente
			.consultar("consultarPorNome","nome", parametro);
		
		return lista.get(0);
	}
	
	public Produto consultarProduto() {
		
		DAO<Produto> dao_produto = new DAO<>(Produto.class);
		
		String porNome = field_prod_nome.getText()+"%";
		
		Produto p = new Produto();
		
		if(!field_prod_nome.getText().isBlank()) {
			p = dao_produto.consultar("consultarProdPorNome","nome", porNome).get(0);
		}else {
			Integer porCod = Integer.parseInt(field_cod_prod.getText());
			p = dao_produto.consultar("consultarProdPorId","id", porCod).get(0);
		}
		
		return p;
	}
	
	public void limparFormularioProd() {
		 field_prod_nome.setText("");
		 field_cod_prod.setText("");
		 field_preco_prod.setText("");
		 field_qtd_prod.setText("");
	}
	
	public void cancelarVenda() {
		lista_itens_venda.clear();
		DefaultTableModel tabela_itens = (DefaultTableModel)tabela_itens_venda.getModel();
		tabela_itens.setNumRows(0);
	}
	
	
	public void adicionarItem(Produto prod) {
		Item_venda iv = new Item_venda();
		
		
		iv.setProduto(getProduto_item());
		iv.setQtd(Integer.parseInt(field_qtd_prod.getText()));
		double subtotal = 
		Integer.parseInt(field_qtd_prod.getText()) * Double.parseDouble(field_preco_prod.getText());
		
		iv.setSubtotal(subtotal);
		
		lista_itens_venda.add(iv);
		
		DefaultTableModel tabela_itens = (DefaultTableModel)tabela_itens_venda.getModel();
		tabela_itens.setNumRows(0);
		
		for(Item_venda item: lista_itens_venda) {
			
			tabela_itens.addRow(new Object[] {
					item.getProduto().getId(),
					item.getProduto().getNome(),
					item.getQtd(),
					item.getProduto().getPreco(),
					item.getSubtotal()
			});
		}
		
		
	}
	
	public double obterTotal() {
		Function<Item_venda, Double> valores = i ->i.getSubtotal();
		BinaryOperator<Double> somar = (t,v) -> t+v;
		
		double total = lista_itens_venda.stream().map(valores).reduce(somar).get();
		
		return total;
	}
	
	
}//FimJanela
