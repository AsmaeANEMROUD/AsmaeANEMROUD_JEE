Asmae ANEMROUD                                                                                                                
Systèmes distribuées                                                                                                              
MIAAD                                                                                                                       
Promotion: 2023-2025

                                                   Compte rendu JEE/TP4

# Première partie :

Pour que l’on puisse travailler avec Angular, il nous faut tout d’abord installer Node js :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/86cdf9b0-71f5-486f-8aff-fbff6853482d)

Puis on passe à l’installation d’Angular CLI :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/4baf8d20-2dac-4326-bd90-d0bda6b11760)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/04ba28ca-e280-4be1-9ac8-74f8b73cbc41)

Maintenant on va créer notre projet Angular que l’on appelle FirstApp, et pour le faire on utilise la commande « ng new FirstApp », et pour que l’on indiquer qu’on veut utiliser la version module on ajoute le flag « --no-standalone » à notre commande pour générer les modules avec le projet.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/0e6f538b-92bb-42f8-ba98-5bc8ff5d96b1)

Puis on lance l’application, pour la tester :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/7b6d836d-01da-438f-920b-a9f6240c660c)

Et voilà notre application :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/c5ce4ce4-6268-45ac-8145-bd88af6c93bd)

On ouvre notre application en utilisant l’éditeur Intellij, pour qu’on la lance dans le terminal de l’éditeur.

Puis, on affiche un petit titre Hello :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/a5045ab4-a72b-4005-bfb5-660ad22e87c8)

Maintenant on veut ajouter un petit Menu en utilisant Bootstrap, pour se faire il faut tout d’abord installer Bootstrap :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/0d29eec0-9532-44c6-811c-49342f0d9a33)

Une fois que Bootstrap est installé, il faut que nous le déclare dans le fichier angular.json pour l’utiliser :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/17cc7cc5-201f-46d7-a556-c93d297eb243)

On ajoute deux boutons, dans le fichier app.component.html :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/be235f8d-0c99-4505-bb04-8a6c8248d710)

Maintenant on veut que lorsqu’on clique sur le bouton Home, le compenent home s’affiche et même pour le bouton Products, pour cela on va générer deux composants :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/f114fef8-5cfc-477b-8735-4f9e02524433)

On va utiliser le système de routage, qui se trouve dans le fichier app-routing.module dans Angular, et on ajoute deux routes :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/530043ef-d143-475d-8fb2-757125b76791)

On utilise le routerLink pour spécifie le routing, et on utilise router-outlet pour afficher les composants Home et Products :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/bce73cf5-1d6f-452d-ac4f-2e05607cf63d)

On passe pour personnaliser le composant Products (même chose pour Home) :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/483a86fd-d306-4ae4-a031-58d1f37a7e94)

Maintenant on veut afficher une liste des produits, on créer tout d’abord les produits :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/27d9dd86-9de0-4d56-bbaa-3382b45ddf2b)

Voilà la liste des produits qui ont stockées dans le module :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/690619e8-b565-4e6e-8a57-45da96d4f78f)

On affiche la liste des produits en utilisant la méthode ngOnInit() :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/2d39263b-4291-4878-afb8-15e07c38ea65)

On ajoute un test pour s’assurer que le product est chargée :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/5bc34afb-c0c6-4ab9-a5c5-6bff5a098f5d)

On va ajouter un bouton pour supprimer les produits :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/438dc2b7-5421-4559-90b4-efd877bace2c)

On définit la méthode deleteProduct, et on supprime les deux derniers produits :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/d6052af7-5f54-4c49-95be-277072a7c1e5)

Supposons nous voulons créer un formulaire, alors dans la partie html on ajoute une zone de texte et un bouton chercher :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/c18e4d27-fc24-466a-bed5-394a69866709)

Puis on importe deux modules :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/d6061402-40ec-4b02-a38b-dee1d4a0a91b)

On ajoute le ngModel et une méthode search pour chercher un produit :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/4b63d5a6-4f4c-48c7-aba3-e51f4fb999d1)

On définit la méthode search, et on chercher par la lettre c :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/c31ea661-d9a2-4d79-85f9-f56119f9c18d)

On peut même faire la recherche avec la méthode filter :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/046454d7-d02d-4e38-8966-404305a0f391)

Il reste une petite tâche à faire c’est quand on clique sur un bouton, il faut qu’il reste marquer.

Pour cela au lieu d’utiliser routerLink, on va utiliser la deuxième solution c’est click :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/e21fd3b7-ed9a-4558-b0af-9a112ad3d51a)

On définit les méthodes :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/b4e6d3a5-efa5-44ae-af14-4c181905243b)

Et on remplace class par ngClass :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/220d312e-3ef0-4066-bc33-07a017c9dc21)

Et voilà le bouton reste remarqué :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/e96b4002-436b-463d-bfcc-300f95645707)

# Deuxième partie :

## Partie 1 :

On veut créer une application web Angular qui permet de gérer des produits avec un backend basé sur Json-server.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/d3d94f43-e7a5-49e6-a623-b5f94b686a3a)

On démarre notre application dans un premier temps avec la commande ng serve :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/d10bbbb2-1143-4d74-a6f2-10cc93bce030)

On change le titre dans le fichier app.component.ts :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/9ab58e65-dc1b-4ff0-a139-35b90abab6c4)

Puis on utilise le mécanisme du Data Binding pour afficher ce variable, c’est-à-dire Angular utilise une directive qui s’appelle double moustache :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/9211d03c-bb0c-4722-be36-84dcb82607c5)

Comme d’habitude il nous faut installer bootstrap et bootstrap-icons :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/c4faf9fa-1b49-400c-abee-d7d3c6f37df2)

Puis pour intégrer bootstrap à notre application, on l’ajoute dans le fichier angular.json :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/54fc3f1a-d4b0-42e1-ad4b-0051daa5eb27)

Pour bootstrap-icons, on va l’intégrer avec autre facon, on va vers le fichier styles.css et on ajoute la directive @import, puis on redémarre l’application :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/52b8ae74-fd6a-4f96-8dcd-ee401a781fab)

Maintenant on va créer trois boutons dans notre application et on va décorer avec bootstrap et bootstrap-icons pour les tester :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/b83069c6-2789-4008-937f-755a13cb8f17)

Pour qu’on peut naviguer dans notre application on doit ajouter le système de routage en utilisant router-outlet :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/4747f3c7-c732-41cc-8a57-a217346c3500)

Puis on va créer trois composants en utilisant le terminal :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/74f9edbc-12df-4bac-a511-2e43c708ed92)

