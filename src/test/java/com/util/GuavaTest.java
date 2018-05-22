package com.util;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.*;
import com.google.common.primitives.Ints;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import static com.google.common.base.CharMatcher.inRange;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;
import static com.google.common.collect.Sets.newHashSet;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午11:25 2018/5/22
 */
public class GuavaTest {
    @Test
    public void test_1() {
        //静态导入
        Map<String, Object> map = newHashMap();
        map.put("1", "2");
        System.out.println(map);
        List<Map<String, Object>> list = newArrayList();
        list.add(map);
        System.out.println(list);
        List<String> list1 = newArrayList("1", "2", "3");
        System.out.println(list1);
        //不可变集合
        ImmutableList<String> list2 = ImmutableList.of("1", "2", "3");
//        list2.remove(1); 报错
        list2.forEach(System.out::println);
        ImmutableMap<String, String> immutableMap = ImmutableMap.of("1", "11", "2", "22");
        System.out.println(immutableMap);
    }

    @Test
    public void test_CharMatcher() {
        inRange('a', 'z').or(inRange('A', 'Z'));
        String string = CharMatcher.DIGIT.retainFrom("some text 89983 and more");
        System.out.println(string);
        String string1 = CharMatcher.DIGIT.removeFrom("some text 89983 and more");
        System.out.println(string1);
    }

    @Test
    public void test_JoinerAndSplitter() {
        String[] subdirs = {"usr", "local", "lib"};
        String directory = Joiner.on("/").join(subdirs);
        System.out.println(directory);

        int[] numbers = {1, 2, 3, 4, 5};//基本数据类型
        String numbersAsString = Joiner.on(";").join(Ints.asList(numbers));
        System.out.println(numbersAsString);

        System.out.println(Ints.join(";", numbers));
        System.out.println("~~");
        Iterable split = Splitter.on(";").split(numbersAsString);
        split.forEach(System.out::println);


    }

    @Test
    public void test_contains() {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(Ints.contains(array, 3));
        System.out.println(Ints.indexOf(array, 2));
        System.out.println(Ints.max(array));
        System.out.println(Ints.min(array));
        int[] array1 = {5, 6, 7, 8, 9};
        int[] concat = Ints.concat(array, array1);
        System.out.println(Ints.asList(concat));
    }

    @Test
    public void test_set() {
        HashSet setA=newHashSet(1,2,3,4,5);
        HashSet setB=newHashSet(4,5,6,7,8);
        Sets.SetView union=Sets.union(setA,setB);
        System.out.println("~~union");
        union.forEach(System.out::println);
        Sets.SetView different=Sets.difference(setA,setB);
        System.out.println("~~different");
        different.forEach(System.out::println);
        System.out.println("~~~intersection");
        Sets.SetView intersection=Sets.intersection(setA,setB);
        intersection.forEach(System.out::println);
    }

    @Test
    public void test_MapDifference(){
        ImmutableMap<String,Object>mapA=ImmutableMap.of("1","11","2","22");
//        ImmutableMap<String,Object>mapB=ImmutableMap.of("1","11","2","22");
//
        ImmutableMap<String,Object>mapB=ImmutableMap.of("2","22","3","33","4","44");
        MapDifference differenceMap = Maps.difference(mapA, mapB);
        System.out.println(differenceMap.areEqual());
        Map entriesDiffering = differenceMap.entriesDiffering();//???????
        System.out.println(entriesDiffering);
        Map entriesOnlyOnLeft = differenceMap.entriesOnlyOnLeft();
        System.out.println(entriesOnlyOnLeft);
        Map entriesOnlyOnRight = differenceMap.entriesOnlyOnRight();
        System.out.println(entriesOnlyOnRight);
        Map entriesInCommon = differenceMap.entriesInCommon();
        System.out.println(entriesInCommon);
    }

    @Test
    public void test_Preconditions(){
        int count=2;
        checkArgument(count > 0, "must be positive: %s", count);
        String a=null;
        System.out.println(checkNotNull(a));
    }

    @Test
    public void test_multiMap(){
        Multimap<String, List<String>> multimap = ArrayListMultimap.create();
        multimap.put("1",Lists.newArrayList("1","2"));
        multimap.put("1",Lists.newArrayList("1","2"));
        System.out.println(multimap);
    }


}
