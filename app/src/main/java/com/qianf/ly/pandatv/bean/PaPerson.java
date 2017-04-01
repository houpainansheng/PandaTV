package com.qianf.ly.pandatv.bean;

import java.util.List;

/**
 * Created by baisaikele on 2017/3/25.
 */

public class PaPerson {
    private List<Person> persons;

    public PaPerson(List<Person> persons) {
        this.persons = persons;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
