/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tdehashe;

/**
 *
 * @author izabe
 */
public class LinkedList {
     Registro list;

    public LinkedList() {
        this.list = null;
    }
    public void insert(int inserir){
     Registro no=new Registro(inserir);
    
     if(list==null){
     list= no;
    }
    else {
     Registro atual;
     atual=list;
     while(atual.next!=null) {
     atual=atual.next;
     } 
     
     atual.next=no;
     }}

    public void print(){
     Registro atual;
     atual=list;
     while(atual!=null) {
     System.out.println(atual.valor);
     atual=atual.next;
     }
    }

    public int busca(int valor){
        Registro busca=list;
        while(busca.next!=null){
            if(busca.valor==valor){
                return busca.valor;
            }
        busca = busca.next;
        }
        //fazer exceção
        return 404;

    }
}
