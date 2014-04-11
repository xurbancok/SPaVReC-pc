package sk.fiit.remotefiit.control;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;

import sk.fiit.remotefiit.app.Movement;

public class MouseEvents implements Runnable {

	private Movement movement;

	public MouseEvents(Movement movement) {
		this.movement = movement;
	}

	@Override
	public void run() {
		Robot robot;
		try {
			robot = new Robot();
			Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			int x = (int) (dimension.getWidth() / 2);
			int y = (int) (dimension.getHeight() / 2);
			robot.mouseMove(x, y);
			robot.mousePress(InputEvent.BUTTON1_MASK);
			for (int i = 0; i < 4; i++) {
				switch (movement) {
				case MOUSE_LEFT:
					robot.mouseMove(x-(i*10), y);
					Thread.sleep(20);
					break;
				case MOUSE_RIGHT:
					robot.mouseMove(x+(i*10), y);
					Thread.sleep(20);
					break;

				case MOUSE_UP:
					robot.mouseMove(x, y-(i*10));
					Thread.sleep(20);
					break;

				case MOUSE_DOWN:
					robot.mouseMove(x, y+(i*10));
					Thread.sleep(20);
					break;
				}
			}
			robot.mouseRelease(InputEvent.BUTTON1_MASK);

		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
