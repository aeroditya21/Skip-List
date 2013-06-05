package skiplist;

public class SkipList
{

	Node head;
	static final int MAXLEVEL = 5;
	static final int INF = 9999;
	
	
	// Constructor creates Skiplist with a HEAD node that has 
	// maximum level and the smallest key, as well as a TAIL node 
	// with the largest key. HEAD and TAIL nodes are sentinels
	SkipList()
	{
		head = new Node(-INF,0,MAXLEVEL);
		Node tail = new Node(INF,0,MAXLEVEL);
		for(int newLevel = 0;newLevel < MAXLEVEL;newLevel++)
			head.next[newLevel] = tail;
	}
	
	
	// Search method searches for node in SkipList
	// Argument : 	'Search key'
	// Returns  : 	'Node' if node is found 
	//				'null' if node not found
	Node search(int skey)
	{
		Node temp = head;
		int tlevel = temp.level-1;
		
		// Keep moving down till the lowest level
		while(tlevel >= 0)
		{
			// Keep moving forward till next node is greater than search key
			while(temp.next[tlevel].key < skey)
				temp = temp.next[tlevel];
			tlevel--;
		}
		
		// temp is node previous to searched node
		if(temp.next[0].key == skey)
			return temp.next[0];
		else return null;
	}
	
	
	// Insert Method inserts new Node in SkipList
	// Argument : 	'Node'
	// Returns  : 	'true' if node is inserted successfully 
	//				'false' if node is already present
	boolean insert(Node newNode)
	{
		Node temp = head;
		int tlevel = temp.level-1;
		Node[] PrevNode = new Node[MAXLEVEL];
		
		// Keep moving down till the lowest level
		while(tlevel >= 0)
		{
			// Keep moving forward till next node is greater than search key
			while(temp.next[tlevel].key < newNode.key)
				temp = temp.next[tlevel];
			PrevNode[tlevel] = temp;		// Keep record of previous nodes at each level
			tlevel--;
		}
		
		// Node is already present
		if(temp.next[0].key == newNode.key)
			return false;
		else
		{
			// Re-assign pointers of previous nodes at each level
			for(int newLevel=0;newLevel<newNode.level;newLevel++)
			{
				newNode.next[newLevel] = PrevNode[newLevel].next[newLevel];
				PrevNode[newLevel].next[newLevel] = newNode;
			}
			return true;
		}
			
	}
	
	
	// Delete method searches for node in SkipList and deletes it
	// Argument : 	'Search key'
	// Returns  : 	'true' if node is found and deleted 
	//				'false' if node not found
	boolean delete(int skey)
	{
		Node temp = head;
		int tlevel = temp.level-1;
		Node[] PrevNode = new Node[MAXLEVEL];
				
		// Keep moving down till the lowest level
		while(tlevel >= 0)
		{
			// Keep moving forward till next node is greater than search key
			while(temp.next[tlevel].key < skey)
				temp = temp.next[tlevel];
			PrevNode[tlevel] = temp;		// Keep record of previous nodes at each level
			tlevel--;
		}
		System.out.println("Nodes previous to node " + skey + " are---");
		for(Node x : PrevNode)
			System.out.println(x.key);
		// Node is already present
		if(temp.next[0].key == skey)
		{
			temp = temp.next[0];
			
			// Re-assign pointers of previous nodes at each level
			for(int newLevel=0;newLevel<temp.level;newLevel++)
				PrevNode[newLevel].next[newLevel] = temp.next[newLevel];

			return true;
		}
		else
			return false;
		
	}
	 
	
	void printSkipList()
	{
		System.out.println("------ Skip List ------");
		Node temp = this.head;
		while(temp != null)
		{
			System.out.println(temp.key + " : " + temp.level);
			temp = temp.next[0];
		}
	}
	
}
