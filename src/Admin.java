public class Admin extends User {

    private String adminId;

    public Admin(int userId, String name, String email, String password, String adminId) {
        super(userId, name, email, password);
        this.adminId = adminId;
    }

    public void monitorOccupancy() {
        System.out.println("Monitoring seat occupancy");
    }
    public void viewReservationActivity() {
        System.out.println("View reservation activity");
    }

    public void grantPriority(Student student) {
        student.setPriority(true);

        System.out.println(student.getName() + " has changed to prioritized user.");
    }
}
