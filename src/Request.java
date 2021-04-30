
public class Request {
	private int size;
	private double memoryUtilization;
	
	public Request(int size, double memUtil) {
		this.size = size;
		this.memoryUtilization = memUtil;
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
	
	public String toString() {
		return "Request [ Size: " + this.size +
				", Memory Utilization when requesting: " + this.memoryUtilization + " ]";
	}
}