On passe pour créer les routes dans le fichier app-routing.module :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/b7bbf935-2d8a-46f4-bfca-46e070e53c99)

Maintenant pour les utiliser on ajoute un routerLink à nos boutons, et on voit qu’il ça marche :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/da256c0c-5d56-4291-bba1-1b8f8946ae28)

Revenant maintenant à nos fichiers html de nos composants pour les personnaliser, prenons l’exemple du composant new Product (même choses sa passe pour les deux autres composants) :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/1f1b1e06-7828-40b1-909b-a139aeadc17d)

On passe pour créer une liste d’action dans notre fichier app.component.ts, pour minimiser le code :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/05718357-813a-47e7-9a4f-3fb2502e3c6d)

On minimise le code html et on voie que l’application marche bien, avec un peu de code :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/42d1ec07-525d-41da-a513-c1bb8bdf7447)

Passant pour indiquer qu’elle est l’action courante, avec l’utilisation d’une variable que l’on appelle currentAction, et on définissons la méthode setCurrentAction() dans notre composant :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/c562cb61-4825-4ffd-a1a5-3c234556c428)

Et on ajoutant le click, et le [class] qui contient une expression pour nos boutons, on voie qu’il reste sélectionné :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/62aecafa-6445-4cb3-856b-83b33ff22d5a)

c’est quoi data binding ? C’est tout simplement la liaison entre les données qui sont stockées dans la classe des composants avec ce qui est affichée dans la vue.

Le data binding peut se faire dans un sens, dans l’autre ou dans les deux, c’est-à-dire si par exemple nous avons une variable data et nous voulons l’afficher dans la partie vue, on utilise ce qu’on appelle String interpolation (la variable va automatiquement se mettre à jour au niveau de la partie vue).

Quand on utilise des parenthèses, on est dans l’autre sens ça veut dire du partie vue vers la classe des composants.

Généralement on utilise les parenthèses dans les événements tels que : OnClick, OnChange, etc.

Parfois, on peut faire Two way binding dans les deux sens, alors pour se faire par exemple dans une zone de texte nous pouvons créer un input par exemple dans un formulaire et nous utilisons [(ngModel)], les parenthèses veut dire que le data binding est dans le premier sens, et entre crochets veut dire qu’on est dans l’autre sens. Ça veut dire que si la variable data change automatiquement il va s’afficher dans la zone de texte, et si on modifie la zone de texte ça va changer la variable, voilà donc ici nous voyons ce qu’on appelle Two way binding.

Le faite d’utiliser [property] ou bien le property binding, ça veut dire que cette propriété est égale à une valeur, et cette valeur c’est une expression.

Maintenant nous voulons afficher la liste des produits, pour se faire on va travailler avec data binding, dans un premier temps on va afficher une liste des produits statiques, on va ajouter des produits dans notre fichier products.component.ts :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/c9f780f7-a700-4729-8ce9-7f74cb7c94be)

Pour les afficher on passe à la partie html :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/42239ae3-2c97-435b-840e-ce8d8a7e2e04)

Maintenant on veut afficher la colonne checked avec des icons, et pour quand on clique le bouton change :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/0599f419-85b1-484a-8bcf-109983367f46)

On passe pour définir la méthode handleCheckedProduct :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/1d97290f-54c8-4148-859f-541f8798e74e)

On a fait ça juste en local, mais dans la pratique on est besoin d’un Rest API.

On a besoin d’un backend dans laquel on va gérer les produits, pour cela on va essayer d’utiliser une Rest API rapide en utilisant le serveur json.

Le serveur json c’est une application Nodejs qui permet de mettre en place en quelques secondes une Rest API.

Alors pour utiliser json server, nous avons besoin d’installer :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/da3902b2-9483-40f9-bc3a-67f1613f9608)

Maintenant pour gérer notre base de données (qui va être un fichier json), dans notre projet on va créer un dossier data, dans lequel on crée un fichier db.json, qui contient notre base de données, puis on va démarrer json server :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/4201fb4c-2a63-4a99-9c87-38a1db26f88a)

Si nous voulons tester notre Rest API, ça va afficher la liste des produits :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/e990a3ba-cf8b-4a25-a377-e77fe6f94cd3)

Alors on va utiliser cette Rest API pour pouvoir chercher nos données.

Au démarrage de notre composant products, on a besoin d’envoyer une requête HTTP vers le backend pour chercher la liste des produits, donc on va utiliser un module qui s’appelle HTTP Client, donc ça se passe premièrement dans app.module, on va l’importer :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/952b77e9-8f0f-4ef8-b8d3-7911d38a6766)

Deuxièmement dans products.component.ts, dans notre product on a un constructeur, et on va faire l’injection des dépendances via le constructeur :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/8555b0ef-ab64-4930-8a85-b6f3a8cd1e5e)

On est besoin aussi de faire un traitement au démarrage du composant, et pour cela un composant angular peut implémenter une interface qui s’appelle OnInit, cela oblige de redéfinir la méthode ngOnInit qui s’exécute une fois que le rendu est généré :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/cbaa58ab-0563-4919-a70b-3aacd557849f)

Nous ajoutons autre produit à notre base de données :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/55151b9a-d0e6-4c2b-a626-0d7f30474642)

Nous voulons maintenant que lorsqu’on fait un check sur un produit ça change aussi dans la partie backend, alors on va utiliser le patch pour qu’on change juste le Checked,  on utlise aussi la template String au lieu d’utiliser le plus :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/6d148252-ff3f-4474-a300-f36c3af7095f)

On va que ça change aussi dans le fichier db.json :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/e87b1ab0-f3d6-4c51-8c61-26421f32bfee)

Alors on va structurer notre code, et pour cela on va d’abord introduire la notion de service.

Pour créer un service product avec Angular on va utiliser la commande :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/070de4bf-b5d2-41ee-a909-867ca7b438e2)

Alors nous avons remarqué qu’il génère un dossier dans notre application qui s’appelle  services, dans lequel on a un fichier product.service.ts.

Donc comme nous voyons, pour créer service dans Angular tout simplement on a une classe qui utilise le décorateur @Injectable.

@Injectable ça veut dire que c’est un service, il est fait pour être injecté, c’est comme si nous voulons avec Spring, nous disons Component, ça veut dire c’est un composant ça peut être l’annotation service au démarrage il va être instancier, une fois qu’il est instancier il faut l’injecter dans n’importe qu’il composant.

En fait l’avantage des services, c’est que dans les services généralement on va déclarer des méthodes.

