package br.com.projeto.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.MaskFormatter;

import br.com.projeto.dao.DAO;
import br.com.projeto.model.Cliente;

@SuppressWarnings("serial")
public class FrmClientes extends JFrame {

	private JPanel FrmClientes;
	private JTextField field_codigo;
	private JTextField field_nome;
	private JTextField field_email;
	private JTextField field_rg;
	private JTextField field_endereco;
	private JTextField field_numero;
	private JTextField field_compl;
	private JTextField field_bairro;
	private JTextField field_cidade;
	private JTextField field_consul_nome;
	private static JFormattedTextField field_celular;
	private static JFormattedTextField field_telefone;
	private static JFormattedTextField field_cep;
	private static JFormattedTextField field_cpf;
	private JComboBox<String> box_uf;
	
	private JTable table;
	


	public FrmClientes() throws ParseException {
//		setIconImage(Toolkit.getDefaultToolkit().getImage("//images/icon1.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 606);
		FrmClientes = new JPanel();
		FrmClientes.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(FrmClientes);
		FrmClientes.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(5, 5, 735, 68);
		FrmClientes.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Clientes");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 25, 351, 32);
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNewLabel);
		
		JTabbedPane janelas = new JTabbedPane(JTabbedPane.TOP);
		janelas.setBounds(15, 84, 720, 424);
		FrmClientes.add(janelas);
		
		
		MaskFormatter formatTextCelField = new MaskFormatter("(##) #####-####");
		
		MaskFormatter formatTextTelField = new MaskFormatter("(##) ####-####");
		
		MaskFormatter formatTextCPFField = new MaskFormatter("###.###.###-##");
		MaskFormatter formatTextCEPField = new MaskFormatter("#####-###");
		
	
		
		JPanel DadosPessoais = new JPanel();
		janelas.addTab("Dados Pessoais", null, DadosPessoais, null);
		DadosPessoais.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(35, 40, 46, 21);
		DadosPessoais.add(lblNewLabel_1);
		
		field_codigo = new JTextField();
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
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("CPF:");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_2.setBounds(35, 139, 46, 21);
		DadosPessoais.add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("RG:");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_2_1.setBounds(187, 139, 46, 21);
		DadosPessoais.add(lblNewLabel_1_1_1_2_1);
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
		
		field_cpf = new JFormattedTextField(formatTextCPFField);
		field_cpf.setBounds(78, 139, 99, 21);
		DadosPessoais.add(field_cpf);
		
		field_rg = new JTextField();
		field_rg.setBounds(214, 140, 86, 20);
		DadosPessoais.add(field_rg);
		field_rg.setColumns(10);
		

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
		janelas.addTab("Consultar Clientes", null, ConsultarCliente, null);
		ConsultarCliente.setLayout(null);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Nome:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_2.setBounds(29, 47, 46, 21);
		ConsultarCliente.add(lblNewLabel_1_1_2);
		
		field_consul_nome = new JTextField();
		field_consul_nome.setColumns(10);
		field_consul_nome.setBounds(72, 47, 253, 20);
		ConsultarCliente.add(field_consul_nome);
		
		table = new JTable();
		table.setShowGrid(false);
		table.setVisible(true);
		table.setSurrendersFocusOnKeystroke(true);
		table.setRowSelectionAllowed(false);
		table.setToolTipText("");
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Nome", "Email", "Celular", "Telefone", "CPF", "RG", "Endere\u00E7o", "N\u00FAmero", "Complemento", "Bairro", "Cidade", "UF", "CEP"
			}
		));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.setBounds(29, 159, 676, 139);
		ConsultarCliente.add(table);
		
		JButton bt_pesquisar = new JButton("Pesquisar");
		bt_pesquisar.setBounds(335, 47, 103, 23);
		ConsultarCliente.add(bt_pesquisar);
		
		JButton bt_novo = new JButton("Novo");
		bt_novo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparFormulario();
			}
		});
		bt_novo.setBounds(25, 519, 89, 23);
		FrmClientes.add(bt_novo);
		
		JButton bt_salvar = new JButton("Salvar");
		bt_salvar.setBounds(124, 519, 89, 23);
		bt_salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarCliente();
			}
		});
		FrmClientes.add(bt_salvar);
		
		JButton bt_editar = new JButton("Editar");
		bt_editar.setBounds(223, 519, 89, 23);
		FrmClientes.add(bt_editar);
		
		JButton bt_excluir = new JButton("Excluir");
		bt_excluir.setBounds(322, 519, 89, 23);
		FrmClientes.add(bt_excluir);
		
		
		
	}
	public TableModel getTableModel() {
		return table.getModel();
	}
	public void setTableModel(TableModel model) {
		table.setModel(model);
	}
	
	//botao Novo
	public void limparFormulario() {
		 field_codigo.setText("");
		 field_nome.setText("");
		 field_email.setText("");
		 field_rg.setText("");
		 field_endereco.setText("");
		 field_numero.setText("");
		 field_compl.setText("");
		 field_bairro.setText("");
		 field_cidade.setText("");
		 field_consul_nome.setText("");
		 field_celular.setText("");
		 field_telefone.setText("");
		 field_cep.setText("");
		 field_cpf.setText("");
	};
	
	public void cadastrarCliente() {
		Cliente c = new Cliente();
		DAO<Cliente> dao_cliente = new DAO<>(Cliente.class);
		
			c.setNome(field_nome.getText());
			c.setEmail(field_email.getText());
			c.setCelular(field_celular.getText());
			c.setTelefone(field_telefone.getText());
			c.setCpf(field_cpf.getText());
			c.setRg(field_rg.getText());
			c.setCep(field_cep.getText());
			c.setEndereco(field_endereco.getText());
			c.setComplemento(field_compl.getText());
			c.setNumero(Integer.parseInt(field_numero.getText()));
			c.setBairro(field_bairro.getText());
			c.setCidade(field_cidade.getText());
			c.setEstado(box_uf.getItemAt(box_uf.getSelectedIndex()));
			
		dao_cliente.incluirAtomico(c);
	}
	
}
