package sk.fiit.remotefiit.control;

import java.net.DatagramPacket;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import sk.fiit.remotefiit.app.JSONParser;
import sk.fiit.remotefiit.app.Movement;

public class PacketProcessing implements Runnable {
	private VRControl control = new VRControl();
	private JSONParser jsonParser = new JSONParser();
	private final int delay = 80;
	private final int delay_1 = 50;
	private final int delay_2 = 30;
	private DatagramPacket receivePacket;
	
	@Override
	public void run() {
		try {
			String receivedMessage = new String(receivePacket.getData());
			System.out.println("RECEIVED: " + receivedMessage);
			JSONObject obj;
			obj = new JSONObject(receivedMessage);
			List<Movement> movements = jsonParser.parse(obj);
			if(movements!=null && movements.size()!=0){
				for(Movement item : movements){
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
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void setDatagramPacket(DatagramPacket receivePacket){
		this.receivePacket = receivePacket;
	}

}
