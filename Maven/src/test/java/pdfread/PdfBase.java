package pdfread;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class PdfBase
{
 public  FileInputStream fis;
 public  PDFParser parser;
 public  COSDocument cosdoc;
 public  PDDocument pddoc;
 public  PDFTextStripper strip;
 public  File fileread, filewrite;
 public  FileWriter fw;
 public  BufferedWriter writer;
 public static String text,startDate,endDate;
 public static String[] strAr,split1,split2;
 
	public void pdfBase() throws IOException
	{		 
		fileread = new File("C:\\Users\\c-xpanxion-ssubbiah\\Desktop\\Contract Details.pdf");
		filewrite = new File("C:\\Users\\c-xpanxion-ssubbiah\\Desktop\\Write.txt");
		   
         
		  
	}
}
