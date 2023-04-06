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
                if(value == currentNode.getValue()) {   // если такой элемент в дереве уже есть, не сохраняем его
                    return;
                }
                else  if (value < currentNode.getValue()) {   // движение влево
                    currentNode = currentNode.getLeft();
                    if (currentNode == null){ // конец цепочки
                        parentNode.setLeft(newNode);
                        return;
                    }
                }
                else {
                    currentNode = currentNode.getRight();
                    if (currentNode == null) { // если был достигнут конец цепочки,
                        parentNode.setRight(newNode);  //то вставить справа
                        return; // и выйти
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
//        int gaps = 100; // значение расстояния между элементами
//        boolean isRowEmpty = false;
//
//        while (isRowEmpty == false) {
//            Stack localStack = new Stack(); // локальный стек для задания потомков элемента
//            isRowEmpty = true;
//
//            for (int j = 0; j < gaps; j++)
//                System.out.print(' ');
//            while (globalStack.isEmpty() == false) { // покуда в общем стеке есть элементы
//                Node temp = (Node) globalStack.pop(); // берем следующий, при этом удаляя его из стека
//                if (temp != null) {
//                    System.out.print(temp.getValue()); // выводим его значение в консоли
//                    localStack.push(temp.getLeft()); // соохраняем в локальный стек, наследники текущего элемента
//                    localStack.push(temp.getRight());
//                    if (temp.getLeft() != null ||
//                            temp.getRight() != null)
//                        isRowEmpty = false;
//                }
//                else {
//                    System.out.print("__");// - если элемент пустой
//                    localStack.push(null);
//                    localStack.push(null);
//                }
//                for (int j = 0; j < gaps * 2 - 2; j++)
//                    System.out.print(' ');
//            }
//            System.out.println();
//            gaps /= 2;// при переходе на следующий уровень расстояние между элементами каждый раз уменьшается
//            while (localStack.isEmpty() == false)
//                globalStack.push(localStack.pop()); // перемещаем все элементы из локального стека в глобальный
//        }
//    }