package com.huluohu.htest;


import org.junit.Test;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.*;

public class StreamTest {

    @Test
    public void testStreamConstractor1(){
        Stream<String> stream = Stream.of("a", "b", "c", "d");

        String[] array = {"a", "b", "c", "d"};

        Stream<String> arrayStream = Arrays.stream(array);

        List<String> list = Arrays.asList(array);

        Stream<String> listStream = list.stream();


        IntStream intStream = IntStream.of(1, 2, 3, 4);

        LongStream longStream = LongStream.of(1, 2, 3, 4);

        DoubleStream doubleStream = DoubleStream.of(1.1, 2.2, 3.3);

        IntStream.range(1,5).forEach(System.out::println);

        IntStream.rangeClosed(1,5).forEach(System.out::println);
    }


    @Test
    public void testStreamMap(){
        List<String> list = Arrays.asList(new String[]{"hello", "world", "google"});
        list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        nums.stream()
                .map(n -> n * n)
                .forEach(System.out::println);

    }

    @Test
    public void testStreamFlatMap(){
        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        stream
                .flatMap(list -> list.stream())
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    @Test
    public void testStreamFilter(){
        Integer[] sixNums = {1,2,3,4,5,6};
        Integer[] array = Stream.of(sixNums)
                .filter(n -> n % 2 == 0)
                .toArray(Integer[]::new);

        Arrays.stream(array)
                .forEach(System.out::println);
    }

    @Test
    public void testStreamPeek(){
        Stream.of("one","two","three","four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value:" + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value:" + e))
                .collect(Collectors.toList());
    }

    @Test
    public void testStreamReduce(){
        Integer integer = Stream.of(1, 2, 3, 4, 5, 6, 7)
                .reduce(0, (a, b) -> a + b);
        System.out.println(integer);


        String str = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        System.out.println(str);

        Double dou = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        System.out.println(dou);

        Integer i = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        System.out.println(i);


        Integer i1 = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        System.out.println(i1);
    }

    @Test
    public void testStreamLimit(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        List<Integer> collect = list.stream()
                .limit(10)
                .skip(3)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void testStreamSorted(){
        Stream.of("a","f","d","r","n")
                .sorted((String::compareTo))
                .forEach(System.out::println);
    }

    @Test
    public void testStreamMaxAndMin(){
        int i = Stream.of("ad", "sfsdg", "sdfrdfgdfghd")
                .mapToInt(String::length)
                .max()
                .getAsInt();
        System.out.println(i);

        int j = Stream.of("ad", "sfsdg", "sdfrdfgdfghd")
                .mapToInt(String::length)
                .min()
                .getAsInt();
        System.out.println(j);
    }

    @Test
    public void testStreamDistinct(){
        Stream.of("aa", "ss", "aa","bb","cc","dd","ss")
                .distinct()
                .sorted()
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    @Test
    public void testStreamGenerate(){
        Random seed = new Random();
        Supplier<Integer> random = seed::nextInt;
        Stream.generate(random)
                .limit(20)
                .forEach(System.out::println);
    }

    @Test
    public void testStreamIterate(){
        Stream.iterate(0,n -> n + 3)
                .limit(10)
                .forEach(System.out::println);
    }

    @Test
    public void testStreamGroupBy(){
        Map<Integer, List<Person>> map = Stream.generate(new PersonSupplier())
                .limit(100)
                .collect(Collectors.groupingBy(Person::getAge));

        map.entrySet().stream()
                .forEach(entry -> {
                    System.out.println(entry.getKey() + "=" + entry.getValue());
                });
    }


    @Test
    public void testStreamPartitioningBy(){
        Map<Boolean, List<Person>> map = Stream.generate(new PersonSupplier())
                .limit(100)
                .collect(Collectors.partitioningBy(p -> p.getAge() < 18));
        System.out.println("Children number:" + map.get(true).size());
        System.out.println("Adult number:" + map.get(false).size());
    }

    private class PersonSupplier implements Supplier<Person>{
        private int index = 0;
        private Random random = new Random();
        @Override
        public Person get() {
            return new Person(random.nextInt(100),"name" + ++index);
        }
    }

    class Person{
        private int age;
        private String name;

        public Person() {
        }

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
