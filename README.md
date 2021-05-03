# WebApp checkString IDM7

L’applicazione Check String riguarda la realizzazione di un ambiente per trovare parole simili, in pratica dato un testo di partenza l’applicazione è in grado di recuperare delle parole simili con l’intento di correggere eventualmente il testo errato o di normalizzarne le parole. 

Il progetto è stato sviluppato in due fasi. 

## Fase 1
Una prima fase ha riguardato la **progettazione e lo sviluppo di un progetto backend**. Inizialmente l’attività ha riguardato la ricerca e l'implementazione di singoli algoritmi di ricerca delle parole simili oggi già utilizzati in diverse applicazioni (motori di ricerca on line, problemi di data mining, ricerca di parole con pronuncia simile, ecc ). 

Successivamente gli algoritmi sono stati organizzati secondo la struttura del **pattern Chain Of Responsability** che rende trasparente l’uso della lista degli algoritmi utilizzati all’utente. 

Lista degli algoritmi utilizzati: 
- Levenstein: calcola lòa distanza di edit tra due stringhe (+1 per ogni sostituzione, cancellazione o inserimento)
- KMP: 
- Gestalt: 
- Soundex: riconosce le stringhe che hanno un suono simile (relativo a parole in inglese pero!) 

Una seconda parte del progetto ha riguardato l'ottimizzazione della tecnica cercando di migliorare le performance del metodo utilizzato, ad esempio evitando che si ripetessero ricerche di parole già effettuate in precedenza. 

Nella realizzazione del progetto sono stati utilizzati il pattern Strategy per il recupero di un dizionario delle parole standard o corrette da utilizzare per la normalizzazione o correzione.  Mentre per l’algoritmo tipico del Chain of Responsibility è stata applicato il pattern Template Method per delegare parti dell’implementazione dell’algoritmo alla classi figlie ma anche per rendere definitivo il metodo di ricerca delle stringhe aumentando la robustezza della soluzione adottata.

### Architettura dell'applicazione  

L’architettura della applicazione è basata sul **pattern architetturale MVC**, con una componente model a sua volta organizzata a strati: 
- livello **dati**, che comprende database e DBMS
- livello **DAO**, implementato secondo il pattern DAO, per le operazioni di dialogo con il database 
- livello **HBN**, framework per la gestione della persistenza
- livello **Manager**, racchiude le logiche funzionali della applicazione.

### Utilizzo dell'applicazione

Tale Componente può essere utilizzato in diversi contesti, se ne riportano di seguito alcuni come esempio. 
- Trasformazione dei dati in applicazioni ETL 
- Sistemi per il riconoscimento vocale
- Correttori di testo
- Software per il supporto alle persone disabili 
- Sistemi intelligenti che apprendono parole nuove in autonomia
- Fornire suggerimenti all’utente in fase di compilazione di moduli on line
- Fornire suggerimenti per l’utilizzo di sinonimi in fase di compilazione di un testo. 
- Traduttori di testo in lingue differenti
- Applicazioni in crittografia basate sulla sostituzioni di parole per cifrare i messaggi
- ...

## Fase 2
Nella fase 2 del progetto il componente CheckString è stato utilizzato in una **applicazione web** che consente una completa gestione delle normalizzazioni o correzioni effettuate dal componente. 

L’applicazione prevede un login utente con la possibilità per l’utente che effettua il login come amministratore di approvare le parole trovate dai vari algoritmi oppure di intervenire manualmente impostando il risultato. 

L’amministratore può inoltre visualizzare i dati delle ricerche effettuate, delle soluzioni trovate e può verificare quali sono gli algoritmi che hanno avuto più successo e quindi eventualmente potrebbe decidere di cambiare l’ordine di applicazione degli stessi. 

## Tecnologie utilizzate
### Back End 
* JDK Java 1.8+
* Spring 
* Hibernate 
* JPA
* Database Mysql e Oracle, SQL 

### Front End
* JDK Java 1.8+ 
* Spring MVC 
* J EE, JSP, JSTL, EL
* Javascript
* Ajax
* HTML
* CSS3
* Bootstrap 4.0
* Web Application Server: Tomcat v.9

## Configurazione del nostro progetto:
**CheckString**: 

![image](https://user-images.githubusercontent.com/61458042/116711979-ac5e8000-a9d3-11eb-9ca2-86008e694ded.png)

**Login**: 

![image](https://user-images.githubusercontent.com/61458042/116711908-98b31980-a9d3-11eb-88ab-6d0c6ed23449.png)

**WebApplication**: 

- ![image](https://user-images.githubusercontent.com/61458042/116712098-ca2be500-a9d3-11eb-8ca7-72eaf2bc8d5c.png)
- ![image](https://user-images.githubusercontent.com/61458042/116712207-e7f94a00-a9d3-11eb-9d32-f4ffbe7b7537.png)