Alors dans notre cas on va créer une méthode getProducts, qui va permettre de chercher des produits au niveau du backend, et aussi la méthode checkProduct :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/deb545fb-31d9-426b-9dfb-48223980a8b5)

Maintenant on doit utiliser les bonnes pratiques, donc on va utiliser les méthodes dans notre service et on les appelle dans notre fichier products.component.ts :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/ca70f40e-cbb7-4b3a-b4cf-e5f8fed62a86)

Normalement on a dit que pour pouvoir injecter un service dans les composants, il faut que le service soit déclaré dans le module, exactement dans providers :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/bd38e9af-5805-4432-90e0-22c65cab897f)

Mais c’est pas obligatoire, parce que si on regarde le service nous avons providedIn : root, ça veut dire c’est qu’on nous disons ce service là il est disponible dans la racine du projet, donc automatiquement dès le démarrage c’est un service qui va être instancier et nous pouvons l’injecter dans n’importe qu’il composant de notre application, pas uniquement de notre module, mais de tous les modules.

On a développé une application structurée on utilisant le type any, mais si nous voulons quelques choses de plus professionnel il faut l’indiquer que c’est une liste de produits, donc ça veut dire nous avons besoin de créer un modèle, pour ce faire on va créer un dossier qui s’appelle model dans lequel on va créer un fichier TypeScript que l’on appelle product.model.ts :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/06937f93-b0a6-4595-82fc-f4b8449388dd)

Du moment que nous avons Product, revenant vers notre service, et on change any par Array<Product>, on fait aussi pour notre composant :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/054ea381-ca69-4197-8281-ac304d2b255f)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/9ca74421-8b7f-4293-a85f-09a21f443649)

Alors on a structuré, mais qu’est-ce qu’on a va gagner ? Si nous allons vers notre frontend, par exemple quand nous allons afficher un produit, nous mettons product. nous voyons bien la structure de nos données, on sait qu’il s’agit d’un objet de type product, et nous allons comparer quand nous déclarons notre modèle, et les services nous sommes en train d’organiser notre code, et quand nous allons développer nous allons voir que ça va très vite.

Il y a juste un petit détail, quand on appelle la méthode getProducts, il va retourner un Observable et on fait subscribe, ça c’est une façon de travailler, mais il existe autre façon, dont products ça devient de type Observable, et comme il n’a pas initialiser il lançe un problème, on peut l’éviter on ajoutant un ! juste après la variable, c’est comme on dit au compilateur TypeScript ignore même on n’a pas initialisé. Et quand nous avons une variable de type Observable par convention on aime beaucoup généralement utiliser un $ juste après le nom de la variable.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/a526f967-1894-402d-b071-7c140519f250)

Là ça passe, mais le problème c’est quand nous allons parcourir le frontend ça marche pas, alors dans Angular il suffit d’utiliser un pipe avec async, c’est-à-dire quand nous avons un observable on met async pour que le frontend automatiquement fait un subscribe, et il parcourt la liste :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/90634ec9-0d23-4ec9-93c4-a1ead882a614)

Pour gérer les erreurs maintenant, il va falloir obligatoirement que nous faisons pipe, c’est-à-dire que nous récupérons l’observable, mais en même temps nous regardons s’il y a erreur, on prend le message d’erreur etc.

Alors ce que nous ferons maintenant, c’est d’ajouter un bouton pour supprimer un produit :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/69b70306-f381-4a91-b0eb-9a392a7d4225)

Pour définir la méthode handleDelete, de préférence on va vers notre service et on créer une méthode que l’on appelle deleteProduct :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/5524f256-bc76-43b7-acb7-cd8959a84676)

Alors pour supprimer il suffit d’appeler la méthode deleteProduct de notre service, et on teste :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/9e0cb2db-6a39-4549-8ba1-584d0eb0d3f9)

Le problème maintenant si que nous avons un observable il faut savoir le manipuler, donc c’est pour cela on va revenir vers la structure qui contient une liste des produits, et on supprime le pipe et async de notre fichier html.

Alors on supprime un élément de la liste, après qu’on clique sur ok dans notre alerte :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/7e7041d3-4cea-4c94-a22e-3665a4f15b66)

Alors maintenant nous avons besoin de créer un formulaire pour ajouter un produit, donc l’une des façons le plus importantes pour gérer les formulaires dans React, est d’utiliser ce qu’on appelle React Forms, pour cela on est besoin d’importer un module qui s’appelle ReactiveFormsModule :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/e373f894-99dc-4543-846e-c297f76db437)

Une fois que nous l’importons, on va vers notre composant pour déclarer un attribut productForm que l’on va utiliser dans la partie html et qui stocke tous les données que nous avons saisir dans le formulaire, aussi un constructeur et la fonction ngOnInit :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/493e3877-7843-4f45-b415-ee302165bd69)

Maintenant on va créer notre formulaire dans notre fichier html, on a utiliser [formGroup] pour rattacher notre formulaire, ça veut dire faire un binding avec elle, puis on a utiliser (ngSubmit) pour qu’elle fait appelle à notre méthode savaProduct que l’on va définir à la suite, ensuite on va afficher le conteunu de notre formulaire en même temps en format json en utilisant un pipe json, ça veut dire tous ce qu’on va saisir s’affiche au-dessus :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/b4ad14b0-c1e1-4e21-8a95-df3fc74032b6)

On va récupérer notre formulaire, en définissant la méthode saveProduct :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/dc34a8de-621c-4c04-afb0-d6947dd45544)

Puis on passe pour définir la méthode saveProduct de notre service, et on supprime l’affichage dans notre fichier html parce que json le fait automatiquement, après on teste pour voir que tous marche bien au niveau backend :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/6a7be68b-186f-49c8-9402-8ae3c579bc2f)

Juste dans le prix normalement la valeur par défaut ça doit être un zéro, ce qui fait on va revenir à notre composant et on met la valeur par défaut c’est 0, et après on va ajouter les validateurs :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/e31505f1-a62a-42e0-99a9-c7338313c2ba)

Alors comment on va l’utiliser ? on va désactiver notre bouton, et ne l’activer que si notre formulaire est valide, c’est-à-dire notre bouton soit désactiver, mais lorsqu’on saisit un nom du produit et il va s’activer :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/28b6f9bc-b078-41c4-9adb-4ee878ef2244)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/75d2233b-b7c5-4597-a05d-27291159779f)

On a fait la suppression, l’ajout et il nous reste la recherche.

