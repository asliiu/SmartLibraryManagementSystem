public class Student extends User {

    private String studentNo;
    private boolean priority;

    public Student(int userId, String name, String email, String studentNo, boolean priority) {
        super(userId, name, email);
        this.studentNo = studentNo;
        this.priority = priority;
    }

    public void  reserveSeat() {
        System.out.println("Seat is reserved.");
    }
    public void cancelReservation() {
        System.out.println("Reservation got cancelled.");
    }
    public void borrowBook() {
        System.out.println("Book is borrowed.");
    }
    public void returnBook() {
        System.out.println("Book is returned.");
    }
    public boolean isPriority() {
        return priority;
    }
    public void receiveNotification() {
        System.out.println("Notification received.");
    }
    public String getStudentNo() {
        return studentNo;
    }
}
