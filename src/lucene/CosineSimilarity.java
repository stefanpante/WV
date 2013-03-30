package lucene;

import java.util.HashSet;
import java.util.Map;

import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;

public class CosineSimilarity implements CompareStrategy {

	private HashSet<String> terms;

	@Override
	public double compare(IndexedDocument first, IndexedDocument second) {
		terms = new HashSet<String>();
		terms.addAll(first.termFrequencies.keySet());
		terms.addAll(second.termFrequencies.keySet());
		RealVector firstVector = calculateRealVector(first.termFrequencies);
		RealVector secondVector = calculateRealVector(second.termFrequencies);
		return calculateCosineSimilarity(firstVector, secondVector);
	}

	private double calculateCosineSimilarity(RealVector first, RealVector second) {
		return (first.dotProduct(second)) / (first.getNorm() * second.getNorm());
	}

	private RealVector calculateRealVector(Map<String, Integer> map) {
		RealVector vector = new ArrayRealVector(terms.size());
		int i = 0;
		for (String term : terms) {
			int value = map.containsKey(term) ? map.get(term) : 0;
			vector.setEntry(i++, value);
		}
		return (RealVector) vector.mapDivide(vector.getL1Norm());
	}
}
