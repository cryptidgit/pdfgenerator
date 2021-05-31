package mypack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;

public class Window implements ActionListener {
	JMenuBar bar;
	JMenu file;
	JMenuItem newfile;
	JFrame frame;
	JLabel noselect;
	JComboBox<Integer> fontSizes;
	JPanel fontSizeBox;
	
	String fileName, windowTitle;
	
	Window(String title, int width, int length) {
		windowTitle = title;
		frame = new JFrame(windowTitle);  // Default screen on opening
		// Set up window frame and behavior
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, length);
		
		// Create menu bar and items
		bar = new JMenuBar();
		file = new JMenu("File");
		
		newfile = new JMenuItem("New File");
		newfile.addActionListener(this);
		file.add(newfile);
		
		bar.add(file);
		frame.setJMenuBar(bar);
		
		// Create "No File Selected" text
		noselect = new JLabel("No File Selected");
		noselect.setHorizontalAlignment(JLabel.CENTER);
		
		frame.add(noselect);
		
		// Make changes visible
		frame.setVisible(true);
		
		// Create font size dropdown menu
		fontSizeBox = new JPanel(new FlowLayout());
		
		JLabel fontSizeName = new JLabel("Font Size");
		fontSizes = new JComboBox<Integer>();
		fontSizes.setEditable(true);
		fontSizes.addActionListener(this);
		
		for(int i = 2; i <= 96; i += 2) {
			fontSizes.addItem(i);
		}
		
		fontSizeBox.add(fontSizeName);
		fontSizeBox.add(fontSizes);		
		
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
				fileName = JOptionPane.showInputDialog("Enter name of PDF file");
				frame.setTitle(windowTitle + "- " + fileName + ".pdf");
				showOptions();
			}
		}
		
		else if(e.getSource() == fontSizes) {
			Object val = fontSizes.getSelectedItem();
			
			if(!(val instanceof Integer)) {
				fontSizes.setSelectedItem(4);
			} else {
				int i = (Integer) val;
				
				if(i < 1) {
					fontSizes.setSelectedItem(1);
				} else if(i > 400) {
					fontSizes.setSelectedItem(400);
				}
			}
		}
	}
	
	public void showOptions() {
		// Remove no file selected message
		noselect.setVisible(false);
		
		frame.add(fontSizeBox);
		
		// Add customization options
		frame.setVisible(true);
	}

}
