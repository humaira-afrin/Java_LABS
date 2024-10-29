package A1;

import java.util.*; // Scanner, Locale
import static java.lang.System.out;
class Temper2
{
// input tool
    public static Scanner in = null;
    public static void main (String[] args)
    {
    out.println("TEMPERATURES\n");
    // create the input tool
    in = new Scanner(System.in);
    in.useLocale(Locale.US);
    // enter the number of weeks and measurements
    out.print("number of weeks: ");
    int nofWeeks = in.nextInt();
    out.print("number of measurements per week: ");
    int nofMeasurementsPerWeek = in.nextInt();


    // storage space for temperature data
    double[][] t = new double[nofWeeks + 1][nofMeasurementsPerWeek + 1];

    // read the temperatures
    for (int week = 1; week <= nofWeeks; week++)
    {
        out.println("temperatures - week " + week + ":");
        read(t[week]);
    }
    out.println ("");


    // show the temperatures
    out.println("the temperatures");
    for (int week = 1; week <= nofWeeks; week++)
    print(t[week]);
    out.println("");


    // the least, greatest and average temperatures - weekly
    double[] minT = new double[nofWeeks + 1];
    double[] maxT = new double[nofWeeks + 1];
    double[] sumT = new double[nofWeeks + 1];
    double[] avgT = new double[nofWeeks + 1];
/*
 * 
 ADD CODE HERE
 * 
 * 
 * 
 */
    for (int week = 1; week <= nofWeeks; week++)
    {
    minT[week] = min(t[week]); 
    maxT[week] = max(t[week]);
    sumT[week] = sum(t[week]);
    avgT[week] = (sum(t[week]))/nofMeasurementsPerWeek;
    }

    // show the least, greatest and average temperatures
    out.println("the least, greatest and average temperatures"
    + " - weekly");
    print(minT);
    print(maxT);
    print(avgT);
    out.println();
/*  
 * 
 * 
 * 
 * 
 * 
 */
    // the least, greatest and average temperatures - whole period
    double minTemp = min(minT);
    double maxTemp = max(maxT);
    double sumTemp = sum(sumT);
    double avgTemp = (sumTemp)/(nofWeeks*nofMeasurementsPerWeek);


    // show the least, greatest and average temperature for
    // the whole period
    out.println("the least, greatest and average temperature"
    + " - whole period");
    out.println(minTemp + "\n" + maxTemp + "\n" + avgTemp);
    }

    // read reads the temperatures and stores them in a specified
    // array. The temperatures are stored from index 1, inclusive.
    public static void read (double[] temp)
    {
    if (temp.length < 2)
    throw new IllegalArgumentException("not enough space");
    for (int i = 1; i < temp.length; i++)
    temp[i] = in.nextDouble();
    }
    // print displays the temperatures in a specified array.
    // Temperatures are given from index 1, inclusive.
    public static void print (double[] temp)
    {
    if (temp.length < 2)
    throw new IllegalArgumentException("no temperatures");
    for (int i = 1; i < temp.length - 1; i++)
    out.print(temp[i] + " ");
    out.println(temp[temp.length - 1]);
    }
    /*
     * 
     * 
     * 
     * 
     * 
     */
    // min returns the least temperature in a specified array.
    // Temperatures are given from index 1, inclusive.
    public static double min (double[] temp)
    {
        double minsta = temp[1];
        for (int i = 2; i < temp.length; i++)
        {
            if (temp[i] < minsta)
                minsta = temp[i];
        }
        return minsta;
    }
    // max returns the greatest temperature in a specified array.
    // Temperatures are given from index 1, inclusive.
    public static double max (double[] temp)
    {
        double största=temp[1];
        for (int i = 2; i < temp.length; i++){
            if (temp[i] > största)
                största = temp[i];
        }
        return största;
    }
    // sum returns the sum of the temperatures in a specified array.
    // Temperatures are given from index 1, inclusive.
    public static double sum (double[] temp)
    {
        double sumTemp = 0;
        for (int i = 1; i<temp.length; i++){
            sumTemp += temp[i];
        }
        return(sumTemp);
     }
}
