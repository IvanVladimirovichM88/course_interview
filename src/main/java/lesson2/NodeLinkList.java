package lesson2;

public class NodeLinkList<E> {
    Object element;
    NodeLinkList<E> next;
    NodeLinkList<E> previous;

    public NodeLinkList() {
    }

    public NodeLinkList(Object element, NodeLinkList<E> next, NodeLinkList<E> previous) {
        this.element = element;
        this.next = next;
        this.previous = previous;
    }

    public NodeLinkList(Object element){
        this.element = element;
        this.next = null;
        this.previous = null;
    }

    public boolean isLast(){
        return next == null;
    }

    public boolean isFirst(){
        return previous == null;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public NodeLinkList<E> getNext() {
        return next;
    }


    public NodeLinkList<E>  getPrevious() {
        return previous;
    }

    public void setNext(NodeLinkList<E> next) {
        this.next = next;
    }

    public void setPrevious(NodeLinkList<E> previous) {
        this.previous = previous;
    }
}
