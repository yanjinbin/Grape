package com.yanjinbin.aop;

import java.util.*;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //如果找到 p 或者 q 那么就没有必要接着递归，因为共同祖先只可能是该节点或该节点祖先
        //如果 root 为空了，说明这条路径上不可能有 p 或 q 节点，返回空
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);  //往左分支上寻找
        TreeNode right = lowestCommonAncestor(root.right, p, q);  //往右分支上寻找
        if (left != null && right != null) {
            return root;  //说明 p 和 q 是分布在 root 两侧，返回即可
        }
        if (left != null) {
            return left;  //说明在 left 分支上找到 p 或 q 节点，返回即可
        }
        return right;  //否则返回 right
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(10);
        list.add(9);
        System.out.println(list);

        Collections.sort(list, Comparator.naturalOrder());
        System.out.println(list);

    }


    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        inTraversalHelper(root, list);
        return list;
    }

    private static void inTraversalHelper(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inTraversalHelper(node.left, list);
        list.add(node.val);
        if (node == null) {
            return;
        }
        inTraversalHelper(node.right, list);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode current = null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }

        }
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
