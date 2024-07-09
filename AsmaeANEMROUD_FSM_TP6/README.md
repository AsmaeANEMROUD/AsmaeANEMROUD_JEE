Asmae ANEMROUD                                                                                                                
Systèmes distribuées                                                                                                              
MIAAD                                                                                                                       
Promotion: 2023-2025

                                                     Compte rendu JEE/TP6

# Première Partie : Développer un micro-service
## Micro Service avec Web Service RESTFUL : 

Dans cette partie on va créer un projet spring dans Spring Initializr et on ajoute les dépendances nécessaires puis générer le projet, puis on l’ouvre avec Intellij.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/5d00003b-be87-4b2c-9555-7f7298158f3c)

On crée un package entities qui contient la classe java BankAccount :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/78103354-5223-460e-a9cd-25c7ff7af51a)

Et on crée aussi un autre package enums qui contient la classe enumération AcountType :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/0119ef24-c258-4bc6-9cb7-744a93fb2df2)

Puis on crée une interface BankAccountRepository :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/cd7e1cc3-ba56-438d-ba95-fa9105300f81)

Après on passe pour créer un premièr test pour notre application, pour cela on va insérer quelques comptes dans la base de données donc on va créer un objet dans l’application CommandLineRunner :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/ad086765-4319-4bfb-ab2d-d63a319eff39)

Avant de faire le premier test, on va paramétrer la base de données avec spring.datasource, spring.h2 et server.port dans le fichier application.properties :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/6bb41a8d-b5ad-4f91-b3e6-4cd7df6cee7f)

Maintenant on va exécuter notre application :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/790d4863-5d2a-4a45-a282-16abb8154eee)

NB : Il faut noter qu’on a un moyen de créer ce qu’on appelle les applications natives an utilisant ce qu’on appelle GraalVM qui rend nos applications très rapides en termes de démarrage.

Si on veut changer le champ type en String au lieu d’ordinal qui est par défaut, il suffit d’utiliser l’annotation @Enumerated :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/ca552aaa-957f-40f9-bf29-2f09093b4261)

On exécute :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/3d8315b2-414b-4511-bd72-2cee448811b9)

Maintenant nous voudrions exposer les fonctionnalités de notre micro service pour le monde extérieur, pour cela on va commencer par la première technologie REST.

On va créer un package web dans lequel on va créer une classe AccountRestController dont on va utiliser directement @RestController, puis on aura besoin d’injecter la couche repositories pour accéder à la base de données et pour faire une meilleure injection on la fait via le constructeur.

Après on va consulter la liste des comptes par la méthode bankAccounts() et on va accéder à cette méthode par @GetMapping et on va créer aussi une méthode bankAccount() pour consulter un compte, dont on utilise l’annotation @PathVariable pour indiquer que c’est un paramétre qui va être récupéré à partir de path :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/737d38c5-6c25-4aa5-969d-45bdaef0cb8c)

On teste l’application pour voir ces les deux méthodes fonctionnent :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/42629f42-d688-424b-94ef-9e6eed2f6e55)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/f7b315d1-98c6-48c3-bb1e-5ff05ce7403d)

Alors pour ajouter un compte, on va ajouter un autre REST API, une méthode qui permet d’ajouter un compte.

Donc on va créer la méthode save() qui permet de retourner un objet et on utilise @PostMapping, et @RequestBody pour indiquer que les données de backend viennent quand il va les récupérer dans le corps de la requête et pour faire Update on utilise une requête avec put (@PutMapping) pour qu’il modifie que les attributs qui ont été envoyés dans la requête puis on crée la méthode delete avec l’annotation @DeleteMapping :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/5cef1155-9953-4b20-8389-bab77f32af55)

On passe pour tester les méthodes en utilisant l’outil postman :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/b5cebea8-7b02-4748-903b-eef1a5d5028c)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/6ac228fa-4131-4d34-a89a-e40cf00b6a1c)

Dans postman, exactement dans Body on va créer les données qu’on veut envoyer pour créer un compte :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/569b6e60-d3b5-48ba-b389-f4d3c4377a84)

Mais on voit qu’on a une erreur interne, parce qu’on a pas généré l’id auto, pour cela on va ajouter dans la méthode save() une condition lorsqu’il trouve l’id est de valeur nulle il lui génère une valeur aléatoire :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/66157d34-bba1-430d-9bd1-76c058ba496d)

On lance l’application, et on envoie la requête dans postman :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/0e104c1f-d0d7-44da-aa1e-70fb39a687ce)

Si on veut par exemple mettre à jour le currency d’un compte on choisit le PUT, et on envoie la requête :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/f77de56b-8272-4819-906d-43bd2f6655bb)

Après tout ce qu’on a fait le service peut se communiquer avec le monde extérieur via RestAPI, qu’on va documenter avec ce qu’on appelle la documentation Swagger.

Pour pouvoir utiliser cette documentation il nous faut ajouter la dépendance openapi :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/22b73458-4c07-4eab-9115-4d55cac31736)

Voilà le fichier json qui est la documentation de notre REST API :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/41d5e54e-3e57-426f-a176-8a7ae7a77eb0)

On fait un test dans Swagger pour la méthode bankAccounts (même chose pour les autres méthodes), car l’utilisateur n’a pas besoin de postman maintenant, c’est via Swagger il peut tester son web service.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/1c22a066-fb90-457b-85bc-da201673907d)

Si on veut ajouter un compte par exemple on fait par la méthode POST :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/47d1c8ed-b87d-479f-b0e5-88b28cff10d7)

On vérifie si le compte a été bien ajouté :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/6bdc1e8e-a6dc-4bb4-9298-2c4fdefe3043)

On peut tester par Swagger, ou bien on prend le lien de la documentation de notre REST API, et on l’utilise dans n’importe quel outil, particulièrement postman :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/50a538b2-82b7-47a1-9afd-0750f1d735f6)

Dans Spring on a ce qu’on appelle spring data rest, pour savoir l’utiliser il faut juste ajouter la dépendance dans pom.xml :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/f1586136-51b1-4f02-bf63-248df77943d4)

On passe pour ajouter à l’interface BankAccountRepository l’annotation @RepositoryRestResource pour demander à spring au démarrage de démarrer un web service REST Full qui permet de gérer l’entité de BankAccount :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/a0f0eb85-e6e0-4a22-b19f-6159dc9008e4)

Alors pour pouvoir tester on va revenir à notre AccountRestController, et on ajoute @RequetMapping(« /api ») :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/2c97f9e1-4d55-496d-a945-e9fe0c0ff973)

