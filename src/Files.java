import java.io.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Files {

	//private static final String Try = null;

	public static void main(String[] args) throws IOException {

		
		  File f =new File("C:\\Users\\PSahani\\Desktop\\Test.txt"); //f.mkdir();
		  f.createNewFile(); //boolean c=f //f.delete();
		  if(f.exists()== true) 
		  {
		  System.out.println("Files is created"); 
		  System.out.println("URL : " +f.getAbsolutePath());
          System.out.println("File writable :"+f.canWrite());
		  System.out.println(" File Readable" +f.canRead());
		  System.out.println("File Size" +f.length()); } 
		  else {
			  
		  
		  System.out.println("Files is not created"); 
		  }
		 
		try {
			FileWriter a = new FileWriter("C:\\Users\\PSahani\\Automation\\DesktopFileshandling.txt");

			try {
				a.write(" JAVA IS a Programming Lanuage..!");
			} finally {
				a.close();
			}
			System.out.println(" sucessfully data wrote in files");
		}

		catch (IOException e) {

		}

		try {
			FileReader b = new FileReader("C:\\Users\\PSahani\\Automation\\DesktopFileshandling.txt");
			try {
				int i;
				while ((i = b.read())!=-i) {
					System.out.print((char) i);
				}
			} finally {
				b.close();
			}
		} catch (IOException e) {
			System.out.println("Exception handling :::");
		}
	}
}
