package mypack;

import java.io.FileNotFoundException;

import com.itextpdf.*;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.*;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PDF {
	private String name, dest, textFile;
	private File file;
	private Scanner in;
	
	private Document doc;
	private PdfWriter writer;
	private PdfDocument pdfDoc;
	
	PDF(String name, String dest, String txtFile) throws FileNotFoundException {
		setName(name);
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
			doc.close();
		}
	}
	
	// Setter methods
	private void setName(String name) {
		this.name = name + ".pdf";
		
		if(!dest.isEmpty()) {
			dest = dest + "/" + name;
		}
	}
	
	private void setDest(String dest) {
		if(name.isEmpty()) {
			this.dest = dest;
		} else {
			this.dest = dest + "/" + name;
		}
	}
	
	private void setTextFile(String txtFile) {
		textFile = txtFile;
		file = new File(txtFile);
	}
	
	// Getter methods
	private String getName() {
		return name;
	}
	
	private String getDest() {
		return dest;
	}
	
	private String getTextFile(String txtFile) {
		return textFile;
	}
	
}
