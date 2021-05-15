package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * write (Key + ": " + Value) from a TreeMap to a file, one couple per line.
 * key : symptom name
 * value : occurrences number of the symptom in a precedent file.  
 */

public class WriteSymptomsAndOccurrencesToFile {
	private TreeMap<String, Integer> symptomAndOccurrencesMap;
    private String filepath;

/**    
 * @param symptomAndOccurrencesMap
 * @param filepath
 */
    
    public WriteSymptomsAndOccurrencesToFile(TreeMap<String,Integer> symptomAndOccurrencesMap, String filepath)
    {
            this.symptomAndOccurrencesMap = symptomAndOccurrencesMap;
            this.filepath = filepath;
    }

    public void writeSymptomsAndOccurrencesToFile()
    {                
            File fileOut = new File(filepath);
            BufferedWriter writer = null;

            try
            {
                    writer = new BufferedWriter(new FileWriter(fileOut));

                    for (Entry<String, Integer> entry : symptomAndOccurrencesMap.entrySet())
                    {
                            writer.write(entry.getKey() + ": " + entry.getValue());
                            writer.newLine();
                    }
            }
/**
 * @throws IOException
 */
            catch (IOException e)
            {
                e.printStackTrace();
            }
            finally
            {
                try
                {
                    writer.close();
                }
                catch (Exception e)
                {
                }
            }
    }

}
