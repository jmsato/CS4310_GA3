import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Test {

	private static double getAverageMemUtil(Request[] req) {
		double mem = 0;
		for (Request r : req) {
			mem += r.getMemoryUtilization();
		}
		return mem / req.length;
	}
	
	private static double getAverageHoles(Request[] req) {
		int holes = 0;
		for (Request r : req) {
			holes += r.getNumHoles();
		}
		return holes / req.length;
	}
	
	public static void main(String[] args) {
		System.out.println("Running Test.java file...");
		int runTests = 1000;
		
		//Create CSV writers:
		try {
			System.out.println("Creating memUtilResults.csv and holeResults.csv files...");
			
			//Creating header row for memory utilization
			List<String[]> memRows = new ArrayList<String[]>();
			FileWriter memWriter = new FileWriter("memUtilResults.csv");
			memWriter.append("First,Next,Best,Worst\n");
			
			//Creating header row for holes examined
			List<String[]> holeRows = new ArrayList<String[]>();
			FileWriter holeWriter = new FileWriter("holeResults.csv");
			memWriter.append("First,Next,Best,Worst\n");
			
			/* Best fit test suite */
			System.out.println("Running best fit test suite...");
			memRows.add(new String[]{"Best fit test suite:"});
			holeRows.add(new String[]{"Best fit test suite:"});
			
			//Test Case 1: d = 100, v = 0
			memRows.add(new String[]{"d = 100 and v = 0"});
			holeRows.add(new String[]{"d = 100 and v = 0"});
			for(int times = 0; times < runTests; times++) {	
				//Create a new row for each test run
				String[] memR = new String[4];
				String[] holeR = new String[4]; 
				//Run simulation
				Simulation sim1 = new Simulation(100, 0);
				Request[] first = sim1.runFirstFit();
				memR[0] = Double.toString(getAverageMemUtil(first));
				holeR[0] = Double.toString(getAverageHoles(first));
				Request[] next = sim1.runNextFit();
				memR[1] = Double.toString(getAverageMemUtil(next));
				holeR[1] = Double.toString(getAverageHoles(next));
				Request[] best = sim1.runBestFit();
				memR[2] = Double.toString(getAverageMemUtil(best));
				holeR[2] = Double.toString(getAverageHoles(best));
				Request[] worst = sim1.runWorstFit();
				memR[3] = Double.toString(getAverageMemUtil(worst));
				holeR[3] = Double.toString(getAverageHoles(worst));
				//Add rows to csv files
				memRows.add(memR);
				holeRows.add(holeR);
			}
			
			//Test Case 2: d = 100, v = 10
			memRows.add(new String[]{"d = 100 and v = 10"});
			holeRows.add(new String[]{"d = 100 and v = 10"});
			for(int times = 0; times < runTests; times++) {	
				//Create a new row for each test run
				String[] memR = new String[4];
				String[] holeR = new String[4]; 
				//Run simulation
				Simulation sim2 = new Simulation(100, 10);
				Request[] first = sim2.runFirstFit();
				memR[0] = Double.toString(getAverageMemUtil(first));
				holeR[0] = Double.toString(getAverageHoles(first));
				Request[] next = sim2.runNextFit();
				memR[1] = Double.toString(getAverageMemUtil(next));
				holeR[1] = Double.toString(getAverageHoles(next));
				Request[] best = sim2.runBestFit();
				memR[2] = Double.toString(getAverageMemUtil(best));
				holeR[2] = Double.toString(getAverageHoles(best));
				Request[] worst = sim2.runWorstFit();
				memR[3] = Double.toString(getAverageMemUtil(worst));
				holeR[3] = Double.toString(getAverageHoles(worst));
				//Add rows to csv files
				memRows.add(memR);
				holeRows.add(holeR);
			}
			
			//Test Case 3: d = 100, v = 50
			memRows.add(new String[]{"d = 100 and v = 50"});
			holeRows.add(new String[]{"d = 100 and v = 50"});
			for(int times = 0; times < runTests; times++) {	
				//Create a new row for each test run
				String[] memR = new String[4];
				String[] holeR = new String[4]; 
				//Run simulation
				Simulation sim3 = new Simulation(100, 50);
				Request[] first = sim3.runFirstFit();
				memR[0] = Double.toString(getAverageMemUtil(first));
				holeR[0] = Double.toString(getAverageHoles(first));
				Request[] next = sim3.runNextFit();
				memR[1] = Double.toString(getAverageMemUtil(next));
				holeR[1] = Double.toString(getAverageHoles(next));
				Request[] best = sim3.runBestFit();
				memR[2] = Double.toString(getAverageMemUtil(best));
				holeR[2] = Double.toString(getAverageHoles(best));
				Request[] worst = sim3.runWorstFit();
				memR[3] = Double.toString(getAverageMemUtil(worst));
				holeR[3] = Double.toString(getAverageHoles(worst));
				//Add rows to csv files
				memRows.add(memR);
				holeRows.add(holeR);
			}
			
			//Test Case 4: d = 100, v = 90
			memRows.add(new String[]{"d = 100 and v = 90"});
			holeRows.add(new String[]{"d = 100 and v = 90"});
			for(int times = 0; times < runTests; times++) {	
				//Create a new row for each test run
				String[] memR = new String[4];
				String[] holeR = new String[4]; 
				//Run simulation
				Simulation sim4 = new Simulation(100, 90);
				Request[] first = sim4.runFirstFit();
				memR[0] = Double.toString(getAverageMemUtil(first));
				holeR[0] = Double.toString(getAverageHoles(first));
				Request[] next = sim4.runNextFit();
				memR[1] = Double.toString(getAverageMemUtil(next));
				holeR[1] = Double.toString(getAverageHoles(next));
				Request[] best = sim4.runBestFit();
				memR[2] = Double.toString(getAverageMemUtil(best));
				holeR[2] = Double.toString(getAverageHoles(best));
				Request[] worst = sim4.runWorstFit();
				memR[3] = Double.toString(getAverageMemUtil(worst));
				holeR[3] = Double.toString(getAverageHoles(worst));
				//Add rows to csv files
				memRows.add(memR);
				holeRows.add(holeR);
			}
			
			//Test Case 5: d = 100, v = 99
			memRows.add(new String[]{"d = 100 and v = 99"});
			holeRows.add(new String[]{"d = 100 and v = 99"});
			for(int times = 0; times < runTests; times++) {	
				//Create a new row for each test run
				String[] memR = new String[4];
				String[] holeR = new String[4]; 
				//Run simulation
				Simulation sim5 = new Simulation(100, 99);
				Request[] first = sim5.runFirstFit();
				memR[0] = Double.toString(getAverageMemUtil(first));
				holeR[0] = Double.toString(getAverageHoles(first));
				Request[] next = sim5.runNextFit();
				memR[1] = Double.toString(getAverageMemUtil(next));
				holeR[1] = Double.toString(getAverageHoles(next));
				Request[] best = sim5.runBestFit();
				memR[2] = Double.toString(getAverageMemUtil(best));
				holeR[2] = Double.toString(getAverageHoles(best));
				Request[] worst = sim5.runWorstFit();
				memR[3] = Double.toString(getAverageMemUtil(worst));
				holeR[3] = Double.toString(getAverageHoles(worst));
				//Add rows to csv files
				memRows.add(memR);
				holeRows.add(holeR);
			}
			
			//Close CSV writers
			memWriter.flush();
			memWriter.close();
			holeWriter.flush();
			holeWriter.close();
			System.out.println("Done!");
		} catch(Exception e) {
			System.out.println("Something went wrong.");
			e.printStackTrace();
		}
	}

}
