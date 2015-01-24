package io.github.Skepter;

import io.github.Skepter.Panels.GradientPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InitDialog extends JFrame {

	private static final long serialVersionUID = -3148013963408309540L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public InitDialog() {
		setVisible(true);
		setTitle("EasyBukkitPluginCreator - Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 220);
		contentPane = new GradientPanel(SystemColor.textHighlight.brighter(), SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel welcomeText = new JLabel("<html><center>Welcome to the EasyBukkitPluginCreator</b><br>Click a button to get started</center></html>");
		welcomeText.setForeground(new Color(255, 255, 255));
		welcomeText.setFont(new Font("Tahoma", Font.PLAIN, 18));
		welcomeText.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnNewButton = new JButton("Create a new plugin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new PluginInformation();
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setIcon(new ImageIcon(InitDialog.class.getResource("/io/github/Skepter/icons/Create.png")));
		
		JButton btnHowToUse = new JButton("How to use");
		btnHowToUse.setIcon(new ImageIcon(InitDialog.class.getResource("/io/github/Skepter/icons/Help symbol.png")));
		btnHowToUse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnInformation = new JButton("Information");
		btnInformation.setIcon(new ImageIcon(InitDialog.class.getResource("/io/github/Skepter/icons/Info.png")));
		btnInformation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(welcomeText, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(btnHowToUse, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(250, Short.MAX_VALUE)
					.addComponent(btnInformation, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(welcomeText, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnHowToUse, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnInformation, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
