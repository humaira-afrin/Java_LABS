// ArrayNumberSequence.java

import java.util.Arrays;

/****************************************************************

ArrayNumberSequence represents a sequence of real numbers.
Such a sequence is defined by the interface NumberSequence.
The class uses an array to store the numbers in the sequence.

Author
Fadil Galjic

****************************************************************/

public class ArrayNumberSequence implements NumberSequence
{
	// numbers in the sequence
    private double[] numbers;

    // create the sequence
    public ArrayNumberSequence (double[] numbers)
    {
		if (numbers.length < 2)
		    throw new IllegalArgumentException("not a sequence");

		this.numbers = new double[numbers.length];
		for (int i = 0; i < numbers.length; i++)
		    this.numbers[i] = numbers[i];
	}

    // toString returns the character string representing this
    // sequence
	public String toString ()
	{
		String s = "";
		for (int i = 0; i < numbers.length - 1; i++)
		    s = s + numbers[i] + ", ";
		s = s + numbers[numbers.length - 1];

		return s;
	}

	public double upperBound (){
		double största = numbers[0];

		for (int i = 1; i<numbers.length; i++){
			if (numbers[i]> största){
				största=numbers[i];
			}
		}
		return (största);
	}

	public double lowerBound (){
		
		double minsta = numbers[0];
		for (int i = 1; i < numbers.length; i++){
			if (numbers[i] < minsta){
				minsta=numbers[i];
			}
		}
		return (minsta);
	}
	public int length(){
		return this.numbers.length;
	}
	public double numberAt (int position) throws IndexOutOfBoundsException
	{
        double number= this.numbers[position];
		return number;
	}

	public int positionOf (double number){
		int positionOf =-1;
		for (int i = 0; i<numbers.length; i++){
			if (numbers[i]==number){
				positionOf = i;
			}
		}
		return (positionOf);
	}

	public boolean isIncreasing (){
		for (int i= 0; i< numbers.length; i++){
			if (numbers[i]>numbers[i+1]){
				return(false);
			}
		}
		return (true);
	}

	public boolean isDecreasing (){
		for (int i= 0; i< numbers.length; i++){
			if (numbers[i]<numbers[i+1]){
				return(false);
			}
		}

		return (true);
	}
	public boolean contains (double number){
		for (int i = 0; i<numbers.length;i++){
			if (numbers[i]==number){
				return (true);
			}
		}
		return (false);
	}
	public void add (double number){
		double [] newArray = new double [numbers.length+1];
		for (int i = 0; i < numbers.length; i++) {
			newArray[i] = numbers[i];
		}
		newArray[numbers.length] = number;
		numbers = newArray;
	}

	public void insert (int position, double number)
	throws IndexOutOfBoundsException
	{
		if (position<0 || position > length()){
			throw new IndexOutOfBoundsException("posotionen finns inte");
		}
		double [] newArr= new double [numbers.length+1];
		for (int i=0; i<position; i++){
			newArr[i]=numbers[i];
		}
		newArr [position]= number;
		for (int i = position; i < numbers.length; i++){
			newArr[i+1]=numbers[i];
		}
		numbers = newArr;
	}

	public void removeAt (int position)
	throws IndexOutOfBoundsException, IllegalStateException
	{
		if (position <1 || position >numbers.length){
			throw new IndexOutOfBoundsException ("positionen finns inte");
		
		}
		if (length()<=2){
			throw new IllegalStateException("för lite)");
		}
		double [] newArr= new double [numbers.length-1];
		for (int i = 0,j=0; i<numbers.length; i++){
			if (i+1 == position){
				continue;
			}
			newArr[j++] = numbers[i];
		}
		numbers = newArr;
	}
    public double[] asArray ()
	{
		double [] newArr = new double [numbers.length];
		for (int i = 0; i<numbers.length; i++){
			newArr[i]= numbers[i];
		}
		return (newArr);
	}
}