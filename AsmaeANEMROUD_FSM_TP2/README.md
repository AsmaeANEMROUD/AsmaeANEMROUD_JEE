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

