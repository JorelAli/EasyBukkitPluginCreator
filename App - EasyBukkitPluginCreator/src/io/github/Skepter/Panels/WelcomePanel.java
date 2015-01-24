package io.github.Skepter.Panels;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class WelcomePanel extends JPanel {

	private static final long serialVersionUID = 4112252746239799449L;

	public WelcomePanel() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel welcomeText = new JLabel("<html><center>Welcome :D</center></html>");
		add(welcomeText, BorderLayout.CENTER);
		welcomeText.setHorizontalAlignment(SwingConstants.CENTER);
		

	}

}
