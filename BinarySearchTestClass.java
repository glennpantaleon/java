// Glenn Pantaleon
// CSCI-260-M01
// Homework 4
// 12/14/2013


public class BinarySearchTestClass 
{

	public static void main(String[] args) 
		{
			BinarySearchTree<Integer> tree1 = new BinarySearchTree<Integer>();


				tree1.add(5);
				tree1.add(10);
				tree1.add(15);
				tree1.add(20);
				tree1.add(25);
				tree1.add(30);
				tree1.add(35);
				tree1.add(40);
				tree1.add(45);

				tree1.treebalance();

				System.out.println(BinarySearchTree.PREORDER);
				System.out.println(BinarySearchTree.INORDER);
				System.out.println(BinarySearchTree.POSTORDER);

		}

}