package Algorithm.DataStruct;

import java.rmi.Remote;
import java.text.BreakIterator;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-14 1:07
 * @description: 搜索二叉树
 */
public class BSTTree<T extends Comparable<T>>{
    BSTNode<T> root;

    static class BSTNode<T> {
        T key;
        Object value;
        BSTNode left;
        BSTNode right;

        public BSTNode(T key, Object value) {
            this.key = key;
        }

        public BSTNode(T key, Object value, BSTNode<T> left, BSTNode<T> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }


    public Object get(T key) {
        BSTNode<T> p=root;
        while (p!=null){
            int i = key.compareTo(p.key);//如果返回-1，代表key<p.key，1则反之0则相等.
            if (i<0){
                p=p.left;
            } else if (i>0) {
                p=p.right;
            }else {
                return p.value;
            }
        }
        return null;
    }
//    private Object doget(BSTNode<T> node,T key){
//        //没找到
//        if (node==null){
//            return null;
//        }
//        if (key<node.key){
//            return doget(node.left,key);//向左找
//        } else if (node.key < key) {
//            return doget(node.right,key);//向右找
//        }else {
//            return node.value;
//        }
//    }

    public Object min() {
        if (root==null){
            return null;
        }
        BSTNode node=root;
        if (node.left!=null){
            node=node.left;
        }
        return node.left;
    }
//    public Object doMin(BSTNode node){
//        if (node==null){
//            return null;
//        }
//        if (node.left==null){
//            return node.value;//找到了最小值
//        }
//        return doMin(node.left);
//    }

    public Object max() {
        if (root==null){
            return null;
        }
        BSTNode node=root;
        if (node.right!=null){
            node=node.right;
        }
        return node.right;
    }

    public void put(T key, Object value) {
        //1.key已经存在，则更新
        BSTNode<T> p=root;
        BSTNode<T> parent=null;
        while (p!=null){
            parent=p;//不断更新值
            int i = key.compareTo(p.key);//如果返回-1，代表key<p.key，1则反之0则相等.
            if (i<0){
                p=p.left;
            } else if (i>0) {
                p=p.right;
            }else {
                //找到了，进行更新
                p.value=value;
                return;
            }
        }
        //2.不存在，则新增
        if (parent==null){
            root=new BSTNode<>(key,value);
            return;
        }
        int j=key.compareTo(parent.key);
        if (j<0){
            parent.left=new BSTNode<>(key,value);
        }else{
            parent.right=new BSTNode<>(key,value);
        }
    }

    public Object successor(T key) {
        BSTNode p=root;
        BSTNode ancestorFromRight =null;
        int i = key.compareTo(root.key);
        while (p!=null) {
            if (i < 0) {
                ancestorFromRight=p;
                p = p.left;
            } else if (i > 0) {

                p = p.right;
            } else {
                break;
            }
        }
        if (p==null){
            return null;//没找到
        }
        //1.找到节点，如果节点有右子树，则后任就是右子树最小值；
        // 2.如果没有右子树，则离他最近的自右而来的祖先就是后任
        if (p.left!=null){
            BSTNode node=p.left;
            if (node.left!=null){
                node=node.left;
            }
        }
        return ancestorFromRight!=null?ancestorFromRight.value:null;
    }

    public Object predecessor(T key) {
        BSTNode p=root;
        BSTNode ancestorFromLeft =null;
        int i = key.compareTo(root.key);
        while (p!=null) {
            if (i < 0) {
                p = p.left;
            } else if (i > 0) {
                ancestorFromLeft=p;
                p = p.right;
            } else {
                break;
            }
        }
        if (p==null){
            return null;//没找到
        }
        //1.找到节点，如果节点有左子树，则前任就是左子树最大值；
        // 2.如果没有左子树，则离他最近的自左而来的祖先就是前任
        if (p.left!=null){
            BSTNode node=p.left;
            if (node.right!=null){
                node=node.right;
            }
        }
        return ancestorFromLeft!=null?ancestorFromLeft.value:null;
    }

    public Object remove(T key) {
        BSTNode<T> p=root;
        BSTNode parent = null;
        while (p!=null){
            int i = key.compareTo(p.key);//如果返回-1，代表key<p.key，1则反之0则相等.
            if (i<0){
                parent=p;
                p=p.left;
            } else if (i>0) {
                parent=p;
                p=p.right;
            }else {
                break;
            }
        }
        if (p==null){
            return null;
        }
        if (p.left==null&&p.right!=null){//只有右孩子
            shift(parent,p,p.right);
        }else if (p.left!=null&&p.right==null){//只有左孩子
            shift(parent,p,p.left);
        }else {//左右孩子都有，选择后任节点顶替
            //1.被删除节点找后继
            BSTNode s=p.right;
            BSTNode sParent=p;
            while (s.left!=null){
                sParent=s;
                s=s.left;
            }
            //后继结点即为s
            if (sParent!=p){
                //2.删除和后继不相邻，处理后继节点的后事
                shift(sParent,s,s.right);
                s.right=p.right;
            }
            //3.后继取代删除节点
            shift(parent,p,s);
            s.left=p.left;
        }
        return p.value;
    }

    public void shift(BSTNode parent,BSTNode remove,BSTNode child){
        if (parent==null){
            root=child;
        } else if (remove==parent.left) {
            parent.left=child;
        }else if (remove==parent.right){
            parent.right=child;
        }
    }
}
