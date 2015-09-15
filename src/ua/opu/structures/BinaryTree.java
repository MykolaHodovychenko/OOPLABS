package ua.opu.structures;

/**
 * ����� ��������� �������� ������.
 * �������� � �������:
 * - ������� ��������
 * - ����� ������ (��� ����)
 * - �������� ��������
 */
public class BinaryTree {

    /** �������� ������� */
    private TreeNode rootNode;

    /**
     * ��� ��� ������, � ��������, ����� ���� ������,
     * �� ����������� � ��� ������
     */
    public BinaryTree() {
    }

    /**
     * ���������� �������.
     * ���� �� �� ������, �������� ���������� ������� �����:
     * 1. ���� �������� ������� ������ - ����������� ������� ���������� ��������
     * �����,
     *
     * ������� �������: C - �������� �������;
     * ����������� �������: N.
     *
     * 2. ���� � != null {
     *     ���� (C.key >= N.key) {C = C.leftChild}
     *     ����� C = C.rightChild
     * }
     * 3. C = N
     *
     * @param key ���� �������
     * @param value �������� �������
     */
    public void addNode(int key, String value) {
        if (rootNode == null) {
            // ���� ���� ������ - ����������� �������
            // ���������� �����
            rootNode = new TreeNode(key, value);
        } else {
            // ������� ������� - ����
            TreeNode currentNode = rootNode;
            while (currentNode !=null) {
                if (currentNode.getKey() > key) {
                    // ���� ����� ��� �� ������, ����� ���������� ����
                    // ���� ������ - ����� ����� ��� ���������� ����� �����
                    if (currentNode.getLeftChild()!=null) {
                        currentNode = currentNode.getLeftChild();
                    } else {
                        currentNode.setLeftChild(new TreeNode(key,value));
                        break;
                    }
                } else {
                    if (currentNode.getRightChild()!=null) {
                        currentNode = currentNode.getRightChild();
                    } else {
                        currentNode.setRightChild(new TreeNode(key,value));
                        break;
                    }
                }
            }
        }
    }

    public void traverseTree(TraverseOrder order) {
        if (order == TraverseOrder.InOrder) {
            inOrderTraverse(rootNode);
        } else if (order == TraverseOrder.PreOrder) {
            preOrderTraverse(rootNode);
        } else if (order == TraverseOrder.PostOrder) {
            postOrderTraverse(rootNode);
        }
     }

    /**
     * �������� �������� �� ��������� ������ ������.
     * ����� ���� ������� �������� ����������� �������� ������
     * �� ������� ����������� ����� traverseTree, ������� ��������� �� ����
     * ������������ � ���� ������� ������,
     * ���� �� ����� ������ ������� ���������� ��������������� ������ ������.
     *
     * ������ �� �� �������� ��������� �����?
     * ������ ��� ����������� ������� ������ �������, ����� � �������� ��������� �� �������
     * �������� �������. ��������������, �������� ������� ����� ����� ��� �������
     * � ������ ���������� ���������� � ���, ��� ���� ��� �����-�� �������� �������, � ���
     * ��� ����� �������������.
     *
     * �����������, ��� ��� ����� �������� ������ ������������� ������ ������ ��������,
     * � �� �� ������ "�������" ������ ������� ������ �����������, ��� ������ ������ ��������
     * ���� ������ - ����� ������.
     * � ������ ������, ������� �������� ������� - ��� ��������� ������ ������
     * ��������� ������ � ��� �� ������ ������������ ������.
     *
     */

    private void inOrderTraverse(TreeNode node){
        if (node == null) { return; }
        inOrderTraverse(node.getLeftChild());
        System.out.println(node.toString());
        inOrderTraverse(node.getRightChild());
    }

    private void preOrderTraverse(TreeNode node){
        if (node == null) { return; }
        System.out.println(node.toString());
        preOrderTraverse(node.getLeftChild());
        preOrderTraverse(node.getRightChild());
    }

    private void postOrderTraverse(TreeNode node){
        if (node == null) { return; }
        postOrderTraverse(node.getLeftChild());
        postOrderTraverse(node.getRightChild());
        System.out.println(node.toString());
    }

    /**
     * �������� ����. ��� �������� � ��� ���� ��� ��������:
     * 1. � ���� ��� ��������, ����� ������ �������
     * 2. � ���� ���� ���� �� �������� - ��������� ������� � ���������
     * 3. � ���� ���� ��� ������� - ����� ��� ���������� ��� ����������� �������,
     * ���������� ��� �� ����� ����������, ��������� ��������� �������� � ������������� ����
     *
     * @param key ���� ����, ������� ����� �������
     * @return ���������� ��������� �������� (false ���� ������ ����� ��� � ������)
     */
    public boolean deleteNode(int key) {
        boolean success = true;

        // ... � ��� ��� ������ ����

        return success;
    }

    /**
     * ��� ������������.
     * ��� ����� ����������� ��� ������,
     * �� ��������� ������� ���� �� ���������� ��������
     */
    public enum TraverseOrder{
        InOrder,
        PreOrder,
        PostOrder
    }
}
