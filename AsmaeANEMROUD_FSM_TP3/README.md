Asmae ANEMROUD                                                                                                                
Systèmes distribuées                                                                                                            
MIAAD                                                                                                                       
Promotion: 2023-2025

                                           Compte rendu JEE/TP3
# Partie 1:
Nous avons créé un projet maven pour gérer les patients et on donne le nom de hopital.

Après on a téléchargé les dépendances qu’on avait besoin tels que : Spring Data JPA parce qu’on a besoin d’utiliser une base de données relationnelles, on a aussi la base de données h2, Spring web, le moteur de templates Thymleaf, Lombok, Spring Boot DevTools qui est une dépendance qui va nous permettre de recharger automatiquement les modifications sans redémarrer.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/e49cf500-fe98-4511-9a3a-363f719fd397)

Comme d’habitude nous avons créé les packages entities, repositories, et web.

Dans le package entities, nous avons créé une entité JPA que nous appelons Patient :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/dce9b264-b9a8-4a0d-8d3b-b54a4ccd181e)

Maintenant, on a besoin de faire un test, mais avant on doit créer une interface qui nous appelons PatientRepository :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/22360888-9f17-43cd-83a8-c237b8e7aae9)

Et pour faire le test, dans notre application pour faire un traitement au démarrage le plus simple c’est d’implémenter l’interface CommandLineRunner, et redéfinir la méthode run.

Pour qu’on créer un patient on a trois façons de faire :

-	Soit avec un constructeur sans paramètres (patient).
  
-	Soit avec un constructeur avec paramètres (patient2).
  
-	Avec l’utilisation du Builder (patient3).
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/635bb833-6ed7-4402-b516-71ae1ff470f3)

Mais dans notre cas, nous allons utiliser directement PatientRepository pour enregistrer les patients avec la méthode save() :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/4218477e-68fb-47d5-b393-0fd2414cbb61)

Maintenant, on va passer directement pour tester, donc on ajoute les lignes qui nous a permet de connecter à la base de données dans le fichier application.properties :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/efb00998-839d-4d91-87c1-65d1ca62a4ab)

On démarre l’application :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/c51e662f-d53e-4d5b-be58-4b913b2da9af)

On a consulté la base de données :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/a3b42ae7-b76a-44a6-9aed-713d261dd35f)

Maintenant, on va passer à la partie MVC.

Alors, nous allons créer un contrôleur dans le package web, et que l’on appelle PatientController :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/1c628386-b9d4-4a53-9a36-fc91f8dd6453)

Quand on tape /index, on veut qu’il retourne une vue patient.html, alors on va créer ce fichier HTML dans un dossier qui s’appelle templates, et on le nomme patients.html :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/61d77578-1bbe-45c9-b843-7fb7eaa65bd4)

On redémarre l’application, et on voie qu’elle ça marche :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/c72ca499-a42d-463c-bab2-ba556aecbf66)

Alors maintenant, on veut afficher la liste des patients, on utilise Model pour stocker la liste des patients :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/8484a3f5-ef06-4de5-84bc-b7b1b554daea)

Revenant maintenant à la vue, pour afficher la liste des patients on a besoin d’utiliser Thymeleaf :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/57311483-a72a-4d61-9510-43c7d67d5061)

On redémarre l’application, et on voie la liste des patients :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/fccbf5f9-dfba-4406-99b6-95a7d411dbc1)

La liste est afficher mais la vue n’est pas bon, pour cela on va utiliser Bootstrap, allons donc ajouter les dépendances de Bootstrap dans le fichier pom.xml :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/143e0de0-0d20-4d6f-8503-09aaeda9e75f)

Voilà comment utiliser Bootstrap dans notre fichier HTML :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/f0bc6b03-a444-4b09-bbc0-bda30e9ca88d)

On redémarre l’application pour voir le résultat avec une vue beaucoup mieux :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/71c14420-13e0-41f8-a29d-158225e45f1a)

On a arrangé un peu les choses, du moment qu’on a Bootstrap :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/7ead90ad-3255-4cff-9fcc-be56f1e9b342)

Pour que nous pas redémarrer à chaque fois l’application, du moment qu’on a utilisé devtools on a deux choses pour les activer :

-	On cherche Preferences -> Advanced Settings, et on s’assure que le premier choix dans Compiler est cocher.
  
-	Dans Build, Exécution, Deployement cocher Build project Automaticaly.
  
Voilà l’application après redémarrage automatique :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/db0f95a0-b76f-460e-8d89-d8d3b3484354)

Maintenant on veut basculer de la base de données h2 à MySQL pour faire la pagination.

Comme d’habitude, on doit télécharger les dépendances MySQL, et on change la base de données dans le fichier application.properties :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/bcbc7b9f-fcbb-4967-94a9-97158eec17ff)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/c2a3add2-712b-4c42-b4be-108a02f9296a)

