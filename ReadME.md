# TSEO-2016-Projektni-Zadatak

### Fakultet tehnickih nauka - Novi Sad
### Naziv kursa:
	Tehnologije i sistemi eUprave 2016
### Profesori:
	Goran Savic - http://www.ftn.uns.ac.rs/1417837781/goran-savic
	Milan Gegedinac  - http://www.ftn.uns.ac.rs/2048313129/milan-segedinac
	
## Kratak Opis 

Aplikacija za administraciju nastavnog procesa u obrazovnoj instituciji. 

## Organizacija

Klijent - Server Web aplikacija

### Realizacija i tehnologije

Klijentski deo - Single Page Application # AngularJS ( static/... )  
Serverski deo - REST API # Java platforma # SpringBoot radni okvir
Baza podataka - MySQL
	
## Pokretanje Aplikacije

1. Preuzeti aplikaciju
2. Import-ovati u eclipse IDE
3. Desni-klik na projekat > Maven > Update Project
4. Podesiti bazu podataka i podatke za pristup istoj
	podaci za pristup >>> /src/main/resources/application.properties
	- kreirati bazu sa odgovarajucim nazivom
5. Pokretanje aplikacije
	- unutar paketa rs.ac.uns.ftn.tseo (/src/main/java/) 
	  nalazi se klasa TSEO_2016_App.java
	- desni-klik na klasu > Run As > Java Application
6. Inicijalizacija baze podataka
	- stopirati aplikaciju
	- unutar foldera database nalazi se inicijalni script za bazu podataka insert.sql
	- nakon prvog pokretanja aplikacije, aplikacija ce sama napraviti tabele u bazi
	- potrebno je kopirati skript i izvrsiti ga nad bazom (npr. pomocu MySQL Workbench-a) 
7. Ponovo pokrenuti aplikaciju
	- sada se mozemo prijaviti
	- prijava > administrator > username: pera password: pera 
	
### Saradnici na projektu
	Srdjan Gojkovic - kolega student