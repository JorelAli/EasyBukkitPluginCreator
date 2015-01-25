package io.github.Skepter.Panels;

import io.github.Skepter.Data.Command;
import io.github.Skepter.Lists.ActionComboBox;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

public class CommandPanel extends JPanel {

	private static final long serialVersionUID = -7539897008307860341L;
	private JTextField commandName;

	/** Create the panel. */
	public CommandPanel(Command command) {

		JButton deleteButton = new JButton("Delete");
		deleteButton.setIcon(new ImageIcon(CommandPanel.class.getResource("/io/github/Skepter/icons/Delete.png")));

		JLabel commandNameLabel = new JLabel("Command syntax:");

		commandName = new JTextField(command.getSyntax());
		commandName.setColumns(10);
		setLayout(new MigLayout("", "[80px,grow][239px,grow][83px]", "[25px][][][]"));
		add(commandNameLabel, "cell 0 0,alignx left,aligny center");
		add(commandName, "cell 1 0,growx,aligny center");
		add(deleteButton, "cell 2 0,alignx left,aligny top");
		
		JLabel actionsLabel = new JLabel("Actions:");
		actionsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(actionsLabel, "cell 0 1");
		
		ActionComboBox actionBox = new ActionComboBox();
		add(actionBox, "cell 0 2,growx");
		
		JComboBox<String> argumentBox = new JComboBox<String>();
		add(argumentBox, "cell 1 2,growx");
		
		JButton removeButton = new JButton("Remove action");
		removeButton.setIcon(new ImageIcon(CommandPanel.class.getResource("/io/github/Skepter/icons/Remove.png")));
		add(removeButton, "cell 2 2,alignx right,aligny center");
		
		JButton addButton = new JButton("Add a new action");
		addButton.setIcon(new ImageIcon(CommandPanel.class.getResource("/io/github/Skepter/icons/New.png")));
		add(addButton, "cell 0 3");


	}
}
