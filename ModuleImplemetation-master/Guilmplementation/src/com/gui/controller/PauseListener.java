package com.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import com.gui.view.HomePage;

public class PauseListener implements ActionListener {

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		HomePage homePageView = HomePage.getHomePageInstance();
		JPasswordField passwordTextField = new JPasswordField();
		Object[] pass = { "Session Password ", passwordTextField };//

		int option = JOptionPane.showConfirmDialog(null, pass, "Enter the session password",
				JOptionPane.OK_CANCEL_OPTION);
		String pwd = passwordTextField.getText();
		if (option == JOptionPane.OK_OPTION) {
			if (pwd.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please enter the password");

			} else {
				int selectedRow = homePageView.getJt().getSelectedRow();
				// int selectedColumn = jt.getSelectedColumn();
				int selectedColumn = 1;

				//String dataSelected = String
					//	.valueOf(homePageView.getInitialdata().getValueAt(selectedRow, selectedColumn));
				Boolean priorCondition = selectedRow != -1 && selectedRow != 0;

				if (priorCondition) {
					homePageView.getInitialdata().setValueAt("Paused", selectedRow, selectedColumn);
					homePageView.getPausebutton().setEnabled(false);
					homePageView.getUnpausebutton().setEnabled(true);
				}
			}
		}

	}

}
