import java.awt.*;

public class Test {
    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double height = screenSize.getHeight();
        double width = screenSize.getWidth();
        System.out.println("height:"+height);
        System.out.println("width:"+width);
        System.out.println(5* (-1));
    }
}