Puis on exécute, et pour accéder à ce web service il faut écrire /api/bankAccounts, si on écrit directement /bankAccounts il donne un format différent :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/be63a6fd-50c2-446e-94e4-ce8bb88fd29b)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/5f588570-123e-49de-9b0d-9fcc70aa5893)

Spring data rest, il fait par défaut la pagination, on voie si par exemple on veut afficher les deux comptes de la première page :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/4935c669-450a-4cf3-ad1c-0893e97c1716)

Supposons on va créer une méthode pour chercher les comptes avec un type dans notre repository, pour y accéder directement à partir de notre spring data rest :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/44bd2feb-af7b-4915-9f39-ca9b5ad779d7)

Maintenant on va accéder à la méthode :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/7f4e1105-27ee-478a-945d-59471ea3e5c5)

Spring data rest donne une possibilité d’utiliser ce qu’on appelle les projections, c’est-à-dire quand nous voulons consulter un compte on lui demande de nous donner par exemple les attributs ID, balance et le type, pour cela avec spring data rest on va créer une interface AccountProjection dans le package entities, dont on utilise l’annotation @projection avec quelle classe elle va s’appliquer, et on lui transmit un nom :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/0834a5fd-7051-404d-9bfb-538d932c79ae)

Donc on va afficher les attributs en utilisant la projection p1 :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/70842ea8-7842-47f5-afe3-846435edb68d)

Ce n’est pas bien d’appeler les méthodes par leur nom, pour cela on ajoute les annotations @RestRessource et @Param pour les alias de méthode et le paramètre respectivement :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/7224f9ab-7192-4872-8f7c-be05912bef95)

On teste :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/c200dcee-9f47-4efc-9a0f-84e26c171aea)

C’est le temps pour respecter les normes, pour cela on va créer la couche service et DTO.

Dans un package service, on crée l’interface AccountService :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/f8b768a6-953c-4040-9ebd-18d371d1599e)

Puis on va créer les classe BankAccountRequestDTO, et BankAccountResponseDTO qui contiennent les attributs envoyés et recevoir dans la réponse :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/87f58c67-91ee-4085-b6d0-2e3ded5cb4aa)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/9886c761-df40-44e0-b5d0-819c03bb98d5)

Puis on va créer une implémentation de l’interface et on ajoute les annotations @Service et @Transactionnal pour la couche service, ensuite on va créer un objet BankAccount et on enregistre ce compte :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/899b1ace-4c55-4473-8b01-b5d134ab0ec5)

Maintenant on va changer dans le contrôleur la méthode save :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/721f9a06-d1e9-4dff-8d6e-2f48cfe7f896)

On teste :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/45fdb7d4-6f63-4c2c-bd8e-080978799af9)

Le dernier point qu’on a c’est d’ajouter un package qui s’appelle mappers dans lequel on va créer la classe AccountMapper, pour respecter les normes :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/ac737831-c164-454f-a640-332769644ef4)

Puis il faut l’injecter dans le RestController :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/c940702d-04fc-4b26-b193-cb3f6c517aea)

On change également dans notre service :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/60c9db48-8122-4a9a-9826-e67389bf4288)

On teste :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/7ea028d9-21e6-4eca-b6d0-abe2a60ab7c3)

## Micro-SERVICE avec web service GRAPHQL : 

Un micro service peut avoir plusieurs connecteurs, il est fait pour communiquer avec le monde extérieur par la communication REST, Soap comme on peut également utiliser Graph QL ou bien GRPC.

Dans le même micro service, on va créer un contrôleur qui permet de communiquer avec le web service en utilisant cette fois Graph QL, pour cela on aura besoin de créer un schéma.

On crée un dossier graphql qui contient le fichier schema.graphqls, dans lequel on déclare les types comme le type Query dont on spécifie les requêtes à implémenter dans le service par exemple on veut un service qui permet de consulter la liste des comptes :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/98d193f5-ec34-4107-a336-d81e5d4546cc)

Puis on va implémenter le service, on crée la classe BankAccountGraphQLController et après on déclare BankAccountRepository pour accéder à la base de données puis injecter les données en utilisant @Autowired, ensuite on va créer une méthode qui permet de retourner la liste des comptes et on utilise l’annotation @QueryMapping pour dire automatiquement quand le client demande accountsList qui se situe dans schema.graphqls la méthode qui s’appelle accountsList s’exécute :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/3230861b-0a3e-4cda-b42b-ec6894fa502b)

Et pour que GraphQL puisse fonctionne nous aurons besoin d’ajouter une ligne dans le fichier application.properties :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/4d1ad618-15b5-4501-949e-5e313973da54)

On passe pour tester, on veut par exemple afficher seulement l’id des listes de comptes (on fait la même chose pour les autres attributs) :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/4ebdbf3f-3b15-4c6f-aef7-78ab9e93e480)

Supposons maintenant qu’on veut récupérer un compte on va créer une autre méthode bankAccountById() :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/96a8efa8-2912-4c1e-b44d-3d1e740f2d1f)

Pour pouvoir l’utiliser, il va falloir faire ce travail dans le schéma :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/78068240-912f-44c2-908e-4731fc900cd3)

On teste :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/a17485aa-89d4-4884-b9ef-eaddb8b60163)

Maintenant on passe pour voir comment on va récupérer le message d’exception, c’est par l’ajout d’un handler d’exception, alors on va créer un package exceptions, dans laquelle on va créer le handler d’exception :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/da3e8959-e6a5-4419-9a06-72574f3d58d4)

On teste :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/4e82696a-8d9a-4678-8c1b-fac791ce7196)

Supposons maintenant qu’on veut créer une méthode qui permet d’ajouter un compte dans le contrôleur, et pour la mapper on utilise @MutationMapping :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/8fd73bf6-ffb0-418c-ad35-bacf6c6e1c14)

Après on la déclare dans le schéma pour qu’on puisse l’utiliser :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/a8758532-9e69-4eb2-b9eb-d5aba60babca)

Donc maintenant on n’a pas besoin de récupérer un objet de type BankAccount, c’est mieux de récupérer BankAccountDTO, ce qui fait on utilise le type record qui est un objet dans lequel on spécifie les paramètres de constructeur dont on a besoin, comme on peut utiliser une classe :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/d45227bd-5726-48ab-b28e-8e8e60eeb153)

Puisqu’on a déjà créé une classe BankAccountResponseDTO, on va l’utiliser au lieu de la classe BankAccountDTO :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/da7d3106-924c-4ba3-b6a6-da0921c1fca4)

