void main() {
    Context context = new Context();

    Scanner scanner = new Scanner(System.in);

    Map<String, Strategy> strategyMap = new HashMap<>();
    Strategy strategy;

    while (true) {
        IO.print("Saisir la stratégie (ex: 1, 2 ou Default) : ");
        String strategyName = scanner.nextLine();
        try {
            if (strategyName.equals("exit"))
                    break;
            strategy = strategyMap.get(strategyName);

            if (strategy == null) {
                IO.println("=> Création d'un nouvel objet StrategyImpl" + strategyName);
                String className = "M"+strategyName+"StrategyImpl";
                strategy = (Strategy) Class.forName(className).getConstructor().newInstance();


                strategyMap.put(strategyName, strategy);
            }

            context.setStrategy(strategy);
            context.effectuerOperation();

        } catch (Exception e) {
            IO.println("Erreur: Stratégie introuvable. Vérifiez le nom.");
        }
    }
}