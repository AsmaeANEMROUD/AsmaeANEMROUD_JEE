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
Dans cette deuxième partie, nous voulons créer une page template pour qu’on avoir par exemple un header fixe (ou bien toutes choses commun) dans toutes les pages sans faire copier-coller à chaque fois.

C’est pour cette raison nous ajoutons les dépendances de Thymeleaf Layout Dialect dans notre fichier pom.xml :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/81d9fe94-a77a-4ae3-b5d2-c4a199aa8478)

Après on va créer un fichier HTML que l’on appelle template1.html :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/559287de-3c55-4ff9-a01b-8900fbaa32e9)

Ensuite, on va l’ajouter dans notre vue patients.html, c’est comme on dit décorer la vue avec template1, et on ajoute aussi le content1 :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/2bb9c289-a966-42e2-96cf-05e898b83973)

On voie que template1 marche :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/aef53057-b674-4c0b-83c7-42d525f0b1af)

On va changer un peu le design de notre header et les éléments pour qu’on puisse faire ajouter un nouveau patient, chercher un patient, et se déconnecter un patient :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/003bc540-67e9-4ff2-b1a5-a90107491b6e)

Et voilà à quoi se rassemble notre nouvelle vue :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/feda8b5d-bb59-4215-9d76-db0bb4119afd)

Passant maintenant à la partie contrôleur, pour faire ajouter un patient on a ajouté une méthode formPatients :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/c4f42ad7-9395-4b90-a3b3-dcc2765e45ff)

Puis on va créer un fichier HTML que l’on appelle formPatients.html, pour générer la vue du formulaire d’ajout :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/346d5df5-4ffc-4e8e-a4ae-8bd89dfc831e)

Notre formulaire est créé :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/d6c1ea0e-3e19-41ea-9f47-c63ca17e95aa)

Il nous reste donc d’ajouter un patient, donc on va vers le contrôleur pour créer la méthode save() :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/7baeec1e-080e-4236-9d92-7c9f532274e4)

Quand on utilise des champs de format date, il faut utiliser l’annotation @DateTimeFormat :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/a4a282fc-1564-4038-93eb-c5e915fd7e08)

On ajoute un patient :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/f8b61e8f-60b6-4c3d-bd9f-2487a8748e12)

On voie dans la dernière page qu’il est ajouté :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/ae1ad7be-e1f4-4c4f-a598-93fb68eaade0)

On passe à la validation, pour ce faire on doit ajouter d’abord la dépendance spring boot validation dans pom.xml :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/a80a3cf6-d772-451e-b836-ed347f61471e)

On revient à notre entité, pour qu’on ajoute des annotations tels que : @NotEmpty c’est-à-dire qu’on n’accepte pas que ce champ soit vide, @Size pour définir le minimum et la maximum des caractères saisies, @DecimalMin pour qu’on dire par exemple qu’on n’accepte pas un score inférieur de la valeur cité :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/1de96b18-26fe-4803-b6e2-b5d88efa826b)

Lorsqu’on démarre l’application on trouve des erreurs, car on n’a dans notre base de données des champs qui sont inférieur à 100 dans le score :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/4e9d2806-153c-4a6f-8ca5-1150e3355179)

Alors on revient l’incrémenter pour avoir régler le problème :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/6c619edb-0b82-497f-9527-f8dfe3af9491)

La deuxième étape pour faire la validation c’est d’ajouter l’annotation @Valid pour qu’on dire à spring mvc une fois que tu stocke les données dans un patient faire la validation, et si jamais il y a des erreurs qui va nous sauter la connexion des erreurs dans une connexion de type BindingResult.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/4ceb870f-5a99-44bb-b81b-36db310c3808)

Pour que ne pas remplir la base de données à chaque fois, on met l’annotation @Bean en commentaire.

Et voilà la validation ça marche :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/ea1eee6c-7133-446e-9792-e4ac123ec0b0)

Maintenant on va ajouter un bouton Edit :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/eefe5ea6-d82f-4990-9585-5a217a89f8eb)

On va donc ajouter la méthode editPatient dans notre contrôleur pour modifier les informations d’un patient :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/071e3364-fc09-48b6-80b8-0539b63e1d85)

