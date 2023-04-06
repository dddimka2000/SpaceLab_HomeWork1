package HomeWork_1_2.Direct_2;

    public class Node {
        char value;
        public Node left;
        public Node right;

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public char getValue() {
            return value;
        }

        public Node(char value) {
            this.value = value;
        }
    }

