package mypack;

/*
 * PDF Generator Application
 * Generates PDFs from .txt files 
 * 
 */

import javax.swing.*;
import java.awt.*;
import com.itextpdf.*;
import java.util.*;

class PDFGen {
	public static void main(String[] args) {
		createWindow();
	}
	
	// Generate Application Window
	private static void createWindow() {
		JFrame frame = new JFrame("PDF Generator");
		
		// Set up window frame and behavior
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		
		// Create menu bar and items
		JMenuBar bar = new JMenuBar();
		JMenu file = new JMenu("File");
		
		JMenuItem f1 = new JMenuItem("New PDF");
		JMenuItem f2 = new JMenuItem("Open Recent PDF");
		
		file.add(f1);
		file.add(f2);
		
		bar.add(file);
		frame.setJMenuBar(bar);
		
		// Make changes visible
		frame.setVisible(true);
	}
}
