package sk.fiit.remotefiit.server;

import java.io.IOException;
import java.net.*;
import org.json.JSONException;
import org.json.JSONObject;

import sk.fiit.remotefiit.app.PositionData;
import sk.fiit.remotefiit.app.RemoteFiit;
import sk.fiit.remotefiit.control.Control;

public class Server implements Runnable {
	
	private int serverPort;
	private RemoteFiit application;
	private Control control;
	private PositionData startPosition;
	private boolean extendedFunction = false;
	
	public Server(int port, RemoteFiit application){
		this.serverPort = port;
		this.application = application;
		this.control = new Control();
	}

	@Override
	public void run() {
		DatagramSocket serverSocket;
		try {
			serverSocket = new DatagramSocket(serverPort);
			byte[] receiveData = new byte[320];
			DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
			
			while (true) {
				serverSocket.receive(receivePacket);
				String receivedMessage = new String(receivePacket.getData());
				//System.out.println("RECEIVED: " + receivedMessage);
				JSONObject obj = new JSONObject(receivedMessage);
				PositionData resultData = new PositionData();
				
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