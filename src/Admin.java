public class Admin extends User {

    private String adminId;

    public Admin(int userId, String name, String email, String adminId) {
        super(userId, name, email);
        this.adminId = adminId;
    }

    public void monitorOccupancy() {
        System.out.println("Monitoring seat occupancy");
    }
    public void viewReservationActivity() {
        System.out.println("View reservation activity");
    }
}
