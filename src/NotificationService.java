public class NotificationService {

    public void sendNotification(Student student, String message) {
        System.out.println("Notification got sent to " + student.getName() + ": " + message);
    }
    public void seatAvailableNotification(Student student) {
        sendNotification(student, "A seat is now available.");
    }
    public void BookDeadlineNotification(Student student) {
        sendNotification(student, "Your borrowed book is approaching its return deadline.");
    }
    public void borrowConfirmationNotification(Student student) {
        sendNotification(student,"Book borrowed successfully.");
    }
    public void reservationConfirmationNotification(Student student) {
        sendNotification(student, "Seat is reserved successfully.");
    }
    public void reservationExpiredNotification(Student student) {
        sendNotification(student, "Your seat reservation has expired.");
    }
}
