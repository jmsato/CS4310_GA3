import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
		System.out.println("Running Test.java file...");
		int runTests = 1000;
		int numRequests = 200;
		
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
			holeWriter.append("First,Next,Best,Worst\n");
			
			/* First fit test suite */
			System.out.println("Running first fit test suite...");
			memRows.add(new String[]{"First fit test suite:"});
			holeRows.add(new String[]{"First fit test suite:"});
			System.out.println("Test case 8, convoy requests");
			//Test Case 8: Convoy requests
			memRows.add(new String[]{"Convoy requests"});
			holeRows.add(new String[]{"Convoy requests"});
			for(int times = 0; times < runTests; times++) {
				//Create a new row for each test run
				String[] memR = new String[8];
				String[] holeR = new String[8]; 
				//Run simulation
				Simulation convoySim = new Simulation(100, 50, numRequests, 8);
				double[] first = convoySim.runSimulationFirstFit();
				memR[0] = Double.toString(first[0] / (first[2] * numRequests));
				holeR[0] = Double.toString(first[1] / first[2]);
				memR[1] = Double.toString(first[2] / numRequests);
				holeR[1] = Double.toString(first[2] / numRequests);
				//System.out.println("Requests Fulfilled: " + first[2]);
				double[] next = convoySim.runSimulationNextFit();
				memR[2] = Double.toString(next[0] / (next[2] * numRequests));
				holeR[2] = Double.toString(next[1] / next[2]);
				memR[3] = Double.toString(next[2] / numRequests);
				holeR[3] = Double.toString(next[2] / numRequests);
				double[] best = convoySim.runSimulationBestFit();
				memR[4] = Double.toString(best[0] / (best[2] * numRequests));
				holeR[4] = Double.toString(best[1] / best[2]);
				memR[5] = Double.toString(best[2] / numRequests);
				holeR[5] = Double.toString(best[2] / numRequests);
				double[] worst = convoySim.runSimulationWorstFit();
				memR[6] = Double.toString(worst[0] / (worst[2] * numRequests));
				holeR[6] = Double.toString(worst[1] / worst[2]);
				memR[7] = Double.toString(worst[2] / numRequests);
				holeR[7] = Double.toString(worst[2] / numRequests);
				memRows.add(memR);
				holeRows.add(holeR);
			}
			memRows.add(new String[]{" "});
			holeRows.add(new String[]{" "});
			
			System.out.println("Test case 9, reverse convoy requests");
			//Test Case 9: Reverse convoy requests
			memRows.add(new String[]{"Reverse convoy requests"});
			holeRows.add(new String[]{"Reverse convoy requests"});
			for(int times = 0; times < runTests; times++) {
				//Create a new row for each test run
				String[] memR = new String[8];
				String[] holeR = new String[8]; 
				//Run simulation
				Simulation revConvoySim = new Simulation(100, 50, numRequests, 9);
				double[] first = revConvoySim.runSimulationFirstFit();
				memR[0] = Double.toString(first[0] / (first[2] * numRequests));
				holeR[0] = Double.toString(first[1] / first[2]);
				memR[1] = Double.toString(first[2] / numRequests);
				holeR[1] = Double.toString(first[2] / numRequests);
				//System.out.println("Requests Fulfilled: " + first[2]);
				double[] next = revConvoySim.runSimulationNextFit();
				memR[2] = Double.toString(next[0] / (next[2] * numRequests));
				holeR[2] = Double.toString(next[1] / next[2]);
				memR[3] = Double.toString(next[2] / numRequests);
				holeR[3] = Double.toString(next[2] / numRequests);
				double[] best = revConvoySim.runSimulationBestFit();
				memR[4] = Double.toString(best[0] / (best[2] * numRequests));
				holeR[4] = Double.toString(best[1] / best[2]);
				memR[5] = Double.toString(best[2] / numRequests);
				holeR[5] = Double.toString(best[2] / numRequests);
				double[] worst = revConvoySim.runSimulationWorstFit();
				memR[6] = Double.toString(worst[0] / (worst[2] * numRequests));
				holeR[6] = Double.toString(worst[1] / worst[2]);
				memR[7] = Double.toString(worst[2] / numRequests);
				holeR[7] = Double.toString(worst[2] / numRequests);
				memRows.add(memR);
				holeRows.add(holeR);
			}
			memRows.add(new String[]{" "});
			holeRows.add(new String[]{" "});
			
			/* Next fit test suite */
			System.out.println("Running next fit test suite...");
			memRows.add(new String[]{"Next fit test suite:"});
			holeRows.add(new String[]{"Next fit test suite:"});
			System.out.println("Test case 10, slowly increase size of requests");
			//Test Case 10: Slowly increase size of requests
			memRows.add(new String[]{"Slowly increase size of requests"});
			holeRows.add(new String[]{"Slowly increase size of requests"});
			for(int times = 0; times < runTests; times++) {
				//Create a new row for each test run
				String[] memR = new String[8];
				String[] holeR = new String[8]; 
				//Run simulation
				Simulation incSim = new Simulation(100, 50, numRequests, 0.25);
				double[] first = incSim.runSimulationFirstFit();
				memR[0] = Double.toString(first[0] / (first[2] * numRequests));
				holeR[0] = Double.toString(first[1] / first[2]);
				memR[1] = Double.toString(first[2] / numRequests);
				holeR[1] = Double.toString(first[2] / numRequests);
				//System.out.println("Requests Fulfilled: " + first[2]);
				double[] next = incSim.runSimulationNextFit();
				memR[2] = Double.toString(next[0] / (next[2] * numRequests));
				holeR[2] = Double.toString(next[1] / next[2]);
				memR[3] = Double.toString(next[2] / numRequests);
				holeR[3] = Double.toString(next[2] / numRequests);
				double[] best = incSim.runSimulationBestFit();
				memR[4] = Double.toString(best[0] / (best[2] * numRequests));
				holeR[4] = Double.toString(best[1] / best[2]);
				memR[5] = Double.toString(best[2] / numRequests);
				holeR[5] = Double.toString(best[2] / numRequests);
				double[] worst = incSim.runSimulationWorstFit();
				memR[6] = Double.toString(worst[0] / (worst[2] * numRequests));
				holeR[6] = Double.toString(worst[1] / worst[2]);
				memR[7] = Double.toString(worst[2] / numRequests);
				holeR[7] = Double.toString(worst[2] / numRequests);
				memRows.add(memR);
				holeRows.add(holeR);
			}
			memRows.add(new String[]{" "});
			holeRows.add(new String[]{" "});
			
			System.out.println("Test case 11, slowly decrease size of requests");
			//Test Case 11: Slowly increase size of requests
			memRows.add(new String[]{"Slowly decrease size of requests"});
			holeRows.add(new String[]{"Slowly decrease size of requests"});
			for(int times = 0; times < runTests; times++) {
				//Create a new row for each test run
				String[] memR = new String[8];
				String[] holeR = new String[8]; 
				//Run simulation
				Simulation decSim = new Simulation(100, 50, numRequests, -0.25);
				double[] first = decSim.runSimulationFirstFit();
				memR[0] = Double.toString(first[0] / (first[2] * numRequests));
				holeR[0] = Double.toString(first[1] / first[2]);
				memR[1] = Double.toString(first[2] / numRequests);
				holeR[1] = Double.toString(first[2] / numRequests);
				//System.out.println("Requests Fulfilled: " + first[2]);
				double[] next = decSim.runSimulationNextFit();
				memR[2] = Double.toString(next[0] / (next[2] * numRequests));
				holeR[2] = Double.toString(next[1] / next[2]);
				memR[3] = Double.toString(next[2] / numRequests);
				holeR[3] = Double.toString(next[2] / numRequests);
				double[] best = decSim.runSimulationBestFit();
				memR[4] = Double.toString(best[0] / (best[2] * numRequests));
				holeR[4] = Double.toString(best[1] / best[2]);
				memR[5] = Double.toString(best[2] / numRequests);
				holeR[5] = Double.toString(best[2] / numRequests);
				double[] worst = decSim.runSimulationWorstFit();
				memR[6] = Double.toString(worst[0] / (worst[2] * numRequests));
				holeR[6] = Double.toString(worst[1] / worst[2]);
				memR[7] = Double.toString(worst[2] / numRequests);
				holeR[7] = Double.toString(worst[2] / numRequests);
				memRows.add(memR);
				holeRows.add(holeR);
			}
			memRows.add(new String[]{" "});
			holeRows.add(new String[]{" "});
			
			/* Best fit test suite */
			System.out.println("Running best fit test suite...");
			memRows.add(new String[]{"Best fit test suite:"});
			holeRows.add(new String[]{"Best fit test suite:"});
			System.out.println("Test case 1");
			//Test Case 1: d = 100, v = 0
			memRows.add(new String[]{"d = 100 and v = 0"});
			holeRows.add(new String[]{"d = 100 and v = 0"});
			for(int times = 0; times < runTests; times++) {	
				//Create a new row for each test run
				String[] memR = new String[8];
				String[] holeR = new String[8]; 
				//Run simulation
				Simulation sim6 = new Simulation(100, 0, numRequests);
				double[] first = sim6.runSimulationFirstFit();
				memR[0] = Double.toString(first[0] / (first[2] * numRequests));
				holeR[0] = Double.toString(first[1] / first[2]);
				memR[1] = Double.toString(first[2] / numRequests);
				holeR[1] = Double.toString(first[2] / numRequests);
				//System.out.println("Requests Fulfilled: " + first[2]);
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
				memRows.add(memR);
				holeRows.add(holeR);
			}
			memRows.add(new String[]{" "});
			holeRows.add(new String[]{" "});
			
			/* Worst Fit Test Suite */
			System.out.println("Running worst fit test suite...");
			memRows.add(new String[]{"Worst fit test suite:"});
			holeRows.add(new String[]{"Worst fit test suite:"});
			System.out.println("Test case 6");
			//Test Case 6: d = 10, v = 1
			memRows.add(new String[]{"d = 10 and v = 1"});
			holeRows.add(new String[]{"d = 10 and v = 1"});
			for(int times = 0; times < runTests; times++) {	
				//Create a new row for each test run
				String[] memR = new String[8];
				String[] holeR = new String[8]; 
				//Run simulation
				Simulation sim6 = new Simulation(10, 1, numRequests);
				double[] first = sim6.runSimulationFirstFit();
				memR[0] = Double.toString(first[0] / (first[2] * numRequests));
				holeR[0] = Double.toString(first[1] / first[2]);
				memR[1] = Double.toString(first[2] / numRequests);
				holeR[1] = Double.toString(first[2] / numRequests);
				//System.out.println("Requests Fulfilled: " + first[2]);
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
			
			System.out.println("Test case 7");
			//Test Case 7: d = 200, v = 1
			memRows.add(new String[]{"d = 200 and v = 1"});
			holeRows.add(new String[]{"d = 200 and v = 1"});
			for(int times = 0; times < runTests; times++) {	
				//Create a new row for each test run
				String[] memR = new String[8];
				String[] holeR = new String[8]; 
				//Run simulation
				Simulation sim6 = new Simulation(200, 1, numRequests);
				double[] first = sim6.runSimulationFirstFit();
				memR[0] = Double.toString(first[0] / (first[2] * numRequests));
				holeR[0] = Double.toString(first[1] / first[2]);
				memR[1] = Double.toString(first[2] / numRequests);
				holeR[1] = Double.toString(first[2] / numRequests);
				//System.out.println("Requests Fulfilled: " + first[2]);
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
			
			System.out.println("Writing to memUtilResults.csv file...");
			//Write to the CSV file
			for (String[] rowData : memRows) {
			    memWriter.append(String.join(",", rowData));
			    memWriter.append("\n");
			}
			
			System.out.println("Writing to holeResults.csv file...");
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