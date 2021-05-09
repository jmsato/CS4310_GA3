import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
		Simulation sim = new Simulation(5, 2, 10);
		sim.runSimulationWorstFit();
		System.out.println(sim.requestsListToString());
		System.out.println(sim.getRequestsList().size());
//		System.out.println("Running Test.java file...");
//		int runTests = 1;
//		int numRequests = 200;
//		
//		//Create CSV writers:
//		try {
//			System.out.println("Creating memUtilResults.csv and holeResults.csv files...");
//			
//			//Creating header row for memory utilization
//			List<String[]> memRows = new ArrayList<String[]>();
//			FileWriter memWriter = new FileWriter("memUtilResults.csv");
//			memWriter.append("First,Next,Best,Worst\n");
//			
//			//Creating header row for holes examined
//			List<String[]> holeRows = new ArrayList<String[]>();
//			FileWriter holeWriter = new FileWriter("holeResults.csv");
//			memWriter.append("First,Next,Best,Worst\n");
//			
//			/* Best fit test suite */
//			System.out.println("Running best fit test suite...");
//			memRows.add(new String[]{"Best fit test suite:"});
//			holeRows.add(new String[]{"Best fit test suite:"});
//			
//			//Test Case 1: d = 100, v = 0
//			memRows.add(new String[]{"d = 100 and v = 0"});
//			holeRows.add(new String[]{"d = 100 and v = 0"});
//			for(int times = 0; times < runTests; times++) {	
//				//Create a new row for each test run
//				String[] memR = new String[4];
//				String[] holeR = new String[4]; 
//				//Run simulation
//				Simulation sim1 = new Simulation(100, 0, numRequests);
//				int[] first = sim1.runSimulationFirstFit();
//				memR[0] = Double.toString(first[0] / first[2]);
//				holeR[0] = Double.toString(first[1] / first[2]);
//				int[] next = sim1.runSimulationNextFit();
//				memR[1] = Double.toString(next[1] / next[2]);
//				holeR[1] = Double.toString(next[1] / next[2]);
//				int[] best = sim1.runSimulationBestFit();
//				memR[2] = Double.toString(best[1] / best[2]);
//				holeR[2] = Double.toString(best[1] / best[2]);
//				int[] worst = sim1.runSimulationWorstFit();
//				memR[3] = Double.toString(worst[1] / worst[2]);
//				holeR[3] = Double.toString(worst[1] / worst[2]);
//				memRows.add(memR);
//				holeRows.add(holeR);
//			}
//			memRows.add(new String[]{" "});
//			holeRows.add(new String[]{" "});
//			
//			//Test Case 2: d = 100, v = 10
//			memRows.add(new String[]{"d = 100 and v = 10"});
//			holeRows.add(new String[]{"d = 100 and v = 10"});
//			for(int times = 0; times < runTests; times++) {	
//				//Create a new row for each test run
//				String[] memR = new String[4];
//				String[] holeR = new String[4]; 
//				//Run simulation
//				Simulation sim2 = new Simulation(100, 10, numRequests);
//				int[] first = sim2.runSimulationFirstFit();
//				memR[0] = Double.toString(first[0] / first[2]);
//				holeR[0] = Double.toString(first[1] / first[2]);
//				int[] next = sim2.runSimulationNextFit();
//				memR[1] = Double.toString(next[1] / next[2]);
//				holeR[1] = Double.toString(next[1] / next[2]);
//				int[] best = sim2.runSimulationBestFit();
//				memR[2] = Double.toString(best[1] / best[2]);
//				holeR[2] = Double.toString(best[1] / best[2]);
//				int[] worst = sim2.runSimulationWorstFit();
//				memR[3] = Double.toString(worst[1] / worst[2]);
//				holeR[3] = Double.toString(worst[1] / worst[2]);
//				//Add rows to csv files
//				memRows.add(memR);
//				holeRows.add(holeR);
//			}
//			memRows.add(new String[]{" "});
//			holeRows.add(new String[]{" "});
//			
//			//Test Case 3: d = 100, v = 50
//			memRows.add(new String[]{"d = 100 and v = 50"});
//			holeRows.add(new String[]{"d = 100 and v = 50"});
//			for(int times = 0; times < runTests; times++) {	
//				//Create a new row for each test run
//				String[] memR = new String[4];
//				String[] holeR = new String[4]; 
//				//Run simulation
//				Simulation sim3 = new Simulation(100, 50, numRequests);
//				int[] first = sim3.runSimulationFirstFit();
//				memR[0] = Double.toString(first[0] / first[2]);
//				holeR[0] = Double.toString(first[1] / first[2]);
//				int[] next = sim3.runSimulationNextFit();
//				memR[1] = Double.toString(next[1] / next[2]);
//				holeR[1] = Double.toString(next[1] / next[2]);
//				int[] best = sim3.runSimulationBestFit();
//				memR[2] = Double.toString(best[1] / best[2]);
//				holeR[2] = Double.toString(best[1] / best[2]);
//				int[] worst = sim3.runSimulationWorstFit();
//				memR[3] = Double.toString(worst[1] / worst[2]);
//				holeR[3] = Double.toString(worst[1] / worst[2]);
//				//Add rows to csv files
//				memRows.add(memR);
//				holeRows.add(holeR);
//			}
//			memRows.add(new String[]{" "});
//			holeRows.add(new String[]{" "});
//			
//			//Test Case 4: d = 100, v = 90
//			memRows.add(new String[]{"d = 100 and v = 90"});
//			holeRows.add(new String[]{"d = 100 and v = 90"});
//			for(int times = 0; times < runTests; times++) {	
//				//Create a new row for each test run
//				String[] memR = new String[4];
//				String[] holeR = new String[4]; 
//				//Run simulation
//				Simulation sim4 = new Simulation(100, 90, numRequests);
//				int[] first = sim4.runSimulationFirstFit();
//				memR[0] = Double.toString(first[0] / first[2]);
//				holeR[0] = Double.toString(first[1] / first[2]);
//				int[] next = sim4.runSimulationNextFit();
//				memR[1] = Double.toString(next[1] / next[2]);
//				holeR[1] = Double.toString(next[1] / next[2]);
//				int[] best = sim4.runSimulationBestFit();
//				memR[2] = Double.toString(best[1] / best[2]);
//				holeR[2] = Double.toString(best[1] / best[2]);
//				int[] worst = sim4.runSimulationWorstFit();
//				memR[3] = Double.toString(worst[1] / worst[2]);
//				holeR[3] = Double.toString(worst[1] / worst[2]);
//				//Add rows to csv files
//				memRows.add(memR);
//				holeRows.add(holeR);
//			}
//			memRows.add(new String[]{" "});
//			holeRows.add(new String[]{" "});
//			
//			//Test Case 5: d = 100, v = 99
//			memRows.add(new String[]{"d = 100 and v = 99"});
//			holeRows.add(new String[]{"d = 100 and v = 99"});
//			for(int times = 0; times < runTests; times++) {	
//				//Create a new row for each test run
//				String[] memR = new String[4];
//				String[] holeR = new String[4]; 
//				//Run simulation
//				Simulation sim5 = new Simulation(100, 99, numRequests);
//				int[] first = sim5.runSimulationFirstFit();
//				memR[0] = Double.toString(first[0] / first[2]);
//				holeR[0] = Double.toString(first[1] / first[2]);
//				int[] next = sim5.runSimulationNextFit();
//				memR[1] = Double.toString(next[1] / next[2]);
//				holeR[1] = Double.toString(next[1] / next[2]);
//				int[] best = sim5.runSimulationBestFit();
//				memR[2] = Double.toString(best[1] / best[2]);
//				holeR[2] = Double.toString(best[1] / best[2]);
//				int[] worst = sim5.runSimulationWorstFit();
//				memR[3] = Double.toString(worst[1] / worst[2]);
//				holeR[3] = Double.toString(worst[1] / worst[2]);
//				//Add rows to csv files
//				memRows.add(memR);
//				holeRows.add(holeR);
//			}
//			memRows.add(new String[]{" "});
//			holeRows.add(new String[]{" "});
//			
//			/* Worst Fit Test Suite */
//			System.out.println("Running worst fit test suite...");
//			memRows.add(new String[]{"Worst fit test suite:"});
//			holeRows.add(new String[]{"Worst fit test suite:"});
//			
//			//Test Case 6: d = 10, v = 1
//			memRows.add(new String[]{"d = 10 and v = 1"});
//			holeRows.add(new String[]{"d = 10 and v = 1"});
//			for(int times = 0; times < runTests; times++) {	
//				//Create a new row for each test run
//				String[] memR = new String[4];
//				String[] holeR = new String[4]; 
//				//Run simulation
//				Simulation sim6 = new Simulation(10, 1, numRequests);
//				int[] first = sim6.runSimulationFirstFit();
//				memR[0] = Double.toString(first[0] / first[2]);
//				holeR[0] = Double.toString(first[1] / first[2]);
//				int[] next = sim6.runSimulationNextFit();
//				memR[1] = Double.toString(next[1] / next[2]);
//				holeR[1] = Double.toString(next[1] / next[2]);
//				int[] best = sim6.runSimulationBestFit();
//				memR[2] = Double.toString(best[1] / best[2]);
//				holeR[2] = Double.toString(best[1] / best[2]);
//				int[] worst = sim6.runSimulationWorstFit();
//				memR[3] = Double.toString(worst[1] / worst[2]);
//				holeR[3] = Double.toString(worst[1] / worst[2]);
//				//Add rows to csv files
//				memRows.add(memR);
//				holeRows.add(holeR);
//			}
//			memRows.add(new String[]{" "});
//			holeRows.add(new String[]{" "});
//			
//			//Test Case 7: d = 200, v = 1
//			memRows.add(new String[]{"d = 200 and v = 1"});
//			holeRows.add(new String[]{"d = 200 and v = 1"});
//			for(int times = 0; times < runTests; times++) {	
//				//Create a new row for each test run
//				String[] memR = new String[4];
//				String[] holeR = new String[4]; 
//				//Run simulation
//				Simulation sim7 = new Simulation(200, 1, numRequests);
//				int[] first = sim7.runSimulationFirstFit();
//				memR[0] = Double.toString(first[0] / first[2]);
//				holeR[0] = Double.toString(first[1] / first[2]);
//				int[] next = sim7.runSimulationNextFit();
//				memR[1] = Double.toString(next[1] / next[2]);
//				holeR[1] = Double.toString(next[1] / next[2]);
//				int[] best = sim7.runSimulationBestFit();
//				memR[2] = Double.toString(best[1] / best[2]);
//				holeR[2] = Double.toString(best[1] / best[2]);
//				int[] worst = sim7.runSimulationWorstFit();
//				memR[3] = Double.toString(worst[1] / worst[2]);
//				holeR[3] = Double.toString(worst[1] / worst[2]);
//				//Add rows to csv files
//				memRows.add(memR);
//				holeRows.add(holeR);
//			}
//			memRows.add(new String[]{" "});
//			holeRows.add(new String[]{" "});
//			
//			//Close CSV writers
//			memWriter.flush();
//			memWriter.close();
//			holeWriter.flush();
//			holeWriter.close();
//			System.out.println("Done!");
//		} catch(Exception e) {
//			System.out.println("Something went wrong.");
//			e.printStackTrace();
//		}
	}
}