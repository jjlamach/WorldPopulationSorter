package Lab1;
/**
 * 
 * @author Julio Lama
 * A concrete Strategy.
 */
public class Bubble implements SortStrategy{
	private long startingTime, endingTime;
	
	public Bubble(long[] items) {
		sort(items);
	}
	
	public Bubble() {
		
	}
	
	public void showSortingMethod() {
		System.out.println("Sorting by Bubble sort.");
	}
	
	/**
	 * Sorts using Bubble Sort.
	 */
	public long[] sort(long[] items) {
		this.startingTime = System.currentTimeMillis();
		for (int i = (items.length - 1); i >= 0; i--)
		{
			for (int j = 1; j <= i; j++)
			{
				if (items[j-1] > items[j])
				{
					long temp = items[j-1];
					items[j-1] = items[j];
					items[j] = temp;
				} 
			} 
		}
		this.endingTime = System.currentTimeMillis();
		return items;
	}

	@Override
	public long sortingTime() {
		return Math.abs(this.startingTime - this.endingTime);
	}
}
