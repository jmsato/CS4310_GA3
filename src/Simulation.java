import java.util.*;
public class Simulation {
    private int d; // Average request size
    private int v; // Standard deviation
    private int k; // Size of hole
    private int s; // Size of block
    private static Random random;
    private ArrayList<Integer> physicalMemmory;
    private int n; // Size of physical memory

    Simulation(int d, int v, int n){
        this.d = d;
        this.v = v;
        physicalMemmory = new ArrayList<Integer>(n);
    }
    /**
     * The method generates 's', the size of block which is generated at random from a normal (Gaussian) distribution.
     * Values less than 1 and greater than n - 1 are discarded.
     */
    public int get_size_of_block (){
        do {
            s = (int) (random.nextGaussian()*v+d);
        } while( (s <= 0) || (s > n-1) ); // discard negative/zero values and n-1 values
        return s;
    }

    //  // Memory utilization is the ratio of space occupied by blocks divided by
    // //the total memory size n, and can vary from 0 to 1.
    public int get_memory_utilization(){
    }

    public void create_request () {
        Request request = new Request (get_size_of_block(), get_memory_utilization());
    }

   public int[] runNextFit() {
	   int[] mem = this.physicalMemory.clone(); //Copy the physical memory
	   int totalMemoryUtilization = 0;
	   int totalNumberOfHolesSearched = 0;
	   int numberOfRequestsFulfilled = 50;
	   int lastSearchIndex = 0; //Index of search where the last allocated block was
	   
	   while(true) {							//repeat x times
		   int s = get_size_of_block(); 		//	choose random request size, s
		   if(currentAllocations + s > n) {		//	repeat until request fails
			   break;
		   }
		   
		   Request currentRequest = new Request(s, get_memory_utilization()); //	do a request
		   
		   while(lastSearchIndex <= lastIndex) {
			   if(mem[lastSearchIndex] < 0) { //negative integer = unallocated memory
				   totalNumberOfHolesSearched++;
				   if(Math.abs(mem[lastSearchIndex]) >= s) {
					   allocate(currentRequest);
					   holesAllocations -= s;
					   currentAllocations += s;
					   
					   totalMemoryUtilization += s;
					   currentRequest.setMemoryUtilization(get_memory_utilization());	//	record current memory util
					   break;
				   }
				   else { //Hole was not big enough
					   lastSearchIndex++;
				   }
			   }
			   else { //positive integer = allocated memory
				   lastSearchIndex++;
			   }
		   }
		   
		   int randomIndex; //index of an occupied block
		   
		   do {
			   randomIndex = random.nextInt(lastIndex); //	select an occupied block i
		   } while(mem[randomIndex] > 0);
		   
		   release(randomIndex);	//	release the occupied block
	   }
	   //Compute avgs for memory utilization and holes searched
	   return new int[] {totalMemoryUtilization, totalNumberOfHolesSearched, numberOfRequestsFulfilled};
   }
}
