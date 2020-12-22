
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class FrameLayout extends JFrame {
	private int currentCard = 1;

	// Declaration of objects of CardLayout class.

	private CardLayout cl;
	JTable jt;
	JButton removebutton;
	JButton addbutton;
	JButton pausebutton;
	JButton unpausebutton;

	public FrameLayout() {
		String header[] = new String[] { "Name", "Queue Status" };
		DefaultTableModel initialdata = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		initialdata.setColumnIdentifiers(header);
		initialdata.addRow(header);
		initialdata.addRow(new Object[] { "Harsh", "Unpaused" });
		initialdata.addRow(new Object[] { "Mridula", "Paused" });
		initialdata.addRow(new Object[] { "Saranya", "Unpaused" });
		initialdata.addRow(new Object[] { "Varsha", "Unpaused" });

		String pausedValue = "Paused";
		String unpausedValue = "Unpaused";

		// Function to set visibility of JFrame
		setTitle("GUI");

		// Function to set visibility of JFrame
		setSize(500, 250);

		JPanel cardPanel = new JPanel();

		// Initialization of object "c1"
		// of CardLayout class.
		cl = new CardLayout();

		// set the layout
		cardPanel.setLayout(cl);

		// Initialization of object
		// "jp1" of JPanel class.
		JPanel jp1 = new JPanel();
		jt = new JTable(initialdata);
		jt.setModel(initialdata);
		jt.setBounds(30, 40, 200, 300);
		jt.setColumnSelectionAllowed(false);
		jp1.add(jt);
		ListSelectionModel cellSelectionModel = jt.getSelectionModel();
		cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cardPanel.add(jt, "1");

		// Creating Object of "JPanel" class
		JPanel buttonPanel = new JPanel();

		// Initialization of objects

		addbutton = new JButton("ADD");
		removebutton = new JButton("REMOVE");
		removebutton.setEnabled(false);
		pausebutton = new JButton("PAUSE");
		pausebutton.setEnabled(false);
		unpausebutton = new JButton("UNPAUSE");
		unpausebutton.setEnabled(false);

		// Adding JButtons on JFrame buttonpanel
		buttonPanel.add(addbutton);
		buttonPanel.add(removebutton);
		buttonPanel.add(pausebutton);
		buttonPanel.add(unpausebutton);

		addbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JTextField nameTextField = new JTextField();
				JTextField emailTextField = new JTextField();
				JPasswordField passwordTextField = new JPasswordField();
				Object[] inputFields = { "Name ", nameTextField, "Email ", emailTextField, "Session Password ",
						passwordTextField };//

				int option = JOptionPane.showConfirmDialog(null, inputFields, "Add User", JOptionPane.OK_CANCEL_OPTION);
				// JOptionPane.showMessageDialog(null,inputFields);
				String name = nameTextField.getText();
				String mail = emailTextField.getText();
				String pass = passwordTextField.getText();

				if (option == JOptionPane.OK_OPTION) {
					if (name.isEmpty() || mail.isEmpty() || pass.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please enter all the required details");

					} else {
						initialdata.addRow(new Object[] { nameTextField.getText(), "Unpaused" });
					}
				}
			}
		});

		removebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JPasswordField passwordTextField = new JPasswordField();
				Object[] pass = { "Session Password ", passwordTextField };//

				int option = JOptionPane.showConfirmDialog(null, pass, "Remove User", JOptionPane.OK_CANCEL_OPTION);
				// JOptionPane.showMessageDialog(null,inputFields);
				String pwd = passwordTextField.getText();

				if (option == JOptionPane.OK_OPTION) {
					if (pwd.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please enter the password");

					}

					else {
						int selectedRow = jt.getSelectedRow();
						System.out.println(selectedRow);
						if (selectedRow != -1 && selectedRow != 0)
							initialdata.removeRow(selectedRow);
						if (initialdata.getRowCount() < 2) {
							JOptionPane.showMessageDialog(null, "Queue is empty");
						}
					}

				}
			}
		});

		pausebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * String pwd = JOptionPane.showInputDialog(null,
				 * "Enter the session password:"); int selectedRow = jt.getSelectedRow(); //int
				 * selectedColumn = jt.getSelectedColumn(); int selectedColumn = 1; String
				 * dataSelected = String.valueOf(initialdata.getValueAt(selectedRow,
				 * selectedColumn)); Boolean priorCondition = selectedRow != -1 && selectedRow
				 * != 0; if (priorCondition) { initialdata.setValueAt(pausedValue, selectedRow,
				 * selectedColumn); }
				 */

				JPasswordField passwordTextField = new JPasswordField();
				Object[] pass = { "Session Password ", passwordTextField };//

				int option = JOptionPane.showConfirmDialog(null, pass, "Enter the session password",
						JOptionPane.OK_CANCEL_OPTION);
				String pwd = passwordTextField.getText();

				if (option == JOptionPane.OK_OPTION) {
					if (pwd.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please enter the password");

					} else {
						int selectedRow = jt.getSelectedRow();
						// int selectedColumn = jt.getSelectedColumn();
						int selectedColumn = 1;

						String dataSelected = String.valueOf(initialdata.getValueAt(selectedRow, selectedColumn));
						Boolean priorCondition = selectedRow != -1 && selectedRow != 0;

						if (priorCondition) {
							initialdata.setValueAt(pausedValue, selectedRow, selectedColumn);
							pausebutton.setEnabled(false);
							unpausebutton.setEnabled(true);
						}
					}
				}

			}
		});

		unpausebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JPasswordField passwordTextField = new JPasswordField();
				Object[] pass = { "Session Password ", passwordTextField };//

				int option = JOptionPane.showConfirmDialog(null, pass, "Enter the session password",
						JOptionPane.OK_CANCEL_OPTION);
				String pwd = passwordTextField.getText();

				if (option == JOptionPane.OK_OPTION)
					if (pwd.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please enter the password");

					} else {
						int selectedRow = jt.getSelectedRow();
						int selectedColumn = 1;

						String dataSelected = String.valueOf(initialdata.getValueAt(selectedRow, selectedColumn));

						Boolean priorCondition = selectedRow != -1 && selectedRow != 0;
						if (priorCondition) {
							initialdata.setValueAt(unpausedValue, selectedRow, selectedColumn);
							unpausebutton.setEnabled(false);
							pausebutton.setEnabled(true);
						}
					}
				{
					// String pwd = JOptionPane.showInputDialog(null, "Enter the session
					// password:");

				}

			}
		});

		cellSelectionModel.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent lse) {

				int selectedRow = jt.getSelectedRow();

				if (selectedRow <= 0) {
					removebutton.setEnabled(false);
					unpausebutton.setEnabled(false);
					pausebutton.setEnabled(false);
					return;
				}

				removebutton.setEnabled(true);

				String status = (String) initialdata.getValueAt(selectedRow, 1);
				if ("Paused".equals(status)) {
					unpausebutton.setEnabled(true);
					pausebutton.setEnabled(false);
				} else if ("Unpaused".equals(status)) {
					pausebutton.setEnabled(true);
					unpausebutton.setEnabled(false);
				}

			}

		});

		// getting content pane(table and buttons)
		getContentPane().add(cardPanel, BorderLayout.NORTH);
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		FrameLayout cl = new FrameLayout();
		cl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cl.setVisible(true);
	}
}
