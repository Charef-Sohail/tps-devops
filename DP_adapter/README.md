# Design Pattern Adapter

## Catégorie : Structure

Le pattern **Adapter** permet de faire collaborer deux interfaces incompatibles. Il convertit l'interface d'une classe existante vers l'interface attendue par le client, sans modifier les classes concernées.

## Objectifs

- Adapter l'interface d'une classe existante à celle attendue par le client.
- Faire communiquer des composants initialement incompatibles.
- Réutiliser une classe existante sans modifier son code.
- Isoler la conversion dans un objet dédié.

## Raison d'utilisation

Un client doit utiliser une classe dont l'interface ne correspond pas à celle qu'il attend. L'adaptateur sert alors d'intermédiaire entre le client et la classe adaptée.

## Résultat

Le client continue d'utiliser l'interface qu'il connaît, tandis que l'adaptateur traduit les appels vers l'interface de la classe adaptée. Le couplage entre les deux composants reste limité et leur code n'a pas besoin d'être modifié.

## Structure de l'implémentation

- `Vga` : interface attendue par l'unité centrale.
- `UniteCentrale` : client qui envoie des messages via une connexion VGA.
- `Ecran` : implémentation directe de l'interface `Vga`.
- `Hdmi` : interface utilisée par les téléviseurs.
- `Tv` : classe adaptée qui affiche des données reçues sous forme de `byte[]`.
- `HdmiVgaAdapter` : adaptateur qui implémente `Vga` et convertit les messages en données compatibles avec `Hdmi`.
- `Main` : démonstration de l'affichage direct sur un écran, puis de l'affichage sur une TV via l'adaptateur.

## Fonctionnement de l'exemple

1. L'unité centrale est connectée directement à un `Ecran` grâce à l'interface `Vga`.
2. Le message `Bonjour (via Ecran direct)` est affiché directement.
3. Une `Tv` est créée avec son interface `Hdmi`.
4. `HdmiVgaAdapter` est connecté à la TV.
5. L'unité centrale utilise l'adaptateur comme s'il s'agissait d'un périphérique VGA.
6. L'adaptateur convertit le message en tableau d'octets et le transmet à la TV via `view`.

## Exécution

Depuis le dossier `DP_adapter`, compiler le projet avec Maven :

```bash
mvn compile
```

Le point d'entrée de la démonstration est la classe `Main`.
