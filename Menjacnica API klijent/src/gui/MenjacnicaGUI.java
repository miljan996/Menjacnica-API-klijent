package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.JButton;

public class MenjacnicaGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblIzValuteZemlje;
	private JLabel lblNewLabel;
	private JSpinner spinnerIz;
	private JSpinner spinnerU;
	private JLabel lblIznosIz;
	private JLabel lblIznosU;
	private JTextField textFieldIz;
	private JTextField textFieldU;
	private JButton btnKonvertuj;


	/**
	 * Create the frame.
	 */
	public MenjacnicaGUI() {
		setTitle("Menjacnica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblIzValuteZemlje());
		contentPane.add(getLblNewLabel());
		contentPane.add(getSpinner_1());
		contentPane.add(getSpinner_1_1());
		contentPane.add(getLblIznosIz());
		contentPane.add(getLblIznosU());
		contentPane.add(getTextFieldIz());
		contentPane.add(getTextFieldU());
		contentPane.add(getBtnKonvertuj());
	}
	private JLabel getLblIzValuteZemlje() {
		if (lblIzValuteZemlje == null) {
			lblIzValuteZemlje = new JLabel("Iz valute zemlje:");
			lblIzValuteZemlje.setBounds(44, 44, 132, 15);
		}
		return lblIzValuteZemlje;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("U valutu zemlje:");
			lblNewLabel.setBounds(215, 44, 132, 15);
		}
		return lblNewLabel;
	}
	private JSpinner getSpinner_1() {
		if (spinnerIz == null) {
			String[] countriesStrings = GUIController.getAllCountries(); 
			SpinnerListModel model = new SpinnerListModel(countriesStrings);
			spinnerIz = new JSpinner(model);
			spinnerIz.setBounds(44, 71, 132, 20);
		}
		return spinnerIz;
	}
	private JSpinner getSpinner_1_1() {
		if (spinnerU == null) {
			String[] countriesStrings = GUIController.getAllCountries(); 
			SpinnerListModel model = new SpinnerListModel(countriesStrings);
			spinnerU = new JSpinner(model);
			spinnerU.setBounds(215, 71, 132, 20);
		}
		return spinnerU;
	}
	private JLabel getLblIznosIz() {
		if (lblIznosIz == null) {
			lblIznosIz = new JLabel("Iznos:");
			lblIznosIz.setBounds(44, 128, 132, 15);
		}
		return lblIznosIz;
	}
	private JLabel getLblIznosU() {
		if (lblIznosU == null) {
			lblIznosU = new JLabel("Iznos:");
			lblIznosU.setBounds(215, 128, 132, 15);
		}
		return lblIznosU;
	}
	private JTextField getTextFieldIz() {
		if (textFieldIz == null) {
			textFieldIz = new JTextField();
			textFieldIz.setBounds(44, 155, 132, 19);
			textFieldIz.setColumns(10);
		}
		return textFieldIz;
	}
	private JTextField getTextFieldU() {
		if (textFieldU == null) {
			textFieldU = new JTextField();
			textFieldU.setEnabled(false);
			textFieldU.setBounds(215, 155, 132, 19);
			textFieldU.setColumns(10);
		}
		return textFieldU;
	}
	private JButton getBtnKonvertuj() {
		if (btnKonvertuj == null) {
			btnKonvertuj = new JButton("Konvertuj");
			btnKonvertuj.setBounds(147, 194, 114, 25);
		}
		return btnKonvertuj;
	}
}
