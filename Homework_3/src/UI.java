import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

public class UI extends JComponent implements MouseMotionListener {
int imageX, imageY;
    Image imagep, imagec, images, imageh;

    public UI(Image ps, Image c, Image s, Image h) {
      imagep = ps;
      imagec = c;
      images = s;
      imageh = h;
      addMouseMotionListener(this);
    }

    public void mouseDragged(MouseEvent e) {
      imageX = e.getX();
      imageY = e.getY();
      repaint();
    }
    public void mouseMoved(MouseEvent e) {}

    public void paint(Graphics g) {
      Graphics2D g2 = (Graphics2D)g;
      g2.drawImage(imagec, 0, 0, this);
      g2.drawImage(imagep, 100, 60, this);
      g2.drawImage(images, 450, 150, this);
      g2.drawImage(imageh, 875, 30, this);
    }
    static int imageWidth=60, imageHeight=60;
    public static void main(String[] args) {
       String Police = "/resource/PoliceStation.jpg";
       String City = "/resource/City.jpg";
       String School = "/resource/school.png";
       String CityHall = "/resource/cityHall.jpg";
       String officer = "/resource/police.jpg";
       String kid = "/resource/kid.jpg";
       String teacher = "/resource/teacher.jpg";

       Image imagec = Toolkit.getDefaultToolkit().getImage(UI.class.getResource(City));
       
       Image imagep = Toolkit.getDefaultToolkit().getImage(UI.class.getResource(Police));
       imagep = imagep.getScaledInstance(200,200,Image.SCALE_DEFAULT);
       
       Image images = Toolkit.getDefaultToolkit().getImage(UI.class.getResource(School));
       images = images.getScaledInstance(350, 400, Image.SCALE_SMOOTH);
       
       Image imageh = Toolkit.getDefaultToolkit().getImage(UI.class.getResource(CityHall));
       imageh = imageh.getScaledInstance(200,200,Image.SCALE_DEFAULT);
       
       JFrame frame = new JFrame("Simville");
       frame.add( new UI(imagep, imagec, images, imageh) );
       frame.setSize(1400, 900);
       frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
       frame.setVisible(true);
     }
 }
