package br.com.projeto.view;

import java.text.ParseException;

public class TesteVenda {

	public static void main(String[] args) throws ParseException {
		
//		Fornecedor f = new Fornecedor();
//		f.setNome("Dell Informatica");
//		
//		Cliente c = new Cliente();
//		c.setNome("Joao");
//		
//		Produto p = new Produto("Dell Optiplex 7010", 1299.9, 1, f);
//		Produto p1 = new Produto("Dell Optiplex 3010", 1000.9, 1, f);
//		Produto p2 = new Produto("Dell Optiplex 3050", 1499.9, 1, f);
//		Produto p3 = new Produto("Dell Optiplex 3020", 999.9, 1, f);
//		
//		Item_venda iv = new Item_venda(10, p.getPreco()* 10, p);
//		Item_venda iv1 = new Item_venda(25, p1.getPreco()* 25, p1);
//		Item_venda iv2 = new Item_venda(30, p2.getPreco()* 30, p2);
//		Item_venda iv3 = new Item_venda(20, p3.getPreco()* 20, p3);
//		
//		List<Item_venda> lista = new ArrayList<>();
//		lista.add(iv);
//		lista.add(iv1);
//		lista.add(iv2);
//		lista.add(iv3);
//
//		
//		Venda v = new Venda();
//		v.setCliente(c);
//		v.setItens(lista);
//		
//		double aux = 0;
//		for(Item_venda itv: v.getItens()) {
//			v.setTotal(aux += itv.getSubtotal());
//			System.out.println(itv.getProduto()+" Qtd:"+itv.getQtd() + " Subtotal: R$"+itv.getSubtotal());
//		}
//		System.out.println(v);
//		
		
		FrmVendas janelaVenda = new FrmVendas();
		janelaVenda.setVisible(true);
		
	}

}
