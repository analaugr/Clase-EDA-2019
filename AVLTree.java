/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryavl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author AGARCIARI
 * @param <T>
 */
public class AVLTree <T extends Comparable <T>> extends LinkedBinary<T>{
    
    public void insert(T element){
        BinaryTreeNode<T> nuevo;
        nuevo = new BinaryTreeNode(element);
        if(root == null){
            root = nuevo;
            cont = 1;
        }
        else{
            
            insert(nuevo, root); 
            cont ++;
            actualizaEquilibrio(root);
        }
        
 
    }
    private void insert(BinaryTreeNode<T> nuevo, BinaryTreeNode<T> actual){
        if(nuevo.getElement().compareTo(actual.getElement())<0){
            if(actual.getIzq() == null){
                actual.setIzq(nuevo);
                nuevo.setPapa(actual);
            }
            else
                insert(nuevo, actual.getIzq());
        }
        else{
            if(actual.getDer() == null){
                actual.setDer(nuevo);
                nuevo.setPapa(actual);
            }
            else
                insert(nuevo, actual.getDer());
        }
           
    }

    public void leftRightRot(BinaryTreeNode<T> actual){
        BinaryTreeNode<T> alfa, beta, gama, papa;
        
        alfa=actual;
        beta=alfa.getIzq();
        gama = beta.getDer();
        papa = alfa.getPapa();
        if(alfa == root)
            root = gama;
        else{
            if(papa.getDer().equals(alfa)){
                papa.setDer(gama);
            }
            else
                papa.setIzq(gama);
        }
        gama.setPapa(papa);
        gama.setIzq(beta);
        beta.setPapa(gama);
        beta.setDer(null);
        gama.setDer(alfa);
        alfa.setPapa(gama);
        alfa.setIzq(null);
      
       
        
    }
    public void rightLeftRot(BinaryTreeNode<T> actual){
        BinaryTreeNode<T> alfa, beta, gama, papa;
        alfa=actual;
        beta=alfa.getDer();
        gama = beta.getIzq();
        papa = alfa.getPapa();
        if(alfa == root)
            root = gama;
        else{
            if(papa.getDer().equals(alfa)){
                papa.setDer(gama);
            }
            else
                papa.setIzq(gama);
        }
        gama.setPapa(papa);
        gama.setDer(beta);
        beta.setPapa(gama);
        beta.setIzq(null);
        gama.setIzq(alfa);
        alfa.setPapa(gama);
        alfa.setDer(null);
    }
    public void leftRot(BinaryTreeNode<T> actual){
        BinaryTreeNode<T> alfa, beta, gama, papa, exHijoBeta;
        alfa = actual;
        papa = alfa.getPapa();
        beta = actual.getIzq();
        gama= beta.getIzq();
        exHijoBeta = beta.getDer();
        if(alfa == root)
            root = beta;
        else {
                if(papa.getDer().equals(actual))
                    papa.setDer(beta);
                else{
                    papa.setIzq(beta);
                }
        }
        beta.setPapa(papa);
        beta.setDer(alfa);
        alfa.setPapa(beta);
        alfa.setIzq(exHijoBeta);
        if(exHijoBeta != null)
            exHijoBeta.setPapa(alfa);
        beta.setIzq(gama);
        gama.setPapa(beta);
    }

