public class Pokemon {

    private final String name;
    private final String type1;
    private final String type2;
    private final int hp;
    private final int defense;

    private double damageTaken;

    public Pokemon(String name, String type1, String type2, int hp, int defense) {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.hp = hp;
        this.defense = defense;
        this.damageTaken = 0;
    }

    public String getName() {
        return name;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    public int getHp() {
        return hp;
    }

    public int getDefense() {
        return defense;
    }

    public void addDamage(double damage) {
        this.damageTaken += damage;
    }

    public double getDamageTaken() {
        return damageTaken;
    }
}
