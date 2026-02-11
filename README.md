# Projet Full Stack Voitures

Ce projet comprend :  
- **Backend** : Spring Boot + MariaDB  
- **Frontend** : React JS  
- **Base de données** : MariaDB  

---

## 1️⃣ Prérequis

Avant de commencer, assurez-vous d'avoir installé :  
- [Docker](https://www.docker.com/)  
- [Docker Compose](https://docs.docker.com/compose/)

---

## 2️⃣ Structure des ports

| Service      | Port conteneur | Port hôte (accès utilisateur) |
|-------------|----------------|-------------------------------|
| Backend     | 8080           | 8081                          |
| Frontend    | 3000           | 3000                          |
| MariaDB     | 3306           | 3307                          |

> Remarque : Les ports sur la machine hôte peuvent être modifiés dans le fichier `docker-compose.yml` si nécessaire.

---

## 3️⃣ Lancer le projet

1. Cloner le projet :  

git clone <URL_DU_PROJET>
cd <NOM_DU_PROJET>

2. Lancer Docker Compose :

docker-compose up --build

- L'option --build permet de recompiler les images si elles ont été modifiées.

- Cette commande va créer et démarrer 3 conteneurs :

  - mariadb-db (MariaDB)

  - springboot-voiture (Backend Spring Boot)

  - react-voiture (Frontend React)

Vérifier que les conteneurs tournent :

docker ps

## 4️⃣ Accéder à l'application

Frontend React : http://localhost:3000

Backend Spring Boot : http://localhost:8081/api/voitures

MariaDB : port 3307 pour se connecter depuis un outil SQL externe.
## 5️⃣ Remarques importantes

Si le port 8081 ou 3000 est déjà utilisé sur votre machine, vous pouvez le changer dans docker-compose.yml.

Le backend Spring Boot écoute toujours 8080 dans le conteneur (config SERVER_PORT=8080).

Le frontend React écoute toujours 3000 dans le conteneur.
