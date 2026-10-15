import composant.Boisson;
import composant.Sumatra;
import decorateur.Caramel;
import decorateur.Chocolat;

void main() {
    // 1. Order a basic Sumatra
    Boisson b = new Sumatra();
    System.out.println(b.getDescription());
    System.out.println(b.cout());

    System.out.println("-----------------------");

    // 2. Add Chocolate
    b = new Chocolat(b);
    System.out.println(b.getDescription());
    System.out.println(b.cout());

    System.out.println("-----------------------");

    // 3. Add Caramel
    b = new Caramel(b);
    System.out.println(b.getDescription());
    System.out.println(b.cout());

    System.out.println("-----------------------");

    // 4. "Double Chocolate" - Chaining in one line
    Boisson b2 = new Chocolat(new Caramel(new Chocolat(new Sumatra())));
    System.out.println(b2.getDescription());
    System.out.println(b2.cout());
}