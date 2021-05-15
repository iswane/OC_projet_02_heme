package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

/**
 * 1. read data from a file, 1 symptom per line
 * 2. write an ordered list of symptoms and their number of occurrences to a new file
 */

public class AnalyticsCounter 
{
/**
 * @param filepath of the original text document
 * @param filepath of the final text document
 */
		static final String symptomsInputFilePath = "/home/alex/Desktop/_02.projet/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/symptoms.txt";
		static final String symptomsOutputFilePath = "/home/alex/Desktop/_02.projet/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/results.out"; 
		
        public static void main(String[]args)
        {

        		ArrayList <String> symptomList = new ArrayList<String>();
                ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(symptomsInputFilePath);
                TreeMap<String,Integer> symptomAndOccurrencesMap = new TreeMap<String,Integer>();
                WriteSymptomsAndOccurrencesToFile writer = new WriteSymptomsAndOccurrencesToFile(symptomAndOccurrencesMap, symptomsOutputFilePath);
/*
 * copy data from a file (: 1 string per line) without any treatment (unordered, duplications,...)
 * paste each line as a new symptom in an ArrayList      
 */
                symptomList = reader.getSymptoms();
/*
 * convert the ArrayList into an TreeMap : key=Symptom, value=number of occurrences of the symptom
 */
                if (symptomList != null)
                {
                	for (String elt : symptomList)
                	{
                        if (!symptomAndOccurrencesMap.containsKey(elt))
                        {
                                symptomAndOccurrencesMap.put(elt, Collections.frequency(symptomList, elt));
                        }
                	}
                }
/*
 * convert the TreeMap into a new file : (1 symptom & its occurrences number) per line
 */
                writer.writeSymptomsAndOccurrencesToFile();
        }
}
