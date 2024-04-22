import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

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
                    List<String> e_1 = generateRoundBracketTests();
                    List<String> e_2 = generateMixedBracketTests();
                    for (String s : e_1) {
                        if(checkString(s)){
                            System.out.println("В строке " + s + " скобки расставлены верно");
                        } else {
                            System.out.println("В строке " + s + " скобки расставлены не верно");
                        }
                    }
                    System.out.println();
//                    for (String s : e_2) {
//                        if(checkString(s)){
//                            System.out.println("В строке " + s + " скобки расставлены верно");
//                        } else {
//                            System.out.println("В строке " + s + " скобки расставлены не верно");
//                        }
//                    }

                    task = -1;
                    break;

                case 2:
                    task = -1;
                    break;

                case 3:

                    task = -1;
                    break;
                case 4:

                    task = -1;
                    break;
                case 5:

                    task = -1;
                    break;

                case 0:
                    flag = false;
                    break;
            }
        }


    }

    private static boolean checkString(String str){
        CustomStack stack = new CustomStack();

        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty() || !isMatching(stack.pop(), c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty(); // Если стек пустой, то все скобки закрыты правильно
    }

    private static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }

    private static List<String> generateRoundBracketTests() {
        List<String> tests = new ArrayList<>();
        tests.add("()"); // правильная расстановка скобок.
        tests.add("(())"); // также правильная расстановка скобок.
        tests.add("(()())"); // опять же правильно.
        tests.add("((()))");
        tests.add("()()");
        tests.add("(((())))");
        tests.add("((())())");
        tests.add("((()))()");
        tests.add("(()()())");
        tests.add("()(()())");
        // Неверные тесты
        tests.add("(");
        tests.add(")");
        tests.add("())");
        tests.add("(()");
        tests.add("())(");
        tests.add("(()()");
        tests.add("(()))");
        tests.add("())()");
        tests.add("((()))))");
        tests.add("((())");
        return tests;
    }

    // Тесты на строки, содержащие любые скобки (б)
    private static List<String> generateMixedBracketTests() {
        List<String> tests = new ArrayList<>();
        tests.add("[");
        tests.add("]");
        tests.add("{(");
        tests.add("})");
        tests.add("(]");
        tests.add("{]");
        tests.add("[)");
        tests.add("(}");
        tests.add("({]}");
        tests.add("[(])");
        // Неверные тесты
        tests.add("[");
        tests.add("]");
        tests.add("{(");
        tests.add("})");
        tests.add("(]");
        tests.add("{]");
        tests.add("[)");
        tests.add("(}");
        tests.add("({]}");
        tests.add("[(])");
        return tests;
    }


}