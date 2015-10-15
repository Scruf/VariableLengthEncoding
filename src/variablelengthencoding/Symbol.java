/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package variablelengthencoding;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author ekozi
 */
public class Symbol {

   private Node root;
   private String codeWord="";
   ArrayList<String> list = new ArrayList<String>();
    Symbol(){
        
        root=null;
    }
    public boolean isEmpty(){
        return this.root==null;
    }
    
    private Node insert (Node n,char s,int f){
        if(n==null){
            n = new Node(s,f);
            n.uniCode="";}
        else{
            if(n.getRight()==null){
                n.right= insert(n.right,s,f);
                n.right.uniCode="1";
            }
            else{
                n.left=insert(n.left,s,f);
               n.left.uniCode="0";
            }
        }
        return n;
    }
    private int countNode(Node N){
        if(N==null)
            return 0;
        else{
            int count = 1;
            count+=countNode(N.getLeft());
            count+=countNode(N.getRight());
            return count;
        }
    }
    public int countNode(){
        return countNode(root);
    }
    public void insert(char s,int f){
        root=insert(root,s,f);
    }
    private void inorder(Node n){
    
       if(n!=null)
       {
        
         
        
            inorder(n.getLeft());
            System.out.println(n.getSequence()+" "+n.getFrequence()+" "+n.getUnicode());
         /*  if(n.getSequence()!= ' ')
           {
               
               list.add(String.valueOf(n.getSequence()));
               
               list.add(codeWord);
               System.out.println("Exiting in sequence "+n.getSequence());
               codeWord="";
           }
           */
           inorder(n.getRight());
           
           
       }
      
        
        
    }
    
      /*
        if(n==null)
           return;
        if(n.getLeft()==null && n.getRight()==null)
           System.out.println(n.sequence);
        inorder(n.getLeft());
        inorder(n.getRight());
          */
        
    
    public void inorrder(){
        inorder(root);
         System.out.println(list);
    }
   
}
