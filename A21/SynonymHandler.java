// SynonymHandler

/****************************************************************

SynonymHandler handles information about synonyms for various
words.

The synonym data can be read from a file and handled in various
ways. These data consists of several lines, where each line begins
with a word, and this word is followed with a number of synonyms.

The synonym line for a given word can be obtained. It is possible
to add a synonym line, and to remove the synonym line for a given
word. Also a synonym for a particular word can be added, or
removed. The synonym data can be sorted. Lastly, the data can be
written to a given file.

Author: Fadil Galjic

****************************************************************/
//package A2;
import java.io.*;    // FileReader, BufferedReader, PrintWriter,
                     // IOException
import java.util.Arrays;

class SynonymHandler
{
	// readSynonymData reads the synonym data from a given file
	// and returns the data as an array
    public static String[] readSynonymData (String synonymFile)
                                         throws IOException
    {
        BufferedReader reader = new BufferedReader(
	        new FileReader(synonymFile));
        int numberOfLines = 0;
        String synonymLine = reader.readLine();
        while (synonymLine != null)
        {
			numberOfLines++;
			synonymLine = reader.readLine();
		}
		reader.close();

		String[] synonymData = new String[numberOfLines];
        reader = new BufferedReader(new FileReader(synonymFile));
		for (int i = 0; i < numberOfLines; i++)
		    synonymData[i] = reader.readLine();
		reader.close();

		return synonymData;
    }

    // writeSynonymData writes a given synonym data to a given
    // file
    public static void writeSynonymData (String[] synonymData,
        String synonymFile) throws IOException
    {
        PrintWriter writer = new PrintWriter(synonymFile);
        for (String synonymLine : synonymData)
            writer.println(synonymLine);
        writer.close();

    }

    // synonymLineIndex accepts synonym data, and returns the
    // index of the synonym line corresponding to a given word.
    // If the given word is not present, an exception of
    // the type IllegalArgumentException is thrown.
	private static int synonymLineIndex (String[] synonymData,
        String word) throws IllegalArgumentException
    {
		int delimiterIndex = 0;
		String w = "";
		int i = 0;
		boolean wordFound = false;
		while (!wordFound  &&  i < synonymData.length)
		{
		    delimiterIndex = synonymData[i].indexOf('|');
		    w = synonymData[i].substring(0, delimiterIndex).trim();
		    if (w.equalsIgnoreCase(word))
				wordFound = true;
			else
				i++;
	    }

	    if (!wordFound)
	        throw new IllegalArgumentException(
		        word + " not present");

	    return i;
	}

    // getSynonymLine accepts synonym data, and returns
    // the synonym line corresponding to a given word.
    // If the given word is not present, an exception of
    // the type IllegalArgumentException is thrown.
    public static String getSynonymLine (String[] synonymData,
        String word) throws IllegalArgumentException
    {
		int index = synonymLineIndex(synonymData, word);

	    return synonymData[index];
	}

    // addSynonymLine accepts synonym data, and adds a given
    // synonym line to the data.
	public static String[] addSynonymLine (String[] synonymData,
	    String synonymLine)
	{
		String[] synData = new String[synonymData.length + 1];
		for (int i = 0; i < synonymData.length; i++)
		    synData[i] = synonymData[i];
		synData[synData.length -1] = synonymLine;

	    return synData;
	}
/**
 * 
 * 
 * 
 * 
 *  
    // removeSynonymLine accepts synonym data, and removes
    // the synonym line corresponding to a given word.
    // If the given word is not present, an exception of
    // the type IllegalArgumentException is thrown.
    */
	public static String[] removeSynonymLine (String[] synonymData,
	    String word) throws IllegalArgumentException
	{
        int index = synonymLineIndex(synonymData, word);
        String[] synData = new String[synonymData.length - 1];
        for (int i = 0,j=0; i < synonymData.length; i++) {
            if (i != index) {
                synData[j++] = synonymData[i];
            }  
    }
    return synData;
	}

   
/*
 * 
 * 
 * 
 * 
 * 
 * 
*/
    // getSynonyms returns synonyms in a given synonym line.
	public static String[] getSynonyms (String synonymLine)
	{
        int plats = synonymLine.indexOf('|');
        String baraSynonym = synonymLine.substring(plats + 1).trim();
        return baraSynonym.split("\\s*,\\s*"); 
	}

