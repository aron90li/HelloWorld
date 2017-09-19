package com.aron.learn.bean;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * Created by Aron on 2017/7/27.
 */
public class PersonTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testPersonStream() {

        List<Person> persons = new ArrayList<>();
        Person p1 = new Person();
        p1.setAge(30);
        p1.setNames(new ArrayList<String>() {{
            add("Michale");
            add("Jordan");
        }});
        p1.setAlias(new ArrayList<String>() {{
            add("Air");
            add("God");
        }});

        Person p2 = new Person();
        p2.setAge(21);
        p2.setNames(new ArrayList<String>() {{
            add("Kobe");
            add("Bryant");
        }});
        p2.setAlias(new ArrayList<String>() {{
            add("Black");
            add("Mamba");
        }});

        persons.add(p1);
        persons.add(p2);

        String s = persons.stream().filter(x -> x.getAge() > 20).map(Person::getNames).flatMap(List::stream).collect(Collectors.joining(","));
        System.out.println(s);


    }
}