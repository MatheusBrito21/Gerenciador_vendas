package br.com.projeto.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FrmClientes extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_10;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmClientes frame = new FrmClientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	@SuppressWarnings("unchecked")
	public FrmClientes() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(5, 5, 735, 68);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Clientes");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 25, 351, 32);
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(15, 84, 720, 424);
		contentPane.add(tabbedPane);
		
		
		MaskFormatter formatTextCelField = new MaskFormatter("(##) #####-####");
		
		MaskFormatter formatTextTelField = new MaskFormatter("(##) ####-####");
		
		MaskFormatter formatTextCPFField = new MaskFormatter("###.###.###-##");
		MaskFormatter formatTextCEPField = new MaskFormatter("#####-###");
		
	
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Dados Pessoais", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(35, 40, 46, 21);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(78, 40, 99, 20);
		panel_1.add(textField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nome:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(35, 75, 46, 21);
		panel_1.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(78, 75, 253, 20);
		panel_1.add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("E-mail:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(35, 107, 46, 21);
		panel_1.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(78, 107, 253, 20);
		panel_1.add(textField_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Celular:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1.setBounds(343, 110, 46, 21);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("CPF:");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_2.setBounds(35, 139, 46, 21);
		panel_1.add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("RG:");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_2_1.setBounds(187, 139, 46, 21);
		panel_1.add(lblNewLabel_1_1_1_2_1);
		JFormattedTextField formattedTextField = new JFormattedTextField(formatTextCelField);
		formattedTextField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		formattedTextField.setBounds(385, 110, 100, 20);
		
		panel_1.add(formattedTextField);
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Telefone:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1.setBounds(490, 110, 58, 21);
		panel_1.add(lblNewLabel_1_1_1_1_1);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField(formatTextTelField);
		formattedTextField_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		formattedTextField_1.setBounds(551, 111, 100, 20);
		panel_1.add(formattedTextField_1);
		JFormattedTextField formattedTextField_2 = new JFormattedTextField(formatTextCPFField);
		formattedTextField_2.setBounds(78, 139, 99, 21);
		panel_1.add(formattedTextField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(214, 140, 86, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		

		JLabel lblNewLabel_1_1_1_2_1_1 = new JLabel("CEP:");
		lblNewLabel_1_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_2_1_1.setBounds(35, 171, 46, 21);
		panel_1.add(lblNewLabel_1_1_1_2_1_1);
		
		
		JFormattedTextField formattedTextField_3 = new JFormattedTextField(formatTextCEPField);
		formattedTextField_3.setBounds(78, 171, 99, 20);
		panel_1.add(formattedTextField_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("Endere\u00E7o:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(187, 171, 58, 21);
		panel_1.add(lblNewLabel_1_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(244, 171, 171, 20);
		panel_1.add(textField_4);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("N\u00FAmero:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2_1.setBounds(425, 171, 58, 21);
		panel_1.add(lblNewLabel_1_2_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(476, 171, 30, 20);
		panel_1.add(textField_5);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Complemento:");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2_2.setBounds(516, 171, 91, 21);
		panel_1.add(lblNewLabel_1_2_2);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(605, 172, 100, 20);
		panel_1.add(textField_6);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Bairro:");
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2_3.setBounds(35, 203, 58, 21);
		panel_1.add(lblNewLabel_1_2_3);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(78, 203, 99, 20);
		panel_1.add(textField_7);
		
		JLabel lblNewLabel_1_2_3_1 = new JLabel("Cidade:");
		lblNewLabel_1_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2_3_1.setBounds(187, 203, 58, 21);
		panel_1.add(lblNewLabel_1_2_3_1);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(230, 203, 99, 20);
		panel_1.add(textField_8);
		
		JLabel lblNewLabel_1_2_3_1_1 = new JLabel("UF:");
		lblNewLabel_1_2_3_1_1.setBounds(343, 202, 30, 21);
		panel_1.add(lblNewLabel_1_2_3_1_1);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"\u00A0AC", "\u00A0AL", "\u00A0AP", "\u00A0AM", "\u00A0BA", "\u00A0CE", "\u00A0DF", "\u00A0ES", "\u00A0GO", "\u00A0MA", "\u00A0MT", "\u00A0MS", "\u00A0MG", "\u00A0PA", "\u00A0PB", "\u00A0PR", "\u00A0PE", "\u00A0PI", "\u00A0RJ", "\u00A0RN", "\u00A0RS", "\u00A0RO", "\u00A0RR", "\u00A0SC", "\u00A0SP", "\u00A0SE", "\u00A0TO"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(366, 202, 49, 22);
		panel_1.add(comboBox);
		
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Consultar Clientes", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Nome:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_2.setBounds(29, 47, 46, 21);
		panel_2.add(lblNewLabel_1_1_2);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(72, 47, 253, 20);
		panel_2.add(textField_10);
		
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
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			@SuppressWarnings("rawtypes")
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.setBounds(29, 159, 676, 139);
		panel_2.add(table);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.setBounds(335, 47, 89, 23);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Novo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(25, 519, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Salvar");
		btnNewButton_1_1.setBounds(124, 519, 89, 23);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Editar");
		btnNewButton_1_2.setBounds(223, 519, 89, 23);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("Excluir");
		btnNewButton_1_3.setBounds(322, 519, 89, 23);
		contentPane.add(btnNewButton_1_3);
		
		
		
	}
	public TableModel getTableModel() {
		return table.getModel();
	}
	public void setTableModel(TableModel model) {
		table.setModel(model);
	}
}