Si on veut envoyer une requête, on va le faire avec une méthode post dont le corps contient mutation :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/3434e77f-9168-4153-8cf0-c042ce688f8f)

On vérifie si le compte a été ajouté :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/e4fc9516-e47a-40e2-b3f5-53fcdbdeec10)

On peut aussi utiliser une requête paramétrée :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/b62b9464-9ca0-441b-81ae-ddd0f203f842)

On va ajouter une méthode updateAccount dans notre implémentation d’interface, puis on la redéfinie dans notre interface, et après on l’utilise pour créer la mutation update :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/d49caa55-b9e2-4929-bcfa-e3916c006383)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/b34cb9fe-e2a9-4a6a-81b4-58845f330fec)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/5e726e88-1293-43ce-ba93-bd6b14c9038a)

Et comme d’habitude on va déclarer la méthode dans le fichier schema.graphqls :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/b494e50d-e64e-4e16-8c15-e7470f1ba516)

On ajoute aussi la méthode deleteAccount de la même façon :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/05d80cf7-80c9-43ad-99a7-88b5d0b0b260)

On la déclare dans le fichier schema.graphqls avec un type de retour Boolean :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/4901cb83-dc0e-436b-8c08-929de73dcd8b)

Et on passe pour tester les méthodes updateAccont et deleteAccount respectivement :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/db4a5a75-af54-4357-b719-89f20a95d659)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/62233ed1-015f-44e5-86d8-9a3c451ddd1b)

Au lieu d’utiliser Boolean pour la méthode deleteAccount on utilise cette fois ci le type String :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/02604666-6501-425c-93f3-2dbf82c6b946)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/0cb76eef-8209-426c-afe8-57629e315896)

On teste :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/0ac0eb84-be18-4806-913b-fe912dc8f298)

Le dernier point c’est les relations, supposons qu’un compte appartient à un client donc on va créer une classe Customer dans le package entities :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/8aae1dd2-f9f6-4afb-8e32-137eeec22256)

On ajoute l’attribut Customer à la classe BankAccount avec la relation @ManyToOne :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/f31611c3-9a76-477e-a6d4-0b1c81e2d5ad)

On crée une interface pour cette classe :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/60222f3c-792b-49ca-bb6a-f7f7d0abce21)

Alors on passe pour créer 10 comptes pour chaque client :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/7beba4c5-c203-4b38-bd2d-15b2c5b39efe)

On jette un coup d’œil sur la table CUSTOMER :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/30473d59-e53b-4000-9009-23d2628ce3d1)

Et aux comptes :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/23fc5acf-9d25-48c5-884e-88a69715cfb9)

Pour notre API GraphQL, on ajoute le customer dans le schéma pour qu’on puisse le demander après :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/ec5e65dd-381f-4733-aeed-04cb2df30c63)

On teste :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/d3428cbd-efd0-46a8-bdc5-363c9fe4e4e9)

Maintenant, on va ajouter une méthode qui permet de consulter les customers :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/fa246477-e75c-46d0-a482-5b9e0bb142a0)

Puis on implémente cette méthode dans le schéma :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/025f4008-3aba-4a8a-a771-5f4a92f68e37)

On teste :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/e46c1ff1-d541-4d70-a7de-26d802417d91)

Maintenant si on demande api/bankAccounts, on plante notre application et on voie qu’une exception sera générée :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/2e37ec9c-17d1-489b-b9aa-782637d04e13)

Pour éviter ce problème, il faut passer vers les DTO, ou bien aller vers Customer et on utilise @JsonProperty :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/be75d23b-432c-4ae0-ace5-2a0f4b7c2fc7)

On faisons ça, il va marcher pour Rest et non pas graphql car il ne change rien :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/652a2a1b-cea3-41e5-b02c-0629875487e6)

# Deuxième partie : Développer une architecture micro-service
## 1. Créer le micro-service Discovery Service
Dans cette partie on va voir comment mettre en place un exemple d’architecture micro service.

Pour cela on va créer un nouveau projet bank-account-service et on ajoute des modules customer-service et account-service (on crée un projet de plusieurs modules dont chaque module représente un micro service) :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/267afb95-7b49-4309-92f5-41355b62231a)

Avec l’ajout des dépendances pour chaque module :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/12f6e2a8-3e21-4cd7-a88b-71e74cbd4704)

Puis on va créer le module gateway-service (Spring cloud gateway est une gateway qui est basée sur les entrées/sorties non bloquantes), après le discovery-service et config-service et à chacun ses propres dépendances, et voilà notre projet :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/ef74e193-052d-4907-bd08-002a1e7bcb8b)

On va commencer par customer-service et on va le tester indépendamment et après on va voir comment faire pour qu’il puisse s’enregistrer au niveau Discovery une fois qu’on va créer les autres micro services.

Dans customer-service, on va créer les packages qu’on a l’habitude de créer pour respecter les bons pratiques : web, entities, repository, service, dtos et mapper, et on crée l’entité Customer avec les annotations lombok :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/500eb41c-094c-4606-b3ee-1568c398f3d4)

On crée l’interface CustomerRepository et on peut aussi ajouter l’annotation @RepositoryRestResource de Spring data Rest qui permet de démarrer automatiquement un web service RestFull qui permet à son tour de gérer les customers mais on ne le fait pas dans notre cas.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/fbef9dc9-89a6-4726-8b0b-114191615f45)

Dans le package web on crée le contrôleur CustomerRestController, et on fait l’injection des dépendances via un constructeur avec paramètres et après on crée une méthode pour consulter la liste des customers et une méthode pour consulter un customer :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/e2b6e89d-fc8e-4e57-b0ae-376f1c5af325)

Pour tester notre application on va insérer quelques customers dans la base de données et n’oublions pas d’ajouter l’annotation @Bean qui veut dire que cette méthode va s’exécuter au démarrage spring par définition.

On a trois possibilités pour créer un customer la première c’est d’utiliser un constructeur sans paramètres, la deuxième c’est d’utiliser un constructeur avec paramètres et la troisième c’est d’utiliser Builder, on va travailler avec cette dernière :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/b3e46f16-da5c-42b4-aba7-c052dfed1cf6)

Lorsqu’on teste on trouve une exception générée car elle va chercher le discovery client et le config client qu’on n’a pas démarrer encore :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/5f2047e7-6ca0-4ac1-8549-6c54239a12f6)

Alors pour résoudre ce problème on va désactiver les services de configuration, et de discovery dans le fichier application.propreties et on fait la configuration qu’on a besoin :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/9eacd274-1d83-4ecd-ba02-ccd9c7d931e6)

