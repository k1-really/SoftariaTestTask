package org.example;

import org.example.letter.LetterManager;
import org.example.letter.LetterManagerImpl;
import org.example.statistic.model.Statistic;
import org.example.statistic.StatisticManager;
import org.example.statistic.StatisticManagerImpl;

import java.util.HashMap;
import java.util.Scanner;

/*Есть две хэш таблицы.

Ключами являются URLы.
        Значениями - html код страниц, находящихся по этим урлам.

Обе таблицы отражают состояние всех страниц некоторого заданного
множества веб сайтов.

Первая таблица - состояние этих сайтов на вчера.
        Вторая - на сегодня.

Задача - написать код который бы, пользуясь этими таблицами составил
письмо следующего формата:

Здравствуйте, дорогая и.о. секретаря

За последние сутки во вверенных Вам сайтах произошли следующие изменения:

Исчезли следующие страницы:{здесь список урлов}
Появились следующие новые страницы {здесь список урлов}
Изменились следующие страницы {здесь список урлов}

С уважением,
автоматизированная система
мониторинга.*/

public class Main {
    public static void main(String[] args) {

        String name;
        String patronymic;

        HashMap<String, String> yesterdayCondition = new HashMap<>();
        HashMap<String, String> todayCondition = new HashMap<>();

        yesterdayCondition.put("/api","<HTML code1>");
        todayCondition.put("/api/1","<HTML code2>");
        todayCondition.put("/api","<HTML code2>");

        Scanner in = new Scanner(System.in);
        System.out.print("Введите Ваше имя: ");
        while ((name = in.nextLine()).isEmpty()) {
            System.out.println("Поле с именем не должно быть пустым! Введите имя заново!");
            System.out.print("Введите Ваше имя: ");
        }
        System.out.print("Введите Ваше отчество: ");
        while ((patronymic = in.nextLine()).isEmpty()) {
            System.out.println("Поле с отчеством не должно быть пустым! Введите имя заново!");
            System.out.print("Введите Ваше отчество: ");
        }

        Initials initials = new Initials(name,patronymic);
        LetterManager letterManager = new LetterManagerImpl();
        StatisticManager statisticManager = new StatisticManagerImpl();
        Statistic statistic = statisticManager.getStatistics(yesterdayCondition,todayCondition);

        System.out.println(letterManager.createLetter(initials,statistic));
    }
}