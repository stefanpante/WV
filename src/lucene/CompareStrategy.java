package lucene;

public interface CompareStrategy {
	public double compare(IndexedDocument first, IndexedDocument second);
}