    /*
     * 
     * 
     * 
     * 
     * 
     */
     
   // addSynonym accepts synonym data, and adds a given
    // synonym for a given word.
    // If the given word is not present, an exception of
    // the type IllegalArgumentException is thrown.
	public static void addSynonym (String[] synonymData,
	    String word, String synonym) throws IllegalArgumentException
	{
        int index = synonymLineIndex(synonymData, word); 
        String[] synData = new String [synonymData.length + 1];
        if (index == -1) {
        throw new IllegalArgumentException("Word '" + word + "' not found ");
        }
        
        for (int i = 0; i < synonymData.length; i++) {
            synData[i] = synonymData[i];
            if (i == index) {
                synonymData[index] +=  ", " + synonym;
            } 
        }
        
    }
    

  
/*
 * 
 * 
 * 
 * */
 
    // removeSynonym accepts synonym data, and removes a given
    // synonym for a given word.
    // If the given word or the given synonym is not present, an
    // exception of the type IllegalArgumentException is thrown.
    // If there is only one synonym for the given word, an
    // exception of the type IllegalStateException is thrown.
	public static void removeSynonym (String[] synonymData,
	    String word, String synonym)
	    throws IllegalArgumentException, IllegalStateException{
        
        int index = synonymLineIndex(synonymData, word); 
        String synLine = getSynonymLine(synonymData, word); 
        String [] synonyms = getSynonyms(synLine);
        String[] synData = new String [synonyms.length-1];

        if (index == -1) {
            throw new IllegalArgumentException("ordet finns inte i  synonymData.");
        }
         if (synonymData.length == 1) {
            throw new IllegalStateException("kan inte ta bort den enda synonymen ");
        }

        int pos= -1;
        int i= 0;

       while(i<synonyms.length && pos==-1){
            if (synonyms[i].equalsIgnoreCase(synonym)) {
                pos = i;
                break;
            }
            i++;
            
         
        }

           if (i == -1) {
            throw new IllegalArgumentException("synonymen hittas inte");
            }

        
    String baraOrd = synLine.substring (0, synLine.indexOf("|")).trim();

       int a = 0;
        for (int m = 0; m < synonyms.length; m++) {
            if (m==pos) {
                 continue;
             }
        synData[a++] = synonyms[m];
          
        }

      String nyaLine = baraOrd + "| ";
        for (int j = 0; j < synData.length; j++) {
        nyaLine += synData[j];
        if (j < synData.length - 1) {
            nyaLine += ", ";
        }
    }

    synLine = nyaLine.trim();
    synonymData[index] = synLine;
}
       
    // sortIgnoreCase sorts an array of strings, using
    // the selection sort algorithm
    private static void sortIgnoreCase (String[] strings) // en genrell method för att sortera
    {
        for (int i = 1; i < strings.length; i++) {
            String aktuell = strings[i];
            int j = i - 1;
    
            while (j >= 0 && aktuell.compareToIgnoreCase(strings[j]) < 0) {
                strings[j+1] = strings[j];
                j--;
            }
    
            strings[j + 1] = aktuell; // om aktuell är större än föregående
        }
 
	}


    // sortSynonymLine accepts a synonym line, and sorts
    // the synonyms in this line
    private static String sortSynonymLine (String synonymLine)
    {
        String [] synonyms = getSynonyms(synonymLine);
        sortIgnoreCase(synonyms);

        String baraOrd = synonymLine.substring (0, synonymLine.indexOf("|")).trim();
        String nyaLine = baraOrd + " | ";
        for (int j = 0; j < synonyms.length; j++) {
            nyaLine += synonyms[j];
            if (j < synonyms.length - 1) {
                nyaLine += ", ";
            }
        }

        return nyaLine;
    }
    
    

    // sortSynonymData accepts synonym data, and sorts its
    // synonym lines and the synonyms in these lines
	public static void sortSynonymData (String[] synonymData)
	{
        for (int i = 0; i < synonymData.length; i++) {
            //String baraOrd = synonymData[i].substring(0, synonymData[i].indexOf("|")).trim();
            String nyaLine = sortSynonymLine(synonymData[i]);
            synonymData[i] = nyaLine;
        }
        sortIgnoreCase(synonymData);
    }
}
