**1.Créer le micro-service customer-service qui permet de gérer les client**

![img.png](images/img.png)

**2.Créer le micro-service inventory-service qui permet de gérer les produits**

![img_1.png](images/img_1.png)

**3.Créer la Gateway Spring cloud Gateway**

**4.Configuration statique du système de routage**

->Via le fichier yml 

![img_2.png](images/img_2.png)

->Par création de la classe de configuration

Résulat: 

Pour inventory-service:
![img_3.png](images/img_3.png)

Pour customer-service
![img_4.png](images/img_4.png)

Pour faire une configuration dynamique il faut créer le discovery service

**5.Créer l'annuaire Eureka Discrovery Service**

L'interface Eureka : 
Pour le moment y a aucun microservice parce qu'on ne les pas activer
![img_5.png](images/img_5.png)

Apres activation des microservices avec : spring.cloud.discovery.enabled=true
Remarquez les microservices enregistrees 
![img_6.png](images/img_6.png)
**6.Faire une configuration dynamique des routes de la gateway**

a chaque fois que j'envoie la requete je dois preciser le nom du microservice dans l'url
![img_7.png](images/img_7.png)

![img_8.png](images/img_8.png)

**7.Créer le service de facturation Billing-Service en utilisant Open Feign**

![img.png](images/img_9.png)
-> openfeign : framework qui permet de creer un client rest de maniere declarative

![img_1.png](images/img_10.png)

