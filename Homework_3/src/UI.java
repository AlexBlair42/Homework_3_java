import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

/**
 * This is the User Interface for my city. 
 * If you click run and then drag the window to one side of the screen
 * The characters are movable
 * as well as if you click on each character there will be information that is printed about each one. 
 * @author Alex Blair
 * @version 1.2
 */

public class UI extends JComponent implements MouseMotionListener, MouseListener {

	/**
	 * This is where the variables for this class are initialized. 
	 */
int imageX, imageY;

int dragged = 0;

int PoliceX = 1100;
int PoliceY = 700;

int TeacherX = 50;
int TeacherY = 450;

int KidX = 50;
int KidY = 50;

int z = 0;


/**
 * Initialize the image variables.
 */
    Image imagep, imagec, images, imageh, imageo, imaget, imagek;
    
/**
 * This is where i set the people in my city.
 */
    Person[] citizens = {new Teacher("Mrs. Sims", 35, 6585233,6, "Education"), new Police("Sargent Anderson" , 26, 3632541, Police.Role.Sargent), new Kid("Timmy", 8, 3632540, "Twix")};
    
    String PoliceOfficer = citizens[1].getName();
    String Teacher1 = citizens[0].getName();
    String Kid1 = citizens[2].getName();
    
    Building[] buildings = {new CityHall("City Hall", "125 Raspberry Ln"), new School("Simville Elementary", "363 Pike Pl.")};
    
    School s = (School) buildings[1];
    CityHall c = (CityHall) buildings[0];
    
/**
 * This is the constructor for the UI class and it takes the image variables as parameters.
 * @param ps
 * @param c
 * @param s
 * @param h
 * @param o
 * @param t
 * @param k
 */
    public UI(Image ps, Image c, Image s, Image h, Image o, Image t, Image k) {
      imagep = ps;
      imagec = c;
      images = s;
      imageh = h;
      imageo = o;
      imaget = t;
      imagek = k;
      addMouseMotionListener(this);
      addMouseListener(this);
    }
    
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    
    /**
     * This function sets parameters for the mouse to be pressed and how that registers with the system.
     */
    public void mousePressed(MouseEvent e)
    {
    	if (e.getX() >= PoliceX && e.getX() <= PoliceX + 100 && e.getY()>= PoliceY && e.getY() <= PoliceY +100)
    	{
			dragged = 1;
    	}
		else if (e.getX() >= TeacherX && e.getX() <= TeacherX + 100 && e.getY()>= TeacherY && e.getY() <= TeacherY +100)
		{
			dragged = 2;
		}
		else if (e.getX() >= KidX && e.getX() <= KidX + 100 && e.getY()>= KidY && e.getY() <= KidY +100)
		{
			dragged = 3;
		}
    }
    
