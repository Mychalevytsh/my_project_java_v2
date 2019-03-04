package store;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

class Menu {
    public static void mainMenu(ArrayList<Good> goodArrayList) {
        Scanner s = new Scanner(System.in);
        int action = 0;
        while (action != 7) {
            Menu.menu();
            action = s.nextInt();
            if (action == 1) {
                addGood(goodArrayList);
            } else if (action == 2) {
                print(goodArrayList);
            } else if (action == 3) {
                goodsEditor(goodArrayList);
            } else if (action == 4) {
                readWriteFileInfo(goodArrayList);
            } else if (action == 5) {
                delete(goodArrayList);
            } else if (action == 6) {
                Printer.printTable(goodArrayList);
            } else if (action == 7) System.out.println("Ви закінчили роботу з програмою! До Побачення!");
            else System.out.println("Неправильний ввід. Виберіть цифру від 1 до 6 \nабо 7 для виходу");
        }
    }

    private static void menu() {
        System.out.println("\n       Виберіть яку дію потрібно виконати");
        System.out.println(" +---+------------------------------------------+");
        System.out.println(" | 1 | додати новий товар                       |");
        System.out.println(" +---+------------------------------------------+");
        System.out.println(" | 2 | переглянути інформацію про товар         |");
        System.out.println(" +---+------------------------------------------+");
        System.out.println(" | 3 | редагувати існуючий товар                |");
        System.out.println(" +---+------------------------------------------+");
        System.out.println(" | 4 | Читатати або записувати дані в файл      |");
        System.out.println(" +---+------------------------------------------+");
        System.out.println(" | 5 | Видалити товар                           |");
        System.out.println(" +---+------------------------------------------+");
        System.out.println(" | 6 | Вивести звіт                             |");
        System.out.println(" +---+------------------------------------------+");
        System.out.println(" | 7 | Вихід                                    |");
        System.out.println(" +---+------------------------------------------+");
    }

    private static void addGood(ArrayList<Good> goodArrayList) {
        System.out.println("Введемо дані нового товару");
        String name = CheckCorrectInput.checkName();
        String category = CheckCorrectInput.checkCategory();
        String productionDate = CheckCorrectInput.checkProductionDate();
        String expireDate = CheckCorrectInput.checkExpireDate();
        int quantity = CheckCorrectInput.checkQuantity();
        double price = CheckCorrectInput.checkPrice();
        String provider = CheckCorrectInput.checkProvider();
        String providerPhone = CheckCorrectInput.checkProviderPhone();
        String recreiveDate = CheckCorrectInput.checkReceiveDate();
        int store = CheckCorrectInput.checkStore();
        String description = CheckCorrectInput.checkDescription();
        String extraInfo = CheckCorrectInput.checkExtraInfo();

        Good good = new Good(name, category, productionDate, expireDate, quantity, price, provider, providerPhone, recreiveDate, store, description, extraInfo);
        goodArrayList.add(good);

        System.out.println("\nДодано введений товар");

        System.out.println(good.toString());
        writeFile(goodArrayList);
    }

    private static void print(ArrayList<Good> goodArrayList) {
        Scanner s = new Scanner(System.in);
        System.out.println("Список товарів");
        for (int i = 0; i < goodArrayList.size(); i++) {
            System.out.print((i + 1) + ". ");
            goodArrayList.get(i).toString();
        }
        System.out.println("Виберіть номер товару");
        int a;
        a = s.nextInt();
        if (a <= goodArrayList.size() && a > 0) {
            System.out.println(goodArrayList.get(a - 1).toString());
        } else System.out.println("Такого товару немає, введіть інший номер");
    }

