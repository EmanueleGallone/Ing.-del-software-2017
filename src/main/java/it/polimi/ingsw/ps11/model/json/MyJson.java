package it.polimi.ingsw.ps11.model.json;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Wood;

public class MyJson {
	
	public static void main(String[] args) {
		MyJson json = new MyJson();
		String string = json.toJson(new ResourceList(new Wood(5)));
		System.out.println(string);
		/*
		Wood wood = new Wood(5);
		StringBuilder builder = new StringBuilder();
		Wood wood2 = new Wood();
		Field[] fields = wood.getClass().getSuperclass().getDeclaredFields();
		
		for(Field field : fields){
			field.setAccessible(true);
			try {
				if(!Modifier.isFinal(field.getModifiers()))
					field.set(wood2, field.get(wood));
				System.out.println(wood2.getValue());
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
			//System.out.println(field.getName());
		}
		*/
	}

	public MyJson() {
	
	}
	
	
	class Element{
		private String name;
		private Object value;
		
		public Element(String name, Object value) {
			this.name = name;
			this.value = value;
		}
	}
	
	public String toJson(Object object){
		//HashMap<String, Object> jsonObject = serialize(object, new ArrayList<>());
		//System.out.println(jsonObject);
		return serialize(object,new ArrayList<>());
	}

	private String mapToString(HashMap<String, Object> map){
		StringBuilder result = new StringBuilder();
		result.append("{");
		for (String name : map.keySet()) {
			//result.append(name + " : " + map.get(name). );
		}
		return result.toString() + "}";
	}
	
	public String serialize(Object object, ArrayList<Object> alreadyCheck){

		StringBuilder result = new StringBuilder();
		if (alreadyCheck.contains(object))
			return "";
		
		result.append("{");
		alreadyCheck.add(object);
		ArrayList<Field> fields = getField(object);
		
		for(Field field : fields){
			field.setAccessible(true);
			if (!Modifier.isTransient(field.getModifiers())){
				try {
					Object value = field.get(object);
					if(!isPrimitive(field)){
						value = (new MyJson().serialize(value, alreadyCheck));	
					}
					result.append(field.getName() + " : " + value + " ,\n ");
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}	
			}
			
		}
		return result.toString();
	}
	
	
	
	
	private boolean isPrimitive(Field field){
		ArrayList<String> primitive = new ArrayList<>(Arrays.asList(
				"int",
				"java.lang.Character",
				"java.lang.String",
				"java.lang.Boolean",
				"java.lang.Byte",
				"java.lang.Integer",
				"java.lang.Long",
				"java.lang.Short",
				"java.lang.Float",
				"java.lang.Double",
				"java.lang.Void"
				));
        return primitive.contains(field.getType().getName());
	}

	private ArrayList<Field> getField(Object object){

		if(object == null)
			return new ArrayList<>();
		ArrayList<Field> fields = new ArrayList<>();
		Class<?> klass = object.getClass();
		while (object != null && klass != Object.class) {
			fields.addAll(new ArrayList<>(Arrays.asList(klass.getDeclaredFields())));
			klass = klass.getSuperclass();
		}
		return fields;
	}
	
}
