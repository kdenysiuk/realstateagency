package com.solvd.realstateagency.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CustomLinkedlist<T> {
	Node<T> head;
	private static final Logger LOGGER = LogManager.getLogger(CustomLinkedlist.class);
	
	//add elements
	public void addElement(T element) {
		Node<T> newNode = new Node<T>(element);
		if(head == null) {
			head = newNode;
		} else {
			Node<T> currentNode = head;
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode = newNode;
		}
	}
	
	//add an element at start
	public void addElementAtStart(T element) {
		Node<T> newNode = new Node<T>(element);
		newNode.next = newNode;
		head = newNode;
	}
	
	//add an element at certain index
	public void addElementAt(int index, T element) {
		if (index == 0) {
			addElementAtStart(element);
		} else {
			Node<T> newNode = new Node<T>(element);
			Node<T> currentNode = head;
			for (int i = 0; i < index - 1; i++) {
				currentNode = currentNode.next;
			}
			newNode.next = currentNode.next;
			currentNode.next = newNode;
		}
	}
	
	//remove an element at certain index
	public void removeElementAt(int index) {
		if (index == 0) {
			head = head.next;
		} else {
			Node<T> currentNode = head;
			for (int i = 0; i < index - 1; i++) {
				currentNode = currentNode.next;
			}
			currentNode.next = currentNode.next.next;
		}
	}
	
	//show the list
	public void show() {
		Node<T> currentNode = head;
		if (currentNode == null) {
			LOGGER.info("The list is empty.");
		} else {
			while (currentNode != null) {
				LOGGER.info(currentNode.element + "/n");
				currentNode = currentNode.next;
			}
		}
	}
	
	//get an element of a certain index
	public Node<T> getElementAt(int index) {
		if (index == 0) {
			return head;
		} else {
			Node<T> currentNode = head;
			for (int i = 0; i < index - 1; i++) {
				currentNode = currentNode.next;
			}
			return currentNode;
		}
	}

}
