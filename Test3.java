package test3;
import javax.swing.*;
import java.awt.*;
class Test3
{
    public static void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                View view=new View();
                Model model=new Model(view);
                Controller controller=new Controller(model, view);
                controller.control();
            }
        });
    }
}