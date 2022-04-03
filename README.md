![el_cercle_logo](https://user-images.githubusercontent.com/60795194/161415084-3ac00f3b-f3e8-40ee-82be-21168bd967fe.png)

El Cercle - Aplicació web desenvolupada per a la Som Hackathon 2022, al TecnoCampus Mataró.

Organigrama: https://lucid.app/lucidchart/9500ee63-850a-4308-9161-323b7684c2de/edit?invitationId=inv_6df9a8cc-d144-4aa2-996f-4018f4c4267b

![image](https://user-images.githubusercontent.com/60795194/161408150-9725eef0-f743-4a44-bfa3-dafd57ad1705.png)

# Demostració d'execució:


Es mostra el nucli de l'aplicació en funcionament, mantenint alhora un disseny gràfic que procura ser atractiu i complir la funció de cridar l'atenció del públic. Aquesta és l'estratègia per fomentar les pràctiques sostenibles.

![image](https://user-images.githubusercontent.com/60795194/161415134-47a868b3-85fb-49f4-ab76-8d772cb16495.png)


S'ha implementat un portal on un restaurant (o d'altres tipus de consumidors de recursos naturals) pot consultar el material orgànic que ha arribat a reciclar. De la mateixa manera, es pot consultar la quantitat de fruites i verdures que s'han pogut generar gràcies a aquests béns, anteriorment només residuals però que s'han convertit en un recurs valuós.

![image](https://user-images.githubusercontent.com/60795194/161415159-2442dae6-55ca-496e-83e0-0cdeb68882ae.png)
![image](https://user-images.githubusercontent.com/60795194/161415193-3ca6b8d2-ac98-4445-ace4-dbaec3557839.png)
![image](https://user-images.githubusercontent.com/60795194/161415201-8a93dc4a-d848-4a0b-b5e2-32c2acf3a039.png)


A més, però, s'ha implementar crides API REST per a consultar i actualitzar la base de dades. Es podria acabar desenvolupant per a formar un projecte d'Open Data.

Crides d'exemple:
POST (o GET sense el paràmetre)

localhost:8080/organic/10

localhost:8080/strawberries/20

localhost:8080/potatoes/3.4

localhost:8080/oranges/6

localhost:8080/lettuces/2


![image](https://user-images.githubusercontent.com/60795194/161415221-473f6348-1bfd-4187-a698-46fe13c6057b.png)
![image](https://user-images.githubusercontent.com/60795194/161415243-db08b67a-4f9d-4826-85ec-5df1431a6379.png)


Finalment, s'ha volgut consolidar una plataforma de Back Office per a facilitar els tràmits que durà la nostra empresa en gestionar els materials donats i generats pels restaurants (o d'altres consumidors). És compatible amb les crides API REST via navegador o eines com Postman. En realitzar els canvis i recarregar la pàgina, les modificacions són visibles tant al "Back Office" con a la plana principal per a l'usuari restaurant.

![image](https://user-images.githubusercontent.com/60795194/161415328-3c49f029-44ee-4339-b936-01fc16a24fe6.png)


Per a entrar a la vista d'aquest restaurant d'exemple, es pot accedir a:
http://localhost:8080/

Per a entrar a la vista del "Back Office" per a tractar la informació d'aquest restaurant, es pot accedir a:
http://localhost:8080/back_office.html



# Estructura del programa:

S'ha organitzat una base per a l'aplicació, construïda en Java seguint el framework d'Spring, tot seguint l'arquitectura del software de Capes, i fent ús d'elements com DAOs, DTOs, o base de dades H2.

![image](https://user-images.githubusercontent.com/60795194/161414381-e01df626-fb13-47bd-94ee-8d6dc87eb96e.png)
![image](https://user-images.githubusercontent.com/60795194/161414425-5f2c046c-562f-42c6-9f2a-e995be52a88f.png)


# Dissseny d'aplicació:

![el_cercle_main_restaurant](https://user-images.githubusercontent.com/60795194/161408180-26a59fff-6881-4646-9ee2-b1c4e3ede688.png)

![el_cercle_organic_restaurant](https://user-images.githubusercontent.com/60795194/161408193-e0ef45da-a218-42dd-8b7b-fa2ab3499f3d.png)

[el_cercle_buy_restaurant](https://user-images.githubusercontent.com/60795194/161408167-9038dce4-4b0c-42ca-b5de-bb22286c0519.png)

![el_cercle_main_farmer](https://user-images.githubusercontent.com/60795194/161408177-516bd2c0-3598-4d8d-95f3-b329088e4a69.png)

![el_cercle_orders_farmer](https://user-images.githubusercontent.com/60795194/161408186-ae51c0f9-5835-45a1-8c3f-f9a1eabbaad4.png)

![el_cercle_main_citizen](https://user-images.githubusercontent.com/60795194/161408171-96a3ab92-fd33-44ad-a12e-77429a088bf0.png)

![7_RESTAURANT_el_cercle_main_restaurant](https://user-images.githubusercontent.com/60795194/161408200-eed655f3-fbd9-4260-8372-572670298f1e.png)

![idees_futures](https://user-images.githubusercontent.com/60795194/161414342-e24cfdb1-dcbd-41d8-a8d2-51a6a8c72574.png)