On teste :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/6727b7ee-8c3c-481f-bee3-2e0ae6d0f839)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/eb38df8c-af14-43c1-b92f-34e41236dde7)

On consulte aussi la base de données H2 :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/f6089239-dd1a-4444-9b35-dba8ca8c810f)

Maintenant on passe au micro service account-service dont on va créer les packages qu’on a l’habitude de créer, et on va créer une entité BankAccount qui contient un attribut (une simple classe Customer) qui n’est pas une entité JPA, et on va utiliser l’annotation @Transient pour ignorer cet attribut car c’est un attribut qui existe dans la classe mais qui n’est pas représenter dans la base de données :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/d10c32b0-1ff4-4cc2-8865-3954107f05f2)

Voilà la classe enum AccountType :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/8328fce2-0a2a-47a2-ae6f-234f326b658d)

Et voilà la classe Customer qu’on a créé dans un package model, pour représenter notre attribut customer :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/d0d05401-5d75-4c84-9966-091c30fbfabd)

On va créer aussi une interface BankAccountRepository :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/49777a94-130a-48cc-a5c9-82f92d8f416a)

Après on crée le web service AccountRestContoller dans lequel on crée 2 méthodes la première pour consulter la liste des comptes et la deuxième pour consulter un compte par son id :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/f40b20ad-02f3-4f7d-9bce-a94153beabe0)

Alors on fait un test en créant des comptes de la même façon dont on fait tout à l’heure :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/4beb7786-7851-40d8-8790-3d9ba4ec0986)

Avant de démarrer ce micro service, on a besoin de le configurer :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/0d651725-96af-40e7-801c-e4d41195f2e6)

On teste :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/f6f2175c-e7a7-4058-b835-0f8498db56b5)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/da2fa9e8-4551-42e1-9790-3ee92a5453b0)

C’est le temps de générer la documentation Swagger pour les web services en ajoutant la dépendance openai-api :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/de8c7283-dfaf-4808-bd65-9c6d951cb9d0)

Et on teste les méthodes :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/d2279fe8-c758-481b-8d91-314b8d68cefa)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/b2ee8cbd-5bab-42f2-8e55-5045d74d5a2b)

Si on veut voir la documentation swagger il affiche l’interface du web service c’est ce document qui montre au client quelles sont les différentes méthodes qui existe dans le web services (dans les web services basées sur soap on utilise le WSDL mais pour d’autre qui ont basés sur Rest on utilise openapi doc) :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/3848eb6d-0a5e-4afb-ab97-43819cfde9ac)

Les méthodes BankAccounts qui existe dans swagger ça va marcher car la dépendance data-Rest n’est pas désactivé même si on n’a pas utilisé l’annotatioon @RepositoryRestRessource il génére un web service.

On va donc la désactiver on mettant leur dépendance en commentaire :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/802ee0e9-d601-4718-833c-b74400eec26b)

Si on redémarre maintenant on voie que les autres méthodes n’apparaitre pas :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/715c5b1e-d2a1-4cf8-8445-0319555462d3)

Allons pour faire la même chose au customer-service, on ajoute la dépendance openai-api :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/c20a3365-e273-43ee-886e-945138101c16)

Et on ajoute l’annotation @RequestMapping pour éviter la confusion :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/1ba62c21-5185-42a1-861a-72c4307753f4)

On teste la méthode POST et on voie que tout se passe bien :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/fa1102fe-78eb-48da-8b7f-1d6ba3e1d407)

On va répéter le même scénario, on désactive la dépendance data-rest pour customer-service car on n’a pas besoin et on lève l’annotation @RequestMapping :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/39db1d6b-3ea1-479e-bfcc-b46ada8dd8b5)

On teste :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/0c121fba-9733-4b57-a588-ecdb3a0e670a)

Maintenant, on va avoir comment mettre en place la gateway.

Pour le gateway, il y a deux solutions la première est l’ancienne c’est ZUUL qui est basée sur les entrées/sotries bloquantes et Spring Cloud Gateway qui est basé sur les entrées/sorties non bloquantes, alors on va voir comment configurer ce gateway et pour configurer les routes de gateway, on peut le faire d’une manière statique ou dynamique et pour cette configuration on utilise le fichier application.yml pour celles qui sont complexes et application.properties pour les configurations simples.

On va configurer les routes dans le fichier application.yml, et on spécifier aussi le nom de l’application et le port comme on peut aussi faire cette configuration dans le fichier application.properties mais c’est compliqué.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/c66783c4-8199-4568-aecc-2c449677c7f2)

On va pour démarrer ce gateway :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/dbfedf8e-5016-4128-bd28-7ac7f32a306e)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/d63afae0-1664-481f-aa60-64f55ce74e61)

Ce qu’on a fait c’est de la configuration statique ou on suppose qu’on connait les adresses des micros services, mais dans la pratique on le connait pas donc la solution c’est de faire la configuration dynamique (utiliser Discovery service).

On va activer le discovery service en utilisant l’annotation @EnableEurekaServer :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/49cc7cd0-eea5-4bfc-b0da-c5985b0d984b)

Et on le configure dans application.properties :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/3288ccdf-6c88-4eda-ac9d-92b00d1ea068)

On démarre et on voie une interface eureka avec les applications enregistrés après qu’on active la propriété discovery dans les services et on redémarre chaque service :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/af5ee466-047d-499f-b78a-8cfcef9fa44f)

Mais les services s’enregistrent avec le nom de l’ordinateur et nous avons besoin de l’enregistrer avec leurs adresses IPs et pour ce faire on ajoute 2 propriétés pour les 3 services :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/b399b922-a084-41fd-bc8d-6275867e9713)

On redémarre pour voir qu’ils sont enregistrés, et on consulte un service pour voir qu’on a l’adresse IP :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/210f6ea2-d4a1-40d6-92c2-9cb1c10aac81)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/eb1f9b6d-e09c-4375-b8f3-b5338f007bcc)

Maintenant notre gateway, on va le configurer pour qu’il puisse chercher les adresses dans discovery.

Donc on va faire une configuration dynamique :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/75d8c75c-9ae5-43a8-b408-eaca3e59a21a)

On démarre et il passe bien :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/de4bcb46-d309-474b-b17a-82cc09c8805f)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/a62dd8b4-0f88-456f-aae1-7f6c24d00070)

Si on veut activer les services de actuator, on doit utiliser une propriété :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/4864d4f3-653d-4109-b631-e5eb71de36bd)

