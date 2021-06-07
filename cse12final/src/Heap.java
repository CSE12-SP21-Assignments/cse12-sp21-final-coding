import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

// Max heap
public class Heap<K> implements PriorityQueue<K>, Iterable<K> {
	public List<K> elements;
	public Comparator<K> comparator;

	public Heap(Comparator<K> comparator) {
		this.elements = new ArrayList<>();
		this.comparator = comparator;
	}

	class HeapIterator implements Iterator<K> {
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public K next() {
			// TODO Auto-generated method stub
			return null;
		}

	}

	public Iterator<K> iterator() {
		// TODO: return the heap iterator
		return null;
	}

	public boolean isEmpty() {
		return elements.size() == 0;
	}

	public int parent(int index) {
		return (index - 1) / 2;
	}

	public int left(int index) {
		return index * 2 + 1;
	}

	public int right(int index) {
		return index * 2 + 2;
	}

	public void swap(int i1, int i2) {
		K tmp = this.elements.get(i1);
		this.elements.set(i1, this.elements.get(i2));
		this.elements.set(i2, tmp);
	}

	public void bubbleUp(int index) {
		if (index <= 0) {
			return;
		}
		K e = this.elements.get(index);
		K parent = this.elements.get(parent(index));
		int comp = this.comparator.compare(e, parent);
		if (comp > 0) {
			swap(index, parent(index));
			bubbleUp(parent(index));
		} else {
			return;
		}
	}

	public void add(K k) {
		this.elements.add(k);
		bubbleUp(this.elements.size() - 1);
	}

	public boolean existsAndGreater(int index1, int index2) {
		if (index1 >= this.elements.size()) {
			return false;
		}
		if (index2 >= this.elements.size()) {
			return false;
		}
		int comp = this.comparator.compare(this.elements.get(index1), this.elements.get(index2));
		if (comp > 0) {
			return true;
		}
		return false;
	}

	public void bubbleDown(int index) {
		if (index >= this.elements.size()) {
			return;
		}
		int leftIndex = left(index);
		if (leftIndex >= this.elements.size()) {
			return;
		}
		int largerChildIndex = leftIndex;
		int rightIndex = right(index);
		if (existsAndGreater(rightIndex, leftIndex)) {
			largerChildIndex = rightIndex;
		}
		if (existsAndGreater(largerChildIndex, index)) {
			swap(index, largerChildIndex);
			bubbleDown(largerChildIndex);
		}
	}

	public K peek() {
		if (this.elements.size() == 0) {
			throw new NoSuchElementException();
		}
		return this.elements.get(0);
	}

	public K poll() {
		if (this.elements.size() == 0) {
			throw new NoSuchElementException();
		}
		K e = this.elements.get(0);
		this.elements.set(0, this.elements.get(this.elements.size() - 1));
		this.elements.remove(this.elements.size() - 1);
		bubbleDown(0);
		return e;
	}

	public int size() {
		return this.elements.size();
	}

	public List<K> toArray() {
		return elements;
	}

	public String toString() {
		String representation = this.elements.size() + "\n";
		for (int i = 0; i < this.elements.size(); i++) {
			representation += elements.get(i) + "\n";
		}
		return representation;
	}
}