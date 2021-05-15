package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *copy data from a file (: 1 string per line) without any treatment (unordered, duplications,...)
 */
public class ReadSymptomDataFromFile 
{
/**
 *@param filepath 
 **/
        private String filepath;

        public ReadSymptomDataFromFile(String filepath)
        {
                this.filepath = filepath;
        }
/**
 * @return ArrayList<String>
 */
        public ArrayList <String> getSymptoms()
        {
                ArrayList <String> symptomList = new ArrayList<String>();
                
                if (filepath != null)
                {        
                    try
                    {
                    BufferedReader reader = new BufferedReader(new FileReader(filepath));
                    String symptom = reader.readLine();
                
                    while (symptom != null)
                    {
                        symptomList.add(symptom);
                        symptom = reader.readLine();
                    }
                    reader.close();
                    }
/**
 *  *@throws IOException
 */
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }
                }
                
                return symptomList;
        }
}