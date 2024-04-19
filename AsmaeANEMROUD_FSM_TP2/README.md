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

Après on a fait des tests dans l’application avec l’implémentation de l’interface CommandLineRunner ou bien avec la création d’une méthode qui retourne un objet de type CommendLineRunner en utilisant l’annotation @Bean.

C’est mieux d’utiliser la deuxième méthode car elle nous a permet de faire l’injection sans utiliser l’annotation @Autowired.
On redémarre l’application :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/78f215c0-274f-44e8-8165-47f21978274c)

Voyons maintenant la table Patient remplie avec des données en utilisant la base de données H2-console :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/d608846f-eaf7-4869-b75a-876d369dda59)

Après on injecte encore l’interface MedecinRepository, on démarre l’application :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/372a5abc-96db-46b5-ad72-f5b5bc55372c)

Voyons maintenant la table Medecin remplie avec des données en utilisant la base de données H2-console :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/b6f3df6f-1c13-456d-8feb-e00b870491d3)

On veut premièrement chercher un patient par son id, puis par son nom et on veut également chercher un medecin par son nom, pour cela on ajoute tout d’abord les fonctions dans les interfaces :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/9fa5097d-dcc7-42af-837d-ae7699759c20)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/bf2b8728-dd3a-4eb5-b74a-31e745d83464)

Après on créer un rendezVous avec un patient et un medecin qui existe déjà. 
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/9d01d28f-879d-43b6-9453-1eb73d90a036)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/c8c42027-7cb7-44d5-9df2-1ffc663c1070)

Dans la classe RendezVous, on utilise l’annotation @EnumType.STRING pour afficher les valeurs de type string et non pas de type ordinal.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/f52244e5-e727-4d1d-9032-b37576e9ad9c)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/9ba2a859-37b5-4e00-917f-6ae08095dd89)

Et voilà la consultation crée :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/bfd07247-bd99-47de-9cf7-dc84acba3ca0)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/2374b870-dd75-4054-910d-f05c7426cf91)

On a créé une interface IHospitalService dans le package service dans laquelle on ajoute quelque méthode dont on aurait besoin.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/fe4e7deb-76b4-4868-92b3-94c39936c47e)

On a créé ensuite une implémentation de l’interface précédente en utilisant l’annotation @Service (utilisée pour les objets de la couche métier) et l’annotation @Transactional pour que toutes les méthodes soit transactionnelles.
Pour injecter les dépendances on utilise le constructeur de tous les paramètres.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/56b19988-33fd-472d-adb9-796bcc20a7a6)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/be2a2022-9ea0-49aa-9c91-750ec3a7762e)

On utilise alors notre interface qui contient tous les méthodes au lieu de travailler avec tous les repositories.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/a15751a6-0015-4a6c-8f9b-50e6a7569ed1)

L’identifiant Id n’est pas nécessairement toujours de type Long, il peut être une chaine de caractère. En utilisant une méthode pour générer une chaine de caractère aléatoire unique.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/300ccf34-dc2e-4a81-81e0-65451b89cfec)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/8321642c-2ab3-44dd-82d9-633971845c9d)

On change findById en findAll :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/fc14bdb5-fcf9-4e0d-bbed-314d4ef6ba80)

On change le type Long en String :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/34fb4a69-7dc7-4c72-b038-45d55ee25c0f)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/f617f3a8-6025-4ca0-9f34-2481727a99f3)

On démarre l’application pour voir la nouvelle valeur de l’Id :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/3b95fc75-6b94-41b6-ae5e-84fdc10d4d04)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/cfc64f99-23ea-4244-a78d-0519689d5b44)

Dans un package web, on a créé la classe PatientRestService et pour créer un web service il suffit d’utiliser l’annotation @RestController et on fait l’injection des dépendances par l’annotation @Autowired.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/5f0382ae-6483-4a3e-9983-4a8599faa65d)

Après qu’on lance l’application, et on consulte la liste des patients sous format json on trouve un problème de dépendances cycliques car on a une relation bidirectionnelle.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/80d0abc1-2fd3-4154-a4ac-4cd9bd3039cf)

Donc pour le résoudre on utilise l’annotation @JsonProprety pour prendre en considération l’attribut lorsqu’on fait l’ajout mais non pas dans la lecture.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/9f1e010d-6c90-4ebe-81a8-ae841c423a55)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/d016d8d9-8ef3-4706-9597-59d99aa9a1d1)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/b88b60a6-941e-42fa-8654-7aa8e4098c4a)

