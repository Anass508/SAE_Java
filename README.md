# SAÉ R201 — FindMyWord (Bases de la programmation orientée objet)

Projet développé dans le cadre de la SAÉ R201 (BUT Informatique, IUT de Villetaneuse). L'objectif est de concevoir et d'implémenter en Java un jeu de devinette de mots (inspiré de Wordle) en respectant les principes de la programmation orientée objet (POO).

---

## Présentation du Projet

* **Jeu :** FindMyWord
* **Principe :** Deviner un mot secret de 5 lettres en 6 tentatives maximum.
* **Indications après chaque essai :**
  * `OK` : lettre correcte et bien placée.
  * `PRESENT` : lettre présente mais mal placée.
  * `ABSENT` : lettre absente du mot.
* **Langage :** Java (POO)
* **Execution :** En ligne de commande (Terminal)

---

## Architecture POO & Modélisation

Le projet applique les principes clés de la POO (encapsulation, héritage, polymorphisme) :

* **`Game`** : Gère la logique de la partie, l'analyse des coups et la grille.
* **`Word`** : Encapsule les règles métier des mots (5 lettres, uniquement des caractères alphabétiques, pas de lettres répétées).
* **`WordRepository`** *(Classe abstraite)* : Définition polymorphique de la récupération du mot secret.
  * **`JsonWordRepository`** : Extrait un mot aléatoire depuis le fichier JSON (`words.json`).
  * **`FixedWordRepository`** : Fournit un mot fixe pour le déroulement des tests.
* **`Main`** : Point d'entrée du programme.

---

## Binome 
* **Anass Fathi**
* **Anis Rocher**
