import GUI.HomePage;
import javax.swing.*;

public class main {
    public static void main(String[] args ){
        JFrame frame = new JFrame("HomePage");
        frame.setContentPane(new HomePage().getHomePageView());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
