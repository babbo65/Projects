package test3;
import java.awt.event.*;
import javax.swing.event.* ;
import java.awt.*;
import javax.swing.JSlider;
public class Model
{
   Color color;
   View view;
   Model(View view)
   {
        this.view=view;
   }
   public Color getColor()
   {
       return view.getColor();
   }
   public int getSize()
   {
       return view.getSize();
   }
   public void changeSize(int size)
   {
       view.changeSize(size);
   }
}