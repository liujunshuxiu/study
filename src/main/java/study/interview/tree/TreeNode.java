package study.interview.tree;

import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeNode {
    int val;

    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
    }

    public void setLeft(TreeNode node){
        this.left = node;
    }

    public void setRight(TreeNode node){
        this.right = node;
    }


    public static TreeNode createBinaryTree(LinkedList<Integer> list){
        TreeNode node = null;
        if(list == null || list.isEmpty()){
            return null;
        }

        Integer data = list.removeFirst();

        if(data != null){
            node = new TreeNode(data);
            node.left = createBinaryTree(list);
            node.right = createBinaryTree(list);
        }
        return node;
    }


    //前序遍历  根——左——右
    public static void preOrder(TreeNode node){
        if(node == null){
            return;
        }
        System.out.println(node.val+",");
        preOrder(node.left);
        preOrder(node.right);
    }


    //中序遍历 左——根——右
    public static void inOrder(TreeNode node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.val+",");
        inOrder(node.right);
    }

    //后序遍历 左——右——根
    public static void postOrder(TreeNode node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.val+",");
    }


    //前序遍历 使用栈
    public static void preOrderTraveralWithStack(TreeNode node){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = node;
        while(treeNode!=null || !stack.isEmpty()){
            //迭代访问节点的左孩子，并入栈
            while(treeNode != null){
                System.out.print(treeNode.val+" ");
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if(!stack.isEmpty()){
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
    }


    public static void main(String[] args) {
        LinkedList<Integer> linkList = new LinkedList<>();
        linkList.add(1);
        linkList.add(34);
        linkList.add(5);
        linkList.add(9);
        linkList.add(8);
        linkList.add(5);

        TreeNode binaryTree = createBinaryTree(linkList);

        preOrderTraveralWithStack(binaryTree);
    }
}