Et on redémarre :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/e00e0cba-da67-41f6-9cda-f4650e364826)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/fc6d2e18-9cdf-4777-a455-e34d057812e4)

Si on consulte la liste des comptes, on voie l’id de customer mais on voie pas leurs autres informations, comme son nom, donc pour ce faire nous aurons besoin d’envoyer une requête vers customer-service du coté account-service.  

On va utiliser le framework open Feign qui va se charger de Rest c’est le plus simple et lui qui permettre de faire facilement les microservices alors pour utiliser Open Feign on a besoin d’ajouter une dépendance dans account-service :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/63a36d59-f11b-4fe1-a4c7-b984e020e3bd)

Pour utiliser Open Fiegn, on va créer un package clients qui contient une interface CustomerRestClient et on veut que cette interface soit Open Feign, alors on utilise l’annotation @FeignClient(name = CUSTOMER-SERVICE) :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/a8bf9087-c70f-4fd5-9bbf-bf260b97ec31)

Pour tester, on va déclarer CustomerRestClient dans AccountRestController :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/f2a51690-36eb-4730-ac8f-c784b2e0bb80)

Et il nous faut activer OpenFiegn avec l’annotation @EnableFeignClients pour qu’on puisse l’utiliser :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/4efe4deb-bd3e-4c31-8cd5-d897f2ae1345)

On démarre et on voie les informations de customer :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/7af9e8f1-0854-43cc-baf6-911f33620938)

Nous allons maintenant faire face à un problème qui s’appelle tolérance en panne, supposons on n’a le service customer est arrêté il va influencer tous les autres services et ça c’est mauvais, alors la solution c’est d’utiliser un design pattern qui s’appelle Circuit Breaker qui est un circuit ouvert fermé.

Alors pour qu’on puisse l’utiliser on va ajouter la dépendance resilience4j :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/cc6cf71c-5f11-479f-9f19-7d9d4da8c4fa)

Maintenant on va vers notre client Rest, et on créer un circuit breaker avec l’annotation @CircuitBreaker avec fallbackMethod qui veut dire à quelle méthode on va appeler si la méthode courante échoue :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/77aa977f-03ea-4c9e-b0c0-498594b9def8)

On arrête notre service et on va démarrer pour tester si notre service est tombe en panne qu’est ce qu’on va voir :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/ea287467-980c-47f5-bfe7-6bdb368d4246)

On va juste utiliser un Circuit Breaker à l’autre méthode allCustomers :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/1abfe10b-3b67-4640-89c0-24d10bdec008)

Si on veut maintenant consulter la liste des customers à partir de l’application AccountService, nous voulons dès le démarrage qu’il cherche les customers, et créer deux comptes pour chaque customer :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/7f1eb849-43cb-458d-b4db-5187420ce517)

On démarre les deux services Customer et Account :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/02ca86d5-2363-4c44-82f2-2c48a78ea87d)

Maintenant on veut associer Customer à AllCustomers :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/c7820c13-e912-4c7e-bf90-e37fd33a0840)

On démarre :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/24c03057-764b-4cc0-8a32-d867b625a700)

## 2. Créer le micro-service Config Service

Voilà alors on va essayer de continuer la mise en œuvre de l'architecture microservice que nous avons commencé la dernière fois, donc nous rappellons en fait que la dernière fois on avait l'occasion de parler de beaucoup de choses qui sont très intéressante.

D'abord nous avons vu comment créer un ensemble de microservices, donc on a commencé par la création de du microservice customer-service dans lequel on gère une base de données qui contient des clients, ensuite nous avons créé un microservice que nous avons appelé account-service dans lequel nous avons géré des comptes bancaires alors c'était deux microservices de base et après donc nous avons vu comment déployer une Gateway: spring cloud Gateway, comment configurer le système de routage de manière statique, notamment comment configurer les routes de manière statique, comment configurer le système de routage de manière dynamique en utilisant Discovery service donc nous avons déployé le service Eureka Discovery, Eureka Server qui est l'une des implémentations de Discovery service, notamment qui sont utilisé au niveau de springcloud c'est une implémentation de Netflix mais nous avons dit également qu'il y a d'autres implémentations qui peuvent être utilisées par les entreprises notamment ZUUL discovery donc on aura l'occasion d'en parler et donc nous avons vu comment accéder au microservice via la gateway donc ça c'est tout, ça ce qu'on a fait et puis nous avons vu surtout comment faire la communication Rest entre les microservices notamment en utilisant Open Feing, donc on rappelle que Open Feing c'est un framework qui permet de créer un client Rest de manière déclarative, donc c'est un framework déclaratif, donc on a vu qu'en fait que l'utilisation de Open Feing peut se faire de manière de manière très simple en créant tout simplement des interfaces, alors généralement quand on fait la communication entre les clients on va dire les applications, les microservices il y a une question qui se pose toujours c'est le problème de tolérance en panne parce qu'un microservice contact d'autres microservices donc c'est des communications réseau, c'est-à-dire parfois il y a des échecs c'est-à-dire un microservice qui envoie une requête vers un autre microservice, bon ça peut toujours générer des échecs de connexion, des échecs de contact de service, et dans ce cas-là qu'est-ce qu'il faut faire alors généralement c'est pour cela nous avons besoin d'utiliser une solution de tolérance en panne (Fault Tolerance) et donc nous avons vu une partie on va dire comment utiliser une solution de tolérance en panne resilience4j, alors en fait resilience4j donc c'est une solution de (Fault Tolerance) qui permet donc d'apporter beaucoup de solutions, parmis les solutions il y a le Circuit Breaker donc on rappelle que Circuit Breaker c'est un design pattern qui est très utilisé dans les systèmes distribuées d'une manière générale et qui fournit une solution notamment de tolérance en panne, et donc nous avons vu une partie sur comment l'intégrer c'est-à-dire par exemple quand on contacte bank-account pour consulter un compte, bank-account a besoin de contacter customer-service parce qu'on a besoin de récupérer les informations sur le client, et puis donc nous avons forcer des échecs, nous avons arrêté le service customer-service et nous avons vu donc ici comment utiliser resilience4j pour notamment implémenter le Circuit Breaker, donc tout ça c'est des solutions que nous avons travaillé la dernière fois, alors bien sûr donc on va continuer toujours on aura l'occasion donc de revenir sur resilience4j parce qu'il n'offre que le Circuit Breaker donc nous avons le mécanisme de Retry, et d'autres mécanismes qui sont fournis dans les solutions de tolérance en panne, et nous avons la possibilité d'utiliser un cache, nous avons pas mal de choses, mais c'est vraiment une solution qui est très intéressante notament pour les architectures, les systèmes distribués d'une manière générale voilà alors ça c'est pour juste rappeler qu'est-ce que nous avons fait, donc on peut dire que nous avons créé donc un microrvice customer-service alors nous avons customer-service dans lequel on gère l'entité Customer, donc on crée un microservice simple nous avons un RestController créé, et donc bien sûr pour accéder à la base de données on a utilisé spring-data alors spring-data-JPA on rappelle que spring avec Spring-data-JPA c'est un framework déclaratif qui permet donc notamment d'accéder à la base de données dans customer-db dans laquelle on gère la table Customers, alors dans notre cas la table Customers est définie par: ID, firstName, lastName donc ça c'est le microservice customer-service alors avec Spring data nous avons vu que pour accéder aux données d'une application on sait le faire notamment via SQL, donc le microservice avec Spring data JPA est un framework déclaratif qui permet de faciliter l'accès notamment à la base de données du microservice.

