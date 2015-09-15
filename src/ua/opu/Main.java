package ua.opu;

import ua.opu.structures.BinaryTree;

import java.sql.Time;

public class Main {

    public static void main(String[] args) {

        Time time1 = new Time(2,5,26);
        Time time2 = new Time(2,6,79);

        TimeInterval interval = new TimeInterval(time1,time2);
        System.out.println(interval.getTimeInterval());

        BinaryTree tree = new BinaryTree();
        tree.addNode(50,"root!");
        tree.addNode(45,"1");
        tree.addNode(47,"2");
        tree.addNode(39,"3");
        tree.addNode(62,"4");
        tree.addNode(69,"5");

        System.out.println("Прямой порядок");
        tree.traverseTree(BinaryTree.TraverseOrder.InOrder);
        System.out.println("Симметричный порядок");
        tree.traverseTree(BinaryTree.TraverseOrder.PreOrder);
        System.out.println("Обратный порядок");
        tree.traverseTree(BinaryTree.TraverseOrder.PostOrder);
    }
}
