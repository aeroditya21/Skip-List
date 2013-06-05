package skiplist;

public class Main 
{
	public static void main(String[] args) 
	{
		SkipList skip = new SkipList();
		
		// Create a skip list having 12 nodes
		skip.insert(new Node(10,50));
		skip.insert(new Node(5,45));
		skip.insert(new Node(15,70));
		skip.insert(new Node(20,60));
		skip.insert(new Node(65,10));
		skip.insert(new Node(30,55));
		skip.insert(new Node(35,21));
		skip.insert(new Node(25,90));
		skip.insert(new Node(70,40));
		skip.insert(new Node(50,70));
		skip.insert(new Node(45,80));
		skip.insert(new Node(50,67));
		skip.printSkipList();
		
		// Deleting a node, and checking for its presence in skip list
		skip.delete(30);
		System.out.println("After deleting node with key 30");
		skip.printSkipList();
		System.out.println((skip.search(30)==null?"Node 30 absent!":"Node 30 found!"));

		// Searching a node, and checking its successor to verify links
		Node n;
		if((n = skip.search(25))!=null)
			System.out.println("Successor of node 25 at its highest level " + n.level + ": " + n.next[n.level-1].key);

	}
}
