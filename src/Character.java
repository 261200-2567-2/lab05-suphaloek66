public interface Character {
    void attack(Character opponent);
    void battle(Character opponent);
    void equip(Accessory item);
    void equipweapon(Equipment item);
    void unequipweapon(int item);
    void unequip(int slot);
    void getStatus();
    void LevelUp();
    void calculate();
}
