/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryavl;

/**
 *
 * @author AGARCIARI
 * @param <T>
 */
public class LinkedBinary <T extends Comparable <T>> implements BinaryTreeInterfaceADT <T>{
  int cont;
  public BinaryTreeNode <T> root;
  public LinkedBinary (){
  cont = 0;
  root = null;
  }
  @Override
  public int size(){
    return cont;
  }
  @Override
  public boolean contains(T element){
    BinaryTreeNode <T> temp;
    temp = busca(root, element);
    return temp != null;
  }
  private BinaryTreeNode <T> busca(BinaryTreeNode <T> node, T element){
    if(node == null)
      return null;
    if(node.equals(element))
      return node;
    BinaryTreeNode <T> temp;
    temp = busca(node.getIzq(), element);
    if(temp == null)
      temp = busca(node.getDer(), element);;
      return temp;
    
  }
  
  public int alturaArbol(){
       return alturaArbol(root);
   
  }
  private int alturaArbol(BinaryTreeNode <T> node){
      if(node == null)
          return 0;
      else
          return Math.max(alturaArbol(node.der), alturaArbol(node.izq))+1;   
  } 

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
