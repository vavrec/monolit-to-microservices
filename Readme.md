TODO - napsat v AJ

Cil 
- vytvorit monolitickou aplikaci, ktera umi par veci. Monolit bude mit design package by fetaure
- Nasledne zkusit z ruznych feature vytvorit microservices 


Featury projktu 
- Evidence uzivatelu - jmeno, prijmeni, uzivatelske jmeno (email)
- Site - skupiny, kde lze umistit uzivatele
- Ulozeni souboru + Metadat (nazev souboru, datum vytvoreni, autor)

Dalsi mozne featury 
- labels - vyhledani pomoci labelu
- pridani stitku


Na co si dat bacha
- zavislost packaage - co nejmensi, melo by jit o jednoduche rozdeleni

Feature user 
- musi byt user ID opravdu UUID? A kdy pouzit UUID? 
- pridat logovan
- pridat swagger
- pridat secuirty
- Restovky update vs patch -https://www.reddit.com/r/ExperiencedDevs/comments/pyleqb/recommendation_reading_booksblogs_for_best/
- Co bz mela vrace restovka pro update a co pro delete ? 
- pokud hledam by iD, tak mel bzch vracet 404? nerikam tim utocnikovy, ze to netrefil?
- implmentovat SpanID atd.
- Na tohle jsem narazil pri implementovani error handleru https://www.rfc-editor.org/rfc/rfc7807.html  https://dev.to/noelopez/spring-rest-exception-handling-problem-details-2hkj
- https://docs.spring.io/spring-boot/appendix/application-properties/index.html

Feature file folder 
- pohrat si s rekuryi v db - slozky



Zajmavosti do readme 
- error response je ve formatu 

http://localhost:8080/swagger-ui.html 