import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Base {
	
	public static void main(String[] args) {
		try {
			new Base();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	LinkedList<EventItem> historyList = new LinkedList<EventItem>();
	static int highestID =0;
	Base() throws InterruptedException {
		
		// Splash Screen Stuff
		// ------------------------------------------------------------------------
	/*	JFrame splashFrame = new JFrame();
		JPanel splashPanel = new JPanel();
		JLabel topSecret = new JLabel("Top Secret");
		JLabel authUse = new JLabel("Autherized Use Only");
		
		topSecret.setFont(new Font("Impact", Font.BOLD, 60));
		authUse.setFont(new Font("Impact", Font.PLAIN, 40));
		splashPanel.add(topSecret);
		splashPanel.add(authUse);
		splashFrame.add(splashPanel);
		
		splashFrame.setVisible(true);
		splashFrame.setLocationRelativeTo(null);
		splashFrame.setResizable(false);
		splashFrame.setSize(400, 200);
		splashFrame.setTitle("Splash Screen");
		Thread.sleep(2000);
		splashFrame.setVisible(false);*/
		
		//TODO reenable the splash screen	
		
		// End Splash Screen Stuff
		// ------------------------------------------------------------------------
		
		//TEST=-----------------------------------------------
		for (int i = 0; i < 10; i++) {
			historyList.add(new EventItem("String" + i, new Alien("name" + i, null, null, null, null, null)));
		}
		
		// TODO Optional Login Screen Here
		
		JFrame homeFrame = new JFrame();
		JPanel homePanel = new JPanel();
		JButton search = new JButton("Search");
		JButton history = new JButton("History");
		JButton addNew = new JButton("Add New Item");
		JPanel resultsPanel = new JPanel();
		JPanel numberPane = new JPanel();
		JPanel namePane = new JPanel();
		JPanel hostilityPane = new JPanel();
		JPanel worldPane = new JPanel();
		homePanel.add(search);
		homePanel.add(history);
		homePanel.add(addNew);
		homeFrame.add(homePanel);
		
		resultsPanel.add(numberPane);
		resultsPanel.add(namePane);
		resultsPanel.add(hostilityPane);
		resultsPanel.add(worldPane);
		//TODO finish this thing where the search results show up these boxes	
		
		homeFrame.setVisible(true);
		homeFrame.setLocationRelativeTo(null);
		homeFrame.setResizable(true);
		homeFrame.setSize(600, 400);
		homeFrame.setTitle("Home Screen");
		homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		history.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homeFrame.remove(homePanel);
				homeFrame.add(history());
				//TODO figure out the back/home button system
			}
		});
		addNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNew();
			}
		});
		
	}
	
	private void addNew() {
		openItemWindow();
	}
	
	private void search() {
		Alien alien = new Alien("none", "none", "none", "none", "none", Hostility.NONE);
		JFrame itemFrame = new JFrame();
		JPanel itemPanel = new JPanel(new GridLayout(3, 3));
		JPanel topPanel = new JPanel(new GridLayout(2,1));
		JPanel searchPanel = new JPanel(); 
		JButton searchButton = new JButton("Search"); //TODO Make this button do stuff
		JLabel name = new JLabel("Name:");
		JButton hostility = new JButton("Hostility Level: " + alien.getHostility());
		JLabel origPlanet = new JLabel("Original Planet:");
		JLabel location = new JLabel("Location:");
		JLabel notes = new JLabel("Notes:");
		
		hostility.setBackground(colourForHostility(alien.getHostility()));
		hostility.setOpaque(true);
		
		
		JTextField nameTF = new JTextField("Name");
		JTextField origPlanetTF = new JTextField("Original Planet");
		JTextField locationTF = new JTextField("Location");
		JTextField notesTF = new JTextField("Notes");
		
		itemFrame.setVisible(true);
		itemFrame.setLocationRelativeTo(null);
		itemFrame.setSize(new Dimension(400, 300));
		itemFrame.setTitle("Item Editing and Creation Window");
		
		searchPanel.add(searchButton);
		itemPanel.add(name);
		itemPanel.add(nameTF);
		itemPanel.add(hostility);
		itemPanel.add(origPlanet);
		itemPanel.add(origPlanetTF);
		itemPanel.add(notes);
		itemPanel.add(location);
		itemPanel.add(locationTF);
		itemPanel.add(notesTF);
		
		topPanel.add(itemPanel);
		topPanel.add(searchPanel);
		itemFrame.add(topPanel);
		
		
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		hostility.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alien.setHostility(alien.incrementedHostility());
			}
		});
	}
	

	public enum Hostility {
		NONE(0), LOW(1), MEDIUM(2), HIGH(3), EXTREME(4);
		private int value;
		
		private Hostility(int value) {
			this.value = value;
		}
	};
	
	private Color colourForHostility(Hostility other){
		switch(other) {
			case NONE: return Color.GREEN;
			case LOW: return Color.BLUE;
			case MEDIUM: return Color.YELLOW;
			case HIGH: return Color.ORANGE; 
			case EXTREME: return Color.RED;
		}
		return Color.WHITE;
		
	}
	
	private void openItemWindow(Alien alien) {
		JFrame itemFrame = new JFrame();
		JPanel itemPanel = new JPanel(new GridLayout(3, 3));
		JPanel topPanel = new JPanel(new GridLayout(2,1));
		JPanel savePanel = new JPanel(); 
		JButton saveButton = new JButton("Save"); //TODO Make this button do stuff
		JLabel name = new JLabel("Name:");
		JButton hostility = new JButton("Hostility Level: " + alien.getHostility());
		JLabel origPlanet = new JLabel("Original Planet:");
		JLabel location = new JLabel("Location:");
		JLabel notes = new JLabel("Notes:");
		
		hostility.setBackground(colourForHostility(alien.getHostility()));
		hostility.setOpaque(true);
		
		
		JTextField nameTF = new JTextField("Name");
		JTextField origPlanetTF = new JTextField("Original Planet");
		JTextField locationTF = new JTextField("Location");
		JTextField notesTF = new JTextField("Notes");
		
		itemFrame.setVisible(true);
		itemFrame.setLocationRelativeTo(null);
		itemFrame.setSize(new Dimension(500, 300));
		itemFrame.setTitle("Item Editing and Creation Window");
		
		savePanel.add(saveButton);
		itemPanel.add(name);
		itemPanel.add(nameTF);
		itemPanel.add(hostility);
		itemPanel.add(origPlanet);
		itemPanel.add(origPlanetTF);
		itemPanel.add(notes);
		itemPanel.add(location);
		itemPanel.add(locationTF);
		itemPanel.add(notesTF);
		
		topPanel.add(itemPanel);
		topPanel.add(savePanel);
		itemFrame.add(topPanel);
		
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO make this button do stuff
			}
		});
		hostility.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alien.setHostility(alien.incrementedHostility());
				hostility.setBackground(colourForHostility(alien.getHostility()));
				hostility.setText("Hostility Level: " + alien.getHostility());
				itemFrame.validate();
				itemFrame.repaint();
			}
		});
		
	}
	
	private void openItemWindow() {
		Alien alien = new Alien("none", "none", "none", "none", "none", Hostility.NONE);
		openItemWindow(alien);
	}
	
	public JScrollPane history() { //TODO Fix this
		JScrollPane historyPanel;
		JTable historyTable;
		
		//MyDateFormat mdf = new MyDateFormat();
		
		String columnNames[] = {
				"Column1", "Column2", "Column3" };
		String dataValues[][] = new String[3][historyList.size()];
		for (int i = 0; i < historyList.size(); i++) {
			dataValues[0][i] = historyList.get(i).item.getName();
			dataValues[1][i] = historyList.get(i).action;
			//	dataValues[2][i] = mdf.format(historyList.get(i).now);
		}
		historyTable = new JTable(dataValues, columnNames);
		historyPanel = new JScrollPane(historyTable);
		
		return historyPanel;
	}
	
}
