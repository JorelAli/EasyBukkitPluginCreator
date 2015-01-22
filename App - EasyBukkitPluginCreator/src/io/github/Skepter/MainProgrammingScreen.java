package io.github.Skepter;

import io.github.Skepter.Panels.CommandPanel;
import io.github.Skepter.Panels.WelcomePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainProgrammingScreen extends JFrame {

	public static void main(String[] args) {
		new MainProgrammingScreen();
	}

	private static final long serialVersionUID = 6082742900544647505L;
	private JPanel contentPane;
	private JScrollPane rightPane;

	private static JList<String> commands;
	private static Map<String, String> commandMap;

	/** Create the frame. */
	public MainProgrammingScreen() {

		/* Variable initialisation */

		commandMap = new HashMap<String, String>();

		/* Everything else */

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		/* Menu bar */

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		JMenu addFeatureMenu = new JMenu("Add Feature");
		menuBar.add(addFeatureMenu);

		JMenuItem addCommandButton = new JMenuItem("Add new command");
		addCommandButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AddCommandDialog();

				//add the command to the main GUI ONLY IF THEY CLICK OKAY!!!!!
				//open a new GUi asking for commandName
				//+ description
				//+ permissions?
			}
		});
		addFeatureMenu.add(addCommandButton);

		JMenuItem addEventButton = new JMenuItem("Add new event");
		addFeatureMenu.add(addEventButton);

		JMenu advancedMenu = new JMenu("Advanced");
		menuBar.add(advancedMenu);

		JMenuItem seePluginButton = new JMenuItem("Show generated plugin.yml file");
		advancedMenu.add(seePluginButton);

		JMenuItem editConfigButton = new JMenuItem("Modify config.yml file");
		//Toggle enabled or disabled based on if the plugin requires a config.yml file or not
		advancedMenu.add(editConfigButton);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		/* Start of main GUI screen */
		
		rightPane = new JScrollPane(new WelcomePanel());

		commands = new JList<String>(new DefaultListModel<String>());
		commands.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				rightPane.setViewportView(new CommandPanel(commands.getSelectedValue()));
			}
		});

		JScrollPane pane = new JScrollPane(commands);

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pane, rightPane);
		splitPane.setContinuousLayout(true);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE));
		contentPane.setLayout(gl_contentPane);
	}

	public static void addCommand(String command, String description) {
		DefaultListModel<String> model = (DefaultListModel<String>) commands.getModel();
		model.addElement(command);
		commandMap.put(command, description);
	}
}
