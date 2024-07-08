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
