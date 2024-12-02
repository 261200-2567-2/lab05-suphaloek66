public class Mage extends BaseCharacter{
    static int[] BaseStats = new int[]{1,70,100,5,20,5,5,5};
    //{LV,hp,mp,P.ATK,M.ATK,P.DEF,M.DEF,SPEED}
    public Mage(String name) {
        super(name, "Mage", BaseStats);
    }
}
