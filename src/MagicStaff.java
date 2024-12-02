public class MagicStaff implements Equipment {
    private int level = 1;
    private int[] stats = {1, 0, 0, 0, 50, 0, 0, -1}; // Level, HP, MP, P.ATK, M.ATK, P.DEF, M.DEF, Speed
    private Character equipper;

    @Override
    public void upgrade() {
        level++;
        stats[4] += 5*level;
        stats[7] += 1;
        System.out.println("Magic Staff upgraded to level " + level);
    }

    @Override
    public int[] getStats() {
        return stats;
    }

    @Override
    public String getType() {
        return "Magic Staff";
    }

    @Override
    public void setEquipper(Character equipper) {
        this.equipper = equipper;
    }

}
