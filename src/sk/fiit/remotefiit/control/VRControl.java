package sk.fiit.remotefiit.control;

import java.awt.AWTException;
import java.awt.Robot;

import sk.fiit.remotefiit.interfaces.Control;

public class VRControl implements Control{

	private Robot robot;

	public VRControl() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
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
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		};
		new Thread(task, "ServiceThread").start();
	}
}
