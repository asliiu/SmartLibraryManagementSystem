public class NormalReservationStrategy implements ReservationStrategy {
    @Override
    public boolean reserveSeat(Student student, Seat seat) {
        if (seat.isAvailable()) {
            seat.reserve();
            return true;
        }
        System.out.println("Seat is not available." + student.getName() + "Can join the waiting list.");
        return false;
    }

}
