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
import javax.swing.JFormattedTextField;
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
import javax.swing.text.MaskFormatter;

import br.com.projeto.dao.DAO;
import br.com.projeto.model.Fornecedor;

@SuppressWarnings("serial")
public class FrmFornecedores extends JFrame {

	private JPanel FrmFornecedor;
	private JTextField field_codigo;
	private JTextField field_nome;
	private JTextField field_email;
	private JTextField field_endereco;
	private JTextField field_numero;
	private JTextField field_compl;
	private JTextField field_bairro;
	private JTextField field_cidade;
	private JTextField field_consul_nome;
	private static JFormattedTextField field_celular;
	private static JFormattedTextField field_telefone;
	private static JFormattedTextField field_cep;
	private static JFormattedTextField field_cnpj;
	private JComboBox<String> box_uf;
	

	private JTable tabelaFornecedores;
	
	


	public FrmFornecedores() throws ParseException {
//		setIconImage(Toolkit.getDefaultToolkit().getImage("//images/icon1.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 761, 606);
		FrmFornecedor = new JPanel();
		FrmFornecedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(FrmFornecedor);
		FrmFornecedor.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(5, 5, 735, 68);
		FrmFornecedor.add(panel);
		panel.setLayout(null);
		
		JLabel titulo = new JLabel("Cadastro de Fornecedores");
		titulo.setFont(new Font("Arial Black", Font.BOLD, 25));
		titulo.setBounds(10, 25, 389, 32);
		titulo.setForeground(SystemColor.text);
		titulo.setBackground(new Color(240, 240, 240));
		titulo.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(titulo);
		
		JTabbedPane janelas = new JTabbedPane(JTabbedPane.TOP);
		janelas.setBounds(15, 84, 720, 424);
		FrmFornecedor.add(janelas);
		
		
		MaskFormatter formatTextCelField = new MaskFormatter("(##) #####-####");
		
		MaskFormatter formatTextTelField = new MaskFormatter("(##) ####-####");
		
		MaskFormatter formatTextCNPJField = new MaskFormatter("##.###.###/####-##");
		MaskFormatter formatTextCEPField = new MaskFormatter("#####-###");
		
	
		
		JPanel DadosPessoais = new JPanel();
		janelas.addTab("Dados", null, DadosPessoais, null);
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
		
		JLabel lblNewLabel_1_1 = new JLabel("Nome:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(35, 75, 46, 21);
		DadosPessoais.add(lblNewLabel_1_1);
		
		field_nome = new JTextField();
		field_nome.setColumns(10);
		field_nome.setBounds(78, 75, 253, 20);
		DadosPessoais.add(field_nome);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("E-mail:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(35, 107, 46, 21);
		DadosPessoais.add(lblNewLabel_1_1_1);
		
		field_email = new JTextField();
		field_email.setColumns(10);
		field_email.setBounds(78, 107, 253, 20);
		DadosPessoais.add(field_email);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Celular:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1.setBounds(343, 110, 46, 21);
		DadosPessoais.add(lblNewLabel_1_1_1_1);
		
		JLabel lb_cnpj = new JLabel("CNPJ");
		lb_cnpj.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lb_cnpj.setBounds(35, 139, 46, 21);
		DadosPessoais.add(lb_cnpj);
		field_celular = new JFormattedTextField(formatTextCelField);
		field_celular.setFont(new Font("Tahoma", Font.PLAIN, 11));
		field_celular.setBounds(385, 110, 100, 20);
		
		DadosPessoais.add(field_celular);
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Telefone:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1.setBounds(490, 110, 58, 21);
		DadosPessoais.add(lblNewLabel_1_1_1_1_1);
		
		field_telefone = new JFormattedTextField(formatTextTelField);
		field_telefone.setFont(new Font("Tahoma", Font.PLAIN, 11));
		field_telefone.setBounds(551, 111, 100, 20);
		DadosPessoais.add(field_telefone);
		
		field_cnpj = new JFormattedTextField(formatTextCNPJField);
		field_cnpj.setBounds(78, 139, 130, 21);
		DadosPessoais.add(field_cnpj);
		

		JLabel cep = new JLabel("CEP:");
		cep.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cep.setBounds(35, 171, 46, 21);
		DadosPessoais.add(cep);
		
		
		field_cep = new JFormattedTextField(formatTextCEPField);
		field_cep.setBounds(78, 171, 99, 20);
		DadosPessoais.add(field_cep);
		
		JLabel lblNewLabel_1_2 = new JLabel("Endere\u00E7o:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(187, 171, 58, 21);
		DadosPessoais.add(lblNewLabel_1_2);
		
		field_endereco = new JTextField();
		field_endereco.setColumns(10);
		field_endereco.setBounds(244, 171, 171, 20);
		DadosPessoais.add(field_endereco);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("N\u00FAmero:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2_1.setBounds(425, 171, 58, 21);
		DadosPessoais.add(lblNewLabel_1_2_1);
		
		field_numero = new JTextField();
		field_numero.setColumns(10);
		field_numero.setBounds(476, 171, 30, 20);
		DadosPessoais.add(field_numero);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Complemento:");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2_2.setBounds(516, 171, 91, 21);
		DadosPessoais.add(lblNewLabel_1_2_2);
		
		field_compl = new JTextField();
		field_compl.setColumns(10);
		field_compl.setBounds(605, 172, 100, 20);
		DadosPessoais.add(field_compl);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Bairro:");
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2_3.setBounds(35, 203, 58, 21);
		DadosPessoais.add(lblNewLabel_1_2_3);
		
		field_bairro = new JTextField();
		field_bairro.setColumns(10);
		field_bairro.setBounds(78, 203, 99, 20);
		DadosPessoais.add(field_bairro);
		
		JLabel lblNewLabel_1_2_3_1 = new JLabel("Cidade:");
		lblNewLabel_1_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2_3_1.setBounds(187, 203, 58, 21);
		DadosPessoais.add(lblNewLabel_1_2_3_1);
		
		field_cidade = new JTextField();
		field_cidade.setColumns(10);
		field_cidade.setBounds(230, 203, 99, 20);
		DadosPessoais.add(field_cidade);
		
		JLabel lblNewLabel_1_2_3_1_1 = new JLabel("UF:");
		lblNewLabel_1_2_3_1_1.setBounds(343, 202, 30, 21);
		DadosPessoais.add(lblNewLabel_1_2_3_1_1);
		
		box_uf = new JComboBox<String>();
		box_uf.setModel(new DefaultComboBoxModel<String>(new String[] {"\u00A0AC", "\u00A0AL", "\u00A0AP", "\u00A0AM", "\u00A0BA", "\u00A0CE", "\u00A0DF", "\u00A0ES", "\u00A0GO", "\u00A0MA", "\u00A0MT", "\u00A0MS", "\u00A0MG", "\u00A0PA", "\u00A0PB", "\u00A0PR", "\u00A0PE", "\u00A0PI", "\u00A0RJ", "\u00A0RN", "\u00A0RS", "\u00A0RO", "\u00A0RR", "\u00A0SC", "\u00A0SP", "\u00A0SE", "\u00A0TO"}));
		box_uf.setSelectedIndex(0);
		box_uf.setBounds(366, 202, 49, 22);
		DadosPessoais.add(box_uf);
		
		
		JPanel ConsultarCliente = new JPanel();
		janelas.addTab("Consultar Fornecedores", null, ConsultarCliente, null);
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
		tabelaFornecedores = new JTable();
		tabelaFornecedores.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				janelas.setSelectedIndex(0);
				
				 field_codigo.setText( tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(),0).toString());
				 field_nome.setText((String) tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(),1).toString());
				 field_email.setText((String) tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(),2).toString());
				 field_celular.setText((String) tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(),3).toString());
				 field_telefone.setText((String) tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(),4).toString());
				 field_cnpj.setText((String) tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(),5).toString());
				 field_cep.setText((String) tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(),6).toString());
				 field_endereco.setText((String) tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(),7).toString());
				 field_numero.setText((String) tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(),8).toString());
				 field_compl.setText((String) tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(),9).toString());
				 field_bairro.setText((String) tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(),10).toString());
				 field_cidade.setText((String) tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(),11).toString());
				 box_uf.setSelectedItem(tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 12).toString());
				
			}
		});
		tabelaFornecedores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelaFornecedores.setShowVerticalLines(true);
		tabelaFornecedores.setAutoResizeMode(NORMAL);
		tabelaFornecedores.setSurrendersFocusOnKeystroke(true);
		tabelaFornecedores.setToolTipText("");
		tabelaFornecedores.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Nome", "Email", "Celular", "Telefone", "CNPJ", "CEP", "Endere\u00E7o", "N\u00FAmero", "Complemento", "Bairro", "Cidade", "UF"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabelaFornecedores.setBounds(10, 157, 676, 139);
		
		JButton bt_pesquisar = new JButton("Pesquisar");
		bt_pesquisar.setBounds(335, 47, 103, 23);
		bt_pesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarFornecedores();
			}
		});
		ConsultarCliente.add(bt_pesquisar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 158, 676, 141);
		scrollPane.setViewportView(tabelaFornecedores);
		ConsultarCliente.add(scrollPane);
		
		JButton bt_novo = new JButton("Limpar");
		bt_novo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparFormulario();
			}
		});
		bt_novo.setBounds(25, 519, 89, 23);
		FrmFornecedor.add(bt_novo);
		
		JButton bt_cadastrar = new JButton("Cadastrar");
		bt_cadastrar.setBounds(124, 519, 102, 23);
		bt_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarFornecedor();
			}
		});
		FrmFornecedor.add(bt_cadastrar);
		
		JButton bt_editar = new JButton("Alterar");
		bt_editar.setBounds(233, 519, 89, 23);
		bt_editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarCliente();
			}
		});
		FrmFornecedor.add(bt_editar);
		
		JButton bt_excluir = new JButton("Excluir");
		bt_excluir.setBounds(333, 519, 89, 23);
		bt_excluir.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				excluirFornecedor();
			}
		});
		FrmFornecedor.add(bt_excluir);
		
		
		
	}
	public TableModel getTableModel() {
		return tabelaFornecedores.getModel();
	}
	public void setTableModel(TableModel model) {
		tabelaFornecedores.setModel(model);
	}
	
	//botao Novo
	public void limparFormulario() {
		 field_codigo.setText("");
		 field_nome.setText("");
		 field_email.setText("");
		 field_endereco.setText("");
		 field_numero.setText("");
		 field_compl.setText("");
		 field_bairro.setText("");
		 field_cidade.setText("");
		 field_consul_nome.setText("");
		 field_celular.setText("");
		 field_telefone.setText("");
		 field_cep.setText("");
		 field_cnpj.setText("");
		 
		 tabelaFornecedores.clearSelection();
	};
	
	public void cadastrarFornecedor() {
		Fornecedor f = new Fornecedor();
		DAO<Fornecedor> dao_cliente = new DAO<>(Fornecedor.class);
			f.setNome(field_nome.getText());
			f.setEmail(field_email.getText());
			f.setCelular(field_celular.getText());
			f.setTelefone(field_telefone.getText());
			f.setCnpj(field_cnpj.getText());
			f.setCep(field_cep.getText());
			f.setEndereco(field_endereco.getText());
			f.setComplemento(field_compl.getText());
			f.setNumero(Integer.parseInt(field_numero.getText()));
			f.setBairro(field_bairro.getText());
			f.setCidade(field_cidade.getText());
			f.setEstado(box_uf.getItemAt(box_uf.getSelectedIndex()));
			
		dao_cliente.incluirAtomico(f);
		JOptionPane.showMessageDialog(FrmFornecedor,"Novo Fornecedor cadastrado!\nNome: "+ f.getNome());
	}
	
	public void listarFornecedores() {
		DAO<Fornecedor> dao_fornc = new DAO<>(Fornecedor.class);
		String parametro = field_consul_nome.getText()+"%";
		
		List<Fornecedor> lista = dao_fornc
			.consultar("consultarFornPorNome","nome", parametro);
		
		DefaultTableModel dados_tabela = (DefaultTableModel) tabelaFornecedores.getModel();
		//limpa a tabela
		dados_tabela.setNumRows(0);
		
		for(Fornecedor f: lista) {
			dados_tabela.addRow(new Object[]{
					f.getId(),
					f.getNome(),
					f.getEmail(),
					f.getCelular(),
					f.getTelefone(),
					f.getCnpj(),
					f.getCep(),
					f.getEndereco(),
					f.getNumero(),
					f.getComplemento(),
					f.getBairro(),
					f.getCidade(),
					f.getEstado()
			});
		}
	}
	
	public void alterarCliente() {
		Fornecedor f = new Fornecedor();
		DAO<Fornecedor> dao_forn = new DAO<>(Fornecedor.class);
		Integer parametro = Integer.parseInt(field_codigo.getText());
		
		f = dao_forn.consultar("consultarFornPorId","id",parametro).get(0);
		
		f.setNome(field_nome.getText());
		f.setEmail(field_email.getText());
		f.setCelular(field_celular.getText());
		f.setTelefone(field_telefone.getText());
		f.setCnpj(field_cnpj.getText());
		f.setCep(field_cep.getText());
		f.setEndereco(field_endereco.getText());
		f.setComplemento(field_compl.getText());
		f.setNumero(Integer.parseInt(field_numero.getText()));
		f.setBairro(field_bairro.getText());
		f.setCidade(field_cidade.getText());
		f.setEstado(box_uf.getItemAt(box_uf.getSelectedIndex()));
		
		dao_forn.alterar(f);
		limparFormulario();
		JOptionPane.showMessageDialog(FrmFornecedor,"Fornecedor: "+ f.getNome()+"\nDados atualizados!");
	}
	
	public void excluirFornecedor() {
		Fornecedor c = new Fornecedor();
		DAO<Fornecedor> dao_cliente = new DAO<>(Fornecedor.class);
		Integer parametro = Integer.parseInt(field_codigo.getText());
		
		c = dao_cliente.consultar("consultarFornPorId","id",parametro).get(0);
		
		dao_cliente.excluir(c);
		limparFormulario();
		JOptionPane.showMessageDialog(FrmFornecedor,"Fornecedor: "+ c.getNome()+"\nDados excluídos!");
	}
	
//	  public Cliente buscaCep(String cep) {
//	       
//	        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
//	       
//
//	        Cliente obj = new Cliente();
//
//	        if (webServiceCep.wasSuccessful()) {
//	            obj.setEndereco(webServiceCep.getLogradouroFull());
//	            obj.setCidade(webServiceCep.getCidade());
//	            obj.setBairro(webServiceCep.getBairro());
//	            obj.setEstado(webServiceCep.getEstado());
//	            return obj;
//	        } else {
//	            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
//	            JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
//	            return null;
//	        }
//
//	    }
		
		
	
}//FimJanela
