
-Per giocare una partita in locale, nel Connection.java (situato nel package Controller.network),
assicuratevi che ci sia "localhost" nell'attributo String serverAddress;
verificate che anche all'interno di RMIConnection (situato nel package Controller.network.rmi) vi sia "//localhost/myServer"
all'interno dell'attributo static String DEFAULT_ADDRESS;

-Avviate Server.java situato nel package Controller.server;

-Per giocare una partita in rete, seguite gli stessi passi appena descritti, e sostituire al "localhost" l'ip della macchina dove avvierete il server.

-Per avviare il Client, avviate il ClientStarter.java (package Controller); scegliete quale tecnologia di collegamento e quale interfaccia usare.

Arrivati a questo punto, non dovreste avere problemi a giocare.

GRAPHIC VIEW:
Nel caso giocaste con la graphic view, appare un pannello di login dove dovrete inserire uno username ed una password. Se non siete nel database