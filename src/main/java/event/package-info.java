package event;
/**
 * 
 */
/**
 * @author Pierpaolo
 * 
 * L'event system funziona cosi: 
 * 
 * Per ogni tipologia di evento bisogna creare:
 * 		
 * 		- Interfaccia da attaccare all'oggetto che può invocare l'evento
 * 		- La classe dell'observer con il codice da eseguire quando l'evento verrà suscitato
 * 		- La classe dell'evento (se si ha bisogno di parametri, altrimenti c'è l'EventHandler di base)
 * 		

 * • INTERFACCIA:
 * 
 *  Questa interfaccia semplicemente definisce il metodo getter dell'evento in questione
 *  (esempio: L'interfaccia "Incrementable" definisce il metodo getIncrementEvent)
 *  
 *  Il metodo getter serve perchè l'eventuale observer chiamerà l'attach su quell'evento quindi ha
 *  bisogno di prenderlo.
 *  Il tipo da ritornare è un HeventHandler<TIPO_DELL'EVENTO> 
 *	(esempio: Nel caso dell'evento "Increment" ci sarà una classe "IncrementEvent" che avrà come 
 *	          parametro un integer)
 *
 * 
 * • CLASSE DELL'OBSERVER:
 * 
 *  Questa classe va ovviamente definita dato che bisogna specificare il codice da eseguire in caso si
 *  verifichi un certo evento. 
 *  La classe implementa l'interfaccia Observers<TIPO DELL'EVENTO> (Il tipo dell'evento è quello che 
 *  definiremo sotto)
 *  
 *
 * • CLASSE EVENTO (ovvero il TIPO DELL'EVENTO)
 * 
 *	C'è una classe di base che è "Event" che è un generico evento e tra i parametri ha solo il subject.
 *	Se però si ha bisogno di parametri particolari si deve estendere questa classe e creare un figlio di
 *  event che abbia gli attributi e i metodi desiderati. 
 *  
 *  
 */
