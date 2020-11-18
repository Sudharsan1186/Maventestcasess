package pdf;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

/*import pdfread.PdfReader;
import pdfread.TextWriter;*/

public class PdfReadAndWrite {

		 public static FileInputStream fis;
		 public static PDFParser parser;
		 public static COSDocument cosdoc;
		 public static  PDDocument pddoc;
		 public static  PDFTextStripper strip;
		 public static  File fileread,fileread1, filewrite;
		 public static  FileWriter fw;
		 public static BufferedWriter writer;
		 public static String text,startDate,endDate;
		 public static String[] strAr,split1,split2;
		 

	
	public static void main(String[] args) throws IOException 
	{		 
		fileread = new File("C:\\Users\\c-xpanxion-ssubbiah\\Downloads\\newdoc.pdf");
		
		filewrite = new File("C:\\Users\\c-xpanxion-ssubbiah\\Desktop\\Write.txt");
	
			  
		 fw = new FileWriter(filewrite);
		   
		 writer  = new BufferedWriter(fw);
		   
		 fis = new FileInputStream(fileread);
		  
		 parser = new PDFParser(fis); parser.parse();
		  
		 cosdoc = parser.getDocument();
		  
		 pddoc = new PDDocument(cosdoc);
		  
		 strip = new PDFTextStripper();
		 text = strip.getText(pddoc);
		 System.out.println(text);
			
			  strAr = text.split("Terms and Conditions:");
			  
			  
			  split1 = text.split("Contract Start Date –"); startDate =
			  split1[1].split("Contract End Date")[0].trim();
			  //System.out.println("Contract Start Date : "+split1[1].split("Contract End Date")[0].trim());
			  
			  split2 = text.split("Contract End Date –"); endDate =
			  split2[1].split("Exhibit A")[0].trim(); //
			  System.out.println("Contract End Date : "
			  +split2[1].split("Exhibit A")[0].trim());
			  
			  writer.write("TERMS AND CONDITION"); writer.write(strAr[1]);
			  writer.newLine(); 
			  writer.write("=============================================================================================="); 
			  writer.write(startDate);
			  writer.newLine(); 
			  writer.write(endDate);
			  writer.close();		 
				 
				
	 }
	
} 
