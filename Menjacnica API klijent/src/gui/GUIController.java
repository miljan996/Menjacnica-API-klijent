package gui;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import domain.Currency;
import domain.Log;
import util.ApiCommunication;
import util.LogWriter;

public class GUIController {

	private static MenjacnicaGUI menjacnicaGUI;
	private static LinkedList<Currency> lst;
	private static LinkedList<Log> logs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lst = ApiCommunication.getCountries();
					logs = new LinkedList<Log>();
					
					menjacnicaGUI = new MenjacnicaGUI();
					menjacnicaGUI.setVisible(true);
					
					menjacnicaGUI.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosing(WindowEvent e) {
							exitApp();
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static void exitApp() {
		LogWriter.logsToJsonFile(logs);
		System.exit(0);
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

		for (Currency c : lst) {
			if (c.getName().equals(countryFrom))
				tempFrom = c.getCurrencyId();

			if (c.getName().equals(countryTo))
				tempTo = c.getCurrencyId();
		}

		double res = ApiCommunication.convert(tempFrom, tempTo, value);

		if (res == -1) {
			JOptionPane.showMessageDialog(menjacnicaGUI, "Greska!");
			return -1;
		} else {
			Log temp = new Log(new Date(), tempFrom, tempTo, res);
			logs.addLast(temp);
			return value * res;
		}

	}
}
