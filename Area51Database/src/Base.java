import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class Base {

	public static void main(String[] args) {
		try {
			new Base();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	Base() throws InterruptedException {
		
		// Splash Screen Stuff
		//------------------------------------------------------------------------
		JFrame splashFrame = new JFrame();
		JPanel splashPanel = new JPanel();
		JLabel topSecret = new JLabel("Top Secret");
		JLabel authUse = new JLabel("Autherized Use Only");
		
		topSecret.setFont(new Font("Impact",Font.BOLD, 60));
		authUse.setFont(new Font("Impact",Font.PLAIN, 40));
		splashPanel.add(topSecret);
		splashPanel.add(authUse);
		splashFrame.add(splashPanel);
		
		splashFrame.setVisible(true);
		splashFrame.setLocationRelativeTo(null);
		splashFrame.setResizable(false);
		splashFrame.setSize(400,200);
		splashFrame.setTitle("Splash Screen");
		Thread.sleep(2000);
		splashFrame.setVisible(false);
		
		//End Splash Screen Stuff
		//------------------------------------------------------------------------
		
		JFrame homeFrame = new JFrame();
		JPanel homePanel = new JPanel();
		JMenu homeMenu = new JMenu();
		JMenuItem homeMenu_fileItme = new JMenuItem(); 
		//TODO finish the home screen and home screen menu
		
		

	}

}
