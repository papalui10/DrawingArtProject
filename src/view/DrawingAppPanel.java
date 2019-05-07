package view;

import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;

import javax.swing.*;

import controller.ArtController;

public class DrawingAppPanel extends JPanel
{
	private ArtController app;
	private ArtPanel canvas;
	private JPanel colorPanel;
	private JPanel menuPanel;
	private JScrollPane canvasPane;
	private SpringLayout appLayout;


	public DrawingAppPanel(ArtController app)
	{
		super();
		
		setupSlider();
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupSlider()
	{
		Hashtable<Integer, JLabel> scaleLabels = new Hashtable<Integer, JLabel>();
		scaleLabels.put(MINIMUM_LINE, new JLabel("<HTML>Small<BR>Line</HTML>"));
		scaleLabels.put(MAXIMUM_LINE, new JLabel("<HTML>Large<BR>Line</HTML>"));
		widthSlider.setLabelTable(scaleLabels);
		widthSlider.setSnapToTicks(true);
		widthSlider.setMajorTickSpacing(5);
		widthSlider.setMinorTickSpacing(1);
		widthSlider.setPaintTicks(true);
		widthSlider.setPaintLabels(true);
		widthSlider.setValue((MAXIMUM_LINE + MINIMUM_LINE) / 2);
	}
	
	private void setupMenuPanels()
	{
		colorPanel.setPreferredSize(new Dimension(50, 700));
		menuPanel.setPreferredSize(new Dimension(50, 700));
		
		purpleButton.setForeground(new Color(75, 0, 130));
		blueButton.setForeground(Color.BLUE);
		greenButton.setForeground(Color.GREEN);
		orangeButton.setForeground(Color.ORANGE);
		redButton.setForeground(Color.RED);
		yellowButton.setForeground(Color.YELLOW);
		
		colorPanel.add(blackButton);
		colorPanel.add(purpleButton);
		colorPanel.add(blueButton);
		colorPanel.add(greenButton);
		colorPanel.add(yellowButton);
		colorPanel.add(orangeButton);
		colorPanel.add(redButon);
		colorPanel.add(whiteButton);
		colorPanel.add(randomColorButton);
		
		menuPanel.add(widthSlider);
		menuPanel.add(loadButton);
		menuPanel.add(saveButton);
		menuPanel.add(clearButton);
		
	}
	
	private void setupScrollPane()
	{
		canvasPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		canvasPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		canvasPane.setViewportView(canvas);
	}
	
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, colorPanel, 0, SpringLayout.NORTH, canvasPane);
		appLayout.putConstraint(SpringLayout.SOUTH, colorPanel, 0, SpringLayout.SOUTH, canvasPane);
		appLayout.putConstraint(SpringLayout.WEST, colorPanel, 50, SpringLayout.EAST, canvasPane);
		appLayout.putConstraint(SpringLayout.WEST, colorPanel, 0, SpringLayout.WEST, menuPanel);
		
		appLayout.putConstraint(SpringLayout.WEST, menuPanel, 200, SpringLayout.EAST, canvasPane);
		appLayout.putConstraint(SpringLayout.SOUTH, menuPanel, 0, SpringLayout.SOUTH, canvasPane);
		appLayout.putConstraint(SpringLayout.SOUTH, menuPanel, -50, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, menuPanel, pad, e2, c2);
	}
	
	private void setupListeners()
	{
		canvas.addMouseListener(new MouseListener()
		{
			public void mouseClikced(MouseEvent e)
			{
				
			}
			
			public void mousePressed(MouseEvent e)
			{
				
			}
			
			public void mouseReleased(MouseEvent e)
			{
				
			}
			
			public void mouseEntered(MouseEvent e)
			{
				
			}
			
			public void mouseExited(MouseEvent e)
			{
				
			}
		});
		
		canvas.addMouseMotionListner(new MouseMotionListener()
			{
				public void mouseDragged(MouseEvent e)
				{
					
				}
				
				public void mouseMoved(MouseEvent e)
				{
					
				}
		
			});
	}
}