Alors de l'autre côté nous avons en fait un autre microservice qui est account-service alors dans account-service, on gère une entité BankAccount, puis donc la même chose nous avons un RestController que nous avons créé, et nous avons vu également semble pour accéder à sa base de données donc il y a spring-data-JPA avec il on accède à une base de données de ce microservice que nous avons appelé account-db dans laquelle on gère les comptes bancaires dont chaque compte est défini par son: ID, le solde, balance, le type et currency.

Et puis bien sûr un compte comme un compte bancaire appartient à un client il ne faut une relation, on doit garder une relation entre les comptes, et les customers donc bien sûr cette relation elle est logiquement représenté par une clé étrangère, c'est-à-dire qu'ici nous avons une clé étrangère qui est customerId, donc techniquement parlant cette table il est lié par une relation à une autre table qui se trouve dans une autre base de données via la clé étrangère donc ça c'est important alors bien sûr ici nous avons une communication toujours via SQL avec Spring-data, par exemple dans le BankAccount service si on veut accéder à des informations sur le client on va utiliser Open Feign donc ici Open Feign c'est un framework déclaratif la même chose qui nécessite que la création des interfaces et qui nous permet de communiquer avec un autre microservice via Rest donc ici nous avons une communication Rest donc à chaque fois si on veut avoir des informations sur le client on a une entité Customer enfin on a une classe Customer que nous avons crée, c'est une classe Customer dans le modèle mais cette classe Customer que nous avons dans ce microservice ce n'est pas une entité JPA, c'est une simple classe Java avec les getters et setters, mais si on veut avoir des informations sur Customer on va utiliser Open Feign donc on voie d'un côté on a spring data, il nous permet d'accéder à la base de données locale avec un framework déclaratif, et Open Feign nous permet d'accéder un autre microservice en tant que framework déclaratif, c'est-à-dire techniquement parlant en accédant à des bases de données locales on sait le faire avec Spring data c'est un framework déclaratif et puis accéder à des données qui se trouvent chez d'autres microservices la même chose c'est simple, il suffit de créer des interfaces Open Feign donc on peut également utiliser Rest Template et d'autres solutions qui permettent de communiquer avec le microservice via Rest, alors dans notre cas nous avons pour accéder à ces microservices, nous passons via spring cloud gateway, alors c'est une gateway API qui permet de recevoir les requêtes à partir des clients et pour chaque requête il va dispatcher la requête vers le bon micro service, bon son rôle bien sûr c'est de faire ça.

Et puis bien sûr donc pour que la gateway puisse contacter les microservices il a besoin des adresses, et donc comme généralement au niveau de la gateway on connaît pas préalablement les adresses des microservices donc c'est pour cela nous avons besoin du Discovery service, alors Discovery service c'est un service qui à chaque fois qu'il y a un microservice qui démarre chaque microservice va faire une opération qui s'appelle register, c'est-à-dire il va enregistrer son nom et son adresse, la même chose pour tous les microservices donc nous avons ici une opération register, Discovery service c'est un annuaire qui permet d'enregistrer les adresses des microservices, donc ça veut dire que maintenant pour contacter un microservice on n'a plus besoin de connaître le nom, on a besoin de connaître que le nom donc ça veut dire que Discovery service gère une table en mémoire dans lequel nous avons le nom du microservice, nous avons l'URL, son adresse customer-service, son adresse account-service, ça veut dire qu'on peut démarrer plusieurs instances d'un même micro service parce qu'en fait les microservice c'est une architecture qui est scalable ça veut dire que techniquement s'il y a par exemple un problème de monter en charge sur par exemple account-service, on va démarrer account-service en plusieurs instances alors quand on démarre en plusieurs instances ça veut dire que ici account-service on va avoir plusieurs adresses, en quelque sorte toutes les instances ils vont s'enregistrer avec le même nom alors ça c'est Discovery service.

Alors donc la gateway quand il reçoit la requête généralement qu'est-ce qu'il fait, à partir de la requête il connaît le nom du microservice et il contacte Discovery service c'est-à-dire il va lui donner le nom et il récupère l'adresse alors cette opération s'appelle discover, bon généralement au niveau designé nous avons register ça veut dire quoi enregistrer son adresse et discover
ça veut dire chercher l'adresse, c'est-à-dire on donne le nom et on récupère l'adresse et après on contacte le bon microservice alors ça c'est en quelque sorte l'architecture globale.

