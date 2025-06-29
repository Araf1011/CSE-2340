package GUI;
import Entity.*;
import EntityList.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class login extends JFrame implements ActionListener{
	JPanel panel;
	JLabel userLabel, passwordLabel, signUpLabel,title ,title1;
	JTextField userTF;
	JPasswordField passwordTF;
	JButton lgnBtn, exitBtn, signUpBtn;
	
	user u = null;
	users us = null;

	
	public 	login(users us){
		super(" User Login");
		this.setSize(950,620);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);  

		
		this.us=us;
		
		
		Font font = new Font("Cambria",Font.BOLD,15);
		
		Font titleFont = new Font("Algerian",Font.BOLD,50);
		Font titleFont1 = new Font("Algerian",Font.BOLD,15);
		Font font1 = new Font("Algerian",Font.BOLD,30);
		panel = new JPanel();
		panel.setLayout(null);
		
		title= new JLabel("AIUB Hospital!");
		title.setBounds(380,420,400,50);
		title.setFont(titleFont);
		title.setForeground(Color.WHITE);
		panel.add(title);
		
		title1= new JLabel("Patient Login");
		title1.setBounds(250,20,150,40);
		title1.setFont(titleFont1);
		title.setForeground(Color.WHITE);
		panel.add(title1);
		
		
		userLabel = new JLabel("User name: "); 
		userLabel.setBounds(100,100,100,30);
		userLabel.setBackground(Color.GRAY);
		userLabel.setForeground(Color.BLACK);
		userLabel.setOpaque(true);
		userLabel.setFont(font);
		panel.add(userLabel);
		
		passwordLabel = new JLabel("Password: ");
		passwordLabel.setBounds(100,140,100,30);
		passwordLabel.setBackground(Color.GRAY);
		passwordLabel.setForeground(Color.BLACK);
		passwordLabel.setOpaque(true);
		passwordLabel.setFont(font);
		panel.add(passwordLabel);
		
		userTF = new JTextField();
		userTF.setBounds(205,100,200,30);
		userTF.setFont(font);
		panel.add(userTF);
		
		passwordTF = new JPasswordField();
		passwordTF.setBounds(205,140,200,30);
		passwordTF.setFont(font);
		passwordTF.setEchoChar('*');
		panel.add(passwordTF);
		
		lgnBtn = new JButton("Login");
		lgnBtn.setBounds(160,180,80,25);
		lgnBtn.setBackground(Color.GREEN);
		lgnBtn.setForeground(Color.BLACK);
		lgnBtn.setOpaque(true);
		lgnBtn.addActionListener(this);
		
		panel.add(lgnBtn);
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(250,180,80,25);
		exitBtn.setBackground(Color.RED);
		exitBtn.setForeground(Color.WHITE);
		
		exitBtn.setOpaque(true);
		exitBtn.addActionListener(this);
		panel.add(exitBtn);
		
		signUpLabel = new JLabel("Don't have an account?");
		signUpLabel.setBounds(100,210,200,30);
		signUpLabel.setFont(font);
		panel.add(signUpLabel);
		
		signUpBtn = new JButton("Sign up");
		signUpBtn.setBounds(300,210,100,25);
		signUpBtn.setBackground(Color.WHITE);
		signUpBtn.setForeground(Color.BLUE);
		signUpBtn.addActionListener(this);
		panel.add(signUpBtn);
		
		
		
		ImageIcon first = new ImageIcon("pic/hm.jpg");
		JLabel background = new JLabel(first);
		background.setBounds(0,0,950,620);
		panel.add(background);
		
		
		
		this.add(panel);
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae){
		String command = ae.getActionCommand();
		if(signUpBtn.getText().equals(command)){
			Register rg = new Register(us);
			rg.setVisible(true);
		this.setVisible(false);}
		else if(lgnBtn.getText().equals(command)){
			String name = userTF.getText();
			String pass = passwordTF.getText();
			
			int index = us.userExists(name);
			if(index == -1){
				JOptionPane.showMessageDialog(this, "User doesn't exist!");
			}else{
				u = us.checkCredentials(index,pass);
				if(u == null ){
					JOptionPane.showMessageDialog(this, "Password incorrect");
				}else{
					UserList ul = new UserList(u,us);
			        ul.setVisible(true);
			        this.setVisible(false);
									}		
			}
		}else if((exitBtn.getText().equals(command))){
			System.exit(0);
		}
		
	}

		
}