/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package variablelengthencoding;

/**
 *
 * @author ekozi
 */
public class Symbol <E> {
   private E e;
   Symbol left;
   Symbol right;
   Symbol root;
    Symbol(E e){
        this.e=e;
       
    }
    public E getProperties(){
        return e;
    }
   
}
