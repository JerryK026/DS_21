package finalterm;

import java.util.*;
import java.io.*;

public class treeTraversal {

    static final StringBuilder sb = new StringBuilder("");

    static class Node {
        int val;
        Node left;
        Node right;
        Node(int val) { this.val = val; }
    }

    static void preorder(Node node) {
        if (node == null) return;
        sb.append(node.val).append(" ");
        preorder(node.left);
        preorder(node.right);
    }

    static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        sb.append(node.val).append(" ");
        inorder(node.right);
    }

    static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        sb.append(node.val).append(" ");
    }

    static void levelorder_main(Node root) {
        sb.append(root.val).append(" ");
        levelorder(root);
    }

    static void levelorder(Node node) {
        if(node == null) return;
        if(node.left != null) {
            sb.append(node.left.val).append(" ");
        }
        if(node.right != null) {
            sb.append(node.right.val).append(" ");
        }
        levelorder(node.left);
        levelorder(node.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        HashMap<Integer, Node> tree = new HashMap<>();
        HashMap<Integer, Boolean> cr = new HashMap<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            String left = st.nextToken();
            String right = st.nextToken();

            if(!tree.containsKey(key)) {
                tree.put(key, new Node(key));
                cr.put(key, false);
            }

            if(!left.equals(".")) {
                int l = Integer.parseInt(left);
                if(!tree.containsKey(l)) tree.put(l, new Node(l));
                tree.get(key).left = tree.get(l);
                cr.put(l, true);
            }

            if(!right.equals(".")) {
                int r = Integer.parseInt(right);
                if(!tree.containsKey(r)) tree.put(r, new Node(r));
                tree.get(key).right = tree.get(r);
                cr.put(r, true);
            }
        }

        int rootKey = -1;

        for(int key : cr.keySet()) {
            if(!cr.get(key)) {
                rootKey = key;
                break;
            }
        }

        preorder(tree.get(rootKey));
        sb.append("\n");
        inorder(tree.get(rootKey));
        sb.append("\n");
        postorder(tree.get(rootKey));
        sb.append("\n");
        levelorder_main(tree.get(rootKey));

        System.out.println(sb.toString());
    }
}