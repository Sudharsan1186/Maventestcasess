package testcase;

import java.io.IOException;

import pdfread.PdfBase;
import pdfread.PdfReader;
import pdfread.TextWriter;

public class TestcaseforPdfRead extends PdfBase
{

	public static void main(String[] args) throws IOException
	{
		PdfReader read = new PdfReader();
		read.readPdfContent();
		
		TextWriter write = new TextWriter();
		write.textWriter();	
		
	 }

}
