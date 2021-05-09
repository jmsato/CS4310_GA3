import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Test2 {
	
	public static void main(String[] args) {
		int runTests = 1000;
		int numRequests = 200;
		
		//Create CSV writers:
		try {
			System.out.println("Creating memUtilResults2.csv and holeResults2.csv files...");
			
			//Creating header row for memory utilization
			List<String[]> memRows = new ArrayList<String[]>();
			FileWriter memWriter = new FileWriter("memUtilResults2.csv");
			memWriter.append("First,PctFirstReqFilled,Next,PctNextReqFilled,Best,PctBestReqFilled,Worst,PctWorstReqFilled\n");
			
			//Creating header row for holes examined
			List<String[]> holeRows = new ArrayList<String[]>();
			FileWriter holeWriter = new FileWriter("holeResults2.csv");
			holeWriter.append("First,PctFirstReqFilled,Next,PctNextReqFilled,Best,PctBestReqFilled,Worst,PctWorstReqFilled\n");
			
			/* Vary v */
			System.out.println("Running various v test suite...");
			System.out.println("Test Case 1: d = 100 and v = 1");
			//Test Case 1: d = 100, v = 1
			memRows.add(new String[]{"d = 100 and v = 1"});
			holeRows.add(new String[]{"d = 100 and v = 1"});
			for(int times = 0; times < runTests; times++) {	
				//Create a new row for each test run
				
				String[] memR = new String[8];
				String[] holeR = new String[8]; 
				//Run simulation
				Simulation sim6 = new Simulation(100, 1, numRequests);
				System.out.println("Requests List size: " + sim6.getRequestsList().size());
				double[] first = sim6.runSimulationFirstFit();
				memR[0] = Double.toString(first[0] / (first[2] * numRequests));
				holeR[0] = Double.toString(first[1] / first[2]);
				memR[1] = Double.toString(first[2] / numRequests);
				holeR[1] = Double.toString(first[2] / numRequests);
				System.out.println("Requests Fulfilled: " + first[2]);
				double[] next = sim6.runSimulationNextFit();
				memR[2] = Double.toString(next[0] / (next[2] * numRequests));
				holeR[2] = Double.toString(next[1] / next[2]);
				memR[3] = Double.toString(next[2] / numRequests);
				holeR[3] = Double.toString(next[2] / numRequests);
				double[] best = sim6.runSimulationBestFit();
				memR[4] = Double.toString(best[0] / (best[2] * numRequests));
				holeR[4] = Double.toString(best[1] / best[2]);
				memR[5] = Double.toString(best[2] / numRequests);
				holeR[5] = Double.toString(best[2] / numRequests);
				double[] worst = sim6.runSimulationWorstFit();
				memR[6] = Double.toString(worst[0] / (worst[2] * numRequests));
				holeR[6] = Double.toString(worst[1] / worst[2]);
				memR[7] = Double.toString(worst[2] / numRequests);
				holeR[7] = Double.toString(worst[2] / numRequests);
				//Add rows to csv files
				memRows.add(memR);
				holeRows.add(holeR);
			}
			memRows.add(new String[]{" "});
			holeRows.add(new String[]{" "});
			
			System.out.println("Test Case 2: d = 100 and v = 25");
			//Test Case 2: d = 100, v = 25
			memRows.add(new String[]{"d = 100 and v = 25"});
			holeRows.add(new String[]{"d = 100 and v = 25"});
			for(int times = 0; times < runTests; times++) {	
				//Create a new row for each test run
				String[] memR = new String[8];
				String[] holeR = new String[8]; 
				//Run simulation
				Simulation sim6 = new Simulation(100, 25, numRequests);
				double[] first = sim6.runSimulationFirstFit();
				memR[0] = Double.toString(first[0] / (first[2] * numRequests));
				holeR[0] = Double.toString(first[1] / first[2]);
				memR[1] = Double.toString(first[2] / numRequests);
				holeR[1] = Double.toString(first[2] / numRequests);
				double[] next = sim6.runSimulationNextFit();
				memR[2] = Double.toString(next[0] / (next[2] * numRequests));
				holeR[2] = Double.toString(next[1] / next[2]);
				memR[3] = Double.toString(next[2] / numRequests);
				holeR[3] = Double.toString(next[2] / numRequests);
				double[] best = sim6.runSimulationBestFit();
				memR[4] = Double.toString(best[0] / (best[2] * numRequests));
				holeR[4] = Double.toString(best[1] / best[2]);
				memR[5] = Double.toString(best[2] / numRequests);
				holeR[5] = Double.toString(best[2] / numRequests);
				double[] worst = sim6.runSimulationWorstFit();
				memR[6] = Double.toString(worst[0] / (worst[2] * numRequests));
				holeR[6] = Double.toString(worst[1] / worst[2]);
				memR[7] = Double.toString(worst[2] / numRequests);
				holeR[7] = Double.toString(worst[2] / numRequests);
				//Add rows to csv files
				memRows.add(memR);
				holeRows.add(holeR);
			}
			memRows.add(new String[]{" "});
			holeRows.add(new String[]{" "});
			
			System.out.println("Test Case 3: d = 100 and v = 50");
			//Test Case 3: d = 100, v = 50
			memRows.add(new String[]{"d = 100 and v = 50"});
			holeRows.add(new String[]{"d = 100 and v = 50"});
			for(int times = 0; times < runTests; times++) {	
				//Create a new row for each test run
				String[] memR = new String[8];
				String[] holeR = new String[8]; 
				//Run simulation
				Simulation sim6 = new Simulation(100, 50, numRequests);
				double[] first = sim6.runSimulationFirstFit();
				memR[0] = Double.toString(first[0] / (first[2] * numRequests));
				holeR[0] = Double.toString(first[1] / first[2]);
				memR[1] = Double.toString(first[2] / numRequests);
				holeR[1] = Double.toString(first[2] / numRequests);
				double[] next = sim6.runSimulationNextFit();
				memR[2] = Double.toString(next[0] / (next[2] * numRequests));
				holeR[2] = Double.toString(next[1] / next[2]);
				memR[3] = Double.toString(next[2] / numRequests);
				holeR[3] = Double.toString(next[2] / numRequests);
				double[] best = sim6.runSimulationBestFit();
				memR[4] = Double.toString(best[0] / (best[2] * numRequests));
				holeR[4] = Double.toString(best[1] / best[2]);
				memR[5] = Double.toString(best[2] / numRequests);
				holeR[5] = Double.toString(best[2] / numRequests);
				double[] worst = sim6.runSimulationWorstFit();
				memR[6] = Double.toString(worst[0] / (worst[2] * numRequests));
				holeR[6] = Double.toString(worst[1] / worst[2]);
				memR[7] = Double.toString(worst[2] / numRequests);
				holeR[7] = Double.toString(worst[2] / numRequests);
				//Add rows to csv files
				memRows.add(memR);
				holeRows.add(holeR);
			}
			memRows.add(new String[]{" "});
			holeRows.add(new String[]{" "});
			
			System.out.println("Test Case 4: d = 100 and v = 90");
			//Test Case 4: d = 100, v = 90
			memRows.add(new String[]{"d = 100 and v = 90"});
			holeRows.add(new String[]{"d = 100 and v = 90"});
			for(int times = 0; times < runTests; times++) {	
				//Create a new row for each test run
				String[] memR = new String[8];
				String[] holeR = new String[8]; 
				//Run simulation
				Simulation sim6 = new Simulation(100, 90, numRequests);
				double[] first = sim6.runSimulationFirstFit();
				memR[0] = Double.toString(first[0] / (first[2] * numRequests));
				holeR[0] = Double.toString(first[1] / first[2]);
				memR[1] = Double.toString(first[2] / numRequests);
				holeR[1] = Double.toString(first[2] / numRequests);
				double[] next = sim6.runSimulationNextFit();
				memR[2] = Double.toString(next[0] / (next[2] * numRequests));
				holeR[2] = Double.toString(next[1] / next[2]);
				memR[3] = Double.toString(next[2] / numRequests);
				holeR[3] = Double.toString(next[2] / numRequests);
				double[] best = sim6.runSimulationBestFit();
				memR[4] = Double.toString(best[0] / (best[2] * numRequests));
				holeR[4] = Double.toString(best[1] / best[2]);
				memR[5] = Double.toString(best[2] / numRequests);
				holeR[5] = Double.toString(best[2] / numRequests);
				double[] worst = sim6.runSimulationWorstFit();
				memR[6] = Double.toString(worst[0] / (worst[2] * numRequests));
				holeR[6] = Double.toString(worst[1] / worst[2]);
				memR[7] = Double.toString(worst[2] / numRequests);
				holeR[7] = Double.toString(worst[2] / numRequests);
				//Add rows to csv files
				memRows.add(memR);
				holeRows.add(holeR);
			}
			memRows.add(new String[]{" "});
			holeRows.add(new String[]{" "});
			
			/* Vary d */
			System.out.println("Running various d test suite...");
			System.out.println("Test Case 5: d = 10 and v = 5");
			//Test Case 5: d = 10, v = 5
			memRows.add(new String[]{"d = 10 and v = 5"});
			holeRows.add(new String[]{"d = 10 and v = 5"});
			for(int times = 0; times < runTests; times++) {	
				//Create a new row for each test run
				String[] memR = new String[8];
				String[] holeR = new String[8]; 
				//Run simulation
				Simulation sim6 = new Simulation(10, 5, numRequests);
				double[] first = sim6.runSimulationFirstFit();
				memR[0] = Double.toString(first[0] / (first[2] * numRequests));
				holeR[0] = Double.toString(first[1] / first[2]);
				memR[1] = Double.toString(first[2] / numRequests);
				holeR[1] = Double.toString(first[2] / numRequests);
				double[] next = sim6.runSimulationNextFit();
				memR[2] = Double.toString(next[0] / (next[2] * numRequests));
				holeR[2] = Double.toString(next[1] / next[2]);
				memR[3] = Double.toString(next[2] / numRequests);
				holeR[3] = Double.toString(next[2] / numRequests);
				double[] best = sim6.runSimulationBestFit();
				memR[4] = Double.toString(best[0] / (best[2] * numRequests));
				holeR[4] = Double.toString(best[1] / best[2]);
				memR[5] = Double.toString(best[2] / numRequests);
				holeR[5] = Double.toString(best[2] / numRequests);
				double[] worst = sim6.runSimulationWorstFit();
				memR[6] = Double.toString(worst[0] / (worst[2] * numRequests));
				holeR[6] = Double.toString(worst[1] / worst[2]);
				memR[7] = Double.toString(worst[2] / numRequests);
				holeR[7] = Double.toString(worst[2] / numRequests);
				//Add rows to csv files
				memRows.add(memR);
				holeRows.add(holeR);
			}
			memRows.add(new String[]{" "});
			holeRows.add(new String[]{" "});
			
			System.out.println("Test Case 6: d = 50 and v = 25");
			//Test Case 6: d = 50, v = 25
			memRows.add(new String[]{"d = 50 and v = 25"});
			holeRows.add(new String[]{"d = 50 and v = 25"});
			for(int times = 0; times < runTests; times++) {	
				//Create a new row for each test run
				String[] memR = new String[8];
				String[] holeR = new String[8]; 
				//Run simulation
				Simulation sim6 = new Simulation(50, 25, numRequests);
				double[] first = sim6.runSimulationFirstFit();
				memR[0] = Double.toString(first[0] / (first[2] * numRequests));
				holeR[0] = Double.toString(first[1] / first[2]);
				memR[1] = Double.toString(first[2] / numRequests);
				holeR[1] = Double.toString(first[2] / numRequests);
				double[] next = sim6.runSimulationNextFit();
				memR[2] = Double.toString(next[0] / (next[2] * numRequests));
				holeR[2] = Double.toString(next[1] / next[2]);
				memR[3] = Double.toString(next[2] / numRequests);
				holeR[3] = Double.toString(next[2] / numRequests);
				double[] best = sim6.runSimulationBestFit();
				memR[4] = Double.toString(best[0] / (best[2] * numRequests));
				holeR[4] = Double.toString(best[1] / best[2]);
				memR[5] = Double.toString(best[2] / numRequests);
				holeR[5] = Double.toString(best[2] / numRequests);
				double[] worst = sim6.runSimulationWorstFit();
				memR[6] = Double.toString(worst[0] / (worst[2] * numRequests));
				holeR[6] = Double.toString(worst[1] / worst[2]);
				memR[7] = Double.toString(worst[2] / numRequests);
				holeR[7] = Double.toString(worst[2] / numRequests);
				//Add rows to csv files
				memRows.add(memR);
				holeRows.add(holeR);
			}
			memRows.add(new String[]{" "});
			holeRows.add(new String[]{" "});
			
			System.out.println("Test Case 7: d = 150 and v = 75");
			//Test Case 7: d = 150, v = 75
			memRows.add(new String[]{"d = 150 and v = 75"});
			holeRows.add(new String[]{"d = 150 and v = 75"});
			for(int times = 0; times < runTests; times++) {	
				//Create a new row for each test run
				String[] memR = new String[8];
				String[] holeR = new String[8]; 
				//Run simulation
				Simulation sim6 = new Simulation(150, 75, numRequests);
				double[] first = sim6.runSimulationFirstFit();
				memR[0] = Double.toString(first[0] / (first[2] * numRequests));
				holeR[0] = Double.toString(first[1] / first[2]);
				memR[1] = Double.toString(first[2] / numRequests);
				holeR[1] = Double.toString(first[2] / numRequests);
				double[] next = sim6.runSimulationNextFit();
				memR[2] = Double.toString(next[0] / (next[2] * numRequests));
				holeR[2] = Double.toString(next[1] / next[2]);
				memR[3] = Double.toString(next[2] / numRequests);
				holeR[3] = Double.toString(next[2] / numRequests);
				double[] best = sim6.runSimulationBestFit();
				memR[4] = Double.toString(best[0] / (best[2] * numRequests));
				holeR[4] = Double.toString(best[1] / best[2]);
				memR[5] = Double.toString(best[2] / numRequests);
				holeR[5] = Double.toString(best[2] / numRequests);
				double[] worst = sim6.runSimulationWorstFit();
				memR[6] = Double.toString(worst[0] / (worst[2] * numRequests));
				holeR[6] = Double.toString(worst[1] / worst[2]);
				memR[7] = Double.toString(worst[2] / numRequests);
				holeR[7] = Double.toString(worst[2] / numRequests);
				//Add rows to csv files
				memRows.add(memR);
				holeRows.add(holeR);
			}
			memRows.add(new String[]{" "});
			holeRows.add(new String[]{" "});
			
			System.out.println("Writing to memUtilResults2.csv file...");
			//Write to the CSV file
			for (String[] rowData : memRows) {
			    memWriter.append(String.join(",", rowData));
			    memWriter.append("\n");
			}
			
			System.out.println("Writing to holeResults2.csv file...");
			//Write to the CSV file
			for (String[] rowData : holeRows) {
			    holeWriter.append(String.join(",", rowData));
			    holeWriter.append("\n");
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