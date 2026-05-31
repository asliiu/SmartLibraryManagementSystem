public class BorrowRecord {
    private String borrowDate;
    private String dueDate;
    private String returnDate;

    public BorrowRecord(String borrowDate, String dueDate) {
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }

    public void returnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getBorrowDate() {
        return borrowDate;
    }
    public String getDueDate() {
        return dueDate;
    }
    public String getReturnDate() {
        return returnDate;
    }
}
