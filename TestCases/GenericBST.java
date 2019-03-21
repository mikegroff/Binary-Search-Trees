//Michael Groff COP 3503C

import java.io.*;
import java.util.*;

class Node<T extends Comparable<T>>
{
	//using the object type T to creat a node that holds that object type
	//and all extends the comparable class of that object type on order to determine
	//where in the tree the node should be located
	T data;
	Node<T> left, right;

	Node(T data)
	{
		this.data = data;
	}
}

public class GenericBST<T extends Comparable<T>>
{
	private Node<T> root;

	public void insert(T data)
	{
		root = insert(root, data);
	}

	private Node<T> insert(Node<T> root, T data)
	{
		if (root == null)
		{
			return new Node<T>(data);
		}
		else if (data.compareTo(root.data) < 0)
		{
			// inserts the node into the tree on the left side if its order is before the current node
			root.left = insert(root.left, data);
		}
		else if (data.compareTo(root.data) >0)
		{
			// inserts the node into the tree on the right side if its order is before the current node
			root.right = insert(root.right, data);
		}
		else
		{
			// Stylistically, I have this here to explicitly state that we are
			// disallowing insertion of duplicate values. This is unconventional
			// and a bit cheeky.
			;
		}

		return root;
	}

	public void delete(T data)
	{
		//calls on delete node funtion
		root = delete(root, data);
	}

	private Node<T> delete(Node<T> root, T data)
	{
		// compares the data to the data in the node and calls the delete function recursively
		// by comparing the the deleted data to the data in the node until if finds the node to be deleted

		if (root == null)
		{
			return null;
		}
		else if (data.compareTo(root.data) < 0)
		{
			root.left = delete(root.left, data);
		}
		else if (data.compareTo(root.data) > 0)
		{
			root.right = delete(root.right, data);
		}
		else
		{
			//once it finds the node that its looking for it checks to see if the node has children


			if (root.left == null && root.right == null)
			{
				return null;
			}
			else if (root.right == null)
			{
				return root.left;
			}
			else if (root.left == null)
			{
				return root.right;
			}
			else
			{
				//replaces the node that is being deleted with the proper child to take its place
				// thus preservind the properties of a BST
				root.data = findMax(root.left);
				root.left = delete(root.left, root.data);
			}
		}

		return root;
	}

	// This method assumes root is non-null, since this is only called by
	// delete() on the left subtree, and only when that subtree is non-empty.
	private T findMax(Node<T> root)
	{
		//finds the max value of the contents under a node by contiuing down the right branch
		//until the right node is not empty
		while (root.right != null)
		{
			root = root.right;
		}

		return root.data;
	}

	// Returns true if the value is contained in the BST, false otherwise.
	public boolean contains(T data)
	{
		return contains(root, data);
	}

	private boolean contains(Node<T> root, T data)
	{
		//uses compareTo to recursively travel through the tree until it finds the node its looking for
		// or finds where in the tree it should be and if nothing is there it returns false
		if (root == null)
		{
			return false;
		}
		else if (data.compareTo(root.data) < 0)
		{
			return contains(root.left, data);
		}
		else if (data.compareTo(root.data) > 0)
		{
			return contains(root.right, data);
		}
		else
		{
			return true;
		}
	}

	public void inorder()
	{
		System.out.print("In-order Traversal:");
		inorder(root);
		System.out.println();
	}

	private void inorder(Node<T> root)
	{
		// travels the tree recursively until it gets to the left most leaf and prints it
		// then returns the right node on that level, prints it and goes up a level and continues
		//if right node is emtpy otherwise travels down that node
		// this way the contents of the tree are printed in order
		if (root == null)
			return;

		inorder(root.left);
		System.out.print(" " + root.data);
		inorder(root.right);
	}

	public void preorder()
	{
		System.out.print("Pre-order Traversal:");
		preorder(root);
		System.out.println();
	}

	private void preorder(Node<T> root)
	{
		// simply goes down the tree recursevely and prints everything on the left branch and then everything on the right
		if (root == null)
			return;

		System.out.print(" " + root.data);
		preorder(root.left);
		preorder(root.right);
	}

	public void postorder()
	{
		System.out.print("Post-order Traversal:");
		postorder(root);
		System.out.println();
	}

	private void postorder(Node<T> root)
	{
		// simply goes down the tree recursevely and prints everything on the left branch and then everything on the right
		//this time reaches the bottom of the tree before it begins to print
		if (root == null)
			return;

		postorder(root.left);
		postorder(root.right);
		System.out.print(" " + root.data);
	}

	public static double difficultyRating()
  {
  return 1.0;//
  }

  public static double hoursSpent()
  {
  return 1.5;//
  }

}
