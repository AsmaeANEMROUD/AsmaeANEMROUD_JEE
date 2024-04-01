Asmae ANEMROUD                                                                                                           
Systèmes distribuées                                                                                                        
MIAAD                                                                                                                   
Promotion: 2023-2025

                                                   Compte rendu JEE/TP1

# Un petit résumé sur la première partie :
Dans le développement de logiciels, il y a deux parties principales d’une application : le front-end et le back-end.

•	Le front-end, ou côté client, est la partie de l’application avec laquelle les utilisateurs interagissent. Il est généralement construit en utilisant des langages tels que HTML, CSS et JavaScript.

•	Le back-end, ou serveur, est la partie de l’application qui gère le stockage et le traitement des données. Il peut être construit en utilisant des technologies telles que PHP, Java ou .NET.

Il existe trois types d’applications : 

•	les applications Web, 

•	les applications mobiles 

•	et les applications Desktop.

Dans un projet logiciel, il y a des exigences fonctionnelles et techniques :

•	Les exigences fonctionnelles sont les besoins spécifiques de l’entreprise auxquels le logiciel doit répondre.

•	Les exigences techniques comprennent la performance, la maintenance, la sécurité et la gestion des transactions.

Pour répondre aux exigences techniques, il est important de tenir compte de : 

•	La performance, qui peut être réalisée par la Scalabilité verticale (ajout de ressources à un seul serveur) ou horizontale (ajout de serveurs).

•	La maintenance est la possibilité de modifier ou d’étendre une application sans modifier le code.

Pour créer une application facile à maintenir, il est important d’utiliser le principe de l’inversion de contrôle, qui permet aux développeurs de se concentrer sur la logique métier tandis que le framework gère les détails techniques.

L’inversion du contrôle peut être réalisée grâce à l’utilisation d’un paradigme appelé programmation orientée vers les aspects, qui sépare les préoccupations telles que la sécurité, les transactions et l’accès aux données.

Lors de la création d’une application, il est important de séparer la logique de l’interface utilisateur de la logique métier.

Il est également important de considérer le couplage entre les différentes parties de l’application. Le couplage faible, réalisé grâce à l’utilisation d’interfaces, permet une plus grande flexibilité et maintenabilité.

Certains modèles de conception qui peuvent être utilisés pour améliorer la maintenabilité d’une application comprennent le modèle d’injection de dépendance qui permet l’injection de dépendances dans une classe, plutôt que de coder ces dépendances. Cela peut rendre la classe plus flexible et plus facile à tester.

Pour résumer, créer une application maintenable implique de considérer les principes de cohésion et de couplage, d’utiliser des modèles de conception et d’utiliser le principe d’inversion de contrôle. Il est également important de considérer la séparation des préoccupations, l’utilisation d’interfaces et l’injection de dépendances.

# Partie 1 :
## 1.	Créer l'interface IDao avec une méthode getDate :
   ![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/ff8b3785-80ac-46d3-935e-cb83a00bdd91)

## 2.	Créer une implémentation de cette interface :
•	Implémentation DaoImpl :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/a290f550-9ddc-4efd-b086-dc17d0c7212a)

•	Implémentation DaoImpl2 :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/a63ade46-4c8f-414f-8b61-dc95f2305660)

•	Implémentation DaoImplVWS :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/6e61130d-e0dd-4c85-986f-384743171b07)

## 3.	Créer l'interface IMetier avec une méthode calcul :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/f8af51b8-f1ee-490a-acae-f19ce371a93c)

## 4.	Créer une implémentation de cette interface en utilisant le couplage faible :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/c8714d45-eb1e-4198-9c42-3c97294172a5)

## 5.	Faire l'injection des dépendances :
### a.	Par instanciation statique :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/d791e258-d734-4b0e-9e88-07f190c41a7e)
                                                        Version Base de données

![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/558c5d3c-cdfd-4c88-b095-fe0326a3d5a5)
                                                            Version Capteurs

### b.	Par instanciation dynamique :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/f50a71c4-cccd-4252-9a51-6422329fae8a)

Le fichier de configuration « config.txt » :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/73795198-67e1-4fcc-aff6-41a92e5a0cdc)

# Partie 2 :
•	Tester le projet Java de la 1ère partie dans le projet maven :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/27b75aa6-e33a-4d38-9138-edb42fd26966)

![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/38780af6-7704-4917-9528-e82368d34971)

•	Ajouter les dépendances du framework Spring :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/0b8a3c24-7f6c-4231-91e9-e8336a559f22)

### c.	En utilisant le Framework Spring :
               - Version XML :

