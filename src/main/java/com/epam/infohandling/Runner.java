package com.epam.infohandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.epam.infohandling.model.Composite;
import com.epam.infohandling.model.Leaf;
import com.epam.infohandling.parsing.ChainBuilder;
import com.epam.infohandling.parsing.Parser;

public class Runner {
	public static void main(String[] args) {
 		parseTest();
	}

	public static void parseTest() {
		try {
			ChainBuilder builder = new ChainBuilder();
			Parser parser = builder.build();
			String text = readFile();
			Composite composite = parser.parse(text);
			//print(composite);
			restoreText(composite);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	private static void restoreText(Composite composite) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < composite.childrenCount(); i++) {
			Composite child = (Composite)composite.getChild(i);
			sb.append("\t");
			for(int j = 0; j < child.childrenCount(); j++) {
				Composite childLevel2 =  (Composite)child.getChild(j);
				//sb.append(childLevel2.getValue()).append(" ");
				for(int z = 0; z < childLevel2.childrenCount(); z++) {
					Leaf childLevel3 =  (Leaf)childLevel2.getChild(z);
					sb.append(childLevel3.getValue()).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	private static void print(Composite composite) {
		System.out.println(composite.getName() + " " + prettyPrintValue(composite.getValue()));
		for(int i = 0; i < composite.childrenCount(); i++) {
			Composite child = (Composite)composite.getChild(i);
			System.out.println("    " + child.getName() + " " + prettyPrintValue(child.getValue()));
			for(int j = 0; j < child.childrenCount(); j++) {
				Composite childLevel2 =  (Composite)child.getChild(j);
				System.out.println("        " + childLevel2.getName() + " " + prettyPrintValue(childLevel2.getValue()));
				
				
				for(int z = 0; z < childLevel2.childrenCount(); z++) {
					Leaf childLevel3 =  (Leaf)childLevel2.getChild(z);
					System.out.println("            " + childLevel3.getName() + " " + childLevel3.getValue());
				}
				
			}
			
		}
	}


	private static String prettyPrintValue(Object value) {
		String strValue = (String)value;
		String result = strValue;
		if(strValue.length() > 12) {
			result = strValue.substring(0, 7) + ".***********************.." + strValue.substring(strValue.length() - 7, strValue.length());
		}
		return result;
	}

	private static String readFile() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("D:\\Education\\MJS-School-code\\infohandling\\src\\main\\resources\\Text_sample.txt"));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			String everything = sb.toString();
			return everything;
		} finally {
			br.close();
		}
	}
}
