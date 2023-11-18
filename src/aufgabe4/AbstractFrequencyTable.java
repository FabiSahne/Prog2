package aufgabe4;

/**
 *
 * @author oliverbittel
 */
public abstract class AbstractFrequencyTable<T> implements FrequencyTable<T> {
	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public void add(T w) {
		add(w, 1);
	}

	@Override
	public void addAll(FrequencyTable<? extends T> fq) {
		// Ihr Code:
		for (Element<? extends T> e : fq) {
			this.add(e.getWord(), e.getFrequency());
		}
	}

	@Override
	public void collectNMostFrequent(int n, FrequencyTable<? super T> fq) {
		// Ihr Code:
		if ( n <= 0 || n > size()) {
			throw new Error("n unlogische Zahl");
		}
		fq.clear();
		for (int i = 0; i < n; i++) {
			Element<T> toAdd = get(i);
			fq.add(toAdd.getWord(), toAdd.getFrequency());
		}
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("{");
		// Ihr Code:

		for (Element<? extends T> e : this) {
			s.append(e.getWord());
			s.append(":");
			s.append(e.getFrequency());
			s.append(", ");
		}

		s.append("} size = ");
		s.append(size());
		return s.toString();
	}
}
