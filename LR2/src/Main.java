import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Лабораторна робота №2. Структуры данных.");

        int task = -1;
        boolean flag = true;

        while (flag){
            while (task < 0 || task > 5){
                try {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Введите номер задания (0-5, 0 - выход): ");
                    task = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Ошибка ввода, попробуйте заново.");
                }
            }


            switch(task){
                case 1:
                    System.out.println(checkParensGeneral("{{}}[]()"));  // true
                    System.out.println(checkParensGeneral("{{[()]}}"));  // true
                    System.out.println(checkParensGeneral("{{[)]}}"));  // false
                    System.out.println(checkParensGeneral("{(})")); // false
                    task = -1;
                    break;

                case 2:
                    // Пример использования
                    MinStack minStack = new MinStack();
                    minStack.push(-4);
                    minStack.push(3);
                    minStack.push(5);
                    minStack.push(2);
                    System.out.println(minStack.getMin());
                    task = -1;
                    break;

                case 3:
                    int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
                    int k = 3;

                    System.out.println("Максимумы в окне размера " + k + ":");
                    List<Integer> maxValues = maxInWindow(arr, k);
                    System.out.println(maxValues);
                    task = -1;
                    break;
                case 4:

                    int[] nums = {1, 3, 4, 2, 2};
                    System.out.println("Повторяющийся элемент: " + findDuplicate(nums));

                    int[] nums2 = {3, 1, 3, 4, 2};
                    System.out.println("Повторяющийся элемент: " + findDuplicate(nums2));

                    task = -1;
                    break;

                case 5:
                    int[][] matrix = {
                            {9, 2, 3},
                            {4, 4, 6},
                            {7, 8, 0}
                    };

                    System.out.println("Исходная матрица:");
                    printMatrix(matrix);

                    zeroMatrix(matrix);

                    System.out.println("Матрица после обнуления:");
                    printMatrix(matrix);

                    task = -1;
                    break;

                case 0:
                    flag = false;
                    break;
            }
        }


    }

    public static boolean checkParensGeneral(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');

        for (char c : s.toCharArray()) {
            if (mapping.containsValue(c)) {
                stack.push(c);
            } else if (mapping.containsKey(c)) {
                if (stack.isEmpty() || mapping.get(c) != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static List<Integer> maxInWindow(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return new ArrayList<>();
        }

        Deque<Integer> deque = new ArrayDeque<>(); // Индексы элементов
        List<Integer> result = new ArrayList<>();

        // Проходим по массиву
        for (int i = 0; i < arr.length; i++) {
            // Удаляем из очереди индексы, которые вышли за пределы окна
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Удаляем из очереди элементы меньшие, чем текущий
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }

            // Добавляем текущий индекс в очередь
            deque.offerLast(i);

            // Если окно сформировано, добавляем максимум в результат
            if (i >= k - 1) {
                result.add(arr[deque.peekFirst()]);
            }
        }

        return result;
    }


    public static int findDuplicate(int[] nums) {
        // Шаг 1: Инициализация указателей
        int tortoise = nums[0];
        int hare = nums[0];

        // Шаг 2: Найти точку пересечения в цикле
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Шаг 3: Найти вход в цикл
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        // Повторяющийся элемент найден
        return hare;
    }

    public static void zeroMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Создаем флаги для обозначения необходимости обнуления строк и столбцов
        boolean[] zeroRows = new boolean[rows];
        boolean[] zeroCols = new boolean[cols];

        // Определяем, какие строки и столбцы нужно обнулить
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroCols[j] = true;
                }
            }
        }

        // Обнуляем строки
        for (int i = 0; i < rows; i++) {
            if (zeroRows[i]) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Обнуляем столбцы
        for (int j = 0; j < cols; j++) {
            if (zeroCols[j]) {
                for (int i = 0; i < rows; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}