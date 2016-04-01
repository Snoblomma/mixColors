import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class mixColors extends JFrame{

	
	
	public static void addGrid(Container pane){
		
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JColorChooser colorChooser1 = new JColorChooser();
		colorChooser1.setPreviewPanel(new JPanel()); //removing preview
		colorChooser1.setMaximumSize(new Dimension(200, 200));
		colorChooser1.setBorder(BorderFactory.createTitledBorder("Choose first colour"));
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.EAST;
		//c.weightx = 0.5;
		//c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		pane.add(colorChooser1, c);
		
		
		Canvas canvas1= new Canvas();
		canvas1.setMinimumSize(new Dimension(150, 150));
		canvas1.setMaximumSize(new Dimension(300, 150));
		canvas1.setSize(150, 150);
		canvas1.setBackground(new Color(255, 255, 255));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.WEST;
		c.gridwidth = 1;
		c.gridheight = 1;
		//c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(0, 20, 0, 0);
		pane.add(canvas1, c);
		
		
		JColorChooser colorChooser2 = new JColorChooser();
		colorChooser2.setPreviewPanel(new JPanel()); //removing preview
		colorChooser2.setMaximumSize(new Dimension(200, 200));
		colorChooser2.setBorder(BorderFactory.createTitledBorder("Choose second colour"));
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		pane.add(colorChooser2, c);
		
		Canvas canvas2 = new Canvas();
		canvas2.setMinimumSize(new Dimension(150, 150));
		canvas2.setMaximumSize(new Dimension(300, 150));
		canvas2.setSize(150, 150);
		canvas2.setBackground(new Color(255, 255, 255));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.WEST;
		c.gridwidth = 1;
		c.gridheight = 1;
		//c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(0, 20, 0, 0);
		pane.add(canvas2, c);
		
		
		JTextArea canvas3 = new JTextArea();
		canvas3.setMinimumSize(new Dimension(150, 150));
		canvas3.setMaximumSize(new Dimension(pane.getWidth(), 200));
		canvas3.setSize(150, 150);
		canvas3.setBackground(new Color(255, 255, 255));
		canvas3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), "Result"));
		canvas3.setText("255, 255, 255");
		canvas3.setEditable(false);
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.ipady = 60;
		//c.weightx = 0;
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(20, 20, 0, 0);
		pane.add(canvas3, c);
		
		
		
		
		//We want our colorChoosers to contain only RGB panel:
		
				AbstractColorChooserPanel[] panels = colorChooser1.getChooserPanels();
				for (AbstractColorChooserPanel accp : panels) {
				   if(!accp.getDisplayName().equals("RGB")) {
				      colorChooser1.removeChooserPanel(accp);
				   }
				  
				}
				
				AbstractColorChooserPanel[] panels2 = colorChooser2.getChooserPanels();
				for (AbstractColorChooserPanel accp : panels2) {
				   if(!accp.getDisplayName().equals("RGB")) {
				      colorChooser2.removeChooserPanel(accp);
				   }
				  
				}
				
				colorChooser1.getSelectionModel().addChangeListener(
						
						new ChangeListener() {
							
							@Override
							public void stateChanged(ChangeEvent e) {
								
								Color newColor = colorChooser1.getColor();
								canvas1.setBackground(newColor);
								Color result = mixColors(canvas1.getBackground(), canvas2.getBackground());
								canvas3.setBackground(result);
								int r = result.getRed();
								int g = result.getGreen();
								int b =  result.getBlue();
								//canvas3.setBorder(BorderFactory.createTitledBorder(String.format("%d, %d, %d", r, g, b)));
								canvas3.setText(String.format("%d, %d, %d", r, g, b));
							}
						}
						
						);
				
				colorChooser2.getSelectionModel().addChangeListener(
						
						new ChangeListener() {
							
							@Override
							public void stateChanged(ChangeEvent e) {
								
								Color newColor = colorChooser2.getColor();
								canvas2.setBackground(newColor);
								Color result = mixColors(canvas1.getBackground(), canvas2.getBackground());
								canvas3.setBackground(result);
								int r = result.getRed();
								int g = result.getGreen();
								int b =  result.getBlue();
								//canvas3.setBorder(BorderFactory.createTitledBorder(String.format("%d, %d, %d", r, g, b)));
								canvas3.setText(String.format("%d, %d, %d", r, g, b));
							}
						}
						
						);
		
	}
	
	private static Color mixColors (Color col1, Color col2){
	
		
		int one = 0, two = 0, three = 0;
		
		one = (col1.getRed() + col2.getRed())/2 + (col1.getRed() + col2.getRed())%2;
		two = (col1.getGreen() + col2.getGreen())/2 + (col1.getGreen() + col2.getGreen())%2;
		three = (col1.getBlue() + col2.getBlue())/2 + (col1.getBlue() + col2.getBlue())%2;
		//colorName3.setText(String.format("%s", one + ", "+ two + ", " + three));
		Color z = new Color(one, two, three);
		return z;
		//canvas3.setBackground(z);
		
	}
	
	private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Grid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        addGrid(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setMinimumSize(new Dimension(850, 700));
        frame.setExtendedState(MAXIMIZED_BOTH);
        frame.setVisible(true);
	}
	public static void main(String[] args){
		
		createAndShowGUI();
	}
	
}
