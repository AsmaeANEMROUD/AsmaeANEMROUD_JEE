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

