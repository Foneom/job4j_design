package ru.job4j.chapter_001.statistic;

import ru.job4j.chapter_001.statistic.model.Info;
import ru.job4j.chapter_001.statistic.model.User;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Analyze {

    public Info diff(List<User> previous, List<User> current) {

        Info info = new Info();

        Map<Integer, User> users = previous.
                stream().collect(
                Collectors.toMap(User::getId, Function.identity())
        );

        current.forEach(user -> {
            User temp = users.remove(user.getId());
            if (temp == null) {
                info.countAdd();
            } else if (!temp.getName().equals(user.getName())) {
                info.countChanged();
            }
        });
        info.setDeleted(users.size());
        return info;
    }
}
