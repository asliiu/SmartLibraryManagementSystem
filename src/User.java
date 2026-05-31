public class User {
    protected int userId;
    protected String name;
    protected String email;

    public User(int userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public void login() {
        System.out.println(name + "logged in");
    }
    public void logout() {
        System.out.println(name + "logged out");
    }
    public String getName(){
        return name;
    }
}
