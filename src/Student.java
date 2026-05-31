public class Student extends User implements Observer {

    private String studentNo;
    private boolean priority;

    public Student(int userId, String name, String email, String password, String studentNo, boolean priority) {
        super(userId, name, email,password);
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
    public void receiveNotification() {
        System.out.println("Notification received.");
    }

    @Override
    public void update(String message){
        System.out.println("\nNotification sent to "+ getName() + ": " + message);
    }

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    public String getStudentNo() {
        return studentNo;
    }
}
