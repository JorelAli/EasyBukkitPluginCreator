package io.github.Skepter.Panels;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class CommandPanel extends JPanel {

	private static final long serialVersionUID = -7539897008307860341L;
	private JTextField commandName;

	/** Create the panel. */
	public CommandPanel(String command) {

		JButton deleteButton = new JButton("Delete");
		deleteButton.setIcon(new ImageIcon(CommandPanel.class.getResource("/io/github/Skepter/icons/Delete.png")));

		JLabel lblNewLabel = new JLabel("Command name:");

		commandName = new JTextField(command);
		commandName.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblNewLabel).addGap(18).addComponent(commandName, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(deleteButton).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(deleteButton).addComponent(lblNewLabel).addComponent(commandName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addContainerGap(264, Short.MAX_VALUE)));
		setLayout(groupLayout);

		//Change to use one of the grid layouts because 
		//the format that this window will be used in
		//conflicts due to the GroupLayout not being able
		//to dynamically add other components without replacing them

	}
}
