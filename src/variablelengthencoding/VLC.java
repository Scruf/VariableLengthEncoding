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

public class VLC {
          
    public static void main(String []args) throws FileNotFoundException
    {
       
        ArrayHeap<Node> heap = new ArrayHeap<Node>();
        
         
        try{
        String line = " ";
         BufferedReader reader = new BufferedReader(new FileReader("sample.txt"));
        
        while((line=reader.readLine())!=null)
        {
            System.out.println("Line is "+line);
            char seq = line.split(" ")[0].charAt(0);
            int freq = Integer.parseInt(line.split(" ")[1]);
            System.out.println("seq "+seq+" freq "+freq);
            heap.add(new Node(seq,freq));
        }
       
         
        reader.close();
     
     }catch(Exception ex)
     {
     
     }
        System.out.print(heap.size());
     /*
     Iterator<Node> node = heap.iterator();
     while(node.hasNext()){
         char seq = node.next().getSequence();
         int freq = node.next().getFrequence();
         System.out.println(seq+" "+freq);
         
     }*/
           
           
    }


  

    
}
