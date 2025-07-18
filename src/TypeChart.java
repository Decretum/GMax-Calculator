import java.util.Map;

public class TypeChart {

    private static final double N = 1; // Neutral
    private static final double R = 0.625; // Resisted damage
    private static final double S = 1.6; // Super effective
    private static final double I = 0.390625; // Immunity (counts as double resist in GO)


    private static final Map<String, Integer> TYPES = Map.ofEntries(
            Map.entry("Normal", 0),
            Map.entry("Fire", 1),
            Map.entry("Water", 2),
            Map.entry("Electric", 3),
            Map.entry("Grass", 4),
            Map.entry("Ice", 5),
            Map.entry("Fighting", 6),
            Map.entry("Poison", 7),
            Map.entry("Ground", 8),
            Map.entry("Flying", 9),
            Map.entry("Psychic", 10),
            Map.entry("Bug", 11),
            Map.entry("Rock", 12),
            Map.entry("Ghost", 13),
            Map.entry("Dragon", 14),
            Map.entry("Dark", 15),
            Map.entry("Steel", 16),
            Map.entry("Fairy", 17)
    );
    private static final double[][] MODIFIERS = {
        {N, N, N, N, N, N, N, N, N, N, N, N, R, I, N, N, R, N},
        {N, R, R, N, S, S, N, N, N, N, N, S, R, N, R, N, S, N},
        {N, S, R, N, R, N, N, N, S, N, N, N, S, N, R, N, N, N},
        {N, N, S, R, R, N, N, N, I, S, N, N, N, N, R, N, N, N},
        {N, R, S, N, R, N, N, R, S, R, N, R, S, N, R, N, R, N},
        {N, R, R, N, S, R, N, N, S, S, N, N, N, N, S, N, R, N},
        {S, N, N, N, N, S, N, R, N, R, R, R, S, I, N, S, S, R},
        {N, N, N, N, S, N, N, R, R, N, N, N, R, R, N, N, I, S},
        {N, S, N, S, R, N, N, S, N, I, N, R, S, N, N, N, S, N},
        {N, N, N, R, S, N, S, N, N, N, N, S, R, N, N, N, R, N},
        {N, N, N, N, N, N, S, S, N, N, R, N, N, N, N, I, R, N},
        {N, R, N, N, S, N, R, R, N, R, S, N, N, R, N, S, R, R},
        {N, S, N, N, N, S, R, N, R, S, N, S, N, N, N, N, R, N},
        {I, N, N, N, N, N, N, N, N, N, S, N, N, S, N, R, N, N},
        {N, N, N, N, N, N, N, N, N, N, N, N, N, N, S, N, R, I},
        {N, N, N, N, N, N, R, N, N, N, S, N, N, S, N, R, N, R},
        {N, R, R, R, N, S, N, N, N, N, N, N, S, N, N, N, R, S},
        {N, R, N, N, N, N, S, R, N, N, N, N, N, N, S, S, R, N}
    };

    public static double getModifier(String attackingType, String defendingType) {
        if (defendingType == null) {
            return 1;
        }
        return MODIFIERS[TYPES.get(attackingType)][TYPES.get(defendingType)];
    }

    public static double getModifier(String attackingType, String defendingType1, String defendingType2) {
        return getModifier(attackingType, defendingType1) * getModifier(attackingType, defendingType2);
    }

}
