package HomeWork_1_2.RR;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class V1 {
    public static void main(String[] args) {
        // Создание immutable списка с помощью конструктора ArrayList и метода Collections.unmodifiableList()
        List<Integer> immutableList = Collections.unmodifiableList(new ArrayList<>(Arrays.asList(1, 2, 3)));

        // Создание immutable списка с помощью метода Collections.unmodifiableList() и массива элементов
        Integer[] array = {1, 2, 3};
        List<Integer> immutableList2 = Collections.unmodifiableList(Arrays.asList(array));

        List<Integer> mutableList = new ArrayList<>();
        mutableList.add(1);
        mutableList.add(2);
        mutableList.add(3);
    }
}