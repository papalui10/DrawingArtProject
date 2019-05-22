package view;

import javax.swing.JFrame;
import controller.ArtController;

public class DrawingFrame extends JFrame
{
	private ArtController app;
	
	public DrawingFrame(ArtController app)
	{
		super();
		this.app = app;
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setSize(1000, 800);
		this.setResizable(false);
		this.setVisible(true);
	}
}
