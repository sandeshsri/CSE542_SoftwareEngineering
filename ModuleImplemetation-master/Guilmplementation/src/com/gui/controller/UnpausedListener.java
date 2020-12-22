package com.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import com.gui.view.HomePage;

public class UnpausedListener implements ActionListener {

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent arg0) {

		HomePage homePageView = HomePage.getHomePageInstance();
		JPasswordField passwordTextField = new JPasswordField();
		Object[] pass = { "Session Password ", passwordTextField };

		int option = JOptionPane.showConfirmDialog(null, pass, "Enter the session password",
				JOptionPane.OK_CANCEL_OPTION);
		String pwd = passwordTextField.getText();
		if (option == JOptionPane.OK_OPTION) {
			if (pwd.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please enter the password");

			} else {
				// String pwd = JOptionPane.showInputDialog(null, "Enter the session
				// password:");

				int selectedRow = homePageView.getJt().getSelectedRow();
				int selectedColumn = 1;
				System.out.println("selectedRow = " + selectedRow);

				Boolean priorCondition = selectedRow != -1 && selectedRow != 0;
				if (priorCondition) {
					homePageView.getInitialdata().setValueAt("Unpaused", selectedRow, selectedColumn);
					homePageView.getPausebutton().setEnabled(true);
					homePageView.getUnpausebutton().setEnabled(false);
				}
			}
		}

	}

}
