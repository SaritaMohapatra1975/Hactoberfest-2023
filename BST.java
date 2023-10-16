package BST;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
  static class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  static class BinaryTree {
    static int idx = -1;

    public static Node buildTree(int node[]) {
      idx++;
      if (node[idx] == -1) {
        return null;
      }
      Node newNode = new Node(node[idx]);
      newNode.left = buildTree(node);
      newNode.right = buildTree(node);
      return newNode;
    }
  }

  public static void preorder(Node root) {
    if (root == null) {
      return;
    }
    System.out.print(root.data + " ");
    preorder(root.left);
    preorder(root.right);
  }

  public static void inorder(Node root) {
    if (root == null) {
      return;
    }

    preorder(root.left);
    System.out.print(root.data + " ");
    preorder(root.right);
  }

  public static void postorder(Node root) {
    if (root == null) {
      return;
    }

    preorder(root.left);
    preorder(root.right);
    System.out.print(root.data + " ");
  }

  public static void levelOrder(Node root) {
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    q.add(null);
    while (!q.isEmpty()) {
      Node currNode = q.remove();
      if (currNode == null) {
        System.out.println();
        if (q.isEmpty()) {
          break;
        } else {
          q.add(null);
        }
      } else {
        System.out.print(currNode.data);
        if (currNode.left != null) {
          q.add(currNode.left);
        }
        if (currNode.right != null) {
          q.add(currNode.right);
        }
        if (root == null) {
          return;
        }
      }
    }
  }

  public static int countOfNode(Node root) {
    if (root == null) {
      return 0;
    }
    int leftNode = countOfNode(root.left);
    int rightNode = countOfNode(root.right);

    return leftNode + rightNode + 1;
  }

  public static int sumOfNode(Node root) {
    if (root == null) {
      return 0;
    }
    int leftNode = sumOfNode(root.left);
    int rightNode = sumOfNode(root.right);

    return leftNode + rightNode + root.data;
  }

  public static int heightOfNode(Node root) {
    if (root == null) {
      return 0;
    }
    int leftNode = heightOfNode(root.left);
    int rightNode = heightOfNode(root.right);

    int myHeight = Math.max(leftNode, rightNode) + 1;
    return myHeight;
  }

  public static int diameter(Node root) {
    if (root == null) {
      return 0;
    }

    int dia1 = diameter(root.left);
    int dia2 = diameter(root.right);
    int dia3 = heightOfNode(root.left) + heightOfNode(root.right) + 1;

    return Math.max(dia3, Math.max(dia1, dia2));
  }

  public static void main(String[] args) {
    int[] node = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
    BinaryTree tree = new BinaryTree();
    Node root = tree.buildTree(node);

    preorder(root);
    System.out.println();

    inorder(root);
    System.out.println();

    postorder(root);
    System.out.println();

    levelOrder(root);
    System.out.println();

    System.out.println(countOfNode(root));
    System.out.println();

    System.out.println(sumOfNode(root));
    System.out.println();

    System.out.println(heightOfNode(root));
    System.out.println();

    System.out.println(diameter(root));
  }
}
