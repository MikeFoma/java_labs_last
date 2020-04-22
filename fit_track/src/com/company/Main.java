package com.company;
import javax.xml.bind.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    //меню тренеровки
    static Profile train_menu(Profile current_profile) throws IOException {

        //создаем коллекцию ввидов тренеровки
        LinkedList<Train> train_set = new LinkedList<Train>();

        train_set.add(new Train("push-ups", 1000));
        train_set.add(new Train("jump rope", 750));
        train_set.add(new Train("squats", 1300));

        //выводим меню тренировки
        for (int i = 0; i < train_set.size(); i++) {
            System.out.println( (i + 1) + ") " + train_set.get(i).type);
        }
        System.out.println("Enter 0 to exit:");

        //начинаем ввод с клавиатуры
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();
        System.out.println(input);

        //если 0, то возвращаемся в меню профиля
        if( "0".equals(input)) {
            return current_profile;
        }
        //если с 1 по 3, вызываем метов нужной тренеровки, после чего записываем результат в профиль. Вызываем меню тренеровки
        //иначе вновь вызываем меню тренеровки
        if( "1".equals(input) || "2".equals(input) || "3".equals(input) ) {
            current_profile.update_calories(train_set.get(Integer.parseInt(input) - 1).do_train());
            current_profile = train_menu(current_profile);
        } else {
            current_profile = train_menu(current_profile);
        }


        return current_profile;
    }

    //меню профиля
    static Profile profile_menu(Profile current_profile) throws IOException {

        //вывод информации о профиле и элементов выбора
        current_profile.print_profile();
        System.out.println("1)Choose train");
        System.out.println("2)Make new profile");
        System.out.println("Enter 0 to exit:");

        //ввод с клавиатуры
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();
        //System.out.println(input);

        //если 0, то возвращаемся в основное меню
        if( "0".equals(input) ) {
            return current_profile;
        }
        //если 1, то вызываем меню тренеровки. По окончанию тренеровки вновь открываем меню профиля
        //если 2, перезаписываем профиль, даем имя и вновь открываем меню профиля
        //иначе вновь открываем меню профиля
        if( "1".equals(input)) {
            current_profile = train_menu(current_profile);
            current_profile = profile_menu(current_profile);
        } else if ("2".equals(input)) {
            current_profile = new Profile("None", current_profile.profile_id, 0);
            System.out.println("New name:");
            input = keyboard.nextLine();
            current_profile.name = input;
            current_profile = profile_menu(current_profile);
        } else {
            current_profile = profile_menu(current_profile);
        }

        return current_profile;
    }

    //основное меню
    static LinkedList<Profile> main_menu(LinkedList<Profile> profile_set) throws IOException {

        //выводим профили
        System.out.println("Choose a profile:");
        for (int i = 0; i < 5; i++) {
            System.out.println( (i + 1) + ") " + profile_set.get(i).name);
        }
        System.out.println("Enter 0 to exit:");

        //начинаем ввод с клавиатуры
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();
        //System.out.println(input);

        //если 0, то закрываем меню и возвращаем итогувую коллекцию профилей
        if( "0".equals(input) ) {
            keyboard.close();
            return profile_set;
        }
        //если от 1 до 5, то вызываем меню профиля с выбранным профилем. По окончанию вновь открываем меню
        //иначе вновь открываем меню
        if( "1".equals(input) || "2".equals(input) || "3".equals(input) || "4".equals(input) || "5".equals(input) ) {
            profile_set.set(Integer.parseInt(input) - 1, profile_menu(profile_set.get(Integer.parseInt(input) - 1)));
            profile_set = main_menu(profile_set);
        } else {
            profile_set = main_menu(profile_set);
        }

        //прекращаем ввод с клавиатуры
        keyboard.close();
        return profile_set;
    }


    public static void main(String[] args) throws JAXBException, IOException {
        // write your code here
        //создаем коллекцию профилей
        LinkedList<Profile> profile_set = new LinkedList<Profile>();

        //создаем «контекст»
        JAXBContext context = JAXBContext.newInstance(Profile.class);

        //создание объекта Marshaller, который выполняет сериализацию
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        //создание объекта Unmarshaller, который выполняет десериализацию
        Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();

        //цикл проверяет наличие конфигурационных файлов с профиялми пользователей
        //если файл существует, то выполняем его десериализацию
        //если не существет, то создаем новый новый пустой профиль и сереализуем его
        for (int i = 0; i < 5; i++) {
            File file = new File( "conf/profile"+ (i + 1) +".xml" );

            if (file.exists()) {
                //System.out.println("exists!!!");
                Profile profile = (Profile) jaxbUnmarshaller.unmarshal(file);
                profile_set.add(profile);
            }
            else {
                //System.out.println("not exists!!!");
                Profile profile = new Profile("None", i + 1, 0);
                profile_set.add(profile);
                // сама сериализация
                marshaller.marshal(profile, file);
            }
        }

        //запуск консольного псевдо-меню
        profile_set = main_menu(profile_set);

        //цикл перезапысывает файлы профилей итоговыми данными
        for (int i = 0; i < 5; i++) {
            File file = new File( "conf/profile"+ (i + 1) +".xml" );
            // сама сериализация
            marshaller.marshal(profile_set.get(i), file);
        }
    }
}
