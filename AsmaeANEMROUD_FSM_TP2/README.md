Asmae ANEMROUD                                                                                                                
Systèmes distribuées                                                                                                             
MIAAD                                                                                                                       
Promotion: 2023-2025

                                               Compte rendu JEE/TP2

# Partie 1:
La première étape c’est de créer le projet maven « students-app » et télécharger les dépendances dont on a besoin (spring JPA, H2 database, Spring web et lombok).

Après on a créé le package entities qui contient la classe Product pour gérer les produits.

Cette classe est définit par ces attributs et quand on travaille avec Lombok on utilise l'annotation @Data qui représentent les getters et les setters, Lombok permet de les ajoutés automatiquement.

Pour que la classe Product soit une entité JPA on utilise l'annotation @Entity qui doit avoir un identifiant, et on a utilisé aussi l'annotation @Id que nous pouvons générer automatiquement on utilisant l'annotation @GeneratedValue avec la stratégie IDENTITY.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/91bf8229-0a74-4125-aa83-d41f56351c23)

Après on ajoute au fichier application_properties le port de notre serveur, l’url et la base de données spring.h2.console.enabled pour activer une interface web pour consulter la base de données.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/f02f6f62-9ec9-4fff-826d-c95ee3d0cbb0)

Lorsqu’on démarre l’application springboot, c’est spring qui va démarrer le premier et qu’on il démarre, il va faire l’inversion de contrôle par la configuration du JPA, le scan des classes et la configuration des annotations.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/46c5a91e-071e-4a0d-855f-a333e73c49ab)

On se connecte maintenant à notre base de données :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/d68a79e0-b942-4afd-9d8a-7e8d85aff0d3)

Voilà à quoi se rassemble notre base de données :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/7b7acf58-0a28-4533-9836-b4b21f6e6258)

Pour exécuter le code une fois que spring est démarré la façon la plus simple c’est d’implémenter l’interface CommandLineRunner et on veut ajouter des produits à la base de données.

Pour utiliser spring data nous avons besoin de créer un package repository dans lequel on crée l’interface ProductRepository qui hérite de l’interface JpaRepository d’entité Product.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/a74b4d08-4f69-42cb-bc3a-7a258084266a)

On utilise l’interface ProductRepository pour pouvoir ajouter des produits dans la base de données et pour cela on déclare un objet de type ProductRepository et on fait l’injection des dépendances en utilisant la notation @Autowired, après on enregistre les produits puis les afficher dans la base de données.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/cc50e198-67d9-42c3-885c-9edfaae436d5)

Affichage dans la base de données :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/7c2351f0-0cfd-4963-9eb2-9bcd1ecd182f)

Si on veut afficher une liste des produits :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/65a86a9c-e7a5-4f27-9a2e-a8a256578153)

Et si on veut afficher le produit dont ID est 1 :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/54b0f3a8-7ac1-46d4-aa8d-5c57b234e36e)

H2 database est une base de données qui démarré en mémoire et une fois qu’on arrête l’application on perd les données c’est pour ça on va basculer vers une base de données mySql. Alors il nous faut charger la dépendance mySql Driver dans le fichier pom.xml.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/94419f3e-200f-47b7-b6f0-afe1ad6722df)

Il nous faut aussi faire un changement dans le fichier application.propreties, on met la base de données de type mySql au lieu de la base de données de type H2.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/61aeaffa-a43a-4c47-a4ec-efa53522e0d8)

C’est le temps pour lancer l’application en utilisant cette fois-ci MySQL :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/ea3ccd5f-671a-484a-a459-a00fa82ddf84)

![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/ca8fd0f6-4beb-4432-8864-d52b18bb35d8)

On réexécute une deuxième fois pour voir que update à chaque fois il insère les produits lors de l’exécution. 
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/f985b0a3-d762-42cd-b974-8d7324002f02)

Pour ajouter d’autres méthodes comme chercher un produit par exemple dont la désignation contient un mot clé, on a deux solutions :

-	Soit on ajoute dans l’interface une méthode qui retourne des produits qui contiennent la lettre C après qu’on le déclare dans ProductRepository.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/94f8ffd3-147b-460b-b921-11f3d9981f74)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/00590f0e-d2eb-4f2b-9557-852589c5fa80)

