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
    public Node left;
    public Node right;
    public Node root;
    public String uniCode;
   
    Node(char seq,int freq){
        this.sequence = seq;
        this.frequence = freq;
        left =null;
        right =null;
        uniCode = null;
       
    }
    Node(Node N){
        this.sequence=' ';
        this.frequence=' ';
        left=null;
        right=null;
    };
  public Node getLeft(){
    
      return this.left;
  }
  public void destroyLeft()
  {
      left=null;
  }
   public void destroyRight()
  {
      right=null;
  }
  public Node getRight(){
     
      return this.right;
  }
  public void setLeft(Node N){
      this.left=N;
  }
  public void setRight(Node N){
      this.right=N;
  }
 
    public int compareTo() {
        return 1;
    }
   public char getSequence(){
       return this.sequence;
   }
   public void setSequence(char s){
       this.sequence=s;
   }
   public int getFrequence(){
       return this.frequence;
   }
   public String getUnicode(){
       return this.uniCode;
   }
    @Override
    public int compareTo(Node t) {
       if(this.frequence<t.frequence)
           return -1;
       if (this.frequence>t.frequence)
           return 1;
       if(this.frequence==t.frequence)
           return 0;
       return 0;
    }
   
  
    
    
}
