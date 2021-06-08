package mypack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.*;

import javax.swing.*;
import javax.swing.colorchooser.*;

public class Window implements ActionListener {
	private JMenuBar bar;
	private JMenu file;
	private JMenuItem newfile, renameFile;
	
	private JFrame frame;
	private JLabel noselect, colorPreview, fontTypeName, fontSizeName;
	
	private JComboBox<Integer> fontSizes;
	private JComboBox<String> fontTypes;
	private JButton colorChooser, generateFile;
	private JPanel fontBox;
	private JColorChooser chooser;
	
	private String fileName, windowTitle, textFileName;
	private Color fontColor;
	
	private PDF pdf;
	
	
	Window(String title, int width, int length) {
		windowTitle = title;
		frame = new JFrame(windowTitle);  // Default screen on opening
		
		// Set up window frame and behavior
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, length);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		// Create menu bar and items
		createMenu();
		
		// Create "No File Selected" text and initialize fileName
		noselect = new JLabel("No File Selected");
		noselect.setHorizontalAlignment(JLabel.CENTER);
		fileName = "";
		
		frame.add(noselect);
		
		// Make changes visible
		frame.setVisible(true);
		
		// Create font size dropdown menu
		addFontSize();
		
		// Create font types dropdown menu		
		addFontTypes();
		
		// Font Color Picker
		addColorPicker();
		
		// Add Generate File Button
		createGenerate();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newfile) {
			JFileChooser filechoose = new JFileChooser();
			filechoose.showOpenDialog(null);
			
			int filelength = filechoose.getSelectedFile().getName().length();
			
			// Only allow .txt files
			if(!filechoose.getSelectedFile().getName().substring(filelength - 3).equals("txt")) {
				JOptionPane.showMessageDialog(frame, "File must end in .txt", "Error", JOptionPane.ERROR_MESSAGE);
			} else if(filechoose.getSelectedFile().getName().substring(filelength - 3).equals("txt")) {
				// Get name of PDF file
				textFileName = filechoose.getSelectedFile().getAbsolutePath();
				fileName = JOptionPane.showInputDialog("Enter name of PDF file");
				renameFile(fileName);
				showOptions();
			}
		}
		
		else if(e.getSource() == renameFile) {
			if(fileName.isEmpty()) {
				JOptionPane.showMessageDialog(null, "No File Selected to Rename", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				fileName = JOptionPane.showInputDialog("Enter new name of PDF file");
				renameFile(fileName);
			}
		}
		
		else if(e.getSource() == fontSizes) {
			Object val = fontSizes.getSelectedItem();
			
			// Default font size is 4 pt
			if(!(val instanceof Integer)) {
				fontSizes.setSelectedItem(4);
			} else {
				int i = (Integer) val;
				
				// Range of font size 1 to 400 pt
				if(i < 1) {
					fontSizes.setSelectedItem(1);
				} else if(i > 400) {
					fontSizes.setSelectedItem(400);
				}
			}
		}
		
		else if(e.getSource() == colorChooser) {
			// Pull up color chooser
			chooser = new JColorChooser();
			
			AbstractColorChooserPanel[] panels = chooser.getChooserPanels();
			
			// Pull up RGB Color Chooser
			for(AbstractColorChooserPanel panel : panels) {
				System.out.println(panel.getDisplayName());
			    if (panel.getDisplayName().equals("RGB"))
			        JOptionPane.showMessageDialog(null, panel);
			}
			
			// Set font color and change color of preview text
			fontColor = chooser.getColor();
			colorPreview.setForeground(new Color(fontColor.getRed(), fontColor.getGreen(), fontColor.getBlue()));
		}
		
		else if(e.getSource() == generateFile) {
			JFileChooser chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			chooser.setSelectedFile(new File(fileName + ".pdf"));
			
			int option = chooser.showSaveDialog(frame);
			
			if(option == JFileChooser.APPROVE_OPTION) {
				try {
					pdf = new PDF(chooser.getSelectedFile().getAbsolutePath(), textFileName);
					pdf.makePDF();
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "File Not Found", "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				
			}
		}
	}
	
	private void addFontSize() {
		fontBox = new JPanel(new FlowLayout());
		
		fontSizeName = new JLabel("Font Size");
		fontSizes = new JComboBox<Integer>();
		fontSizes.setEditable(true);
		fontSizes.addActionListener(this);
		
		for(int i = 2; i <= 96; i += 2) {
			fontSizes.addItem(i);
		}
		
		fontBox.add(fontSizeName);
		fontBox.add(fontSizes);		
	}
	
	private void addColorPicker() {
		colorChooser = new JButton("Choose Font Color");
		colorChooser.addActionListener(this);
		colorPreview = new JLabel("Font Color Preview");
		
		fontBox.add(colorChooser);
		fontBox.add(colorPreview);
	}
	
	private void addFontTypes() {
		fontTypeName = new JLabel("Font");
		fontTypes = new JComboBox<String>();
		fontTypes.addActionListener(this);
		
		fontTypes.addItem("Courier");
		fontTypes.addItem("Helvetica");
		fontTypes.addItem("Symbol");
		fontTypes.addItem("Times New Roman");
		fontTypes.addItem("Zapf Dingbats");
		
		fontBox.add(fontTypeName);
		fontBox.add(fontTypes);
	}
	
	private void createMenu() {
		bar = new JMenuBar();
		file = new JMenu("File");
		
		newfile = new JMenuItem("New File");
		newfile.addActionListener(this);
		file.add(newfile);
		
		renameFile = new JMenuItem("Rename File");
		renameFile.addActionListener(this);
		file.add(renameFile);
		
		bar.add(file);
		frame.setJMenuBar(bar);
	}
	
	private void createGenerate() {
		generateFile = new JButton("Generate");
		generateFile.setBounds(100, 100, 200, 200);
		generateFile.addActionListener(this);
		
		fontBox.add(generateFile);
	}
	
	private void showOptions() {
		// Remove no file selected message
		noselect.setVisible(false);
		
		frame.add(fontBox);
		
		// Add customization options
		frame.setVisible(true);
	}
	
	private void renameFile(String newName) {
		frame.setTitle(windowTitle + "- " + newName + ".pdf");
	}

}