-	Soit on utilise une liste mais à condition d’ajouter l’annotation @Query et @Param pour indiquer que mc représente le paramètre x.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/88fd95e1-fdf3-4c76-bfbc-54d3f28d015d)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/2f5c9362-cd57-4867-b77c-1d24cbf124d2)

Maintenant on veut chercher les produits dont le prix est supérieur à 3000, on a aussi deux solutions :

-	En utilisant la méthode findByPriceGreaterThan() :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/1c9e9a80-436e-46e6-a759-0e4c22579490)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/5c990863-86df-44cc-9b28-6b107ac714d6)

-	En utilisant la fonction searchByPrice() :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/32c45189-374d-4964-8560-fce340ed1587)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/571164ee-ca08-42ce-bfbc-720db6960722)

Dans un package web, on crée un web service ProductRestService on utilisant l’annotation @RestController et lorsqu’on a besoin d’accéder à la base de données on déclare l’interface ProductRepository et on fait l’injection des dépendances par la notation @Autowired.

On crée une méthode qui permet de consulter la liste des produits, pour accéder à cette méthode on utilise l’annotation @GetMapping (on envoie une requête http get vers le path « /products ») et même chose pour une méthode qui permet de chercher un produit par son id mais au lieu d’utiliser findAll(), on utilise findById()  et l’annotation @PathVariable pour indiquer que l’id va prendre la valeur qui vient dans la paramétre qui se trouve dans le path.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/6c84fa24-bf43-466e-8df0-d76cc4af4575)

Le résultat apparaître en format json :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/43b18ac5-293b-49a5-952a-3ef357436d8a)

On veut maintenant afficher le produit dont l’ID est 1 :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/684cf30a-d1bc-4df4-8c07-d93a1c268f40)

Voilà le résultat en format json :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/2bd814d9-5d90-45e6-aaf3-75ae19df6d2a)

# Partie 2:
La première des choses qu’on a fait c’est de créer un projet maven « hospital ».

Puis, et dans un package entities, on a créé les classes Patient, Medecin, Consultation, RendezVous et une énumération StatusRDV.

Pour la date de naissance, on n’a pas besoin de garder l’heure, les minutes on utilise l’annotation @Temporal(TemporalType.DATE).

Pour la collection des rendezVous on utilise l’annotation @OneToMany.

On créer une entité JPA avec l’annotation @Entity qui doit avoir un identifiant et on utilise aussi l’annotation @Id et pour le générer automatiquement, et on utilise l’annotation @GeneratedValue avec la stratégie IDENTITY.

Voilà les classes et l’énumération :

-	classe Patient :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/7ee72233-684d-4038-9788-0ba44f8e89cd)

-	Classe Medecin :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/ced8bb02-0257-468c-a310-379c0c6546fc)

-	Classe Consultation :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/232ec703-c54f-4a53-8fdb-be02ed968d7e)

-	Classe RendezVous :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/0fc03be9-0d07-43f7-b2b1-e16d8cf5881d)

-	Enumération StatusRDV :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/bfe4cff1-3264-4910-b9a9-02068e2b5e4b)

Dans un package repositories, on a créé une interface pour chaque classe dans entities.
On démarre l’application pour voir la base de données:
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/ce1fe7ab-6129-4761-9228-7524c843ca59)

Voyons par exemple la table Patient en utilisant la base de données H2-console :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/d7ec81c2-3dab-4eb5-89df-7dc9e72aaa2e)

Après on a fait des tests dans l’application avec l’implémentation de l’interface CommandLineRunner ou bien avec la création d’une méthode qui retourne un objet de type CommendLineRunner en utilisant l’annotation Bean.

C’est mieux d’utiliser la deuxième méthode car elle nous a permet de faire l’injection sans utiliser l’annotation @Autowired.
On redémarre l’application :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/78f215c0-274f-44e8-8165-47f21978274c)

Voyons maintenant la table Patient remplie avec des données en utilisant la base de données H2-console :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/d608846f-eaf7-4869-b75a-876d369dda59)
