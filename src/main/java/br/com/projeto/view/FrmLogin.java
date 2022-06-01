package br.com.projeto.view;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class FrmLogin extends JFrame {
	private JPanel Login;
	private JTextField field_log_email;
	private JPasswordField field_log_senha;
	
	public FrmLogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		bt_sair.setBounds(275, 323, 89, 23);
		bt_sair.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		Login.add(bt_sair);
	}
	
	public void autenticarLogin() {
		
		
	}
	
	
	
	
	
	
}//FimTela
