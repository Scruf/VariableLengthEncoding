/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package variablelengthencoding;

import java.util.Iterator;

/**
 *
 * @author ekozi
 */
public class Node implements Comparable<Node>{
    public char sequence;
    public int frequence;
    private final int rangeStart=0;
    private final int rangeEnd=0;
    Node(char seq,int freq){
        this.sequence = seq;
        this.frequence = freq;
    }
  
    public int compareTo() {
        return 1;
    }
   public char getSequence(){
       return this.sequence;
   }
   public int getFrequence(){
       return this.frequence;
   }

    @Override
    public int compareTo(Node t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
   
    
    
}
