package com.solvd.realstateagency.util;

public class Node<T> {
	
	//element in the first node
	T element;
	
	//element in the next node
    Node next;

    //Constructor 
    Node(T element) {
        this.element = element;
    }

}