Alors maintenant il nous reste une dernière étape c'est la configuration parce que ça c'est la partie que nous n'avons pas travaillé la dernière fois alors maintenant si on crée en fait un fichier de configuration pour chaque microservice ça ce n'est pas pratique de créer un fichier de configuration pour chaque microservice parce que quand nous allons avoir un fichier de configuration pour chaque microservice c'est terrible pourquoi, parce que nous avons account-service il est déployé en trois instance si nous changons un fichier de configuration dans une instance il faut également changer chez les autres et en plus il y a beaucoup de microservices qui ont des configurations commune, ils ont les mêmes paramètres de configuration et du coup donc à chaque fois qu'on va changer il faut redémarrer le service, c'est-à-dire on est obligé d'utiliser une configuration à froid c'est à chaque fois il faut redémarrer le microservice, donc ce qui fait c'est quoi la solution donc dans une architecture microservice il faut pas oublier qu'une architecture microservice c'est une application c'est-à-dire plusieurs microservices au sein d'une même application c'est-à-dire en terme de configuration nous allons avoir un seul fichier de configuration enfin, c'est-à-dire nous allons avoir une configuration pour toute l'application alors comment on va gérer ça, donc nous allons créer un service qui plutôt un service de configuration config-service et alors on va créer un dossier dans lequel on va créer un ensemble de fichiers de configuration Config-Repo, alors dans ce dossier là qu'est-ce qu'on va va créer, on va créer un fichier application.properties alors tout ce qu'on met dans ce fichier c'est des paramètres de configuration qui concerne l'ensemble des micro services c'est-à-dire tout ce qui est en commun à tous les microservices, et puis on va créer un fichier customer-service.properties et on va créer un fichier account-service.properties, c'est-à-dire que dans customer-service.properties on va garder que les paramètres de configuration de account-service de customer-service et dans account-service.properties on va garder que les paramètres de configuration qui concerne account-service et du coup donc ce service de configuration il va gérer ce dossier là c'est-à-dire toute la configuration va être gérée de manière centralisée au niveau du service de configuration donc ce qui fait que chaque service qui démarre va encore contacter le service de configuration pour chercher la config, alors chaque service qui démarre va envoyer une requête HTTP c'est du Rest vers le service de configuration pour lui demander donne-moi ma config et après le service va recevoir sa configuration et la même chose pour l'autre, c'est-à-dire on peut également configurer spring cloud Gateway au niveau de service config et eureca du coup donc on va avoir cette architecture alors sauf que en fait ce dossier qui permet de stocker la configuration ça doit être un repository git pourquoi un repository git donc ça c'est un git repository parce que nous avons besoin d'utiliser un outil de gestion des versions pourquoi tout simplement, parce que quand un paramètre de configuration change au niveau de la config quand par exemple on change un paramètre de configuration quelque part on va demander au microservice de recharger sa config se mettre à jour, de faire update alors qu'est-ce qu'il fait le microservice il envoie la requête vers config service pour lui demander donne-moi ma config donc si on n'a pas utilisé un outil de gestion des versions et bien qu'est-ce qui va se passer et bien ce qui va se passer c'est que le microservice va recevoir toute la config c'est il va recevoir toute la config, il va recharger toute la config alors que il y a qu'une partie de la config qui a changé donc comment par exemple on peut savoir qu'il y a que quelques paramètres qui ont changé au dans la config si nous n'utilisons pas un système de versionning on peut pas le faire parce que si on travaille à un git repository à chaque fois que nous faisons un commit ça veut dire nous créons une version, donc quand on demande la config on demande la dernière version et nous savons quand nous demandons la dernière version il va pas nous envoyer le tout il va nous envoyer que les paramètres qui ont subi des  modifications donc nous voyons pour à noter c'est que l'utilisation d'un des repository pour stocker la config c'est une très bonne pratique pourquoi tout simplement parce que ça permet à chaque fois de gréer des versions à chaque fois quand on fait un nouveau commit et tout simplement c'est qu'on a une version quand on demande la nouvelle version et bien on récupère que les modifications par rapport à l'ancien version qu'on a déjà donc ça permet au microservice de savoir uniquement quels sont les paramètres qui ont subi la modification et ça c'est très important. donc on va d'abord voir comment on va faire fonctionner le service de configuration alors pour le créer donc, nous avons créé déjà un service de config avec les dépendances: springcloud, config Server, donc spring cloud config c'est une solution, c'est une implémentation d'un service de configuration. 

On aura besoin d'utiliser actuator pour tous les microservices et on aura besoin d'utiliser également eureka Discovery client si nous souhaitons que le service de configuration s'enregistre également chez eureka Discovery bon une fois que nous créons le microservice avec ces dépendances nous allaons créer un dossier qu'on va appeler config git repo dans lequel on va créer les fichiers application.properties c'est dans ce fichier là on va garder toutes les propriétés concernant l'ensemble des microservices alors par exemple dans notre exemple ici on va supposer que par exemple dans application.properties nous avons le paramètre on a besoin d'un paramètre P1 = 99, un paramètre P2 = 88 on suppose P1 et P2 ce sont deux paramètres qui concernent l'ensemble des micro services ça peut être par exemple une URL, ça peut être une adresse, ça peut être un paramètre fonctionnel, ça peut être beaucoup de choses alors ensuite on va créer un fichier customer-service.properties dans lequel on va garder uniquement les paramètres qui concerne le service de customer-service par exemple dans notre cas on va essayer donc de créer un paramètre dans ce fichier là on va créer un paramètre X dont la valeur est 01 et y dont la valeur égale 02 et puis donc account-service.properties dans lequel on va créer un paramètre a = 11 et un paramètre b = 22 par exemple donc on suppose généralement que ça c'est des paramètres fonctionnels nous savons que dans la configuration il y a ce qu'on appelle la configuration technique et fonctionnel, technique c'est tout ce qui concerne les connexions vers les bases de données  les paramètres des framework les Time Out, et technique c'est parce que nous sommes en train de paramétrer la configuration du framework, et fonctionnel c'est des paramètres de configuration c'est-à-dire métier ça dépend du métier par exemple si nous sommes dans par exemple le métier de la banque il y a des paramètres métiers il y a par exemple un taux d'intérêt il y a par exemple des paramètres fonctionnels qu'il faut paramétrer donc ça c'est les paramètres fonctionnels ça peut être souvent c'est la caractéristique de chaque microervice par exemple on suppose que customer-service il a un paramètre fonctionnel x et y et account-service il a un paramètre fonctionnel a et b alors maintenant dans la réalité on va dire dans la vraie vie c'est qu'il faut également gérer ce qu'on appelle les profiles c'est-à-dire les environnements de développement parce que quand on développe une application il existe plusieurs environnements il y a l'environnement de développement il y a l'environnement de test et l'environnement production On peut avoir plusieurs environnements par exemple quand on est en train de développer dans l'environnement de développement on va utiliser une base de données MySQL, dans l'environnement de test on va utiliser une base de données H2 database, parce que c'est pratique et dans l'environnement production on va utiliser Oracle parce que c'est imposé par le client donc ça veut dire que finalement dans notre application on va créer trois fichiers de configuration un fichier de configuration pour l'environnement de développement un fichier de configuration pour l'environnement de test et un fichier de configuration pour l'environnement production et quand on démarre notre application c'est à nous de dire à l'application on  veut démarrer l'application avec quel profile dev ou test la alors comment on va gérer ça, tout simplement en créant des fichiers par exemple ici nous avons customer-service.properties et nous avons customer-service-dev.properties et nous avons le fichier customer-service-prod.properties par exemple dans custommer-service.properties on va avoir le paramètre x = 111 et y = 222 alors que dans l'environnement prod nous voudrons que X soit 321 et y soit 123 parce que le paramétrage n'est pas le même donc justement ça c'est très simple à gérer avec bien sûr spring cloud config la même chose ici pour l'environnement dev a = 543 et b = 21 et le paramètre pour l'environnement prod nous avons a = 3 et b = 4 donc voilà comme ça qu'on va gérer. 

