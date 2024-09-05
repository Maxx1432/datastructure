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
        System.out.println(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree();
        bt.preOrder(bt.root);
    }
}
