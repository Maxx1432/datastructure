package Leetcode.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        Stack<TreeNode> treeStack = new Stack<>();
        TreeNode current = root;
        while(current != null || !treeStack.isEmpty()){
            if(current != null){
                treeStack.push(current);
                current = current.left;
            } else {
                TreeNode temp = treeStack.peek().right;
                if(temp == null){
                    temp = treeStack.pop();
                    result.add(temp.val);
                    while(!treeStack.isEmpty() && temp == treeStack.peek().right){
                        temp = treeStack.pop();
                        result.add(temp.val);
                    }
                } else {
                    current = temp;
                }
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

        List<Integer> result = postorderTraversal(first);
        System.out.println(result);
    }
}