    private static void goodsEditor(ArrayList<Good> goodArrayList) {
        Scanner s = new Scanner(System.in);
        System.out.println("Вікно редагування товару -");
        for (int i = 0; i < goodArrayList.size(); i++) {
            System.out.print((i + 1) + ". ");
            System.out.println(goodArrayList.get(i).getName());
        }
        System.out.println("Виберіть номер товару який хоче редагувати");
        int index;
        index = s.nextInt();
        if (index <= goodArrayList.size() && index > 0) {
            int i = 0;
            while (i != 13) {
                System.out.println("\nВиберіть що потрібно редагувати ");
                System.out.println("1   Назва");
                System.out.println("2   Категорія");
                System.out.println("3   Дата виготовлення");
                System.out.println("4   Термін придатності");
                System.out.println("5   Кількість");
                System.out.println("6   Ціна");
                System.out.println("7   Постачальник");
                System.out.println("8   Номер телефону постачальника");
                System.out.println("9   Дата поставки");
                System.out.println("10  Номер складу");
                System.out.println("11  Короткий опис");
                System.out.println("12  Примітки");
                System.out.println("13  Завершити редагування");
                i = s.nextInt();
                s.nextLine();
                index--;
                //Назва товару
                if (i == 1) {
                    System.out.println("Назва товару -  " + goodArrayList.get(index).getName());
                    System.out.println("Введіть нову назву товару");
                    goodArrayList.get(index).setName(CheckCorrectInput.checkName());

                    System.out.println("Нова нову назву товару" + goodArrayList.get(index).getName());

                    //Категорія товару
                } else if (i == 2) {
                    System.out.println("Поточна категорія: " + goodArrayList.get(index).getCategory());
                    System.out.println("Введіть нову назву категорії");
                    goodArrayList.get(index).setCategory(CheckCorrectInput.checkCategory());

                    System.out.println("Нову назва категорії " + goodArrayList.get(index).getCategory());

                    //Дата виробництва
                } else if (i == 3) {
                    System.out.println("Поточна дата виробництва " + goodArrayList.get(index).getProductionDate());
                    System.out.println("Введіть нову  дату виробництва ");
                    goodArrayList.get(index).setProductionDate(CheckCorrectInput.checkProductionDate());

                    System.out.println("Нова  дата виробництва " + goodArrayList.get(index).getProductionDate());

                    //Термін придатності
                } else if (i == 4) {
                    System.out.println("Поточний термін придатності " + goodArrayList.get(index).getExpiryDate());
                    System.out.println("Введіть новий термін придатності");
                    goodArrayList.get(index).setExpiryDate(CheckCorrectInput.checkExpireDate());

                    System.out.println("Новий термін придатності" + goodArrayList.get(index).getExpiryDate());

                    //Кількість
                } else if (i == 5) {
                    System.out.println("Поточна кількість " + goodArrayList.get(index).getQuantity());
                    System.out.println("Введіть нову кількість ");
                    goodArrayList.get(index).setQuantity(CheckCorrectInput.checkQuantity());

                    System.out.println("Нова кількість товару " + goodArrayList.get(index).getQuantity());

                    //Ціна

                } else if (i == 6) {
                    System.out.println("Поточна ціна " + goodArrayList.get(index).getPrice());
                    System.out.println("Введіть нову ціну ");
                    goodArrayList.get(index).setPrice(CheckCorrectInput.checkPrice());

                    System.out.println("Нова ціна " + goodArrayList.get(index).getPrice());

                    //Постачальник
                } else if (i == 7) {
                    System.out.println("Поточний Постачальник " + goodArrayList.get(index).getProvider());
                    System.out.println("Введіть нового постачальника");
                    goodArrayList.get(index).setProvider(CheckCorrectInput.checkProvider());

                    System.out.println("Назва нового постачальника " + goodArrayList.get(index).getProvider());

                    //Телефон Постачальника
                } else if (i == 8) {
                    System.out.println("Поточний номер телефону постачальника " + goodArrayList.get(index).getProviderPhone());
                    System.out.println("Введіть новий номер телефону постачальника");
                    goodArrayList.get(index).setProviderPhone(CheckCorrectInput.checkProviderPhone());

                    System.out.println("Новий номер телефону -" + goodArrayList.get(index).getProviderPhone());

                    //Дата отримання товару
                } else if (i == 9) {
                    System.out.println("Поточна дата отримання товару" + goodArrayList.get(index).getReceiveDate());
                    System.out.println("Змініть дату отримання товару");
                    goodArrayList.get(index).setReceiveDate(CheckCorrectInput.checkReceiveDate());

                    System.out.println("Нова дата отримання товару" + goodArrayList.get(index).getReceiveDate());

                    //склад
                } else if (i == 10) {
                    System.out.println("Поточний номер складу " + goodArrayList.get(index).getStore());
                    System.out.println("Введіть новий номер складу");
                    goodArrayList.get(index).setStore(CheckCorrectInput.checkStore());

                    System.out.println("Новий номер склвду" + goodArrayList.get(index).getStore());

                    //Опис
                } else if (i == 11) {
                    System.out.println("Поточний опис товару" + goodArrayList.get(index).getDescription());
                    System.out.println("Введіть новий опис товару");
                    goodArrayList.get(index).setDescription(CheckCorrectInput.checkReceiveDate());

                    System.out.println("New dateOfStartWork is " + goodArrayList.get(index).getDescription());

                    //Примітки
                } else if (i == 12) {
                    System.out.println("Поточне значення приміток " + goodArrayList.get(index).getExtraInfo());
                    System.out.println("Введіть нове значення Примітки");
                    goodArrayList.get(index).setExtraInfo(CheckCorrectInput.checkExtraInfo());

                    System.out.println("Нове значення Примітки" + goodArrayList.get(index).getExtraInfo());
                } else if (i == 13) {
                    System.out.println("Вихід");
                } else System.out.println("Помилка, введіть число від  1 до 13: ");
            }
        } else System.out.println("Нема товару з таким ID");
    }