•	Créer le fichier de configuration « applicationContext.xml » :
Le premier bean sert à créer un objet dao de la classe DaoImpl.
Le deuxième bean sert à créer un objet metier de la classe MetierImpl.
Pour faire l’injection via setter on a utilisé property qui prend le nom dao et fait référence à l’objet dao.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/6a644959-5c11-4e89-836c-a7621df9b9b7)

Ce fichier permet d’afficher la version base de données :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/2f315eba-7bf0-46d2-a823-de10decab981)

De la même manière si on veut afficher la version capteurs on modifier le fichier de configuration :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/db7c90b9-5c58-4427-a758-a5be8d5779fc)

Et le résultat sera :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/bba1cb36-2fd2-411c-89a5-1890f2f00117)

De même pour la version web service :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/e9a39b06-0135-45c7-b10d-ff4130823118)

Et voilà le résultat :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/ece16779-ee4a-4934-a801-6327425ed556)

 		- Version annotations :
Pour utiliser la version annotation en ajoute l’annotation @Compenent("dao") et si comme nous disons à Spring que au démarrage, à chaque qu’il trouve une classe qui commence par cette annotation elle va l’instancier, elle va lui donner comme nom dao.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/5881fa8e-6004-4266-846f-f7e5846e30cc)

•	L’injection via l’annotation Autowired :
Il existe aussi l’annotation @Autowired, c’est comme nous demandons à Spring au moment où tu vas instancier la classe MetierImpl cherche moi un objet de type IDao et si tu le trouve tu vas me l’injecter dans la variable dao, c’est de l’injection des dépendances.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/e977a913-0071-4164-b89e-92033e126c1f)

Le résultat :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/a6edcd40-6cf8-4381-b013-3591328f015a)

•	L’injection via le constructeur :
Créer un constructeur qui reçoit un objet de type IDao.
Cela fait apparaitre une erreur en relation avec la classe Presentation.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/704b1bba-e4b0-4c28-89f6-cda1982ce2b8)

Pour résoudre le problème il suffit d’ajouter l’objet dao au constructeur pour qu’il soit avec paramètre et supprimer la ligne de setter car on n’a plus besoin.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/5d5dcc42-ec08-4e92-894c-c8d23ee9e40c)

NB : il est préférable d’utiliser l’injection via le constructeur que par l’annotation Autowired.
On exécute l’application :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/a7da9166-152a-4210-b6bf-571e14d4ca2e)

Pour la version XML ne va pas marcher car dans le fichier de configuration on a plus de constructeur sans paramètres.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/e0ba5aeb-c67f-4d6d-8b9c-dda03fb7abe6)

utiliser constructor-arg au lieu de property :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/89835710-9234-4e6a-8127-b3baedd8bd08)

Cette fois ci la version XML doit marcher :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/2053e54a-fb0f-494b-9fa0-4cd633ea8fec)

On utilise l’annotation Component pour l’implémentation DaoImpl2 :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/c1043942-60f1-4a2f-a0ac-5a850c87acb4)

Cela va générer un conflit de bean car il ne sait lequel va injecter ce qui lève une exception :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/c33239dc-4faf-4560-aa9c-2deec9531f6d)

Pour résoudre ce problème il faut donner un nom à chaque bean :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/65210af6-762f-4399-a5a0-e94480efb1bb)

Et au niveau de l’annotation Autowired, ajouter l’annotation Qualifier avec le nom du bean :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/c141c93f-5fe5-4658-801d-d15d246d182a)

On exécute :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/17870b83-d7cf-486a-9617-e13bbdaba5be)

Si on fait l’injection via le constructeur, même si on a deux instances il injecte la première qu’il a trouvée dans les beans :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/a1ae277a-94e8-440c-a5fe-38e748b8f43d)

Pour créer un test unitaire il faut ajouter les dépendances de Junit :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/5cc2e125-1fdc-425d-a7e1-1a25e459ff0d)

Ajouter une classe Calcul qui calcule la somme des deux nombres a et b :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/1365e978-728c-4135-999f-68deb614ab34)

Créer un test unitaire CalculTest :

        Si le test est réussi il affiche un truc vert :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/6c7fe646-ee0c-4841-9175-330b4974a188)

        Si ce n’est pas le cas, il affiche une erreur :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/4c129931-9777-4f5c-b237-5cab14f59737)

Dans Intellij nous n’avons pas besoin d’installer maven car il fait partie des outils qui sont dans-il.
On peut exécuter même les commandes de base dans Intellij :

•	Compile :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/8d21ad33-7f31-4656-832f-7b048a35ebd3)

•	Test :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/e8d48515-38aa-4cd9-bc40-072c970d6add)

•	Package :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/0dcab9b3-042f-49ed-8f47-0e0f33a287d4)

•	Install :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/44a6ca66-9e56-4107-aa66-294ad93d2098)

