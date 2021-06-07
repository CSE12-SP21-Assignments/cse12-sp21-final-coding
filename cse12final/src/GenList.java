public interface GenList<E> {
	void add(E s);
	E get(int index);
	int size();
	void remove(int index);
	void insert(int index, E s);
	void prepend(E s);
}