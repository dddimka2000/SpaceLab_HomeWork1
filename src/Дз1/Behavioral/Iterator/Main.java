package Äç1.Behavioral.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayContainer arrayContainer=new ArrayContainer();
        System.out.println(arrayContainer);
        while (arrayContainer.getIterator().hasNext()){
            System.out.println(arrayContainer.getIterator().next());
        }

    }
}
