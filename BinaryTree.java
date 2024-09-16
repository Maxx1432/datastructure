import java.util.Stack;

public class BinaryTree {

    private TreeNode root;  // null<--Root Node-->null
    // this the top node of the binary tree.

    private class TreeNode{ // Class to represent the node in binary tree
        private TreeNode left;
        private TreeNode right;
        private int data; //Generic Type

        public TreeNode(int data){
            this.data = data;
        }
    }

    public void createBinaryTree(){
        TreeNode first = new TreeNode(9);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);
        TreeNode sixth = new TreeNode(6);

        root = first;         // null<--First-->null
        first.left = second;  // second<--First-->null
        first.right = third;  // second<--First-->third
        second.left = fourth; // fourth<--second-->null
        third.right = fifth;  // null<--third-->fifth
        third.left = sixth;   // sixth<--third-->>fifth

    }

//    to create preorder of the tree which first visit the left node and then right node
    public void preOrder(TreeNode root){
        if(root == null) //base case
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void preOrderIterative(TreeNode root){
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.print(temp.data + "-->");
            if (temp.right != null){
                stack.push(temp.right);
            }
            if (temp.left != null){
                stack.push(temp.left);
            }
        }
    }
    public void inOrder(TreeNode root){
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data+"-->");
        inOrder(root.right);
    }
    public void inOderIterative(TreeNode root){
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (!stack.isEmpty() || temp != null){
            if (temp != null){
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print(temp.data+"-->");
                temp = temp.right;
            }
        }
    }

    public void postOrder(TreeNode root){
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+"-->");
    }

    public void postOrderIterative(TreeNode root){
        if(root == null)
            return;
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while(current != null || !stack.isEmpty()){
            if(current != null){
                stack.push(current);
                current = current.left;
            } else {
                TreeNode temp = stack.peek().right;
                if(temp == null){
                    temp = stack.pop();
                    System.out.print(temp.data+"-->");
                    while (!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop();
                        System.out.print(temp.data+"-->");
                    }
                } else {
                    current = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree();
        System.out.println("Pre order");
        bt.preOrder(bt.root);
        System.out.println();

        System.out.println("using Iterative");
        bt.preOrderIterative(bt.root);
        System.out.println();

        System.out.println("in Order");
        bt.inOrder(bt.root);
        System.out.println();

        System.out.println("in Order using Iterative");
        bt.inOderIterative(bt.root);
        System.out.println();

        System.out.println("post Order");
        bt.postOrder(bt.root);
        System.out.println();

        System.out.println("post Order using Iterative");
        bt.postOrderIterative(bt.root);
        System.out.println();

    }
}
