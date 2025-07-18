import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final double STAB_BOOST = 1.2;

    private static int applySTAB(int power) {
        return (int) STAB_BOOST * power;
    }

    public static void main(String[] args) {
        // Get values from https://pokechespin.net/dynamax
        List<Pokemon> defenders = getDefenders();

        List<Move> attackingMoves = List.of(
                new Move("Blizzard", "Ice", applySTAB(130)),
                new Move("Hydro Pump", "Water", applySTAB(135)),
                new Move("Skull Bash", "Normal", 130),
                new Move("Sparkling Aria", "Water", applySTAB(85)),
                new Move("Surf", "Water", applySTAB(60))
        );

        for (Move move : attackingMoves) {
            for (Pokemon defender : defenders) {
                defender.addDamage(move.getPower() * TypeChart.getModifier(move.getType(), defender.getType1(), defender.getType2()) / (defender.getHp() * defender.getDefense()));
            }
        }

        System.out.println("Damage taken (less is better)");
        defenders.sort((p1, p2) -> Double.compare(p1.getDamageTaken(), p2.getDamageTaken()));
        for (Pokemon defender : defenders) {
            System.out.println(defender.getDamageTaken() + " - " + defender.getName());
        }
    }

    private static List<Pokemon> getDefenders() {
        Pokemon blissey40 = new Pokemon("Blissey L40", "Normal", null, 403, 145);
        Pokemon blissey50 = new Pokemon("Blissey L50", "Normal", null, 429, 154);
        Pokemon zamazenta = new Pokemon("Zamazenta L50 (with free T3 shield)", "Fighting", "Steel", 173 + 60, 257);
        Pokemon lapras = new Pokemon("Lapras L40", "Water", "Ice", 230, 149);

        List<Pokemon> defenders = new ArrayList<>();
        defenders.add(blissey40);
        defenders.add(blissey50);
        defenders.add(zamazenta);
        defenders.add(lapras);
        return defenders;
    }
}