package mypack;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.itextpdf.*;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.*;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PDF {
	private String dest, textFile;
	private float fontSize = 12.0f;
	private Color fontColor = new DeviceRgb(0, 0, 0);
	private File file;
	private Scanner in;
	
	private Document doc;
	private PdfWriter writer;
	private PdfDocument pdfDoc;
	private PdfFont times, helvetica, courier, symbol, zapf, docFont;
	
	PDF(String dest, String txtFile) throws FileNotFoundException {
		setDest(dest);
		setTextFile(txtFile);
		
		writer = new PdfWriter(dest);
		pdfDoc = new PdfDocument(writer);
		doc = new Document(pdfDoc);
	}
	
	public void makePDF() throws FileNotFoundException {
		in = new Scanner(file);
		
		
		while(in.hasNextLine()) {
			String data = in.nextLine();
			
			doc.add(new Paragraph(data).setFontSize(fontSize).setFontColor(fontColor).setFont(docFont));
		}		
		doc.close();
	}
	
	// Setter methods
	
	private void setDest(String dest) {
		this.dest = dest;
	}
	
	private void setTextFile(String txtFile) {
		textFile = txtFile;
		file = new File(txtFile);
	}
	
	public void setFontSize(float size) {
		fontSize = (float)size;
	}
	
	public void setFontColor(int r, int g, int b) {
		fontColor = new DeviceRgb(r, g, b);
	}
	
	public void setFont(String font) throws IOException {
		times = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
		helvetica = PdfFontFactory.createFont(StandardFonts.HELVETICA);
		courier = PdfFontFactory.createFont(StandardFonts.COURIER);
		symbol = PdfFontFactory.createFont(StandardFonts.SYMBOL);
		zapf = PdfFontFactory.createFont(StandardFonts.ZAPFDINGBATS);
		
		switch(font) {
			case "Courier":
				docFont = courier;
				break;
			case "Helvetica":
				docFont = helvetica;
				break;
			case "Symbol":
				docFont = symbol;
				break;
			case "Times New Roman":
				docFont = times;
				break;
			case "Zapf Dingbats":
				docFont = zapf;
				break;
			default:
				docFont = helvetica;
				break;
		}
		
	}
	
	// Getter methods
	
	private String getDest() {
		return dest;
	}
	
	private String getTextFile(String txtFile) {
		return textFile;
	}
	
	
}
