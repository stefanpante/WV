package lucene;

public interface CompareStrategy {
	public double compare(Document first, Document second);
}
