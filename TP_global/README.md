Sohail
Charef GLSID 3
 
1)  Le pattern Composite est utilisé ici car il permet
de traiter de manière identique des objets individuels (comme un Cercle ou un
Rectangle) et des conteneurs d'objets (un Groupe de figures). Grâce à
l'interface commune Figure, le code client peut appeler l'opération dessiner()
sans avoir à vérifier s'il manipule une simple forme ou tout un ensemble de
formes imbriquées. Cela rend la gestion de l'arborescence totalement
transparente.
 
 
 
2)   Cette situation
combine deux patterns pour répondre à deux besoins distincts :
Le pattern Template Method permet de définir le squelette de
l'algorithme dans la classe mère abstraite Plugin. Il fige l'ordre d'exécution global, tout
en forçant (via des méthodes abstraites) le développeur à fournir le code
spécifique des partie1 et partie2 dans les
classes filles.
Le pattern Factory (Fabrique) répond à la seconde contrainte :
masquer la création de l'objet. L'application cliente demande un plugin à la FabriquePlugin, qui instancie la classe concrète en
coulisses et la retourne sous son type abstrait (Plugin). Ainsi, le client reste
totalement indépendant de l'implémentation.
 
 
 
3)   Le pattern
Decorator est la solution
idéale pour ajouter dynamiquement de nouvelles responsabilités à un objet sans
modifier son code d'origine. En créant un décorateur qui implémente la même
interface (IComposant) et qui "enveloppe" l'objet de base grâce à la
composition, on peut facilement intercepter l'appel à la méthode traitement()
pour insérer des actions personnalisées juste avant ou juste après son
exécution.
 
 
 
4)   Le pattern Observer est la solution parfaite ici pour
garantir un couplage faible. La classe Joueur joue le rôle du sujet observé
(Observable) : elle garde une liste d'observateurs mais ne connaît que leur
interface commune (IObserver). Dès que son score change, le Joueur appelle
automatiquement la méthode update() de tous les éléments inscrits (Couloir,
Caméra, Gardien) pour les avertir, sans avoir besoin de connaître leur code
interne.
 
 
 
 
 