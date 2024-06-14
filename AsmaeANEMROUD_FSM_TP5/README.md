Asmae ANEMROUD                                                                                                                
Systèmes distribuées                                                                                                             
MIAAD                                                                                                                       
Promotion: 2023-2025

                                                 Compte rendu JEE/TP5

# Web services SOAP WSDL :

Dans la première partie, on a parlé des concepts fondamentaux des Web Services. Principalement, les trois concepts fondamentaux SOAP, WSDL, UDDI. Il est question de mettre en œuvre un exemple de Web Service basé sur SOAP en utilisant Jax-ws. Pour cela, nous allons utiliser une spécification javaxws qui fait partie des spécifications JEE. 

Pour créer un web service basé sur SOAP pour les applications Java, en utilisant Javax Ws, c'est très simple. Ici, on va créer une classe banque service. Tout simplement, c'est une classe qui va être utilisée des annotations Jax-ws. 

L’annotation qui permet d'indiquer qu'il s'agit d'un web service, c'est WebService. Pour spécifier le nom du web service, on peut utiliser ServiceName. Par exemple, Banque WS. Et chaque méthode, par exemple, on a une méthode conversion qui reçoit un montant en input et qui permet de retourner le montant, plutôt de convertir ce montant de l'euro en dirham. Et donc chaque méthode, pour qu'il fasse partie des méthodes du web service, il va utiliser l’annotation web méthode. Et donc pour attribuer un nom à l'opération, on va utiliser operation name. Donc, operationName, ça permet de spécifier le nom de l'opération.

Si nous ne mettons pas operationName par défaut, il va prendre le même nom que la méthode. 

Et après, il y a les paramètres. Ici, le paramètre s'appelle MT. Au niveau du web service, nous voudrons l'appeler Montant. Donc, on va utiliser l'annotation WEPARAM (WEPARAM_Name = Montant). 

Donc, les annotations principales pour créer un web service sont WEPSERVICE. Web méthode et Webparam. 

La même chose nous avons une méthode test, une méthode get compte, une méthode qui permet de consulter la liste des comptes. 

•	On va essayer de montrer comment créer d'abord en premier lieu, le web service. Ça, c'est la première étape. 
•	Deuxième étape, comment déployer le web service à travers un serveur Jax-ws, simple dans un premier temps. 
•	Et par la suite, on va voir comment on travaille avec Spring, comment déployer un web service basé sur SOAP dans une application Spring. 
•	Après, en troisième lieu, on va essayer de voir avec un browser, on va consulter le WSDL pour l'analyser et voir sa structure. 
•	Et puis, on va voir comment tester les web services en utilisant un outil qui s'appelle SOAPUI, c'est un outil de test des web services. 
•	Et puis, on va créer un client Java qui permet de consommer le web service. 
•	Et après, nous aurons quelques demandes supplémentaires par la suite où nous pouvons consulter si nous voulons voir comment faire ça avec ces c# et comment le faire avec avec PHP.

On crée un projet Java, Maven sans passer par spring.

Dans un package ws, on va créer une classe que nous allons appeler BanqueService qui contient des méthodes pour faire une conversion, récupérer un compte et retourner la liste des comptes :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/3b371362-eccf-4300-bb16-7151c2aedd0c)

Puis on crée une classe Compte qui contient les constructeurs avec les getters et setters :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/162a009d-62ed-44d6-9c03-08843b1ce588)

Alors maintenant, pour que cette classe devienne un web service, on a besoin d'utiliser Jax-ws, pour cela, on a besoin d'utiliser l’annotation WebService et pour l’utiliser il nous faut ajouter une dépendance à notre projet :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/bdeb023d-7004-49e9-a916-a72fbc1608a4)

On utilise l’annotation WebService et on va attribuer un nom BanqueWS à notre classe BanqueService, puis chaque méthode doit être noté webMethod et on lui attribue un nom operationName et on affect pour chaque paramètre l’annotation @WebParam :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/f4d88d99-b999-4671-847a-214ca087ae80)

Maintenant, on a besoin de déployer le website et pour ce faire, on va créer notre propre serveur jax-ws, et on démarre le serveur :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/8b834d9e-75ae-4d2b-9420-7f9102f080fe)

On va démarrer un navigateur web et on va demander le WSDL qui est un document XML qui permet la description de l’interface du webservice.

Si on met rien il s’affiche comme suit (c’est notre service qui répond) :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/0bb8ce60-0a25-4a89-b972-66a3d6516f6f)

Et si on met ?wsdl, il affiche le WSDL :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/819de4b4-22e2-48c3-9890-3059cc23517a)

On arrive maintenant à la quatrième étape c’est comment tester le web service et pour ce faire, nous allons utiliser un outil qui s’appelle SoapUI qui est un outil open source utilisé pour tester les web services basés sur soap.

On lance SoapUI, en lui donne un nom de projet et le lien de notre wsdl :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/8082d4fa-592e-4158-845a-d27aa2adcf52)

On trouve qu’il y a 3 méthodes, on teste la méthode ConversionEuroToDH et on choisit un montant par exemple de 78 Euro, et en envoie la requête pour récupérer le résultat :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/850c17e4-ec04-4e1c-8727-4372ceecb154)

Pour la méthode getCompte, il retourne un compte défini par le code, la date de création et le solde :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/b0831908-d84f-4505-afb7-3b9b762ff482)

On voie que l’attribut de dateCreation est vide, tout simplement parce qu’on a utilisé le format LocalDate, donc on va le changer par Date au lieu, et on crée à nouveau le projet test2 et on teste la méthode à nouveau pour voir le résultat :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/632a26de-2795-4139-a405-11f16ed06667)

On teste la méthode listeComptes aussi :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/8a4a336d-700b-4f7f-b37e-38bf1244971e)

Maintenant, on va créer un client java qui permet de consommer le web service.

On crée un projet fils qui s’appelle client-soap-java dans le même projet ws-soap, et on ajoute les mêmes dépendances de jax-ws qu’on dans le projet précédent.

Puis pour créer le client on a besoin de wsdl pour générer ce qu’on appelle un proxy qui est un ensemble de classes qu’on va générer à partir du wsdl et qui vont permettre à notre application java de communiquer avec le web service, donc on va générer des codes java à partir de wsdl :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/1de41775-9edc-4cc3-ae34-6cbe5825064b)

On va vers notre application client et on fait appelle au web service par l’interface qui s’appelle BanqueService dans proxy et après on va faire appel à la méthode conversionEuroToDH :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/9799c377-8e34-4897-9d70-f0b0ec7994f1)

On va consulter un compte à partir de proxy et on va afficher les informations sur ce compte :
![image](https://github.com/AsmaeANEMROUD/AsmaeANEMROUD_JEE/assets/164891923/14b48a4c-1647-4ea4-b106-d34d59bf9b71)