Alors pour faire la recherche, on va vers le même composant du products, et on va créer un simple input, et au lieu de ReactiveForms on va utiliser Two Way Binding, donc la première des choses c’est qu’on va ajouter le module FormsModule :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/1c51ac62-9976-42b8-ac4a-6ffea89bb307)

La deuxième des choses c’est qu’on crée notre formulaire, dans lequel on utilise [(ngModel)] de notre modèle FormsModel :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/1ca4bdbf-3a20-4b82-9116-8016fad7f932)

Maintenant il nous faut la variable keyword, alors on va la déclarer dans notre classe :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/01fbd544-c6a3-44e0-9cf6-d0610e7df899)

On va utiliser un click dans notre bouton qui fait appelle à une méthode searchProducts :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/fa3768b4-f798-495a-9db7-5cb335953231)

Puis on va définir notre méthode de recherche :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/cfc29f6a-cdf0-4776-b354-6c96549ae51d)

Il nous reste de définir notre méthode dans le service, avec json-server on utilise le nom du champs avec lequel on veut chercher underscore like :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/fda16154-98f4-429f-9119-6b3528a71e27)

Le dernier point qui nous reste c’est la pagination, pour cela on va transmettre des paramètres à nos méthodes dans le service :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/36d8b5de-36a2-477b-babc-6de1f702040b)

Pour qu’on vérifie il suffit d’aller vers la page products.comoponent.ts, alors qu’on nous appelons getProducts avec les paramètres 1 pour la page et 2 pour size :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/fd7deec0-06b5-4414-a1ee-6f235a193a89)

Donc json-server il gère la pagination en backend, maintenant il reste le nombre des pages dans la prochaine partie.

## Partie 2 :

Dans cette partie, on va essayer d’abord de compléter notre pagination, pour cela on doit lire les headers en utilisant observe:’response’ :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/542f9b3a-ebd2-46d2-bd8a-a7dd2c8c4be2)

Maintenant on revient vers notre composant, alors lorsqu’on appelle la méthode getProducts on retourne un objet responsable ça veut dire un objet de type http Response, et forcément un petit souci se trouve, pour le sauver on met resp.body as Product[] c’est comme on dit que c’est un tableau de produits, la deuxième des choses c’est qu’on doit récupérer totalCount :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/76817acf-1d46-4013-bff5-b54d86236fd2)

Maintenant qu’on a vu le nombre de page récupéré est 5, on passe pour calculer le nombre total des pages, donc nous avons besoin dans notre composant de déclarer les trois variables totalPages, pageSize et currentPage :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/5f22a3ea-c63e-4370-a839-d36514e6a514)

Il nous faut un petit test, c’est lorsqu’on a un reste il faut ajouter une page :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/04d560a3-17ff-4817-9aba-67247f177846)

Alors maintenant que nous avons totalPages, on va revenir vers la partie html, pour afficher les pages :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/b344feac-be30-4d0e-812a-cc35e6797636)

Il nous qu’on on clique il doit afficher la page, pour cela on va ajouter click à nos boutons, cette click fait appelle à la méthode handleGotoPage, que l’on va créer tout à l’heure :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/5a0f2f2c-f6a4-461c-bf24-4ed63784bec8)

On passe pour définir notre méthode, et on teste :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/8a304a40-4600-43e9-972a-612573cbfca2)

Maintenant tous ce qui reste c’est qu’il nous faut colorier ou bien sélectionner la page courante :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/d927505e-b95c-49b9-8949-7d6e9415ac72)

On peut le faire aussi en utilisant [class] au lieu de [ngClass] :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/6d14a33c-4bda-449f-94ca-8532ff2fd4a9)

Maintenant il nous reste un petit problème, c’est que tous les produits s’affiche dans la même page, parce qu’on n’a pas initialisé le pageSize et currentPage.

Alors on va régler le problème, on va envoyer le currentlPage et pageSize en paramètres de notre méthode searchProducts.

L’autre problème qu’on trouve c’est de refaire ce que nous avons déjà fait dans la méthode getProducts, (c’est le calcul des pages totales), pour cela on va changer le nom de la méthode getProducts en searchProducts et en envoie le variable keyword dans leur paramètres.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/9a399714-ae4a-4803-a708-ed7c919b4ef9)

On change aussi dans notre service, et on teste pour voir les produits s’affiche dans plusieurs pages telles que le size de chaque page est 3, et lorsqu’on fait la recherche il s’affiche les pages contenant les produits recherchés.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/afec5298-9dc5-46a4-bfd3-f81d738e2435)

Il y’a encore un petit problème c’est que quand on est dans la première ou la dernière page et on supprime les produits, la page reste vide mais afficher, pour cela on doit ajouter des trucs pour que le numéro de la page s’incrémente ou décrémente selon si on est au début ou à la fin.

Après on va passer pour faire la modification des produits, et on va commencer par la partie html pour afficher le bouton éditer :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/1a8cdc4c-a763-4807-9dbd-60d90da7cc29)

Puis on va pour générer un nouveau composant qui permet d’éditer le produit :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/ce85d72f-4bd7-41b4-a5b0-3d09af50ff85)

Pour aller vers edit-product on est besoin de créer une route d’abord, cette route il va contient un paramètre id, on ajoute les paramètres dans angular après un slash :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/18a3fea1-391f-403d-b62f-e9b77d4e02b8)

On passe pour définir notre méthode handleEdit qu’on a cité dans la partie html, mais tout d’abord on va injecter le router, après on teste :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/a4f8e0bd-1eb9-44f1-8711-57fd3207ad2f)

Maintenant on revient vers notre composant pour faire éditer, on commence par l’injection d’activatedRoute c’est pour le route active, on a snapshot qui fait un copie pour notre route, et params pour indiquer le paramètre qui nous interesse :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/783bd81b-af5a-4b1f-9b4e-0b33cc4204c4)

Pour les tester, on revient vers la partie html :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/512d4f6a-4383-4252-96a9-42c8d39541d7)

On passe pour que nous envoyions une requête au backend pour récupérer le produit, pour l’éditer :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/1922046b-7e7a-442d-b3d0-586fd775e8a7)

On définit la méthode getProductById dans notre service :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/d9d6fca3-3d56-4f6b-8b16-457602aa9ce0)

On a initialisé notre formulaire, donc il reste de l’afficher donc revenant à la partie du html :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/de2d52f2-369b-4959-8c78-e8da6c6cda64)

On passe pour définir la méthode updateProduct, qui permet d’éditer le produit :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/08968598-bf83-4b22-92e4-8a867a5c1d28)

