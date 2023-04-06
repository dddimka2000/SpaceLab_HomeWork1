package org.example.Direct_6;


import java.lang.reflect.Field;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IllegalAccessException {
        org.example.Direct_6.Drink drink = new org.example.Direct_6.Drink("Tea");
        org.example.Direct_6.Person person = new org.example.Direct_6.Person("Dima", 10, drink);
        String output = convertToJson(person);
        System.out.println(output);
    }

    public static String convertToJson(Object object) throws IllegalAccessException {
        StringBuilder json = new StringBuilder("{");

        // Получаем все поля объекта
        Field[] fields = object.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);

            // Получаем имя поля и его значение
            String name = fields[i].getName();
            Object value = fields[i].get(object);

            // Добавляем имя поля в JSON-строку
            json.append(name+":");

            // Преобразуем значение поля в соответствующий JSON-элемент
            if (value == null) {
                json.append("null");
            } else if (value instanceof String) {
                json.append(value);
            } else if (value.getClass().isArray()) {
                for (int j = 0; j < ((Object[]) value).length; j++) {
                    if (j > 0) {
                        json.append(",");
                    }
                    json.append(convertToJson(((Object[]) value)[j]));
                }
            } else if (value instanceof Number || value instanceof Boolean) {
                json.append(value.toString());
            } else {
                json.append(convertToJson(value));
            }

            // Добавляем разделитель, если это не последнее поле объекта
            if (i < fields.length - 1) {
                json.append(",");
            }
        }

        json.append("}");
        return json.toString();
    }
}
