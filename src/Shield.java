public class Shield implements Equipment {
    private int level = 1;
    private int[] stats = {1, 0, 0, 0, 0, 10, 10, -2}; // Level, HP, MP, P.ATK, M.ATK, P.DEF, M.DEF, Speed
    private Character equipper;

    @Override
    public void upgrade() {
        level++;
        stats[5] += 5; // Increase P.DEF
        stats[6] += 3; // Increase M.DEF
        stats[7] -= 1; // Decrease Speed
        System.out.println("Shield upgraded to level " + level);
    }

    @Override
    public int[] getStats() {
        return stats;
    }

    @Override
    public String getType() {
        return "Shield";
    }

    @Override
    public void setEquipper(Character equipper) {
        this.equipper = equipper;
    }

}
