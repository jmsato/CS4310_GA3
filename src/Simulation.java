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

   
}
