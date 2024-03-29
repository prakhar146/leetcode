// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> it;
    Integer next;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    it = iterator;
        if(iterator.hasNext()) {
            next = iterator.next();
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer nextValue = next;
        if(it.hasNext()) {
            next = it.next();
        } else {
            next = null;
        }
        return nextValue;
	}
	
	@Override
	public boolean hasNext() {
	    return (next != null);
	}
}