package ru.otus.evgrez;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import java.util.List;

public class Testmaven {
    public static void main(String[] args) {
        List<String> names = Lists.newArrayList("John", "Jane", "Adam", "Tom");
        String result = Joiner.on(',').join(names.toArray());
        System.out.println(result);
    }
}
