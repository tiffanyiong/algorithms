package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/binary-tree-postorder-traversal/description/
 */
public class PostorderTraversal {

    // 1 Stack version(recommended):
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return result;
        stack.push(root);
        // 如果沒彈出過的node， root就一直會是頭節點。
        // 一旦彈出過，就mark成處理過，且之後root的意義為 "處理過的節點"
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();

            // 有左樹，但還沒被處理過的左孩子都壓入棧
            if (cur.left != null && root != cur.left && root != cur.right) {
                stack.push(cur.left);
            }
            // 有右樹，且未處理過的右孩子壓入棧
            else if (cur.right != null && root != cur.right) {
                stack.push(cur.right);
            }
            // 把沒有孩子，走了第三遍的node彈出，且標記為root 代表已處理過了
            else {
                root = stack.pop();
                result.add(root.val);
            }
        }
        return result;
    }

    // 2 stacks version:
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> collect = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            collect.push(root);
            //先壓左 再壓右
            if (root.left != null) {
                stack.push(root.left);
            }
            if (root.right != null) {
                stack.push(root.right);
            }
        }
        while (!collect.isEmpty()) {
            result.add(collect.pop().val);
        }

        return result;
    }
}
