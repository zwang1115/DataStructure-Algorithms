package Design.LeetCode;

import java.util.Iterator;

public class _284PeekingIterator {

    private Iterator<Integer> iter;
    Integer next = null;
    public _284PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
        if (iter.hasNext()) {
            next = iter.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.

    public Integer next() {
        Integer res = next;
        next = iter.hasNext() ? iter.next() : null;
        return res;
    }

    public boolean hasNext() {
        return next != null;
    }
}
