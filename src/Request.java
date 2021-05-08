

public class Request {
	private int size;
	private double memoryUtilization;
	private int numHoles;
	
	public Request(int size, double memUtil) {
		this.size = size;
		this.memoryUtilization = memUtil;
		this.numHoles = 0;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public double getMemoryUtilization() {
		return memoryUtilization;
	}

	public void setMemoryUtilization(double memoryUtilization) {
		this.memoryUtilization = memoryUtilization;
	}
	
	public int getNumHoles() {
		return numHoles;
	}

	public void setNumHoles(int numHoles) {
		this.numHoles = numHoles;
	}

	public String toString() {
		return "Request [ Size: " + this.size +
				", Memory Utilization after request: " + this.memoryUtilization + 
				", Num Holes searched: " + this.numHoles + " ]";
	}
}
