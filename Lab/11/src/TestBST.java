import java.util.ArrayList;

public class TestBST {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        Integer[] array = {45,88,54,76,98,1,2,20,6,53,42,100,86,32,28,65,14};
        tree.insert(array);

        System.out.print("InOrder   : ");
        tree.traverseInOrder(tree.root);

        System.out.print("\nPostOrder : ");
        tree.traversePostOrder(tree.root);

        System.out.print("\nPreOrder  : ");
        tree.traversePreOrder(tree.root);

        System.out.println("\nHeight of BST : " + tree.height());

        System.out.println("Root for BST : " + tree.root.data);

        System.out.println("Check whether 10 is in the tree : " + tree.search(10));

        System.out.println("Delete 53");
        tree.delete(53);

        System.err.print("Updated InOrder : ");
        tree.traverseInOrder(tree.root);

        System.out.println("\nMin Value : " + tree.minValue());
        System.out.println("Max Value : " + tree.maxValue());

        System.out.print("Path from root to 6 : ");
        ArrayList<TreeNode<Integer>> arr = tree.path(6);

        for(TreeNode<Integer> node : arr){
            System.out.print(node.data + " ");
        }
    
    }
}


class TreeNode<E extends Comparable<E>> {
    E data;
    TreeNode<E> left;
    TreeNode<E> right;

    TreeNode(E e) {
        data = e;
        left = null;
        right = null;
    }
}

class BST<E extends Comparable<E>>{
    TreeNode<E> root;
    int size;


    BST() {
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public E minValue(){
        if(root == null) return null;
        TreeNode<E> node = root;
        while(node.left != null) node = node.left;
        return node.data;
    }

    public E maxValue(){
        if(root == null) return null;
        TreeNode<E> node = root;
        while(node.right != null) node = node.right;
        return node.data;
    }

    public ArrayList<TreeNode<E>> path(E e){

        ArrayList<TreeNode<E>> res = new ArrayList<>();
        TreeNode<E> node = root;

        while(node != null){
            res.add(node);
            int cmp = e.compareTo(node.data);
            if(cmp > 0) node = node.right;
            else if(cmp < 0) node = node.left;
            else return res;
        }
        return new ArrayList<>();
    }

    public void delete(E element){
        root = deleteHelp(root, element);
    }

    public TreeNode<E> deleteHelp(TreeNode<E> node , E e){
        if(node == null) return null;

        int cmp = e.compareTo(node.data);
        if(cmp > 0) node.right = deleteHelp(node.right, e);
        else if(cmp < 0) node.left = deleteHelp(node.left, e);
        else{

            // 1st case : 0 child
            if(node.right == null && node.left == null) return null;

            // 2nd case : 1 child
            if(node.right == null) return node.left;
            if(node.left == null) return node.right;

            // 3rd case : 2 child
            TreeNode<E> successor = findMin(node.right);
            node.data = successor.data;
            node.right = deleteHelp(node.right, successor.data);

        }
        return node;
    }

    public boolean clear(){
        if(root == null) return false;
        root = null;
        size = 0;
        return true;
    }

    public int height(){
        return height(root);
    }

    private int height(TreeNode<E> node){
        if(node == null) return -1;
        int left = height(node.left);
        int right = height(node.right);
        return 1 + Math.max(left, right);
    }


    private TreeNode<E> findMin(TreeNode<E> node){
        if(node == null) return null;
        while(node.left != null) node = node.left;
        return node;
    }

    public boolean insert(E e){
        return insertHelp(root,e);
    }

    public void insert(E[] elements){
        for(E e : elements) insert(e);
    }

    private boolean insertHelp(TreeNode<E> node, E element){
        if(root == null){
            root = new TreeNode<>(element);  
            size++;
            return true;
        } 
        else if(node.data.compareTo(element) > 0){
            if(node.left == null) {
                node.left = new TreeNode<>(element);
                size++;
                return true;
            }
            else return insertHelp(node.left, element);
        }
        else if(node.data.compareTo(element) < 0){
            if(node.right == null) {
                node.right = new TreeNode<>(element);
                size++;
                return true;
            }
            else return insertHelp(node.right, element);
        }
        return false;
    }

    public boolean search(E e){
        return searchHelp(root, e);
    }

    private boolean searchHelp(TreeNode<E> node, E element){
        if(node == null) return false;
        if(node.data.compareTo(element) == 0) return true;
        if(node.data.compareTo(element) > 0) return searchHelp(node.left, element);
        else return searchHelp(node.right, element);
    }

    public void traverseInOrder(TreeNode<E> root){
        if(root == null) return;
        traverseInOrder(root.left);
        System.out.print(root.data + " ");
        traverseInOrder(root.right);
    }

    public void traversePreOrder(TreeNode<E> root){
        if(root == null) return;
        System.out.print(root.data + " ");
        traversePreOrder(root.left);
        traversePreOrder(root.right);
    }

    public void traversePostOrder(TreeNode<E> root){
        if(root == null) return;
        traversePostOrder(root.left);
        traversePostOrder(root.right);
        System.out.print(root.data + " ");
    }
}
