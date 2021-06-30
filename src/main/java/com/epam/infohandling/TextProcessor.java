package com.epam.infohandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.infohandling.model.Component;
import com.epam.infohandling.parsing.ChainBuilder;
import com.epam.infohandling.parsing.Parser;

public class TextProcessor {
	private static Logger logger = LogManager.getLogger();

	public Component parseText(String text) throws IOException {
		Parser parser = new ChainBuilder().build();
		String textRromFile = readResource(text);
		logger.info("# textParser parsed text #");
		return parser.parse(textRromFile.trim());
	}

	private String readResource(String text) throws IOException {
		InputStream in = this.getClass().getResourceAsStream("/" + text);

		try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in))) 
		{
			StringBuilder sb = new StringBuilder();
			String line = bufferedReader.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = bufferedReader.readLine();
			}
			String everything = sb.toString();
			logger.debug("# text from file was read #");
			return everything;
		}
	}
}




