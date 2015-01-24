package io.github.Skepter;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class PluginInformation extends JFrame {

	private static final long serialVersionUID = -516627115358436613L;
	private JPanel contentPane;
	private JTextField pluginName;
	private JTextField pluginDescription;
	private JTextField pluginVersion;
	private JTextField pluginWebsite;
	private JTextField pluginAuthor;

	/** Create the frame. */
	public PluginInformation() {
		setTitle("Plugin settings");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Plugin settings", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		contentPane.add(panel, BorderLayout.CENTER);

		JLabel nameLabel = new JLabel("Plugin name:");

		pluginName = new JTextField();
		pluginName.setColumns(10);

		JLabel descriptionLabel = new JLabel("Plugin description:");

		pluginDescription = new JTextField();
		pluginDescription.setColumns(10);

		JLabel versionLabel = new JLabel("Plugin version:");

		pluginVersion = new JTextField();
		pluginVersion.setColumns(10);

		JLabel websiteLabel = new JLabel("Website:");

		pluginWebsite = new JTextField();
		pluginWebsite.setColumns(10);

		JLabel authorLabel = new JLabel("Author:");

		pluginAuthor = new JTextField();
		pluginAuthor.setColumns(10);

		JButton saveButton = new JButton("Save");
		saveButton.setIcon(new ImageIcon(PluginInformation.class.getResource("/io/github/Skepter/icons/Apply.png")));
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pluginName.getText().equals("") || pluginDescription.getText().equals("") || pluginVersion.getText().equals("") || pluginWebsite.getText().equals("") || pluginAuthor.getText().equals("")) {
					return;
				} else {
					new MainProgrammingScreen(pluginName.getText(), pluginDescription.getText(), pluginVersion.getText(), pluginWebsite.getText(), pluginAuthor.getText());
					dispose();
				}
			}
		});

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new InitDialog();
			}
		});
		cancelButton.setIcon(new ImageIcon(PluginInformation.class.getResource("/io/github/Skepter/icons/Cancel.png")));

		JButton helpButton = new JButton("Help");
		helpButton.setIcon(new ImageIcon(PluginInformation.class.getResource("/io/github/Skepter/icons/Help symbol.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup().addContainerGap().addGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(descriptionLabel).addComponent(versionLabel).addComponent(websiteLabel).addComponent(authorLabel).addComponent(nameLabel)).addGap(18).addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(pluginName, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE).addComponent(pluginVersion, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE).addComponent(pluginDescription, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE).addComponent(pluginWebsite, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE).addComponent(pluginAuthor, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))).addGroup(gl_panel.createSequentialGroup().addComponent(helpButton).addPreferredGap(ComponentPlacement.RELATED, 147, Short.MAX_VALUE).addComponent(cancelButton).addGap(18).addComponent(saveButton))).addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(pluginName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(nameLabel)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(descriptionLabel).addComponent(pluginDescription, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(versionLabel).addComponent(pluginVersion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(websiteLabel).addComponent(pluginWebsite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(authorLabel).addComponent(pluginAuthor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE).addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(saveButton).addComponent(cancelButton).addComponent(helpButton)).addContainerGap()));
		panel.setLayout(gl_panel);
	}
}
