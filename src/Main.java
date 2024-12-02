import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Character player1 = null;
        Character player2 = null;

        // Player 1
        System.out.print("Enter name for Player 1: ");
        String name1 = scanner.nextLine();
        System.out.print("Choose job for Player 1 (1: Swordman, 2: Mage): ");
        int choice1 = scanner.nextInt();
        if (choice1 == 1) {
            player1 = new Swordman(name1);
        } else {
            player1 = new Mage(name1);
        }

        // Player 2
        System.out.print("Enter name for Player 2: ");
        scanner.nextLine(); // Consume newline
        String name2 = scanner.nextLine();
        System.out.print("Choose job for Player 2 (1: Swordman, 2: Mage): ");
        int choice2 = scanner.nextInt();
        if (choice2 == 1) {
            player2 = new Swordman(name2);
        } else {
            player2 = new Mage(name2);
        }

        boolean running = true;
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. View Player 1 Status");
            System.out.println("2. View Player 2 Status");
            System.out.println("3. Equip Item for Player 1");
            System.out.println("4. Equip Item for Player 2");
            System.out.println("5. Battle");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("\nPlayer 1 Status:");
                    player1.getStatus();
                    break;
                case 2:
                    System.out.println("\nPlayer 2 Status:");
                    player2.getStatus();
                    break;
                case 3:
                    equipMenu(player1, scanner);
                    break;
                case 4:
                    equipMenu(player2, scanner);
                    break;
                case 5:
                    System.out.println("\n--- Battle Start ---");
                    player1.battle(player2);
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting the game.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
    private static void equipMenu(Character player, Scanner scanner) {
        System.out.println("\n--- Equipment Menu ---");
        System.out.println("1. Equip Sword");
        System.out.println("2. Equip Shield");
        System.out.println("3. Equip Magic Staff");
        System.out.println("4. Equip Ring");
        System.out.println("5. Equip Boots");
        System.out.println("6. Unequip All");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                if (player instanceof Swordman) {
                    System.out.println("Equip Sword");
                    player.equipweapon(new Sword());
                }else {
                    System.out.println("Only Swordman can equip a Sword.");
                }
                break;
            case 2:
                System.out.println("Equip Shield");
                player.equipweapon(new Shield());
                break;
            case 3:
                if (player instanceof Mage) {
                    System.out.println("Equip MagicStaff");
                    player.equipweapon(new MagicStaff());
                }else{
                    System.out.println("Only MagicStaff can equip Magic Staff.");
                }
                break;
            case 4:
                System.out.println("Equip Ring");
                player.equip(new Ring());
                break;
            case 5:
                System.out.println("Equip Boots");
                player.equip(new Boots());
                break;
            case 6:
                System.out.println("Unequip All");
                player.unequip(0);
                player.unequip(1);
                player.unequipweapon(0);
                player.unequipweapon(1);
                break;
            default:
                System.out.println("Invalid option. Returning to the main menu.");
        }
    }
}
