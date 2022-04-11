package com.solvd.realstateagency.wordcounter;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordCounter {
	private static Logger LOGGER = LogManager.getLogger(WordCounter.class);
	private static final File INPUT = new File("src/main/resources/text.txt");
	private static final File OUTPUT = new File("src/main/resources/outtext.txt");
	
	private static Pattern pattern = Pattern.compile("\\s|\\.|,", Pattern.CASE_INSENSITIVE);
	private static ArrayList<String> outputArray = new ArrayList<String>();
	
	public static void main(String[] arg) {
		try {
			String stringFile = FileUtils.readFileToString(INPUT);
			String[] arrayFile = pattern.split(stringFile);
			
			int n = 0;
			for (int i = 0; i < arrayFile.length; i++) {
				for (int j = 0; j < arrayFile.length; j++) {
					if (arrayFile[i].equals(arrayFile[j])) {
						n++;
					}
				}
				outputArray.add(arrayFile[i] + "   " + n);
				n = 0;
			}
			FileUtils.writeLines(OUTPUT, outputArray);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		LOGGER.info("Finished");
	}

}
