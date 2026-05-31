//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LibrarySystem system = LibrarySystem.getInstance();

        Student student1 = new Student(
                1,
                "Asli",
                "asli@gmail.com",
                "123",
                "2372048",
                false
        );

        Student priorityStudent = new Student(
                2,
                "Asma",
                "asma@gmail.com",
                "123",
                "2355500",
                true
        );

        Seat seat1 = new Seat(101);
        Seat seat2 = new Seat(102);
        Seat seat3 = new Seat(103);

        Book book1 = new Book(
                1,
                "Design Patterns",
                "Gamma"
        );

        system.addUser(student1);
        system.addUser(priorityStudent);

        system.addSeat(seat1);
        system.addSeat(seat2);
        system.addSeat(seat3);

        system.addBook(book1);

        ReservationStrategy normalStrategy = new NormalReservationStrategy();
        ReservationStrategy priorityStrategy = new PriorityReservationStrategy();

        System.out.println("Welcome to SmartLibrary Management System!");

        System.out.println("Please enter your E-mail: ");
        String email = scanner.nextLine();

        System.out.println("Please enter your Password: ");
        String password = scanner.nextLine();

        Student currentStudent = system.login(email,password);
        if(currentStudent == null) {
            System.out.println("Invalid email or password.");
            return;
        }
        System.out.println("Login successful. Welcome " + currentStudent.getName() + "!");

        System.out.println("\nWhat would you like to do?");

        boolean running= true;

        while(running) {

            System.out.println("1. Normal Seat Reservation");
            System.out.println("2. Priority Seat Reservation");
            System.out.println("3. Cancel Seat Reservation");
            System.out.println("4. Search Book");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Pay Fine");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();


            switch (choice) {

                case 1:
                    System.out.println("Normal Seat Reservation selected.");

                    system.showAvailableSeats();
                    if(!system.hasAvailableSeats()) {
                        System.out.println("No seats available. ");
                        System.out.println("Do you want to join the waiting list? ");
                        System.out.println("1. Yes");
                        System.out.println("2. No");

                        int waitingChoice = scanner.nextInt();

                        if(waitingChoice == 1) {
                            System.out.println("You have been added to the waiting list.");
                        }

                        returnToMenu(scanner);
                        break;
                    }

                    System.out.println("Enter seat number: ");
                    int seatNumber = scanner.nextInt();

                    Seat selectedSeat = system.findSeatById(seatNumber);

                    if(selectedSeat != null && selectedSeat.isAvailable()) {

                        System.out.println("Your reservation is successful.");
                        System.out.println("Reserved seat number: "+ selectedSeat.getSeatId());

                        system.reserveSeat(
                                currentStudent,
                                selectedSeat,
                                normalStrategy
                        );

                    } else{
                        System.out.println("Invalid seat selection.");
                    }

                    returnToMenu(scanner);
                    break;

                case 2:

                    System.out.println("Priority Seat Reservation selected.");

                    if (!currentStudent.isPriority()) {
                        System.out.println("You are not eligible for priority reservation.");
                        returnToMenu(scanner);
                        break;
                    }

                    system.showAvailableSeats();

                    if (!system.hasAvailableSeats()) {

                        System.out.println("No seats available.");
                        System.out.println("Do you want to join the priority waiting list?");
                        System.out.println("1. Yes");
                        System.out.println("2. No");

                        int waitingChoice = scanner.nextInt();

                        if (waitingChoice == 1) {
                            system.joinWaitingList(currentStudent);
                            System.out.println("You have been added to the priority waiting list.");
                        }

                        returnToMenu(scanner);
                        break;
                    }

                    System.out.print("Enter seat number: ");
                    int prioritySeatNumber = scanner.nextInt();

                    Seat prioritySelectedSeat = system.findSeatById(prioritySeatNumber);

                    if (prioritySelectedSeat != null && prioritySelectedSeat.isAvailable()) {

                        System.out.println("Your priority reservation is successful.");
                        System.out.println("Reserved seat number: " + prioritySelectedSeat.getSeatId());

                        system.reserveSeat(
                                currentStudent,
                                prioritySelectedSeat,
                                priorityStrategy
                        );
                    } else {
                        System.out.println("Invalid seat selection.");
                    }

                    returnToMenu(scanner);
                    break;

                case 3:

                    System.out.println("Cancel Seat Reservation selected.");

                    System.out.print("Enter seat number to cancel: ");
                    int cancelSeatNumber = scanner.nextInt();

                    Seat seatToCancel = system.findSeatById(cancelSeatNumber);

                    if (seatToCancel != null && !seatToCancel.isAvailable()) {

                        system.cancelReservation(currentStudent, seatToCancel);

                        System.out.println("Reservation cancelled successfully.");
                        System.out.println("Cancelled seat number: " + seatToCancel.getSeatId());

                    } else {
                        System.out.println("Invalid seat number or seat is not reserved.");
                    }

                    returnToMenu(scanner);
                    break;

                case 4:
                    System.out.println("Search Book selected.");
                    returnToMenu(scanner);
                    break;

                case 5:
                    System.out.println("Borrow Book selected.");
                    returnToMenu(scanner);
                    break;

                case 6:
                    System.out.println("Return Book selected.");
                    returnToMenu(scanner);
                    break;

                case 7:
                    System.out.println("Pay Fine selected.");
                    returnToMenu(scanner);
                    break;

                case 8:
                    System.out.println("Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        }
    public static void returnToMenu(Scanner scanner){
        System.out.println("\nPress 0 to return to Main Menu");

        while(scanner.nextInt() !=0){
            System.out.println("Invalid choice.");
        }
    }
    }