On a également créé un fichier HTML, editPatient.html :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/907e010c-d13e-4137-918e-973248a241bf)

Voici la ligne avec l’id 5 avant la modification :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/27b208cb-6275-44d7-8b31-42fb6d318bdf)

On fait la modification :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/89c3caa0-ef0f-4bf0-8904-f4d8f9a0d31c)

Et voilà, la ligne est modifiée :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/917b4ee8-63ee-4d08-899d-9590fc8df0e8)

Il reste encore un petit détail c’est que l’on face toujours, c’est la perte du keyword, pour le régler, comme d’habitude on fait un petit changement dans patients.html :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/06aa1741-7739-48ac-bdad-1009d9f1bbee)

On revient au contrôleur pour stocker dans le model le keyword et la page :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/38a59db2-db66-40ea-9cd2-09b9891dcf8a)

On ajoute les paramètres page et keyword dans save au niveau de th:action :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/bb20d978-f75d-46a3-933d-f5d743152dd6)

On revient les ajouter encore dans la méthode save dans le contrôleur :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/627c95f8-1748-482b-b628-f10228f0ad81)

Voyons maintenant que lorsqu’on fait la modification on reste dans la même page :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/8b9d2542-30c2-4a48-aa27-f24947c06b44)

On modifie la ligne dont l’id est 46 :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/08dca013-cfb9-4591-b47c-c8490723f765)

Et on voie qu’elle est modifiée et on est dans la même page :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/b26592b9-3a58-431f-9bb5-e4b91d5845aa)

On ajouter un lien pour le Home :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/91b2383d-b03a-4511-a7c5-8ccef7cd8ba1)

Et on a caché la zone de texte de l’id, on affiche sa valeur mais on ne peut pas le modifier :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/9efff01c-91bd-4da6-81c0-91ff45641ebe)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/e7a5ebf6-9cd4-452f-a23a-0be63bcdfaa0)

# Partie 3:
- In Memomy Authentication:
Pour cette partie, on a cloné un projet de github qui s’appelle unsecured-hospital-app, puis on a testé le.

Ce projet est le même que celui de la deuxième partie.

Ce que nous intéresse maintenant c’est la sécurité, pour le faire on va tout d’abord ajouter la dépendance security :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/c30dc7e9-ab9f-4421-8f1e-c29793d83e18)

Quand on la télécherge, spring security va déployer, on démarre l’application, quand on accède à l’application, on voie qu’on a une configuration par défaut :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/42931bc5-541d-4938-956b-f43eae51d5e9)

La seule moyenne pour accéder à l’application dans ce moment, est d’utiliser un Username « user », et un mot de page qui est généré :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/17fb5ed8-5990-495a-844f-78ac60f8cdcf)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/3a742aba-f892-47db-96db-fcb6772ccacc)

On veut pas sécuriser l’application de cette manière, on doit personnaliser la configuration. 

Donc pour se faire on va créer une classe SecurityConfig, dont laquelle on travaille avec deux annotations @Configuration et @EnableWebSecurity. 

On utilise également l’annotation @Bean pour que notre méthode s’exécute au démarrage. 

La ligne de configuration sert à nécessiter l’authentification pour toute requête de notre application :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/07400abe-4b47-4c7f-a45d-8003bd8b7bae)

Maintenant quand on veut accéder à l’application, nous n’avons pas autorisé :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/5b02bf23-0181-494e-81c0-e45743ba120a)

Alors on va demander d’ajouter un formulaire d’authentification, pour se faire on ajoute formLogin() :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/14fe34d0-12af-4ad1-8909-5dd63061314d)

Lorsqu’on accède à l’application, un formulaire d’authentification s’affiche :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/402790e6-1bf0-431e-b230-17d0b6d1b35c)

On doit maintenant créer des autorisations pour les utilisateurs, pour cela on utilise un objet de type InMemoryAuthentication, qui permet de préciser au mémoire les utilisateurs qui ont le droit d’accéder à l’application.

On utilise {noop} pour dire à spring security ne pas utliser un password encoder, il va juste comparer le mot de passe tel qu’il est.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/cc09c200-04fa-4202-a670-5866563fb2a7)

