package ru.job4j.chapter_001.statistic;

import org.junit.Test;
import ru.job4j.chapter_001.statistic.model.Info;
import ru.job4j.chapter_001.statistic.model.User;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AnalyzeTest {

    @Test
    public void whenAddNewUser() {
        List<User> prev = Arrays.asList(
                new User(00, "Alex"),
                new User(01, "Derek"),
                new User(02, "Salma")
        );

        List<User> curr = Arrays.asList(
                new User(00, "Alex"),
                new User(01, "Derek"),
                new User(02, "Salma"),
                new User(03, "Arnold")
        );
        Analyze analyze = new Analyze();
        Info result = analyze.diff(prev, curr);
        assertThat(result.getAdded(), is(1));
        assertThat(result.getChanged(), is(0));
        assertThat(result.getDeleted(), is(0));
    }

    @Test
    public void whenDeleteOneUser() {
        List<User> prev = Arrays.asList(
                new User(00, "Alex"),
                new User(01, "Derek"),
                new User(02, "Salma")
        );

        List<User> curr = Arrays.asList(
                new User(00, "Alex"),
                new User(01, "Derek")
        );
        Analyze analyze = new Analyze();
        Info result = analyze.diff(prev, curr);
        assertThat(result.getAdded(), is(0));
        assertThat(result.getChanged(), is(0));
        assertThat(result.getDeleted(), is(1));
    }

    @Test
    public void whenChangedOneUser() {
        List<User> prev = Arrays.asList(
                new User(00, "Alex"),
                new User(01, "Derek"),
                new User(02, "Salma")
        );

        List<User> curr = Arrays.asList(
                new User(00, "Alex"),
                new User(01, "John"),
                new User(02, "Salma")
        );
        Analyze analyze = new Analyze();
        Info result = analyze.diff(prev, curr);
        assertThat(result.getAdded(), is(0));
        assertThat(result.getChanged(), is(1));
        assertThat(result.getDeleted(), is(0));
    }
}
