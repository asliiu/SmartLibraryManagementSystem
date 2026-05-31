public class NormalReservationStrategy implements ReservationStrategy {
    @Override
    public boolean reserveSeat(Student student, Seat seat) {
        if (seat.isAvailable()) {
            seat.reserve();
            System.out.println("Seat has been reserved for: " + student.getName());
            return true;
        }
        System.out.println("Seat is not available." + student.getName() + "Can join the waiting list.");
        return false;
    }

}
