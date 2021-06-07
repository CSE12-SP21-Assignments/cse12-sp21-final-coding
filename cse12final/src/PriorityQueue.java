import java.util.List;

public interface PriorityQueue<K> {
	void add(K k);

	K poll();

	K peek();

	List<K> toArray();

	boolean isEmpty();

}