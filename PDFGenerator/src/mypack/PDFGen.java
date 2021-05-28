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
		JFrame nofile = new JFrame("PDF Generator"); // Default screen on opening
		JFrame frame = new JFrame("PDF Generator");
		
		// Set up window frame and behavior
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		nofile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nofile.setSize(500, 500);
		
		// Create menu bar and items
		JMenuBar bar = new JMenuBar();
		JMenu file = new JMenu("File");
		
		JMenuItem f1 = new JMenuItem("New File");
		file.add(f1);
		
		bar.add(file);
		frame.setJMenuBar(bar);
		nofile.setJMenuBar(bar);
		
		// Create "No File Selected" text
		JLabel noselect = new JLabel("No File Selected");
		noselect.setHorizontalAlignment(JLabel.CENTER);
		
		nofile.add(noselect);
		
		// Make changes visible
		nofile.setVisible(true);
	}
}
