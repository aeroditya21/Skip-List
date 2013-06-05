package skiplist;

class Node 
{
	int key, value, level;
	Node[] next;
	
	Node(int key, int value)
	{
		this.key = key;
		this.value = value;
		level = 1;
		while(Math.random() < 0.5)
			level++;
		if(level > SkipList.MAXLEVEL)
			level = SkipList.MAXLEVEL;
		next = new Node[level];
	}
	
	Node(int key, int value, int level)
	{
		this(key, value);
		this.level = level;
		next = new Node[level];
	}
}
