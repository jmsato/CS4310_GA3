
public class Test {

	public static void main(String[] args) {
		int n = 10;
		Simulation sm = new Simulation(1, 3, n);
		//sm.initializePhysicalMemory (n);
		sm.printPhysicalMemory();
		System.out.println("first fit");
		sm.runSimulationFirstFit();
		//int[] deallocated = sm.randomDeallocation (n);
		//for(Integer i: deallocated) {
    	//	System.out.print(i+ " ");  		
    	//}
		//sm.shiftZero();
		
		
	}
}