package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.SpringLayout;

import controller.ArtController;




public class ArtPanel extends JPanel
{
	private ArtController app;
	private SpringLayout appLayout;
	private JScrollPane canvasPane;


	//Color Selection Buttons
	private JButton redButton;
	private JButton orangeButton;
	private JButton yellowButton;
	private JButton greenButton;
	private JButton blueButton;
	private JButton purpleButton;
	private JButton randomColorButton;


	//Load, Save, Clear Buttons
	private JButton loadButton;
	private JButton saveButton;
	private JButton clearButton;


	//Image Label
	private JLabel duck;


	//Slider
	private JSlider widthSlider;


	//Panels
	private ArtPanel canvas;
	private JPanel colorPanel;
	private JPanel menuPanel;


	private final int MAXIMUM_LINE = 1;
	private final int MINIMUM_LINE = 25;
	
	private int previousX;
	private int previousY;
	
	private BufferedImage currentCanvas;
	private Color currentColor;
	
	public ArtPanel(ArtController app)
	{
		super();
		this.app = app;
		this.canvas = new ArtPanel(app);
		canvasPane = new JScrollPane();
		appLayout = new SpringLayout();

		redButton = new JButton("red");
		orangeButton = new JButton("orange");
		yellowButton = new JButton("yellow");
		greenButton = new JButton("green");
		blueButton = new JButton("blue");
		purpleButton = new JButton("purple");
		randomColorButton = new JButton("???");

		saveButton = new JButton("save panel");
		loadButton = new JButton("load new panel");
		clearButton = new JButton("clear panel");
		widthSlider = new JSlider(MINIMUM_LINE, MAXIMUM_LINE);
		colorPanel = new JPanel(new GridLayout(0, 1));
		menuPanel = new JPanel(new GridLayout(0, 1));

		setupSlider();
		setupMenuPanel();
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupSlider()
	{
		Hashtable<Integer, JLabel> scaleLabels = new Hashtable<Integer, JLabel>();
		scaleLabels.put(MINIMUM_LINE, new JLabel("<HTML>Small<Br>Line</HTML>"));
		scaleLabels.put(MAXIMUM_LINE, new JLabel("<HTML>Large<BR>Line</HTML>"));
		widthSlider.setLabelTable(scaleLabels);
		widthSlider.setSnapToTicks(true);
		widthSlider.setMajorTickSpacing(5);
		widthSlider.setMinorTickSpacing(1);
		widthSlider.setPaintTicks(true);
		widthSlider.setPaintLabels(true);
		widthSlider.setValue((MAXIMUM_LINE + MINIMUM_LINE) / 2);

	}
	
	/**
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
		
		//colorPanel.add(blackButton);
		colorPanel.add(purpleButton);
		colorPanel.add(blueButton);
		colorPanel.add(greenButton);
		colorPanel.add(yellowButton);
		colorPanel.add(orangeButton);
		//colorPanel.add(redButon);
		//colorPanel.add(whiteButton);
		colorPanel.add(randomColorButton);
		
		menuPanel.add(widthSlider);
		menuPanel.add(loadButton);
		menuPanel.add(saveButton);
		menuPanel.add(clearButton);
		
	}
	**/
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
		appLayout.putConstraint(SpringLayout.EAST, colorPanel, 0, SpringLayout.WEST, menuPanel);

		appLayout.putConstraint(SpringLayout.WEST, menuPanel, 200, SpringLayout.EAST, canvasPane);
		appLayout.putConstraint(SpringLayout.SOUTH, menuPanel, 0, SpringLayout.SOUTH, canvasPane);
		appLayout.putConstraint(SpringLayout.EAST, menuPanel, -50, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, menuPanel, 0, SpringLayout.NORTH, canvasPane);

		appLayout.putConstraint(SpringLayout.NORTH, canvasPane, 25, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, canvasPane, 50, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, canvasPane, -50, SpringLayout.SOUTH, this);
	}

	private void setupListeners()
	{
		canvas.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				canvas.drawDot(e.getX(), e.getY(), widthSlider.getValue());
			}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e)
			{
				canvas.resetPoint();
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				canvas.resetPoint();
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				canvas.resetPoint();
			}
		});

		canvas.addMouseMotionListener(new MouseMotionListener()
		{
			@Override
			public void mouseDragged(MouseEvent e) {}

			@Override
			public void mouseMoved(MouseEvent e) {}
		});

	}
	
	private void setupMenuPanel()
	{
		colorPanel.setPreferredSize(new Dimension(50, 700));
		menuPanel.setPreferredSize(new Dimension(50, 700));

		redButton.setForeground(Color.RED);
		orangeButton.setForeground(Color.ORANGE);
		yellowButton.setForeground(Color.YELLOW);
		greenButton.setForeground(Color.GREEN);
		blueButton.setForeground(Color.BLUE);
		purpleButton.setForeground(new Color(75, 0, 130));

		colorPanel.add(redButton);
		colorPanel.add(orangeButton);
		colorPanel.add(yellowButton);
		colorPanel.add(greenButton);
		colorPanel.add(blueButton);
		colorPanel.add(purpleButton);
		colorPanel.add(randomColorButton);

		menuPanel.add(widthSlider);
		menuPanel.add(loadButton);
		menuPanel.add(saveButton);
		menuPanel.add(clearButton);
	}
	
	
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.setBackground(Color.DARK_GRAY);
		this.setPreferredSize(new Dimension(1200, 800));
		this.add(canvasPane);
		this.add(colorPanel);
		this.add(menuPanel);
	}
	
	public void resetPoint()
	{
		previousX = Integer.MIN_VALUE;
		previousY = Integer.MIN_VALUE;
		
	}
	
	public void drawDot(int currentX, int currentY, int width)
	{
		Graphics2D current = currentCanvas.createGraphics();
		current.setColor(currentColor);
		current.setStroke(new BasicStroke(width));
		current.drawOval(currentX, currentY, width, width);
		repaint();
	}
	
	
}
