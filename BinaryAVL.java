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
public class BinaryAVL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    AVLTree arbol = new AVLTree();
    arbol.insert(54);
    arbol.insert(60);
    arbol.insert(72);
    arbol.insert(43);
    arbol.insert(18);
    arbol.insert(22);
    arbol.insert(9);
    arbol.insert(21);
    arbol.insert(6); 
    arbol.insert(8);
    arbol.insert(20);
    arbol.insert(63);
    arbol.insert(50);
    arbol.insert(62);
    arbol.insert(51);
    arbol.printTree();
    //arbol.remove(63);
    //arbol.remove(6);
    //arbol.remove(18);
    //arbol.printTree();
    
    }
    
}
