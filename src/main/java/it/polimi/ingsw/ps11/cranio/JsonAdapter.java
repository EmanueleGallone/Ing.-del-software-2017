package it.polimi.ingsw.ps11.cranio;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.resources.Resource;
import it.polimi.ingsw.ps11.cranio.zones.towers.Tower;
import it.polimi.ingsw.ps11.posNetwork.messages.Message;

public class JsonAdapter {

	
	private Gson gson;
	
	private static ArrayList<Class<?>> list = new ArrayList<>(Arrays.asList(
			Resource.class,
			Tower.class,
			DevelopmentCard.class,
			FamilyMember.class,
			Message.class
			));
	
	public JsonAdapter() {
		this(list);
	}
	
	
	public JsonAdapter(Class<?> Class) {
		
		gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(Class, new GsonAdapter()).create();
	}
	
	public JsonAdapter(ArrayList<Class<?>> Classes) {

		GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();
				
		for(Class<?> c : Classes){
			gsonBuilder.registerTypeAdapter(c, new GsonAdapter());
		}
		
		gson = gsonBuilder.create();
	}
	
	public String toJson(Object object) {
		return gson.toJson(object);
	}
	
	public <T extends Object> T fromJson(String json, Class<T> classOfT){
		return gson.fromJson(json, classOfT);
	}
	
	public <T extends Object> T fromJson(FileReader json, Class<T> classOfT){
		return gson.fromJson(json, classOfT);
	}
	
	protected class GsonAdapter implements JsonSerializer<Object>, JsonDeserializer<Object> {
		
	    private static final String CLASSNAME = "CLASSNAME";
	    private static final String INSTANCE  = "INSTANCE";

	    @Override
	    public JsonElement serialize(Object src, Type typeOfSrc,
	            JsonSerializationContext context) {

	        JsonObject retValue = new JsonObject();
	        String className = src.getClass().getName();
	        retValue.addProperty(CLASSNAME, className);
	        JsonElement elem = context.serialize(src); 
	        retValue.add(INSTANCE, elem);
	        return retValue;
	    }

	    @Override
	    public Object deserialize(JsonElement json, Type typeOfT,
	            JsonDeserializationContext context) throws JsonParseException  {
	        JsonObject jsonObject = json.getAsJsonObject();
	        JsonPrimitive prim = (JsonPrimitive) jsonObject.get(CLASSNAME);
	        String className = prim.getAsString();

	        Class<?> klass = null;
	        try {
	            klass = Class.forName(className);
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	            throw new JsonParseException(e.getMessage());
	        }
	        return context.deserialize(jsonObject.get(INSTANCE), klass);
	    }
  }
}
