package store;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args){
        System.out.println(" +----------------------------------------------+");
        System.out.println(" |     Програма для роботи зі складом товарів   |");
        System.out.println(" +----------------------------------------------+");

//  список для товарів
        ArrayList<Good> goodList = new ArrayList<>();
//виклик меню
        Menu.mainMenu(goodList);

    }
}
