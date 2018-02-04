package Lab1;
/**
 * 
 * @author Julio Lama
 * A concrete Strategy
 */
public class Selection implements SortStrategy {
	private long startingTime, endingTime;
	
	public Selection(long[] items) {
		sort(items);
	}
	public Selection() {
		
	}
	
	public void showSortingMethod() {
		System.out.println("Sorting by Selection sort.");
	}
	
	public long[] sort(long[] items) {
		this.startingTime = System.currentTimeMillis();
		for (int i = 0; i < items.length-1; i++)
		{
			int min = i;
			for (int j = i+1; j < items.length; j++)
				if (items[j] < items[min]) min = j;
			long temp = items[i];
			items[i] = items[min];
			items[min] = temp;
		} 
		this.endingTime = System.currentTimeMillis();
		return items;
	}
	@Override
	public long sortingTime() {
		return Math.abs(this.startingTime - this.endingTime);
	}

}
