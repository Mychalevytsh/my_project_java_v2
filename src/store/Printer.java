package store;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Printer {
     static void printTable(ArrayList<Good> goodArrayList) {
        List<Good> smartphone = new ArrayList<>();
         List<Good> notebook = new ArrayList<>();
         int printVariant = 0;

        System.out.println("               Формування таблиці");

        System.out.println("         Виберіть яку дію потрібно виконати");
        System.out.println(" +---+------------------------------------------+");
        System.out.println(" | 1 | вивести всі товари                       |");
        System.out.println(" +---+------------------------------------------+");
        System.out.println(" | 2 | переглянути товари з категорії смартфон  |");
        System.out.println(" +---+------------------------------------------+");
        System.out.println(" | 3 | переглянути товари з категорії ноутбук   |");
        System.out.println(" +---+------------------------------------------+");
        System.out.println(" | 4 | вийти в головне меню                     |");
        System.out.println(" +---+------------------------------------------+");
        Scanner scr = new Scanner(System.in);
        System.out.println("Введіть цифру:\n ");
        try {
            printVariant = Integer.parseInt(scr.nextLine());
        }catch (Exception e){System.out.println("Неправильний ввід, введіть число від 1 до 4");}


        if (printVariant == 1) {

            System.out.println("                        Таблиця товарів");
            System.out.println("+----+---------------+----------------+----------------+-------------+------------+--------+---------------+-----------------+-----------------+--------+-------------+------------+");
            System.out.println("| ID |  Ім'я         |   Категорія    |     Дата       |  Термін     |  Кількість | Ціна   |  Постачальник |    Номер        |        Дата     | Склад  |   Короткий  | Примітки   |");
            System.out.println("|    |               |                | Виготовлення   | Придатності |            |        |               | телефону постач.|      Поставки   |        |      опис   |            |");
            System.out.println("+----+---------------+----------------+----------------+-------------+------------+--------+---------------+-----------------+-----------------+--------+-------------+------------+");
            for (Good good : goodArrayList) {
                if (good != null) {
                    System.out.printf("| %2d | %-14.13s| %-15.14s| %-15.14s| %-12.11s| %-11.10s| %-7.6s| %-14.13s| %-16.14s| %-16.15s| %-7.6s| %-12.11s| %-11.10s|%n", good.getId(), good.getName(), good.getCategory(), good.getProductionDate(), good.getExpiryDate(), good.getQuantity(), good.getPrice(), good.getProvider(), good.getProviderPhone(), good.getReceiveDate(), good.getStore(), good.getDescription(), good.getExtraInfo());
                    System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");

                }

            }
        }else if (printVariant == 2){
            System.out.println("                        Таблиця товарів з категорії смартфон");
            System.out.println("+----+---------------+----------------+----------------+-------------+------------+--------+---------------+-----------------+-----------------+--------+-------------+------------+");
            System.out.println("| ID |  Ім'я         |   Категорія    |     Дата       |  Термін     |  Кількість | Ціна   |  Постачальник |    Номер        |        Дата     | Склад  |   Короткий  | Примітки   |");
            System.out.println("|    |               |                | Виготовлення   | Придатності |            |        |               | телефону постач.|      Поставки   |        |      опис   |            |");
            System.out.println("+----+---------------+----------------+----------------+-------------+------------+--------+---------------+-----------------+-----------------+--------+-------------+------------+");

            for (Good good : goodArrayList) {
                if (good.getCategory().equalsIgnoreCase("смартфон")) {
                    smartphone.add(good);
                }
            }
            for (Good good: smartphone) {
                if (good != null) {
                    System.out.printf("| %2d | %-14.13s| %-15.14s| %-15.14s| %-12.11s| %-11.10s| %-7.6s| %-14.13s| %-16.14s| %-16.15s| %-7.6s| %-12.11s| %-11.10s|%n", good.getId(), good.getName(), good.getCategory(), good.getProductionDate(), good.getExpiryDate(), good.getQuantity(), good.getPrice(), good.getProvider(), good.getProviderPhone(), good.getReceiveDate(), good.getStore(), good.getDescription(), good.getExtraInfo());
                    System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");

                }

            }
            System.out.println(smartphone.size());
        }
        else if (printVariant == 3){
            System.out.println("                        Таблиця товарів з категорії ноутбук");
            System.out.println("+----+---------------+----------------+----------------+-------------+------------+--------+---------------+-----------------+-----------------+--------+-------------+------------+");
            System.out.println("| ID |  Ім'я         |   Категорія    |     Дата       |  Термін     |  Кількість | Ціна   |  Постачальник |    Номер        |        Дата     | Склад  |   Короткий  | Примітки   |");
            System.out.println("|    |               |                | Виготовлення   | Придатності |            |        |               | телефону постач.|      Поставки   |        |      опис   |            |");
            System.out.println("+----+---------------+----------------+----------------+-------------+------------+--------+---------------+-----------------+-----------------+--------+-------------+------------+");

            for (Good good : goodArrayList) {
                if (good.getCategory().equalsIgnoreCase("ноутбук")) {
                    notebook.add(good);
                }
            }
            for (Good good: notebook) {
                if (good != null) {
                    System.out.printf("| %2d | %-14.13s| %-15.14s| %-15.14s| %-12.11s| %-11.10s| %-7.6s| %-14.13s| %-16.14s| %-16.15s| %-7.6s| %-12.11s| %-11.10s|%n", good.getId(), good.getName(), good.getCategory(), good.getProductionDate(), good.getExpiryDate(), good.getQuantity(), good.getPrice(), good.getProvider(), good.getProviderPhone(), good.getReceiveDate(), good.getStore(), good.getDescription(), good.getExtraInfo());
                    System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");

                }

            }
        }
        else if (printVariant == 4){
            System.out.println("Вихід в головне меню  ");
        }

    }
}
