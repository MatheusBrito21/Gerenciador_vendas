package br.com.projeto.view;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.projeto.dao.DAO;
import br.com.projeto.model.Cliente;
import br.com.projeto.model.Item_venda;
import br.com.projeto.model.Venda;

@SuppressWarnings("serial")
public class ReciboVenda extends JFrame {

	private JPanel tela_recibo;
	private JTable lista_itens_venda;

	public ReciboVenda(Cliente c, List<Item_venda> lista, Date data, double valor_total) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		tela_recibo = new JPanel();
		tela_recibo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(tela_recibo);
		tela_recibo.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 212, 364, 160);
		tela_recibo.add(scrollPane);

		lista_itens_venda = new JTable();
		lista_itens_venda.setBackground(new Color(180, 180, 180));
		lista_itens_venda.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "C\u00F3digo", "Produto", "Qtd", "Pre\u00E7o", "Subtotal" }));
		scrollPane.setViewportView(lista_itens_venda);
		
		
		DefaultTableModel tabela_itens = (DefaultTableModel) lista_itens_venda.getModel();
		tabela_itens.setNumRows(0);

		for (Item_venda item : lista) {

			tabela_itens.addRow(new Object[] {
					item.getProduto().getId(),
					item.getProduto().getNome(), 
					item.getQtd(),
					item.getProduto().getPreco(), 
					item.getSubtotal() });
		}
		

		JPanel painel_codigo_venda = new JPanel();
		painel_codigo_venda.setBackground(Color.GRAY);
		painel_codigo_venda.setBounds(10, 11, 364, 201);
		tela_recibo.add(painel_codigo_venda);
		painel_codigo_venda.setLayout(null);

		@SuppressWarnings("deprecation")
		JLabel lb_data = new JLabel(data.toGMTString());
		lb_data.setBounds(103, 30, 163, 14);
		lb_data.setVerticalAlignment(SwingConstants.BOTTOM);
		lb_data.setHorizontalAlignment(SwingConstants.LEFT);
		painel_codigo_venda.add(lb_data);

		JLabel title_aplicacao = new JLabel("Minon - Gerenciador de Vendas");
		title_aplicacao.setBounds(80, 5, 200, 14);
		title_aplicacao.setVerticalAlignment(SwingConstants.BOTTOM);
		title_aplicacao.setHorizontalAlignment(SwingConstants.CENTER);
		painel_codigo_venda.add(title_aplicacao);

		JLabel linha = new JLabel("********************************************************");
		linha.setBounds(10, 57, 344, 14);
		painel_codigo_venda.add(linha);

		JLabel lb_cliente = new JLabel("Cliente:");
		lb_cliente.setBounds(10, 70, 46, 14);
		painel_codigo_venda.add(lb_cliente);

		JLabel lb_end_forn = new JLabel("Endereço:");
		lb_end_forn.setBounds(10, 130, 59, 14);
		painel_codigo_venda.add(lb_end_forn);

		JLabel lb_cliente_nome = new JLabel(c.getNome());
		lb_cliente_nome.setBounds(52, 70, 291, 14);
		painel_codigo_venda.add(lb_cliente_nome);

		JLabel lb_end_forn_dados = new JLabel("New label");
		lb_end_forn_dados.setBounds(80, 130, 274, 14);
		painel_codigo_venda.add(lb_end_forn_dados);

		JLabel linha_1 = new JLabel("********************************************************");
		linha_1.setBounds(10, 155, 344, 14);
		painel_codigo_venda.add(linha_1);

		JLabel linha_1_1 = new JLabel("********************************************************");
		linha_1_1.setBounds(10, 91, 344, 14);
		painel_codigo_venda.add(linha_1_1);

		JLabel lb_itens = new JLabel("Itens");
		lb_itens.setVerticalAlignment(SwingConstants.BOTTOM);
		lb_itens.setHorizontalAlignment(SwingConstants.CENTER);
		lb_itens.setBounds(80, 176, 200, 14);
		painel_codigo_venda.add(lb_itens);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(10, 409, 364, 41);
		tela_recibo.add(panel);
		panel.setLayout(null);

		JButton bt_confirmar_venda = new JButton("Confirmar");
		bt_confirmar_venda.setBounds(200, 11, 89, 23);
		bt_confirmar_venda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				registrarVenda(c, lista, data, valor_total);
			}
		});
		panel.add(bt_confirmar_venda);

		JButton bt_cancelar = new JButton("Cancelar");
		bt_cancelar.setBounds(64, 11, 89, 23);
		bt_cancelar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				fecharJanela();
			}
		});
		panel.add(bt_cancelar);
		
		JLabel lb_total = new JLabel("Total: R$");
		lb_total.setBounds(30, 383, 55, 14);
		tela_recibo.add(lb_total);
		
		JLabel lb_valor_total = new JLabel(Double.toString(valor_total));
		lb_valor_total.setBounds(82, 383, 104, 14);
		tela_recibo.add(lb_valor_total);
	}

	public void registrarVenda(Cliente cliente,List<Item_venda> lista,Date data,double total) {
		
		DAO<Venda> dao_venda = new DAO<>(Venda.class);
		Venda recibo_venda = new Venda(cliente, lista, total,data);
		
		dao_venda.incluirAtomico(recibo_venda);
		JOptionPane.showMessageDialog(null, "Código Pedido:"+recibo_venda.getId()+"\nCompra finalizada!");
		this.dispose();
	}
	
	public void fecharJanela() {
		this.dispose();
	}

}
