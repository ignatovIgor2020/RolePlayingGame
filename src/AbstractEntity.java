public abstract class AbstractEntity implements Fighter {

    private int health; // здоровье
    private int gold; // золото
    private int dexterity; //ловкость
    private int practice; // опыт
    private int hitStrenght; // сила удара
    private String name; // имя сущности

    public AbstractEntity(String name, int health,int hitStrenght,  int dexterity, int practice, int gold) {
        this.name = name;
        this.health = health;
        this.gold = gold;
        this.dexterity = dexterity;
        this.practice = practice;
        this.hitStrenght = hitStrenght;
        
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getPractice() {
        return practice;
    }

    public void setPractice(int practice) {
        this.practice = practice;
    }

    public int getHitStrenght() {
        return hitStrenght;
    }

    public void setHitStrenght(int hitStrenght) {
        this.hitStrenght = hitStrenght;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int attack() {
        if ((dexterity * 3) > ((int)(Math.random() * 100)))
            return hitStrenght;
        else 
            return 0;
    }

    @Override
    public String toString() {
        return String.format("%s здоровье: %d", name, health);
    }
}
