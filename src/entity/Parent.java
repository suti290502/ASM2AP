package entity;

import core.Person;
import interfaces.NotifyInterface;

public class Parent extends Person implements NotifyInterface {
public Parent(){

}
    @Override
    public void notification() {
        System.out.println("Parent notify");

    }
}
