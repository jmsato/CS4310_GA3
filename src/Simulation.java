import java.util.*;
public class Simulation {
    private int d; // Average request size
    private int v; // Standard deviation
    private int k; // Size of hole
    private int s; // Size of block
    private static Random random;
    private int[] physicalMemory;
    private int n; // Size of physical memory
    private int lastIndex; //index of occupied element in array (can be hole or allocated block)
    private int currentAllocations;
    private int holesAllocations;

    Simulation(int d, int v, int n){
        this.d = d;
        this.v = v;
        this.physicalMemory = new int[n];
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
    public double get_memory_utilization(int totalMemory){
        //TODO  fix
        return (double)totalMemory/(double)n;
    }

    public void create_request () {
        Request request = new Request (get_size_of_block(), get_memory_utilization(currentAllocations));
    }

    //TODO fill in function 
    public void release(Request r){

    }
    //TODO fill in function
    public void allocate(Request r){

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
