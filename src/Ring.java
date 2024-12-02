public class Ring implements Accessory {
    private int[] stats = {1, 30, 0, 5, 5, 0, 0, -1}; // Level, HP, MP, P.ATK, M.ATK, P.DEF, M.DEF, SPEED
    private BaseCharacter equipper;

    @Override
    public void upgrade() {
        stats[0]++;
        stats[1] += 10;
        stats[3] += 1;
        stats[4] -= 1;
        System.out.println("Ring upgraded to Level " + stats[0]);
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
        return "Ring";
    }
}