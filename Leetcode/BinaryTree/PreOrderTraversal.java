package Leetcode.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
    public static List<Integer> preorderTraversal(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> treeStack = new Stack<>();
        treeStack.push(root);
        while(!treeStack.isEmpty()){
            TreeNode temp = treeStack.pop();
            result.add(temp.val);
            if(temp.right != null)
                treeStack.push(temp.right);

            if(temp.left != null)
                treeStack.push(temp.left);
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode first = new TreeNode(9);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);
        TreeNode sixth = new TreeNode(6);

//        root = first;         // null<--First-->null
        first.left = second;  // second<--First-->null
        first.right = third;  // second<--First-->third
        second.left = fourth; // fourth<--second-->null
        third.right = fifth;  // null<--third-->fifth
        third.left = sixth;

        List<Integer> result = preorderTraversal(first);
        System.out.println(result);
    }
}
