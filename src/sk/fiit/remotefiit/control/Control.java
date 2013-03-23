package sk.fiit.remotefiit.control;

import java.awt.AWTException;
import java.awt.Robot;

public class Control {

	private Robot robot;
	private final int delay = 100;

	public Control() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void pressBackward() {
		robot.keyPress(40);
		robot.delay(delay);
		robot.keyRelease(40);
	}

	public void pressForward() {
		robot.keyPress(38);
		robot.delay(delay);
		robot.keyRelease(38);
	}

	public void pressKeyArrowLeft() {
		robot.keyPress(37);
		robot.delay(delay);
		robot.keyRelease(37);
	}

	public void pressKeyArrowRight() {
		robot.keyPress(39);
		robot.delay(delay);
		robot.keyRelease(39);
	}
	public void pressSidestepLeft() {
		robot.keyPress(65);
		robot.delay(delay);
		robot.keyRelease(65);
	}
	public void pressSidestepRight() {
		robot.keyPress(68);
		robot.delay(delay);
		robot.keyRelease(68);
	}
	public void pressUP() {
		robot.keyPress(32);
		robot.delay(delay);
		robot.keyRelease(32);
	}
	public void pressDOWN() {
		robot.keyPress(17);
		robot.delay(delay);
		robot.keyRelease(17);
	}
}
