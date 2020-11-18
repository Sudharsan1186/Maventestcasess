package pdfread;

import java.io.IOException;

public class TextWriter extends PdfBase
 {

	public void textWriter() throws IOException
	{
		 writer.write(startDate);
		 writer.newLine();
		 writer.write(endDate);
		 writer.close();
		 
		 
	}
}
