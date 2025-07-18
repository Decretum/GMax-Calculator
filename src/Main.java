import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    // Configure the raid boss moveset here, see below for options
    private static final String RAID_BOSS = "Butterfree";
    private static final double STAB_BOOST = 1.2;

    private static List<Pokemon> configureDefenders() {
        // Get values from https://pokechespin.net/dynamax
        Pokemon blissey40 = new Pokemon("Blissey L40", "Normal", null, 403, 145);
        Pokemon blissey50 = new Pokemon("Blissey L50", "Normal", null, 429, 154);
        Pokemon zamazenta = new Pokemon("Zamazenta L50 (with free T3 shield)", "Fighting", "Steel", 173 + 60, 257);
        Pokemon zacian = new Pokemon("Zacian L50", "Fairy", "Steel", 173, 214);
        Pokemon lapras = new Pokemon("Lapras L40", "Water", "Ice", 230, 149);
        Pokemon latias = new Pokemon("Latias L40", "Dragon", "Psychic", 162, 206);
        Pokemon gengar = new Pokemon("Gengar L40", "Ghost", "Poison", 134, 129);
        Pokemon corviknight = new Pokemon("Corviknight L40", "Steel", "Flying", 186, 163);

        List<Pokemon> defenders = new ArrayList<>();
        defenders.add(blissey40);
        defenders.add(blissey50);
        defenders.add(zamazenta);
        defenders.add(lapras);
        defenders.add(latias);
        defenders.add(zacian);
        defenders.add(gengar);
        defenders.add(corviknight);
        return defenders;
    }

    private static List<Move> configureRaidBoss() {
        Map<String, List<Move>> options = new HashMap<>();
        options.put("Lapras", List.of(
                new Move("Blizzard", "Ice", applySTAB(130)),
                new Move("Hydro Pump", "Water", applySTAB(135)),
                new Move("Skull Bash", "Normal", 130),
                new Move("Sparkling Aria", "Water", applySTAB(85)),
                new Move("Surf", "Water", applySTAB(60))
        ));
        options.put("Latias", List.of(
                new Move("Thunder", "Electric", 100),
                new Move("Psychic", "Psychic", applySTAB(95)),
                new Move("Outrage", "Dragon", applySTAB(110))
        ));
        options.put("Latios", List.of(
                new Move("Dragon Claw", "Dragon", applySTAB(45)),
                new Move("Psychic", "Psychic", applySTAB(95)),
                new Move("Solarbeam", "Grass", 180)
        ));
        options.put("Butterfree", List.of(
                new Move("Bug Buzz", "Bug", applySTAB(95)),
                new Move("Signal Beam", "Bug", applySTAB(75)),
                new Move("Psychic", "Psychic", 95)
        ));


        return options.get(RAID_BOSS);
    }

    private static int applySTAB(int power) {
        return (int) STAB_BOOST * power;
    }

    public static void main(String[] args) {
        List<Pokemon> defenders = configureDefenders();
        List<Move> attackingMoves = configureRaidBoss();

        for (Move move : attackingMoves) {
            for (Pokemon defender : defenders) {
                defender.addDamage(move.getPower() * TypeChart.getModifier(move.getType(), defender.getType1(), defender.getType2()) / (defender.getHp() * defender.getDefense()));
            }
        }

        defenders.sort(Comparator.comparingDouble(Pokemon::getDamageTaken));

        System.out.println(RAID_BOSS + "\n");
        System.out.println("| Damage taken (less is better) | Defender |");
        System.out.println("| ---------- | ---------- |");
        for (Pokemon defender : defenders) {
            System.out.println("| " + defender.getDamageTaken() + " | " + defender.getName() + " |");
        }
    }
}