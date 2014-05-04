package sk.fiit.remotefiit.server;

import java.io.IOException;
import java.lang.instrument.Instrumentation;
import java.net.*;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;

import sk.fiit.remotefiit.app.JSONParser;
import sk.fiit.remotefiit.app.Movement;
import sk.fiit.remotefiit.app.RemoteFiit;
import sk.fiit.remotefiit.control.PacketProcessing;
import sk.fiit.remotefiit.control.VRControl;
import sk.fiit.remotefiit.control.VRControlNew;

public class Server implements Runnable {

	private RemoteFiit application;
	private VRControlNew control;
	private JSONParser jsonParser;
	private final int delay = 1;
	private final int delay_1 = 1;
	private final int delay_2 = 1;
	
	private PacketProcessing packetProcessing;
	private Timer timer;
	private DatagramSocket serverSocket;

	public Server(RemoteFiit application, DatagramSocket serverSocket, Map<Movement, Integer> mapovanie){
		this.application = application;
		this.control = new VRControlNew(mapovanie);
		this.jsonParser = new JSONParser();
		this.serverSocket = serverSocket;
	}

	@Override
	public void run() {
		try {
			application.setPort(String.valueOf(serverSocket.getLocalPort()));
			byte receiveData[] = new byte[320];
			DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
			List<Movement> movements;
			JSONObject obj;
			while (true) {
				serverSocket.receive(receivePacket);
				String receivedMessage = new String(receivePacket.getData());
				System.out.println("RECEIVED: " + receivedMessage);
				//JSONObject obj = new JSONObject(receivedMessage);
				//packetProcessing = new PacketProcessing();
				//packetProcessing.setDatagramPacket(receivePacket);
				//packetProcessing.run();
				if(timer !=null){
					timer.cancel();
					timer = null;
				}
				obj = new JSONObject(receivedMessage);
				movements = jsonParser.parse(obj);
				if(movements!=null && movements.size()!=0){
					if(movements.contains(Movement.MOVE_LEFT)){
						control.moveLeft(1);
					}else{
						control.moveLeft(0);
					}
					if(movements.contains(Movement.MOVE_RIGHT)){
						control.moveRight(1);
					}else{
						control.moveRight(0);
					}
					if(movements.contains(Movement.MOVE_UP)){
						control.moveUp(1);
					}else{
						control.moveUp(0);
					}
					if(movements.contains(Movement.MOVE_DOWN)){
						control.moveDown(1);
					}else{
						control.moveDown(0);
					}
					if(movements.contains(Movement.MOVE_FORWARDS)){
						control.moveForward(1);
					}else{
						control.moveForward(0);
					}
					if(movements.contains(Movement.MOVE_BACKWARDS)){
						control.moveBackward(1);
					}else{
						control.moveBackward(0);
					}
					if(movements.contains(Movement.LOOK_LEFT)){
						control.lookLeft(1);
					}else{
						control.lookLeft(0);
					}
					if(movements.contains(Movement.LOOK_RIGHT)){
						control.lookRight(1);
					}else{
						control.lookRight(0);
					}
					if(movements.contains(Movement.LOOK_UP)){
						control.lookUp(1);
					}else{
						control.lookUp(0);
					}
					if(movements.contains(Movement.LOOK_DOWN)){
						control.lookDown(1);
					}else{
						control.lookDown(0);
					}
					if(movements.contains(Movement.ROTATE_CCW)){
						control.rotateCCW(1);
					}else{
						control.rotateCCW(0);
					}
					if(movements.contains(Movement.ROTATE_CW)){
						control.rotateCW(1);
					}else{
						control.rotateCW(0);
					}
				/*	for(Movement item : movements){
						switch(item){
						case LOOK_DOWN:
							control.lookDown(delay);
							break;
						case LOOK_UP:
							control.lookUp(delay);
							break;
						case LOOK_LEFT:
							control.lookLeft(delay);
							break;
						case LOOK_LEFT_1:
							control.lookLeft(delay_1);
							break;	
						case LOOK_LEFT_2:
							control.lookLeft(delay_2);
							break;
						case LOOK_RIGHT:
							control.lookRight(delay);
							break;
						case LOOK_RIGHT_1:
							control.lookRight(delay_1);
							break;
						case LOOK_RIGHT_2:
							control.lookRight(delay_2);
							break;
						case MOVE_BACKWARDS:
							control.moveBackward(delay);
							break;
						case MOVE_BACKWARDS_1:
							control.moveBackward(delay_1);
							break;
						case MOVE_BACKWARDS_2:
							control.moveBackward(delay_2);
							break;
						case MOVE_FORWARDS:
							control.moveForward(delay);
							break;
						case MOVE_FORWARDS_1:
							control.moveForward(delay_1);
							break;
						case MOVE_FORWARDS_2:
							control.moveForward(delay_2);
							break;
						case MOVE_DOWN:
							control.moveDown(delay);
							break;
						case MOVE_DOWN_1:
							control.moveDown(delay_1);
							break;
						case MOVE_DOWN_2:
							control.moveDown(delay_2);
							break;
						case MOVE_UP:
							control.moveUp(delay);
							break;
						case MOVE_UP_1:
							control.moveUp(delay_1);
							break;
						case MOVE_UP_2:
							control.moveUp(delay_2);
							break;
						case MOVE_LEFT:
							control.moveLeft(delay);
							break;
						case MOVE_LEFT_1:
							control.moveLeft(delay_1);
							break;
						case MOVE_LEFT_2:
							control.moveLeft(delay_2);
							break;
						case MOVE_RIGHT:
							control.moveRight(delay);
							break;
						case MOVE_RIGHT_1:
							control.moveRight(delay_1);
							break;
						case MOVE_RIGHT_2:
							control.moveRight(delay_2);
							break;
						}
					}
					*/
				}
				
				timer = new Timer();
				timer.schedule(new TimerTask() {
					  @Override
					  public void run() {
					    control.reset();
					  }
					}, 110);
/*
				extendedFunction = obj.getBoolean("EF");
				resultData.setProximity(obj.getDouble("Proximity"));

				resultData.setAccelerometerX(obj.getJSONObject("Accelerometer").getDouble("X"));
				resultData.setAccelerometerY(obj.getJSONObject("Accelerometer").getDouble("Y"));
				resultData.setAccelerometerZ(obj.getJSONObject("Accelerometer").getDouble("Z"));
				
				resultData.setGyroscopeX(obj.getJSONObject("Gyroscope").getDouble("X"));
				resultData.setGyroscopeY(obj.getJSONObject("Gyroscope").getDouble("Y"));
				resultData.setGyroscopeZ(obj.getJSONObject("Gyroscope").getDouble("Z"));
				
				resultData.setOrientationX(obj.getJSONObject("Orientation").getDouble("X"));
				resultData.setOrientationY(obj.getJSONObject("Orientation").getDouble("Y"));
				resultData.setOrientationZ(obj.getJSONObject("Orientation").getDouble("Z"));
				
				resultData.setMagneticFieldX(obj.getJSONObject("Magnetic_field").getDouble("X"));
				resultData.setMagneticFieldY(obj.getJSONObject("Magnetic_field").getDouble("Y"));
				resultData.setMagneticFieldZ(obj.getJSONObject("Magnetic_field").getDouble("Z"));
				
				if(obj.getBoolean("reset")==true)startPosition=null;
				if(startPosition == null){
					startPosition = new PositionData();
					startPosition.setOrientationX(obj.getJSONObject("Orientation").getDouble("X"));
					startPosition.setOrientationY(obj.getJSONObject("Orientation").getDouble("Y"));
				}
				
				application.setProximityValue(Double.toString(resultData.getProximity()));
				application.setAcceleratorValue(Double.toString(resultData.getAccelerometerX()), 
						Double.toString(resultData.getAccelerometerY()), 
						Double.toString(resultData.getAccelerometerZ()));
				application.setGyroscopeValue(Double.toString(resultData.getGyroscopeX()), 
						Double.toString(resultData.getGyroscopeY()), 
						Double.toString(resultData.getGyroscopeZ()));
				application.setOrientatonValue(Double.toString(resultData.getOrientationX()), 
						Double.toString(resultData.getOrientationY()), 
						Double.toString(resultData.getOrientationZ()));
				application.setMagneticFieldValue(Double.toString(resultData.getMagneticFieldX()), 
						Double.toString(resultData.getMagneticFieldY()), 
						Double.toString(resultData.getMagneticFieldZ()));
				receivedMessage = null;
				obj = null;
				
				if(resultData.getAccelerometerY() < -1){
					if (extendedFunction == false)control.pressForward();
					else control.pressDOWN();
				}
				if(resultData.getAccelerometerY() > 4){
					if (extendedFunction == false)control.pressBackward();
					else control.pressUP();
				}
				if(resultData.getAccelerometerX() > 3){
					control.pressSidestepLeft();
				}
				if(resultData.getAccelerometerX() < -3){
					control.pressSidestepRight();
				}	
				if(startPosition.getOrientationX()<=60 || startPosition.getOrientationX()>=300){
					
					if(resultData.getOrientationX()>60 && resultData.getOrientationX()<300 ){
						return;
					}
					
					if(startPosition.getOrientationX()>=0 && startPosition.getOrientationX()<=60){
						if(resultData.getOrientationX()>=300){
							resultData.setOrientationX(resultData.getOrientationX()-360);
						}
						if(resultData.getOrientationX() > (startPosition.getOrientationX()+20) && 
								resultData.getAccelerometerX() <=3 && resultData.getAccelerometerX() >= -3){
							control.pressKeyArrowRight();
						}
						if(resultData.getOrientationX() < (startPosition.getOrientationX()-20) && 
								resultData.getAccelerometerX() <=3 && resultData.getAccelerometerX() >= -3){
							System.out.println("vlavo");
							control.pressKeyArrowLeft();
						}
					}else{
						if(resultData.getOrientationX()<=60)resultData.setOrientationX(resultData.getOrientationX()+360);
						if(resultData.getOrientationX() < (startPosition.getOrientationX()-15) && 
								resultData.getAccelerometerX() <=3 && resultData.getAccelerometerX() >= -3){
							control.pressKeyArrowLeft();
						}

						if(resultData.getOrientationX() > (startPosition.getOrientationX()+15) && 
								resultData.getAccelerometerX() <=3 && resultData.getAccelerometerX() >= -3){
							control.pressKeyArrowRight();
							}
					}
				}else{
					if(resultData.getOrientationX() > (startPosition.getOrientationX()+15) && 
							resultData.getAccelerometerX() <=3 && resultData.getAccelerometerX() >= -3){
						control.pressKeyArrowRight();
					}
					if(resultData.getOrientationX() < (startPosition.getOrientationX()-15) && 
							resultData.getAccelerometerX() <=3 && resultData.getAccelerometerX() >= -3){
						control.pressKeyArrowLeft();
					}
				}
*/

			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}