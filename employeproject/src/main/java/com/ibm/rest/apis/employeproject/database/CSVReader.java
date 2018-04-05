package com.ibm.rest.apis.employeproject.database;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class CSVReader {
	  
	 static FileWriter writer = null; 
	 static String csvFile = "d:/records.csv";
	 static BufferedReader br = null;
    public static void main(String[] args) {

        
        String line = "";
        String cvsSplitBy = ",";

        try {
        	writer = new FileWriter("d:/results.csv",false);
        	
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] fields = line.split(cvsSplitBy);
                  
                
                File file = new File(fields[5]);
                boolean filexits = file.exists();
                String results = filexits+"";
                generateCsvFile( fields[0],fields[1],fields[2],fields[3],fields[4],fields[5],results);

                
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
            if (writer != null) {
                    try {
                
                writer.flush();
                writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                
            }
        
        }
    }
    
    private static void generateCsvFile(String obj_item, String obj_createdate, String obj_path, String obj_filename,String Obj_mimetype,String Obj_filepath, String results)
    {
     try
     {
       
   
             writer.append(" ");
         writer.append(',');
              
         writer.append(obj_item);
         writer.append(',');
         writer.append(obj_createdate);
                     writer.append(',');
         writer.append(obj_path);
                     writer.append(',');
         writer.append(obj_filename);
         
         writer.append(',');
         writer.append(Obj_mimetype);
      
      	writer.append(',');
      	writer.append(Obj_filepath);
   
   		writer.append(',');
   		writer.append(results);
             writer.append('\n');
           
              
         //generate whatever data you want
   
         
     }
     catch(IOException e)
     {
          e.printStackTrace();
     } 
     }

}