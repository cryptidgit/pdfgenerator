package mypack;

import java.io.FileNotFoundException;

import com.itextpdf.*;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.*;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PDF {
	private String dest, textFile;
	private double fontSize;
	private Color fontColor;
	private File file;
	private Scanner in;
	
	private Document doc;
	private PdfWriter writer;
	private PdfDocument pdfDoc;
	
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
			
			doc.add(new Paragraph(data));
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
	
	public void setFontSize(double size) {
		fontSize = size;
	}
	
	public void setFontColor(int r, int g, int b) {
		fontColor = new DeviceRgb(r, g, b);
	}
	
	// Getter methods
	
	private String getDest() {
		return dest;
	}
	
	private String getTextFile(String txtFile) {
		return textFile;
	}
	
	
}
