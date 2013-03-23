package sk.fiit.remotefiit.app;

import sk.fiit.remotefiit.server.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.Point;
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

public class RemoteFiit {

	private JFrame jFrame = null;  //  @jve:decl-index=0:visual-constraint="10,10"
	private JPanel jContentPane = null;
	private JMenuBar jJMenuBar = null;
	private JMenu fileMenu = null;
	private JMenu editMenu = null;
	private JMenu helpMenu = null;
	private JMenuItem exitMenuItem = null;
	private JMenuItem aboutMenuItem = null;
	private JMenuItem serverMenuItem = null;
	private JDialog aboutDialog = null;  //  @jve:decl-index=0:visual-constraint="425,10"
	private JPanel aboutContentPane = null;
	private JLabel aboutVersionLabel = null;
	private JButton jButtonStart = null;
	private JButton jButton1 = null;
	private JDialog jDialogServer = null;  //  @jve:decl-index=0:visual-constraint="419,67"
	private JPanel jContentPane1 = null;
	private JLabel jLabel = null;
	private JTextField jTextField = null;
	private JButton jButton2 = null;
	private JLabel jLabelAcce = null;
	private JLabel jLabelGyro = null;
	private JLabel jLabelMagnet = null;
	private JLabel jLabelProximity = null;
	private JLabel jLabelAcceX = null;
	private JLabel jLabelAcceY = null;
	private JLabel jLabelAcceZ = null;
	private JLabel jLabelGyroX = null;
	private JLabel jLabelGyroY = null;
	private JLabel jLabelGyroZ = null;
	private JLabel jLabelOrientX = null;
	private JLabel jLabelOrientY = null;
	private JLabel jLabelOrientZ = null;
	private JLabel jLabelProximitValue = null;
	private JLabel jLabelServerInfo = null;
	private JLabel jLabelAcceXValue = null;
	private JLabel jLabelAcceYValue = null;
	private JLabel jLabelAcceZValue = null;
	private JLabel jLabelGyroXValue = null;
	private JLabel jLabelGyroYValue = null;
	private JLabel jLabelGyroZValue = null;
	private JLabel jLabelOrientationXValue = null;
	private JLabel jLabelOrientationYValue = null;
	private JLabel jLabelOrientationZValue = null;
	private Thread server = null;
	private JButton jButtonStop = null;
	private int serverPort = 9876;
	private JLabel jLabelMagneticField = null;
	private JLabel jLabelMagnetX = null;
	private JLabel jLabelMagnetY = null;
	private JLabel jLabelMagnetZ = null;
	private JLabel jLabelMagnetXValue = null;
	private JLabel jLabelMagnetYValue = null;
	private JLabel jLabelMagnetZValue = null;
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
		try {
			jLabelServerInfo.setText("Your IP: "+InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			jLabelServerInfo.setText("<html><font color='red'>!!! Unknown host !!!</font></html>");
			jButtonStart.setEnabled(false);
			e.printStackTrace();
		}
	}
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelMagnetZValue = new JLabel();
			jLabelMagnetZValue.setBounds(new Rectangle(325, 140, 60, 20));
			jLabelMagnetZValue.setText("");
			jLabelMagnetYValue = new JLabel();
			jLabelMagnetYValue.setBounds(new Rectangle(325, 115, 60, 20));
			jLabelMagnetYValue.setText("");
			jLabelMagnetXValue = new JLabel();
			jLabelMagnetXValue.setBounds(new Rectangle(325, 90, 60, 20));
			jLabelMagnetXValue.setText("");
			jLabelMagnetZ = new JLabel();
			jLabelMagnetZ.setBounds(new Rectangle(305, 140, 15, 20));
			jLabelMagnetZ.setText("Z:");
			jLabelMagnetY = new JLabel();
			jLabelMagnetY.setBounds(new Rectangle(305, 115, 15, 20));
			jLabelMagnetY.setText("Y:");
			jLabelMagnetX = new JLabel();
			jLabelMagnetX.setBounds(new Rectangle(305, 90, 15, 20));
			jLabelMagnetX.setText("X:");
			jLabelMagneticField = new JLabel();
			jLabelMagneticField.setBounds(new Rectangle(200, 90, 100, 20));
			jLabelMagneticField.setText("Magnetic field");
			jLabelOrientationZValue = new JLabel();
			jLabelOrientationZValue.setBounds(new Rectangle(325, 55, 60, 20));
			jLabelOrientationYValue = new JLabel();
			jLabelOrientationYValue.setBounds(new Rectangle(325, 30, 60, 20));
			jLabelOrientationXValue = new JLabel();
			jLabelOrientationXValue.setBounds(new Rectangle(325, 5, 60, 20));
			jLabelGyroZValue = new JLabel();
			jLabelGyroZValue.setBounds(new Rectangle(125, 140, 60, 20));
			jLabelGyroYValue = new JLabel();
			jLabelGyroYValue.setBounds(new Rectangle(125, 115, 60, 20));
			jLabelGyroXValue = new JLabel();
			jLabelGyroXValue.setBounds(new Rectangle(125, 90, 60, 20));
			jLabelAcceZValue = new JLabel();
			jLabelAcceZValue.setBounds(new Rectangle(125, 55, 60, 20));
			jLabelAcceYValue = new JLabel();
			jLabelAcceYValue.setBounds(new Rectangle(125, 30, 60, 20));
			jLabelAcceXValue = new JLabel();
			jLabelAcceXValue.setBounds(new Rectangle(125, 5, 60, 20));
			jLabelServerInfo = new JLabel();
			jLabelServerInfo.setBounds(new Rectangle(7, 197, 163, 25));
			jLabelProximitValue = new JLabel();
			jLabelProximitValue.setBounds(new Rectangle(110, 165, 60, 20));
			jLabelOrientZ = new JLabel();
			jLabelOrientZ.setBounds(new Rectangle(305, 55, 15, 20));
			jLabelOrientZ.setText("Z:");
			jLabelOrientY = new JLabel();
			jLabelOrientY.setBounds(new Rectangle(305, 30, 15, 20));
			jLabelOrientY.setText("Y:");
			jLabelOrientX = new JLabel();
			jLabelOrientX.setBounds(new Rectangle(305, 5, 15, 20));
			jLabelOrientX.setText("X:");
			jLabelGyroZ = new JLabel();
			jLabelGyroZ.setBounds(new Rectangle(110, 140, 15, 20));
			jLabelGyroZ.setText("Z:");
			jLabelGyroY = new JLabel();
			jLabelGyroY.setBounds(new Rectangle(110, 115, 15, 20));
			jLabelGyroY.setText("Y:");
			jLabelGyroX = new JLabel();
			jLabelGyroX.setBounds(new Rectangle(110, 90, 15, 20));
			jLabelGyroX.setText("X:");
			jLabelAcceZ = new JLabel();
			jLabelAcceZ.setBounds(new Rectangle(110, 55, 15, 20));
			jLabelAcceZ.setText("Z:");
			jLabelAcceY = new JLabel();
			jLabelAcceY.setBounds(new Rectangle(110, 30, 15, 20));
			jLabelAcceY.setText("Y:");
			jLabelAcceX = new JLabel();
			jLabelAcceX.setBounds(new Rectangle(110, 5, 15, 20));
			jLabelAcceX.setText("X:");
			jLabelProximity = new JLabel();
			jLabelProximity.setBounds(new Rectangle(5, 165, 100, 20));
			jLabelProximity.setText("Proximity sensor");
			jLabelMagnet = new JLabel();
			jLabelMagnet.setBounds(new Rectangle(200, 5, 100, 20));
			jLabelMagnet.setText("Orientation");
			jLabelGyro = new JLabel();
			jLabelGyro.setBounds(new Rectangle(5, 90,  100, 20));
			jLabelGyro.setText("Gyroscope");
			jLabelAcce = new JLabel();
			jLabelAcce.setBounds(new Rectangle(5, 5, 100, 20));
			jLabelAcce.setText("Accelerometer");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(jLabelAcce, null);
			jContentPane.add(jLabelGyro, null);
			jContentPane.add(jLabelMagnet, null);
			jContentPane.add(jLabelProximity, null);
			jContentPane.add(jLabelAcceX, null);
			jContentPane.add(jLabelAcceY, null);
			jContentPane.add(jLabelAcceZ, null);
			jContentPane.add(jLabelGyroX, null);
			jContentPane.add(jLabelGyroY, null);
			jContentPane.add(jLabelGyroZ, null);
			jContentPane.add(jLabelOrientX, null);
			jContentPane.add(jLabelOrientY, null);
			jContentPane.add(jLabelOrientZ, null);
			jContentPane.add(jLabelProximitValue, null);
			jContentPane.add(jLabelServerInfo, null);
			jContentPane.add(jLabelAcceXValue, null);
			jContentPane.add(jLabelAcceYValue, null);
			jContentPane.add(jLabelAcceZValue, null);
			jContentPane.add(jLabelGyroXValue, null);
			jContentPane.add(jLabelGyroYValue, null);
			jContentPane.add(jLabelGyroZValue, null);
			jContentPane.add(jLabelOrientationXValue, null);
			jContentPane.add(jLabelOrientationYValue, null);
			jContentPane.add(jLabelOrientationZValue, null);
			jContentPane.add(getJButtonPause(), null);
			jContentPane.add(jLabelMagneticField, null);
			jContentPane.add(jLabelMagnetX, null);
			jContentPane.add(jLabelMagnetY, null);
			jContentPane.add(jLabelMagnetZ, null);
			jContentPane.add(jLabelMagnetXValue, null);
			jContentPane.add(jLabelMagnetYValue, null);
			jContentPane.add(jLabelMagnetZValue, null);
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
			editMenu.add(getServerMenuItem());
		}
		return editMenu;
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
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getServerMenuItem() {
		if (serverMenuItem == null) {
			serverMenuItem = new JMenuItem();
			serverMenuItem.setText("Server");
			serverMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JDialog serverDialog = getServerDialog();
					serverDialog.setVisible(true);
					serverDialog.pack();
				}
			});
		}
		return serverMenuItem;
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
	 * This method initializes jDialog	
	 * 	
	 * @return javax.swing.JDialog	
	 */
	private JDialog getServerDialog() {
		if (jDialogServer == null) {
			jDialogServer = new JDialog(getJFrame(),true);
			jDialogServer.setSize(new Dimension(140, 100));
			jDialogServer.setTitle("Server");
			jDialogServer.setContentPane(getJContentPane1());
			jDialogServer.setLocationRelativeTo(jFrame);
			jDialogServer.setResizable(false);
			jDialogServer.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		}
		return jDialogServer;
	}

	/**
	 * This method initializes jContentPane1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane1() {
		if (jContentPane1 == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(20, 5, 35, 20));
			jLabel.setText("Port:");
			jContentPane1 = new JPanel();
			jContentPane1.setLayout(null);
			jContentPane1.add(jLabel, null);
			jContentPane1.add(getJTextField(), null);
			jContentPane1.add(getJButton2(), null);
		}
		return jContentPane1;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(60, 5, 45, 20));
			jTextField.setText(String.valueOf(serverPort));
		}
		return jTextField;
	}

	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new Rectangle(32, 32, 69, 28));
			jButton2.setText("Save");
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					serverPort = Integer.parseInt(jTextField.getText());
				}
			});
		}
		return jButton2;
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

	public void setAcceleratorValue(String x, String y, String z){
		jLabelAcceXValue.setText(x);
		jLabelAcceYValue.setText(y);
		jLabelAcceZValue.setText(z);
	}
	public void setGyroscopeValue(String x, String y, String z){
		jLabelGyroXValue.setText(x);
		jLabelGyroYValue.setText(y);
		jLabelGyroZValue.setText(z);
	}	
	public void setOrientatonValue(String x, String y, String z){
		jLabelOrientationXValue.setText(x);
		jLabelOrientationYValue.setText(y);
		jLabelOrientationZValue.setText(z);
	}
	public void setMagneticFieldValue(String x, String y, String z){
		jLabelMagnetXValue.setText(x);
		jLabelMagnetYValue.setText(y);
		jLabelMagnetZValue.setText(z);
	}
	public void setProximityValue(String x){
		jLabelProximitValue.setText(x);
	}
}
