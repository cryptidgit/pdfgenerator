/*
 * PDF Generator Application
 * Generates PDFs from .txt files 
 * 
 */

import javax.swing.*;
import com.itextpdf.*;
import java.util.*;

class PDFGenerator {
	public static void main(String[] args) {
		createWindow();
	}
	
	// Generate Application Window
	private static void createWindow() {
		JFrame frame = new JFrame("PDF Generator");
		
		// Set window size and close operation
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		
		// Add Buttons
		JButton file = new JButton("Choose File");
		JPanel p = new JPanel();
		p.add(file);
	}
}
