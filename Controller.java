package test3;
import java.awt.event.*;
import javax.swing.event.* ;
import java.awt.*;
import javax.swing.JSlider;

public class Controller
{
    private Model model;
    private View view;
    private ActionListener actionListener;
    Color color;
    int size;
    public Controller(Model model, View view)
    {
        this.model=model;
        this.view=view;
    }
    public void control()
    {
        view.getSlider().addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e){
                model.changeSize(((JSlider)e.getSource()).getValue());
                view.refresh();
            }
        });
        view.getTbutton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent)
            {
                color=model.getColor();
                size=model.getSize();
                view.deleteShape();
                view.changeShapeToTriangle();
                view.changeColor(color);
                model.changeSize(size);
                view.refresh();
            }
        });
        view.getRbutton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent)
            {
                color=model.getColor();
                size=model.getSize();
                view.deleteShape();
                view.changeShapeToRectangle();
                view.changeColor(color);
                model.changeSize(size);
                view.refresh();
            }
        });
        view.getCbutton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent)
            {
                color=model.getColor();
                size=model.getSize();
                view.deleteShape();
                view.changeShapeToCircle();
                view.changeColor(color);
                model.changeSize(size);
                view.refresh();
            }
        });
        view.getRedButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent)
            {
                view.changeColor(Color.RED);
                view.refresh();
            }
        });
        view.getYellowButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent)
            {
                view.changeColor(Color.YELLOW);
                view.refresh();
            }
        });
        view.getBlueButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent)
            {
                view.changeColor(Color.BLUE);
                view.refresh();
            }
        });
    }
}