package sk.fiit.remotefiit.control;

import java.awt.AWTException;
import java.awt.Robot;

import sk.fiit.remotefiit.interfaces.Control;

public class VRControl implements Control{

	private Robot robot;
	private final int delay = 100;

	public VRControl() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void moveBackward() {
		robot.keyPress(40);
		robot.delay(delay);
		robot.keyRelease(40);
	}
	
	@Override
	public void moveForward() {
		robot.keyPress(38);
		robot.delay(delay);
		robot.keyRelease(38);
	}
	
	@Override
	public void lookLeft() {
		robot.keyPress(37);
		robot.delay(delay);
		robot.keyRelease(37);
	}
	
	@Override
	public void lookRight() {
		robot.keyPress(39);
		robot.delay(delay);
		robot.keyRelease(39);
	}
	
	@Override
	public void moveLeft() {
		robot.keyPress(65);
		robot.delay(delay);
		robot.keyRelease(65);
	}
	
	@Override
	public void moveRight() {
		robot.keyPress(68);
		robot.delay(delay);
		robot.keyRelease(68);
	}
	
	@Override
	public void moveUp() {
		robot.keyPress(32);
		robot.delay(delay);
		robot.keyRelease(32);
	}
	
	@Override
	public void moveDown() {
		robot.keyPress(17);
		robot.delay(delay);
		robot.keyRelease(17);
	}

	@Override
	public void lookDown() {
		// TODO Auto-generated method stub
	}

	@Override
	public void lookUp() {
		// TODO Auto-generated method stub
	}
}
