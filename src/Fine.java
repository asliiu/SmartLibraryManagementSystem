public class Fine {

    private int FineId;
    private double amount;
    private boolean paid;

    public Fine(int fineId, double amount) {
        this.FineId = fineId;
        this.amount = amount;
        this.paid = false;
    }

    public void payFine() {
        paid = true;
        System.out.println("Fine paid successfully");
    }

    public double getAmount() {
        return amount;
    }

    public boolean isPaid() {
        return paid;
    }
}
