package com.company;


import javax.xml.bind.annotation.*;

@XmlRootElement(name = "profile")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"name","profile_id","calories"})
public class Profile {

    String name;
    int profile_id;
    double calories;

    Profile(String name, int profile_id, double calories) {
        this.profile_id = profile_id;
        this.name = name;
        this.calories = calories;
    }

    //добовлени потраченных калорий
    void update_calories(double new_calories) {
        calories += new_calories;
    }

    //вывод профиля
    void print_profile() {
        System.out.println("Profile ID:" + profile_id + "\nName:" + name + "\nCalories:" + calories);
    }

}
