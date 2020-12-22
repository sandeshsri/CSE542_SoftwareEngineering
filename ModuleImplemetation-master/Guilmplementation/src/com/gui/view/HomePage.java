package com.gui.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.gui.controller.AddActionListener;
import com.gui.controller.ButtonVisibityListener;
import com.gui.controller.PauseListener;
import com.gui.controller.RemoveActionListener;
import com.gui.controller.UnpausedListener;

enum Status {
	PAUSED, UNPAUSED
};

@SuppressWarnings("serial")
public class HomePage extends JFrame {

	private static HomePage homePageViewObj;
	private CardLayout cl;
	private JTable jt;
	private JButton removebutton;
	private JButton addbutton;
	private JButton pausebutton;
	private JButton unpausebutton;
	private DefaultTableModel initialdata;

	public String pausedValue = "Paused";
	public String unpausedValue = "Unpaused";

	public CardLayout getCl() {
		return cl;
	}

	public JTable getJt() {
		return jt;
	}

	public JButton getRemovebutton() {
		return removebutton;
	}

	public JButton getAddbutton() {
		return addbutton;
	}

	public JButton getPausebutton() {
		return pausebutton;
	}

	public JButton getUnpausebutton() {
		return unpausebutton;
	}

	public void setCl(CardLayout cl) {
		this.cl = cl;
	}

	public void setJt(JTable jt) {
		this.jt = jt;
	}

	public void setRemovebutton(JButton removebutton) {
		this.removebutton = removebutton;
	}

	public void setAddbutton(JButton addbutton) {
		this.addbutton = addbutton;
	}

	public void setPausebutton(JButton pausebutton) {
		this.pausebutton = pausebutton;
	}

	public void setUnpausebutton(JButton unpausebutton) {
		this.unpausebutton = unpausebutton;
	}

	public HomePage() {

		String header[] = new String[] { "Name", "Queue Status" };

		initialdata = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		initialdata.setColumnIdentifiers(header);
		initialdata.addRow(header);
		initialdata.addRow(new Object[] { "Harsh", unpausedValue });
		initialdata.addRow(new Object[] { "Mridula", pausedValue });
		initialdata.addRow(new Object[] { "Saranya", unpausedValue });
		initialdata.addRow(new Object[] { "Varsha", unpausedValue });
		// initialdata.addRow(new Object[] { "Sandesh",unpausedValue });// 0-4 entries

		setTitle("GUI");
		setSize(500, 250);
		JPanel cardPanel = new JPanel();
		cl = new CardLayout();
		cardPanel.setLayout(cl);

		JPanel jp1 = new JPanel();
		jt = new JTable(initialdata);
		jt.setModel(initialdata);
		jt.setBounds(30, 40, 200, 300);
		jt.setColumnSelectionAllowed(false);
		jp1.add(jt);
		ListSelectionModel cellSelectionModel = jt.getSelectionModel();
		cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cardPanel.add(jt, "1");

		JPanel buttonPanel = new JPanel();

		addbutton = new JButton("ADD");
		removebutton = new JButton("REMOVE");
		removebutton.setEnabled(false);
		pausebutton = new JButton("PAUSE");
		pausebutton.setEnabled(false);
		unpausebutton = new JButton("UNPAUSE");
		unpausebutton.setEnabled(false);

		buttonPanel.add(addbutton);
		buttonPanel.add(removebutton);
		buttonPanel.add(pausebutton);
		buttonPanel.add(unpausebutton);

		getContentPane().add(cardPanel, BorderLayout.NORTH);
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);

		addbutton.addActionListener(new AddActionListener());
		removebutton.addActionListener(new RemoveActionListener());
		pausebutton.addActionListener(new PauseListener());
		unpausebutton.addActionListener(new UnpausedListener());
		cellSelectionModel.addListSelectionListener(new ButtonVisibityListener());

	}

	public static void main(String[] args) {

		homePageViewObj = getHomePageInstance();
		homePageViewObj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		homePageViewObj.setVisible(true);

	}

	public DefaultTableModel getInitialdata() {
		return initialdata;
	}

	public void setInitialdata(DefaultTableModel initialdata) {
		this.initialdata = initialdata;
	}

	public static HomePage getHomePageInstance() {
		if (null == homePageViewObj) {
			homePageViewObj = new HomePage();
		}
		return homePageViewObj;
	}

}
