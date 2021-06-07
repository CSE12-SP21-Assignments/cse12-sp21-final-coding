import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author Juan Dominguez, Qiyue Wang 
 *
 * @param <K> The type of the keys of this BST. They need to be comparable by nature of the BST
 * @param <V> The type of the values of this BST. 
 */
public class BST<K extends Comparable<? super K>, V> implements DefaultMap<K, V>, Iterable<Node<K, V>> {
	
	private Node<K, V> root;
	private int size;
	private Comparator<K> comparator;
	
	public BST(Comparator<K> comparator) {
		this.comparator = comparator;
	}
	
	// In-order traversal
	class BSTIterator implements Iterator<Node<K, V>> {

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Node<K, V> next() {
			// TODO Auto-generated method stub
			return null;
		}

	}
	
	@Override
	public Iterator<Node<K, V>> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean put(K key, V value) throws IllegalArgumentException {
		if (key == null) {
			throw new IllegalArgumentException(DefaultMap.ILLEGAL_ARG_NULL_KEY);
		}
		
		Node<K, V> toInsert = new Node<>(key, value);
		
		if (insert(toInsert)) {
			++size;
			return true;
		}
		
		return false;
	}
	
	// insert node if key is not present and not null
	private boolean insert(Node<K, V> toInsert) {
		if (root == null) {
			root = toInsert;
			return true;
		} 
		
		Node<K, V> currNode = root;
		
		while (currNode != null) {
			if (comparator.compare(toInsert.getKey(), currNode.getKey()) == 0) {
				return false;
			} else if (comparator.compare(toInsert.getKey(), currNode.getKey()) < 0) {
				if (currNode.left == null) {
					currNode.left = toInsert;
					break;
				} else {
					currNode = currNode.left;
				}
			} else {
				if (currNode.right == null) {
					currNode.right = toInsert;
					break;
				} else {
					currNode = currNode.right;
				}
			}
		}
		return true;
	}

	@Override
	public boolean replace(K key, V newValue) throws IllegalArgumentException {
		Node<K, V> targetNode = find(key);
		if (targetNode == null) {
			return false;
		}
		
		targetNode.value = newValue;
		return true;
	}

	@Override
	public boolean remove(K key) throws IllegalArgumentException {
		Node<K, V> target = find(key);
		if (target == null) {
			return false;
		}
		
		root = remove(root, key);
		--size;
		return true;
	}
	

	private Node<K, V> remove(Node<K, V> subroot, K key) {
		if (subroot == null) {
			return subroot;
		}
		
		if (comparator.compare(key, subroot.getKey()) < 0) {
			subroot.left = remove(subroot.left, key);
		} else if (comparator.compare(key, subroot.getKey()) > 0) {
			subroot.right = remove(subroot.right, key);
		} else {
			if (subroot.left == null) {
				return subroot.right;
			} else if (subroot.right == null) {
				return subroot.left;
			}
			
			Node<K, V> successor = subroot.successor();
			subroot.key = successor.key;
			subroot.value = successor.value;
			
			// recursively remove the successor from the right subtree since it's now the root
			subroot.right = remove(subroot.right, subroot.key);
		
		}
		return subroot;
	}

	@Override
	public void set(K key, V value) throws IllegalArgumentException {
		if (!replace(key, value)) {
			put(key, value);
		}
		
	}

	@Override
	public V get(K key) throws IllegalArgumentException {
		Node<K, V> targetNode = find(key);
		return (targetNode == null) ? null : targetNode.value;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	// IMPORTANT: the list of keys must maintain sorted order of keys
	@Override
	public boolean containsKey(K key) throws IllegalArgumentException {
		return find(key) != null;
	}
	
	// search this BST for the specified key, returning the node of where
	// the key is if it exists, or where it should be if it doesn't. 
	private Node<K, V> find(K key) {
		if (key == null) {
			throw new IllegalArgumentException(DefaultMap.ILLEGAL_ARG_NULL_KEY);
		}
		
		Node<K, V> currNode = root;
		
		while (currNode != null) {
			if (key.equals(currNode.key)) {
				return currNode;
			} else if (comparator.compare(key, currNode.getKey()) < 0) {
				currNode = currNode.left;
			} else {
				currNode = currNode.right;
			}
		}
		
		return null;	
	}

	/**
	 * For a BST, the keys should be sorted. 
	 */
	@Override
	public List<K> keys() {
		Stack<Node<K, V>> iter = new Stack<>(); 
		List<K> keys = new ArrayList<>(size);
		Node<K, V> currNode = root;
		while (currNode != null) {
			iter.push(currNode);
			currNode = currNode.left;
		}
		
		while (!iter.isEmpty()) {
			currNode = iter.pop();
			keys.add(currNode.key);
			currNode = currNode.right;
			while (currNode != null) {
				iter.push(currNode);
				currNode = currNode.left;
			}
		}
		return keys;
	}
	 
}

class Node<K extends Comparable<? super K>, V> implements DefaultMap.Entry<K, V>{
	
	K key;
	V value;
	Node<K, V> left;
	Node<K, V> right;
	
	public Node(K key, V value) {
		this.key = key;
		this.value = value;
	}
	

	@Override
	public K getKey() {
		return key;
	}

	@Override
	public V getValue() {
		return value;
	}

	@Override
	public void setValue(V value) {
		this.value = value;
	}
	
	// return this Node's right subtree's leftmost value (smallest on the subtree)
	public Node<K, V> successor() {
		if (right == null) {
			return null;
		}
		
		Node<K, V> successor = right;
		while (successor.left != null) {
			successor = successor.left;
		}
		
		return successor;
	}
	
}