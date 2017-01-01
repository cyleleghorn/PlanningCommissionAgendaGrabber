package pcag;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.miginfocom.swing.MigLayout;


public class MainGUI
{
	
	public static JFrame	mainFrame;
	public static String	version	= "V1.0.0";
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			@SuppressWarnings("static-access")
			public void run()
			{
				try
				{
					MainGUI window = new MainGUI();
					window.mainFrame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the application.
	 */
	public MainGUI()
	{
		initialize();
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		// Set look and feel if not on windows.
		if (!System.getProperty("os.name").toLowerCase().contains("windows"))
		{
			try
			{
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
			catch (ClassNotFoundException e1)
			{
				e1.printStackTrace();
			}
			catch (InstantiationException e1)
			{
				e1.printStackTrace();
			}
			catch (IllegalAccessException e1)
			{
				e1.printStackTrace();
			}
			catch (UnsupportedLookAndFeelException e1)
			{
				e1.printStackTrace();
			}
		}
		else
		{
			// Basically, if it is windows, do nothing and let it default to
			// Java look and feel.
		}
		
		mainFrame = new JFrame();
		mainFrame.setBounds(100, 100, 500, 400);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(new MigLayout("", "[grow][]", "[][grow]"));
		
		JButton btnGetData = new JButton("Get Data");
		btnGetData.setFont(new Font("Tahoma", Font.PLAIN, 13));
		mainFrame.getContentPane().add(btnGetData, "cell 0 0,pushx ,growx,width 50%,height 10%");
		
		JButton btnExportData = new JButton("Export Data");
		btnExportData.setEnabled(false);
		btnExportData.setFont(new Font("Tahoma", Font.PLAIN, 13));
		mainFrame.getContentPane().add(btnExportData, "cell 1 0,pushx ,growx,width 50%,gapx 5%,height 10%");
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setToolTipText("Status window");
		mainFrame.getContentPane().add(textArea, "cell 0 1 2097051 1,push ,grow");
		
		JMenuBar menuBar = new JMenuBar();
		mainFrame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExportToExcel = new JMenuItem("Export to Excel");
		mnFile.add(mntmExportToExcel);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem mntmCheckForUpdates = new JMenuItem("Check For Updates");
		mnAbout.add(mntmCheckForUpdates);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		mnAbout.add(mntmHelp);
	}
	
}
