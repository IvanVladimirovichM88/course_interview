package lesson2;

public class MyArrayList<E> {
    private final static Integer MIN_SIZE = 10;
    Object[] array;
    Integer len;
    Integer size;

    public MyArrayList() {
        this.array = new Object[MIN_SIZE];
        this.len = 0;
        this.size = MIN_SIZE;
    }

    public MyArrayList(Object[] initArray ){
        this.array = initArray;
        this.len = initArray.length;
        this.size = this.len + 10;
    }

    public boolean add(E element){

        if ( (size-len) < 10 ){
            Object[] newArray = new Object[size*2];
            for (int i=0; i<len; i++){
                newArray[i] = this.array[i];
            }
            this.array = newArray;
        }

        array[len] = element;

        len++;

        return true;
    }

    public E remove(Integer position){

        if (position >= len )
            throw  new IndexOutOfBoundsException( position );

        if (position == (len-1)){
            array[position] = null;
        }else{
            for (int i=position; i< len; i++){
                array[i] = array[i+1];
            }
            array[len-1] = null;
        }
        len--;
        return (E) array[position-1];
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder().append("[ ");
        for (int i=0; i<len; i++) {
            stringBuilder.append(this.array[i])
                         .append(" ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public E getElement(Integer position){
        if (position >= len )
            throw  new IndexOutOfBoundsException( position );

        return (E) array[position];
    }


}
