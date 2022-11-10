import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Какую функцию вы хотите проверить?");
        System.out.println("0 - FizzBuzz");
        System.out.println("1 - Числа Фибоначчи");
        System.out.println("2 - Факториал числа");
        System.out.println("3 - Сортировка пузырьком");
        System.out.println("4 - Подсчёт гласных и согласных");
        System.out.print("Введите число: ");
        int program = in.nextInt();
        if (program < 0 || program > 4) {
            System.out.println("Нет такой функции(");
        } else if (program == 0) {
            System.out.println("Вы выбрали функцию FizzBuzz");
            System.out.print("Введите натуральное число: ");
            int number = in.nextInt();
            if (number < 1) {
                System.out.println("Не натуральное число(");
            } else {
                FizzBuzz(number);
            }
        } else if (program == 1) {
            System.out.println("Вы выбрали функцию Fibonacci");
            System.out.print("Введите натуральное число: ");
            int number = in.nextInt();
            if (number < 1) {
                System.out.println("Не натуральное число(");
            } else {
                Fibonacci(number);
            }
        } else if (program == 2) {
            System.out.println("Вы выбрали функцию Factorial");
            System.out.print("Введите неотрицательное число: ");
            int number = in.nextInt();
            if (number < 0) {
                System.out.println("Отрицательное число(");
            } else {
                Factorial(number);
            }
        } else if (program == 3) {
            System.out.println("Вы выбрали функцию BubbleSort");
            System.out.print("Введите неотрицательное число - размер массива, он будет сгенерирован автоматически: ");
            int number = in.nextInt();
            if (number < 0) {
                System.out.println("Отрицательное число(");
            } else {
                BubbleSort(number);
            }
        }
    }

    static void FizzBuzz(int number) {
        for (int i = 1; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
        System.out.println("Это была функция FizzBuzz, спасибо за внимание");
    }

    static void Fibonacci(int number) {
        int first = 0, second = 1;
        if (number == 1) {
            System.out.println("0");
        } else if (number == 2) {
            System.out.println("0 1");
        } else {
            System.out.print("0 1 ");
            for (int i = 2; i < number; i++) {
                int third = first + second;
                System.out.printf("%d ", third);
                first = second;
                second = third;
            }
        }
        System.out.println();
        System.out.println("Это была функция чисел Фибоначчи, спасибо за внимание");
    }

    static void Factorial(int number) {
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        System.out.printf("Факториал %d - это %d\n", number, factorial);
        System.out.println("Это была функция вычисления факториала, спасибо за внимание");
    }

    static void BubbleSort(int number) {
        int[] array = new int[number];
        System.out.println("Сгенерированный массив размера " + number + ":");
        for (int i = 0; i < number; i++) {
            array[i] = (int) (Math.random() * (201)) - 100;
            System.out.print(array[i] + " ");
        }
        System.out.println();
        int k;
        for (int i = 0; i < number - 1; i++) {
            for (int j = i + 1; j < number; j++) {
                if (array[i] > array[j]) {
                    k = array[i];
                    array[i] = array[j];
                    array[j] = k;
                }
            }
        }
        System.out.println("Отсортированный массив:");
        for (int i = 0; i < number; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println("Это была функция BubbleSort, спасибо за внимание");
    }
}
