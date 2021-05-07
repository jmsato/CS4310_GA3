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
	}

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

	//  // Memory utilization is the ratio of space occupied by blocks divided by
	// //the total memory size n, and can vary from 0 to 1.
	public double get_memory_utilization(int totalMemory){
		//TODO  fix
		return (double)totalMemory/(double)n;
	}

	public void create_request () {
		Request request = new Request (getBlockSize(n), get_memory_utilization(currentAllocations));
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

	//TODO fill in function 
	public void release(Request r){

	}
	//TODO fill in function
	public void allocate(Request r){

	}

	/**
	 * Runs the first-fit simulation.
	 * @return Integer array with the total memory utilization, holes searched, and number of requests fulfilled.
	 */
	public int[] runSimulationFirstFit(){
		int[] copyMemory=this.physicalMemory.clone(); //since it's primitive, we can do this
		//currentAllocations, holesAllocations should be set in creation physicalMemory
		int totalMemoryUtilization=0;
		int totalNumberOfHolesSearched=0;
		int numberOfRequestsFulfilled=0;

		while(true){ //repeat x times

			int s = getBlockSize(n); //s is the request size chosen from a normal distribution
			//TODO decide if this should go before or after creation of a new request (really just depends on s)
			if(currentAllocations + s < n) //repeat until request fails
				break;
			//TODO fix memUtil of request
			Request currentRequest=new Request(s, get_memory_utilization()); //create a request of size s



			//First Fit Search starts here
			int searchIndex=0;
			while(searchIndex<=lastIndex){//start from firstIndex always, search until reach lastIndex filled
				//should have cases for >0 and <0, if ==0, the coalescing of holes is incorrectly implemented
				if(physicalMemory[searchIndex]<0){ //positive integer = allocated
					totalNumberOfHolesSearched++;//
					if(Math.abs(physicalMemory[searchIndex])>=s){
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
			int randomIndex;
			do{
				randomIndex=random.nextInt(lastIndex); //select an occupied block i
			}while(physicalMemory[randomIndex]>0);
			//TODO  create release method
			release(randomIndex);
		}//end while(true)
		
		physicalMemory = copyMemory;

		return new int[] {totalMemoryUtilization, totalNumberOfHolesSearched, numberOfRequestsFulfilled};
	}//end runSimulationFirstFit

	/**
	 * Runs the next fit simulation.
	 * @return Integer array with the total memory utilization, holes searched, and number of requests fulfilled.
	 */
	public int[] runSimulationNextFit() {
		int[] copyMemory = this.physicalMemory.clone(); //Copy the physical memory
		int totalMemoryUtilization = 0;
		int totalNumberOfHolesSearched = 0;
		int numberOfRequestsFulfilled = 0;
		int searchIndex = 0; //Index of search where the last allocated block was

		//Next fit simulation begins here
		while(true) {							//repeat x times
			int s = getBlockSize(n); 			//	choose random request size, s
			if(currentAllocations + s > n) {		//	repeat until request fails
				break;
			}

			int searched = 0; //Number of holes searched for circular memory
			Request currentRequest = new Request(s, get_memory_utilization()); //	do a request

			while(searched < lastIndex + 1) {
				searched++;
				if(physicalMemory[searchIndex] < 0) { //negative integer = unallocated memory
					totalNumberOfHolesSearched++;
					if(Math.abs(physicalMemory[searchIndex]) >= s) {
						allocate(currentRequest);
						holesAllocations -= s;
						currentAllocations += s;
						numberOfRequestsFulfilled++;

						totalMemoryUtilization += s;
						currentRequest.setMemoryUtilization(get_memory_utilization());	//	record current memory util
						
						//Circular memory indices
						if(searchIndex + 1 > lastIndex) {
							searchIndex = 0;
						}
						else {
							searchIndex++;
						}
						
						break;
					}
					else { //Hole was not big enough
						//Circular memory indices
						if(searchIndex + 1 > lastIndex) {
							searchIndex = 0;
						}
						else {
							searchIndex++;
						}
					}
				}
				else { //positive integer = allocated memory
					//Circular memory indices
					if(searchIndex + 1 > lastIndex) {
						searchIndex = 0;
					}
					else {
						searchIndex++;
					}
				}
			}

			int randomIndex; //index of an occupied block

			do {
				randomIndex = random.nextInt(lastIndex); //	select an occupied block i
			} while(physicalMemory[randomIndex] > 0);

			release(randomIndex);	//	release the occupied block
		}
		physicalMemory = copyMemory;
		
		//Compute avgs for memory utilization and holes searched
		return new int[] {totalMemoryUtilization, totalNumberOfHolesSearched, numberOfRequestsFulfilled};
	}// end runSimulationNextFit
	
	/**
	 * Runs the best fit simulation.
	 * @return Integer array with the total memory utilization, holes searched, and number of requests fulfilled.
	 */
	public int[] runSimulationBestFit(){
		int[] copyMemory=this.physicalMemory.clone(); //since it's primitive, we can do this
		//currentAllocations, holesAllocations should be set in creation physicalMemory
		int totalMemoryUtilization=0;
		int totalNumberOfHolesSearched=0;
		int numberOfRequestsFulfilled=0;

		while(true){ //repeat x times

			int s = getBlockSize(n); //s is the request size chosen from a normal distribution
			//TODO decide if this should go before or after creation of a new request (really just depends on s)
			if(currentAllocations + s > n) //repeat until request fails
				break;
			//TODO fix memUtil of request
			Request currentRequest=new Request(s, get_memory_utilization()); //create a request of size s

			//Best Fit Search starts here
			int searchIndex=0;
			int bestIndex = -1;
			while(searchIndex<=lastIndex){//start from firstIndex always, search until reach lastIndex filled
				//should have cases for >0 and <0, if ==0, the coalescing of holes is incorrectly implemented
				if(physicalMemory[searchIndex]<0){ //positive integer = allocated
					totalNumberOfHolesSearched++;
					if(Math.abs(physicalMemory[searchIndex]) >= s && (bestIndex == -1 || Math.abs(physicalMemory[searchIndex]) < Math.abs(physicalMemory[bestIndex]))){
						bestIndex = searchIndex;
					}
					else{//hole wasn't big enough, move on
						searchIndex++;
					}
				}
				else{ //should be copyMemory[searchIndex]>0
					searchIndex++;
				}
			}//ends while searchIndex
			
			//Do the allocation stuff here
			if(bestIndex != -1) {
				//TODO create allocate function, does it need an index???
				allocate(currentRequest);
				//TODO take out when create allocate function
				holesAllocations-=s;
				currentAllocations+=s;
				numberOfRequestsFulfilled++;
	
				//TODO check calculations
				totalMemoryUtilization+=s;
				currentRequest.setMemoryUtilization(get_memory_utilization());
				//TODO  decide what happens to currentRequest
				//does it get added to a completedRequests list?
				//do we just send it off to the garbage collector?
				//what do :(
			}
			else { //means the request failed
				break;
			}
			//request(s); //attempt to satisfy the request using chosen method; 
			//count number of holes examined and average the count over the number of request operations
			int randomIndex;
			do{
				randomIndex=random.nextInt(lastIndex); //select an occupied block i
			}while(physicalMemory[randomIndex]>0);
			//TODO  create release method
			release(randomIndex);
		}//end while(true)
		
		physicalMemory = copyMemory;

		return new int[] {totalMemoryUtilization, totalNumberOfHolesSearched, numberOfRequestsFulfilled};
	}//end runSimulationFirstFit
}
