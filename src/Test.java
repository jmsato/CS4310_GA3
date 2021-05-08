
public class Test {

	public static void main(String[] args) {
		Simulation sm = new Simulation(100, 50);
		int n = 10;
		sm.initializePhysicalMemory (n);
		int[] deallocated = sm.randomDeallocation (n);
		for(Integer i: deallocated) {
    		System.out.print(i+ " ");  		
    	}
		sm.shiftZero();
		
		
	}
}