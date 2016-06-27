# mf-challange

http://www.modularfinance.se/api/challenges/buy-sell.json
"Write something in your favorite lang that figures out at what date and at what price to buy and sell the stock in order to get the highest return. Only one buy and one sell transaction is allowed"

Repot innehåller två lösningar, en skriven i Java och en i Python

Java
Lösningen i Java är mer generell och tänkt att kunna hitta optimal köp/säljkurs vid close för vilken tidsserie som helst med samma egenskaper som buy-sell.json.

Starta genom att gå in i java-katalogen och köra
```
mvn clean package
java -jar target/solution-1.0-SNAPSHOT-fat.jar
```
(har här även checkat in target/solution-1.0-SNAPSHOT-fat.jar för att kunna köra lösningen på en dator som inte har maven installerat)
Vid körning visas optimal köpkurs och datum, säljkurs och datum samt vinst per aktie baserat på close.

Python
Python-lösningen är mer naiv och skriven för det specifika exemplet.
Genom att plotta tidsserien så ser man tydligt att vi hittar den optimala köp och säljkurserna genom att hitta min/max-punkterna för tidsserien,
och Python-koden gör just detta. 

Starta genom att gå in i python-katalogen och köra
```
python mf-challange.py
```

Vid körning visas en figur med optimal köpkurs och datum, säljkurs och datum baserat baserat på close.
Denna information skrivs också ut i konsollen, samt vinst per aktie.
Om man istället för close tittar på köp vid lägsta low och sälj vid högsta high så får vi andra datum och lite bättre köp och säljkurs, 
även denna info skrivs ut för denna lösning.
