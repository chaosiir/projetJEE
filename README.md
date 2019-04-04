#         ReadMe projetJEE

Version: 1.0

Autheurs :
- Colin LUCIANI
- Jules LAGARDE
- Moncef REJEB SFAR
- Nicolas AYALA
- Pascal FERRARIS


## Prérequis :
- un serveur tomcat 9.0
- un serveur mysql

## Installation :

### Setup de mysql :

- créer une nouvelle database "projetJEE"
- soit : créer un utilisateur login:login et mdp:password
- soit : éditer le fichier dans l'archive war : /WEB-INF/classes/config.properties
- éxécuter le script createDB.sql depuis mysql

### setup war :

- importer l'archive projetJEE_war dans un server tomcat 9.0
- lors du premier demarrage du server, les students vont etre télechargé du web service

## Sources du projet :

github : http://github.com/chaosiir/projetJEE
