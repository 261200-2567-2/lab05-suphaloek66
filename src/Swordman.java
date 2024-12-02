public class Swordman extends BaseCharacter{
    static int[] BaseStats = new int[]{1,100,50,20,0,15,15,5};
    //{LV,hp,mp,P.ATK,M.ATK,P.DEF,M.DEF,SPEED}
    public Swordman(String name) {
        super(name, "Swordsman", BaseStats);
    }
}
