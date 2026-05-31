public class PriorityReservationStrategy implements ReservationStrategy{
    @Override
    public boolean reserveSeat(Student student, Seat seat) {
        if(!student.isPriority()){
            System.out.println(student.getName() + "is not eligible for priority reservation.");
            return false;
        }

        if(seat.isAvailable()){
            seat.reserve();
            System.out.println("Priority reservation is created for "+student.getName()+ ".");
            return true;
        }
        System.out.println("Seat is not available. Priority student added to the front of the waiting list.");
        return false;
    }

}
