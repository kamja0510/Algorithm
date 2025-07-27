package templates;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {
    public TreeNode PostOrder(TreeNode curNode){
        if(curNode == null){
            return null;
        }

        PostOrder(curNode.left);
        PostOrder(curNode.right);
        System.out.println(curNode.val);    // 이 방문의 순서에 따라 Post, In, Pre 순회가 바뀐다.

        return new TreeNode(1);
    }

    public TreeNode levelOrder(TreeNode root){
        if(root == null){return null;}

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode currentNode = queue.poll();
            if(currentNode.left != null){
                queue.offer(currentNode.left);
            }
            if(currentNode.right != null){
                queue.offer(currentNode.right);
            }
        }

        return new TreeNode(1);
    }

}

