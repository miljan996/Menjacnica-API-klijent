package domain;

import java.util.Date;

public class Log {

	private Date datumVreme;
	private String izValuta;
	private String uValuta;
	private Double kurs = null;

	public Log(Date datumVreme, String izValuta, String uValuta, Double kurs) {
		this.datumVreme = datumVreme;
		this.izValuta = izValuta;
		this.uValuta = uValuta;
		this.kurs = kurs;
	}

	public Log() {
	}

	public Date getDatumVreme() {
		return datumVreme;
	}

	public void setDatumVreme(Date datumVreme) {
		this.datumVreme = datumVreme;
	}

	public String getIzValuta() {
		return izValuta;
	}

	public void setIzValuta(String izValuta) {
		this.izValuta = izValuta;
	}

	public String getuValuta() {
		return uValuta;
	}

	public void setuValuta(String uValuta) {
		this.uValuta = uValuta;
	}

	public Double getKurs() {
		return kurs;
	}

	public void setKurs(Double kurs) {
		this.kurs = kurs;
	}

}
