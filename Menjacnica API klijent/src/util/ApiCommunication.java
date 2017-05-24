package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.Set;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import domain.Currency;

public class ApiCommunication {

	private static String sendGet(String url) throws IOException {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

		boolean endReading = false;
		String response = "";

		while (!endReading) {
			String s = in.readLine();

			if (s != null) {
				response += s;
			} else {
				endReading = true;
			}
		}
		in.close();

		return response.toString();
	}

	public static LinkedList<Currency> getCountries() {
		LinkedList<Currency> tempCurrLst = new LinkedList<Currency>();
		String url = "http://free.currencyconverterapi.com/api/v3/countries";

		try {
			String response = sendGet(url);

			Gson gson = new GsonBuilder().create();
			JsonObject tempJson = gson.fromJson(response, JsonObject.class);
			JsonObject results = (JsonObject) tempJson.get("results");
			Set<Entry<String, JsonElement>> set = results.entrySet();

			for (Entry<String, JsonElement> pair : set) {
				Currency tempCur = new Currency();
				JsonObject tempVal = (JsonObject) pair.getValue();
				tempCur.setName(tempVal.get("name").getAsString());
				tempCur.setCurrencyId(tempVal.get("currencyId").getAsString());

				tempCurrLst.add(tempCur);
			}

			return tempCurrLst;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}
