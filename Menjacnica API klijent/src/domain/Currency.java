package domain;

public class Currency {

	private String name;
	private String currencyId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

	@Override
	public String toString() {
		return "Currency [name=" + name + ", currencyId=" + currencyId + "]";
	}

}
