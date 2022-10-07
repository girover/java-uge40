import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) {

        // Color red = new Color(255, 0, 0);
        // Color color = new Color(155, 17, 100);
        // Color black = new Color();

        // System.out.println(red.toString());
        // System.out.println(black.toString());
        // System.out.println(color.toString());
        // System.out.println(red.equals(red));

        // MoneyBox box1 = new MoneyBox();
        // box1.set(20, 5);
        // box1.set(10, 10);
        // box1.set(5, 20);
        // box1.set(2, 50);
        // box1.set(1, 100);
        
        MoneyBox box2 = new MoneyBox();
        box2.set(20, 5);
        box2.set(10, 10);
        box2.set(5, 20);
        box2.set(2, 50);
        box2.set(1, 100);
        
        // box2.add(box1);
        System.out.println(box2);
        System.out.printf("The whole amount in the MoneyBox is: [ %d ]%n", box2.sum());
        System.out.println(box2.getMoneyBox(477));
        System.out.println(box2);

    }
}
