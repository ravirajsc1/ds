package ravi.algo.concepts;

class EduTreeNode<T> {
    T data;
    EduTreeNode<T> left;
    EduTreeNode<T> right;
    EduTreeNode<T> next;

    EduTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.next = null;
    }
}