On démarre l’application :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/a103a255-21c2-4d4f-a9bc-0961f2231d0e)

Alors quand on redémarre l’application, elle nous rajouter les données car on n’a pas écrasé la base de données, et c’est fait exprès car on a besoin de plusieurs données pour qu’on puisse faire la pagination :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/4cfc9d52-9231-4472-850c-b17114c463a0)

Elle ça se voie aussi dans notre vue :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/2c462f6c-c793-4a3f-a930-a8da214ff239)

Voilà comment faire la pagination :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/5897f33a-84f3-4233-a350-875686d2868a)

On spécifie dans l’url la page qu’on veut afficher et combien d’éléments :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/fe005f27-0a29-436d-9f81-a961cd9a411f)

L’annotation @RequestParam c’est utiliser pour faire la correspondance entre les paramètres qu’on créer dans l’url et celui qu’on a déclaré.

et pour faire la pagination on a stocké le nombre de pages dans un model.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/9d7a5a9b-7a9c-412d-89c5-396fb612f3d0)

Revenant vers la vue, dont on a ajouté des boutons pour se déplacer d’une page vers l’autre :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/19a8173e-7f2c-49e1-9e18-fd156b6f0cbf)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/586fe1af-77d7-43c5-ba76-caa028cb4fce)

Maintenant, on veut que le bouton de la page courante soit colorié, alors on va stocker dans le model la page courante :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/236c57fb-5b2d-4180-8614-f66408473d40)

Dans notre vue, on a fait un changement :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/e9792971-7f4d-4c03-a72a-6c97bf4b9410)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/a29bf717-d576-427a-80c2-649d8bab08c8)

Maintenant nous voulons ajouter une autre partie pour rechercher des patients.

Alors ce qu’on va faire est créer un formulaire dans notre vue :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/96b48628-88b5-4920-b410-69872b5ebc0a)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/65ebb702-8b2a-474e-a969-30d74111d99e)

Là, il va falloir récupérer le keyword affiché dans l’url pour faire la recherche. 

Donc on a besoin d’ajouter une méthode dans PatientRepository, et il est obligatoire d’utiliser Pageable lorsqu’on travaille avec des pages :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/d65e31a4-3e4d-4b22-925b-3160951eda60)

On fait un changement au niveau de PatientController :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/2c7078e3-4211-45dc-af89-00da2c87c808)

Et voilà, on peut chercher maintenant des patients :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/8831ec8d-9b20-4cf6-a964-bae9c9d67d8f)

Maintenant on veut que la valeur rechercher reste dans la zone de texte, alors ce qu’on fait et de stocker dans le model le keyword, car c’est lui qu’on va transmis dans la zone de texte :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/13a47ecc-2578-4fe6-9134-01b3d608c63e)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/3dae6fcd-96c1-45f6-ab57-a47d34e01251)

Voilà le mot qu’on cherche reste dans la zone de texte :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/663b2f45-260a-41be-9a89-ac3088f65738)

Le problème qui se pose c’est que lorsqu’on appuyer sur un bouton d’une autre page il revient affiche tous les patients et non pas celles recherchés, si on ajoute le keyword dans le lien ça va marcher :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/63d0b74b-3d5e-4c91-8117-51e74481cea5)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/2e8f0b05-3fef-4df7-82fb-8d42b2240182)

Maintenant on veut supprimer un patient, tout d’abord on va créer le bouton delete, puis on ajoute la fonction delete dans le contrôleur :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/2f68a0f7-98d6-49f9-929c-5d9de5f779e1)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/95f1cbd1-feb9-4570-9ebd-61c2334ee880)

On supprime le premier patient :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/3afb8b65-d268-46ea-b265-2f59f16b37ae)

Il reste encore un petit souci c’est lorsqu’on veut supprimer, il faut comme même afficher un message :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/1edd2672-250d-4063-bff0-03ba21f05ed8)

Voilà, on affiche le message de confirmation :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/a5044581-b4f6-450e-8ce5-2334a4c93c5f)

Il reste encore un petit détail, c’est que lorsqu’on supprime il perd le mot clé.

On a sauvé le problème de la même manière qu’on a fait précédemment :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/9364aea5-7c68-4f43-8c4b-a7b8d5779357)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/5f4774e6-abcf-475c-8551-cb68ff80d217)

Voilà maintenant l’application marche correctement, on supprime l’élément 44 et on bascule vers la page 5 sans perdre le keyword :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/f6979580-321e-4b5f-bb01-7fe40b2af775)

A la fin, on a fait des améliorations supplémentaires :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/fcdb7453-8048-46ec-8a58-4c14fd126079)

# Partie 2:
