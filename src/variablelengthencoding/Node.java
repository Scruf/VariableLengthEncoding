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
public class Node<T extends Comparable<T>> implements Comparable<Node<T>>{
    public char sequence;
    public int frequence;
    Node(){
        sequence = ' ';
        frequence = 0;
    }
    @Override
    public int compareTo(Node<T> t) {
        return 1;
    }
    public void setFrequency(int number){
        this.frequence = number;
    }
    public void setSequence(char seq){
        this.sequence = seq;
    }

   
    
    
}
