package io.github.Skepter;

import io.github.Skepter.Panels.GradientPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.UIManager;

import com.alee.laf.WebLookAndFeel;

public class SplashScreen extends JDialog {

	private static final long serialVersionUID = 5866751799338096044L;

	private static final boolean showSplash = false;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(WebLookAndFeel.class.getCanonicalName());
			WebLookAndFeel.initializeManagers();
			SplashScreen dialog = new SplashScreen();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			initUI(dialog);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static JProgressBar progressBar;

	public SplashScreen() {
		setUndecorated(true);
		setBounds(100, 100, 450, 200);
		setLocationRelativeTo(null);

		JPanel panel = new GradientPanel(SystemColor.textHighlight.brighter(), SystemColor.textHighlight.darker());
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(panel, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE));

		JLabel icon = new JLabel("");
		JLabel text = new JLabel("<html><b>EasyBukkitPluginCreator</b><br>\r\nCreated by Skepter<br><br>\r\n[Website link]</html>");
		text.setForeground(new Color(255, 255, 255));
		text.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text.setVerticalAlignment(SwingConstants.TOP);

		progressBar = new JProgressBar();
		progressBar.setIndeterminate(true);
		progressBar.setStringPainted(true);
		progressBar.setString("Loading, please wait...");

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel.createSequentialGroup().addGap(26).addComponent(icon, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE).addGap(18).addComponent(text, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE).addGap(22)).addComponent(progressBar, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup().addGap(27).addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false).addComponent(text, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(icon, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE).addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)));
		panel.setLayout(gl_panel);

		BufferedImage img = null;
		try {
			img = ImageIO.read(SplashScreen.class.getResource("/io/github/Skepter/icons/Bukkit Logo.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		icon.setIcon(imageIcon);
		getContentPane().setLayout(groupLayout);
	}

	private static void initUI(final SplashScreen dialog) throws MalformedURLException {
		SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
			@Override
			protected Void doInBackground() throws Exception {
				if (showSplash) {
					for (int i = 0; i < 100; i++) {
						Thread.sleep(50);
						publish(i);
					}
				}
				return null;
			}

			@Override
			protected void process(List<Integer> chunks) {
				progressBar.setValue(chunks.get(chunks.size() - 1));
			}

			@Override
			protected void done() {
				dialog.dispose();
				new InitDialog();
			}
		};
		worker.execute();
	}
}
