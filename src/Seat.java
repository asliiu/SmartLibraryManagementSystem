public class Seat {
    private int seatId;
    private String status;

    public Seat(int seatId) {
        this.seatId = seatId;
        this.status = "Available";
    }

    public void  reserve() {
        status = "Reserved";
    }
    public void release() {
        status = "Available";
        System.out.println("Seat " + seatId + " is now available.");
    }
    public boolean isAvailable() {
        return status.equals("Available");
    }
    public int getSeatId() {
        return seatId;
    }
    public String getStatus() {
        return status;
    }

}
