package sk.fiit.remotefiit.control;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import sk.fiit.remotefiit.interfaces.Control;

public class VRControl implements Control{
	private final static Logger LOGGER = Logger.getLogger(VRControl.class.getName());
	static private FileHandler logFile;
	static private SimpleFormatter textFormatter;
	private Robot robot;

	public VRControl() {
		try {
			robot = new Robot();
			
			LOGGER.setLevel(Level.INFO);
			logFile = new FileHandler("log "	+ new Date().toString().replaceAll(":", "") + ".txt");
			textFormatter = new SimpleFormatter();
			logFile.setFormatter(textFormatter);
			LOGGER.addHandler(logFile);
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void moveBackward(final int delay) {
		Runnable task = new Runnable() {
			@Override
			public void run() {
				try {
					robot.keyPress(40);
					robot.delay(delay);
					robot.keyRelease(40);
					LOGGER.info("moveBackward "+delay);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		};
		new Thread(task, "ServiceThread").start();
	}
	
	@Override
	public void moveForward(final int delay) {
		Runnable task = new Runnable() {
			@Override
			public void run() {
				try {
					robot.keyPress(38);
					robot.delay(delay);
					robot.keyRelease(38);
					LOGGER.info("moveForward "+delay);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		};
		new Thread(task, "ServiceThread").start();
	}
	
	@Override
	public void lookLeft(final int delay) {
		Runnable task = new Runnable() {
			@Override
			public void run() {
				try {
					robot.keyPress(37);
					robot.delay(delay);
					robot.keyRelease(37);
					LOGGER.info("lookLeft "+delay);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		};
		new Thread(task, "ServiceThread").start();
	}
	
	@Override
	public void lookRight(final int delay) {
		Runnable task = new Runnable() {
			@Override
			public void run() {
				try {
					robot.keyPress(39);
					robot.delay(delay);
					robot.keyRelease(39);
					LOGGER.info("lookRight "+delay);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		};
		new Thread(task, "ServiceThread").start();
	}
	
	@Override
	public void moveLeft(final int delay) {
		Runnable task = new Runnable() {
			@Override
			public void run() {
				try {
					robot.keyPress(65);
					robot.delay(delay);
					robot.keyRelease(65);
					LOGGER.info("moveLeft "+delay);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		};
		new Thread(task, "ServiceThread").start();
	}
	
	@Override
	public void moveRight(final int delay) {
		Runnable task = new Runnable() {
			@Override
			public void run() {
				try {
					robot.keyPress(68);
					robot.delay(delay);
					robot.keyRelease(68);
					LOGGER.info("moveRight "+delay);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		};
		new Thread(task, "ServiceThread").start();
	}
	
	@Override
	public void moveUp(final int delay) {
		Runnable task = new Runnable() {
			@Override
			public void run() {
				try {
					robot.keyPress(32);
					robot.delay(delay);
					robot.keyRelease(32);
					LOGGER.info("moveUp "+delay);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		};
		new Thread(task, "ServiceThread").start();
	}
	
	@Override
	public void moveDown(final int delay) {
		Runnable task = new Runnable() {
			@Override
			public void run() {
				try {
					robot.keyPress(17);
					robot.delay(delay);
					robot.keyRelease(17);
					LOGGER.info("moveDown "+delay);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		};
		new Thread(task, "ServiceThread").start();
	}

	@Override
	public void lookDown(final int delay) {
		Runnable task = new Runnable() {
			@Override
			public void run() {
				try {
					robot.keyPress(34);
					robot.delay(delay);
					robot.keyRelease(34);
					LOGGER.info("lookDown "+delay);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		};
		new Thread(task, "ServiceThread").start();
	}

	@Override
	public void lookUp(final int delay) {
		Runnable task = new Runnable() {
			@Override
			public void run() {
				try {
					robot.keyPress(33);
					robot.delay(delay);
					robot.keyRelease(33);
					LOGGER.info("lookUp "+delay);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		};
		new Thread(task, "ServiceThread").start();
	}
}
