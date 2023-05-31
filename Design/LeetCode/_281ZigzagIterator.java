package Design.LeetCode;

import java.util.Iterator;
import java.util.List;

public class _281ZigzagIterator {

    private Iterator<Integer> i, j, temp;
    public _281ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        i = v2.iterator();
        j = v1.iterator();
    }

    public int next() {
        if (j.hasNext()) {
            temp = j;
            j = i;
            i = temp;
        }
        return i.next();
    }

    public boolean hasNext() {
        return i.hasNext() || j.hasNext();
    }
}
