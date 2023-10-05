import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilesHandling {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\PSahani\\Test1.csv"); // file Extension change depend .txt /.csv

		// file.mkdir(); this is used for folder creation

		file.createNewFile(); // used file creation
		// Write a data
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		String data = "Selenium with Java Training 11 April ";
		bw.write(data);
		bw.close();

		// Read a data
		String text;
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		while ((text = br.readLine()) != null)
		{
			System.out.println(text);
		}

		
//	       System.out.println(file.canRead());
//	       System.out.println(file.canWrite());
//		   System.out.println(file.getName());
//		   System.out.println(file.length());
		 
		 

		/*
		 * boolean a=file.exists(); if(a==true) { System.out.println("Folder Exist "); }
		 * else { System.out.println("Floder Does not Exist"); }
		 * 
		 * // file.delete();
		 */ 
		}

}