Alors maintenant, pour que ce dossier soit un guide repo donc nous rappellons qu'il faut utiliser la commande git init c'est pour initialiser le repo git add et git commit ça c'est les commandes de base de Git pour créer, pour initialiser le git le repository, pour ajouter les fichiers tous les fichiers et après à chaque fois que nous faisons une modification il faut faire un commit donc avec les versions.

Alors maintenant pour démarrer le service de configuration nous aurons juste besoin d'utiliser enable config Server donc qui permet d'activer. donc nous démarrons le serveur et maintenant le serveur il a besoin d'être configuré dans son fichier application.properties, bah on a besoin de spécifier le nom du microservice par exemple config service on a besoin de spécifier le port dans notre cas on va utiliser le port 9999, si nous voulons que le microservice s'enregistre au niveau de Server nous utilisons donc spring cloud Discovery en égale à True ou bien égale à false que ça dépend de cas mais surtout true voilà donc nous aurons besoin de spécifier spring cloud config Server git uri c'est-à-dire vous spécifiez à Spring cloud config sur où il va trouver la config c'est-à-dire où se trouve les fichiers de configuration et bien tout simplement ici donc nous avons l'uri et donc dans notre cas dans un premier temps on va utiliser file, c'est-à-dire c'est le système de fichier local file://users etc, et nous spécifions le chemin du dossier mais si nous avons fait un push vers GitHub nous allons avoir HTTPS etc, nous mettons directement l'adresse du repo c'est ce qui serait plus pratique, d'accord donc le terme URI on a déjà parlé la dernière fois, c'est Universal Resource Identifier c'est l'identifiant de ressources universelles ça peut être file://le chemin vers un dossier ou un fichier ça veut dire loader balancer et on spécifie le nom du microservice c'est une URI c'est-à-dire ça peut identifier une ressource quelconque ça peut être un fichier, ça peut être une image.

C'est d'une manière générale alors que l'URL c'est Universal Resource Locator ça c'est pour les ressources web c'est-à-dire que l'URL forcément c'est HTTP etc, on identifie soit HTTP soit FTP c'est des URL c'est-à-dire c'est une ressource que accessible via le web d'une manière générale donc c'est ça la différence voilà parce que exactement donc URL c'est un cas particulier de URI donc l'UR Ic'est d'une manière générale ça peut identifier une ressource quelconque alors que l'URL c'est un cas particulier de l'URI qui permet d'identifier une ressource web, alors donc ça c'est au niveau de ce qu'il faut faire si nous démarrons le service de configuration nous lançons notre navigateur nous voulons le tester, si nous demandons application/default ça veut dire que nous demandons au service de configuration application ça veut dire quoi c'est le fichier application.properties, il va nous retourner tout simplement les tous paramètres de configuration qui se trouvent dans application.properties ça veut dire l'environnement par défaut ou le profile par défaut. si nous lui demandons custommer-service/default il va nous donner les propriétés qui se trouvent dans le fichier application.properties à savoir P1 et P2 mais également il nous donne les paramètres de configuration qui se trouvent dans customer-service à savoir X et Y ça veut dire que customer-service quand on demande sa configuration il va demander ça et il reçoit le paramètre a et P1 et P2 il reçoit également le paramètre X et Y, alors ça c'est défault l'environnement par défaut.

Alors avant de passer à la pratique donc on va regarder côté client maintenant côté customer-service qu'est-ce qu'il faut faire pour chercher sa config alors pour chercher sa config donc ce qu'on va faire c'est qu'on va d'abord la dépendance spring cloud config client on a déjà fait ça donc c'est-à-dire le client config et puis nous avons besoin dans le fichier application.properties de customer-service de spécifier d'abord le nom du microservice parce que le nom du microservice on va le centraliser on va pas le le mettre dans le git repo pourquoi parce que nous savons que chaque microservice quand il démarre il a besoin de connaître d'abord son nom d'accord pourquoi nous avons besoin de connaître notre nom parce que une fois que nous démarrons nous allons demander à spring cloud config donne-moi ma config et pour lui il faut lui donner notre nom donc si nous n'avons pas de nom nous pouvons pas récupérer notre config donc ce qui fait le nom du microservice ça doit être précisé au niveau de la configuration locale de chaque microervice la même chose pour le port donc le port il faut le préciser dans le fichier de configuration locale du microservice si bien sûr généralement si nous voulons le fixer mais après on va voir que le port peut être spécifié au moment du démarrage idéalement c'est-à-dire au moment du démarrage on peut spécifier le port via un paramètre de configuration donc ça c'est les choses que nous devrons préciser mais après le reste de la configuration alors pour demander au microservice d'aller chercher le reste de la configuration chez le service de config on va utiliser la propriété spring config import et voyons donc dans import nous avons optional config Server et là nous spécifions l'adresse de config Server donc ça veut dire que le microservice une fois qu'il démarre il envoie cette requête vers customer-service/deault, donc  il reçoit sa config de cette façon c'est envoie une requête HTTP pour récupérer cette config et après il va se configurer bon c'est comme ça qu'on fait voilà alors maintenant c'est comme ça qu'on peut chercher la config chez le service de configuration alors maintenant quand il y a une modification au niveau de la config quand on change un paramètre de configuration comment est-ce qu'on va indiquer au microservice que la configuration a changé comment le microservice peut savoir que sa configuration vient de changer donc il doit la recharger et bien tout simplement si nous voulons informer le microservice d'actualiser sa config il faudrait envoyer une requête HTTP avec Post vers le microservice bien sûr ici actuator/refresh donc nous rappelons actuator c'est une dépendance que nous avons utilisé et parmi les endpoints que actuator peut exposé il y a actuator/refresh alors si nous envoyons un Post vers refresh qu'est-ce qu'il fait le microservice il va automatiquement à nouveau envoyer la requête vers le service de config pour lui dire donne-moi la nouvelle version de la config il récupère la config et après il va se rafraîchir.

Alors bien sûr ici y a un exemple on va le voir dans la pratique on va voir comment faire tout ça dans la partie suivante.

## 3. Créer le Micro-service Customer Service
