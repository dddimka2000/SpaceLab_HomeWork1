package HomeWork_1_2.Direct_7v;

import java.util.*;


public class Main {
    private static Map<String, Map<String, Integer>> graph = new HashMap<>();

    public static void main(String[] args) {
        addEdge("������", "�����", 271);
        addEdge("�����", "�������", 160);
        addEdge("�������", "�����������", 122);
        addEdge("�����������", "���������", 111);
        addEdge("���������", "�����", 159);
        addEdge("�����", "�����", 121);
        addEdge("���������", "�����", 127);
        addEdge("�������", "�����", 188);
        addEdge("����", "�������", 140);
        addEdge("�����", "����", 212);

        addEdge("�����", "������������", 167);
        addEdge("������������", "������ ���", 119);
        addEdge("������������", "�����", 245);

        addEdge("������", "��������", 132);
        addEdge("��������", "������", 71);
        addEdge("��������", "������ ���", 204);
        addEdge("������ ���", "�����", 146);
        addEdge("�����", "�������", 216);
        addEdge("����", "�������", 342);
        addEdge("�������", "�������", 143);
        addEdge("�������", "�����", 183);

        String start = "������";
        String end = "�����";

        Map<String, Integer> distances = dijkstra(graph, start);
        List<String> path = getPath(distances, start, end);

        System.out.println("���������� ����: " + path);
        System.out.println("����� ����������: " + distances.get(end));
    }

    private static void addEdge(String from, String to, int distance) {
        graph.computeIfAbsent(from, k -> new HashMap<>()).put(to, distance);
        graph.computeIfAbsent(to, k -> new HashMap<>()).put(from, distance); // ��������� ����� � �������� �������
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
                if (newDistance < distances.getOrDefault(neighbor, Integer.MAX_VALUE)) { // ���������� getOrDefault, ����� ������� Integer.MAX_VALUE, ���� �������� �� �������
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