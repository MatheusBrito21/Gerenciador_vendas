package br.com.projeto.view;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.projeto.dao.DAO;
import br.com.projeto.model.Funcionario;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class FrmLogin extends JFrame {
	private JPanel Login;
	private JTextField field_log_email;
	private JPasswordField field_log_senha;
	
	public FrmLogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 583, 396);
		Login = new JPanel();
		Login.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Login);
		Login.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 585, 74);
		Login.add(panel);
		panel.setLayout(null);
		
		JLabel titulo = new JLabel("Autenticação");
		titulo.setForeground(SystemColor.text);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		titulo.setBounds(10, 11, 181, 52);
		panel.add(titulo);
		
		JPanel painel = new JPanel();
		painel.setBounds(10, 85, 547, 188);
		Login.add(painel);
		painel.setLayout(null);
		
		JLabel field_email = new JLabel("Email:");
		field_email.setBounds(95, 80, 46, 14);
		painel.add(field_email);
		
		JLabel field_senha = new JLabel("Senha:");
		field_senha.setBounds(95, 120, 46, 14);
		painel.add(field_senha);
		
		field_log_email = new JTextField();
		field_log_email.setBounds(151, 80, 205, 20);
		painel.add(field_log_email);
		field_log_email.setColumns(10);
		
		field_log_senha = new JPasswordField();
		field_log_senha.setBounds(151, 117, 205, 20);
		painel.add(field_log_senha);
		
		JButton bt_entrar = new JButton("Entrar");
		bt_entrar.setBounds(163, 323, 89, 23);
		
		bt_entrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				autenticarLogin();
			}
		});
		Login.add(bt_entrar);
		
		JButton bt_sair = new JButton("Sair");
		bt_sair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		bt_sair.setBounds(275, 323, 89, 23);
		Login.add(bt_sair);
	}
	
	public void autenticarLogin() {
		DAO<Funcionario> dao_func = new DAO<>(Funcionario.class);
		
		String email = field_log_email.getText();
		char[] senha = field_log_senha.getPassword();
		
		List<Funcionario> f_busca_email = dao_func.consultar("consultarFuncPorEmail","email",email);
		if (!f_busca_email.isEmpty()) {
			for (Funcionario f : f_busca_email) {
				if (Arrays.equals(f.getSenha(), senha)) {
					JOptionPane.showMessageDialog(null, "Login autenticado com sucesso!");
					FrmMenu menu = new FrmMenu();
					menu.setVisible(true);
					menu.lb_usuarioConectado.setText(f.getNome());
					menu.lb_nivel_acesso.setText(f.getNivel_acesso().toString());

					this.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Dados incorretos!");
				}
			} 
		}else {
			JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado!");
		}		
	}
	
	
	
	
	
	
}//FimTela
