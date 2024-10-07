package com.api;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamApi {
    public static void main(String[] args) {
        // Predicate Functional Function
        //Example1
        Predicate<Integer> val=x->x>100;
        boolean test = val.test(88);
        System.out.println(test);
        //Example2
        Predicate<String> name=x->x.equals("Abhi");
        boolean abhi = name.test("Abhi");
        System.out.println(abhi);

        //Example3 with streamapi number greaterthen
        List<Integer> data= Arrays.asList(100,10,35,2,15,500,700);
        List<Integer> newData=data.stream().filter(x->x>30).collect(Collectors.toList());
        System.out.println(newData);

        //Example4 with streamapi String start latter
        List<String> data2=Arrays.asList("mike","abhi","adam","madam");
        List<String> newData2=data2.stream().filter(x->x.startsWith("a")).collect(Collectors.toList());
        System.out.println(newData2);

        //Example5 with streamapi even number
        List<Integer> data3=Arrays.asList(10,11,13,14,16,19);
        List<Integer> newData3=data3.stream().filter(x->x%2==0).collect(Collectors.toList());
        System.out.println(newData3);

        //Example6 with streamapi odd number
        List<Integer> data4=Arrays.asList(10,11,13,14,16,19);
        List<Integer> newdata4=data4.stream().filter(x->x%2!=0).collect(Collectors.toList());
        System.out.println(newdata4);
    }
}
