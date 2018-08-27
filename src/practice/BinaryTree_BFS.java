//package practice;
//
//public class BinaryTree_BFS<E> {
//	TreeNode<E> root;
//	
//	public void levelOrder() {
//		Queue<TreeNode<E>> q = new LinkedList<TreeNode<E>>();
//		q.add(root);
//		while(!q.isEmpty()) {
//			TreeNode<E> curr = q.remove();
//			if(curr != null) {
//				curr.visit();
//				q.add(curr.getLeftChild());
//				q.add(curr.getRightChild());
//			}
//		}
//	}
//}
