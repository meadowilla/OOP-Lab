package hust.soict.dsai.aims.screen.additem;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
	// int id, String title, String category, float cost, String director, String artist
	private String director;
	private String artist;
	
	private JTextField directorInput;
	private JTextField artistInput;
	
	public AddCompactDiscToStoreScreen(Store store, Cart cart) {
		super(store, cart);
	}
	
	@Override
	JPanel createCenter() {
		JPanel center = new JPanel();

		center.setLayout(new GridLayout(6, 2, 2, 2));
		
		center.add(new JLabel("Enter id: "));
		idInput = new JTextField(10);
		center.add(idInput);
		idInput.addActionListener(new idInputListener());
		
		center.add(new JLabel("Enter title: "));
		titleInput = new JTextField(10);
		center.add(titleInput);
		titleInput.addActionListener(new titleInputListener());
		
		center.add(new JLabel("Enter category: "));
		categoryInput = new JTextField(10);
		center.add(categoryInput);
		categoryInput.addActionListener(new categoryInputListener());
		
		center.add(new JLabel("Enter cost: "));
		costInput = new JTextField(10);
		center.add(costInput);
		costInput.addActionListener(new costInputListener());
		
		center.add(new JLabel("Enter director: "));
		directorInput = new JTextField(10);
		center.add(directorInput);
		directorInput.addActionListener(new directorInputListener());
		
		center.add(new JLabel("Enter artist: "));
		artistInput = new JTextField(10);
		center.add(artistInput);
		artistInput.addActionListener(new artistInputListener());
		
		return center;
	}
	
	JPanel createSouth() {
		JPanel south = new JPanel();
		south.setLayout(new FlowLayout());
		JButton btnAdd = new JButton("Add CD");
		south.add(btnAdd);
		btnAdd.addActionListener(new btnAddListener());
		return south;
	}
	
	private class btnAddListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			CompactDisc cd = new CompactDisc(id, title, category, cost, director, artist);
			store.addMedia(cd);
		}
	}
	
	private class directorInputListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			director = directorInput.getText();
		}
	}
	
	private class artistInputListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			artist = artistInput.getText();
		}
	}
		
	public static void main(String[] args) {
		new AddCompactDiscToStoreScreen(new Store(), new Cart());
	}

}
