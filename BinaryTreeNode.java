/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryavl;

/**
 *
 * @author AGARCIARI
 */
public class BinaryTreeNode <T extends Comparable<T>>{
  protected T element;
  protected int FE;
  protected BinaryTreeNode <T> izq, der, papa;
  BinaryTreeNode(T element1){
    element = element1;
    izq = null;
    der = null;
    papa= null;
    FE = 0;
    
  }

  public T getElement() {
    return element;
  }

    public int getFE() {
        return FE;
    }

    public void setFE(int FE) {
        this.FE = FE;
    }
  

  public BinaryTreeNode<T> getIzq() {
    return izq;
  }

  public BinaryTreeNode<T> getDer() {
    return der;
  }

    public BinaryTreeNode<T> getPapa() {
        return papa;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public void setIzq(BinaryTreeNode<T> izq) {
        this.izq = izq;
    }

    public void setDer(BinaryTreeNode<T> der) {
        this.der = der;
    }

    public void setPapa(BinaryTreeNode<T> papa) {
        this.papa = papa;
    }
    public void cuelga(BinaryTreeNode<T> node){
        if(node.getElement().compareTo(element)<0)
            setIzq(node);
        else
            setDer(node);
        node.setPapa(this);
    }
    
  
  
  public int numDescendientes(){
    int res = 0;
    if(izq != null)
      res = 1+ izq.numDescendientes();
    if(der != null)
      res += der.numDescendientes();
    return res; 
  }
}
