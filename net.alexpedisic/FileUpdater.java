package net.alexpedisic.fileupdater;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

public class FileUpdater {
	
	private static File file;
	
	public static String readToString(String targetURL) throws IOException
	{
	    URL url = new URL(targetURL);
	    BufferedReader bufferedReader = new BufferedReader(
	            new InputStreamReader(url.openStream()));

	    StringBuilder stringBuilder = new StringBuilder();

	    String inputLine;
	    while ((inputLine = bufferedReader.readLine()) != null)
	    {
	        stringBuilder.append(inputLine);
	        stringBuilder.append(System.lineSeparator());
	    }

	    bufferedReader.close();
	    return stringBuilder.toString().trim();
	}
	
	public static String fileToString(String targetFile) throws IOException
	{
		StringBuilder stringBuilder = new StringBuilder();
		
	    BufferedReader br = new BufferedReader(new FileReader(targetFile));
	    String textLine;
	    while ((textLine = br.readLine()) != null) {
	        stringBuilder.append(textLine);
	        stringBuilder.append(System.lineSeparator());
	    }

	    br.close();
	    return stringBuilder.toString().trim();
	}
	
	public static void writeUpdatedFile(String updateFile, String targetFile) {
		PrintWriter writer;
		try {
			writer = new PrintWriter(targetFile, "UTF-8");
			try {
				writer.println(readToString(updateFile));
			} catch (IOException e) {
				e.printStackTrace();
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}
	
	
	public static void main(String[] args) throws MalformedURLException {
		try {
			String currentver = fileToString("C:\\Users\\alexpedisic.dev\\Documents\\version.txt");
			
			System.out.println(currentver);
			
			if(readToString("http://www.puzzlers.org/pub/wordlists/pocket.txt").contains(currentver.trim())) {
				System.out.println("File is up to date.");
			} else {
				System.out.println("The file has changed, shall we update?");
				try {
				writeUpdatedFile("http://www.puzzlers.org/pub/wordlists/pocket.txt", "C:\\Users\\alexpedisic.dev\\Documents\\version.txt");
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("Updated.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