    public void rightRot(BinaryTreeNode<T> actual){
        BinaryTreeNode<T> alfa, beta, gama, papa, exHijoBeta;
        alfa = actual;
        papa = alfa.getPapa();
        beta = actual.getDer();
        gama= beta.getDer();
        exHijoBeta = beta.getIzq();
        if(alfa == root)
            root = beta;
        else {
                if(papa.getDer().equals(alfa))
                    papa.setDer(beta);
                else
                    papa.setIzq(beta);
        }
        beta.setPapa(papa);
        beta.setIzq(alfa);
        alfa.setPapa(beta);
        alfa.setDer(exHijoBeta);
        if(exHijoBeta!= null)
            exHijoBeta.setPapa(alfa);
        beta.setDer(gama);
        gama.setPapa(beta);
    }
    public T remove(T ele) throws RuntimeException{
        BinaryTreeNode<T> N=busca(ele), actual;
        if(N==null)
            throw new RuntimeException(ele.toString());
        if(--cont==0)
            root=null;
        else{if(N.getIzq()==null && N.getDer()==null)
                if(N.getElement().compareTo(N.getPapa().getElement())<=0)
                    N.getPapa().setIzq(null);
                else
                    N.getPapa().setDer(null);
            else{
                if(N.getIzq()==null)
                    if(root==N)
                        root=N.getDer();
                    else{
                        BinaryTreeNode<T> papa=N.getPapa();
                        BinaryTreeNode<T> hijo=N.getDer();
                        papa.cuelga(hijo);
                    }
                 if(N.getDer()==null)
                    if(root==N)
                        root=N.getIzq();
                    else{
                        BinaryTreeNode<T> papa=N.getPapa();
                        BinaryTreeNode<T> hijo=N.getIzq();
                        papa.cuelga(hijo);
                    }
                 if(N.getDer()!=null&&N.getIzq()!=null){
                    actual=N.getDer();
                    BinaryTreeNode<T> papa=N.getDer();
                    while(actual.getIzq()!=null){
                        papa=actual;
                        actual=actual.getIzq();
                    }
                   N.setElement(actual.getElement());
                   if(papa!=actual){
                       papa.setIzq(actual.getDer());
                       actual.getDer().setPapa(papa);
                   }else{
                       actual.getPapa().setDer(actual.getDer());
                       actual.getDer().setPapa(N);
                   }
                }
            }
        }
        boolean termine=false;
        actual=N;
        while(actual!=null && !termine){
            if(ele.compareTo(actual.getElement())<=0)
                actual.setFE(actual.getFE()+1);
            else
                actual.setFE(actual.getFE()-1);
            if(Math.abs(actual.getFE())>1){
                actual=rotation(actual);
                termine=true;
            }
            else{if(Math.abs(actual.getFE())==1)
                    termine=true;
            actual=actual.getPapa();
                }
        }        
        return N.getElement();
     }
    public void printTree(){
    BinaryTreeNode <T> temp;
    ArrayList <T> lista = new ArrayList();
    Queue <BinaryTreeNode <T>> cola = new LinkedList<>();
    cola.add(root);
    while (!cola.isEmpty()){
      temp = cola.remove();
    lista.add(temp.getElement());
    if(temp.getIzq() != null)
       cola.add(temp.getIzq());
    if(temp.getDer() != null)
       cola.add(temp.getDer());
    }
    lista.forEach((elem) -> {
        System.out.println(elem);
        });
    
  }
    public  BinaryTreeNode<T> busca(T element) {
        
       
        return busca(element, root);
        
    }
    private <T extends Comparable <T>> BinaryTreeNode<T>  busca( T element,BinaryTreeNode <T> nodoActual) {
        if(nodoActual == null)
            return null;
        else{
            if(element.compareTo(nodoActual.element)<0)
               return  busca(element, nodoActual.izq);
 
            else{ 
                if(element.compareTo(nodoActual.element)>0)
                    return busca(element, nodoActual.der);
                else
                    return nodoActual;
                
            }
        }
    }
    private BinaryTreeNode<T> rotation(BinaryTreeNode<T> actual){
            System.out.println("Entró a rotación");
        if(actual.getFE()==-2 && actual.izq.FE==-1){//Left-Left
            System.out.println("Rot. Izquierda");
            leftRot(actual);
            }else{
            if(actual.getFE()==2 && actual.getDer().getFE()==1){//Right-Right
                System.out.println("Rot. Derecha");
                rightRot(actual);
            }else{
                if(actual.getFE()==-2 && actual.getIzq().getFE()==1){//Left-Right
                    System.out.println("Rot. Izq-Der");
                    leftRightRot(actual);
                }
                else{//Right-Left
                    System.out.println("Rot. Der-Izq");
                    rightLeftRot(actual);    
                }
            }
        }
        actualizaEquilibrio(root);
        return actual;
    }
    private void actualizaEquilibrio(BinaryTreeNode<T> actual){
        int eq;
        boolean bandera = false;
        BinaryTreeNode<T> elementOfRot=null;
        if(actual!=null){
            actualizaEquilibrio(actual.getIzq());
            actualizaEquilibrio(actual.getDer());
            eq=alturaArbol(actual.getIzq())-alturaArbol(actual.getDer());
            if(eq>0){
                eq=(-1)*Math.abs(eq);
            }
            else{
                eq=Math.abs(eq);
            }
            
            if(eq==-2 || eq==2){
                System.out.println("El nodo "+actual.getElement().toString()+" no está balanceado");
                bandera = true;
                elementOfRot = actual;
            }
            
            actual.setFE(eq);
            
            
        }
        
        if(bandera){
            
            rotation(elementOfRot);
            
        }
            
    }
    @Override
    public int alturaArbol(){
       return alturaArbol(root);
   
  }
    private int alturaArbol(BinaryTreeNode <T> node){
      if(node == null)
          return 0;
      else
          return Math.max(alturaArbol(node.der), alturaArbol(node.izq))+1;   
  } 
    
}
