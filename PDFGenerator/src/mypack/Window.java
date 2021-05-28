package mypack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Window implements ActionListener {
	JMenuBar bar;
	JMenu file;
	JMenuItem newfile;
	JFrame frame;
	JLabel noselect;
	JComboBox<Integer> fontSizes;
	
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
		file.add(frame);
		
		bar.add(file);
		frame.setJMenuBar(bar);
		
		// Create "No File Selected" text
		noselect = new JLabel("No File Selected");
		noselect.setHorizontalAlignment(JLabel.CENTER);
		
		frame.add(noselect);
		
		// Make changes visible
		frame.setVisible(true);
		
		// Create font size dropdown menu
		fontSizes = new JComboBox<Integer>();
		
		for(int i = 4; i < 96; i += 2) {
			fontSizes.addItem(i);
		}
		
		
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
	}
	
	public void showOptions() {
		
	}

}
