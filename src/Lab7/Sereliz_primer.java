package Lab7;

import java.io.*;
import java.util.Scanner;

class Avtomobil implements Serializable {
    String model; // модель автомобиля
    int reg_nomer; // регистрационный номер
    int god_vup; // год выпуска
    int probeg; // пробег
    int stoimost; // стоимость
}

public class Sereliz_primer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in, "cp1251");
        // создается файл на диске
        File f = new File("MyFileSer.txt");
        f.createNewFile();
// -------------ЗАПИСЬ ОБЪЕКТА В ФАЙЛ-------------
// Создается поток для записи объекта
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        System.out.print("Введите количество автомобилей для записи в файл\n" + "=> ");
        int kol = sc.nextInt();

// Вводится информация об объекте (автомобиле)
        Avtomobil avtomobil = null;
        for (int i = 0; i < kol; i++) {
            avtomobil = new Avtomobil();
            System.out.println("Введите информацию об автомобиле: ");

            System.out.print("Модель автомобиля => ");
            avtomobil.model = sc.nextLine();
            avtomobil.model = sc.next();

            System.out.print("Регистрационный номер => ");
            avtomobil.reg_nomer = sc.nextInt();

            System.out.print("Год выпуска => ");
            avtomobil.god_vup = sc.nextInt();

            System.out.print("Пробег => ");
            avtomobil.probeg = sc.nextInt();

            System.out.print("Стоимость => ");
            avtomobil.stoimost = sc.nextInt();
            oos.writeObject(avtomobil);
        }
// Объект записывается в файл

// Дописывается информация и закрывается файловый поток
        oos.flush();
        oos.close();
// -------------ЧТЕНИЕ ОБЪЕКТА ИЗ ФАЙЛА-------------
// Создается поток для чтения объекта из файла
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream oin = new ObjectInputStream(fis);
        File file2 = new File("godvup2009.txt");
        file2.createNewFile();
        FileOutputStream fos2 = new FileOutputStream(file2);
        ObjectOutputStream oos2 = new ObjectOutputStream(fos2);


// Объект считывается, и на экран выводится требуемая информация
        for (int i = 0; i < kol; i++) {
            avtomobil = (Avtomobil) oin.readObject();
            if (avtomobil.god_vup > 2009) {
                System.out.println(" Модель автомобиля " + avtomobil.model);
                System.out.println(" Регистрационный номер = " + avtomobil.reg_nomer);
                System.out.println(" Год выпуска = " + avtomobil.god_vup);
                System.out.println(" Пробег = " + avtomobil.probeg);
                System.out.println(" Стоимость = " + avtomobil.stoimost);
            }
        }
// Поток закрывается
        oos2.close();
        oos2.flush();
    }
}