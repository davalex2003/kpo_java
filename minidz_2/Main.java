import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static final String[] LIST_OF_STUDENTS = {"Абиев Марик Олегович", "Абулханов Дамир Зуфарович", "Александрова Анастасия Васильевна",
            "Безруков Михаил Александрович", "Бушмаков Максим Олегович", "Воробьев Артём Александрович", "Габдуллина Алия Маратовна",
            "Давиденко Алексей Ильич", "Данилов Никита Александрович", "Жижин Никита Дмитриевич", "Иванов Дмитрий Сергеевич",
            "Кирьянова Софья Александровна", "Кислов Максим Алексеевич", "Константинов Никита Дмитриевич", "Оробцов Вячеслав Алексеевич",
            "Остапец Валерия Александровна", "Поклонский Антон Максимович", "Пронин Богдан", "Рахимова Камила Мухаммадовна",
            "Сафронов Лев Павлович", "Семенов Никита Сергеевич", "Сериков Артём Игоревич", "Спиридонов Дмитрий Вячеславович",
            "Терехов Артем Русланович", "Фортов Егор Кириллович", "Хамид Карим Мохамадович", "Харитонов Кирилл Александрович",
            "Шабалкин Виталий Витальевич", "Шкляр Станислав Станиславович"};
    public static final String HELP = """
            /r - выбрать случайного студента\s
            /c - выбрать студента по ФИО\s
            /a - показать список студентов\s
            /m - показать список студентов с оценками\s
            /i - показать информацию о студенте\s
            /e - пара закончилась""";
    static StudentMark[] LIST_OF_STUDENTS_MARKS = new StudentMark[LIST_OF_STUDENTS.length];
    static int inflation = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < LIST_OF_STUDENTS.length; i++) {
            LIST_OF_STUDENTS_MARKS[i] = new StudentMark(i, LIST_OF_STUDENTS[i]);
        }
        System.out.println("Здравствуйте! Это программа для выбора студента, который будет отвечать на сегодняшней паре. Для подсказки введите /h.");
        String receivedFlag;
        receivedFlag = in.next();
        while (!receivedFlag.equals("/e")) {
            switch (receivedFlag) {
                case "/h" -> System.out.println(HELP);
                case "/a" -> showAllStudents();
                case "/m" -> showStudentMarks();
                case "/i" -> showStudentInformation();
                case "/r" -> chooseRandomStudent();
                case "/c" -> chooseStudent();
                default -> System.out.println("Такой опции нет, введите /h для подсказки");
            }
            receivedFlag = in.next();
        }
        System.out.println("Пара закончилась, поздравляем!");
    }

    private static void chooseStudent() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите ФИО студента: ");
        String surname = in.nextLine();
        if (Arrays.asList(LIST_OF_STUDENTS).contains(surname)) {
            int studentIndex = Arrays.asList(LIST_OF_STUDENTS).indexOf(surname);
            if (LIST_OF_STUDENTS_MARKS[studentIndex].alreadyAnswered != 0) {
                System.out.println(LIST_OF_STUDENTS_MARKS[studentIndex].name + " уже выбирался вами");
            } else {
                System.out.println("Отвечает " + LIST_OF_STUDENTS_MARKS[studentIndex].name);
                System.out.print("Присутствует ли на паре? (д или н): ");
                String answer = in.next();
                while (!answer.equals("д") && !answer.equals("н")) {
                    System.out.print("Присутствует ли на паре? (д или н): ");
                    answer = in.next();
                }
                if (answer.equals("н")) {
                    System.out.println("Ай-ай-ай, " + LIST_OF_STUDENTS_MARKS[studentIndex].name + " не пришёл(-ла) на пару(");
                    LIST_OF_STUDENTS_MARKS[studentIndex].alreadyAnswered = 1;
                } else {
                    LIST_OF_STUDENTS_MARKS[studentIndex].alreadyAnswered = 2;
                    System.out.print("Оценка за ответ: ");
                    int mark = in.nextInt();
                    while (mark < 0 || mark > 10) {
                        System.out.println("Оценка должна быть от 0 до 10");
                        System.out.print("Оценка за ответ: ");
                        mark = in.nextInt();
                    }
                    if (mark > 8) {
                        inflation++;
                    }
                    if (mark > 8 && inflation > 2) {
                        System.out.println("Не забывайте про инфляцию оценок, уже " + inflation + " оценок больше 8))");
                    }
                    LIST_OF_STUDENTS_MARKS[studentIndex].mark = mark;
                    System.out.println("Оценка записана");
                }
            }
        } else {
            System.out.println("Такого студента нет в списке");
        }
    }

    private static void chooseRandomStudent() {
        Scanner in = new Scanner(System.in);
        int studentIndex = (int) (Math.random() * 29);
        if (LIST_OF_STUDENTS_MARKS[studentIndex].alreadyAnswered != 0) {
            System.out.println(LIST_OF_STUDENTS_MARKS[studentIndex].name + " уже не первый раз попадается, вот ведь повезло");
        } else {
            System.out.println("Отвечает " + LIST_OF_STUDENTS_MARKS[studentIndex].name);
            System.out.print("Присутствует ли на паре? (д или н): ");
            String answer = in.next();
            while (!answer.equals("д") && !answer.equals("н")) {
                System.out.print("Присутствует ли на паре? (д или н): ");
                answer = in.next();
            }
            if (answer.equals("н")) {
                System.out.println("Ай-ай-ай, " + LIST_OF_STUDENTS_MARKS[studentIndex].name + " не пришёл(-ла) на пару(");
                LIST_OF_STUDENTS_MARKS[studentIndex].alreadyAnswered = 1;
            } else {
                LIST_OF_STUDENTS_MARKS[studentIndex].alreadyAnswered = 2;
                System.out.print("Оценка за ответ: ");
                int mark = in.nextInt();
                while (mark < 0 || mark > 10) {
                    System.out.println("Оценка должна быть от 0 до 10");
                    System.out.print("Оценка за ответ: ");
                    mark = in.nextInt();
                }
                if (mark > 8) {
                    inflation++;
                }
                if (mark > 8 && inflation > 2) {
                    System.out.println("Не забывайте про инфляцию оценок, уже " + inflation + " оценок больше 8))");
                }
                LIST_OF_STUDENTS_MARKS[studentIndex].mark = mark;
                System.out.println("Оценка записана");
            }
        }
    }

    private static void showAllStudents() {
        for (String listOfStudent : LIST_OF_STUDENTS) {
            System.out.println(listOfStudent);
        }
    }

    private static void showStudentMarks() {
        boolean someonePresent = false;
        for (int i = 0; i < LIST_OF_STUDENTS.length; i++) {
            if (LIST_OF_STUDENTS_MARKS[i].alreadyAnswered == 2) {
                System.out.println(LIST_OF_STUDENTS_MARKS[i].name + " : " + LIST_OF_STUDENTS_MARKS[i].mark);
                someonePresent = true;
            } else if (LIST_OF_STUDENTS_MARKS[i].alreadyAnswered == 1) {
                System.out.println(LIST_OF_STUDENTS_MARKS[i].name + " отсутствует на паре");
            }
        }
        if (!someonePresent) {
            System.out.println("Два варианта: пессимистичный (никто не пришёл на пару) и оптимистичный (просто Вы пока что никого не спросили)");
        }
    }

    private static void showStudentInformation() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите ФИО студента: ");
        String surname = in.nextLine();
        if (Arrays.asList(LIST_OF_STUDENTS).contains(surname)) {
            int studentIndex = Arrays.asList(LIST_OF_STUDENTS).indexOf(surname);
            if (LIST_OF_STUDENTS_MARKS[studentIndex].alreadyAnswered == 0) {
                System.out.println(LIST_OF_STUDENTS_MARKS[studentIndex].name);
                System.out.println("Нет информации присутствует ли на паре");
            } else {
                if (LIST_OF_STUDENTS_MARKS[studentIndex].alreadyAnswered == 1) {
                    System.out.println(LIST_OF_STUDENTS_MARKS[studentIndex].name);
                    System.out.println("Отсутствует на паре");
                } else {
                    System.out.println(LIST_OF_STUDENTS_MARKS[studentIndex].name);
                    System.out.println("Присутствует на паре");
                    System.out.println("Получил(-а) оценку: " + LIST_OF_STUDENTS_MARKS[studentIndex].mark);
                }
            }
        } else {
            System.out.println("Такого студента нет в списке");
        }
    }
}
