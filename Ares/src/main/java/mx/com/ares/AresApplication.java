package mx.com.ares;


public class AresApplication {

    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new AresApplication().getGreeting());
    }

}
