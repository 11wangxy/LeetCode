package Algorithm.DataStruct;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-15 22:11
 * @description: leetCode
 */
public class AVLTree {
    static class AVLNode{
        int key;
        Object value;
        AVLNode left;
        AVLNode right;
        int height = 1;

        public AVLNode(int key, Object value, AVLNode left, AVLNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public AVLNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public AVLNode(int key) {
            this.key = key;
        }
    }

    //求节点的高度
    private int height(AVLNode node){
        return node==null?0: node.height;
    }

    //更新节点高度
    private void updateHeight(AVLNode node){
       node.height = Integer.max(height(node.left), height(node.right)) + 1;
    }

    //平衡因子 左子树高度-右子树高度
    private int bn(AVLNode node){
        return height(node.left)-height(node.right);
    }

    //检查节点是否失衡，重新平衡代码
    private AVLNode balance(AVLNode node){
        if (node==null){
            return null;
        }
        int bn = bn(node);
        if (bn>1&&bn(node.left)>0){//LL
            return rightRotate(node);
        } else if (bn>1&&bn(node.left)<0) {//LR
            return leftRightRotate(node);
        } else if (bn<-1&&bn(node.right)>0) {//RL
            return rightLeftRotate(node);
        } else if (bn<-1&&bn(node.right)<0) {//RR
            return rightRotate(node);
        }
        return node;
    }
    
    //参数：一个要旋转的节点，返回值为新的根节点
    private AVLNode rightRotate(AVLNode node){
        AVLNode left = node.left;
        node.left= left.right;
        left.right=node;
        updateHeight(node);
        updateHeight(left);
        return left;
    }
    private AVLNode leftRotate(AVLNode node){
        AVLNode right = node.right;
        AVLNode rightLeft = right.left;
        right.left=node;
        node.right=rightLeft;
        updateHeight(node);
        updateHeight(right);
        return right;
    }
    //两次旋转
    private AVLNode rightLeftRotate(AVLNode node){
        AVLNode rightedRotate = rightRotate(node.right);
        node.right=rightedRotate;
        AVLNode leftedRotate = leftRotate(node);
        return leftedRotate;
    }
    private AVLNode leftRightRotate(AVLNode node){
        AVLNode leftedRotate = leftRotate(node.left);
        node.left=leftedRotate;
        AVLNode rightedRotate = rightRotate(node);
        return rightedRotate;
    }

    AVLNode root;
    //新增节点
    public void put(int key,Object value){
        root=doPut(root,key,value);
    }
    private AVLNode doPut(AVLNode node,int key,Object value){
        //1.找到空位了，创建新节点
        if (node==null){
            return new AVLNode(key,value);
        }
        //2.key 已存在，更新
        if (key==node.key){
            node.value=value;
            return node;
        }
        //3.继续查找
        if (key<node.key){
            node.left=doPut(node.left,key,value);
        }else {
            node.right=doPut(node.right,key,value);
        }
        updateHeight(node);
        return balance(node);
    }

    //删除节点
    public void remove(int key){
        root=doRemove(root,key);
    }
    private AVLNode doRemove(AVLNode node,int key){
        //1.node==null
        if (node==null){
            return null;
        }
        //2.没找到key
        if (key< node.key){
            node.left= doRemove(node.left, key);
        } else if (key> node.key) {
            node.right=doRemove(node.right,key);
        }else {
            //3.找到key 3.1只有一个孩子 3.2两个孩子都有
            if (node.left==null&&node.right==null){
                return null;
            }else if (node.left==null){
                node=node.right;
            } else if (node.right==null) {
                node=node.left;
            }else {
                AVLNode s=node.right;
                while (s.left!=null){
                    s=s.left;
                }
                //s 此时为后继节点
                s.right = doRemove(node.right, s.key);
                s.left=node.left;
            }
        }
        //4.跟新高度
        updateHeight(node);
        //5.平衡
        return balance(node);
    }
}
