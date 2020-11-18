package ocr;

import java.io.File;

import com.asprise.ocr.Ocr;

public class OcrRead {

	public static void main(String[] args)
	{
		Ocr ocr = new Ocr();
		ocr.startEngine("eng", ocr.SPEED_FASTEST);
		//String str = ocr.recognize(new File[] {new File("C:\\Users\\c-xpanxion-ssubbiah\\Downloads\\newdoc.pdf")});
         		
	}

}
