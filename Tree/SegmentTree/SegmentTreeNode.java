package Tree.SegmentTree;

public class SegmentTreeNode {

    int start;
    int end;
    SegmentTreeNode left;
    SegmentTreeNode right;
    int sum;


    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.right = null;
        this.left = null;
        this.sum = 0;
    }
}
