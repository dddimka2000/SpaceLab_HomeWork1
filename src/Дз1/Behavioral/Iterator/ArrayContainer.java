package ��1.Behavioral.Iterator;

public class ArrayContainer implements Container{

    public String[] array= {"Mark","Dina","Alice"};
    int index=0;

    @Override
    public Iterator getIterator() {
        return new ArrayIterator();
    }
    //����� ������������ ���������, ���� ��������
     private class ArrayIterator implements Iterator{
         @Override
        public boolean hasNext() {
            return (index<array.length)?true:false;
        }

        @Override
        public Object next() {
            if(hasNext()==true){
                return array[index++];
            }
                return null;
        }
    }
}
