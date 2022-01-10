package constant;

public class Check {
    String berry = "blue";

    public static void main(String[] args) {
        new Check().juicy("straw");
    }

    void juicy(String berry) {
        this.berry = "rasp";
        System.out.println(berry + "berry");
    }
}
