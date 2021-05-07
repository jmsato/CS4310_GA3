
public class Test {

	public static void main(String[] args) {
		int []test ={1, 1, 1, 1, 1}; 
		Simulation sim = new Simulation(test);
		sim.printPhysicalMemory();
		sim.setLastIndex(4);
		sim.release(4);
		sim.printPhysicalMemory();
		sim.release(0);
		sim.printPhysicalMemory();
		sim.release(1);
		sim.printPhysicalMemory();
		sim.release(1);
		sim.printPhysicalMemory();
		sim.release(1);
		sim.printPhysicalMemory();

		
	}
}