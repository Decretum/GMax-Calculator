import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final double STAB_BOOST = 1.2;

    private static int applySTAB(int power) {
        return (int) STAB_BOOST * power;
    }

    public static void main(String[] args) {
//        Pokemon blissey = new Pokemon("Blissey L40", "Normal", null, 403, 145);
        Pokemon blissey = new Pokemon("Blissey L50", "Normal", null, 429, 154);
        Pokemon zamazenta = new Pokemon("Zamazenta L50 (with free T3 shield)", "Fighting", "Steel", 173 + 60, 257);

        List<Move> attackingMoves = List.of(
                new Move("Blizzard", "Ice", applySTAB(130)),
                new Move("Hydro Pump", "Water", applySTAB(135)),
                new Move("Skull Bash", "Normal", 130),
                new Move("Sparkling Aria", "Water", applySTAB(85)),
                new Move("Surf", "Water", applySTAB(60))
                );

        double blisseyPercentTaken = 0;
        double zamazentaPercentTaken = 0;

        for (Move move : attackingMoves) {
            blisseyPercentTaken += move.getPower() * TypeChart.getModifier(move.getType(), blissey.getType1(), blissey.getType2()) / (blissey.getHp()*blissey.getDefense());
            zamazentaPercentTaken += move.getPower() * TypeChart.getModifier(move.getType(), zamazenta.getType1(), zamazenta.getType2()) / (zamazenta.getHp()*zamazenta.getDefense());
        }

        System.out.println("Blissey:   " + blisseyPercentTaken);
        System.out.println("Zamazenta: " + zamazentaPercentTaken);
    }
}