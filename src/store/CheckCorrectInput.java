package store;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckCorrectInput {
    private static final String message = "Дані прийнято успішно";

    public static String checkName(){
        Scanner scanner = new Scanner(System.in);
        String name;
        while (true) {
            System.out.println("Введіть назву товару ");
            name = scanner.nextLine();
            Pattern p = Pattern.compile("^[a-zA-Zа-яієїґА-ЯІЄЇ][\\-a-zA-Zа-яієїґ0-9 \\-\"@#$%+]{1,15}$");
            Matcher m = p.matcher(name);
            if (m.matches()) {
                System.out.println(message);
                name = name.substring(0,1).toUpperCase() + name.substring(1);
                break;
            }
            else {
                System.out.println("Неправильно введене ім'я");
                System.out.println("В назві можна використовувати букви і знаки; не більше 15 знаків");

            }
        }
        return name;
    }

    public static String checkCategory(){
        Scanner scanner = new Scanner(System.in);
        String category;
        while (true) {
            System.out.println("Введіть категорію товару ");
            category = scanner.nextLine();
            Pattern p = Pattern.compile("^[a-zA-Zа-яієїґА-ЯІЄЇ][a-zA-Zа-яієїґ0-9 \\-\"@#$%+]{1,15}$");
            Matcher m = p.matcher(category);
            if (m.matches()) {
                System.out.println(message);
                category = category.substring(0,1).toUpperCase() + category.substring(1);
                break;
            }
            else {
                System.out.println("Неправильно введене значення\n можна ввести не більше 15 символів");


            }
        }
        return category;
    }

    public static String checkProductionDate(){
        Scanner scanner = new Scanner(System.in);
        String productionDate;
        while (true) {
            System.out.println("Введіть дату виготовлення ");
            productionDate = scanner.nextLine();
            Pattern p = Pattern.compile("(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d");
            Matcher m = p.matcher(productionDate);
            if (m.matches()) {
                System.out.println(message);
                if (!productionDate.equals(" ") && productionDate.length() > 0)
                    productionDate = productionDate.substring(0,1).toUpperCase() + productionDate.substring(1);
                break;
            }
            else {
                System.out.println("Неправильно введена дата");
                System.out.println("1. dd - введіть день місяця від 1 до 31");
                System.out.println("2. mm - введіть місяць від 1 до 12");
                System.out.println("3. yyyy - введіть рік від 1900 і більше");
                System.out.println("4. yyyy - максимальний рік 20..");
                System.out.println("5. розділювач має бути / -/.");
            }
        }
        return productionDate;
    }

    public static String checkExpireDate(){
        Scanner scanner = new Scanner(System.in);
        String expireDate;
        while (true) {
            System.out.println("Введіть термін придатності товару ");
            expireDate = scanner.nextLine();
            Pattern p = Pattern.compile("^[0-9a-zA-Zа-яієїґА-ЯІЄЇ][a-zA-Zа-яієїґ0-9 \\-\"@#$%+]{1,15}$");
            Matcher m = p.matcher(expireDate);
            if (m.matches()) {
                System.out.println(message);
                break;
            }
            else {
                System.out.println("Неправильно введене значення\n можна ввести не більше 15 символів");
            }
        }
        return expireDate;
    }

    public static int checkQuantity(){
        Scanner scanner = new Scanner(System.in);
        String string;
        int quantity;
        while (true) {
            System.out.println("Введіть кількість товару(ціле число)");
            string = scanner.nextLine();
            Pattern p = Pattern.compile("-?\\d+(\\.\\d{0,})?");
            Matcher m = p.matcher(string);
            if (m.matches()) {
                System.out.println(message);
                quantity = Integer.parseInt(string);
                break;
            }
            else {
                System.out.println("Введіть ціле число");

            }
        }
        return quantity;
    }

    public static Double checkPrice(){
        Scanner scanner = new Scanner(System.in);
        String sl;
        Double price;
        while (true) {
            System.out.println("Введіть ціну товару, розділювачем цілої і дробової частини є .(крапка) ");
            sl = scanner.nextLine();
            Pattern p = Pattern.compile("-?\\d+(\\.\\d{0,})?");
            Matcher m = p.matcher(sl);
            if (m.matches()) {
                System.out.println(message);
                price = Double.parseDouble(sl);
                break;
            }
            else {
                System.out.println("Введіть ціле число  або у форматі 12.5");

            }
        }
        return price;
    }

    public static String checkProvider(){
        Scanner scanner = new Scanner(System.in);
        String provider;
        while (true) {
            System.out.println("Введіть ім'я постачальника ");
            provider = scanner.nextLine();
            Pattern p = Pattern.compile("^[a-zA-Z][\\-a-zA-Z0-9 \\-\"@#$%+]{1,15}$");
            Matcher m = p.matcher(provider);
            if (m.matches()) {
                System.out.println(message);
                provider = provider.substring(0,1).toUpperCase() + provider.substring(1);
                break;
            }
            else {
                System.out.println("Неправильно введене ім'я постачальника");
                System.out.println("В назві можна використовувати букви і знаки латинського алфавіту(не більше 15 знаків)");

            }
        }
        return provider;
    }

    public static String checkProviderPhone(){
        Scanner scanner = new Scanner(System.in);
        String providerPhone;
        while (true) {
            System.out.println("Введіть телефон постачальника у форматі +380(99)-488-60-40)): ");
            providerPhone = scanner.nextLine();
            Pattern p = Pattern.compile("^[+][380][()0-9\\-]{11,20}$");
            Matcher m = p.matcher(providerPhone);
            if (m.matches()) {
                System.out.println(message);
                break;
            }
            else {
                System.out.println("Неправильно введено");
                System.out.println("Формат +380...");

            }
        }
        return providerPhone;
    }

    public static String checkReceiveDate(){
        Scanner s = new Scanner(System.in);
        String receiveDate;
        while (true) {
            System.out.println("Введіть дату виготовлення у форматі ДД/ММ/РРРР ");
            receiveDate = s.nextLine();
            Pattern p = Pattern.compile("(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d");
            Matcher m = p.matcher(receiveDate);
            if (m.matches()) {
                System.out.println(message);
                break;
            }
            else {
                System.out.println("Неправильно введена дата");
                System.out.println("1. dd - введіть день місяця від 1 до 31");
                System.out.println("2. mm - введіть місяць від 1 до 12");
                System.out.println("3. yyyy - введіть рік від 1900 і більше");
                System.out.println("4. yyyy - максимальний рік 20..");
                System.out.println("5. розділювач має бути / -/.");
            }
        }
        return receiveDate;
    }

    public static int checkStore(){
        Scanner scanner = new Scanner(System.in);
        String storeNumber;
        int store;
        while (true) {
            System.out.println("Введіть номер складу (від одного до 3 символів)");
            storeNumber = scanner.nextLine();
            Pattern p = Pattern.compile("^[0-9]{1,3}$");
            Matcher m = p.matcher(storeNumber);
            if (m.matches()) {
                System.out.println(message);
                store = Integer.parseInt(storeNumber);
                break;
            }
            else {
                System.out.println("Введіть число від від 1 до 999");

            }
        }
        return store;
    }

    public static String checkDescription(){
        Scanner scanner = new Scanner(System.in);
        String description;
        while (true) {
            System.out.println("Введіть короткий опис");
            description = scanner.nextLine();
            Pattern p = Pattern.compile("^[a-zA-Zа-яієїґА-ЯІЄЇ0-9][a-zA-Zа-яієїґ0-9 \\-\"@#$%+]{1,20}$");
            Matcher m = p.matcher(description);
            if (m.matches()) {
                System.out.println(message);
                description = description.substring(0,1).toUpperCase() + description.substring(1);
                break;
            }
            else {
                System.out.println("Неправильний формат");

            }
        }
        return description;
    }

    public static String checkExtraInfo(){
        Scanner s = new Scanner(System.in);
        String extraInfo;
        while (true) {
            System.out.println("Введіть короткий опис товару ");
            extraInfo = s.nextLine();
            Pattern p = Pattern.compile("^[a-zа-яієїґ0-9 \\-\"@#$%+]{0,30}$");
            Matcher m = p.matcher(extraInfo);
            if (m.matches()) {
                System.out.println(message);
                extraInfo = extraInfo.substring(0,1).toUpperCase() + extraInfo.substring(1);
                break;
            }
            else {
                System.out.println("Можна вводити не більше 30 символів");

            }
        }
        return extraInfo;
    }

}
