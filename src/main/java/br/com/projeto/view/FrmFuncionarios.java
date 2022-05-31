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
import javax.swing.JPasswordField;
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
import br.com.projeto.model.Funcionario;

@SuppressWarnings("serial")
public class FrmFuncionarios extends JFrame {

	private JPanel FrmFuncionarios;
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
	
	//atributos especificos de funcionarios
	private JComboBox<String> box_nivelAcesso; 
	private JTable tabelaFuncionarios;
	private JPasswordField field_senha;
	private JTextField field_cargo;
	
	


	public FrmFuncionarios() throws ParseException {
//		setIconImage(Toolkit.getDefaultToolkit().getImage("//images/icon1.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 761, 606);
		FrmFuncionarios = new JPanel();
		FrmFuncionarios.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(FrmFuncionarios);
		FrmFuncionarios.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(5, 5, 735, 68);
		FrmFuncionarios.add(panel);
		panel.setLayout(null);
		
		JLabel Titulo = new JLabel("Cadastro de Funcionários");
		Titulo.setFont(new Font("Arial Black", Font.BOLD, 25));
		Titulo.setBounds(10, 25, 403, 32);
		Titulo.setForeground(SystemColor.text);
		Titulo.setBackground(new Color(240, 240, 240));
		Titulo.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(Titulo);
		
		JTabbedPane janelas = new JTabbedPane(JTabbedPane.TOP);
		janelas.setBounds(15, 84, 720, 424);
		FrmFuncionarios.add(janelas);
		
		
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
		
		JLabel lblNewLabel = new JLabel("Senha:");
		lblNewLabel.setBounds(35, 235, 46, 14);
		DadosPessoais.add(lblNewLabel);
		
		field_senha = new JPasswordField();
		field_senha.setBounds(78, 235, 99, 20);
		DadosPessoais.add(field_senha);
		
		JLabel lblNewLabel_1_2_3_1_1_1 = new JLabel("Nivel de Acesso:");
		lblNewLabel_1_2_3_1_1_1.setBounds(187, 235, 113, 21);
		DadosPessoais.add(lblNewLabel_1_2_3_1_1_1);
		
		box_nivelAcesso = new JComboBox<String>();
		box_nivelAcesso.setModel(new DefaultComboBoxModel<String>(new String[] {"Usuário", "Administrador"}));
		box_nivelAcesso.setSelectedIndex(0);
		box_nivelAcesso.setBounds(282, 234, 105, 22);
		DadosPessoais.add(box_nivelAcesso);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Cargo:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_2.setBounds(341, 75, 46, 21);
		DadosPessoais.add(lblNewLabel_1_1_2);
		
		field_cargo = new JTextField();
		field_cargo.setColumns(10);
		field_cargo.setBounds(384, 75, 164, 20);
		DadosPessoais.add(field_cargo);
		
		
		JPanel ConsultarFuncionario = new JPanel();
		janelas.addTab("Consultar Funcionário", null, ConsultarFuncionario, null);
		ConsultarFuncionario.setLayout(null);
		
		JLabel cons_lb_nome = new JLabel("Nome:");
		cons_lb_nome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cons_lb_nome.setBounds(29, 47, 46, 21);
		ConsultarFuncionario.add(cons_lb_nome);
		
		field_consul_nome = new JTextField();
		field_consul_nome.setColumns(10);
		field_consul_nome.setBounds(72, 47, 253, 20);
		ConsultarFuncionario.add(field_consul_nome);
		
		//ao clicar na linha selecionada na tabela
		//os dados serao enviados para os respectivos campos na janela Dados pessoais
		//ao clicar em editar os dados serao atualizados
		tabelaFuncionarios = new JTable();
		tabelaFuncionarios.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				janelas.setSelectedIndex(0);
				
				 field_codigo.setText( tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(),0).toString());
				 field_nome.setText((String) tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(),1).toString());
				 field_cargo.setText((String) tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(),2).toString());
				 field_email.setText((String) tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(),4).toString());
				 field_celular.setText((String) tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(),5).toString());
				 field_telefone.setText((String) tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(),6).toString());
				 field_cpf.setText((String) tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(),7).toString());
				 field_rg.setText((String) tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(),8).toString());
				 field_cep.setText((String) tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(),9).toString());
				 field_endereco.setText((String) tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(),10).toString());
				 field_numero.setText((String) tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(),11).toString());
				 field_compl.setText((String) tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(),12).toString());
				 field_bairro.setText((String) tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(),13).toString());
				 field_cidade.setText((String) tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(),14).toString());
				 box_uf.setSelectedItem(tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 15).toString());
				 field_senha.setText("");
				 box_nivelAcesso.setSelectedItem(tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 3).toString());
				
			}
		});
		tabelaFuncionarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelaFuncionarios.setShowVerticalLines(true);
		tabelaFuncionarios.setAutoResizeMode(NORMAL);
		tabelaFuncionarios.setSurrendersFocusOnKeystroke(true);
		tabelaFuncionarios.setToolTipText("");
		tabelaFuncionarios.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Nome", "Cargo", "Nivel de Acesso", "Email", "Celular", "Telefone", "CPF", "RG", "CEP", "Endere\u00E7o", "N\u00FAmero", "Complemento", "Bairro", "Cidade", "UF"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabelaFuncionarios.getColumnModel().getColumn(1).setPreferredWidth(110);
		tabelaFuncionarios.getColumnModel().getColumn(3).setPreferredWidth(97);
		tabelaFuncionarios.getColumnModel().getColumn(4).setPreferredWidth(103);
		tabelaFuncionarios.setBounds(10, 157, 676, 139);
		
		JButton bt_pesquisar = new JButton("Pesquisar");
		bt_pesquisar.setBounds(335, 47, 103, 23);
		bt_pesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarFuncionarios();
			}
		});
		ConsultarFuncionario.add(bt_pesquisar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 158, 676, 141);
		scrollPane.setViewportView(tabelaFuncionarios);
		ConsultarFuncionario.add(scrollPane);
		
		JButton bt_novo = new JButton("Limpar");
		bt_novo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparFormulario();
			}
		});
		bt_novo.setBounds(25, 519, 89, 23);
		FrmFuncionarios.add(bt_novo);
		
		JButton bt_salvar = new JButton("Cadastrar");
		bt_salvar.setBounds(124, 519, 102, 23);
		bt_salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarFuncionario();
			}
		});
		FrmFuncionarios.add(bt_salvar);
		
		JButton bt_editar = new JButton("Alterar");
		bt_editar.setBounds(233, 519, 89, 23);
		bt_editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarFunc();
			}
		});
		FrmFuncionarios.add(bt_editar);
		
		JButton bt_excluir = new JButton("Excluir");
		bt_excluir.setBounds(333, 519, 89, 23);
		bt_excluir.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				excluirFunc();
			}
		});
		FrmFuncionarios.add(bt_excluir);
		
		
		
	}
	public TableModel getTableModel() {
		return tabelaFuncionarios.getModel();
	}
	public void setTableModel(TableModel model) {
		tabelaFuncionarios.setModel(model);
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
		 field_senha.setText("");
		 
		 tabelaFuncionarios.clearSelection();
	};
	
	public void cadastrarFuncionario() {
		Funcionario f = new Funcionario();
		DAO<Funcionario> dao_cliente = new DAO<>(Funcionario.class);
			f.setNome(field_nome.getText());
			f.setEmail(field_email.getText());
			f.setCelular(field_celular.getText());
			f.setTelefone(field_telefone.getText());
			f.setCpf(field_cpf.getText());
			f.setRg(field_rg.getText());
			f.setCep(field_cep.getText());
			f.setEndereco(field_endereco.getText());
			f.setComplemento(field_compl.getText());
			f.setNumero(Integer.parseInt(field_numero.getText()));
			f.setBairro(field_bairro.getText());
			f.setCidade(field_cidade.getText());
			f.setEstado(box_uf.getItemAt(box_uf.getSelectedIndex()));
			f.setSenha(field_senha.getPassword());
			f.setCargo(field_cargo.getText());
			f.setNivel_acesso(box_nivelAcesso.getItemAt(box_nivelAcesso.getSelectedIndex()));
			
			
		dao_cliente.incluirAtomico(f);
		JOptionPane.showMessageDialog(FrmFuncionarios,"Novo funcionário cadastrado!\nNome: "+ f.getNome());
	}
	
	public void listarFuncionarios() {
		DAO<Funcionario> dao_func = new DAO<>(Funcionario.class);
		String parametro = field_consul_nome.getText()+"%";
		
		List<Funcionario> lista = dao_func
			.consultar("consultarFuncPorNome","nome", parametro);
		
		DefaultTableModel dados_tabela = (DefaultTableModel) tabelaFuncionarios.getModel();
		//limpa a tabela
		dados_tabela.setNumRows(0);
		
		for(Funcionario f: lista) {
			dados_tabela.addRow(new Object[]{
					f.getId(),
					f.getNome(),
					f.getCargo(),
					f.getNivel_acesso(),
					f.getEmail(),
					f.getCelular(),
					f.getTelefone(),
					f.getCpf(),
					f.getRg(),
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
	
	public void alterarFunc() {
		Funcionario f = new Funcionario();
		DAO<Funcionario> dao_func = new DAO<>(Funcionario.class);
		Integer parametro = Integer.parseInt(field_codigo.getText());
		
		f = dao_func.consultar("consultarFuncPorId","id",parametro).get(0);
		
		f.setNome(field_nome.getText());
		f.setEmail(field_email.getText());
		f.setCelular(field_celular.getText());
		f.setTelefone(field_telefone.getText());
		f.setCpf(field_cpf.getText());
		f.setRg(field_rg.getText());
		f.setCep(field_cep.getText());
		f.setEndereco(field_endereco.getText());
		f.setComplemento(field_compl.getText());
		f.setNumero(Integer.parseInt(field_numero.getText()));
		f.setBairro(field_bairro.getText());
		f.setCidade(field_cidade.getText());
		f.setEstado(box_uf.getItemAt(box_uf.getSelectedIndex()));
		f.setCargo(field_cargo.getText());
		f.setNivel_acesso(box_nivelAcesso.getItemAt(box_nivelAcesso.getSelectedIndex()));
		
		dao_func.alterar(f);
		limparFormulario();
		JOptionPane.showMessageDialog(FrmFuncionarios,"Funcionário: "+ f.getNome()+"\nDados atualizados!");
	}
	
	public void excluirFunc() {
		Funcionario f = new Funcionario();
		DAO<Funcionario> dao_func = new DAO<>(Funcionario.class);
		Integer parametro = Integer.parseInt(field_codigo.getText());
		
		f = dao_func.consultar("consultarFuncPorId","id",parametro).get(0);
		
		dao_func.excluir(f);
		limparFormulario();
		JOptionPane.showMessageDialog(FrmFuncionarios,"Usuário: "+ f.getNome()+"\nDados excluídos!");
	}
	
//	  public Funcionario buscaCep(String cep) {
//	       
//	        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
//	       
//
//	        Funcionario obj = new Funcionario();
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