Et en fin on définit la méthode dans notre service aussi :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/8e507c35-a038-4cb4-92bf-b15f6023fbf0)

## Partie 3 :

Supposons nous voudrons créer un web component que nous allons appeler dashboard dans lequel on va mettre quelques indicateurs tels que le nombre totale de produits, les produits checked, le nombre de pages et le page size, etc.

Supposons nous avons un composant qui permet de faire un dashboard mais ce dashboard il dépend des données qui se trouve dans l’autre composant, alors maintenant on va tomber dans un problème, c’est que nous avons en fait les deux composant, comment ils vont communiquer ? donc on a une hiérarchie des composants, ça veut dire le premier composant utilise les données qui sont déclarer dans l’autre composant.

Pour qu’il peut les utiliser on peut commencer par des solutions basé sur des inputs et des outputs, mais c’est vraiment par une bonne solution, alors c’est la raison pour laquelle souvent il est plus utile quand nous avons des données de notre application qui ont besoin d’être utilisé par plusieurs composants, alors dans cette situation-là, il est plus important de centraliser les données de l’application dans un service, donc on va appeler app state, c’est-à-dire c’est un service dans lequel on va mettre l’état de l’application ce qui nous facilite la gestion de nos données, alors pour cela on va faire un réfactoring de notre application.

Le réfactoring ça consiste tout simplement d’aller dans notre composants products, et comme nous voyons il a un état (la liste des produits, le keyword, le totalPages, etc), qu’on utilise, mais ça peut-être c’est données là on a besoin de les utilisées dans un autre composants de l’application, donc la façon la plus simple c’est de génére un service :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/e64b86ee-5c52-409d-b164-49941431ed35)

Dans notre service app-state, on va créer un variable qu’on va appeler productsState, puis on va déplacer les données de states de notre composant products à notre service app-state :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/df5fde46-4de1-4950-a458-971f487ccdfb)

Alors maintenant pour pouvoir les utiliser dans products, et pour gérer les erreurs qu’on voit partout, et bien tout simplement on va injecter le service app-state en public pour que l’on utilise directement dans la partie template, et on appelle les données de notre service :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/85049d17-bdf1-4bd8-9d9e-7177a61da945)

On va faire la même chose pour la partie html, et on teste :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/7314c1fe-a760-4a8c-8acb-f1e2bf07f83d)

Pourquoi on fait ça ? Ça va nous faciliter les choses parce que supposons nous voulons créer un composant dashboard par exemple, on va le créer d’abord :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/87b4e388-c0ec-4b7a-8860-783305d54c37)

Puis on revient à notre partie html de l’application et on affiche le dashboard :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/7fd89f5b-8a16-4644-93aa-4c45682f097c)

Pour qu’on affiche des statistiques de notre application, on va à la partie TypeScript de notre composant dashboard, on injecte le service dans un constructeur (là on voit l’intérêt de centraliser les données dans un service), et on définit la méthode totalCheckedProducts que nous utiliserons dans la partie html, et qui nous retourne le nombre des produits checker dans une page :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/28d778c2-297f-41b9-a9aa-72e68a321d91)

On passe à la partie html pour créer les labels dans lequel on va afficher nos statistiques :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/987c79bc-3462-49f1-a90e-b362531cffd8)

Pour afficher le nombre total des produits, on a ajouté totalProducts avec nos données centralisé :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/6ec30735-dcc6-4c5d-938a-891f8699133e)

Puis on le récupérer et stocker dans la variable totalProducts :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/e1be6d9a-2969-4500-bbd8-db5e78951dfa)

Le problème qu’on a maintenant c’est lorsqu’on supprime un produits le nombre total des produits ne change que lorsqu’on recherge la page, pour cela et dans le même composant on revient à notre méthode handleDelete, et on va appeler la méthode searchProducts qui va recharger les données :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/5b23a35c-082c-4e23-8c50-6d0fb9c8c553)

On fait un petit refactoring à notre code, donc au lieu d’appeler un attribut on va créer une méthode dans laquel on utilise des trois points pour qu’on faire copier tous les attributs de productsState, c’est ce qu’on appelle un objet immuable :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/7bb36dfe-5782-4f1e-9bfd-5f1e716756af)

On change aussi au niveau de products, par exemple au lieu d’aller directement stocker dans des variables, on va déclarer des variables et on change des données en utilisant la méthode setProductState :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/4abe5362-bb7e-4e41-a53c-b99530059b3e)

On revient vers notre service product, comme nous voyons le host ce n’est pas bien de les mettre directement, ou de le coder en dur le host de notre URL, donc ce que nous pouvons faire c’est dans un premier temps de déclarer une variable que nous appelons par exemple host et en lui donner comme valeur notre host :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/f8b88d43-db8e-47b7-9c7f-971740cb1b10)

On revient vers notre service app-state pour ajouter des messages, pour qu’il s’affiche un spinner pour que nous indique que les données sont en chargement : 
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/bda70118-56a2-4231-9d27-391befd47e8f)

On revient dans notre composant products, dans searchProducts avant d’envoyer la requête en peut aller vers appState et on accède directement à la méthode setProductState et on change la valeur de status en LOADING, et qu’une fois les données sont charger on met status en LOADED et dans la partie des erreurs on met status en ERROR et en trasmis un message d’erreur :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/9abb1465-12ac-4937-b739-f6508120ec26)

Maintenant on passe pour afficher un spinner dans navbar, mais avant on doit générer un composant navbar :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/e5a02c54-8a6a-418d-8377-82a46755f3c6)

Puis on prend le code html de navbar de notre application et on le mettre dans le ficher html de notre composant navbar :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/498b47fc-f813-4e72-ab0e-d1a0c2c10246)

De même on prend le code qui contient les variables que nous utilisons dans la partie html, du composant de l’application vers notre composant navbar :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/4fe3324b-cfc7-4aa1-83ec-f5ac5754c9a6)

N’oubliez pas d’ajouter app-navbar dans la partie html du composant de l’application :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/56d658b7-0f19-41a9-8cf5-2703c5e566ff)

Maintenant à l’intérieur de navbar on ajoute notre spinner :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/f172d0ec-9134-479e-ade1-757f88448feb)

Mais on ne veut pas que le spinner s’affiche que lorsque le status est en loading, pour cela on injecte appState dans notre composant :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/598970b4-a1cb-4ec8-9e23-b7e47541ae78)

Et on revient dans la partie html pour faire un test avec ngIf :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/84450e53-6c81-42c9-8c67-fc35ba6f90ba)

