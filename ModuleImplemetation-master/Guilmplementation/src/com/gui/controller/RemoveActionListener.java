package com.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import com.gui.view.HomePage;

public class RemoveActionListener implements ActionListener {

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) {

		HomePage homePageView = HomePage.getHomePageInstance();
		JPasswordField passwordTextField = new JPasswordField();
		Object[] pass = { "Session Password ", passwordTextField };//

		int option = JOptionPane.showConfirmDialog(null, pass, "Remove User", JOptionPane.OK_CANCEL_OPTION);
		// JOptionPane.showMessageDialog(null,inputFields);
		String pwd = passwordTextField.getText();
		if (option == JOptionPane.OK_OPTION) {
			if (pwd.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please enter the password");

			} else {
				int selectedRow = homePageView.getJt().getSelectedRow();
				// System.out.println("selectedRow : " + selectedRow);
				System.out.println(selectedRow);
				if (selectedRow != -1 && selectedRow != 0)
					homePageView.getInitialdata().removeRow(selectedRow);
				if (homePageView.getInitialdata().getRowCount() < 2) {
					JOptionPane.showMessageDialog(null, "Queue is empty");
				}
			}

		}
	}

}
