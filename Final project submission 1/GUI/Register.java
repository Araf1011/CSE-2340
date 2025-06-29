package GUI;
import Entity.*;
import EntityList.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import File.*;


public class Register extends JFrame implements ActionListener {
	JPanel panel;
	JLabel userLabel,passwordLabel,confirmPassLabel,genderLabel,addressLabel,phoneNumberLabel,imgLabel;
	JTextField userTF,addressTF,phoneNumberTF;
	JPasswordField passwordTF,confirmPasswordTF;
	JButton RegisterBtn,backBtn;
	JRadioButton r1,r2,r3;
	ButtonGroup bg;
	ImageIcon img;
	Color color1, color2;
	Font font1, font2;
	
	user u = null;
	users us = null;
 
	
    public Register(users us){
		super("REGISTRATION PAGE");
		this.setSize(900,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.us = us;
		
		color1 = new Color(191,232,247);
		color2 = new Color(236,235,232);
		font1 = new Font("Times New Roman",Font.BOLD, 16);
		font2 = new Font("Times New Roman",Font.BOLD, 16);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
        userLabel = new JLabel("User name: "); 
		userLabel.setBounds(50,10,150,30);
		userLabel.setFont(font2);
		
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(200,10,200,30);
		userTF.setFont(font2);
		panel.add(userTF);
		
		passwordLabel = new JLabel("Password: ");
		passwordLabel.setBounds(50,50,150,30);
		passwordLabel.setFont(font2);
		
		panel.add(passwordLabel);
		
		passwordTF = new JPasswordField();
		passwordTF.setBounds(200,50,200,30);
		passwordTF.setFont(font2);
		passwordTF.setEchoChar('*');
		panel.add(passwordTF);
		
		confirmPassLabel = new JLabel("Confirm Password: ");
		confirmPassLabel.setBounds(50,90,150,30);
		confirmPassLabel.setFont(font2);
		
		panel.add(confirmPassLabel);
		
		confirmPasswordTF = new JPasswordField();
		confirmPasswordTF.setBounds(200,90,200,30);
		confirmPasswordTF.setFont(font2);
		confirmPasswordTF.setEchoChar('*');
		panel.add(confirmPasswordTF);
		
		genderLabel = new JLabel("Gender: ");
		genderLabel.setBounds(50,130,150,30);
		genderLabel.setFont(font2);
		panel.add(genderLabel);
		
		phoneNumberLabel = new JLabel("Phone Number: ");
		phoneNumberLabel.setBounds(50,170,150,30);
		phoneNumberLabel.setFont(font2);
		
		panel.add(phoneNumberLabel);
		
		phoneNumberTF = new JTextField();
		phoneNumberTF.setBounds(200,170,200,30);
		panel.add(phoneNumberTF);
        
		addressLabel = new JLabel("Address:");
		addressLabel.setBounds(50,210,150,30);
		addressLabel.setFont(font2);
	
		panel.add(addressLabel);
		
		addressTF = new JTextField();
		addressTF.setBounds(200,210,200,30);
		panel.add(addressTF);
		
		r1 = new JRadioButton("Male");
		r1.setBounds(200,130,80,30);
		panel.add(r1);
		r2 = new JRadioButton("Female");
		r2.setBounds(280,130,80,30);
		panel.add(r2);
		r3 = new JRadioButton("Other");
		r3.setBounds(360,130,80,30);
		panel.add(r3);
		
		bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		bg.add(r3);
		
		RegisterBtn= new JButton("REGISTER");
		RegisterBtn.setBounds(250,250,150,25);
		RegisterBtn.setFont(font1);
		RegisterBtn.setBackground(color1);
		RegisterBtn.setForeground(Color.WHITE);
		
		RegisterBtn.addActionListener(this);
	
		panel.add(RegisterBtn);
		
		backBtn= new JButton("BACK");
		backBtn.setBounds(250,290,150,25);
		backBtn.setFont(font1);
		backBtn.setBackground(color1);
		backBtn.setForeground(Color.WHITE);
		
		backBtn.addActionListener(this);
	
		panel.add(backBtn);
		
		img = new ImageIcon("pic/mdc.jpg");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(0,0,900,705);
		panel.add(imgLabel);

		
		this.add(panel);
   }
   public void actionPerformed(ActionEvent ae){
	   String command = ae.getActionCommand();
		if(backBtn.getText().equals(command)){
			login lg = new login(us);
			lg.setVisible(true);
			this.setVisible(false);
		}
		if(RegisterBtn.getText().equals(command)){
			String name = "", pass = "",confirmPass = "", gender="",
							phn="",address="";
			
			name = userTF.getText();
			pass = passwordTF.getText();
			confirmPass = confirmPasswordTF.getText();
			address = addressTF.getText();
			
			if(r1.isSelected()){
				gender = "Male";
			}else if(r2.isSelected()){
				gender = "Female";
			}else if(r3.isSelected()){
				gender = "Other";
			}
			
			phn = phoneNumberTF.getText();
			
			if(!name.isEmpty() && !pass.isEmpty() && !confirmPass.isEmpty() && !gender.isEmpty() && !phn.isEmpty() && !address.isEmpty()){
				if(pass.equals(confirmPass)){
					//user create - user class - object create - add user to userList array
					user u = new user(name,pass,gender,phn,address);
					us.addUser(u);
					
					JOptionPane.showMessageDialog(this, "Sign up successful. Please login to continue.");
					login lg = new login(us);
					lg.setVisible(true);
					this.setVisible(false);
				}
				else{
					JOptionPane.showMessageDialog(this, "Password missmatch");
				}
			}else{
				JOptionPane.showMessageDialog(this, "Information missing");
			}
			
		}
	}
	

   }



 
		
		
	


		
