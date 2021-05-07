

import java.util.*;

public class Simulation {
    private int d; // Average request size
    private int v; // Standard deviation
    private int k; // Size of hole
    private int s; // Size of block
    private int numberOfSpaceOcupied;
    private int[] physicalMemory; // Physical memory in simulation
    private ArrayList<Integer> memUtil; 
    private ArrayList<Integer> numHoles;
 
    
    public Simulation(int d, int v){
        this.d = d;
        this.v = v;
        this.k = 0;
        this.s = 0;
        this.numberOfSpaceOcupied = 0;
        physicalMemory = null;
        memUtil = new ArrayList<Integer>();    
        numHoles = new ArrayList<Integer>();  
    }
    
    /** Initialize memory to contain a set of blocks of normally distributed sizes
     *  (using d and v) and placed randomly throughout the memory
     * 	@param n size of physical memory 
     */
    public void initializePhysicalMemory (int n) {
    	physicalMemory = new int[n];
    	physicalMemory[0] =-n; // 1 block has -n holes
    	for(int i=0; i<n; i++) {
    		physicalMemory[i] = getBlockSize(n);  
    		System.out.print(physicalMemory[i]+ " ");
    	}  
    }
    
    /** 
     *  Number of blocks to be deallocated 50% of n
     * */
    public int[] randomDeallocation (int n) {
    	Random random = new Random();
    	int numberOfBlocksToBeDeallocated = n/2;
    	Set<Integer> set = new HashSet<Integer>();
       	do {
    		set.add(random.nextInt(n-1)); // check for non-duplicates random index
    	}while (set.size()!= numberOfBlocksToBeDeallocated);
    	for(Integer i: set) {
    		int deallocated = physicalMemory[i]*-1;
    		physicalMemory[i] = deallocated;
      	}
      	return physicalMemory;
     }
    
    public void printPhysicalMemory (int[] arr) {
    	for(Integer i: arr) {
    		System.out.print(i+ " ");  		
    	}
    }
    
    /**
     * The method generates 's', the size of block which is generated at random from a normal (Gaussian) distribution.
     * Values less than 1 and greater than n - 1 are discarded.
     */
    public int getBlockSize (int n){
    	Random random = new Random();
    	int max = n-1;
         do {
            s = (int) (random.nextGaussian()*v+d);
        } while(s>max || s<=0); // discard negative/zero values and n-1 values
         return s;
    }
    
    /** 
     * The method generates the size of each hole which starts with a negative integer, -k, where the absolute value k
     * indicates the length of the hole. 
    */
    public int generateHoleSize (int n){
    	Random random = new Random();
    	int max = n-1;
        do {
            k = (int) (random.nextGaussian()*v+d);
        } while ( k>=0 || k>max);
        System.out.println(k);
        return k;
    }
     
    /**
     * Memory utilization is the ratio of space occupied by blocks divided by the total memory size n, and can vary from 0 to 1.
     */
    public int memoryUtilization(int n){
        return numberOfSpaceOcupied/n;        
    }
    
    
   
    
   
   
}
