package finalterm;

import java.util.*;
import java.io.*;

public class BSTBuilder {

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        preorder(node.left);
        preorder(node.right);
    }

    static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }

    static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.val + " ");
    }

    static Queue<Node> q = new LinkedList<>();

    static void levelorder(Node root) {
        q.offer(root);
        while(!q.isEmpty()) {
            Node node = q.poll();
            System.out.print(node.val + " ");
            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Node[] tree = new Node[N];

        for(int i = 0; i < N; i++) {
            tree[i] = new Node(Integer.parseInt(st.nextToken()));
            Node head = tree[0];
            Node cur;
            Node nNode = tree[i];

            if(i == 0) continue;

            while (true) {
                cur = head;
                if (head.val < nNode.val) {
                    head = head.right;
                    if (head == null) {
                        cur.right = nNode;
                        break;
                    }
                }
                else {
                    head = head.left;
                    if (head == null) {
                        cur.left = nNode;
                        break;
                    }
                }
            }
        }

        preorder(tree[0]);
        System.out.println();
        inorder(tree[0]);
        System.out.println();
        postorder(tree[0]);
        System.out.println();
        levelorder(tree[0]);
    }
}