Maintenant c’est le temps de créer un composant que l’on appelle app-errors :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/abae730b-758e-45e1-8229-b2cd591aac68)

De même on va injecter le service appState :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/910302b1-f01d-4b9e-9e68-8b4ea676cc0f)

On passe pour la partie html, dans laquel on met une condition d’afficher le message d’erreur en format json uniquement si le status égale ERROR :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/2ed68b87-b8e3-4352-8a59-cbac5130512a)

N’oubliez pas d’ajouter app-app-errors à la partie html du composant de l’application pour qu’il s’affiche :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/3ed0c567-dda6-41a1-ba64-29f732c2bfe2)

Maintenant ce qui nous intéresse dans tout ça c’est le massage, donc va lui afficher seul :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/eb71fdc6-11be-4991-a13f-0a94701dc366)

Pour simuler les applications du réseau lent il suffit de choisir Lente 3G :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/442417f3-8366-48d7-8f2f-d80b3a887942)

On remarque que à chaque fois, on doit envoyer le status avant la requête et après, et en état d’erreur dans chaque composant et ça dérange vraiment, alors la meilleure solution pour ce genre de chose est d’utiliser ce qu’on appelle un intercepteur http.

L’intercepteur http c’est un service qui intercepte toutes les requêtes http, à chaque fois que nous envoyons une requête http il va l’intercepter avant qu’il envoie.

Et si ce qu’on veut, on envoie une requête mais avant qu’il soit envoyée, on va mettre le state de l’application à loading, une fois qu’on reçoie la réponse en le met en loaded, et le problème est régler.

Donc on va créer un intercepteur que l’on appelle app-http :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/f45ee6cc-339e-493c-be0c-86770eed99ae)

Dans cet intercepteur on va utiliser clone pour créer un copie de la requête, et supposons nous voulons mettre un header on peut utiliser req.headers et on retourne la requête :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/5596b93d-6a9d-43c0-b642-30c0a536c4d2)

Et pour qu’il fonctionne, on doit le déclarer dans le module précisément dans providers :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/688fda7d-8dc7-4d2b-a183-3eb9a3e8c001)

Si nous inspectons nos requêtes, nous allons trouver dans les headers, Authorization pour qu’on connaisse que notre intercepteur se fonctionne :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/65cc7d48-68f2-46b1-8b46-bb8d73c6c2eb)

Maintenant on va injecter appState dans notre intercepteur, pour qu’il fasse loading avant qu’il retourne la requête, et donc une fois que la réponse arrive on va l’écouter en utilisant pipe :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/dfbc11ef-0e4b-4baf-9540-2057af3ee286)

Maintenant on va voir l’autre solution pour le spinner c’est de créer un subject, qui est un type d’observable particulier qui peut lui-même être un observateur, alors on va créer un service que nous appelons loading :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/2d46ad7b-ef71-41fe-9f46-bda06f7d071b)

Alors dans notre loading service on va déclarer un subject que l’on appelle isLoading, et on créer deux méthodes showLoadingSpinner, dans laquelle on utilise next, ça veut dire on va émettre, ou bien on va envoyer à n’importe quel composant qui écoute un true, et la méthode hideLoadingSpinner dans laquelle on utilise next en false :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/eea37689-4de1-46fa-ba7f-ce3176deda66)

Alors comment on va l’utiliser ? On va vers notre intercepteur, et on injecte le service loading, et on fait appelle à nos méthodes :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/4e62ef1c-2d9f-439f-83fd-1bf361ecf13d)

Maintenant on met le subject en public, et on ajoute un $ au nom du subject, pour indiquer que c’est un observable :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/e274e500-9fb1-40e5-a390-a52ced7c3f5c)

Maintenant on l’utilise directement dans navbar, en injectant le service loading :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/ddaac0e7-060d-4851-90f9-f5e1bfda46f2)

On change dans la partie html aussi :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/2d4ba7bd-7a98-480f-b60a-f4aaf525b13e)

On peut faire autre solution, c’est de déclarer un attribut que l’o appelle isLoading :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/55083c86-ee4d-420a-aea9-7ee6485129ae)

On vérifie directement dans la partie html, si la variable isLoading est égale à true :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/e028291b-1d5a-4bfd-9c98-468d8ab9713b)

## Partie 4 :

Dans cette partie, on va continuer sur la même application pour montrer les éléments de base pour mettre en place une partie authentification.

On va faire juste quelque chose temporaire, on va dire un fake backend, donc ce qui fait nous allons monter notre système d’authentification sur quelque chose qui n’est pas vraiment sécurisé dans la base, mais après par la suite on va revenir au partie backend encore pour travailler avec Spring pour mettre en place Rest API, et on va la sécurisé, donc on va essayer de voir avec Spring Security, Json web token, comment aborder la sécurité, et comment sécuriser le backend. Et après par la suite, on va adapter en quelque sorte notre frontend, que nous avons développé avec Angular à notre backend pour sortir avec un exemple d’application complet.

Maintenant nous voulons qu’on démarre l’application, va démarrer avec un formulaire d’authentification, alors pour se faire, nous aurons besoin de créer un composant login :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/b47bbb30-182f-4f22-97df-945a705a9df0)

Passons pour créer un formulaire simple dans notre fichier login.html, et on fait la liaison de notre formulaire et nos champs avec ce qu’on va déclarer dans le component à la suite, aussi on créer une méthode handleLogin qui affiche les valeurs d’authentification :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/ad4773ed-6fe7-4ccf-ad37-7f98e01a2821)

Donc bien sûr, on va comme la dernière fois dans login component, déclarer un formulaire, et définir la méthode handleLogin :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/8a2dee27-039f-4f86-bd57-f5b931a185b0)

Après on ajoute le route de ce composant, puis on ajoute un path pour qu’il nous rediriger vers la page login si on fait rien :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/ddca97b1-7aac-48c8-ab83-61bc0f109965)

On démarrant l’application, on voie que notre formulaire a été bien afficher :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/694308a7-ad81-478b-b16e-bec0232643af)

Le problème maintenant, c’est qu’on ne veut pas afficher les autres component, lorsqu’on est dans la page d’authentification, ce qui fait, on va créer donc un composant ou bien une template qui concerne la partie admin, c’est-à-dire il y a une interface qui ne va être visible qu’une fois nous avons authentifiées. Pour cela le plus simple c’est de créer un composant que l’on appelle admin-tamplate :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/fdf42691-7911-4e3e-b20b-c988ec8ee6fb)

