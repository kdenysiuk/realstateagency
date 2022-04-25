package com.solvd.realstateagency.util;

public class Node<T> {
	
	//element in the first node
	T element;
	
	//element in the next node
    Node<T> next;

    //Constructor 
    Node(T element) {
        this.element = element;
    }

    //setter
    public void setElement(T element){
        this.element = element;
    }

    //getter
    public T getElement(){
        return element;
    }

}
