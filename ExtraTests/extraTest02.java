public class extraTest02
{

  public static void main(String[] args)
  {
    GenericBST<Double> list = new GenericBST<>();

    double [] arr = {-1.5, 2.7, 11.25, 11111111111111111111.9, -1111110.10};

    for (int i = 0; i < arr.length; i++)
    {
      System.out.println("Inserting . . . " + arr[i]);
      list.insert(arr[i]);
    }

    System.out.println("Original list: ");
    list.inorder();
    list.preorder();
    list.postorder();

    System.out.println();

    // Delete all the numbers at odd indices of arr from the BST
    for (int i = 1; i < arr.length; i += 2)
    {
      System.out.println("Deleting . . . " + arr[i]);
      list.delete(arr[i]);
    }

    System.out.println("Deleted-some-elements list: ");
    list.inorder();
    list.preorder();
    list.postorder();

  }
}
