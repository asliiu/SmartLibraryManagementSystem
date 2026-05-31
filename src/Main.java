//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        LibrarySystem system = LibrarySystem.getInstance();

        Student student1 = new Student(
                1,
                "Asli",
                "asli@gmail.com",
                "2372048",
                false
        );

        Student priorityStudent = new Student(
                2,
                "Asma",
                "asma@gmail.com",
                "2355500",
                true
        );

        Seat seat1 = new Seat(101);

        Book book1 = new Book(
                1,
                "Design Patterns",
                "Gamma"
        );

        system.addUser(student1);
        system.addUser(priorityStudent);

        system.addSeat(seat1);
        system.addBook(book1);

        ReservationStrategy normalStrategy = new NormalReservationStrategy();
        ReservationStrategy priorityStrategy = new PriorityReservationStrategy();

        System.out.println("---Normal Reservation---");

        system.reserveSeat(
                student1,
                seat1,
                normalStrategy
        );

        System.out.println();
        System.out.println("---Priority Reservation---");

        system.reserveSeat(
                priorityStudent,
                seat1,
                priorityStrategy
        );

        System.out.println();
        System.out.println("---Book Borrowing---");

        system.borrowBook(
                student1,
                book1
        );

        System.out.println();
        System.out.println("---Book Return---");

        system.returnBook(
                student1,
                book1
        );

    }
}