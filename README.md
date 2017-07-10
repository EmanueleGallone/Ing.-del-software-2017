PS11 Lorenzo il Magnifico:
ISTRUZIONI PER GIOCARE:
-Per giocare una partita in locale, nel Connection.java (situato nel package Controller.network),
assicuratevi che ci sia "localhost" nell'attributo String serverAddress;
verificate che anche all'interno di RMIConnection (situato nel package Controller.network.rmi) vi sia "//localhost/myServer"
all'interno dell'attributo static String DEFAULT_ADDRESS;

-Avviate Server.java situato nel package Controller.server;

-Per giocare una partita in rete, seguite gli stessi passi appena descritti, e sostituire al "localhost" l'ip della macchina dove avvierete il server.

-Per avviare il Client, avviate il Client.java (package Controller.client); scegliete quale tecnologia di collegamento e quale interfaccia usare.
-Una volta scelta l'interfaccia, vi verra' chiesto di inserire username e password. Se non siete registrati, verrete automaticamente registrati nel database.

Arrivati a questo punto, non dovreste avere problemi a giocare.

GRAPHIC USER INTERFACE:
Una volta iniziata la partita, per muovere un familiare, selezionare prima uno spazio azione e successivamente il familiare.
Successivamente vi verra' mostrato un pannello dove inserire il numero di servitori da usare. In caso voleste prendere una carta da una torre
e qualora quella carta avesse piu' ci un costo vi verra' mostrato un pannello dove c'e' la possibilita' di selezionare un costo da pagare.

� possibile selezionare la carta nella torre per vederla nel pannello di fianco la chat, in versione piu' grande.

Per vedere le carte di cui siete in possesso, basta che clicchiate sui colori nel pannello situato al di sotto della chat e al disopra del pannello
dove vengono mostrate le risorse.

cliccate nel pulsante di fianco alla vostra barra dove sono situate le vostre risorse per aprire il pannello contenente la zona produzione,
la zona raccolta, il mercato ed il palazzo del consiglio.

Quando avete terminato l'azione (cioe' posizionato un familiare o attivato una carta leader) ricordatevi di passare il turno, Altrimenti il server
vi classificher� come utenti inattivi.

COMMAND LINE INTERFACE:
Una volta iniziata la partita, verr� stampata la board a schermo ed il vostro status. per stampare la board scrivete update e premete invio.
Per selezionare un piano di una torre scrivete ad esempio "yellow tower 1". Per selezionare uno spazio azione del market scrivete "market 1".
Quando selezionate un posto azione vi verr� mostrata la lista dei familiari disponibili al posizionamento. Successivamente verra' mostrato un messaggio
dove vi verra' chiesto di scegliere quanti servitori utilizzare. una volta premuto invio, verra' inviato al server la vostra azione.
Per passare il turno digitate "pass". Vi saranno comunque istruzioni stampate a schermo.



Requisiti sviluppati:
-Regole Complete
-Pattern MVC
-Networking con Socket ed RMI.
-Server instanziato singolarmente capace di gestire più partite contemporaneamente.
-Server supporta la comunicazione tra Client che utilizzano tecnologie di comunicazione diverse (Socket, RMI)
-Sviluppate CLI e GUI (GUI sviluppata utilizzando Swing).
-Il client puo' scegliere quale interfaccia e tecnologia di collegamento usare.
-Gioco completamente configurabile editando opportunamente i file.
-Timeout per inizio partita settabile da file.
-Timeout per azione settabile da file.
-Non tutte le carte Leader implementate.
-Non tutte le scomuniche implementate.