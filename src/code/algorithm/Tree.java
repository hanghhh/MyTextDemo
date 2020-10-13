package code.algorithm;

/**
 * 二叉树
 */
public class Tree {
    public static void main(String[] args) {
        Node n1 = new Node(1,10);
        Node n2 = new Node(2,20);
        Node n3 = new Node(3,30);
        Node n4 = new Node(4,40);
        Node n5 = new Node(5,50);
        Node n6 = new Node(6,60);
        Node n7 = new Node(7,70);
        Node n8 = new Node(8,80);
        Node n9 = new Node(9,90);
        Tree tree = new Tree();
        tree.add(n1);
        tree.add(n2);
        tree.add(n3);
        tree.add(n4);
        tree.add(n5);
        tree.add(n6);
        tree.add(n7);
        tree.add(n8);
        tree.add(n9);
        Node node = tree.find(4);
        System.out.println(node.getData());
    }

    private Node root;

    public void Tree(){
        this.root = null;
    }

    /**
     * 查找元素
     * @param index
     * @return
     */
    private Node find(int index) {

        Node currNode = root;
        int currNodeIndex = currNode.getIndex();
        while (index != currNodeIndex) {
            if(index < currNodeIndex) {
                currNode = currNode.getLeftChild();
                currNodeIndex = currNode.getIndex();
            }else {
                currNode = currNode.getRightChold();
                currNodeIndex = currNode.getIndex();
            }
            if(currNode == null) {
                return null;
            }
        }
        return currNode;
    }

    private void add(Node node){
        //当根为空时，插入得节点作为根节点
        if(this.root == null) {
            this.root = node;
            return;
        }
        //
        Node parent;
        //从根节点开始查找
        Node currNode = root;
        while (true) {
            parent = currNode;
            if(currNode.getIndex() < currNode.getIndex()) {
                currNode = currNode.getLeftChild();
                if(currNode == null) {
                    parent.setLeftChild(node);
                    return;
                }
            } else {
                currNode = currNode.getRightChold();
                if(currNode == null) {
                    parent.setRightChold(node);
                    return;
                }
            }
        }
    }
}



class Node{
    private Node leftChild;
    private Node rightChold;
    private int data;
    private int index;

    public void display() {
        System.out.println("{");
        System.out.println(" " + data);
        System.out.println(", " + index);
        System.out.println("}");
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChold() {
        return rightChold;
    }

    public void setRightChold(Node rightChold) {
        this.rightChold = rightChold;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Node(int index, int data) {
        this.data = data;
        this.index = index;
    }
}
