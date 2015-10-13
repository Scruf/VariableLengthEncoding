/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package variablelengthencoding;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ekozi
 */

public class VLC <E extends Comparable<E>> {
    public int compareTo(){
        return 1;
        
    }
    public static void main(String []args) throws FileNotFoundException
    {
        ArrayHeap<VLC> heap ;
         ArrayList<String> list = new ArrayList<String>();
        try{
        String line = " ";
         BufferedReader reader = new BufferedReader(new FileReader("sample.txt"));
        
        while((line=reader.readLine())!=null)
        {
            if(!line.equals(" "))
                list.add(line);
        }
       
         
        reader.close();
     
     }catch(Exception ex)
     {
         System.out.print("File was not found");
     }
           list.removeAll(Arrays.asList("", null));
         
     
        
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

    
}
