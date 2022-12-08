package ru.netology.Java10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MovieManagerTest {

@Test

    public void addMovieTest () {
    MovieManager manager = new MovieManager();
    manager.addMovie("Film 1");
    manager.addMovie("Film 2");
    manager.addMovie("Film 3");

    String [] actual = manager.findAll();
    String [] expected = {"Film 1", "Film 2", "Film 3"};

    Assertions.assertArrayEquals(expected,actual);
}
@Test
    public void findLastTestUnderlimit () {
    int limit = 8;
    MovieManager manager = new MovieManager(limit);
    int underLimit = limit - 1;
    String [] expected = new String[underLimit];
    for (int i =0; i < underLimit; i++) {
        manager.addMovie("Film "+i);
        expected[underLimit - 1 -i] = "Film "+i;
    }
String [] actual = manager.findLast();
    Assertions.assertArrayEquals(expected,actual);
}
    @Test
    public void findLastTestLimit () {
        int limit = 8;
        MovieManager manager = new MovieManager(limit);

        String [] expected = new String[limit];
        for (int i =0; i <limit; i++) {
            manager.addMovie("Film "+i);
            expected[limit - 1 -i] = "Film "+i;
        }
        String [] actual = manager.findLast();
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void findLastTestAbovelimit () {
        int limit = 8;
        MovieManager manager = new MovieManager(limit);
        int aboveLimit = limit + 3;

        for (int i =0; i < aboveLimit; i++) {
            manager.addMovie("Film "+i);
        }
        String [] actual = manager.findLast();
        String [] expected = {"Film 10", "Film 9", "Film 8", "Film 7", "Film 6", "Film 5", "Film 4", "Film 3"};
        Assertions.assertArrayEquals(expected,actual);
    }

}
