package it.polimi.ingsw.ps11.posTree;

import java.util.ArrayList;

public class Node<T> {

	private T data;
	private ArrayList<Node<T>> children = new ArrayList<>();
	private Node<T> parent;

// Constructors
	
	public Node() {
		
	}
	
	public Node(T data) {
		this.data = data;
	}

// Setters
	
	public void add(Node<T> child){
		child.setParent(this);
		this.children.add(child);
	}
	
	public void setData(T data) {
		this.data = data;
	}
	public void setParent(Node<T> parent) {
		this.parent = parent;
	}
	public void setChildren(ArrayList<Node<T>> children) {
		this.children = children;
	}
	
// Getters
	
	public T getData() {
		return data;
	}
	public Node<T> getParent() {
		return parent;
	}
	public ArrayList<Node<T>> getChildren() {
		return children;
	}

	/*
// Iterator
	
	@Override
	public Iterator<Node<T>> iterator() {
		return children.iterator();
	}
	*/
}
