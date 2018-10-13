package DataUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

/**
 * Created by alvaro on 13/09/18.
 */
public class DataOutput {
    public static void outputData( HashMap<String, HashMap<String, List<double[]>>> results){
        HashMap<String, List<double[]>> localResults;
        for (String function: results.keySet()) {
            System.out.println(function+": ");
            localResults = results.get(function);
            for(String method: localResults.keySet()){
                StringBuilder fileString = new StringBuilder();
                System.out.println(method+": ");
                //printList( localResults.get(method) );
                List<double[]> theList =localResults.get(method);
                for(int i = 0; i < theList.size(); i++){
                    fileString.append( writeArray( theList.get(i) ) );
                }
                try{
                    saveCSVData( function, method, fileString.toString());
                }catch (FileNotFoundException ex){
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void printList( List<double[]> list ){
        for(int i = 0; i < list.size(); i++){
            printArray( list.get(i));
        }
    }


    public static void writeList( List<double[]> list ){
        for(int i = 0; i < list.size(); i++){
            writeArray( list.get(i));
        }
    }

    public static void printArray(double []x){
        System.out.print("[ ");
        for (int i = 0; i < x.length; i++) {
            System.out.print(String.valueOf(x[i]) + ( i!= x.length -1? ", ": "" ));
        }
        System.out.print(" ]\n");
    }

    public static String writeArray(double []x){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < x.length; i++) {
             sb.append( String.valueOf(x[i]) + ( i!= x.length -1? ",": "\n" ));
        }
        return  sb.toString();
    }

    //Write to CSV
    public static void saveCSVData(String function, String method, String file) throws FileNotFoundException{
        String fileName = function+method+".csv";

        PrintWriter pw = new PrintWriter(new File(fileName));
        //StringBuilder sb = new StringBuilder();

        pw.write(file);

        pw.close();
        System.out.println("done!");
    }
}
