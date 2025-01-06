package Leetcode.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        Stack<TreeNode> treeStack = new Stack<>();
        TreeNode temp = root;
        while(!treeStack.isEmpty() || temp != null){
            if(temp != null){
                treeStack.push(temp);
                temp = temp.left;
            } else {
                temp = treeStack.pop();
                result.add(temp.val);
                temp = temp.right;
            }
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

        List<Integer> result = inorderTraversal(first);
        System.out.println(result);
    }
}
