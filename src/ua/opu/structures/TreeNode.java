package ua.opu.structures;

/**
 * Класс описывает узел бинарного дерева.
 * Узел дерева должен иметь:
 * - ключ (int)
 * - значение (допустим, у нас будет String)
 * - ссылка на левого потомка (объект класса TreeNode)
 * - ссылка на правого потомка (объект класса TreeNode)
 */
public class TreeNode {

    private int key;
    private String value;

    private TreeNode leftChild;
    private TreeNode rightChild;

    /**
     * Так как при инициализации узла, у нас
     * вряд ли будет ссылка на дочерние узла,
     * то в конструкторе мы назначим им null и
     * предусмотрим геттер и сеттер для них
     */
    public TreeNode(int key, String value) {
        this.key = key;
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    /** Геттеры и сеттеры */
    public TreeNode getLeftChild() {
        return leftChild;
    }
    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }
    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public String toString() {
        return new String ("Ключ: " + key + ". Значение: " + value);
    }
}
