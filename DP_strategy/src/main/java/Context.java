public class Context {
    private Strategy strategy;

    public Context() {
        this.strategy = new MDefaultStrategyImpl();
    }

    public void effectuerOperation() {
        System.out.println("--- Début de l'opération ---");

        strategy.operationStrategique();

        System.out.println("--- Fin de l'opération ---");
        System.out.println("=============================================");
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}