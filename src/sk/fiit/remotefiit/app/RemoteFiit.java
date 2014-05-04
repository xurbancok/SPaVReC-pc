package sk.fiit.remotefiit.app;

import sk.fiit.remotefiit.server.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.Point;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JFrame;
import javax.swing.JDialog;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JTextField;

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
	private JDialog aboutDialog = null;  //  @jve:decl-index=0:visual-constraint="765,0"
	private JPanel aboutContentPane = null;
	private JLabel aboutVersionLabel = null;
	private JButton jButtonStart = null;
	private JButton jButton1 = null;
	private Thread server = null;
	private JButton jButtonStop = null;
	private int serverPort = 9876;
	private JDialog jDialog = null;  //  @jve:decl-index=0:visual-constraint="763,63"
	private JPanel jContentPane1 = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabelQR = null;
	
	private String port;  //  @jve:decl-index=0:
	private JLabel jLabel = null;
	private QRCodeCreator qrCodeCreator = new QRCodeCreator();
	private JLabel jLabelMoveLeft = null;
	private JLabel jLabelMoveRight = null;
	private JLabel jLabelMoveUp = null;
	private JLabel jLabelMoveDown = null;
	private JLabel jLabelMoveForwards = null;
	private JLabel jLabelMoveBackwards = null;
	private JLabel jLabelLookLeft = null;
	private JLabel jLabelLookRight = null;
	private JLabel jLabelLookUp = null;
	private JLabel jLabelLookDown = null;
	private JLabel jLabelRotateCW = null;
	private JLabel jLabelRotateCCW = null;
	private JTextField JTextFieldMoveLeft = null;
	private JTextField JTextFieldMoveRight = null;
	private JTextField JTextFieldMoveUp = null;
	private JTextField JTextFieldMoveDown = null;
	private JTextField JTextFieldMoveForwards = null;
	private JTextField JTextFieldMoveBackwards = null;
	private JTextField JTextFieldLookLeft = null;
	private JTextField JTextFieldLookRight = null;
	private JTextField JTextFieldLookUp = null;
	private JTextField JTextFieldLookDown = null;
	private JTextField JTextFieldRotateCW = null;
	private JTextField JTextFieldRotateCCW = null;
	private JLabel jLabelProfile = null;
	private JComboBox JComboBoxProfile = null;
	private JButton jButtonSaveNewProfile = null;
	private JLabel jLabelProfileName = null;
	private JTextField jTextFieldProfileName = null;
	private JLabel jLabelMouseLeft = null;
	private JLabel jLabelMouseRight = null;
	private JLabel jLabelMouseForwards = null;
	private JLabel jLabelMouseBackwards = null;
	
	private Map<Movement, Integer> profile = new HashMap<Movement, Integer>();  //  @jve:decl-index=0:
	private Map<String,Map<Movement,Integer>> profiles = new HashMap<String,Map<Movement,Integer>>();  //  @jve:decl-index=0:
	private FileStorage fs = new FileStorage();
	
	private JComboBox jComboBoxMouseLeft = null;
	private JComboBox jComboBoxMouseRight = null;
	private JComboBox jComboBoxMouseForwards = null;
	private JComboBox jComboBoxMouseBackwards = null;

	private DatagramSocket datagramSocket;  //  @jve:decl-index=0:
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
			jFrame.setSize(666, 366);
			jFrame.setContentPane(getJContentPane());
			jFrame.setTitle("SPaVReC");
			jFrame.setLocationRelativeTo(null);
		}
		return jFrame;
	}
	private void init(){
		try {
			datagramSocket = new DatagramSocket(0);
			profiles = fs.readData();
			System.out.println(profiles.keySet().size());
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
//		if (server == null) {
//			server = new Thread(new Server(serverPort, RemoteFiit.this));
//			server.start();
//		}
	}
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelMouseBackwards = new JLabel();
			jLabelMouseBackwards.setBounds(new Rectangle(378, 134, 112, 25));
			jLabelMouseBackwards.setText("Mouse backwards:");
			jLabelMouseForwards = new JLabel();
			jLabelMouseForwards.setBounds(new Rectangle(378, 104, 99, 25));
			jLabelMouseForwards.setText("Mouse forwards:");
			jLabelMouseRight = new JLabel();
			jLabelMouseRight.setBounds(new Rectangle(378, 74, 87, 25));
			jLabelMouseRight.setText("Mouse right:");
			jLabelMouseLeft = new JLabel();
			jLabelMouseLeft.setBounds(new Rectangle(378, 44, 83, 25));
			jLabelMouseLeft.setText("Mouse left:");
			jLabelProfileName = new JLabel();
			jLabelProfileName.setBounds(new Rectangle(15, 240, 80, 25));
			jLabelProfileName.setText("Profile name:");
			jLabelProfile = new JLabel();
			jLabelProfile.setBounds(new Rectangle(15, 5, 45, 29));
			jLabelProfile.setText("Profile:");
			jLabelRotateCCW = new JLabel();
			jLabelRotateCCW.setBounds(new Rectangle(204, 194, 80, 25));
			jLabelRotateCCW.setText("Rotate CCW:");
			jLabelRotateCW = new JLabel();
			jLabelRotateCW.setBounds(new Rectangle(204, 164, 80, 25));
			jLabelRotateCW.setText("Rotate CW:");
			jLabelLookDown = new JLabel();
			jLabelLookDown.setBounds(new Rectangle(204, 134, 80, 25));
			jLabelLookDown.setText("Look down:");
			jLabelLookUp = new JLabel();
			jLabelLookUp.setBounds(new Rectangle(204, 104, 80, 25));
			jLabelLookUp.setText("Look up:");
			jLabelLookRight = new JLabel();
			jLabelLookRight.setBounds(new Rectangle(204, 74, 80, 25));
			jLabelLookRight.setText("LookRight:");
			jLabelLookLeft = new JLabel();
			jLabelLookLeft.setBounds(new Rectangle(204, 44, 80, 25));
			jLabelLookLeft.setText("Look left:");
			jLabelMoveBackwards = new JLabel();
			jLabelMoveBackwards.setBounds(new Rectangle(15, 193, 100, 25));
			jLabelMoveBackwards.setText("Move backwards:");
			jLabelMoveForwards = new JLabel();
			jLabelMoveForwards.setBounds(new Rectangle(15, 163, 100, 25));
			jLabelMoveForwards.setText("Move forwards:");
			jLabelMoveDown = new JLabel();
			jLabelMoveDown.setBounds(new Rectangle(15, 133, 100, 25));
			jLabelMoveDown.setText("Move down:");
			jLabelMoveUp = new JLabel();
			jLabelMoveUp.setBounds(new Rectangle(15, 103, 100, 25));
			jLabelMoveUp.setText("Move up:");
			jLabelMoveRight = new JLabel();
			jLabelMoveRight.setBounds(new Rectangle(15, 73, 100, 25));
			jLabelMoveRight.setText("Move right:");
			jLabelMoveLeft = new JLabel();
			jLabelMoveLeft.setBounds(new Rectangle(15, 43, 100, 25));
			jLabelMoveLeft.setText("Move left:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJButtonPause(), null);
			jContentPane.add(jLabelMoveLeft, null);
			jContentPane.add(jLabelMoveRight, null);
			jContentPane.add(jLabelMoveUp, null);
			jContentPane.add(jLabelMoveDown, null);
			jContentPane.add(jLabelMoveForwards, null);
			jContentPane.add(jLabelMoveBackwards, null);
			jContentPane.add(jLabelLookLeft, null);
			jContentPane.add(jLabelLookRight, null);
			jContentPane.add(jLabelLookUp, null);
			jContentPane.add(jLabelLookDown, null);
			jContentPane.add(jLabelRotateCW, null);
			jContentPane.add(jLabelRotateCCW, null);
			jContentPane.add(getJTextFieldMoveLeft(), null);
			jContentPane.add(getJTextFieldMoveRight(), null);
			jContentPane.add(getJTextFieldMoveUp(), null);
			jContentPane.add(getJTextFieldMoveDown(), null);
			jContentPane.add(getJTextFieldMoveForwards(), null);
			jContentPane.add(getJTextFieldMoveBackwards(), null);
			jContentPane.add(getJTextFieldLookLeft(), null);
			jContentPane.add(getJTextFieldLookRight(), null);
			jContentPane.add(getJTextFieldLookUp(), null);
			jContentPane.add(getJTextFieldLookDown(), null);
			jContentPane.add(getJTextFieldRotateCW(), null);
			jContentPane.add(getJTextFieldRotateCCW(), null);
			jContentPane.add(jLabelProfile, null);
			jContentPane.add(getJButtonSaveNewProfile(), null);
			jContentPane.add(jLabelProfileName, null);
			jContentPane.add(getJTextFieldProfileName(), null);
			jContentPane.add(jLabelMouseLeft, null);
			jContentPane.add(jLabelMouseRight, null);
			jContentPane.add(jLabelMouseForwards, null);
			jContentPane.add(jLabelMouseBackwards, null);
			jContentPane.add(getJComboBoxMouseLeft(), null);
			jContentPane.add(getJComboBoxMouseRight(), null);
			jContentPane.add(getJComboBoxMouseForwards(), null);
			jContentPane.add(getJComboBoxMouseBackwards(), null);
			jContentPane.add(getJTextFieldProfile(), null);
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
					if(port == null){
						JOptionPane.showMessageDialog(null, "Start server first");
						return;
					}
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
						jLabelQR.setIcon(qrCodeCreator.getQRCode(host));
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
			jButtonStart.setBounds(new Rectangle(167, 272, 365, 30));
			jButtonStart.setText("Start server");
			jButtonStart.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (server != null) {
						server.stop();
						server = null;
					}   
					server = new Thread(new Server(RemoteFiit.this, datagramSocket, profiles.get(JComboBoxProfile.getSelectedItem())));
					server.start();
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
			jButton1.setBounds(new Rectangle(579, 274, 60, 20));
			jButton1.setText("EXIT");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(server!=null)server.stop();
					fs.storeData(profiles);
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
			jButtonStop.setBounds(new Rectangle(13, 278, 66, 20));
			jButtonStop.setText("STOP");
			jButtonStop.setEnabled(false);
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
	 * This method initializes JTextFieldMoveLeft	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldMoveLeft() {
		if (JTextFieldMoveLeft == null) {
			JTextFieldMoveLeft = new JTextField();
			JTextFieldMoveLeft.setName(Movement.MOVE_LEFT.toString());
			JTextFieldMoveLeft.setBounds(new Rectangle(120, 43, 80, 25));
			this.addListeners(JTextFieldMoveLeft);
		}
		return JTextFieldMoveLeft;
	}
	/**
	 * This method initializes JTextFieldMoveRight	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldMoveRight() {
		if (JTextFieldMoveRight == null) {
			JTextFieldMoveRight = new JTextField();
			JTextFieldMoveRight.setName(Movement.MOVE_RIGHT.toString());
			JTextFieldMoveRight.setBounds(new Rectangle(120, 73, 80, 25));
			this.addListeners(JTextFieldMoveRight);
		}
		return JTextFieldMoveRight;
	}
	/**
	 * This method initializes JTextFieldMoveUp	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldMoveUp() {
		if (JTextFieldMoveUp == null) {
			JTextFieldMoveUp = new JTextField();
			JTextFieldMoveUp.setName(Movement.MOVE_UP.toString());
			JTextFieldMoveUp.setBounds(new Rectangle(120, 103, 80, 25));
			this.addListeners(JTextFieldMoveUp);
		}
		return JTextFieldMoveUp;
	}
	/**
	 * This method initializes JTextFieldMoveDown	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldMoveDown() {
		if (JTextFieldMoveDown == null) {
			JTextFieldMoveDown = new JTextField();
			JTextFieldMoveDown.setName(Movement.MOVE_DOWN.toString());
			JTextFieldMoveDown.setBounds(new Rectangle(120, 133, 80, 25));
			this.addListeners(JTextFieldMoveDown);
		}
		return JTextFieldMoveDown;
	}
	/**
	 * This method initializes JTextFieldMoveForwards	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldMoveForwards() {
		if (JTextFieldMoveForwards == null) {
			JTextFieldMoveForwards = new JTextField();
			JTextFieldMoveForwards.setName(Movement.MOVE_FORWARDS.toString());
			JTextFieldMoveForwards.setBounds(new Rectangle(120, 163, 80, 25));
			this.addListeners(JTextFieldMoveForwards);
		}
		return JTextFieldMoveForwards;
	}
	/**
	 * This method initializes JTextFieldMoveBackwards	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldMoveBackwards() {
		if (JTextFieldMoveBackwards == null) {
			JTextFieldMoveBackwards = new JTextField();
			JTextFieldMoveBackwards.setName(Movement.MOVE_BACKWARDS.toString());
			JTextFieldMoveBackwards.setBounds(new Rectangle(120, 193, 80, 25));
			this.addListeners(JTextFieldMoveBackwards);
		}
		return JTextFieldMoveBackwards;
	}
	/**
	 * This method initializes JTextFieldLookLeft	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldLookLeft() {
		if (JTextFieldLookLeft == null) {
			JTextFieldLookLeft = new JTextField();
			JTextFieldLookLeft.setName(Movement.LOOK_LEFT.toString());
			JTextFieldLookLeft.setBounds(new Rectangle(289, 44, 80, 25));
			this.addListeners(JTextFieldLookLeft);
		}
		return JTextFieldLookLeft;
	}
	/**
	 * This method initializes JTextFieldLookRight	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldLookRight() {
		if (JTextFieldLookRight == null) {
			JTextFieldLookRight = new JTextField();
			JTextFieldLookRight.setName(Movement.LOOK_RIGHT.toString());
			JTextFieldLookRight.setBounds(new Rectangle(289, 74, 80, 25));
			this.addListeners(JTextFieldLookRight);
		}
		return JTextFieldLookRight;
	}
	/**
	 * This method initializes JTextFieldLookUp	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldLookUp() {
		if (JTextFieldLookUp == null) {
			JTextFieldLookUp = new JTextField();
			JTextFieldLookUp.setName(Movement.LOOK_UP.toString());
			JTextFieldLookUp.setBounds(new Rectangle(289, 104, 80, 25));
			this.addListeners(JTextFieldLookUp);
		}
		return JTextFieldLookUp;
	}
	/**
	 * This method initializes JTextFieldLookDown	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldLookDown() {
		if (JTextFieldLookDown == null) {
			JTextFieldLookDown = new JTextField();
			JTextFieldLookDown.setName(Movement.LOOK_DOWN.toString());
			JTextFieldLookDown.setBounds(new Rectangle(289, 134, 80, 25));
			this.addListeners(JTextFieldLookDown);
		}
		return JTextFieldLookDown;
	}
	/**
	 * This method initializes JTextFieldRotateCW	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldRotateCW() {
		if (JTextFieldRotateCW == null) {
			JTextFieldRotateCW = new JTextField();
			JTextFieldRotateCW.setName(Movement.ROTATE_CW.toString());
			JTextFieldRotateCW.setBounds(new Rectangle(289, 164, 80, 25));
			this.addListeners(JTextFieldRotateCW);
		}
		return JTextFieldRotateCW;
	}
	/**
	 * This method initializes JTextFieldRotateCCW	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldRotateCCW() {
		if (JTextFieldRotateCCW == null) {
			JTextFieldRotateCCW = new JTextField();
			JTextFieldRotateCCW.setName(Movement.ROTATE_CCW.toString());
			JTextFieldRotateCCW.setBounds(new Rectangle(289, 194, 80, 25));
			this.addListeners(JTextFieldRotateCCW);
		}
		return JTextFieldRotateCCW;
	}
	/**
	 * This method initializes JTextFieldProfile	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JComboBox getJTextFieldProfile() {
		if (JComboBoxProfile == null) {
			JComboBoxProfile = new JComboBox();
			JComboBoxProfile.setBounds(new Rectangle(67, 5, 252, 27));
			JComboBoxProfile.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					//System.out.println(JComboBoxProfile.getSelectedItem()); // TODO Auto-generated Event stub itemStateChanged()
					if(profiles.containsKey(JComboBoxProfile.getSelectedItem())){
						resetForm();
						Map<Movement, Integer> profil = profiles.get(JComboBoxProfile.getSelectedItem());
						
					//	Map<Movement, Integer> profilNew = new HashMap<Movement, Integer>();
						List<Movement> list = new ArrayList<Movement>(profil.keySet());
						for(Movement s : list){
							profile.put(s, profil.get(s));
						}
						
						if(profil.containsKey(Movement.MOVE_LEFT)){
							if(profil.get(Movement.MOVE_LEFT).intValue()>900)getComboBoxMouse(profil.get(Movement.MOVE_LEFT).intValue()).setSelectedItem(Movement.MOVE_LEFT);
							else{
								JTextFieldMoveLeft.setText(getSymbol(profil.get(Movement.MOVE_LEFT).intValue()));
								JTextFieldMoveLeft.setEditable(false);
							}
						}
						if(profil.containsKey(Movement.MOVE_RIGHT)){
							if(profil.get(Movement.MOVE_RIGHT).intValue()>900)getComboBoxMouse(profil.get(Movement.MOVE_RIGHT).intValue()).setSelectedItem(Movement.MOVE_RIGHT);
							else{
								JTextFieldMoveRight.setText(getSymbol(profil.get(Movement.MOVE_RIGHT).intValue()));
								JTextFieldMoveRight.setEditable(false);
							}
						}
						if(profil.containsKey(Movement.MOVE_UP)){
							if(profil.get(Movement.MOVE_UP).intValue()>900)getComboBoxMouse(profil.get(Movement.MOVE_UP).intValue()).setSelectedItem(Movement.MOVE_UP);
							else{
								JTextFieldMoveUp.setText(getSymbol(profil.get(Movement.MOVE_UP).intValue()));
								JTextFieldMoveUp.setEditable(false);
							}
						}
						if(profil.containsKey(Movement.MOVE_DOWN)){
							if(profil.get(Movement.MOVE_DOWN).intValue()>900)getComboBoxMouse(profil.get(Movement.MOVE_DOWN).intValue()).setSelectedItem(Movement.MOVE_DOWN);
							else{							
								JTextFieldMoveDown.setText(getSymbol(profil.get(Movement.MOVE_DOWN).intValue()));
								JTextFieldMoveDown.setEditable(false);
							}
						}
						if(profil.containsKey(Movement.MOVE_BACKWARDS)){
							if(profil.get(Movement.MOVE_BACKWARDS).intValue()>900)getComboBoxMouse(profil.get(Movement.MOVE_BACKWARDS).intValue()).setSelectedItem(Movement.MOVE_BACKWARDS);
							else{							
								JTextFieldMoveBackwards.setText(getSymbol(profil.get(Movement.MOVE_BACKWARDS).intValue()));
								JTextFieldMoveBackwards.setEditable(false);
							}
						}
						if(profil.containsKey(Movement.MOVE_FORWARDS)){
							if(profil.get(Movement.MOVE_FORWARDS).intValue()>900)getComboBoxMouse(profil.get(Movement.MOVE_FORWARDS).intValue()).setSelectedItem(Movement.MOVE_FORWARDS);
							else{							
							JTextFieldMoveForwards.setText(getSymbol(profil.get(Movement.MOVE_FORWARDS).intValue()));
							JTextFieldMoveForwards.setEditable(false);}
						}
						if(profil.containsKey(Movement.LOOK_LEFT)){
							if(profil.get(Movement.LOOK_LEFT).intValue()>900)getComboBoxMouse(profil.get(Movement.LOOK_LEFT).intValue()).setSelectedItem(Movement.LOOK_LEFT);
							else{							
								JTextFieldLookLeft.setText(getSymbol(profil.get(Movement.LOOK_LEFT).intValue()));
								JTextFieldLookLeft.setEditable(false);
							}
						}
						if(profil.containsKey(Movement.LOOK_RIGHT)){
							if(profil.get(Movement.LOOK_RIGHT).intValue()>900)getComboBoxMouse(profil.get(Movement.LOOK_RIGHT).intValue()).setSelectedItem(Movement.LOOK_RIGHT);
							else{						
								JTextFieldLookRight.setText(getSymbol(profil.get(Movement.LOOK_RIGHT).intValue()));
								JTextFieldLookRight.setEditable(false);
							}
						}
						if(profil.containsKey(Movement.LOOK_UP)){
							if(profil.get(Movement.LOOK_UP).intValue()>900)getComboBoxMouse(profil.get(Movement.LOOK_UP).intValue()).setSelectedItem(Movement.LOOK_UP);
							else{							
								JTextFieldLookUp.setText(getSymbol(profil.get(Movement.LOOK_UP).intValue()));
								JTextFieldLookUp.setEditable(false);
							}
						}
						if(profil.containsKey(Movement.LOOK_DOWN)){
							if(profil.get(Movement.LOOK_DOWN).intValue()>900)getComboBoxMouse(profil.get(Movement.LOOK_DOWN).intValue()).setSelectedItem(Movement.LOOK_DOWN);
							else{							
								JTextFieldLookDown.setText(getSymbol(profil.get(Movement.LOOK_DOWN).intValue()));
								JTextFieldLookDown.setEditable(false);
							}
						}
						if(profil.containsKey(Movement.ROTATE_CCW)){
							if(profil.get(Movement.ROTATE_CCW).intValue()>900)getComboBoxMouse(profil.get(Movement.ROTATE_CCW).intValue()).setSelectedItem(Movement.ROTATE_CCW);
							else{							
								JTextFieldRotateCCW.setText(getSymbol(profil.get(Movement.ROTATE_CCW).intValue()));
								JTextFieldRotateCCW.setEditable(false);
							}
						}
						if(profil.containsKey(Movement.ROTATE_CW)){
							if(profil.get(Movement.ROTATE_CW).intValue()>900)getComboBoxMouse(profil.get(Movement.ROTATE_CW).intValue()).setSelectedItem(Movement.ROTATE_CW);
							else{							
								JTextFieldRotateCW.setText(getSymbol(profil.get(Movement.ROTATE_CW).intValue()));
								JTextFieldRotateCW.setEditable(false);
							}
						}
					}
				}
			});
			
		}
		List<String> list = new ArrayList<String>(profiles.keySet());
		for (String s : list) {
			JComboBoxProfile.addItem(s);
		}
		return JComboBoxProfile;
	}
	/**
	 * This method initializes jButtonSaveNewProfile	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSaveNewProfile() {
		if (jButtonSaveNewProfile == null) {
			jButtonSaveNewProfile = new JButton();
			jButtonSaveNewProfile.setBounds(new Rectangle(306, 240, 143, 25));
			jButtonSaveNewProfile.setText("Save new profile");
			jButtonSaveNewProfile.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(jTextFieldProfileName.getText()==null || jTextFieldProfileName.getText().length()==0){
						JOptionPane.showMessageDialog(null, "Type profile name");
						return;
					}
					profiles.put(jTextFieldProfileName.getText(), profile);
					profile = new HashMap<Movement, Integer>();
					JComboBoxProfile.addItem(jTextFieldProfileName.getText());	
					JComboBoxProfile.setSelectedItem(jTextFieldProfileName.getText());
					jTextFieldProfileName.setText("");
					fs.storeData(profiles);

					JOptionPane.showMessageDialog(null, "Profile successfully saved");
				}
			});
		}
		return jButtonSaveNewProfile;
	}
	/**
	 * This method initializes jTextFieldProfileName	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldProfileName() {
		if (jTextFieldProfileName == null) {
			jTextFieldProfileName = new JTextField();
			jTextFieldProfileName.setBounds(new Rectangle(98, 240, 203, 25));
			jTextFieldProfileName.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					System.out.println("keyPressed() "+e.getKeyCode()); // TODO Auto-generated Event stub keyPressed()
				}
			});
		}
		return jTextFieldProfileName;
	}
	/**
	 * This method initializes jComboBoxMouseLeft	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxMouseLeft() {
		if (jComboBoxMouseLeft == null) {
			jComboBoxMouseLeft = new JComboBox();
			jComboBoxMouseLeft.setBounds(new Rectangle(500, 44, 140, 25));
			this.insertItems(jComboBoxMouseLeft);
			jComboBoxMouseLeft.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if(jComboBoxMouseLeft.getSelectedItem().toString().equals("")) return;
					profile.put(Movement.valueOf(jComboBoxMouseLeft.getSelectedItem().toString()), 991); // TODO Auto-generated Event stub itemStateChanged()
				}
			});
			
		}
		return jComboBoxMouseLeft;
	}
	/**
	 * This method initializes jComboBoxMouseRight	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxMouseRight() {
		if (jComboBoxMouseRight == null) {
			jComboBoxMouseRight = new JComboBox();
			jComboBoxMouseRight.setBounds(new Rectangle(500, 74, 140, 25));
			this.insertItems(jComboBoxMouseRight);
			jComboBoxMouseRight.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if(jComboBoxMouseRight.getSelectedItem().toString().equals("")) return;
					profile.put(Movement.valueOf(jComboBoxMouseRight.getSelectedItem().toString()), 992); // TODO Auto-generated Event stub itemStateChanged()
				}
			});
			
		}
		return jComboBoxMouseRight;
	}
	/**
	 * This method initializes jComboBoxMouseForwards	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxMouseForwards() {
		if (jComboBoxMouseForwards == null) {
			jComboBoxMouseForwards = new JComboBox();
			jComboBoxMouseForwards.setBounds(new Rectangle(500, 104, 140, 25));
			this.insertItems(jComboBoxMouseForwards);
			jComboBoxMouseForwards.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if(jComboBoxMouseForwards.getSelectedItem().toString().equals("")) return;
					profile.put(Movement.valueOf(jComboBoxMouseForwards.getSelectedItem().toString()), 993); // TODO Auto-generated Event stub itemStateChanged()
				}
			});
		}
		return jComboBoxMouseForwards;
	}
	/**
	 * This method initializes jComboBoxMouseBackwards	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxMouseBackwards() {
		if (jComboBoxMouseBackwards == null) {
			jComboBoxMouseBackwards = new JComboBox();
			jComboBoxMouseBackwards.setBounds(new Rectangle(500, 134, 140, 25));
			this.insertItems(jComboBoxMouseBackwards);
			jComboBoxMouseBackwards.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if(jComboBoxMouseBackwards.getSelectedItem().toString().equals("")) return;
					profile.put(Movement.valueOf(jComboBoxMouseBackwards.getSelectedItem().toString()), 994); // TODO Auto-generated Event stub itemStateChanged()
				}
			});
		}
		return jComboBoxMouseBackwards;
	}
	/**
	 * Launches this application
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				RemoteFiit application = new RemoteFiit();
				application.init();
				application.getJFrame().setVisible(true);

			}
		});
	}
	
	public void setPort(String s) {
		port = s;
	}
	
	private void addListeners(final JTextField input){
		input.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent e) {
				//System.out.println("keyReleased() "+e.getKeyCode());
				switch(e.getKeyCode()){
				case 65://a
					profile.put(getEnum(input.getName()), 65);
					input.setText("a");
					break;
				case 66://b
					profile.put(getEnum(input.getName()), 66);
					input.setText("b");
					break;
				case 67://c
					profile.put(getEnum(input.getName()), 67);
					input.setText("c");
					break;
				case 68://d
					profile.put(getEnum(input.getName()), 68);
					input.setText("d");
					break;
				case 69://e
					profile.put(getEnum(input.getName()), 69);
					input.setText("e");
					break;
				case 70://f
					profile.put(getEnum(input.getName()), 70);
					input.setText("f");
					break;
				case 71://g
					profile.put(getEnum(input.getName()), 71);
					input.setText("g");
					break;
				case 72://h
					profile.put(getEnum(input.getName()), 72);
					input.setText("h");
					break;
				case 73://i
					profile.put(getEnum(input.getName()), 73);
					input.setText("i");
					break;
				case 74://j
					profile.put(getEnum(input.getName()), 74);
					input.setText("j");
					break;
				case 75://k
					profile.put(getEnum(input.getName()), 75);
					input.setText("k");
					break;
				case 76://l
					profile.put(getEnum(input.getName()), 76);
					input.setText("l");
					break;
				case 77://m
					profile.put(getEnum(input.getName()), 77);
					input.setText("m");
					break;
				case 78://n
					profile.put(getEnum(input.getName()), 78);
					input.setText("n");
					break;
				case 79://o
					profile.put(getEnum(input.getName()), 79);
					input.setText("o");
					break;
				case 80://p
					profile.put(getEnum(input.getName()), 80);
					input.setText("p");
					break;
				case 81://q
					profile.put(getEnum(input.getName()), 81);
					input.setText("q");
					break;
				case 82://r
					profile.put(getEnum(input.getName()), 82);
					input.setText("r");
					break;
				case 83://s
					profile.put(getEnum(input.getName()), 83);
					input.setText("s");
					break;
				case 84://t
					profile.put(getEnum(input.getName()), 84);
					input.setText("t");
					break;
				case 85://u
					profile.put(getEnum(input.getName()), 85);
					input.setText("u");
					break;
				case 86://v
					profile.put(getEnum(input.getName()), 86);
					input.setText("v");
					break;
				case 87://w
					profile.put(getEnum(input.getName()), 87);
					input.setText("w");
					break;
				case 88://x
					profile.put(getEnum(input.getName()), 88);
					input.setText("x");
					break;
				case 89://y
					profile.put(getEnum(input.getName()), 89);
					input.setText("y");
					break;
				case 90://z
					profile.put(getEnum(input.getName()), 90);
					input.setText("z");
					break;	
//==========================koniec abecedy					
				case 16://shift
					profile.put(getEnum(input.getName()), 16);
					input.setText("shift");
					break;	
				case 17://ctrl
					profile.put(getEnum(input.getName()), 17);
					input.setText("ctrl");
					break;	
				case 18://alt
					profile.put(getEnum(input.getName()), 18);
					input.setText("alt");
					break;
				case 37://lava sipka
					profile.put(getEnum(input.getName()), 37);
					input.setText("left arrow");
					break;
				case 39://prava sipka
					profile.put(getEnum(input.getName()), 39);
					input.setText("right arrow");
					break;	
				case 38://hore sipka
					profile.put(getEnum(input.getName()), 38);
					input.setText("up arrow");
					break;	
				case 40://dole sipka
					profile.put(getEnum(input.getName()), 40);
					input.setText("down arrow");
					break;	
				case 34://page down
					profile.put(getEnum(input.getName()), 34);
					input.setText("pg down");
					break;	
				case 33://page up
					profile.put(getEnum(input.getName()), 33);
					input.setText("pg up");
					break;		
				case 36://home
					profile.put(getEnum(input.getName()), 36);
					input.setText("home");
					break;	
				case 35://end down
					profile.put(getEnum(input.getName()), 35);
					input.setText("end");
					break;	
				case 32://medzernik
					profile.put(getEnum(input.getName()), 32);
					input.setText("space");
					break;	
				case 92://\
					profile.put(getEnum(input.getName()), 92);
					input.setText("\\");
					break;
				case 44://,
					profile.put(getEnum(input.getName()), 44);
					input.setText(",");
					break;
				case 46://.
					profile.put(getEnum(input.getName()), 46);
					input.setText(".");
					break;
				case 47:///
					profile.put(getEnum(input.getName()), 47);
					input.setText("/");
					break;
				case 59://;
					profile.put(getEnum(input.getName()), 59);
					input.setText(";");
					break;
				case 129://'
					profile.put(getEnum(input.getName()), 129);
					input.setText("'");
					break;
				case 91://[
					profile.put(getEnum(input.getName()), 91);
					input.setText("[");
					break;
				case 93://]
					profile.put(getEnum(input.getName()), 93);
					input.setText("]");
					break;
				case 45://-
					profile.put(getEnum(input.getName()), 45);
					input.setText("-");
					break;
				case 61://=
					profile.put(getEnum(input.getName()), 61);
					input.setText("=");
					break;
				}
				input.setEditable(false);
			}
		});
		input.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				input.setText("");
				input.setEditable(true);
				profile.remove(getEnum(input.getName()));
			}
		});
	}
	
	private Movement getEnum(String input){
		return Movement.valueOf(input);
	}
	
	private void insertItems(JComboBox input){
		input.addItem("");
		input.addItem(Movement.MOVE_LEFT);
		input.addItem(Movement.MOVE_RIGHT);
		input.addItem(Movement.MOVE_UP);
		input.addItem(Movement.MOVE_DOWN);
		input.addItem(Movement.MOVE_BACKWARDS);
		input.addItem(Movement.MOVE_FORWARDS);
		input.addItem(Movement.LOOK_LEFT);
		input.addItem(Movement.LOOK_RIGHT);
		input.addItem(Movement.LOOK_UP);
		input.addItem(Movement.LOOK_DOWN);
		input.addItem(Movement.ROTATE_CCW);
		input.addItem(Movement.ROTATE_CW);
	}
	
	private String getSymbol(int i){
		switch(i){
		case 65://a
			return("a");
		case 66://b
			return("b");
		case 67://c
			return("c");
		case 68://d
			return("d");
		case 69://e
			return("e");
		case 70://f
			return("f");
		case 71://g
			return("g");
		case 72://h
			return("h");
		case 73://i
			return("i");
		case 74://j
			return("j");
		case 75://k
			return("k");
		case 76://l
			return("l");
		case 77://m
			return("m");
		case 78://n
			return("n");
		case 79://o
			return("o");
		case 80://p
			return("p");
		case 81://q
			return("q");
		case 82://r
			return("r");
		case 83://s
			return("s");
		case 84://t
			return("t");
		case 85://u
			return("u");
		case 86://v
			return("v");
		case 87://w
			return("w");
		case 88://x
			return("x");
		case 89://y
			return("y");
		case 90://z
			return("z");
//==========================koniec abecedy					
		case 16://shift
			return("shift");
		case 17://ctrl
			return("ctrl");
		case 18://alt
			return("alt");
		case 37://lava sipka
			return("left arrow");
		case 39://prava sipka
			return("right arrow");
		case 38://hore sipka
			return("up arrow");
		case 40://dole sipka
			return("down arrow");
		case 34://page down
			return("pg down");
		case 33://page up
			return("pg up");
		case 36://home
			return("home");
		case 35://end down
			return("end");
		case 32://medzernik
			return("space");
		case 92://\
			return("\\");
		case 44://,
			return(",");
		case 46://.
			return(".");
		case 47:///
			return("/");
		case 59://;
			return(";");
		case 129://'
			return("'");
		case 91://[
			return("[");
		case 93://]
			return("]");
		case 45://-
			return("-");
		case 61://=
			return("=");
		}
		return null;
	}
	private JComboBox getComboBoxMouse(int i){
		switch(i){
		case 991:
			return jComboBoxMouseLeft;
		case 992:
			return jComboBoxMouseRight;
		case 993:
			return jComboBoxMouseForwards;
		case 994:
			return jComboBoxMouseBackwards;
		}
		return null;
	}
	
	private void resetForm(){
		JTextFieldMoveLeft.setText("");
		JTextFieldMoveRight.setText("");
		JTextFieldMoveUp.setText("");
		JTextFieldMoveDown.setText("");
		JTextFieldMoveForwards.setText("");
		JTextFieldMoveBackwards.setText("");
		JTextFieldLookLeft.setText("");
		JTextFieldLookRight.setText("");
		JTextFieldLookUp.setText("");
		JTextFieldLookDown.setText("");
		JTextFieldRotateCCW.setText("");
		JTextFieldRotateCW.setText("");
		jComboBoxMouseLeft.setSelectedItem("");
		jComboBoxMouseRight.setSelectedItem("");
		jComboBoxMouseForwards.setSelectedItem("");
		jComboBoxMouseBackwards.setSelectedItem("");
	}
}
