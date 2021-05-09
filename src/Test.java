import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
//		Simulation test8 = new Simulation(100, 50, 200, 8);
//		test8.printRequestList();
//		Simulation test9 = new Simulation(100, 50, 200, 9);
//		test9.printRequestList();
//		Simulation test10 = new Simulation(100, 50, 200, 0.25);
//		test10.printRequestList();
//		Simulation test11 = new Simulation(100, 50, 200, -0.25);
//		test11.printRequestList();
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
				String[] memR = new String[4];
				String[] holeR = new String[4]; 
				//Run simulation
				Simulation convoySim = new Simulation(100, 50, numRequests, 8);
				double[] first = convoySim.runSimulationFirstFit();
				memR[0] = Double.toString(first[0] / (first[2] * numRequests));
				holeR[0] = Double.toString(first[1] / first[2]);
				double[] next = convoySim.runSimulationNextFit();
				memR[1] = Double.toString(next[0] / (next[2] * numRequests));
				holeR[1] = Double.toString(next[1] / next[2]);
				double[] best = convoySim.runSimulationBestFit();
				memR[2] = Double.toString(best[0] / (best[2] * numRequests));
				holeR[2] = Double.toString(best[1] / best[2]);
				double[] worst = convoySim.runSimulationWorstFit();
				memR[3] = Double.toString(worst[0] / (worst[2] * numRequests));
				holeR[3] = Double.toString(worst[1] / worst[2]);
				memRows.add(memR);
				holeRows.add(holeR);
			}
			memRows.add(new String[]{" "});
			holeRows.add(new String[]{" "});
			
			System.out.println("Test case 9, reverse convoy requests");
			//Test Case 11: Slowly increase size of requests
			memRows.add(new String[]{"Reverse convoy requests"});
			holeRows.add(new String[]{"Reverse convoy requests"});
			for(int times = 0; times < runTests; times++) {
				//Create a new row for each test run
				String[] memR = new String[4];
				String[] holeR = new String[4]; 
				//Run simulation
				Simulation revConvoySim = new Simulation(100, 50, numRequests, 9);
				double[] first = revConvoySim.runSimulationFirstFit();
				memR[0] = Double.toString(first[0] / (first[2] * numRequests));
				holeR[0] = Double.toString(first[1] / first[2]);
				double[] next = revConvoySim.runSimulationNextFit();
				memR[1] = Double.toString(next[0] / (next[2] * numRequests));
				holeR[1] = Double.toString(next[1] / next[2]);
				double[] best = revConvoySim.runSimulationBestFit();
				memR[2] = Double.toString(best[0] / (best[2] * numRequests));
				holeR[2] = Double.toString(best[1] / best[2]);
				double[] worst = revConvoySim.runSimulationWorstFit();
				memR[3] = Double.toString(worst[0] / (worst[2] * numRequests));
				holeR[3] = Double.toString(worst[1] / worst[2]);
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
				String[] memR = new String[4];
				String[] holeR = new String[4]; 
				//Run simulation
				Simulation incSim = new Simulation(100, 50, numRequests, 0.25);
				double[] first = incSim.runSimulationFirstFit();
				memR[0] = Double.toString(first[0] / (first[2] * numRequests));
				holeR[0] = Double.toString(first[1] / first[2]);
				double[] next = incSim.runSimulationNextFit();
				memR[1] = Double.toString(next[0] / (next[2] * numRequests));
				holeR[1] = Double.toString(next[1] / next[2]);
				double[] best = incSim.runSimulationBestFit();
				memR[2] = Double.toString(best[0] / (best[2] * numRequests));
				holeR[2] = Double.toString(best[1] / best[2]);
				double[] worst = incSim.runSimulationWorstFit();
				memR[3] = Double.toString(worst[0] / (worst[2] * numRequests));
				holeR[3] = Double.toString(worst[1] / worst[2]);
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
				String[] memR = new String[4];
				String[] holeR = new String[4]; 
				//Run simulation
				Simulation decSim = new Simulation(100, 50, numRequests, -0.25);
				double[] first = decSim.runSimulationFirstFit();
				memR[0] = Double.toString(first[0] / (first[2] * numRequests));
				holeR[0] = Double.toString(first[1] / first[2]);
				double[] next = decSim.runSimulationNextFit();
				memR[1] = Double.toString(next[0] / (next[2] * numRequests));
				holeR[1] = Double.toString(next[1] / next[2]);
				double[] best = decSim.runSimulationBestFit();
				memR[2] = Double.toString(best[0] / (best[2] * numRequests));
				holeR[2] = Double.toString(best[1] / best[2]);
				double[] worst = decSim.runSimulationWorstFit();
				memR[3] = Double.toString(worst[0] / (worst[2] * numRequests));
				holeR[3] = Double.toString(worst[1] / worst[2]);
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
				String[] memR = new String[4];
				String[] holeR = new String[4]; 
				//Run simulation
				Simulation sim1 = new Simulation(100, 0, numRequests);
				double[] first = sim1.runSimulationFirstFit();
				memR[0] = Double.toString(first[0] / (first[2] * numRequests));
				holeR[0] = Double.toString(first[1] / first[2]);
				double[] next = sim1.runSimulationNextFit();
				memR[1] = Double.toString(next[0] / (next[2] * numRequests));
				holeR[1] = Double.toString(next[1] / next[2]);
				double[] best = sim1.runSimulationBestFit();
				memR[2] = Double.toString(best[0] / (best[2] * numRequests));
				holeR[2] = Double.toString(best[1] / best[2]);
				double[] worst = sim1.runSimulationWorstFit();
				memR[3] = Double.toString(worst[0] / (worst[2] * numRequests));
				holeR[3] = Double.toString(worst[1] / worst[2]);
				memRows.add(memR);
				holeRows.add(holeR);
			}
			memRows.add(new String[]{" "});
			holeRows.add(new String[]{" "});
			
			System.out.println("Test case 2");
			//Test Case 2: d = 100, v = 10
			memRows.add(new String[]{"d = 100 and v = 10"});
			holeRows.add(new String[]{"d = 100 and v = 10"});
			for(int times = 0; times < runTests; times++) {	
				//Create a new row for each test run
				String[] memR = new String[4];
				String[] holeR = new String[4]; 
				//Run simulation
				Simulation sim2 = new Simulation(100, 10, numRequests);
				double[] first = sim2.runSimulationFirstFit();
				memR[0] = Double.toString(first[0] / (first[2] * numRequests));
				holeR[0] = Double.toString(first[1] / first[2]);
				double[] next = sim2.runSimulationNextFit();
				memR[1] = Double.toString(next[0] / (next[2] * numRequests));
				holeR[1] = Double.toString(next[1] / next[2]);
				double[] best = sim2.runSimulationBestFit();
				memR[2] = Double.toString(best[0] / (best[2] * numRequests));
				holeR[2] = Double.toString(best[1] / best[2]);
				double[] worst = sim2.runSimulationWorstFit();
				memR[3] = Double.toString(worst[0] / (worst[2] * numRequests));
				holeR[3] = Double.toString(worst[1] / worst[2]);
				//Add rows to csv files
				memRows.add(memR);
				holeRows.add(holeR);
			}
			memRows.add(new String[]{" "});
			holeRows.add(new String[]{" "});
			
			System.out.println("Test case 3");
			//Test Case 3: d = 100, v = 50
			memRows.add(new String[]{"d = 100 and v = 50"});
			holeRows.add(new String[]{"d = 100 and v = 50"});
			for(int times = 0; times < runTests; times++) {	
				//Create a new row for each test run
				String[] memR = new String[4];
				String[] holeR = new String[4]; 
				//Run simulation
				Simulation sim3 = new Simulation(100, 50, numRequests);
				double[] first = sim3.runSimulationFirstFit();
				memR[0] = Double.toString(first[0] / (first[2] * numRequests));
				holeR[0] = Double.toString(first[1] / first[2]);
				double[] next = sim3.runSimulationNextFit();
				memR[1] = Double.toString(next[0] / (next[2] * numRequests));
				holeR[1] = Double.toString(next[1] / next[2]);
				double[] best = sim3.runSimulationBestFit();
				memR[2] = Double.toString(best[0] / (best[2] * numRequests));
				holeR[2] = Double.toString(best[1] / best[2]);
				double[] worst = sim3.runSimulationWorstFit();
				memR[3] = Double.toString(worst[0] / (worst[2] * numRequests));
				holeR[3] = Double.toString(worst[1] / worst[2]);
				//Add rows to csv files
				memRows.add(memR);
				holeRows.add(holeR);
			}
			memRows.add(new String[]{" "});
			holeRows.add(new String[]{" "});
			
			System.out.println("Test case 4");
			//Test Case 4: d = 100, v = 90
			memRows.add(new String[]{"d = 100 and v = 90"});
			holeRows.add(new String[]{"d = 100 and v = 90"});
			for(int times = 0; times < runTests; times++) {	
				//Create a new row for each test run
				String[] memR = new String[4];
				String[] holeR = new String[4]; 
				//Run simulation
				Simulation sim4 = new Simulation(100, 90, numRequests);
				double[] first = sim4.runSimulationFirstFit();
				memR[0] = Double.toString(first[0] / (first[2] * numRequests));
				holeR[0] = Double.toString(first[1] / first[2]);
				double[] next = sim4.runSimulationNextFit();
				memR[1] = Double.toString(next[0] / (next[2] * numRequests));
				holeR[1] = Double.toString(next[1] / next[2]);
				double[] best = sim4.runSimulationBestFit();
				memR[2] = Double.toString(best[0] / (best[2] * numRequests));
				holeR[2] = Double.toString(best[1] / best[2]);
				double[] worst = sim4.runSimulationWorstFit();
				memR[3] = Double.toString(worst[0] / (worst[2] * numRequests));
				holeR[3] = Double.toString(worst[1] / worst[2]);
				//Add rows to csv files
				memRows.add(memR);
				holeRows.add(holeR);
			}
			memRows.add(new String[]{" "});
			holeRows.add(new String[]{" "});
			
			System.out.println("Test case 5");
			//Test Case 5: d = 100, v = 99
			memRows.add(new String[]{"d = 100 and v = 99"});
			holeRows.add(new String[]{"d = 100 and v = 99"});
			for(int times = 0; times < runTests; times++) {	
				//Create a new row for each test run
				String[] memR = new String[4];
				String[] holeR = new String[4]; 
				//Run simulation
				Simulation sim5 = new Simulation(100, 99, numRequests);
				double[] first = sim5.runSimulationFirstFit();
				memR[0] = Double.toString(first[0] / (first[2] * numRequests));
				holeR[0] = Double.toString(first[1] / first[2]);
				double[] next = sim5.runSimulationNextFit();
				memR[1] = Double.toString(next[0] / (next[2] * numRequests));
				holeR[1] = Double.toString(next[1] / next[2]);
				double[] best = sim5.runSimulationBestFit();
				memR[2] = Double.toString(best[0] / (best[2] * numRequests));
				holeR[2] = Double.toString(best[1] / best[2]);
				double[] worst = sim5.runSimulationWorstFit();
				memR[3] = Double.toString(worst[0] / (worst[2] * numRequests));
				holeR[3] = Double.toString(worst[1] / worst[2]);
				//Add rows to csv files
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
				String[] memR = new String[4];
				String[] holeR = new String[4]; 
				//Run simulation
				Simulation sim6 = new Simulation(10, 1, numRequests);
				double[] first = sim6.runSimulationFirstFit();
				memR[0] = Double.toString(first[0] / (first[2] * numRequests));
				holeR[0] = Double.toString(first[1] / first[2]);
				double[] next = sim6.runSimulationNextFit();
				memR[1] = Double.toString(next[0] / (next[2] * numRequests));
				holeR[1] = Double.toString(next[1] / next[2]);
				double[] best = sim6.runSimulationBestFit();
				memR[2] = Double.toString(best[0] / (best[2] * numRequests));
				holeR[2] = Double.toString(best[1] / best[2]);
				double[] worst = sim6.runSimulationWorstFit();
				memR[3] = Double.toString(worst[0] / (worst[2] * numRequests));
				holeR[3] = Double.toString(worst[1] / worst[2]);
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
				String[] memR = new String[4];
				String[] holeR = new String[4]; 
				//Run simulation
				Simulation sim7 = new Simulation(200, 1, numRequests);
				double[] first = sim7.runSimulationFirstFit();
				memR[0] = Double.toString(first[0] / (first[2] * numRequests));
				holeR[0] = Double.toString(first[1] / first[2]);
				double[] next = sim7.runSimulationNextFit();
				memR[1] = Double.toString(next[0] / (next[2] * numRequests));
				holeR[1] = Double.toString(next[1] / next[2]);
				double[] best = sim7.runSimulationBestFit();
				memR[2] = Double.toString(best[0] / (best[2] * numRequests));
				holeR[2] = Double.toString(best[1] / best[2]);
				double[] worst = sim7.runSimulationWorstFit();
				memR[3] = Double.toString(worst[0] / (worst[2] * numRequests));
				holeR[3] = Double.toString(worst[1] / worst[2]);
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