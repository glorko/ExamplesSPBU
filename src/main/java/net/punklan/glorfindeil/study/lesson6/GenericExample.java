package net.punklan.glorfindeil.study.lesson6;

import net.punklan.glorfindeil.study.lesson2.UserPOJO;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by st020794 on 31.03.2017.
 */
public class GenericExample {
    public static void main(String[] args) {
        //before 5 java
        List example = new ArrayList();
        //before 7 java
        List<UserPOJO> example2 = new ArrayList<UserPOJO>();
        UserPOJO user = new UserPOJO();
        user.setFirstName("Name");
        UserPOJO user2 = new UserPOJO();
        user2.setFirstName("Name2");
        example2.add(user);
        example2.add(user2);
        Map<String, String> example3 = new HashMap<>();
        UserFunction<UserPOJO, String> fun = new GetUserName();
        System.out.println(fun.apply(new UserPOJO()));
        UserFunction<UserPOJO, String> anonFun = new UserFunction<UserPOJO, String>() {
            @Override
            public String apply(UserPOJO userPOJO) {
                return userPOJO.getFirstName();
            }
        };
        Map<Integer, Integer> numbers = new HashMap<>();
        numbers.put(2, 4);
        numbers.put(6, 8);
        BiFunction<Integer, Integer, Integer> sum =
                (first, second) ->
                        first + second;
        numbers.entrySet().forEach((entry) ->
                System.out.println(entry.getKey() + entry.getValue()));

        List<String> names = example2.stream()
                .map(UserPOJO::getFirstName)
                .map((elem) -> elem + "||").collect(Collectors.toList());
        Optional<String> all = example2.stream().map(UserPOJO::getFirstName)
                .filter(s -> {
                    return s.length() > 3;
                }).reduce(String::concat);
        System.out.println(all.get());


    }

    BiFunction<Integer, Integer, Integer> sumOld =
            new BiFunction<Integer, Integer, Integer>() {
                @Override
                public Integer apply(Integer integer, Integer integer2) {
                    return integer + integer2;
                }
            };


}
