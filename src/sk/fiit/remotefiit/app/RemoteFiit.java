package sk.fiit.remotefiit.app;

import sk.fiit.remotefiit.server.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JFrame;
import javax.swing.JDialog;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.text.Position;

import java.awt.GridBagLayout;

public class RemoteFiit {

	private JFrame jFrame = null;  //  @jve:decl-index=0:visual-constraint="10,10"
	private JPanel jContentPane = null;
	private JMenuBar jJMenuBar = null;
	private JMenu fileMenu = null;
	private JMenu editMenu = null;
	private JMenu helpMenu = null;
	private JMenuItem exitMenuItem = null;
	private JMenuItem aboutMenuItem = null;
	private JMenuItem howToConnectMenuItem = null;
	private JDialog aboutDialog = null;  //  @jve:decl-index=0:visual-constraint="425,10"
	private JPanel aboutContentPane = null;
	private JLabel aboutVersionLabel = null;
	private JButton jButtonStart = null;
	private JButton jButton1 = null;
	private Thread server = null;
	private JButton jButtonStop = null;
	private int serverPort = 9876;
	private JDialog jDialog = null;  //  @jve:decl-index=0:visual-constraint="471,91"
	private JPanel jContentPane1 = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabelQR = null;
	
	private String port;
	private JLabel jLabel = null;
	/**
	 * This method initializes jFrame
	 * 
	 * @return javax.swing.JFrame
	 */
	private JFrame getJFrame() {
		if (jFrame == null) {
			jFrame = new JFrame();
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jFrame.setJMenuBar(getJJMenuBar());
			jFrame.setSize(400, 330);
			jFrame.setContentPane(getJContentPane());
			jFrame.setTitle("RemoteFiit PC");
			jFrame.setLocationRelativeTo(null);
			init();
		}
		return jFrame;
	}
	private void init(){
		if (server == null) {
			server = new Thread(new Server(serverPort, RemoteFiit.this));
			server.start();
		}
	}
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJButtonPause(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getFileMenu());
			jJMenuBar.add(getSettingsMenu());
			jJMenuBar.add(getHelpMenu());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getFileMenu() {
		if (fileMenu == null) {
			fileMenu = new JMenu();
			fileMenu.setText("File");
			fileMenu.add(getExitMenuItem());
		}
		return fileMenu;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getSettingsMenu() {
		if (editMenu == null) {
			editMenu = new JMenu();
			editMenu.setText("Settings");
			editMenu.add(getHowToConnectItem());
		}
		return editMenu;
	}

	private JMenuItem getHowToConnectItem() {
		if (howToConnectMenuItem == null) {
			howToConnectMenuItem = new JMenuItem();
			howToConnectMenuItem.setText("How to connect");
			howToConnectMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JDialog aboutDialog = getJDialog();
					aboutDialog.pack();
					Point loc = getJFrame().getLocation();
					loc.translate(20, 20);
					aboutDialog.setLocation(loc);
					aboutDialog.setVisible(true);
					jDialog.setSize(350, 300);
					try {
						jLabel.setText(InetAddress.getLocalHost().getHostAddress() + ":" + port);
						String host = InetAddress.getLocalHost().getHostAddress() + ":" + port;
						jLabelQR.setIcon(QRCodeCreator.getQr(host));
					} catch (UnknownHostException e2) {
						jLabel2.setText("<html><font color='red'>!!! Unknown host !!!</font></html>");
						jButtonStart.setEnabled(false);
						e2.printStackTrace();
					}
					
					

				}
			});
		}
		return howToConnectMenuItem;
	}
	
	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getHelpMenu() {
		if (helpMenu == null) {
			helpMenu = new JMenu();
			helpMenu.setText("Help");
			helpMenu.add(getAboutMenuItem());
		}
		return helpMenu;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getExitMenuItem() {
		if (exitMenuItem == null) {
			exitMenuItem = new JMenuItem();
			exitMenuItem.setText("Exit");
			exitMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return exitMenuItem;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getAboutMenuItem() {
		if (aboutMenuItem == null) {
			aboutMenuItem = new JMenuItem();
			aboutMenuItem.setText("About");
			aboutMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JDialog aboutDialog = getAboutDialog();
					aboutDialog.pack();
					Point loc = getJFrame().getLocation();
					loc.translate(20, 20);
					aboutDialog.setLocation(loc);
					aboutDialog.setVisible(true);
				}
			});
		}
		return aboutMenuItem;
	}

	/**
	 * This method initializes aboutDialog	
	 * 	
	 * @return javax.swing.JDialog
	 */
	private JDialog getAboutDialog() {
		if (aboutDialog == null) {
			aboutDialog = new JDialog(getJFrame(), true);
			aboutDialog.setTitle("About");
			aboutDialog.setContentPane(getAboutContentPane());
		}
		return aboutDialog;
	}

	/**
	 * This method initializes aboutContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getAboutContentPane() {
		if (aboutContentPane == null) {
			aboutContentPane = new JPanel();
			aboutContentPane.setLayout(new BorderLayout());
			aboutContentPane.add(getAboutVersionLabel(), BorderLayout.CENTER);
		}
		return aboutContentPane;
	}

	/**
	 * This method initializes aboutVersionLabel	
	 * 	
	 * @return javax.swing.JLabel	
	 */
	private JLabel getAboutVersionLabel() {
		if (aboutVersionLabel == null) {
			aboutVersionLabel = new JLabel();
			aboutVersionLabel.setText("Version 0.1");
			aboutVersionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return aboutVersionLabel;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButtonStart == null) {
			jButtonStart = new JButton();
			jButtonStart.setBounds(new Rectangle(125, 230, 150, 30));
			jButtonStart.setText("START");
			jButtonStart.setEnabled(false);
			jButtonStart.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (server == null) {
						server = new Thread(new Server(serverPort, RemoteFiit.this));
						server.start();
					} else if (server.isAlive()) {
						server.resume();
					}
					jButtonStart.setEnabled(false);
					jButtonStop.setEnabled(true);
				}
			});
		}
		return jButtonStart;
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(315, 240, 60, 20));
			jButton1.setText("EXIT");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return jButton1;
	}

	/**
	 * This method initializes jButtonPause	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonPause() {
		if (jButtonStop == null) {
			jButtonStop = new JButton();
			jButtonStop.setBounds(new Rectangle(15, 236, 66, 20));
			jButtonStop.setText("STOP");
			jButtonStop.setEnabled(true);
			jButtonStop.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (server!=null && server.isAlive()){
						server.suspend();
						jButtonStop.setEnabled(false);
						jButtonStart.setEnabled(true);
					}
				}
			});
		}
		return jButtonStop;
	}

	/**
	 * This method initializes jDialog	
	 * 	
	 * @return javax.swing.JDialog	
	 */
	private JDialog getJDialog() {
		if (jDialog == null) {
			jDialog = new JDialog(getJFrame());
			jDialog.setTitle("How to connect");
			jDialog.setSize(new Dimension(350, 300));
			jDialog.setContentPane(getJContentPane1());
		}
		return jDialog;
	}
	/**
	 * This method initializes jContentPane1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane1() {
		if (jContentPane1 == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(6, 62, 322, 17));
			jLabel.setHorizontalAlignment(JLabel.CENTER);
			jLabelQR = new JLabel();
			jLabelQR.setBounds(new Rectangle(108, 131, 125, 125));
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(5, 111, 243, 20));
			jLabel4.setText("Scan this QR code with your device:");
			jLabel3 = new JLabel();
			jLabel3.setHorizontalAlignment(JLabel.CENTER);
			jLabel3.setBounds(new Rectangle(0, 83, 350, 18));
			jLabel3.setText("OR");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(5, 34, 203, 27));
			jLabel2.setText("Set this IP and port to your device:");
			jLabel1 = new JLabel();
			jLabel1.setHorizontalAlignment(JLabel.CENTER);
			jLabel1.setBounds(new Rectangle(0, 10, jDialog.getWidth(), 20));
			jLabel1.setText("How to connect");
			jContentPane1 = new JPanel();
			jContentPane1.setLayout(null);
			jContentPane1.add(jLabel1, null);
			jContentPane1.add(jLabel2, null);
			jContentPane1.add(jLabel3, null);
			jContentPane1.add(jLabel4, null);
			jContentPane1.add(jLabelQR, null);
			jContentPane1.add(jLabel, null);
		}
		return jContentPane1;
	}
	/**
	 * Launches this application
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				RemoteFiit application = new RemoteFiit();
				application.getJFrame().setVisible(true);
			}
		});
	}
	
	public void setPort(String s) {
		port = s;
	}
}
