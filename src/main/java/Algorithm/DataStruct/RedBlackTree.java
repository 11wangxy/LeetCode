package Algorithm.DataStruct;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-16 22:34
 * @description: leetCode
 */
public class RedBlackTree {
    enum Color{
        RED,BLACK;
    }

    //定义节点
    private static class Node{
        int key;
        Object value;
        Node left;
        Node right;
        Node parent;
        Color color= Color.RED;

        public Node(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        //是否是左孩子
        boolean isLeftChild(){
            return parent!=null&&parent.left==this;
        }

        //叔叔
        Node uncle(){
            if (parent==null||parent.parent==null){
                return null;
            }
            if (parent.isLeftChild()){
                return parent.parent.right;
            }else {
                return parent.parent.left;
            }
        }

        //兄弟
        Node sibling(){
            if (parent==null){
                return null;
            }
            if (this.isLeftChild()){
                return parent.right;
            }else {
                return parent.left;
            }
        }


    }

    //判断红黑
    boolean isRed(Node node){
        return node!=null&&node.color==Color.RED;
    }
    boolean isBlack(Node node){
        return node==null||node.color==Color.BLACK;
    }

    private Node root;

    //右旋
    private void rightRemote(Node node){
        Node parent = node.parent;
        Node nodeLeft = node.left;
        Node nodeLeftRight = nodeLeft.right;
        if (nodeLeftRight!=null){
            nodeLeftRight.parent=node;
        }
        nodeLeft.right=node;
        nodeLeft.parent=parent;
        node.left=nodeLeftRight;
        node.parent=nodeLeft;
        if (parent==null){
            root=nodeLeft;
        } else if (parent.left==node){
            parent.left=nodeLeft;
        }else {
            parent.right=nodeLeft;
        }
    }
    //左旋
    private void leftRotate(Node node) {
        Node parent = node.parent;
        Node nodeRight = node.right;
        Node nodeRightLeft = nodeRight.left;
        if (nodeRightLeft != null) {
            nodeRightLeft.parent = node;
        }
        nodeRight.left = node;
        nodeRight.parent = parent;
        node.right = nodeRightLeft;
        node.parent = nodeRight;
        if (parent == null) {
            root = nodeRight;
        } else if (parent.left == node) {
            parent.left = nodeRight;
        } else {
            parent.right = nodeRight;
        }
    }

    //插入
    public void put(int key,Object value){
        Node p=root;
        Node parent=null;
        while (p!=null){
            parent=p;
            if (key<p.key){
                p=p.left;
            } else if (key>p.key) {
                p=p.right;
            }else {
                p.value=value;//更新
                return;
            }
        }
        Node insert=new Node(key, value);
        if (parent==null){
            root=insert;
        }else if (key< parent.key){
            parent.left=insert;
            insert.parent=parent;
        } else{
            parent.right=insert;
            insert.parent=parent;
        }
        fixRedRed(insert);
    }

    void fixRedRed(Node x){
        //插入节点是根节点，则颜色为黑
        if (x==root){
            x.color=Color.BLACK;
            return;
        }
        if (isBlack(x.parent)){
            return;
        }
        Node parent = x.parent;
        Node uncle = x.uncle();
        Node grandparent = parent.parent;
        if (isRed(uncle)){
            parent.color=Color.BLACK;
            uncle.color=Color.BLACK;
            grandparent.color=Color.RED;
            fixRedRed(grandparent);
            return;
        }
    }
    public void remove(int key){

    }
}
