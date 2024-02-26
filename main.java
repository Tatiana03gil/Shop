import java.io.FileWriter;
import java.io.IOException;

public class main {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        ui ui = new ui();
        int types = ui.takeToysCount();
        toysLists toysLists = new toysLists();
        for (int i = 0; i < types; i++) {
            toy toy = new toy();
            String[] toyInfo = ui.takeToyInfo();
            try {
                toy.setID(ui.convertId(toyInfo[0]));
                toy.setName(toyInfo[1]);
                toy.setCount(ui.convertCount(toyInfo[2]));
                toy.setFrequency(ui.convertFrequency(toyInfo[3]));
                toysLists.addToy(toy);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Игрушка не записана, неверно указаны данные! Повторите ввод через ; ");
                i = i - 1;
            }
        }

        if (toysLists.totalWeight() != 100)
            System.out.println("Общий вес не равен 100%. Розыгрыш будет в долях");
        shop shop = new shop(toysLists.countsList());
        shop.shopList(toysLists);
        String command = "1";
        while (command.equals("1")) {
            System.out.println("Введите 1 для проведения розыгрыша ");
            command = ui.addInfo();
            if (command.equals("1"))
                if (!shop.shopList.isEmpty()) {
                    try {
                        FileWriter fw = new FileWriter("shop.txt", true);
                        fw.write(shop.shopList.remove(0));
                        fw.write("\n");
                        fw.flush();
                        fw.close();
                    } catch (IOException e) {
                        System.out.println("Файл не найден");
                        command = "";
                    }
                } else {
                    System.out.println("Призов больше нет. Розыгрыш окончен.");
                    command = "";
                }
        }
        System.out.println("Розыгрыш окончен. Результаты в файле shop.txt");
    }
}
