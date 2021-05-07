

import java.util.*;

public class Simulation {
    private int d; // Average request size
    private int v; // Standard deviation
    private int k; // Size of hole
    private int s; // Size of block
    private int numberOfSpaceOcupied;
    private static int[] physicalMemory; // Physical memory in simulation
    private int currentAllocations;
    private int holesAllocations;
 
    
    public Simulation(int d, int v){
        this.d = d;
        this.v = v;
        this.k = 0;
        this.s = 0;
        this.numberOfSpaceOcupied = 0;
        physicalMemory = null;
        this.currentAllocations = 0;
        this.holesAllocations = 0;
       
    }
    
    /** Initialize memory to contain a set of blocks of normally distributed sizes
     *  (using d and v) and placed randomly throughout the memory
     * 	@param n size of physical memory 
     */
    public void initializePhysicalMemory (int n) {
    	physicalMemory = new int[n];
    	physicalMemory[0] =-n; // 1 block has -n holes
    	for(int i=0; i<n; i++) {
    		physicalMemory[i] =  generateHoleSize(n);  
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
    	this.currentAllocations = n/2;
    	this.holesAllocations = n/2;
      	
    	return physicalMemory;
     }
    public int[] shiftZero() {
    	int j=0;
    	int n = physicalMemory.length;
    	for(int i=0; i<n; i++) {  	
    		if(physicalMemory[i]!=0) {   
    			int temp = physicalMemory[j];
    			physicalMemory[j] = physicalMemory[i];
    			physicalMemory[i] = temp;
    			j++; 			
    		}
    	}
    	System.out.println();
    	for(Integer i: physicalMemory) {
    		System.out.print(i + " ");
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
        } while (  k<0 || k>max); // generate the value of hole size is in the range of [0, n-1]
        System.out.println(k);
        return k;
    }
     
    /**
     * Memory utilization is the ratio of space occupied by blocks divided by the total memory size n, and can vary from 0 to 1.
     */
    public int getMemoryUtilization(int n){
        return numberOfSpaceOcupied/n;        
    }
    
    public int lastIndex(int[] arr) {

       // still working
     
        
       
    	
    	
    }
    public int[] runSimulationFirstFit(){
        int[] copyMemory= Simulation.physicalMemory.clone(); //since it's primitive, we can do this
          
    	  //currentAllocations, holesAllocations should be set in creation physicalMemory    										
        int totalMemoryUtilization=0;
        int totalNumberOfHolesSearched=0;  			 
        int numberOfRequestsFulfilled=0;				 
        
        int n = physicalMemory.length;
        while(true){ //repeat x times
          int s = getBlockSize(n); //s is the request size chosen from a normal distribution
          int memUtil = getMemoryUtilization(n);
         //TODO decide if this should go before or after creation of a new request (really just depends on s)
         if(currentAllocations+s <n) //repeat until request fails
             break;
         //TODO fix memUtil of request
         Request currentRequest=new Request(s, memUtil); //create a request of size s
                          
         //First Fit Search starts here
         int searchIndex=0;
         while(searchIndex<=lastIndex(physicalMemory, 0, n-1)){//start from firstIndex always, 
             //should have cases for >0 and <0, if ==0, the coalescing of holes is incorrectly implemented
             if(copyMemory[searchIndex]<0){ //positive integer = allocated
                 totalNumberOfHolesSearched++;//
                 if(Math.abs(copyMemory[searchIndex])>=s){
                     //TODO create allocate function   
                     allocate(currentRequest, searchIndex, s);
                     //TODO take out when create allocate function
                     holesAllocations-=s;
                     currentAllocations+=s;
                     
                     //TODO check calculations
                     totalMemoryUtilization+=s;
                     currentRequest.setMemoryUtilization(memUtil);
                     //TODO  decide what happens to currentRequest 
                     //does it get added to a completedRequests list?
                     //do we just send it off to the garbage collector?
                     //what do :(
                     break;
                 }
                 else{//hole wasn't big enough, move on
                     searchIndex++;
                 }
             }
             else{ //should be copyMemory[searchIndex]>0
                 searchIndex++;
             }
         }//ends while searchIndex
                     //request(s); //attempt to satisfy the request using chosen method; 
                     //count number of holes examined and average the count over the number of request operations
         
         do{
             int randomIndex=random.nextInt(lastIndex); //select an occupied block i
         }while(copyMemory[randomIndex]>0);
         //TODO  create release method
         release(randomIndex);
        }//end while(true)
         
        return new int[] {totalMemoryUtilization, totalNumberOfHolesSearched, numberOfRequestsFulfilled};
    }//end runSimulationFirstFit
   
    /**
     * @param request a request to be allocated in a physical memory
     * @param currentLocation an index location to be allocated
     * @paran blcokSize block size of a request*/
    public void allocate(Request request, int currentLocation, int blockSize){
    	boolean isMemFull = false;
    	int i=0;
    	while( i<physicalMemory.length && !isMemFull) {
    		 if(physicalMemory[i] < 0 && (i < currentLocation) && (Math.abs(physicalMemory[i]) + i > currentLocation + blockSize)) {
                 int next = Math.abs(physicalMemory[i]) + i;
                 physicalMemory[i] = i - currentLocation;
                 physicalMemory[currentLocation] = blockSize;
                 physicalMemory[currentLocation + blockSize] = (currentLocation + blockSize) - next;
                 isMemFull = true;
	         }
	         else {
	        	 i = Math.abs(physicalMemory[i]) + i;
	         }
    	}	
    }
    
   
   
}
