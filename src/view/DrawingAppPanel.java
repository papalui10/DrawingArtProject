package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import controller.ArtController;

public class DrawingAppPanel extends JPanel
{
	private ArtController app;
	private Color currentColor;
	private BufferedImage currentCanvas;
	


	public DrawingAppPanel(ArtController app)
	{
		super();
		this.app = app;
		this.currentCanvas = new BufferedImage(700, 700, BufferedImage.TYPE_INT_ARGB);
		setupPanel();
		//resetPoint();
	}
	

	private void clearImage()
	{

	}
	
	public void drawLine(int currentX, int currentY, int width)
	{

	}
	
	
	
	/**
	public void saveImage()
	{
		try
		{
			JFileChooser saveDialog = new JFileChoose();
			saveDialog.showSaveDialog(this);
			String savePath = saveDialog.getSelectedFile().getPath();
			if(!savePath)
		}
	}
**/
	public void setupPanel()
	{
		this.setPreferredSize(new Dimension(700, 700));
		this.setBackground(Color.MAGENTA);
		this.currentColor = Color.GREEN;
	}

	public void setCurrentColor(String color)
	{
		if(color.equalsIgnoreCase("red"))
		{
			currentColor = Color.RED;
		}
		else if(color.equals("orange"))
		{
			currentColor = Color.ORANGE;
		}
		else if(color.equals("yellow"))
		{
			currentColor = Color.YELLOW;
		}
		else if(color.equals("green"))
		{
			currentColor = Color.GREEN;
		}
		else if(color.equals("blue"))
		{
			currentColor = Color.BLUE;
		}
		else if(color.equals("violet"))
		{
			currentColor = new Color(75, 0, 130);
		}
		else
		{
			currentColor = randomColor();
		}
	}

	private Color randomColor()
	{
		int red = (int)(Math.random() * 256);
		int green = (int)(Math.random() * 256);
		int blue = (int)(Math.random() * 256);
		int alpha = (int)(Math.random() * 256);

		Color randomColor = new Color(red, green, blue, alpha);
		return randomColor;
	}

	@Override
	protected void paintComponent(Graphics graphics)
	{
		super.paintComponent(graphics);
		graphics.drawImage(currentCanvas, 0, 0, null);
	}
}