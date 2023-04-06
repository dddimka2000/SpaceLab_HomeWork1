package HomeWork_1_2.Direct_7v;

import java.util.*;


public class Main {
    private static Map<String, Map<String, Integer>> graph = new HashMap<>();

    public static void main(String[] args) {
        addEdge("Одесса", "Умань", 271);
        addEdge("Умань", "Винница", 160);
        addEdge("Винница", "Хмельницкий", 122);
        addEdge("Хмельницкий", "Тернополь", 111);
        addEdge("Тернополь", "Ровно", 159);
        addEdge("Ровно", "Львов", 121);
        addEdge("Тернополь", "Львов", 127);
        addEdge("Житомир", "Ровно", 188);
        addEdge("Киев", "Житомир", 140);
        addEdge("Умань", "Киев", 212);

        addEdge("Умань", "Кропивницкий", 167);
        addEdge("Кропивницкий", "Кривой Рог", 119);
        addEdge("Кропивницкий", "Днепр", 245);

        addEdge("Одесса", "Николаев", 132);
        addEdge("Николаев", "Херсон", 71);
        addEdge("Николаев", "Кривой Рог", 204);
        addEdge("Кривой Рог", "Днепр", 146);
        addEdge("Днепр", "Харьков", 216);
        addEdge("Киев", "Полтава", 342);
        addEdge("Полтава", "Харьков", 143);
        addEdge("Харьков", "Суммы", 183);

        String start = "Одесса";
        String end = "Львов";

        Map<String, Integer> distances = dijkstra(graph, start);
        List<String> path = getPath(distances, start, end);

        System.out.println("Кратчайший путь: " + path);
        System.out.println("Общее расстояние: " + distances.get(end));
    }

    private static void addEdge(String from, String to, int distance) {
        graph.computeIfAbsent(from, k -> new HashMap<>()).put(to, distance);
        graph.computeIfAbsent(to, k -> new HashMap<>()).put(from, distance); // добавляем ребро в обратную сторону
    }

    private static Map<String, Integer> dijkstra(Map<String, Map<String, Integer>> graph, String start) {
        Map<String, Integer> distances = new HashMap<>();
        for (String vertex : graph.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        Set<String> visited = new HashSet<>();
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        queue.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            visited.add(current);

            Map<String, Integer> neighbors = graph.get(current);
            if (neighbors == null) {
                continue;
            }

            for (String neighbor : neighbors.keySet()) {
                int distance = neighbors.get(neighbor);
                if (visited.contains(neighbor)) {
                    continue;
                }
                int newDistance = distances.get(current) + distance;
                if (newDistance < distances.getOrDefault(neighbor, Integer.MAX_VALUE)) { // используем getOrDefault, чтобы вернуть Integer.MAX_VALUE, если значение не найдено
                    distances.put(neighbor, newDistance);
                    queue.add(neighbor);
                }
            }
        }
        return distances;
    }

    private static List<String> getPath(Map<String, Integer> distances, String start, String end) {
        List<String> path = new ArrayList<>();
        path.add(end);
        while (!end.equals(start)) {
            int minDistance = Integer.MAX_VALUE;
            String nextVertex = null;
            Map<String, Integer> neighbors = graph.get(end);
            if (neighbors == null) {
                break;
            }
            for (String neighbor : neighbors.keySet()) {
                int distance = distances.get(neighbor);
                if (distance < minDistance) {
                    minDistance = distance;
                    nextVertex = neighbor;
                }
            }
            if (nextVertex == null) {
                break;
            }
            path.add(nextVertex);
            end = nextVertex;
        }

        Collections.reverse(path);
        return path;
    }
}