package pdfread;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.testng.annotations.Test;


public class PdfReader extends PdfBase {
	
	public void readPdfContent() throws IOException 
	{
		  	
				  
		fw = new FileWriter(filewrite);
		   
		 writer  = new BufferedWriter(fw);
		   
		 fis = new FileInputStream(fileread); 
		  
		 parser = new PDFParser(fis); parser.parse();
		  
		 cosdoc = parser.getDocument();
		  
		 pddoc = new PDDocument(cosdoc);
		  
		 strip = new PDFTextStripper();
		 text = strip.getText(pddoc);
		 strAr = text.split("Terms and Conditions:");
		 
		 split1 = text.split("Contract Start Date –");
		 startDate = split1[1].split("Contract End Date")[0].trim();
			 //System.out.println("Contract Start Date : " +split1[1].split("Contract End Date")[0].trim());
			  
	     split2 = text.split("Contract End Date –");
		 endDate = split2[1].split("Exhibit A")[0].trim();
			// System.out.println("Contract End Date : " +split2[1].split("Exhibit A")[0].trim()); 
		
		 	 
		    
        
	}

	
}
