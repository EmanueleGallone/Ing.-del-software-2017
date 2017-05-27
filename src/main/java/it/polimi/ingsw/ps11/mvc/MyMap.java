package it.polimi.ingsw.ps11.mvc;

import java.util.HashMap;

import javax.naming.NameNotFoundException;

public class MyMap {
	
	private HashMap<String, Container> map = new HashMap<>();

	
	public void addModelElement(String key, Object ob){
		Container container = map.get(key);
		if (container != null){
			container.setModelElement(ob);
			return;
		}
		container = new Container();
		container.setModelElement(ob);
		map.put(key, container);
	}
	
	public void addViewElement(String key, Object ob){
		Container container = map.get(key);
		if (container != null){
			container.setViewElement(ob);
			return;
		}
		container = new Container();
		container.setModelElement(ob);
		map.put(key, container);
	}
	
	public <T extends Object> T getModelComponent(String key,Class<T> type) throws NameNotFoundException, ClassNotFoundException {
		Container container = map.get(key);
		if (container == null)
			throw new NameNotFoundException();
		Object object = container.getModelElement();
		if (object.getClass() == type)
			return (T)object;
		throw new ClassNotFoundException();
	}
	
	public <T extends Object> T getViewComponent(String key,Class<T> type) throws NameNotFoundException, ClassNotFoundException {
		Container container = map.get(key);
		if (container == null)
			throw new NameNotFoundException();
		Object object = container.getViewElement();
		if (object.getClass() == type)
			return (T)object;
		throw new ClassNotFoundException();
	}

	class Container{
		private Object viewElement;
		private Object modelElement;
		
		public Object getModelElement() {
			return modelElement;
		}
		public Object getViewElement() {
			return viewElement;
		}
		
		public void setViewElement(Object viewElement) {
			this.viewElement = viewElement;
		}
		public void setModelElement(Object modelElement) {
			this.modelElement = modelElement;
		}
	}
}
