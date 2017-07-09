PS11 Lorenzo il Magnifico:
-Per giocare una partita in locale, nel Connection.java (situato nel package Controller.network),
assicuratevi che ci sia "localhost" nell'attributo String serverAddress;
verificate che anche all'interno di RMIConnection (situato nel package Controller.network.rmi) vi sia "//localhost/myServer"
all'interno dell'attributo static String DEFAULT_ADDRESS;

-Avviate Server.java situato nel package Controller.server;

-Per giocare una partita in rete, seguite gli stessi passi appena descritti, e sostituire al "localhost" l'ip della macchina dove avvierete il server.

-Per avviare il Client, avviate il ClientStarter.java (package Controller); scegliete quale tecnologia di collegamento e quale interfaccia usare.
-Una volta scelta l'interfaccia, vi verrà chiesto di inserire username e password. Se non siete registrati, verrete automaticamente registrati nel database.

Arrivati a questo punto, non dovreste avere problemi a giocare.

GRAPHIC USER INTERFACE:
Una volta iniziata la partita, per muovere un familiare, selezionare prima uno spazio azione e successivamente il familiare.
Successivamente vi verrà mostrato un pannello dove inserire il numero di servitori da usare. In caso voleste prendere una carta da una torre
e qualora quella carta avesse più ci un costo vi verrà mostrato un pannello dove c'è la possibilità di selezionare un costo da pagare.

è possibile selezionare la carta nella torre per vederla nel pannello di fianco la chat, in versione piu' grande.

Per vedere le carte di cui siete in possesso, basta che clicchiate sui colori nel pannello situato al di sotto della chat e al disopra del pannello
dove vengono mostrate le risorse.

cliccate nel pulsante di fianco alla vostra barra dove sono situate le vostre risorse per aprire il pannello contenente la zona produzione,
la zona raccolta, il mercato ed il palazzo del consiglio.

Quando avete terminato l'azione (cioè posizionato un familiare o attivato una carta leader) ricordatevi di passare il turno, Altrimenti il server
vi classificherà come utenti inattivi.

COMMAND LINE INTERFACE:
Una volta iniziata la partita, verrà stampata la board a schermo ed il vostro status. per stampare la board scrivete update e premete invio.
Per selezionare un piano di una torre scrivete ad esempio "yellow tower 1". Per selezionare uno spazio azione del market scrivete "market 1".
Quando selezionate un posto azione vi verrà mostrata la lista dei familiari disponibili al posizionamento. Successivamente verrà mostrato un messaggio
dove vi verrà chiesto di scegliere quanti servitori utilizzare. una volta premuto invio, verra' inviato al server la vostra azione.
Per passare il turno digitate "pass".