import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {
    private static LibrarySystem instance;

    private List<Seat> seats;
    private List<Reservation> reservations;
    private List<Book> books;
    private List<User> users;

    private NotificationService notificationService;

    private LibrarySystem() {
        seats = new ArrayList<>();
        reservations = new ArrayList<>();
        books = new ArrayList<>();
        users = new ArrayList<>();
        notificationService = new NotificationService();
    }
    public static LibrarySystem getInstance() {
        if (instance == null) {
            instance = new LibrarySystem();
        }
        return instance;
    }

    public void addSeat(Seat seat){
        seats.add(seat);
    }
    public void addBook(Book book){
        books.add(book);
    }
    public void addUser(User user){
        users.add(user);
    }

    public void reserveSeat(Student student, Seat seat, ReservationStrategy strategy) {
        boolean success=strategy.reserveSeat(student,seat);

        if(success){
            notificationService.reservationConfirmationNotification(student);
        }else
            notificationService.sendNotification(student, "Seat is not available. You can join the waiting list.");
    }
    public void cancelReservation(Student student, Seat seat) {
        seat.release();
        notificationService.sendNotification(student, "Your reservation has been cancelled.");
    }
    public Book searchBook(String title) {
        for (Book book : books){
             if (book.getTitle().equalsIgnoreCase(title)) {
                 return book;
             }
        }
        return null;
    }

    public void borrowBook(Student student, Book book) {
        if(book.isAvailable()){
            book.borrow();
            notificationService.borrowConfirmationNotification(student);
        }else
            notificationService.sendNotification(student, "Book is not available.");
        }
    public void returnBook(Student student, Book book) {
        book.returnBook();
        notificationService.sendNotification(student, "Book got returned successfully.");
    }

    }

