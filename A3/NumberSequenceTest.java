// NumberSequenceTest.java

/****************************************************************

NumberSequenceTest is a test program for the classes
ArrayNumberSequence and LinkedNumberSequence.

Author
Fadil Galjic

****************************************************************/

import static java.lang.System.out;

class NumberSequenceTest
{
    public static void main (String[] args)
    {
		double[] realNumbers =
		    {8.0, 2.0, 16.0, 5.0, 1.0, 12.0, 4.0};
        NumberSequence sequence = null;
        sequence = new ArrayNumberSequence(realNumbers);
        //sequence = new LinkedNumberSequence(realNumbers);
        out.println("the sequence:");
        out.println(sequence);
        out.println();

        // add code here
        out.println("length : "+ sequence.length());
        out.println ("One Upper bound: "+sequence.upperBound());
        out.println ("One lower bound: "+sequence.lowerBound());
        out.println();

        out.println("number at pos 3: "+ sequence.numberAt(3 ));
        out.println ("position of 8: "+ sequence.positionOf(8));
        out.println();

        out.println("is increasing: "+ sequence.isIncreasing( ));
        out.println("is decreasing: "+ sequence.isDecreasing( ));
        out.println("contains: "+ sequence.contains( 16));
        out.println();

        sequence.add (32);
        out.println ("add 32: ");
        out.println (sequence);
        sequence.insert(6, 00);
        out.println ("inser 0 at position 7: ");
        out.println (sequence);
        sequence.removeAt(7);
        out.println("remove at position 7: ");
        out.println (sequence);
        out.println();

        sequence.asArray();
        out.println("corresponding array: ");
        out.println(sequence);
        out.println();
    }
}