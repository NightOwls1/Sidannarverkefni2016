##Hönnunarskýrsla :bowtie:

####Inngangur
	Þetta verkefni snýst um að forrita leikinn TicTacToe í forritunarmálinu java með aðferðafræðinni test driven development(TDD).
	Við byrjum á að búa til repository á GitHub fyrir hópinn til þess að geta haldið öllum gögnum á einum stað og unnið saman.
	Samkvæmt aðferðarfræðinni TDD gerum við unit test fyrir hvert fall.
	Kóðinn sem við erum að prófa hverju sinni þarf að vera sjálfstæður, óháður öðrum kóða. 
	Við notumst tól eins og Gradle, Travis og Heroku.


####Hönnun
	Leikurinn verður forritaður þannig að tveir geta spilað leikinn saman í tölvunni. 
	Ætlum við að reyna að forrita leikinn þannig að einn leikmaður spili á móti tölvunni. 
	Ef tími gefst til þá ætlum við að reyna að búa til selenium og end-to-end prófanir.

####Klasarit

![](img/ClassDiagram.jpg?raw=true)

####Forritunarreglur

1. Föll og nöfn á breytum eru skrifuð með camelCase syntax.
    - Þá er fyrsti stafurinn í fyrsta orðinu lítill svo er fyrsti stafurinn í meðfylgjandi orði stór.
	- dæmi: showBoard, makeMove.

2. Klasar eru skrifaðir með PascalCase syntax.
    - Fyrsti stafurinn í orðinu er stór og fyrsti stafur í meðfylgjandi orði er líka stór.
 	- dæmi: TicTacToe, Player.

3. Mikilvægt er að nöfn á klösum, föllum og breytum séu mjög lýsandi. 
    - Það er betra að skrifa löng lýsandi nöfn sem lýsir því hvað er að gerast.



