package A1;
import java.util.*; // Scanner, Locale
import static java.lang.System.out;
class Temper1
{
    public static void main (String[] args)
    {
        System.out.println("TEMPERATURES\n");
        // input tool
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);


    // enter the number of weeks and measurements
        System.out.print("number of weeks: ");
        int nofWeeks = in.nextInt();
        System.out.print("number of measurements per week: ");
        int nofMeasurementsPerWeek = in.nextInt();


    // storage space for temperature data
    double[][] t = new double[nofWeeks + 1] [nofMeasurementsPerWeek + 1];
    // read the temperatures
    for (int week = 1; week <= nofWeeks; week++)
    {
    System.out.println("temperatures - week " + week + ":");
        for (int measurement = 1; measurement <= nofMeasurementsPerWeek; measurement++)
        t[week][measurement] = in.nextDouble();
    }
    System.out.println("");


    // show the temperatures
    System.out.println("the temperatures");
    for (int week = 1; week <= nofWeeks; week++)
    {
        for (int measurement = 1; measurement <= nofMeasurementsPerWeek; measurement++)
        System.out.print(t[week][measurement] + " ");
        System.out.println("");
    }
    System.out.println("");

    // the least, greatest and average temperatures - weekly
    double[] minT = new double[nofWeeks + 1];
    double[] maxT = new double[nofWeeks + 1];
    double[] sumT = new double[nofWeeks + 1];
    double[] avgT = new double[nofWeeks + 1];
/*
 * 
 * 
 * 
 * 
 * 
 */
    // add code here
for (int week = 1; week <= nofWeeks; week++) {
    double minsta = t[week][1];
    double maximum = t[week][1];
    double summa = 0;
    for (int measurement = 1; measurement <= nofMeasurementsPerWeek; measurement++) {
        if (t[week][measurement] < minsta) {
            minsta = t[week][measurement];
        }
        if (t[week][measurement] > maximum) {
            maximum = t[week][measurement];
        }
        summa += t[week][measurement];
    }
    avgT[week] = summa / nofMeasurementsPerWeek;
    minT[week] = minsta;
    maxT[week] = maximum;
    sumT[week]=summa;
}
/*
 * 
 * 
 * 
 * 
 * 
 */
 // show the least, greatest and average temperatures
    System.out.println("the least, greatest and average temperatures"
    + " - weekly");
    for (int week = 1; week <= nofWeeks; week++)
    out.print(minT[week] + " ");
    out.println("");
    for (int week = 1; week <= nofWeeks; week++)
    out.print(maxT[week] + " ");
    out.println("");
    for (int week = 1; week <= nofWeeks; week++)
    out.print(avgT[week] + " ");
    out.println("");
    out.println();
    /*
     * 
     * 
     * 
     * 
     */
    // the least, greatest and average temperatures - whole period
    double minTemp = minT[1];
    double maxTemp = maxT[1];
    double sumTemp = sumT[1];
    out.println(sumTemp);
    out.println(sumT[1]);

    double avgTemp = 0;
   /*
    * 
    *
    *
    */
    // add code here
    for ( int week= 2; week<=nofWeeks; week++){
        if(minT[week]<minTemp)
        minTemp=minT[week];
        if (maxT[week]>maxTemp)
        maxTemp=maxT[week];
        sumTemp+=sumT[week];
    }
    out.println(sumTemp);

    avgTemp = sumTemp/(nofMeasurementsPerWeek * nofWeeks);
/*
    * 
    *
    *
    */
    // show the least, greatest and average temperature for
    // the whole period
    out.println("the least, greatest and average temperature"
    + " - whole period");
    out.println(minTemp + "\n" + maxTemp + "\n" + avgTemp);
    }
    }
