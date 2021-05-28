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
	
	Window(String title, int width, int length) {
		frame = new JFrame(title);  // Default screen on opening
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
		
		frame.add(fontSizeBox);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newfile) {
			JFileChooser filechoose = new JFileChooser();
			filechoose.showOpenDialog(null);
			
			int filelength = filechoose.getSelectedFile().getName().length();
			
			if(!filechoose.getSelectedFile().getName().substring(filelength - 3).equals("txt")) {
				JOptionPane.showMessageDialog(frame, "File must end in .txt", "Error", JOptionPane.ERROR_MESSAGE);
			} else if(filechoose.getSelectedFile().getName().substring(filelength - 3).equals("txt")) {
				showOptions();
			}
		}
		
		else if(e.getSource() == fontSizes) {
			Object val = fontSizes.getSelectedItem();
			
			if(!(val instanceof Integer)) {
				fontSizes.setSelectedItem(4);
			}
		}
	}
	
	public void showOptions() {
		// Remove no file selected message
		noselect.setVisible(false);
		
		// Add customization options
		frame.setVisible(true);
	}

}
