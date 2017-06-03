package it.polimi.ingsw.ps11.cranio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Node<T> implements Iterable<T>{

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

// search _________________________________
	
	/***
	 * Ritorna l'insieme degli elementi che soddisfano il predicato (Ricerca in profondita' nell'albero)
	 */
	public ArrayList<T> searchAll(Predicate<? super T> predicate){
		return searchAll(predicate,false);
	}
	
	/***
	 * 
	 * Ritorna l'insieme degli elementi che soddisfano il predicato
	 * Se unique e' true se trova un elemento che soddisfa il predicato allora si ferma e non cerca oltre, altrimenti
	 * cerca in profondita' nell'albero
	 */
	public ArrayList<T> searchAll(Predicate<? super T> predicate, boolean unique){
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
	
// ForEach _________________________________
	
	/***
	 * 
	 * Scorre tutti gli elementi dell'albero sottostante e applica l'operazione passatagli
	 */
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

// Iterator _________________________________
	
	@Override
	public Iterator<T> iterator() {
		Iterator<T> iter = new Iterator<T>() {
			
			private int i = 0;
			
			@Override
			public boolean hasNext() {
				return (i < children.size());
			}

			@Override
			public T next() {
				i++;
				return children.get(i-1).getData();
			}
		};
		
		return iter;
	}
}

