package mypack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Window implements ActionListener {
	JMenuItem newfile;
	JFrame nofile, frame;
	
	Window(String title, int width, int length) {
		nofile = new JFrame(title); // Default screen on opening
		frame = new JFrame(title); // Customization screen
		
		// Set up window frame and behavior
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, length);
		nofile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nofile.setSize(width, length);
		
		// Create menu bar and items
		JMenuBar bar = new JMenuBar();
		JMenu file = new JMenu("File");
		
		newfile = new JMenuItem("New File");
		newfile.addActionListener(this);
		file.add(newfile);
		
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newfile) {
			JFileChooser filechoose = new JFileChooser();
			filechoose.showOpenDialog(null);
		}
	}

}
