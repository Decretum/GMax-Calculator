public class Pokemon {

    private String name;
    private String type1;
    private String type2;
    private int hp;
    private int defense;

    public Pokemon(String name, String type1, String type2, int hp, int defense) {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.hp = hp;
        this.defense = defense;
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
}
