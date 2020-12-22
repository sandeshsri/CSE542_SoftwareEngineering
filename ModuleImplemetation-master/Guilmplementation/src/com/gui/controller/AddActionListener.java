package com.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.gui.view.HomePage;

public class AddActionListener implements ActionListener{
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		HomePage homePageView = HomePage.getHomePageInstance();
		JTextField nameTextField = new JTextField();
		JTextField emailTextField = new JTextField();
		JPasswordField passwordTextField = new JPasswordField();
		Object[] inputFields = 
			{"Name " , nameTextField , 
				"Email ", emailTextField, 
				"Session Password ",   passwordTextField };//
		
		 int option = JOptionPane.showConfirmDialog(null, inputFields, "Add User", JOptionPane.OK_CANCEL_OPTION);
			//JOptionPane.showMessageDialog(null,inputFields);
			String name = nameTextField.getText();
			String mail = emailTextField.getText();
			String pass = passwordTextField.getText();
			

			if (option == JOptionPane.OK_OPTION)
			{
				if(name.isEmpty() || mail.isEmpty() || pass.isEmpty())
    			{
	    			JOptionPane.showMessageDialog(null,"Please enter all the required details");

    			}			
				else
    			{			    			
					homePageView.getInitialdata().addRow(new Object[] {nameTextField.getText(),homePageView.unpausedValue});
    			}	    			    
			}   			
        
		
	}

}
