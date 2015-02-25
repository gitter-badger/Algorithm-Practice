package com.abhishek;

/**
 * http://jira.abhis.ws/browse/AP-52
 */
public class AP_52 {

    private int level = 0;

    public boolean areCousins(Node root, Node node1, Node node2) {

        findLevel(node1, root, 0);
        int node1level = level;
        level=0;
        findLevel(node2, root, 0);
        int node2level = level;

        if (node1level == node2level)
            return true;
        else
            return false;
    }

    private void findLevel(Node node, Node root, int level) {
        if (root == null)
            return;

        if (root == node) {
            this.level = level;
            return;
        }

        if (node == root)
            return;

        findLevel(node, root.left, level++);
        findLevel(node, root.right, level++);
    }

    public static void main(String... args) {

        /**
         *              20
         *          8       22
         *       4     12
         *          10   14
         */

        Node four = new Node(4, null, null);
        Node ten = new Node(10, null, null);

        Node root = new Node(20, new Node(8, four, new Node(12, ten, new Node(14, null, null))), new Node(22, null, null));

        AP_52 ap_52 = new AP_52();
        System.out.println(ap_52.areCousins(root, four, ten));
    }
}
