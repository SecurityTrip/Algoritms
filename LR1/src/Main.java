import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Лабораторна робота №1. Списки. Вариант 1.");

        int task = -1;
        boolean flag = true;

        while (flag){
            while (task < 1 || task > 3){
                try {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Введите номер задания (0-3, 0 - выход): ");
                    task = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Ошибка ввода:");
                }
            }


            switch(task){
                case 1:
                    System.out.println("Задание 1. Дан однонаправленный список с петлёй. Его «последний» элемент содержит указатель на\n" +
                            "один из элементов этого же списка, причём не обязательно на первый. Найдите начальный\n" +
                            "узел петли. Элементы списка менять нельзя, память должна быть константна.\n");

                    ListNode head_1 = new ListNode(1);
                    head_1.next = new ListNode(2);
                    head_1.next.next = new ListNode(3);
                    head_1.next.next.next = new ListNode(4);
                    head_1.next.next.next.next = head_1.next.next; // создание цикла

                    ListNode cycleStart = ListNode.findCycle(head_1);
                    if (cycleStart != null) {
                        System.out.println("Значение в начальном узле петли: " + cycleStart.val);
                    } else {
                        System.out.println("Цикл не найден.");
                    }
                    task = -1;
                    break;

                case 2:
                    System.out.println("Задание 2. Дан список с двумя указателями у каждого элемента. Зацикленность списка не допускается.\n" +
                            "Скопируйте данный список за время О(n) без использования дополнительной памяти.\n" +
                            "Выделение памяти под все данные одним блоком (как под массив) не допускается, список\n" +
                            "должен быть разбросанным по частям.\n");

                    ListNode head_2 = new ListNode(1);
                    head_2.next = new ListNode(2);
                    head_2.next.next = new ListNode(3);
                    head_2.next.next.next = new ListNode(2);
                    head_2.next.next.next.next = new ListNode(4);
                    head_2.next.next.next.next.next = new ListNode(3);

                    System.out.println("Исходный список:");
                    ListNode.printList(head_2);

                    ListNode copy = ListNode.copyList(head_2);

                    System.out.println("Скопированный список:");
                    ListNode.printList(copy);
                    task = -1;
                    break;

                case 3:
                    System.out.println("Задание 3. Удалите дубликаты из несортированного связного списка. Память должна быть константна.\n");

                    ListNode head_3 = new ListNode(1);
                    head_3.next = new ListNode(2);
                    head_3.next.next = new ListNode(3);
                    head_3.next.next.next = new ListNode(2);
                    head_3.next.next.next.next = new ListNode(4);
                    head_3.next.next.next.next.next = new ListNode(3);

                    System.out.println("Исходный список:");
                    ListNode.printList(head_3);

                    ListNode.removeDuplicate(head_3);

                    System.out.println("Список после удаления дубликатов:");
                    ListNode.printList(head_3);
                    task = -1;
                    break;

                case 0:
                        flag = false;
                        break;
            }
        }


    }
}