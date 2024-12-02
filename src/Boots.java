public class Boots implements Accessory {
    private int[] stats = {1, 50, 0, 0, 0, 10, 5, 2}; // Level, HP, MP, P.ATK, M.ATK, P.DEF, M.DEF, SPEED
    private BaseCharacter equipper;

    @Override
    public void upgrade() {
        stats[0]++;
        stats[1] += 20;
        stats[5] += 5;
        stats[6] += 2;
        stats[7] += 2;
        System.out.println("Boots upgraded to Level " + stats[0]);
    }

    @Override
    public void setEquipper(BaseCharacter character) {
        this.equipper = character;
    }

    @Override
    public int[] getStats() {
        return stats;
    }

    @Override
    public String getType() {
        return "Boots";
    }

}