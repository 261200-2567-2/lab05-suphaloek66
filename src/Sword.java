public class Sword implements Equipment {
    private int level = 1;
    private int[] stats = {1, 0, 0, 20, 0, 0, 0, -1}; // Level, HP, MP, P.ATK, M.ATK, P.DEF, M.DEF, Speed
    private Character equipper;

    @Override
    public void upgrade() {
        level++;
        stats[3] += 5; // Increase P.ATK
        stats[7] -= 1; // Decrease Speed
        System.out.println("Sword upgraded to level " + level);
    }

    @Override
    public int[] getStats() {
        return stats;
    }

    @Override
    public String getType() {
        return "Sword";
    }

    @Override
    public void setEquipper(Character equipper) {
        this.equipper = equipper;
    }

}