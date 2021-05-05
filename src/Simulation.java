

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
    
    /**
     * @param n size of physical memory */
    public void initializeSimulation (int n) {
    	physicalMemory = new int[n];
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
        } while(s>max && s<=0); // discard negative/zero values and n-1 values
         System.out.println(s);
         return s;
    }
    
    /** 
     * The method generates the size of each hole which starts with a negative integer, -k, where the absolute value k
     * indicates the length of the hole. 
    */
    public int generateHoleSize (){
    	Random random = new Random();
        do {
            k = (int) (random.nextGaussian()*v+d);
        } while ( k>=0 );
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
