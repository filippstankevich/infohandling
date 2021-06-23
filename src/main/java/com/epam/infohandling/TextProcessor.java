package com.epam.infohandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import com.epam.infohandling.model.Composite;
import com.epam.infohandling.parsing.ChainBuilder;
import com.epam.infohandling.parsing.Parser;

public class TextProcessor {

	public Composite parseText(String text) throws IOException {		//изменить на Component
		Parser parser = new ChainBuilder().build();
		String textRromFile = readResource(text);
		return parser.parse(textRromFile.trim());
	}

	private String readResource(String text) throws IOException {
		InputStream in = this.getClass().getResourceAsStream("/" + text);

		try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in))) 
		{
			//try {
				StringBuilder sb = new StringBuilder();
				String line = bufferedReader.readLine();

				while (line != null) {
					sb.append(line);
					sb.append(System.lineSeparator());
					line = bufferedReader.readLine();
				}
				String everything = sb.toString();
				return everything;
			/*/} finally {
				bufferedReader.close();
			}*/
		}
	}
}