L’application ça va marcher :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/c14232a2-955a-4e99-a684-dae131870dc9)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/fdd9359d-8a77-4053-a93d-26b8c38e831f)

D’une manière générale, pour travailler avec spring security on utilise un password encoder BCrypt :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/2b68e00e-4785-4fc6-aca7-fc6de09493ee)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/287c1b0b-516a-4dd9-86aa-5a0362614034)

Maintenant on veut que le nom du user connecté s’affiche au lieu de [User], et aussi ajouter une opération du logout.

Pour afficher l’utilisateur authentifié, on est besoin d’ajouter une autre dépendance thymeleaf extras :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/71a5eb7f-6b6c-495c-8cd7-b0cd350ca11d)

On demande maintenant à spring security via thymeleaf de m’afficher le nom de l’utilisateur qui est authentifié :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/53c8cd48-036b-4e80-983f-2b2bee6035ef)

On voie qu’il marche bien :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/019248ac-722a-4293-8e40-d1d96e4b68cb)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/92b7c11f-7207-47a2-b75a-8f26d8026c8e)

Pour se déconnecter, on a deux méthodes pour faire :

-	Première méthode :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/c6a18dac-4d94-4288-b3f3-754a53cb9506)

-	Deuxième méthode : c’est lorsqu’on ne veut pas passer par un autre bouton logout.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/3b33d231-8c34-492b-b9e9-e3a4e2f3dab3)

Maintenant ce qui nous reste c’est les droits d’accès, car un user c’est pas un admin, donc on va gérer les autorisations, avec deux façons :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/1939b5d6-4e22-4a41-afeb-62f3c40adf42)

On est connecté en tant que user, et lorsqu’on veut supprimer ou modifier un patient une erreur 403 se génère, car on n’a pas données à l’utilisateur le droit de faire ses actions :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/dbae085b-6e89-4c4f-86db-22f35b5c5524)

Si on se connecte en tant que admin, on peut faire tous les actions.

Maintenant lorsqu’on a régler les droits d’accès, ça sert à rien d’afficher à l’utilisateur les actions qu’il le peut pas faire.

Alors on va retirer les boutons pour l’utilisateur :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/1a11ae7c-9c23-40d3-8b8a-23179ce46560)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/0aa379f7-0770-4920-851e-1bb3d91c09a7)

Voilà les boutons sont retirés lorsqu’on se connecte en tant que user :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/1d498f2f-7ee7-402d-ae72-50b76fe2ad7a)

Pour qu’on affiche un message à l’utilisateur comme quoi vous n’avez pas le droit de faire cette fonctionnalité, on va ajouter une configuration :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/5e1236b4-fe5e-4864-b1a2-d7fbccec357c)

Et on ajoute un autre contrôleur SecurityController :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/a7682c9f-83b0-4db0-9107-573b3d2c40c0)

Et aussi une vue notAuthorized.html :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/ade26fbe-ca3d-421a-9a9c-f2b1199fa978)

Il s’affiche comme ça :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/32bca4b2-4b51-49ee-b37d-9ccf6b248fb9)

Maintenant on veut personnaliser le formulaire d’authentification :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/e811daf0-dd94-4474-a043-3747b15c9d76)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/25ad4cff-f27d-4d87-8cb6-200d6bbb4e9e)

On ajoute encore une vue login.html :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/58aad64c-e379-4584-b358-efb3b103d284)

Voilà le nouveau formulaire :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/8c3289a0-a5ec-4814-a894-5a3425d6df9b)

On veut ajouter une case à cocher Remember me :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/2b972848-d67f-431e-adb0-527c843cae33)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/0324a55f-9509-493d-8c54-a8ab20ae26f2)

Voilà la case est ajoutée :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/823341a6-2e2e-4a54-84cc-e5cf4771ff73)

Maintenant on passe pour stocker les données dans la base de données au lieu dans une mémoire.

On protège les données avec l’annotation @EnableMethodSecurity, et @PreAuthorize.
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/3aaa874d-2f9d-4902-9971-5f61aa29d38c)
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/c14a2690-3f6c-434a-b391-4b096f3630ed)

- JDBC Authentication :
