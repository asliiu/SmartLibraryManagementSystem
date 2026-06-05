import java.util.ArrayList;
import java.util.List;

public class NotificationService implements Subject {

    private List<Observer> observers;

    public NotificationService() {
        observers = new ArrayList<>();
    }

    @Override
    public void attach(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void sendNotification(Student student, String message) {
        student.update(message);
    }

    public void reservationConfirmationNotification(Student student, Seat seat) {
        student.update("Seat " + seat.getSeatId() + " has been reserved successfully.");
    }

    public void reservationExpiredNotification(Student student, Seat seat) {
        student.update("Your reservation for Seat " + seat.getSeatId() + " has expired because you did not check in within 15 minutes.");
    }

    public void seatAvailableNotification(Seat seat) {
        notifyObservers("Seat " + seat.getSeatId() + " is now available.");
    }

    public void borrowConfirmationNotification(Student student) {
        student.update("Book borrowed successfully.");
    }

    public void bookDeadlineNotification(Student student) {
        student.update("Your borrowed book is approaching its return deadline.");
    }
}