Puis on va supprimer le header de notre fichier app.component.html et on le replace dans le ficher html de notre composant admin-template :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/bfb6351f-c512-4302-885e-65ef15ee32ea)

Alors on veut afficher que le formulaire d’authentification, et celui-ci qui va nous permettre d’aller vers les autres pages, don ce qui fait on va changer les routes, c’est à dire on va ajouter un path vers notre composant admin-template, et on remplace les autres à l’intérieur de ce composant on utilisant le tableau children :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/bef506d3-80d8-42a5-b867-7096b6da57e7)

On redémarre l’application, pour voir que nous avons le formulaire sans header, et que pour accéder à un composant il faut créer /admin/composant :



Mais la suppression et la modification ne fonctionne pas, car on doit modifier les URLs en ajoutant le /admin (on va le faire après), alors ça c’est la première de chose, alors maintenant on va vers notre login et en fait un test que lorsqu’on fait l’authentification avec username admin et password 123 et on clique sur le bouton il affiche le composant admin-template :

Mais on voie que les boutons ne fonctionnent pas, donc c’est le temps de changer les routes :


Donc on redémarre l’application, pour voir que tous se passe bien :


Jusqu’à maintenant on n’a pas fait l’authentification car on n’a pas protégé, ce que nous allons fait à la suite en utilisant les guards.
Le guard c’est un service Angular qui va tout simplement vérifier si les routes nécessitent une condition.
Maintenant on va vers notre fichier db.json pour ajouter une collection des utilisateurs qui ont le droit d’accéder à l’application, on utilise les tokens qui contiennent le jwt token qu’on a pris du site jwt.io et on a encodé le password avec base64 :
Voilà la liste des utilisateurs sous format json :


Maintenant on va créer un autre service que l’on va appeler auth :
On passe pour créer une méthode « async » que l’on appelle login, et qu’il attend à récupérer l’utilisateur en utilisant le mot « await », et le « firstValueFrom » qui rend l’observable en promise, et après il décode le mot de passe avec « atob », puis le vérifier, ensuite on utilise jwtDecode après qu’on l’installe pour décoder notre token afin de récupérer nos données, si le mot de passe est correct tout se passe bien, sinon un message d’erreur se lever.
Voilà d’abord comment installer jwt-decoder :



Et voilà le code de cette partie :
Après on va vers le login, et on injecte notre authService, et on spécifie le route que l’on diriger vers si le tout est bien, sinon on récupére le message qu’il va s’afficher :
On va maintenant pour ajouter l’authState dans le fichier app-state.service, donc on déclare une variable appState dans laquelle on va stocker les informations de l’utilisateur, et on va créer aussi une méthode setAuthState dans laquelle on va créer une copie et on va ajouter les attributs qui se trouve dans state :
On ajoute quelque code dans le fichier html du composant login, pour qu’il affiche le message d’erreur :

On démarre l’application, et on essaye de lui donner un mot de passe incorrect :
Maintenant on veut afficher à côté les informations de l’utilisateur qu’il est connecté, pour cela on va vers le navbar et on fait un test, c’est que si l’utilisateur est connecté on afiche un bouton logout sinon on affiche login :



Puis on définit les méthodes logout et login :
	Voilà comment s’affiche :



C’est le temps maintenant de protéger les routes par des autorisations, donc là qu’on va utiliser les guards, allons pour les créer :
On va vers authentication guard et on retourne l’utilisateur s’il est authentifié :



Pour pouvoir utiliser ce guard, on va vers le module des routes, et on ajoute can activate à notre route admin, pour que nous disions que cette route est protégée avec ce guard :
Pour les tester on va démarrer l’application et on tape /admin manuellement et on voie que ça marche pas :



Maintenant on veut qu’il nous redirige vers la page login, au lieu d’afficher une page vide, pour ça on change un peu dans le guard :
Alors maintenant on passe pour qu’on donne le droit de supprimer, d’ajouter et d’éditer un produit qu’à l’admin, pour cela on va vers le guard authorization pour qu’on fait une vérification est ce que les rôles de l’utilisateur contient le rôle admin pour le donner le droit :



Dans le module des routes, on ajoute can Activate, à notre composant d’ajout :
On teste l’application avec l’user1, et on voit qu’il ne lui donne pas le droit d’ajouter un produit :


Alors on va créer un composant que l’on appelle not-authorized :
Et on va créer un peu de code pour afficher un message d’erreur :
On ajoute ce composant dans notre route admin :



Après on ajoute une ligne de code dans notre guard pour qu’il affiche le message d’erreur aux utilisateurs qui n’ont pas le droit d’ajouter un produit :
Maintenant on passe pour faire la même chose pour l’édition :




Pour la suppression elle a pas une route, donc va la masquer, aussi que pour l’édition et le check :
Voilà le résultat :




On peut améliorer les guards pour ne pas écrire le rôle ADMIN ou autre, pour cela on créer une liste des rôles dans le module des routes :
Pour le guard maintenant, au lieu d’accéder à admin on va utiliser la route d’ActivatedRoute pour accéder à notre rôle :



NB : tout ce qu’on fait dans cette partie est un faut backend, on a protégé juste le frontend.

# Troisième partie :
## A.	Développer et Tester la partie Backend avec Spring :
Dans cette partie, on va créer une autre application qui gère des étudiants qui ont fait plusieurs paiements, on travaille sur le backend puis le frontend et ensuite on va voir comment les combiner.
Tout d’abord on va créer l’application, et on ajoute les dépendances :



Puis on va créer les packages que nous avons besoin.
On commence par les entities, on a deux Student et Payement et pour cette dernière on a deux classes de type énumération, on a défini aussi les annotations que nous avons l’habitude d’utiliser :


Après on va dans les repository pour gérer les étudiants, on va créer une interface StudentRepository, dans laquelle on va définir une méthode pour chercher un étudiant par son code, et une deuxième méthode qui va retourner la liste des étudiants d’une filière donnée :



Puis de la même manière, on va créer une deuxième repository pour gérer les paiements, donc on va créer une interface PaymentRepository, dans laquelle on va définir une méthode pour retourner les paiements de l’étudiant, et une deuxième méthode pour retourner les paiements selon un status, et aussi une troisième pour chercher la liste des paiements par type :
Après on veut faire un test, dans notre application on va remplir d’abord notre base de données avec des données, puis on va créer des paiements pour chaque étudiant :

