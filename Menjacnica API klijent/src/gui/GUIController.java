package gui;

import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import domain.Currency;
import util.ApiCommunication;

public class GUIController {

	private static MenjacnicaGUI menjacnicaGUI;
	private static LinkedList<Currency> lst;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lst = ApiCommunication.getCountries();
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

	public static double convert(String countryFrom, String countryTo, String amount) {
		double value;
		
		try {
			value = Double.parseDouble(amount);
			if (value < 0) {
				JOptionPane.showMessageDialog(menjacnicaGUI, "Greska!");
				return -1;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(menjacnicaGUI, "Greska!");
			return -1;
		}
		
		String tempFrom = "";
		String tempTo = "";
		
		for (Currency c: lst) {
			if (c.getName().equals(countryFrom)) 
				tempFrom = c.getCurrencyId();
			
			if (c.getName().equals(countryTo))
				tempTo = c.getCurrencyId();
		}
		
		double res =  ApiCommunication.convert(tempFrom, tempTo, value);
		
		if (res == -1) {
			JOptionPane.showMessageDialog(menjacnicaGUI, "Greska!");
			return -1;
		} else {
			return value * res;
		}
		
		
		
	}
}
