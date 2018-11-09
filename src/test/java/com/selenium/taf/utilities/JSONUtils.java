package com.selenium.taf.utilities;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.github.javafaker.Faker;

public class JSONUtils {

	public static Object[][] parseFileJSONReader(String path) {

		String[][] tabArray = null;
		JSONParser parser = new JSONParser();
		JSONArray jsonArray;
		try {
			jsonArray = (JSONArray) parser.parse(new FileReader(path));
			int i = 0;
			tabArray = new String[jsonArray.size()][5];

			for (Object o : jsonArray) {
				JSONObject user = (JSONObject) o;

				tabArray[i][0] = (String) user.get("gender");

				tabArray[i][1] = (String) user.get("firstName");

				tabArray[i][2] = (String) user.get("lastName");

				tabArray[i][3] = (String) user.get("email");

				tabArray[i][4] = (String) user.get("password");

				i++;

			}

		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return tabArray;

	}

	@SuppressWarnings("unchecked")
	public static void WriteFakerDateInJSONFile(String path) throws IOException {
		File file = new File(path);
		file.createNewFile();
		FileWriter fileWriter = new FileWriter(file);
		JSONArray jsonArray = new JSONArray();

		for (int i = 1; i <= 50; i++) {

			JSONObject user = new JSONObject();
			user.put("gender", "male");
			user.put("firstName", new Faker().name().firstName());
			user.put("lastName", new Faker().name().lastName());
			user.put("email", new Faker().internet().emailAddress());
			user.put("password", new Faker().internet().password());

			// Writing to a file
			jsonArray.add(user);

			System.out.println("Writing JSON object to file");
			System.out.println("-----------------------");
			System.out.print(user);

		}
		jsonArray.writeJSONString(fileWriter);
		fileWriter.close();
	}

}
