
public class Test {

	public static void main(String[] args) {
		int n = 10;
		int[] arr={2, 2, -2, 4, 0,0,0,0,0,0};
		Simulation sm = new Simulation(arr);
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