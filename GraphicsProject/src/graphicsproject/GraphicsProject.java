package graphicsproject;

/**
 *
 * @author Tarana
 */

import java.awt.Color;
import java.util.Random;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.Animator;
import javax.swing.JFrame;

public class GraphicsProject implements GLEventListener
{
	 static GLProfile profile = GLProfile.get(GLProfile.GL2);
	 static GLCapabilities capabilities = new GLCapabilities(profile);
	 static GLCanvas glcanvas = new GLCanvas(capabilities);
	 GL2 gl;
	 public static Animator animator;
	 
	 double strawy=-0.65;
         double strawx=0.01;
         double strawyy=-0.65;
         double strawxx=0.01;
         
	 
         double cofy=0.4;
         double cofxleft=-.35;
	 double cofxright=.35; 
	 // Color variable for Background;
         double icey=.4;
	double BackR = 0.3;
	double BackG = 0.71;
	double BackB = 0.8;
	
        double cofr=.23;
        double cofg=.16;
        double cofb=.04;
	
	public static void main(String[]args)
	{
		GraphicsProject b  = new GraphicsProject();
			
	      glcanvas.addGLEventListener(b);                    //creating frame
	      glcanvas.setSize(800, 800);
	      final JFrame frame = new JFrame ("Final Project");
	                                                        //adding canvas to frame
	      frame.getContentPane().add(glcanvas);
	      frame.setSize(frame.getContentPane().getPreferredSize());
	
	      frame.setVisible(true);
	      glcanvas.addGLEventListener(new GraphicsProject());
	      animator = new Animator(glcanvas);
	      frame.setBackground(Color.red);
              
             
	      
              animator.start();	
	}

	 @Override
	public void display(GLAutoDrawable drawable) 
	{
		// System.out.println("Entered into display");
		
                
                final GL2 gl = drawable.getGL().getGL2();
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
	   gl.glClearColor((float) BackR, (float) BackG, (float) BackB, 1.0f); 
           BackR=BackR+.005;
           BackR=BackR+.005;
           BackR=BackR+.005;
		if(BackG>1||BackR>1||BackB>1){
                BackR=.3;BackG=.4;BackB=.5;
                }
           
                //glass
           gl.glBegin(GL2.GL_POLYGON);
             gl.glColor4d(1, 1, 1, 0.8f);
             gl.glVertex2d(-.4, .5);
             gl.glVertex2d(.4, .5);
             gl.glVertex2d(.3, -.7);
             gl.glVertex2d(-.3, -0.7);
           gl.glEnd();
                //coffee
            gl.glBegin(GL2.GL_POLYGON);
             gl.glColor4d(cofr, cofg,cofb, .8f);
             gl.glVertex2d(cofxleft, cofy);
             gl.glVertex2d(cofxright, cofy);
             gl.glVertex2d(.25, -.65);
             gl.glVertex2d(-0.25, -0.65);
           gl.glEnd();
           
                //straw
            gl.glBegin(GL2.GL_POLYGON);
             gl.glColor4d(1, 1, 1, 0.6f);
             gl.glVertex2d(.3, 1);
             gl.glVertex2d(.35, 1);
             gl.glVertex2d(0.05, -.65);
             gl.glVertex2d(0, -0.65);
           gl.glEnd();
           gl.glBegin(GL2.GL_POLYGON);
             gl.glColor4d(cofr, cofg, cofb, 0.6f);
             gl.glVertex2d(strawx, strawy);
             gl.glVertex2d(strawx+.03, strawy);
             gl.glVertex2d(strawxx+.03, strawyy);
             gl.glVertex2d(strawxx, strawyy);
           gl.glEnd();
                //ice
           gl.glBegin(GL2.GL_POLYGON);
             gl.glColor4d(.9,.9,1, 0.8f);
             gl.glVertex2d(-.25, icey);
             gl.glVertex2d(-.1, icey+.05);
             gl.glVertex2d(-0.1, icey-.1);
             gl.glVertex2d(-0.25, icey-.15);
           gl.glEnd();
           gl.glBegin(GL2.GL_POLYGON);
             gl.glColor4d(.9,.9,1, 0.8f);
             gl.glVertex2d(-.08, icey+.05);
             gl.glVertex2d(0.07, icey);
             gl.glVertex2d(0.07, icey-.15);
             gl.glVertex2d(-0.08, icey-.1);
           gl.glEnd();
            gl.glBegin(GL2.GL_POLYGON);
             gl.glColor4d(.9,.9,1, 0.8f);
             gl.glVertex2d(.1, icey);
             gl.glVertex2d(0.25, icey+.05);
             gl.glVertex2d(0.25, icey-.1);
             gl.glVertex2d(0.1, icey-.15);
           gl.glEnd();
           //oPACITY ENABLING
            gl.glEnable(GL2.GL_BLEND);
            gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
                if(strawy<1){
                    strawy=strawy+.01;
                    strawx=strawx+.01*.3/1.65;
                    cofy=cofy-.002;
                    cofxleft=cofxleft+.002*.1/1.05;
                    cofxright=cofxright-.002*.1/1.05;
                    icey=icey-.002;
                }
                else if(cofy>-.65){
                    cofy=cofy-.002;
                    cofxleft=cofxleft+.002*.1/1.05;
                    cofxright=cofxright-.002*.1/1.05;
                    if(icey>-.5)
                        icey=icey-.002;
                    }
                else{
                    strawyy=strawyy+.01;
                    strawxx=strawxx+.01*.3/1.65;
                }
                try {
                    Thread.sleep(2);                 //1000 milliseconds is one second.
                    } catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
   
		
	
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
	//	drawable.getGL().setSwapInterval(5);
	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3,
			int arg4) {
		// TODO Auto-generated method stub
		
	}

}
