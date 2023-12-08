package aufgabe2;

/**
 *
 * @author oliverbittel
 */
public abstract class AbstractFrequencyTable implements FrequencyTable {
	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public void add(String w) {
		add(w, 1);
	}

	@Override
	public void addAll(FrequencyTable fq) {
		// Ihr Code:
		for (int i = 0; i < fq.size(); i++) {
			this.add(fq.get(i).getWord(), fq.get(i).getFrequency());
		}
	}

	@Override
	public void collectNMostFrequent(int n, FrequencyTable fq) {
		// Ihr Code:
		if ( n <= 0 || n > size()) {
			throw new Error("n unlogische Zahl");
		}
		fq.clear();
		for (int i = 0; i < n; i++) {
			Word toAdd = get(i);
			fq.add(toAdd.getWord(), toAdd.getFrequency());
		}
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("{");
		// Ihr Code:
		for (int i = 0; i < size(); i++) {
			s.append(get(i).getWord()).append(":");
			s.append(get(i).getFrequency());
			if (i < size() - 1) {
				s.append(", ");
			}
		}
		s.append("} size = ").append(size());
		return s.toString();
	}
}
