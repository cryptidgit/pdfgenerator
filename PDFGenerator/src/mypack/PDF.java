package mypack;

import java.io.FileNotFoundException;

import com.itextpdf.*;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PDF {
	private String name, dest, textFile;
	
	private Document doc;
	private PdfWriter writer;
	private PdfDocument pdfDoc;
	
	
	PDF(String name, String dest) throws FileNotFoundException {
		setName(name);
		setDest(dest);
		
		writer = new PdfWriter(dest);
		pdfDoc = new PdfDocument(writer);
		doc = new Document(pdfDoc);
	}
	
	private void setName(String name) {
		this.name = name + ".pdf";
		
		if(!dest.isEmpty()) {
			dest = dest + "/" + name;
		}
	}
	
	private String getName() {
		return name;
	}
	
	private void setDest(String dest) {
		if(name.isEmpty()) {
			this.dest = dest;
		} else {
			this.dest = dest + "/" + name;
		}
	}
	
	private String getDest() {
		return dest;
	}
	
}