Voilà le résultat après l’application de la solution :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/daf99092-52f0-4eab-9ec6-20c2cb146194)

# Partie 3:
Dans cette partie, on a fait la même chose pour les deux premières parties.

On utilise l’annotation @Column(unique= true, length=20) sur un colonne pour dire qu’il est unique et il ne peut pas dépasser 20 caractères comme on peut lui donner aussi un nom.

On utilise l’annotation @Service pour la couche service et l’annotation @Transactional pour gérer les transactions.

On utilise l’annotation @Repository pour indiquer que ce component de la couche dao.

On fait l’injection des dépendances avec les constructeurs.

Voici les classes du package entities :

-	Classe User :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/0150e65a-450c-4b2d-ad22-03935bd56318)

-	Classe Role :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/a9ee19bf-38e4-4a6b-b869-26e86cb4c2c4)

Voici les interfaces du package repositories :

-	UserRepository :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/7cff55a8-a98b-4a57-84e9-740d94cc71d7)

-	RoleRepository :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/9eefbcbe-ae30-4297-826b-e54e815fa58c)

Voici l’interface du package service :

-	UserService :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/f7cea66a-5605-42cc-bf73-748aa6866bcc)

Après on a créé une implémentation de cette interface :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/dbf2dba2-1aa8-4cdf-8ad8-2486846cd9ab)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/dbbdc2c7-a020-4c48-972f-4018fbdf0c51)

Puis on ajoute une fonctionne pour trouver un role avec leur nom et même chose pour user :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/d1275a99-8acb-4dff-ab27-67aaeede1722)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/dc5eaf69-b6e8-48b7-8406-e14c9212c882)

Après on a fait des tests dans l’application avec l’implémentation de l’interface CommandLineRunner ou bien créer une méthode qui retourne un objet de type CommendLineRunner et utilise l’annotation @Bean.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/ca357964-7702-4e43-b001-324e9de658f0)

Ensuite on ajoute des lignes à application.properties pour avoir connecté à la base de données h2-console :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/29592134-2221-45e0-b6d7-75366f01fe42)

Et on exécute l’application :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/4426ac3e-2f04-4e6a-b217-7671ac424551)

On se connecte à notre base de données « users_db »:
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/4d84ea8f-3d7f-4c62-b052-a6c1ad04014d)

Et voilà notre base de données :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/adb287dd-74eb-448c-8a3d-bbcf59f879a8)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/03006f25-8ae9-4d7c-8a39-7115c8e6e580)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/70cdba33-be97-4059-9b57-41cfc0c5cc2b)

On veut créer un modèle d’authentification. 

Donc la première des choses qu’on a fait et d’ajouter la fonction authenticate à notre interface UserService :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/58c48ee5-3064-4c69-8ce7-994f52291ebd)

On redéfinie cette méthode dans notre implémentation UserServiceImpl pour qu’on vérifie si le mot de passe est correct :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/0142c5fe-a442-4c20-ab72-64c9a0ec0592)

On a démarré l’application et on a trouvé une erreur :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/79fd4a86-672f-444e-992b-348bb7c471a6)

Pour les sauver on a utilisé l’annotation @ToString.Exclude sur l’attribut de la liste des utilisateurs dans la classe Role pour spécifier à lombok que ce n’est pas la peine d’inclure la méthode toString.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/0dba26f5-c49b-4896-a000-30dfffc8ee02)

Après on a essayé avec un mot de passe incorrect, et on a trouvé le message que nous avons écrit lors de la gestion des exceptions :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/d072ab6b-c0bf-481d-8284-5020f1d42781)

Eh, C’est le temps pour basculer à une base de données MySQL.

Comme d’habitude, on va ajouter les dépendances MySQL dans le fichier pom.xml premièrement et après on va modifier application.properties pour qu’il soit connecter à une base de données MySQL au lieu de h2-console :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/44221b9a-5f14-4702-987a-cff0d26bfbdb)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/3ef586e9-5a33-4df8-874b-804e03cd5024)

Lorsqu’on démarre l’application on trouve une erreur, c’est qu’il trouve le champ nommé desc et c’est un mot clé de MySQL :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/87ae7d4c-7e07-4e02-94fd-b68ba7467ac2)
