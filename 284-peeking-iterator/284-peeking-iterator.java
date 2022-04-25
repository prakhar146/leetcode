// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Queue<Integer> integerQueue;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        integerQueue = new LinkedList<>();
        fillQueue(iterator);
	}
    
    private void fillQueue(Iterator<Integer> iterator) {
        while(iterator.hasNext()) {
            integerQueue.add(iterator.next());
        }
    }
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return integerQueue.peek();
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    return integerQueue.poll();
	}
	
	@Override
	public boolean hasNext() {
	    return !integerQueue.isEmpty();
	}
}