package sk.fiit.remotefiit.app;

public class PositionData {

	private double accelerometerX;
	private double accelerometerY;
	private double accelerometerZ;
	
	private double gyroscopeX;
	private double gyroscopeY;
	private double gyroscopeZ;

	private double orientationX;
	private double orientationY;
	private double orientationZ;

	private double magneticFieldX;
	private double magneticFieldY;
	private double magneticFieldZ;
	
	private double proximity;

	public void setProximity(double proximity) {
		this.proximity = proximity;
	}

	public double getProximity() {
		return proximity;
	}

	public void setGyroscopeZ(double gyroscopeZ) {
		this.gyroscopeZ = gyroscopeZ;
	}

	public double getGyroscopeZ() {
		return gyroscopeZ;
	}

	public void setGyroscopeY(double gyroscopeY) {
		this.gyroscopeY = gyroscopeY;
	}

	public double getGyroscopeY() {
		return gyroscopeY;
	}

	public void setGyroscopeX(double gyroscopeX) {
		this.gyroscopeX = gyroscopeX;
	}

	public double getGyroscopeX() {
		return gyroscopeX;
	}

	public void setAccelerometerZ(double accelerometerZ) {
		this.accelerometerZ = accelerometerZ;
	}

	public double getAccelerometerZ() {
		return accelerometerZ;
	}

	public void setAccelerometerY(double accelerometerY) {
		this.accelerometerY = accelerometerY;
	}

	public double getAccelerometerY() {
		return accelerometerY;
	}

	public void setAccelerometerX(double accelerometerX) {
		this.accelerometerX = accelerometerX;
	}

	public double getAccelerometerX() {
		return accelerometerX;
	}

	public void setOrientationX(double orientationX) {
		this.orientationX = orientationX;
	}

	public double getOrientationX() {
		return orientationX;
	}

	public void setOrientationY(double orientationY) {
		this.orientationY = orientationY;
	}

	public double getOrientationY() {
		return orientationY;
	}

	public void setOrientationZ(double orientationZ) {
		this.orientationZ = orientationZ;
	}

	public double getOrientationZ() {
		return orientationZ;
	}

	public void setMagneticFieldX(double magneticFieldX) {
		this.magneticFieldX = magneticFieldX;
	}

	public double getMagneticFieldX() {
		return magneticFieldX;
	}

	public void setMagneticFieldY(double magneticFieldY) {
		this.magneticFieldY = magneticFieldY;
	}

	public double getMagneticFieldY() {
		return magneticFieldY;
	}

	public void setMagneticFieldZ(double magneticFieldZ) {
		this.magneticFieldZ = magneticFieldZ;
	}

	public double getMagneticFieldZ() {
		return magneticFieldZ;
	}
}
