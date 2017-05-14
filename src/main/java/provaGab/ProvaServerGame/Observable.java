package provaGab.ProvaServerGame;


import java.util.ArrayList;
import java.util.List;

public class Observable<T> {
	
	private List<Observer<T>> observers = new ArrayList<Observer<T>>();	//vantaggio generic, codice pi� conciso
	
	public void register(Observer<T> observer){							//svantaggio una classe pu� essere osservabile / osservare solo per un tipo
		synchronized (observers) {
			observers.add(observer);			
		}		
	}
	
	public void deregister(Observer<T> observer){
		synchronized (observers) {
			observers.remove(observer);
		}
	}
	
	protected void notify(T message){
		synchronized (observers) {
			for(Observer<T> observer : observers){
				observer.notify(message);
			}
		}
	}

}
