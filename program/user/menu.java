import java.util.Scanner;

import program.Main.PetType;
import program.UncD.UncorrectData;
import program.Controller.Controller;
import program.Controller.Counter;

public class menu {

    Controller Controller;

    public menu(java.lang.ModuleLayer.Controller controller2) {
        this.Controller = Controller;
    }

    public void start() {

        System.out.print("\033[H\033[J");
        try (Scanner in = new Scanner(System.in, "ibm866"); Counter count = new Counter()) {

            boolean flag = true;
            int id;
            while (flag) {

                System.out.println(
                        "\n1 - Список животных\n2 - Добавить животное\n3 - Изменить данные\n4 - Команды\n5 - Способности\n6 - Удалить запись\n0 - Выход");
                String key = in.next();
                switch (key) {
                    case "1":
                        Controller.getAllPet();
                        break;
                    case "2":
                        PetType type = menuChoice(in);
                        if (type != null) {
                            try {
                                Controller.createPet(type);
                                count.add();
                                System.out.println("ОК");
                            } catch (UncorrectData e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        break;
                    case "3":
                        while (true) {
                            id = menuChoicePet(in);
                            if (id != 0)
                                try {
                                    Controller.updatePet(id);
                                } catch (UncorrectData e) {
                                    System.out.println(e.getMessage());
                                }
                            else
                                break;
                        }
                        break;
                    case "4":
                        while (true) {
                            id = menuChoicePet(in);
                            if (id != 0)
                                Controller.getCommands(id);
                            else
                                break;
                        }
                        break;
                    case "5":
                        id = menuChoicePet(in);
                        if (id != 0)
                            menuTrainPet(id, in);
                        break;
                    case "6":
                        id = menuChoicePet(in);
                        if (id != 0)
                            Controller.delete(id);
                        break;
                    case "0":
                        flag = false;
                        break;
                    default:
                        System.out.println("ошибка");
                        break;
                }
            }
        }
    }

    private PetType menuChoice(Scanner in) {
        System.out.println("Какое животное добавить:\n1 - Кошка\n2 - Собака\n3 - Хомяк\n0 - Возврат в основное меню");

        while (true) {
            String key = in.next();
            switch (key) {
                case "1":
                    return PetType.Cat;
                case "2":
                    return PetType.Dog;
                case "3":
                    return PetType.Hamster;
                case "0":
                    return null;
                default:
                    System.out.println("Такого варианта нет, введите число от 0 до 3");
                    break;
            }
        }
    }

    private int menuChoicePet(Scanner in) {
        System.out.println("\nВведите номер животного, 0 для возврата в основное меню: ");
        while (true) {
            int id = in.nextInt();
            in.nextLine();
            if (id == 0)
                return id;
            if (Controller.getById(id) == null) {
                System.out.println("Животного с таким номером нет, попробуйте еще раз, 0 для возврата в основное меню:");
            } else
                return id;

        }
    }

    private void menuTrainPet(int petId, Scanner in) {
        Scanner sc = in;
        while (true) {
            System.out.println("Введите новую команду, 0 для возврата в основное меню: ");
            String command = sc.nextLine();
            if (command.length() == 1 && command.equals("0"))
                return;
            if (Controller.trainPet(petId, command))
                System.out.println("выполнено");
        }
    }
}
