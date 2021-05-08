import java.util.*;

public class Simulation {
	private int d; // Average request size
	private int v; // Standard deviation
	private int k; // Size of hole
	private int s; // Size of block
	private static Random random;
	private int[] physicalMemory; // Physical memory in simulation
	private int n; // Size of physical memory
	private int lastIndex; //index of occupied element in array (can be hole or allocated block)
	private int currentAllocations;
	private int holesAllocations;
	private int numberOfSpaceOcupied;
	private ArrayList<Integer> memUtil; 
	private ArrayList<Integer> numHoles;

	public Simulation(int d, int v, int n) {
		this.d = d;
		this.v = v;
		this.physicalMemory = new int[n];
        this.n=n;
	}

	public Simulation(int d, int v){
		this.d = d;
		this.v = v;
		this.k = 0;
		this.s = 0;
		this.numberOfSpaceOcupied = 0;
		physicalMemory = null;
        this.n=0;
		memUtil = new ArrayList<Integer>();    
		numHoles = new ArrayList<Integer>();  
	}
    
    public Simulation(int[]pm){
		this.d = d;
		this.v = v;
		this.k = 0;
		this.s = 0;
		this.numberOfSpaceOcupied = 0;
		this.physicalMemory = pm;
        this.n=pm.length;
		memUtil = new ArrayList<Integer>();    
		numHoles = new ArrayList<Integer>();  
	}

    //TODO for testing, remove in final code
    public void setLastIndex(int i){
        this.lastIndex=i;
    }
    public void setPhysicalMemory(int[]arr){
        this.physicalMemory=arr;
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
    
    public void printPhysicalMemory () {
        for(Integer i: this.physicalMemory) {
    		System.out.print(i+ " ");  		
    	}
        System.out.println("\tLast Index: "+this.lastIndex);//TODO take out after testing
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

    //  // Memory utilization is the ratio of space occupied by blocks divided by
    // //the total memory size n, and can vary from 0 to 1.
    public double get_memory_utilization(int totalMemory){
        //TODO  fix
        return (double)totalMemory/(double)n;
    }

    public void create_request () {
        Request request = new Request (get_size_of_block(), get_memory_utilization(currentAllocations));
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

    /**
     * @param request a request to be allocated in a physical memory
     * @param currentLocation an index location to be allocated
     * @param blockSize block size of a request*/
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


    /**
     * Method that releases an allocated memory block from physicalMemory array
     * @param index an int value that specifies the index of the block in physicalMemory to be released
     * returns an int. 1 was a successful release, -1 meant there was a problem, the memory was not released(was already a hole, out of bounds, etc.)
     */
    public int release(int index){
        if(index>lastIndex || index<0)//check if is inbounds
            return -1; 
        if(physicalMemory[index]<+0)
            return -1; //it's already a hole
        physicalMemory[index]*=(-1);
        if(index==0){
            if(index+1>=n){//if n=1 sort of scenario
                return 1; 
            }
            else{
                if (physicalMemory[index+1]<0){
                    System.out.println("Hitting else of case 0");
                    physicalMemory[index]+=physicalMemory[index+1];
                    for(int i=index+1; i<=lastIndex; i++){ //shifting physicalMemory from [index+1] left 1 element]
                        if(i==lastIndex)
                        physicalMemory[i]=0;
                    else
                        physicalMemory[i]=physicalMemory[i+1];
                    }
                lastIndex--;
                }
                return 1;    
            }
        }
        else if(index==this.n-1){
            if(index-1<0){//if n=1 sort of scenario //lastIndex should remain same in this case
                return 1;
            }
            else{
                if (physicalMemory[index-1]<0){
                    physicalMemory[index-1]+=physicalMemory[index];
                    for(int i=index; i<=lastIndex; i++){ //shifting physicalMemory from [index] left 1 element]
                        if(i==lastIndex)
                            physicalMemory[i]=0;
                        else
                            physicalMemory[i]=physicalMemory[i+1];
                    }
                    lastIndex--;
                }
                return 1;    
            }//end else
        }
        else{
            if(physicalMemory[index-1]<0 && physicalMemory[index+1]<0){//need to combine holes
                physicalMemory[index-1]+=physicalMemory[index]+physicalMemory[index+1];
                for(int i=index;i<=lastIndex;i++){ //shift left 2 times
                    if(i==lastIndex-1 ||i==lastIndex)
                        physicalMemory[i]=0;
                    else
                        physicalMemory[i]=physicalMemory[i+2];
                }
                lastIndex-=2;
                return 1;
            }
            else if(physicalMemory[index-1]<0){ //hole to left
                physicalMemory[index-1]+=physicalMemory[index];
                for(int i=index; i<=lastIndex; i++){ //shifting physicalMemory from [index] left 1 element]
                    if(i==lastIndex)
                        physicalMemory[i]=0;
                    else
                        physicalMemory[i]=physicalMemory[i+1];
                }
                lastIndex--;
                return 1;
            }
            else if(physicalMemory[index+1]<0){ // hole to right
                    physicalMemory[index]+=physicalMemory[index+1];
                    for(int i=index+1; i<=lastIndex; i++){ //shifting physicalMemory from [index+1] left 1 element]
                        if(i==lastIndex)
                        physicalMemory[i]=0;
                    else
                        physicalMemory[i]=physicalMemory[i+1];
                    }
                lastIndex--;
                return 1;
            }
            else{//no holes on either side
                return 1;
            }
        }//end big if-elseif-else statement
    }//end release

    public int lastIndex(int[] arr) {

        // still working
      
         
         
         
     }

   public int[] runSimulationFirstFit(){
       //int[] copyMemory=this.physicalMemory.clone(); //since it's primitive, we can do this
       //currentAllocations, holesAllocations should be set in creation physicalMemory
       int totalMemoryUtilization=0;
       int totalNumberOfHolesSearched=0;
       int numberOfRequestsFulfilled=0;
       
       while(true){ //repeat x times
        
        int s = get_size_of_block(); //s is the request size chosen from a normal distribution
        //TODO decide if this should go before or after creation of a new request (really just depends on s)
        if(currentAllocations+s<n) //repeat until request fails
            break;
        //TODO fix memUtil of request
        Request currentRequest=new Request(s, get_memory_utilization()); //create a request of size s
              
        
        //First Fit Search starts here
        int searchIndex=0;
        while(searchIndex<=lastIndex){//start from firstIndex always, search until reach lastIndex filled
            //should have cases for >0 and <0, if ==0, the coalescing of holes is incorrectly implemented
            if(copyMemory[searchIndex]<0){ //positive integer = allocated
                totalNumberOfHolesSearched++;//
                if(Math.abs(copyMemory[searchIndex])>=s){
                    //TODO create allocate function   
                    allocate(currentRequest);
                    //TODO take out when create allocate function
                    holesAllocations-=s;
                    currentAllocations+=s;
                    
                    //TODO check calculations
                    totalMemoryUtilization+=s;
                    currentRequest.setMemoryUtilization(get_memory_utilization());
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
    
   
}
