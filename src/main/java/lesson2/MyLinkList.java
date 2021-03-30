package lesson2;

public class MyLinkList<E>  {

    private NodeLinkList<E> activeNode;
    private NodeLinkList<E> lastNode;
    private NodeLinkList<E> firstNode;

    Integer len;

    public MyLinkList(){
        this.activeNode = null;
        this.lastNode = null;
        this.firstNode = null;
        this.len = 0;
    }

    public  MyLinkList<E> addToEnd(E element){
        if (len == 0){
            activeNode = new NodeLinkList<>(element);
            lastNode = activeNode;
            firstNode = activeNode;
            len++;
            return this;
        }

        activeNode = new NodeLinkList<E>(element,null,lastNode);
        lastNode.next = activeNode;
        this.lastNode = activeNode;
        len++;
        return this;
    }

    public E getElement(){
        return (E) activeNode.element;
    }

    public E getElement(Integer position){

        shiftActiveElementTo(position);
        return getElement();
    }

    public MyLinkList<E> remove(Integer position){

        if(len == 1){
            return new MyLinkList<>();
        }

        NodeLinkList<E> removeElement = shiftActiveElementTo(position);
        NodeLinkList<E> previousElement = removeElement.previous;
        NodeLinkList<E> nextElement = removeElement.next;

        if ( !removeElement.isFirst() ){
            previousElement.setNext(nextElement);
        }else {
            this.firstNode = nextElement;
        }

        if( !removeElement.isLast() ){
            nextElement.setPrevious(previousElement);
        }else{
            this.lastNode = previousElement;
        }
        len--;

        return this;

    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder().append("[ ");
        activeNode = firstNode;
        for (int i=0; i < len; i++){
            stringBuilder.append(activeNode.getElement()).append(" ");
            activeNode = activeNode.getNext();
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public NodeLinkList<E> shiftActiveElementTo(Integer position){

        if (position>len ){
            throw  new IndexOutOfBoundsException();
        }

        activeNode = firstNode;

        for (int i=0; i < position-1; i++){
            activeNode = activeNode.next;
        }

        return activeNode;
    }

    public NodeLinkList<E> getActiveNode() {
        return activeNode;
    }

    public NodeLinkList<E> getLastNode() {
        return lastNode;
    }

    public NodeLinkList<E> getFirstNode() {
        return firstNode;
    }

    public Integer getLen() {
        return len;
    }
}
