package it.polimi.ingsw.ps11.posTree;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

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

	public ArrayList<T> searchAll(Predicate<T> predicate){
		return searchAll(predicate,false);
	}
	
	public ArrayList<T> searchAll(Predicate<T> predicate, boolean unique){
		return searchAll(predicate,new ArrayList<>(),unique);
	}
	
	private ArrayList<T> searchAll(Predicate<? super T> predicate, ArrayList<Node<T>> alreadyChecked,boolean unique){
		ArrayList<T> metch = new ArrayList<>();
		if (!alreadyChecked.contains(this)){
			alreadyChecked.add(this);
			for(Node<T> component : this.getChildren()){
				if (predicate.test(component.getData())){
					metch.add(component.getData());
					if (unique)
						return metch;
				}
				metch.addAll(component.searchAll(predicate,alreadyChecked,unique));
			 }
		 }
		return metch;
	}
	
	public void forEach(Consumer<? super T> action){
		forEach(action,new ArrayList<>());
	}
	
	private void forEach(Consumer<? super T> action, ArrayList<Node<T>> alreadyChecked) {
		
		if (!alreadyChecked.contains(this)){
			alreadyChecked.add(this);
			for(Node<T> component : this.getChildren()){
				action.accept(component.getData());
				component.forEach(action,alreadyChecked);
			 }
		 }
	}
	/*
// Iterator
	
	@Override
	public Iterator<Node<T>> iterator() {
		return children.iterator();
	}
	*/
}
