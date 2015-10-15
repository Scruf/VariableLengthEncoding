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
import java.util.Collections;
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
            try (BufferedReader reader = new BufferedReader(new FileReader("sample.txt"))) {
                while((line=reader.readLine())!=null)
                {
                   
                    char seq = line.split(" ")[0].charAt(0);
                    int freq = Integer.parseInt(line.split(" ")[1]);
                    heap.add(new Node(seq,freq));
                }   }
     
     }catch(Exception ex)
     {
     
     }
      Symbol symb = new Symbol();
      ArrayList<Node> list = new ArrayList<Node>();
    while(heap.size()>1){
        
        
       Node n1 = heap.removeMin();
      
       Node n2 = heap.removeMin();
       
       int freqN1 = n1.getFrequence();
       int freqN2 = n2.getFrequence();
       int sum = freqN1+freqN2;
       Node root = new Node(' ',sum);
        System.out.println(n1.getFrequence());
        System.out.println(n2.getFrequence());
        System.out.println(root.getFrequence());
        System.out.println("--------------------");
        list.add(n1);
        list.add(n2);
       
       heap.add(root);
       
       
    }
    list.add(heap.removeMin());
    
   Collections.reverse(list);
    for(Node n : list){
        symb.insert(n.sequence,n.frequence);
    }
    symb.inorrder();
    
           
    }


  

    
}
