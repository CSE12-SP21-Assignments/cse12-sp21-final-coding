public class AList<E> implements GenList<E> {

	E[] elements;
	int size;

	@SuppressWarnings("unchecked")
	public AList() {
		this.elements = (E[]) new Object[2];
		this.size = 0;
	}

	public void add(E s) {
		expandCapacity();
		this.elements[this.size] = s;
		this.size += 1;
	}

	public E get(int index) {
		if (index >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		return this.elements[index];
	}

	public int size() {
		return this.size;
	}

	@SuppressWarnings("unchecked")
	private void expandCapacity() {
		int currentCapacity = this.elements.length;
		if (this.size < currentCapacity) {
			return;
		}

		E[] expanded = (E[]) new Object[currentCapacity * 2];

		for (int i = 0; i < this.size; i += 1) {
			expanded[i] = this.elements[i];
		}
		this.elements = expanded;
	}

	// Assumes a valid index is given
	public void remove(int index) {
		for (int i = index; i < this.size - 1; i++) {
			this.elements[i] = this.elements[i + 1];
		}

		this.elements[size] = null;
		this.size -= 1;

		return;
	}

	// Assumes a valid index is given
	public void insert(int index, E s) {
		expandCapacity();

		for (int i = this.size; i > index; i--) {
			this.elements[i] = this.elements[i - 1];
		}

		this.elements[index] = s;
		this.size += 1;

		return;
	}

	public void prepend(E s) {
		this.insert(0, s);
		return;
	}
}