package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Train {

    String type;
    double calories_in_time;

    Train(String type, double calories_in_time) {
        this.type = type;
        this.calories_in_time = calories_in_time;
    }

    //начать тренеровку
    double do_train() throws IOException {
        //начинаем ввод с клавиатуры
        Scanner keyboard = new Scanner(System.in);
        //запуск тренеровки
        System.out.println("Ready to start?");
        String input = keyboard.nextLine();

        //берем время запуска
        double time1 = System.currentTimeMillis();

        //конец тренеровки
        System.out.println("Stop training?");
        input = keyboard.nextLine();

        //берем время остановки
        double time2 = System.currentTimeMillis();
        //считаем разницу и переводим милиссекунды в часы
        double time = (time2 - time1) / (1000.0 * 60.0 * 60.0 * 24.0);

        System.out.println(time);

        //keyboard.close();
        return calories_in_time * time;
    }

}