    public void mouseReleased(MouseEvent e)
    {
    	dragged = 0;
    }
    
    
    /**
     * This is where The information for if the mouse is clicked on a person is handeled. 
     */
    public void mouseClicked(MouseEvent e)
    {
    	if(e.getY() > 400 && e.getY() < 600 && e.getX() >700 && e.getX()<900){
			System.out.printf("%s,%s\n",buildings[1].Name,buildings[1].Address);
			s.showOccupants();
		}
		
		else if (e.getY() > 0 && e.getY() < 150 && e.getX() > 350 && e.getX() < 500)
		{
			System.out.printf("%s,%s\n",buildings[0].Name,buildings[0].Address);
			c.showOccupants();
		}
		else if (e.getX() > KidX && e.getX()< KidX +100 && e.getY() > KidY && e.getY() < KidY +100){
			System.out.printf("%s\n",citizens[2].getName());
		}
		else if (e.getX()> PoliceX && e.getX() < PoliceX +100 && e.getY() > PoliceY && e.getY() < PoliceY+100){
			Police p1=(Police) citizens[1];
			System.out.printf("%s\n",citizens[1].getName());
		}
		else if (e.getX()>TeacherX && e.getX() < TeacherX +100 && e.getY() > TeacherY && e.getY() < TeacherY +100){
			System.out.printf("%s\n",citizens[0].getName());
		}
    	
    }
    
    
    /**
     * This function keeps track of how the mouse reacts on screen to being dragged.
     */
    public void mouseDragged(MouseEvent e) {
    	if (dragged == 0) {
    		if (e.getX() >= PoliceX && e.getX() <= PoliceX + 75 && e.getY() >= PoliceY && e.getY() <= PoliceY+100)
    		{
    			dragged = 1;
    		}
    		else if(e.getX() >= TeacherX && e.getX() <= TeacherX + 150 && e.getY() >= TeacherY && e.getY() <= TeacherY + 100)
    		{
    			dragged = 2;
    		}
    		else if (e.getX() >= KidX && e.getX() <= KidX + 100 && e.getY() >= KidY && e.getY() <= KidY + 125)
    		{
    			dragged = 3;
    		}
    	}
    	if (dragged == 1) {
	      PoliceX = e.getX();
	      PoliceY = e.getY();
    	}
    	else if (dragged == 2)
    	{
    	TeacherX = e.getX();
      	TeacherY = e.getY();
    	}
    	else if (dragged == 3)
    	{
    	KidX = e.getX();
    	KidY = e.getY();
    	}
      repaint();
    }
    
    public void mouseMoved(MouseEvent e) {}

    /**
     * Create a paint function to make images appear.
     */
    public void paint(Graphics g) {
      Graphics2D g2 = (Graphics2D)g;
      g2.drawImage(imagec, 0, 0, this);
      g2.drawImage(imagep, 100, 60, this);
      g2.drawImage(images, 450, 150, this);
      g2.drawImage(imageh, 875, 30, this);
      g2.drawImage(imageo, PoliceX, PoliceY, this);
      g2.drawImage(imaget, TeacherX, TeacherY, this);
      g2.drawImage(imagek, KidX, KidY, this);
    }
    public static void main(String[] args) {
    	
    	/**
    	 * Import the appropriate images from the resource folder.
    	 */
    	String Police = "/resource/PoliceStation.jpg";
       String City = "/resource/City.jpg";
       String School = "/resource/school.png";
       String CityHall = "/resource/cityHall.jpg";
       String officer = "/resource/police.jpg";
       String kid = "/resource/kid.jpg";
       String teacher = "/resource/teacher.jpg";

       /**
        * This is the creation of each picture element in the UI.
        */
       Image imagec = Toolkit.getDefaultToolkit().getImage(UI.class.getResource(City));
       
       Image imagep = Toolkit.getDefaultToolkit().getImage(UI.class.getResource(Police));
       imagep = imagep.getScaledInstance(200,200,Image.SCALE_DEFAULT);
       
       Image images = Toolkit.getDefaultToolkit().getImage(UI.class.getResource(School));
       images = images.getScaledInstance(350, 400, Image.SCALE_SMOOTH);
       
       Image imageh = Toolkit.getDefaultToolkit().getImage(UI.class.getResource(CityHall));
       imageh = imageh.getScaledInstance(200,200,Image.SCALE_DEFAULT);
       
       Image imageo = Toolkit.getDefaultToolkit().getImage(UI.class.getResource(officer));
       imageo = imageo.getScaledInstance(75, 100, Image.SCALE_SMOOTH);
       
       Image imaget = Toolkit.getDefaultToolkit().getImage(UI.class.getResource(teacher));
       imaget = imaget.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
       
       Image imagek = Toolkit.getDefaultToolkit().getImage(UI.class.getResource(kid));
       imagek = imagek.getScaledInstance(100, 125, Image.SCALE_SMOOTH);
       
       /**
        * Create the JFrame
        */
       JFrame frame = new JFrame("Simville");
       frame.add( new UI(imagep, imagec, images, imageh, imageo, imaget, imagek) );
       frame.setSize(1400, 1000);
       frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
       frame.setVisible(true);
     }
 }
