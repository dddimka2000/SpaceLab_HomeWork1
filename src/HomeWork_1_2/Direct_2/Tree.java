package HomeWork_1_2.Direct_2;

import java.util.LinkedList;
import java.util.List;

public class Tree {
    public static void main(String[] args) {
        Char_Tree char_tree=new Char_Tree();
        char_tree.add('f');
        char_tree.add('v');
        char_tree.add('g');
        char_tree.add('b');
        char_tree.add('a');
        char_tree.add('d');
        char_tree.add('c');
        char_tree.add('d');
        char_tree.breadthFirstTraversal(char_tree.treeNode);
        System.out.println("\n==========");
        char_tree.traversePreOrder(char_tree.treeNode);
    }
}
