package HomeWork_1_0.Äç1.Structural.FlyWeight;

import java.util.HashMap;
import java.util.Map;

public class FlyWeight {
    Map<String, Tea> map = new HashMap<>();

    Tea getTea(String color) {
        Tea tea = map.get(color);
        if (tea == null) {
            tea=new Tea();
            tea.color=color;
            map.put(color,tea);
        }
        return tea;
    }

}
