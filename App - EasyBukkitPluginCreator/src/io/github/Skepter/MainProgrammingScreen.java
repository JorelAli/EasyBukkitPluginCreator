package io.github.Skepter;

import io.github.Skepter.Builder.PluginYAMLBuilder;
import io.github.Skepter.Data.Action;
import io.github.Skepter.Data.Command;
import io.github.Skepter.Panels.CommandPanel;
import io.github.Skepter.Panels.WelcomePanel;
import io.github.Skepter.Utils.SaveLoadHandler;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
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
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainProgrammingScreen extends JFrame {

	private static final long serialVersionUID = 6082742900544647505L;
	private JPanel contentPane;
	private JScrollPane rightPane;

	private JList<String> commands;
	private Map<String, Command> commandMap;
	private Map<Command, List<Action>> commandActionMap;

	private static MainProgrammingScreen instance;

	public JList<String> getCommands() {
		return commands;
	}

	public Map<Command, List<Action>> getCommandActionMap() {
		return commandActionMap;
	}

	public Map<String, Command> getCommandMap() {
		return commandMap;
	}

	public static MainProgrammingScreen getInstance() {
		return instance;
	}

	/** Create the frame. */
	public MainProgrammingScreen(final String name, final String description, final String version, final String website, final String author) {

		/* Variable initialisation */

		instance = this;
		commandMap = new HashMap<String, Command>();

		/* Everything else */

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 875, 475);

		/* Menu bar */

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		JMenuItem saveButton = new JMenuItem("Save plugin");
		saveButton.setIcon(new ImageIcon(MainProgrammingScreen.class.getResource("/io/github/Skepter/icons/Save.png")));
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();
				fc.setDialogType(JFileChooser.SAVE_DIALOG);
				fc.setAcceptAllFileFilterUsed(false);
				fc.setMultiSelectionEnabled(false);
				fc.setFileFilter(new FileNameExtensionFilter("EasyBukkitPluginCreator data file (.ebpc)", "ebpc"));
				if (fc.showSaveDialog(instance) == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					String filePath = file.getAbsolutePath();
					if (!filePath.endsWith(".ebpc")) {
						file = new File(filePath + ".ebpc");
					}
					try {
						/* DO NOT save the view
						 * Save the key points:
						 * How many actions
						 * name + syntax of command...
						 * store it in some yaml file
						 * and then parse it.... or something */
						SaveLoadHandler.save(rightPane.getViewport().getView(), file);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		fileMenu.add(saveButton);

		JMenuItem openButton = new JMenuItem("Open plugin");
		openButton.setIcon(new ImageIcon(MainProgrammingScreen.class.getResource("/io/github/Skepter/icons/Load.png")));
		openButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();
				fc.setDialogType(JFileChooser.OPEN_DIALOG);
				fc.setAcceptAllFileFilterUsed(false);
				fc.setMultiSelectionEnabled(false);
				fc.setFileFilter(new FileNameExtensionFilter("EasyBukkitPluginCreator data file (.ebpc)", "ebpc"));
				if (fc.showSaveDialog(instance) == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					try {
						Object o = SaveLoadHandler.load(file);
						if (o instanceof Component) {
							rightPane.setViewportView((Component) o);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		fileMenu.add(openButton);

		JMenuItem mntmNewMenuItem = new JMenuItem("Return to home");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InitDialog();
				dispose();
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(MainProgrammingScreen.class.getResource("/io/github/Skepter/icons/Exit.png")));
		fileMenu.add(mntmNewMenuItem);

		JMenu addFeatureMenu = new JMenu("Add Feature");
		menuBar.add(addFeatureMenu);

		JMenuItem addCommandButton = new JMenuItem("Add new command");
		addCommandButton.setIcon(new ImageIcon(MainProgrammingScreen.class.getResource("/io/github/Skepter/icons/application_xp_terminal.png")));
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
		addEventButton.setIcon(new ImageIcon(MainProgrammingScreen.class.getResource("/io/github/Skepter/icons/Script.png")));
		addFeatureMenu.add(addEventButton);

		JMenu advancedMenu = new JMenu("Advanced");
		menuBar.add(advancedMenu);

		JMenuItem seePluginButton = new JMenuItem("Show generated plugin.yml file");
		seePluginButton.setIcon(new ImageIcon(MainProgrammingScreen.class.getResource("/io/github/Skepter/icons/List.png")));
		seePluginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PluginYAMLBuilder builder = new PluginYAMLBuilder();
				builder.setName(name);
				builder.setDescription(description);
				builder.setVersion(version);
				builder.setWebsite(website);
				builder.setAuthor(author);

				for (Entry<String, Command> entry : commandMap.entrySet()) {
					builder.addCommand(entry.getValue());
				}

				//show generated Plugin.YML file
				new PluginYAML(builder.getGeneratedYAML());
			}
		});
		advancedMenu.add(seePluginButton);

		JMenuItem editConfigButton = new JMenuItem("Modify config.yml file");
		editConfigButton.setIcon(new ImageIcon(MainProgrammingScreen.class.getResource("/io/github/Skepter/icons/Notes.png")));
		//Toggle enabled or disabled based on if the plugin requires a config.yml file or not
		advancedMenu.add(editConfigButton);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		/* Start of main GUI screen */

		//SystemColor.textHighlight.brighter(), SystemColor.textHighlight.darker()
		rightPane = new JScrollPane(new WelcomePanel());

		commands = new JList<String>(new DefaultListModel<String>());
		commands.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				/*
				 * Look for existing command components in a HashMap first,
				 * if there isn't one, load a new one with the new CommandPanel
				 */
				rightPane.setViewportView(new CommandPanel(commandMap.get(commands.getSelectedValue())));
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

	public static void addCommand(String command, String description, String syntax) {
		DefaultListModel<String> model = (DefaultListModel<String>) MainProgrammingScreen.getInstance().getCommands().getModel();
		model.addElement(command);
		MainProgrammingScreen.getInstance().getCommandMap().put(command, new Command(command, description, syntax));
	}
}
