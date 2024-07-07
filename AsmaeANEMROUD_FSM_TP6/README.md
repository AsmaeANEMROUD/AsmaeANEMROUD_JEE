Asmae ANEMROUD                                                                                                                
Systèmes distribuées                                                                                                              
MIAAD                                                                                                                       
Promotion: 2023-2025

                                                     Compte rendu JEE/TP6

# Première Partie : Développer un micro-service
## MIcro Service avec Web Service RESTFUL : 

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

## Micro-SERVICE wvec web service GRAPHQL : 
