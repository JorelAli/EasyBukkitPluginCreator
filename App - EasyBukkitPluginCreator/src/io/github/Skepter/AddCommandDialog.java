package io.github.Skepter;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;

/** A near perfect example of using proper command action listeners effectively */
public class AddCommandDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = 3822253547721457858L;
	private final JPanel contentPanel = new JPanel();
	private JTextField commandName;
	private JTextField commandDescription;
	private JTextField commandSyntax;
	private JComboBox<String> argumentList;

	/** Create the dialog. */
	public AddCommandDialog() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setTitle("Add a new command");
		setBounds(100, 100, 528, 261);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Command settings", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(panel, GroupLayout.PREFERRED_SIZE, 510, Short.MAX_VALUE));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel.createSequentialGroup().addComponent(panel, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE).addContainerGap(85, Short.MAX_VALUE)));

		JLabel nameLabel = new JLabel("Command name:");

		commandName = new JTextField();
		commandName.setColumns(10);

		JLabel descriptionLabel = new JLabel("Short description of the command:");

		commandDescription = new JTextField();
		commandDescription.setColumns(10);

		commandSyntax = new JTextField();
		commandSyntax.setColumns(10);

		JLabel syntaxLabel = new JLabel("Command format:");

		argumentList = new JComboBox<String>();
		argumentList.addItem("Add player name");
		argumentList.addItem("Add custom message");
		argumentList.addItem("Add option");
		argumentList.addItem("Add world name");

		JButton addToFormatButton = new JButton("Add to command format");
		addToFormatButton.setActionCommand("AddCommand");
		addToFormatButton.addActionListener(this);

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup().addContainerGap().addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(nameLabel).addComponent(descriptionLabel).addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false).addComponent(argumentList, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(syntaxLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))).addPreferredGap(ComponentPlacement.RELATED).addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(commandSyntax, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE).addComponent(commandName, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE).addComponent(commandDescription, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE).addComponent(addToFormatButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)).addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(commandName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(nameLabel)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(commandDescription, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(descriptionLabel)).addGap(13).addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(commandSyntax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(syntaxLabel)).addPreferredGap(ComponentPlacement.RELATED).addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(argumentList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(addToFormatButton)).addContainerGap(26, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		contentPanel.setLayout(gl_contentPanel);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("Add");
		okButton.setActionCommand("Add");
		okButton.addActionListener(this);
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		switch (event.getActionCommand()) {
		case "AddCommand":
			String argumentValue = null;
			switch (argumentList.getSelectedIndex()) {
			case 0:
				argumentValue = "{PLAYER}";
				break;
			case 1:
				argumentValue = "{MESSAGE}";
				break;
			case 2:
				argumentValue = "{OPTION}";
				break;
			case 3:
				argumentValue = "{WORLD}";
				break;
			}
			commandSyntax.setText(commandSyntax.getText() + " " + argumentValue);
			return;
		case "Add":
			MainProgrammingScreen.addCommand(commandName.getText(), commandDescription.getText(), commandSyntax.getText());
			break;
		case "Cancel":
			//Can happily continue since it will dispose
			break;
		}
		dispose();
	}
}
