package Lab1;
/**
 * 
 * @author Julio Lama
 * A concrete Strategy
 */
public class Insertion implements SortStrategy {
	private long startingTime, endingTime;
	
	public Insertion(long[] items) {
		sort(items);
	}
	
	public Insertion() {
		
	}
	
	public void showSortingMethod() {
		System.out.println("Sorting by Insertion sort.");
	}
	
	public long [] sort(long[] items) {
		this.startingTime = System.currentTimeMillis();
		for (int i=1; i < items.length; i++)
		{
			long index = items[i]; int j = i;
			while (j > 0 && items[j-1] > index)
			{
				items[j] = items[j-1];
				j--;
			}
			items[j] = index;
		} 
		this.endingTime = System.currentTimeMillis();
		return items;
	}
	@Override
	public long sortingTime() {
		return this.startingTime - this.endingTime;
	}
}
