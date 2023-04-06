package HomeWork_1_2.RR;

public class V2 {
    public static void main(String[] args) {
        Box box=new Box<>();
        box.setContent(10);
        Box.printBoxContent(box);
    }
    public static class Box<T> {
        private T content;

        public T getContent() {
            return content;
        }

        public void setContent(T content) {
            this.content = content;
        }

        public static void printBoxContent(Box<?> box) {
            System.out.println(box.getContent());
        }
    }
}