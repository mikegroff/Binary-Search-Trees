
public class extraTest01
{

  public static void main(String[] args)
  {
    GenericBST<Person> myPersons = new GenericBST<>();
    Person [] allThePeople = new Person[3];

    allThePeople[0] = new Person("Cada St-Merrein", "04/22/1961");
    allThePeople[1] = new Person("Perceval Thoreau", "08/08/1450");
    allThePeople[2] = new Person("Magdeleine Corriander Grabb", "05/19/1960");

    for (int i = 0; i < 3; i++)
      myPersons.insert(allThePeople[i]);

    myPersons.inorder();
    System.out.println();
    myPersons.preorder();
    System.out.println();
    myPersons.postorder();
    System.out.println();

    if (myPersons.contains(allThePeople[0]))
      System.out.print("Hooray!\n");
    else
      System.out.print("Oh nooo!! Something went wrong with the contains method.\n");

    for (int i = 0; i < 3; i++)
      myPersons.delete(allThePeople[i]);

    myPersons.inorder();

  }

}