Avant de tester on va configurer notre base de données :
Et on va créer un web service, un Rest controller dans notre packege web, on crée un RestController que l’on appelle PaymentRestController, dans lequel on va injecter StudentRepository et PaymentRepository via le constructeur, et on va créer une méthode pour consulter la liste de tous les paiements pour les retourner, et une pour consulter les paiements sachant l’id, et autre pour consulter tous les étudiants, et une pour consulter un étudiant sachant son code, autre pour consulter les étudiants d’une filière, et une pour les paiements de l’étudiants, et aussi une pour les paiements par status, et la dernière pour consulter les paiements par type :
On passe pour tester l’application, on trouve une exception qui signifie que dans le mapping de notre Rest Controller on a une ambiguïté :


Justement ce problème se lève car on a /payements utilisé plusieurs fois, donc allons pour régler le problème on changeant le mapping des méthodes paymentsByStatus, et PaymentsByType, puis on lançe l’application pour voir qu’il n’a pas de conflit :
On teste notre application :


Pour tester les API Rest Full, on a un moyen beaucoup plus pratique c’est d’utiliser la documentation swagger, donc pour le faire on ajoute une dépendance à notre fichier pom.xml :
On redémarre l’application et on va dans le serveur pour faire appel au swagger-ui.html :
Nous avons vu comment s’affiche, donc on passe pour tester tous les méthodes, on cite ici juste un exemple, et on peut appliquer pour les autres :
On va ajouter une méthode aussi qui permet de mettre à jour le statut de paiement, et on redémarre l’application :



Pour tester on actualise le server, et on modifier par exemple l’id 1 en VALIDATED :
Les données sont stockées dans la base de données h2, donc voilà on a bien les deux tables student et payment :



Donc il nous reste d’ajouter un paiement, c’est l’occasion de voir aussi comment faire upload.
On va créer une méthode pour ajouter un paiement : 




On teste et on voie que le paiement a été créé avec le file :

On vérifie si le file existe, et s’il est dans le bon endroit, et que ce file a été bien créé dans la base de données :



Maintenant on va créer une méthode qui nous a permet de consulter ce file :
On teste dans le server :



Pour respecter les bonnes pratiques on remplace les méthodes ayant un traitement dans un service PaymentService que l’on injecte et on utilise dans le PaymentRestController :

## B.	Développer la partie frontend en utilisant Angular avec Angular Material pour la partie design :
Dans cette partie on va créer le frontend avec angular.
Dans le même projet précédent on va créer un dossier que l’on appelle frontend-ang, et on créer notre projet angular dans le terminal comme suit :
Alors maintenant on va installer Angular Material (C’est un framework de design qui à peu près nous donne les mêmes fonctionnalités que nous trouvons dans bootstrap ou encore mieux avec des web components) :
On démarre l’application :
Donc ce qu’on fait, on va générer un composant que l’on appelle admin-template :

On va donc afficher ce composant dans app.component :
Maintenant on crée une barre de navigation dans admin-template, avec une sidebar :




Pour que ces balises d’angular material fonctionnent on a ajouté des modules :
Alors on passe pour faire notre système de navigation, d’abord on va créer les composants (on va citer ici un seul exemple de home et c’est le même pour les autres) :



Puis on va déclarer les routes :
Donc on va utiliser ces routes dans notre système de navigation, et on voie qu’il marche bien :


Maintenant on va mettre à jour nos composants, en prend comme exemple home, et on le fait de la même manière pour les autres et on teste :
Il nous reste le bouton de menu, qu’il doit afficher et masquer le menu, c’est simple on va créer un id pour le menu que l’on appelle dans le bouton en utilisant toggle :



On veut que notre application quand il démarre affiche un formulaire d’authentification, alors dans app.component on va utiliser router-outlet au lieu d’admin-template :
Après on suppose que le route par défaut c’est login, alors on le déplace en haut et on ajoute un autre route pour que s’il ne fait rien il affiche le formulaire d’authentification aussi :


Alors allons pour compléter la page d’authentification :
Jusqu’à maintenant on n’a pas un système d’authentification en backend, on va bricoler un qui est basique en frontend.
Pour cela maintenant on va voir comment récupérer les données du formulaire, tout d’abord on va importer un module qui s’appelle ReactiveFormsModule :


Maintenant dans notre composant login, on va déclarer notre formulaire, et l’initialiser :
 On doit faire la data binding, ça veut dire lier les champs du formulaire avec ses variables :



On va ajouter un click dans notre bouton qui fait appelle à la méthode login qu’on va créer après :
Passons pour définir la méthode login dans laquelle on va récupérer le username et le mot de passe :



Nous allons en train de créer un système d’authentification basique, pour cela on doit créer un service :
Dans ce service on fait une vérification du mot de passe saisie par l’utilisateur est le mot de passe stockées déjà, on précise les rôles aussi pour chaque utilisateur :


Revenons maintenant à notre composant login pour terminer la définition de la méthode login :
N’oublions pas d’ajouter la route d’admin :


On va tester, on se connecte avec le compte admin :


Maintenant on doit changer la structure des routes, les tous doivent être des children de la route admin :
Mais à condition de changer les liens dans admin-template en ajoutant /admin :


Notre système d’authentification n’est pas complet car on doit garder l’utilisateur connecté, alors on fait ça dans notre service auth :
Alors on n’a besoin d’afficher l’utilisateur connecté donc on va vers admin-template et on injecte le service auth, puis on créer un bouton dans la partie html en faisons un teste si l’utilisateur est authentifié, on affiche son nom, ainsi on va ajouter un click dans le bouton logout :


On va créer la méthode logout dans le composant admin-template, qui est a son tour fait appelle à la méthode logout du service auth :
Allons pour redéfinir cette dernière méthode dans notre service :



Mais on a encore un problème c’est que on peut accéder à quelle page via l’url, pour se régler ça on doit protéger les routes, en utilisant guards.
Donc on va créer le guard auth :
Donc on ajoute une ligne de code pour que le guard vérifie si l’utilisateur est connecté ou non :


Alors pour que ce service fonctionne on doit le déclarer dans le module premièrement :
Deuxièmement il faut protéger les routes :


Maintenant on passe pour ajouter autre guard pour que l’on diversifié les roles d’Admin et User.
On crée un guard authorization, et on ajoute ce guard dans le module des routes :
Après on applique ce guard aux routes que nous voulons :


Revenons à notre guard, on va récupérer les roles, et on vérifie si l’un des roles existe comme ceux qui sont requis, puis on teste l’application on se connectant en tant que user pour voir que load students et payments ne fonctionnent pas :
Dès qu’ils ne fonctionnent pas donc on va les masquées, pour cela on ajoute une condition :
