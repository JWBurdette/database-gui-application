//Joshua Burdette
package part_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

/**
 * Customized JButton to change shape and color.
 * credit for design to: https://happycoding.io/examples/java/swing/circle-button
 *
 * @author Joshua Burdette
 */
public class AddButton extends JButton
{
	
	/**
	 * Boolean for if mouse is pressed.
	 */
	private boolean mousePressed = false;
	
	/**
	 * Constructor that sets up appearance of
	 * button and mouse listeners.
	 *
	 * @param text is the text on the button.
	 */
	public AddButton(String text)
	{
		super(text);
		setOpaque(false);
		setFocusPainted(false);
		setBorderPainted(false);
		
		MouseAdapter mouseListener = new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent me)
			{
				if (contains(me.getX(), me.getY()))
				{
					mousePressed = true;
					repaint();
				}
			}
			
			@Override
			public void mouseReleased(MouseEvent me)
			{
				mousePressed = false;
				repaint();
			}
		};
		addMouseListener(mouseListener);
		addMouseMotionListener(mouseListener);
	}
	
	/**
	 * @return the diameter of the button.
	 */
	private int getDiameter()
	{
		int diameter = Math.min(getWidth(), getHeight());
		return diameter;
	}
	
	/**
	 * @return the dimensions that the button prefers.
	 */
	@Override
	public Dimension getPreferredSize()
	{
		FontMetrics metrics = getGraphics().getFontMetrics(getFont());
		int minDiameter = 10 + Math.max(metrics.stringWidth(getText()), metrics.getHeight());
		return new Dimension(minDiameter, minDiameter);
	}
	
	/**
	 * Define shape of button for mouse processing.
	 */
	@Override
	public boolean contains(int x, int y)
	{
		int radius = getDiameter() / 2;
		return Point2D.distance(x, y, getWidth() / 2, getHeight() / 2) < radius;
	}
	
	/**
	 * Sets the appearance of the button.
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		int diameter = getDiameter();
		int radius = diameter / 2;
		
		if (mousePressed)
		{
			g.setColor(Color.GREEN);
		} else
		{
			g.setColor(new Color(78, 255, 115));
		}
		g.fillOval(getWidth() / 2 - radius, getHeight() / 2 - radius, diameter, diameter);
		
		g.setColor(Color.BLACK);
		
		g.drawOval(getWidth() / 2 - radius, getHeight() / 2 - radius, diameter, diameter);
		
		g.setFont(getFont());
		FontMetrics metrics = g.getFontMetrics(getFont());
		int stringWidth = metrics.stringWidth(getText());
		int stringHeight = metrics.getHeight();
		g.drawString(getText(), getWidth() / 2 - stringWidth / 2, getHeight() / 2 + stringHeight / 4);
	}
}