    private static void delete(ArrayList<Good> goodArrayList) {
        System.out.println("Видаляємо товар зі списку");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Список товарів");
        for (int i = 0; i < goodArrayList.size(); i++) {
            System.out.print((i + 1) + ") ");
            System.out.println(goodArrayList.get(i).getName());
        }
        System.out.println("Введіть номер товару, який хочете видалити ");
        int a;
        a = scanner.nextInt();
        if (a <= goodArrayList.size() && a > 0) {
            System.out.println("Ви точно хочете видалити товар  " + goodArrayList.get(a - 1).getName() + "Ціна  якого" + goodArrayList.get(a - 1).getPrice());
            int str;
            System.out.println("1 - Так \n2 - НІ");
            str = scanner.nextInt();
            scanner.nextLine();
            if (str == 1) {
                goodArrayList.remove(a - 1);
                writeFile(goodArrayList);
                System.out.println("Видалення товару...");
                System.out.println("Товар видалено");


            } else if (str == 2) {
                System.out.println("Відміна ");
            } else System.out.println("Виберіть 1 або 2");
        } else System.out.println("товару з таким номером не існує");
    }





    private static void writeFile(ArrayList<Good> goodArrayList){
        File file = new File("text_save.txt");
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (Good good : goodArrayList) {
            assert printWriter != null;
            printWriter.print(good.getId() + "; ");
            printWriter.print(good.getName() + "; ");
            printWriter.print(good.getCategory() + "; ");
            printWriter.print(good.getProductionDate() + "; ");
            printWriter.print(good.getExpiryDate() + "; ");
            printWriter.print(good.getQuantity() + "; ");
            printWriter.print(good.getPrice() + "; ");
            printWriter.print(good.getProvider() + "; ");
            printWriter.print(good.getProviderPhone() + "; ");
            printWriter.print(good.getReceiveDate() + "; ");
            printWriter.print(good.getStore() + "; ");
            printWriter.print(good.getDescription() + "; ");
            printWriter.println(good.getExtraInfo());
        }
        if (printWriter != null) {
            printWriter.close();
        }
    }
    private static void readFromFile(ArrayList<Good> goodArrayList) {
        System.out.println("\nЧитаємо файл");
        File file = new File("text.txt");

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert scanner != null;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] goodArr = line.split("; ");
            System.out.println("Зчитуємо новий товар");
            String name = goodArr[1];
            String category = goodArr[2];

            String prodactionDate = goodArr[3];
            String expiryDate = goodArr[4];
            int quantity = Integer.parseInt(goodArr[5]);
            double price = Double.parseDouble(goodArr[6]);
            String provider = goodArr[7];
            String providerPhone = goodArr[8];
            String receiveDate = goodArr[9];

            int store = Integer.parseInt(goodArr[10]);
            String description = goodArr[11];
            String extraInfo = goodArr[12];

            Good good = new Good(name, category, prodactionDate,
                    expiryDate, quantity, price,
                    provider, providerPhone, receiveDate,
                    store, description, extraInfo);

            //Записуємо дані у список
            goodArrayList.add(good);
            System.out.println(Arrays.toString(goodArr));
        }
        scanner.close();
    }
    private static void readWriteFileInfo(ArrayList<Good> goodArrayList) {
        String act = "";
        Scanner scanner = new Scanner(System.in);
        while (!act.equals("3")) {
            System.out.println("\nВиберіть дію яку хочете виконати");
            System.out.println("1 Читати  з файлу");
            System.out.println("2 Писати в файл");
            System.out.println("3 Вийти в головне меню");
            act = scanner.nextLine();

            switch (act) {
                case "1":
                    System.out.println("Зчитано з файлу");
                    readFromFile(goodArrayList);
                    break;

                case "2":
                    System.out.println("Записуємо дані файл");
                    writeFile(goodArrayList);
                    break;

                default:
                    System.out.println("Неправильне число, введіть число від 1 до 3");
                    break;
            }
        }
    }
}