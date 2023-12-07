package entity;

import core.Person;
import interfaces.NotifyInterface;

public class Admin extends Person implements NotifyInterface {
    @Override
    public void notification() {
        System.out.println("Admin notify");
    }
}
