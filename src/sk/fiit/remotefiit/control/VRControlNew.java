package sk.fiit.remotefiit.control;

import java.awt.Robot;
import java.util.Date;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import sk.fiit.remotefiit.app.Movement;
import sk.fiit.remotefiit.interfaces.Control;

public class VRControlNew implements Control {
	private static Logger LOGGER = Logger.getLogger(VRControl.class.getName());
	static private FileHandler logFile;
	static private SimpleFormatter textFormatter;
	private Robot robot;
	private Map<Movement, Integer> mapovanie;
	
	private double moveFTime, moveBTime, moveLTime, moveRTime, moveUTime,
			moveDTime, lookLTime, lookRTime, lookUTime, lookDTime;

	public VRControlNew(Map<Movement, Integer> mapovanie) {
		try {
			this.mapovanie = mapovanie;
			robot = new Robot();
			LOGGER.setLevel(Level.INFO);
			logFile = new FileHandler("log "
					+ new Date().toString().replaceAll(":", "") + ".txt");
			textFormatter = new SimpleFormatter();
			logFile.setFormatter(textFormatter);
			LOGGER.addHandler(logFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void moveBackward(int delay) {
		if (delay == 1){
			if(mapovanie.containsKey(Movement.MOVE_BACKWARDS)){
				if(mapovanie.get(Movement.MOVE_BACKWARDS)>900){
					
				}else{
					robot.keyPress(mapovanie.get(Movement.MOVE_BACKWARDS));
					LOGGER.info("moveBackward");
				}
			}
//			robot.keyPress(40);
//			LOGGER.info("moveBackward");
		}
		else {
			if(mapovanie.containsKey(Movement.MOVE_BACKWARDS)){
				if(mapovanie.get(Movement.MOVE_BACKWARDS)>900){
					
				}else{
					robot.keyRelease(mapovanie.get(Movement.MOVE_BACKWARDS));
				}
			}
			//robot.keyRelease(40);
			//LOGGER.info("moveBackward " + delay);
		}
	}

	@Override
	public void moveForward(int delay) {
		if (delay == 1){
			if(mapovanie.containsKey(Movement.MOVE_FORWARDS)){
				if(mapovanie.get(Movement.MOVE_FORWARDS)>900){
					
				}else{
					robot.keyPress(mapovanie.get(Movement.MOVE_FORWARDS));
					LOGGER.info("moveForward");
				}
			}
			//robot.keyPress(38);
			//LOGGER.info("moveForward");
			}
		else{
			if(mapovanie.containsKey(Movement.MOVE_FORWARDS)){
				if(mapovanie.get(Movement.MOVE_FORWARDS)>900){
					
				}else{
					robot.keyRelease(mapovanie.get(Movement.MOVE_FORWARDS));
				}
			}
			//robot.keyRelease(38);
			//LOGGER.info("moveForward " + delay);
		}
	}

	@Override
	public void lookLeft(int delay) {
		if (delay == 1){
			if(mapovanie.containsKey(Movement.LOOK_LEFT)){
				if(mapovanie.get(Movement.LOOK_LEFT)>900){
					switch(mapovanie.get(Movement.LOOK_LEFT)){
					case 991:
						new Thread(new MouseEvents(Movement.MOUSE_LEFT)).start();
						break;
					case 992:
						new Thread(new MouseEvents(Movement.MOUSE_RIGHT)).start();
						break;
					case 993:
						new Thread(new MouseEvents(Movement.MOUSE_UP)).start();
						break;
					case 994:
						new Thread(new MouseEvents(Movement.MOUSE_DOWN)).start();
						break;
					}
				}else{
					robot.keyPress(mapovanie.get(Movement.LOOK_LEFT));
					LOGGER.info("lookLeft");
				}
			}
		//	robot.keyPress(37);
		//	LOGGER.info("lookLeft");
		}
		else {
			if(mapovanie.containsKey(Movement.LOOK_LEFT)){
				if(mapovanie.get(Movement.LOOK_LEFT)>900){
	
				}else{
					robot.keyRelease(mapovanie.get(Movement.LOOK_LEFT));
				}
			}
			//robot.keyRelease(37);
			//LOGGER.info("lookLeft " + delay);
		}
	}

	@Override
	public void lookRight(int delay) {
		if (delay == 1){
			if(mapovanie.containsKey(Movement.LOOK_RIGHT)){
				if(mapovanie.get(Movement.LOOK_RIGHT)>900){
					switch(mapovanie.get(Movement.LOOK_RIGHT)){
					case 991:
						new Thread(new MouseEvents(Movement.MOUSE_LEFT)).start();
						break;
					case 992:
						new Thread(new MouseEvents(Movement.MOUSE_RIGHT)).start();
						break;
					case 993:
						new Thread(new MouseEvents(Movement.MOUSE_UP)).start();
						break;
					case 994:
						new Thread(new MouseEvents(Movement.MOUSE_DOWN)).start();
						break;
					}
				}else{
					robot.keyPress(mapovanie.get(Movement.LOOK_RIGHT));
					LOGGER.info("lookRight");
				}
			}
			//robot.keyPress(39);
			//LOGGER.info("lookRight");
		}
		else {
			if(mapovanie.containsKey(Movement.LOOK_RIGHT)){
				if(mapovanie.get(Movement.LOOK_RIGHT)>900){
	
				}else{
					robot.keyRelease(mapovanie.get(Movement.LOOK_RIGHT));
				}
			}
			//robot.keyRelease(39);
			//LOGGER.info("lookRight " + delay);
		}
	}

	@Override
	public void moveLeft(int delay) {
		if (delay == 1){
			if(mapovanie.containsKey(Movement.MOVE_LEFT)){
				if(mapovanie.get(Movement.MOVE_LEFT)>900){
	
				}else{
					robot.keyPress(mapovanie.get(Movement.MOVE_LEFT));
					LOGGER.info("moveLeft");
				}
			}
		//	robot.keyPress(65);
		//	LOGGER.info("moveLeft");
		}
		else {
			if(mapovanie.containsKey(Movement.MOVE_LEFT)){
				if(mapovanie.get(Movement.MOVE_LEFT)>900){
	
				}else{
					robot.keyRelease(mapovanie.get(Movement.MOVE_LEFT));
				}
			}
			//robot.keyRelease(65);
			//LOGGER.info("moveLeft " + delay);
		}
	}

	@Override
	public void moveRight(int delay) {
		if (delay == 1){
			if(mapovanie.containsKey(Movement.MOVE_RIGHT)){
				if(mapovanie.get(Movement.MOVE_RIGHT)>900){
	
				}else{
					robot.keyPress(mapovanie.get(Movement.MOVE_RIGHT));
					LOGGER.info("moveRight");
				}
			}
			//robot.keyPress(68);
			//LOGGER.info("moveRight");
			}
		else {
			if(mapovanie.containsKey(Movement.MOVE_RIGHT)){
				if(mapovanie.get(Movement.MOVE_RIGHT)>900){
	
				}else{
					robot.keyRelease(mapovanie.get(Movement.MOVE_RIGHT));
				}
			}
			//robot.keyRelease(68);
			//LOGGER.info("moveRight " + delay);
		}
	}

	@Override
	public void moveUp(int delay) {
		if (delay == 1){
			if(mapovanie.containsKey(Movement.MOVE_UP)){
				if(mapovanie.get(Movement.MOVE_UP)>900){
	
				}else{
					robot.keyPress(mapovanie.get(Movement.MOVE_UP));
					LOGGER.info("moveUp");
				}
			}
			//LOGGER.info("moveUp");
			//robot.keyPress(32);
			}
		else {
			if(mapovanie.containsKey(Movement.MOVE_UP)){
				if(mapovanie.get(Movement.MOVE_UP)>900){
	
				}else{
					robot.keyRelease(mapovanie.get(Movement.MOVE_UP));
				}
			}
			//robot.keyRelease(32);
			//LOGGER.info("moveUp " + delay);
		}
	}

	@Override
	public void moveDown(int delay) {
		if (delay == 1){
			if(mapovanie.containsKey(Movement.MOVE_DOWN)){
				if(mapovanie.get(Movement.MOVE_DOWN)>900){
	
				}else{
					robot.keyPress(mapovanie.get(Movement.MOVE_DOWN));
					LOGGER.info("moveDown");
				}
			}
			//LOGGER.info("moveDown " );
			//robot.keyPress(17);
			}
		else {
			if(mapovanie.containsKey(Movement.MOVE_DOWN)){
				if(mapovanie.get(Movement.MOVE_DOWN)>900){
	
				}else{
					robot.keyRelease(mapovanie.get(Movement.MOVE_DOWN));
				}
			}
			//robot.keyRelease(17);
			//LOGGER.info("moveDown " + delay);
		}
	}

	@Override
	public void lookDown(int delay) {
		if (delay == 1){
			if(mapovanie.containsKey(Movement.LOOK_DOWN)){
				if(mapovanie.get(Movement.LOOK_DOWN)>900){
					switch(mapovanie.get(Movement.LOOK_DOWN)){
					case 991:
						new Thread(new MouseEvents(Movement.MOUSE_LEFT)).start();
						break;
					case 992:
						new Thread(new MouseEvents(Movement.MOUSE_RIGHT)).start();
						break;
					case 993:
						new Thread(new MouseEvents(Movement.MOUSE_UP)).start();
						break;
					case 994:
						new Thread(new MouseEvents(Movement.MOUSE_DOWN)).start();
						break;
					}
				}else{
					robot.keyPress(mapovanie.get(Movement.LOOK_DOWN));
					LOGGER.info("lookDown");
				}
			}
			//robot.keyPress(34);
			//LOGGER.info("lookDown");
		}
		else {
			if(mapovanie.containsKey(Movement.LOOK_DOWN)){
				if(mapovanie.get(Movement.LOOK_DOWN)>900){
	
				}else{
					robot.keyRelease(mapovanie.get(Movement.LOOK_DOWN));
				}
			}
			//robot.keyRelease(34);
			//LOGGER.info("lookDown " + delay);
		}
	}

	@Override
	public void lookUp(int delay) {
		if (delay == 1){
			if(mapovanie.containsKey(Movement.LOOK_UP)){
				if(mapovanie.get(Movement.LOOK_UP)>900){
					switch(mapovanie.get(Movement.LOOK_UP)){
					case 991:
						new Thread(new MouseEvents(Movement.MOUSE_LEFT)).start();
						break;
					case 992:
						new Thread(new MouseEvents(Movement.MOUSE_RIGHT)).start();
						break;
					case 993:
						new Thread(new MouseEvents(Movement.MOUSE_UP)).start();
						break;
					case 994:
						new Thread(new MouseEvents(Movement.MOUSE_DOWN)).start();
						break;
					}
				}else{
					robot.keyPress(mapovanie.get(Movement.LOOK_UP));
					LOGGER.info("lookUp");
				}
			}
			//robot.keyPress(33);
			//LOGGER.info("lookUp");
			}
		else {
			if(mapovanie.containsKey(Movement.LOOK_UP)){
				if(mapovanie.get(Movement.LOOK_UP)>900){

				}else{
					robot.keyRelease(mapovanie.get(Movement.LOOK_UP));
				}
			}
			//robot.keyRelease(33);
			//LOGGER.info("lookUp " + delay);
		}
	}

	public void reset(){
		robot.keyRelease(40);
		robot.keyRelease(38);
		robot.keyRelease(37);
		robot.keyRelease(39);
		robot.keyRelease(65);
		robot.keyRelease(68);
		robot.keyRelease(32);
		robot.keyRelease(17);
		robot.keyRelease(34);
		robot.keyRelease(33);
	}
}
