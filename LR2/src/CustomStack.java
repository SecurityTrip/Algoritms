import java.util.EmptyStackException;

public class CustomStack {
    private Node top; // верхний элемент стека
    private int min; // текущий минимальный элемент в стеке

    // Конструктор
    public CustomStack() {
        top = null;
        min = Integer.MAX_VALUE; // начальное значение минимума устанавливаем как максимально возможное
    }

    // Внутренний класс для узла стека
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Добавление элемента на вершину стека
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;

        // Обновляем минимальное значение, если добавленный элемент меньше текущего минимума
        if (data < min) {
            min = data;
        }
    }

    // Удаление и возврат элемента с вершины стека
    public char pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        int poppedData = top.data;
        top = top.next;

        // Если удаляемый элемент равен текущему минимуму, нужно обновить минимум
        if (poppedData == min) {
            updateMin();
        }

        return (char) poppedData;
    }

    // Возврат минимального элемента в стеке
    public int min() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return min;
    }

    // Проверка на пустоту стека
    public boolean isEmpty() {
        return top == null;
    }

    // Обновление значения минимального элемента
    private void updateMin() {
        if (isEmpty()) {
            min = Integer.MAX_VALUE;
            return;
        }

        int currentMin = Integer.MAX_VALUE;
        Node current = top;
        while (current != null) {
            if (current.data < currentMin) {
                currentMin = current.data;
            }
            current = current.next;
        }
        min = currentMin;
    }
}
