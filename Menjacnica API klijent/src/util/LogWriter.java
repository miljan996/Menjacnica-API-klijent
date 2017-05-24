package util;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import domain.Log;

public class LogWriter {

	public static void logsToJsonFile(LinkedList<Log> logLst) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
		JsonArray jsonArray = new JsonArray();

		try {
			FileWriter writer = new FileWriter("data/log.json", true);
			for (Log l : logLst) {
				JsonObject json = new JsonObject();
				json.addProperty("datumVreme", dateFormater.format(l.getDatumVreme()));
				json.addProperty("izValuta", l.getIzValuta());
				json.addProperty("uValuta", l.getuValuta());
				json.addProperty("kurs", l.getKurs());

				jsonArray.add(json);
			}
			writer.write(gson.toJson(jsonArray) + ",\n");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
