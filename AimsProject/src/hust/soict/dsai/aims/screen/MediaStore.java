package hust.soict.dsai.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel{
	private Media media;
	
	public MediaStore(Media media) {
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel("" + media.getCost() + " $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton btnAddToCart = new JButton("Add to cart");
		container.add(btnAddToCart);
		addButton(btnAddToCart);
		if (media instanceof Playable) {
			JButton btnPlay = new JButton("Play");
			container.add(btnPlay);
			addButton(btnPlay);
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	void addButton(JButton button) {
		ButtonListener btnListener = new ButtonListener();
		button.addActionListener(btnListener);
	}
	
	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand();
			
			if (button == "Play") {
				System.out.println("Button Play is clicked.");
				JDialog dialog = new JDialog();
				if (e.getSource() instanceof CompactDisc) {
					System.out.println("Playing...");
					CompactDisc cd = (CompactDisc) e.getSource();
					JLabel label = new JLabel("Playing CD " + cd.getTitle() 
											+ "in length of " + cd.getLength());
					dialog.add(label);
				}
				else if (e.getSource() instanceof DigitalVideoDisc) {
					DigitalVideoDisc dvd = (DigitalVideoDisc) e.getSource();
					JLabel label = new JLabel("Playing DVD " + dvd.getTitle() 
											+ "in length of " + dvd.getLength());
					dialog.add(label);
				}
				
				dialog.setTitle("Play");
				dialog.setSize(200, 200);
				dialog.setVisible(true);
			}
			else if (button == "Add to cart") {
				Aims.getCart().addMedia((Media) e.getSource());
			}
		}	
	}
	
}
