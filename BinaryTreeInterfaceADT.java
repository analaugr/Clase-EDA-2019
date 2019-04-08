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
public interface BinaryTreeInterfaceADT <T>{
    public boolean isEmpty();
    public int size();
    public boolean contains(T element);
    @Override
    public String toString();
}
