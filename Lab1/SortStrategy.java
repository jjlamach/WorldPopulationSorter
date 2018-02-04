package Lab1;
/**
 * 
 * @author juliolama
 * The Strategy
 */
public interface SortStrategy {
	long sortingTime();
	void showSortingMethod();
	long[] sort(long[] items);
}
