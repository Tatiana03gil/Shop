import java.util.Scanner;

public class ui {

    public String[] takeToyInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите информацию о игрушке: (id; название; количество; вес в %)");
        String info = scanner.nextLine();
        String[] strings = info.split("; ");
        return strings;
    }

    public String addInfo() {
        Scanner scanner = new Scanner(System.in);
        String info = scanner.nextLine();
        return info;
    }

    public int convertId(String string) {
        try {
            int id = Integer.parseInt(string);
            return id;
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат ID! Введите ID цифрами: ");
            return convertId(addInfo());
        }
    }

    public int convertCount(String string) {
        try {
            int count = Integer.parseInt(string);
            if (count > 0)
                return count;
            else {
                System.out.println("Игрушек не может быть меньше 0! Введите количество заново: ");
                return convertCount(addInfo());
            }
        } catch (NumberFormatException e) {
            System.out.println("Неверное количество! Введите количество цифрами: ");
            return convertId(addInfo());
        }
    }

    public int convertFrequency(String string) {
        string = string.replace("%", "");
        try {
            int fr = Integer.parseInt(string);
            if (fr > 0)
                return fr;
            else {
                System.out.println("Частота не может быть меньше 0! Введите частоту в % заново: ");
                return convertFrequency(addInfo());
            }
        } catch (NumberFormatException e) {
            System.out.println("Неверная частота! Введите частоту цифрами в %: ");
            return convertId(addInfo());
        }
    }

    public int takeToysCount () {
        System.out.println("Введите число ВИДОВ игрушек для розыгрыша: ");
        try {
            int number = Integer.parseInt(addInfo());
            if (number > 0) 
                return number;
            else {
                System.out.println("Число не может быть меньше 1!");
                return takeToysCount();
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка! Введите число видов заново: ");
            return takeToysCount();
        }
    }

    public String startRaffle () {
        System.out.println("Нажмите 1 чтобы провести розыгрыш");
        String number = addInfo();
        return number;
    }
}
