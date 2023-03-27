package HomeWork_1_0.ƒз1.Behavioral.Iterator;

public class ArrayContainer implements Container{

    public String[] array= {"Mark","Dina","Alice"};
    int index=0;

    @Override
    public Iterator getIterator() {
        return new ArrayIterator();
    }
    //можно использовать сингелтон, если доделать
     private class ArrayIterator implements Iterator{
         @Override
        public boolean hasNext() {
            return index < array.length;
        }

        @Override
        public Object next() {
            if(hasNext()){

                return array[index++];

            }
                return null;
        }
    }
}
