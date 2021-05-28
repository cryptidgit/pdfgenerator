package mypack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Window implements ActionListener {
	Window(String title, int width, int length) {
		JFrame nofile = new JFrame(title); // Default screen on opening
		JFrame frame = new JFrame(title);
		
		// Set up window frame and behavior
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, length);
		nofile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nofile.setSize(width, length);
		
		// Create menu bar and items
		JMenuBar bar = new JMenuBar();
		JMenu file = new JMenu("File");
		
		JMenuItem f1 = new JMenuItem("New File");
		f1.addActionListener(this);
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
