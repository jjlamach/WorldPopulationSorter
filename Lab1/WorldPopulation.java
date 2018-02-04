package Lab1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
/**
 * @author Julio Lama
 * WorldPopulation sorting program that uses the Strategy Design pattern.
 * Sorts the world population (not exactly) using: Selection, Insertion and Bubble sort.
 */
public class WorldPopulation {

	SortStrategy sortStrategy;
	
	long[] population = new long[13484];
		
	public WorldPopulation(){
		sortStrategy = new Selection();
	}
	
	/* Read input from that file. */
	public void readInputFile(){
		population = readPopulationFile("src/WorldPopulation.csv");
	}
	
	public void setStrategy(SortStrategy strategy){
		sortStrategy = strategy;
	}
	
	/**
	 * Extract the numbers from the source file and filter them using the tokenizer. 
	 * */
	public long[] readPopulationFile(String fileName) {
		int index = 0;
		try {
			FileReader fileReader = new FileReader(fileName);	
			BufferedReader outputReader = new BufferedReader(fileReader);
			StringTokenizer tokenizer;	/*Tokenizer, filters the data based on some delimeters. */
			String line;
			while((line = outputReader.readLine()) != null) {
				tokenizer = new StringTokenizer(line, ",");
				tokenizer.nextToken();
				tokenizer.nextToken();
				population[index++] = Long.parseLong(tokenizer.nextToken());
			}
			outputReader.close();
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}
		return population;
	}
	
	
	/**
	 * Sorts the population using the sorting method selected.
	 */
	public void sortPopulation(){		
		sortStrategy.sort(population);
	}
	
	
	/**
	 * Shows the sorting method. 
	 * */
	public void showSortingMethod() {
		sortStrategy.showSortingMethod();
	}
	
	/**
	 * Gets the time for the sort.
	 * @return time it took to sort the input.
	 */
	public long showTime() {
		return Math.abs(sortStrategy.sortingTime());
	}
	
	
	public static void main(String[] args) {
		WorldPopulation worldPopulation = new WorldPopulation();
		
		worldPopulation.readInputFile();
		worldPopulation.setStrategy(new Selection());
		worldPopulation.sortPopulation();
		worldPopulation.showSortingMethod();
		long time = worldPopulation.showTime();
		System.out.println("Sorting time: " + time + " seconds.\n");
		
		worldPopulation.readInputFile();
		worldPopulation.setStrategy(new Bubble());
		worldPopulation.sortPopulation();
		worldPopulation.showSortingMethod();
		long time2 = worldPopulation.showTime();
		System.out.println("Sorting time for Bubble:" + time2 + " seconds.\n");
		
		worldPopulation.readInputFile();
		worldPopulation.setStrategy(new Insertion());
		worldPopulation.sortPopulation();
		worldPopulation.showSortingMethod();
		long time3 = worldPopulation.showTime();
		System.out.println("Sorting time for Insertion sort:" + time3 + " seconds.\n");	
	}
}
