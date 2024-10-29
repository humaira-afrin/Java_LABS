// LinkedNumberSequence.java

/****************************************************************

LinkedNumberSequence represents a sequence of real numbers.
Such a sequence is defined by the interface NumberSequence.
The class uses linked nodes to store the numbers in the sequence.

Author
Fadil Galjic

****************************************************************/

public class LinkedNumberSequence implements NumberSequence
{
	private class Node
	{
		public double number;
		public Node next;

		public Node (double number)
		{
			this.number = number;
			next = null;
		}
	}

	// the first node in the node-sequence
    private Node first;

    // create the sequence
    public LinkedNumberSequence (double[] numbers)
    {
		if (numbers.length < 2)
		    throw new IllegalArgumentException("not a sequence");

        first = new Node(numbers[0]);
        Node n = first;
		for (int i = 1; i < numbers.length; i++)
		{
			n.next = new Node(numbers[i]);
			n = n.next;
		}
	}

    // toString returns the character string representing this
    // sequence
	public String toString ()
	{
		String s = "";
		Node n = first;
		while (n.next != null)
		{
		    s = s + n.number + ", ";
		    n = n.next;
		}
		s = s + n.number;

		return s;
	}
	public int length()
	{
		int length = 0;
		if (first==null){
			return (length);
		}
		Node nyaNode = first;
		while (nyaNode != null){
			length++;
			nyaNode= nyaNode.next;
		}
		return (length);
	}

	public double upperBound (){
		Node curr =first; 
		double max= first.number;
		while(curr != null){
			if (curr.number > max){
				max=curr.number;
			}
			curr=curr.next;
		}
		return (max);
	}

	public double lowerBound (){
		Node curr=first; 
		double min = first.number;
		while(curr != null){
			if (curr.number < min){
				min = curr.number;
			}
			curr=curr.next;
		}
		return (min);
	}
	
	public double numberAt (int position) throws IndexOutOfBoundsException
	{
		if (position == -1){
			throw new IndexOutOfBoundsException("Finns inte");
		}
		Node n = first;
		int pos= 0;
		double nummer = 0;
		while (n != null){
			if (pos == position){
				nummer=n.number;
			}
			pos ++;
			n = n.next;
		}
		return (nummer);
	}

	public int positionOf (double number){
		Node n = first;
		int count = 0;// aktuella
		int pos = -1;
		while (n != null){
			if (n.number == number){
				pos= count;
				break;
			}
			count ++;
			n= n.next;
		}
		return (pos);
	}

	public boolean isIncreasing (){
		Node n = first;
    	while (n.next != null) {
        	if (n.number >= n.next.number) {
            	return false;
       		}
        n = n.next;
    	}
		return (true);
	}

	public boolean isDecreasing (){
		Node n = first;
    	while (n != null && n.next != null) {
        	if (n.number < n.next.number) {
            	return false;
       		}
        n = n.next;
    	}
		return (true);
	}

	public boolean contains (double number){
		Node n = first;
    	while (n != null){
			if (n.number == number){
				return (true);
			}
			n= n.next;
		}
		return (false);
	}
	
	public void add (double number)
	{
		Node node = new Node (number);
		if (first == null)
			first = node;
		else {
			Node n = first;
			while(n.next != null)
				n= n.next; //sista noden
			n.next = node;
		}
		/*Node n = first;
		if (first == null){
			first= node;
		}
		while (n.next != null){
			n= n.next;
		}
		n.next = node;*/

	}

	public void insert (int position, double number)
	throws IndexOutOfBoundsException
	{
		if (position < 0){
			throw new IndexOutOfBoundsException("finns inte");
		}
		Node node = new Node (number);
		if (position == 0){
			node.next = first; //om fördta noden ska inser flyttar vi first
			first = node;
		}
		else {
			Node n = first;
			for (int i = 0; i<position; i++){
				n = n.next;
			}
			node.next = n.next;
			n.next = node;
		}
	}

	public void removeAt (int position)
	throws IndexOutOfBoundsException, IllegalStateException
	{
		if (position < 0) {
			throw new IndexOutOfBoundsException("finns inte");
		}
		if (length()<=1){
			throw new IllegalStateException("bara ett element");
		}
		
		if (position == 0){
			first = first.next;
		}
		
		Node n = first;
		int i = 0;
		while (n != null)
		{
			if (i == position-1){
				n. next = n.next.next;
			}
			n=n.next;
			i++;
		}
	}

    public double[] asArray ()
	{
		Node n = first;
		int length=length();
		double[] array = new double[length];
		for (int i = 0; i < length; i++) {
			array[i]= n.number;
			n = n.next;
		}
		return (array);
	}
}