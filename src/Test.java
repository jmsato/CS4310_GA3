
public class Test {

	public static void main(String[] args) {
		int n = 10;
		int[] arr={2, 2, -2, 4, 0,0,0,0,0,0};
		Simulation sm = new Simulation(arr);
		sm.setLastIndex(3);
		//sm.initializePhysicalMemory (n);
		sm.printPhysicalMemory();
		//System.out.println("first fit");
		//sm.runSimulationFirstFit();
		//int[] deallocated = sm.randomDeallocation (n);
		//for(Integer i: deallocated) {
    	//	System.out.print(i+ " ");  		
    	//}
		//sm.shiftZero();
		
		//TESTING THE REQUEST METHOD
		sm.request(new Request(1, 0.0), 2);
		sm.printPhysicalMemory();
		
		int[] beg = {-2, 2, -2, 4, 0,0,0,0,0,0};
		Simulation b = new Simulation(beg);
		b.setLastIndex(3);
		b.printPhysicalMemory();
		b.request(new Request(1, 0.0), 0);
		b.printPhysicalMemory();
		
		int[] end = {-2, 2, 2, -4, 0,0,0,0,0,0};
		Simulation e = new Simulation(end);
		e.setLastIndex(3);
		e.printPhysicalMemory();
		e.request(new Request(4, 0.0), 3);
		e.printPhysicalMemory();
	}
}