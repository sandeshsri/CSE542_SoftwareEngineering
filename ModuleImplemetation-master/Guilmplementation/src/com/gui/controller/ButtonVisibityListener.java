package com.gui.controller;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.gui.view.HomePage;

public class ButtonVisibityListener implements ListSelectionListener{

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		
		HomePage homePageView = HomePage.getHomePageInstance();

		int selectedRow = homePageView.getJt().getSelectedRow();
		//System.out.println("selectedRow : " + selectedRow);
		if (selectedRow <= 0) {
			homePageView.getRemovebutton().setEnabled(false);
			homePageView.getPausebutton().setEnabled(false);
			homePageView.getUnpausebutton().setEnabled(false);
			return;
		}

		homePageView.getRemovebutton().setEnabled(true);

		String status = (String) homePageView.getInitialdata().getValueAt(selectedRow, 1);
		if (homePageView.pausedValue.equals(status)) {
			homePageView.getUnpausebutton().setEnabled(true);
			homePageView.getPausebutton().setEnabled(false);
		} else if (homePageView.unpausedValue.equals(status)) {
			homePageView.getPausebutton().setEnabled(true);
			homePageView.getUnpausebutton().setEnabled(false);
		}

	
		
	}

}
