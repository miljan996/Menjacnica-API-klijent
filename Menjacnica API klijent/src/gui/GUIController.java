package gui;

import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import domain.Currency;
import util.ApiCommunication;

public class GUIController {

	private static MenjacnicaGUI menjacnicaGUI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menjacnicaGUI = new MenjacnicaGUI();
					menjacnicaGUI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static String[] getAllCountries() {
		LinkedList<Currency> tempLst = ApiCommunication.getCountries();

		if (tempLst != null) {
			String[] tempCountries = new String[tempLst.size()];

			int i = -1;
			for (Currency c : tempLst) {
				tempCountries[++i] = c.getName();
			}

			return tempCountries;

		} else {
			JOptionPane.showMessageDialog(menjacnicaGUI, "Greska!");
			return null;
		}

	}
}
