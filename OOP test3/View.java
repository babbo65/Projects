package test3;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.Hashtable;
public class View
{
    private JFrame frame;
    private JSlider slider;
    private JPanel slPanel;
    private JPanel shPanel;
    private JPanel panel;
    private JPanel topPanel;
    private Triangle triangle;
    private Circle circle;
    private Rectangle rectangle;
    private JPanel botPanel;
    private JLabel label;
    private JLabel shapelabel;
    private JButton Rbutton;
    private JButton Tbutton;
    private JButton Cbutton;
    private JButton RedButton;
    private JButton BlueButton;
    private JButton YellowButton;
    private char S;
    public View() 
    {
        frame=new JFrame("Test 3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        
        panel = new JPanel();
        topPanel=new JPanel(new FlowLayout());
        botPanel=new JPanel(new FlowLayout());
        

        slider=new JSlider(JSlider.VERTICAL, 20, 150, 20);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        
        Hashtable<Integer, JLabel> position=new Hashtable<Integer, JLabel>();
        position.put(20, new JLabel("20"));
        position.put(30, new JLabel("30"));
        position.put(40, new JLabel("40"));
        position.put(50, new JLabel("50"));
        position.put(60, new JLabel("60"));
        position.put(70, new JLabel("70"));
        position.put(80, new JLabel("80"));
        position.put(90, new JLabel("90"));
        position.put(100, new JLabel("100"));
        position.put(110, new JLabel("110"));
        position.put(120, new JLabel("120"));
        position.put(130, new JLabel("130"));
        position.put(140, new JLabel("140"));
        position.put(150, new JLabel("150"));
        slider.setLabelTable(position);
        
        slPanel=new JPanel();
        slPanel.setLayout(new BorderLayout());
        panel.add(slider);
        frame.add(panel, BorderLayout.WEST);
        
        triangle=new Triangle(150, Color.RED);
        S='t';
        shapelabel=new JLabel(triangle);
        shPanel=new JPanel(new BorderLayout());
        shPanel.add(shapelabel);
        frame.add(shPanel, BorderLayout.CENTER);

        Rbutton=new JButton("Rectangle");
        Tbutton=new JButton("Triangle");
        Cbutton=new JButton("Circle");
        topPanel.add(Rbutton);
        topPanel.add(Tbutton);
        topPanel.add(Cbutton);
        frame.add(topPanel, BorderLayout.NORTH);
        
        RedButton=new JButton("Red");
        BlueButton=new JButton("Blue");
        YellowButton=new JButton("Yellow");
        botPanel.add(RedButton);
        botPanel.add(BlueButton);
        botPanel.add(YellowButton);
        frame.add(botPanel, BorderLayout.SOUTH);
        
        frame.pack();
        frame.setVisible(true);
    }
    public void changeColor(Color color)
    {
        if(S=='t')
            triangle.setColor(color);
        else if(S=='c')
            circle.setColor(color);
        else
            rectangle.setColor(color);
    }
    public void changeSize(int size)
    {
        if(S=='t')
            triangle.changeSize(size);
        else if(S=='c')
            circle.changeSize(size);
        else
            rectangle.changeSize(size);
    }
    public Color getColor()
    {
        if(S=='t')
            return triangle.getColor();
        else if(S=='c')
            return circle.getColor();
        else
            return rectangle.getColor();
    }
    public int getSize()
    {
        if(S=='t')
            return triangle.getSize();
        else if(S=='c')
            return circle.getSize();
        else
            return rectangle.getSize();
    }
    public void deleteShape()
    {
        frame.remove(shPanel);
    }
    public void refresh()
    {
        frame.revalidate();
        frame.repaint();
    }
    public void changeShapeToCircle()
    {
        circle=new Circle(150, Color.RED);
        S='c';
        shapelabel=new JLabel(circle);
        shPanel=new JPanel();
        shPanel.add(shapelabel);
        frame.add(shPanel, BorderLayout.CENTER);
    }
    public void changeShapeToTriangle()
    {
        triangle=new Triangle(150, Color.RED);
        S='t';
        shapelabel=new JLabel(triangle);
        shPanel=new JPanel();
        shPanel.add(shapelabel);
        frame.add(shPanel, BorderLayout.CENTER);
    }
    public void changeShapeToRectangle()
    {
        rectangle=new Rectangle(150, Color.RED);
        S='r';
        shapelabel=new JLabel(rectangle);
        shPanel=new JPanel();
        shPanel.add(shapelabel);
        frame.add(shPanel, BorderLayout.CENTER);
    }
    public JSlider getSlider()
    {
        return slider;
    }
    public JButton getRedButton()
    {
        return RedButton;
    }
    public JButton getBlueButton()
    {
        return BlueButton;
    }
    public JButton getYellowButton()
    {
        return YellowButton;
    }   
    public JButton getRbutton()
    {
        return Rbutton;
    }
    public JButton getTbutton()
    {
        return Tbutton;
    }
    public JButton getCbutton()
    {
        return Cbutton;
    }
}
class Triangle implements Icon
{
    public int size;
    public int height;
    public int width;
    public Color color;
    Triangle(int size, Color color)
    {
        this.size=size;
        height=size;
        width=size;
        this.color=color;
    }
    public int getSize()
    {
        return size;
    }
    public int getIconHeight()
    {
        return height;
    }
    public int getIconWidth()
    {
        return width;
    }
    public void setColor(Color color)
    {
        this.color=color;
    }
    public Color getColor()
    {
        return color;
    }
    public void changeSize(int size)
    {
        width=size;
        height=size;
        this.size=size;
    }
    public void paintIcon(Component c, Graphics g, int x, int y)
    {
        Graphics2D g2=(Graphics2D) g;
        int[] p={0, size/2, size};
        int[] q={size,0,size};
        Polygon tri=new Polygon(p, q, 3);
        g2.setColor(color);
        g2.fill(tri);
    }
}
class Circle implements Icon
{
    public int size;
    public int height;
    public int width;
    public Color color;
    Circle(int size, Color color)
    {
        this.size=size;
        height=size;
        width=size;
        this.color=color;
    }
    public int getSize()
    {
        return size;
    }
    public int getIconHeight()
    {
        return height;
    }
    public int getIconWidth()
    {
        return width;
    }
    public void setColor(Color color)
    {
        this.color=color;
    }
    public Color getColor()
    {
        return color;
    }
    public void changeSize(int size)
    {
        width=size;
        height=size;
    }
    public void paintIcon(Component c, Graphics g, int x, int y)
    {
        Graphics2D g2=(Graphics2D) g;
        Ellipse2D.Double circle=new Ellipse2D.Double(x, y, width, height);
        g2.setColor(color);
        g2.fill(circle);
    }
}
class Rectangle implements Icon
{
    public int size;
    public int height;
    public int width;
    public Color color;
    Rectangle(int size, Color color)
    {
        this.size=size;
        height=size;
        width=size;
        this.color=color;
    }
    public int getSize()
    {
        return size;
    }
    public int getIconHeight()
    {
        return height;
    }
    public int getIconWidth()
    {
        return width;
    }
    public void setColor(Color color)
    {
        this.color=color;
    }
    public Color getColor()
    {
        return color;
    }
    public void changeSize(int size)
    {
        width=size;
        height=size;
    }
    public void paintIcon(Component c, Graphics g, int x, int y)
    {
        Graphics2D g2=(Graphics2D) g;
        Rectangle2D.Double rectangle=new Rectangle2D.Double(x, y, width, height);
        g2.setColor(color);
        g2.fill(rectangle);
    }
}