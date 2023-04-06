package HomeWork_1_2.Direct_2;

import java.util.LinkedList;
import java.util.Queue;

public class Char_Tree {
    Node treeNode;
    public Char_Tree() {
        this.treeNode = null;
    }

    public void add(char value) {
        Node newNode = new Node(value);
        if (treeNode == null) {
            treeNode= newNode;
        }
        else {
            Node currentNode = treeNode;
            Node parentNode;
            while (true)
            {
                parentNode = currentNode;
                if(value == currentNode.getValue()) {   // ���� ����� ������� � ������ ��� ����, �� ��������� ���
                    return;
                }
                else  if (value < currentNode.getValue()) {   // �������� �����
                    currentNode = currentNode.getLeft();
                    if (currentNode == null){ // ����� �������
                        parentNode.setLeft(newNode);
                        return;
                    }
                }
                else {
                    currentNode = currentNode.getRight();
                    if (currentNode == null) { // ���� ��� ��������� ����� �������,
                        parentNode.setRight(newNode);  //�� �������� ������
                        return; // � �����
                    }
                }
            }
        }
    }

    public void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            traversePreOrder(node.getLeft());
            traversePreOrder(node.getRight());
        }
    }
    public void breadthFirstTraversal(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            System.out.print(current.getValue() + " ");
            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
    }
}










//    public void printTree() {
//        Stack globalStack = new Stack();
//        globalStack.push(treeNode);
//        int gaps = 100; // �������� ���������� ����� ����������
//        boolean isRowEmpty = false;
//
//        while (isRowEmpty == false) {
//            Stack localStack = new Stack(); // ��������� ���� ��� ������� �������� ��������
//            isRowEmpty = true;
//
//            for (int j = 0; j < gaps; j++)
//                System.out.print(' ');
//            while (globalStack.isEmpty() == false) { // ������ � ����� ����� ���� ��������
//                Node temp = (Node) globalStack.pop(); // ����� ���������, ��� ���� ������ ��� �� �����
//                if (temp != null) {
//                    System.out.print(temp.getValue()); // ������� ��� �������� � �������
//                    localStack.push(temp.getLeft()); // ���������� � ��������� ����, ���������� �������� ��������
//                    localStack.push(temp.getRight());
//                    if (temp.getLeft() != null ||
//                            temp.getRight() != null)
//                        isRowEmpty = false;
//                }
//                else {
//                    System.out.print("__");// - ���� ������� ������
//                    localStack.push(null);
//                    localStack.push(null);
//                }
//                for (int j = 0; j < gaps * 2 - 2; j++)
//                    System.out.print(' ');
//            }
//            System.out.println();
//            gaps /= 2;// ��� �������� �� ��������� ������� ���������� ����� ���������� ������ ��� �����������
//            while (localStack.isEmpty() == false)
//                globalStack.push(localStack.pop()); // ���������� ��� �������� �� ���������� ����� � ����������
//        }
//    }