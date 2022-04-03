# El Cercle

Aplicació web desenvolupada per a la Som Hackathon 2022.

Organigrama: https://lucid.app/lucidchart/9500ee63-850a-4308-9161-323b7684c2de/edit?invitationId=inv_6df9a8cc-d144-4aa2-996f-4018f4c4267b

![image](https://user-images.githubusercontent.com/60795194/161408150-9725eef0-f743-4a44-bfa3-dafd57ad1705.png)

# Demostració d'execució:

Es mostra el nucli de l'aplicació en funcionament, mantenint alhora un disseny gràfic que procura ser atractiu i complir la funció de cridar l'atenció del públic. Aquesta és l'estratègia per fomentar les pràctiques sostenibles.

S'ha implementat un portal on un restaurant (o d'altres tipus de consumidors de recursos naturals) pot consultar el material orgànic que ha arribat a reciclar. De la mateixa manera, es pot consultar la quantitat de fruites i verdures que s'han pogut generar gràcies a aquests béns, anteriorment només residuals però que s'han convertit en un recurs valuós.



A més, però, s'ha implementar crides API REST per a consultar i actualitzar la base de dades. Es podria acabar desenvolupant per a formar un projecte d'Open Data.

Crides d'exemple:
POST (o GET sense el paràmetre)

localhost:8080/organic/10

localhost:8080/strawberries/20

localhost:8080/potatoes/3.4

localhost:8080/oranges/6

localhost:8080/lettuces/2


Finalment, s'ha volgut consolidar una plataforma de Back Office per a facilitar els tràmits que durà la nostra empresa en gestionar els materials donats i generats pels restaurants (o d'altres consumidors). És compatible amb les crides API REST via navegador o eines com Postman.

# Estructura del programa:

S'ha organitzat una base per a l'aplicació, seguint l'arquitectura del software de Capes, i fent ús d'elements com DAOs, DTOs, o base de dades H2

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
