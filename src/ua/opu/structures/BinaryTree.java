package ua.opu.structures;

/**
 * Класс описывает бинарное дерево.
 * Операции с деревом:
 * - вставка элемента
 * - обход дерева (три вида)
 * - удаление элемента
 */
public class BinaryTree {

    /** Корневая вершина */
    private TreeNode rootNode;

    /**
     * Так как дерево, в принципе, может быть пустым,
     * то конструктор у нас пустой
     */
    public BinaryTree() {
    }

    /**
     * Добавление вершины.
     * Если вы не забыли, алгоритм добавления вершины такой:
     * 1. Если корневая вершина пустая - добавляемая вершина становится корневой
     * иначе,
     *
     * Текущая вершина: C - корневая вершина;
     * Добавляемая вершина: N.
     *
     * 2. пока С != null {
     *     если (C.key >= N.key) {C = C.leftChild}
     *     иначе C = C.rightChild
     * }
     * 3. C = N
     *
     * @param key ключ вершины
     * @param value значение вершины
     */
    public void addNode(int key, String value) {
        if (rootNode == null) {
            // Если узел пустой - добавляемая вершина
            // становится узлом
            rootNode = new TreeNode(key, value);
        } else {
            // Текущая вершина - узел
            TreeNode currentNode = rootNode;
            while (currentNode !=null) {
                if (currentNode.getKey() > key) {
                    // Если левый сын не пустой, тогда спускаемся вниз
                    // если пустой - тогда левый сын становится новым узлом
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
     * Обратите внимание на следующий важный момент.
     * Чтобы дать внешним объектам возможность обходить дерево
     * мы сделали специальный метод traverseTree, который принимает на вход
     * перечисление в виде порядка обхода,
     * хотя мы могли просто сделать публичными соответствующие методы обхода.
     *
     * Почему же мы написали отдельный метод?
     * Потому что рекурсивный порядок обхода требует, чтобы в качестве параметра мы указали
     * корневую вершину. Соответственно, внешнему объекту нужно взять эту вершину
     * и вообще появляется информация о том, что есть еще какая-то корневая вершина, а это
     * ему знать необязательно.
     *
     * Представьте, что ваш класс бинарное дерево предоставляет услуги другим объектам,
     * и вы не должны "грузить" другие объекты лишней информацией, они просто должны получить
     * свою услугу - обход дерева.
     * В данном случае, наличие корневой вершины - это внутрення логика работы
     * бинарного дерева и она не должна выставляться наружу.
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
     * Удаление узла. При удалении у нас есть три варианта:
     * 1. У узла нет потомков, тогда просто удаляем
     * 2. У узла есть один из потомков - соединяем потомка с родителем
     * 3. У узла есть оба потомка - берем или предыдущий или последующий элемент,
     * перемещаем его на место удаляемого, применяем процедуру удаления к перемещаемому узлу
     *
     * @param key ключ узла, который нужно удалить
     * @return успешность процедуры удаления (false если такого ключа нет в дереве)
     */
    public boolean deleteNode(int key) {
        boolean success = true;

        // ... А вот тут пишите сами

        return success;
    }

    /**
     * Это перечисление.
     * Это такой специальный тип данных,
     * он позволяет выбрать одно из нескольких значений
     */
    public enum TraverseOrder{
        InOrder,
        PreOrder,
        PostOrder
    }
}
