public class BaseCharacter implements Character {
    private final String  name;
    private final String job;
    private int[] stats;
    private Accessory[] accessories;
    private Equipment[] weaponSlot;

    public BaseCharacter(String name, String job, int[] baseStats) {
        this.name = name;
        this.job = job;
        this.stats = baseStats.clone();
        this.accessories = new Accessory[2];
        this.weaponSlot = new Equipment[2];
    }

    @Override
    public void attack(Character opponent) {
        int damage;
        String attackMessage = "";

        // M.ATK for Mage, P.ATK for Swordman
        if (job.equals("Mage")) {
            damage = stats[4];
            attackMessage = name + " Cast Fireball on " + ((BaseCharacter) opponent).name;
            damage = Math.max(0, damage - ((BaseCharacter) opponent).stats[6]);
        } else {
            damage = stats[3];
            attackMessage = name + " strikes " + ((BaseCharacter) opponent).name;
            damage = Math.max(0, damage - ((BaseCharacter) opponent).stats[5]);
        }

        System.out.println(attackMessage + " for " + damage + " damage!");
        ((BaseCharacter) opponent).stats[1] -= damage;
    }

    @Override
    public void battle(Character opponent) {
        System.out.println("Battle Start: " + name + " vs " + ((BaseCharacter) opponent).name);
        System.out.println("=========================");
        while (this.stats[1] > 0 && ((BaseCharacter) opponent).stats[1] > 0) {
            attack(opponent);
            if (((BaseCharacter) opponent).stats[1] <= 0) {break;}
            opponent.attack(this);
            System.out.println(name + " HP: " + stats[1]);
            System.out.println(((BaseCharacter) opponent).name + " HP: " + ((BaseCharacter) opponent).stats[1]);
        }
        System.out.println("=========================");
        if(stats[1] > 0){
            System.out.println(name + " HP: " + stats[1] + " and " + ((BaseCharacter) opponent).name + " HP: " + "0");
            System.out.println(name + " "+ "wins!");
        }else {
            System.out.println(name + " HP: " + "0" + " and " + ((BaseCharacter) opponent).name + " HP: " + ((BaseCharacter) opponent).stats[1]);
            System.out.println(((BaseCharacter) opponent).name + " " + "wins!");
        }

    }

    @Override
    public void equipweapon(Equipment item) {
        for (int i = 0; i < weaponSlot.length; i++) {
            if (weaponSlot[i] == null) {
                weaponSlot[i] = item;
                item.setEquipper(this);
                for (int j = 1; j < stats.length; j++) {
                    stats[j] += item.getStats()[j];
                }
                System.out.println(name + " equipped " + item.getType() + " in Weapon slot " + (i + 1));
                getStatus();
                return;
            }
        }
        System.out.println("Weapon slots are full!");
    }

    @Override
    public void unequipweapon(int slot) {
        if (slot >= 0 && slot < weaponSlot.length && weaponSlot[slot] != null) {
            Equipment removedWeapon = weaponSlot[slot];
            weaponSlot[slot] = null;
            for (int i = 1; i < stats.length; i++) {
                stats[i] -= removedWeapon.getStats()[i];
            }
            removedWeapon.setEquipper(null);
            System.out.println(name + " unequipped " + removedWeapon.getType() + " from slot " + (slot + 1));
        } else {
            System.out.println("No weapon in this slot.");
        }
    }

    @Override
    public void equip(Accessory item) {
        for (int i = 0; i < accessories.length; i++) {
            if (accessories[i] == null) {
                accessories[i] = item;
                item.setEquipper(this);
                for (int j = 1; j < stats.length; j++) {
                    stats[j] += item.getStats()[j];
                }
                System.out.println(name + " equipped " + item.getType() + " in accessory slot " + (i + 1));
                return;
            }
        }
        System.out.println("Accessory slots are full!");
    }

    @Override
    public void unequip(int slot) {
        if (slot >= 0 && slot < accessories.length && accessories[slot] != null) {
            Accessory removed = accessories[slot];
            accessories[slot] = null;
            for (int i = 1; i < stats.length; i++) {
                stats[i] -= removed.getStats()[i];
            }
            removed.setEquipper(null);
            System.out.println(name + " unequipped " + removed.getType() + " from slot " + (slot + 1));
        } else {
            System.out.println("No accessory in this slot.");
        }
    }

    @Override
    public void getStatus() {
        System.out.println("=========================================");
        System.out.println("Name: " + name + ", Job: " + job + ", LV." + stats[0]);
        System.out.print(
                "HP: " + stats[1] +
                        "\nMP: " + stats[2] +
                        "\nP.ATK: " + stats[3] +
                        "\nM.ATK: " + stats[4] +
                        "\nP.DEF: " + stats[5] +
                        "\nM.DEF: " + stats[6] +
                        "\nSPEED: " + stats[7]);
        System.out.println("\n=========================================");
    }

    @Override
    public void calculate() {
        stats[1] += 10 * stats[0]; // HP
        stats[2] += 5 * stats[0];  // MP
        stats[7] += 1;             // Speed
        System.out.println(name + " Level up! New stats calculated.");
    }
    @Override
    public void LevelUp(){
        stats[0]++;
        calculate();
    }
}
