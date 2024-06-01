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
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen{
	// int id, String title, String category, float cost, int length, String director
	private String director;
	private int length;
	
	private JTextField directorInput;
	private JTextField lengthInput;
	public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
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
		
		center.add(new JLabel("Enter length: "));
		lengthInput = new JTextField(10);
		center.add(lengthInput);
		lengthInput.addActionListener(new lengthInputListener());
		
		center.add(new JLabel("Enter director: "));
		directorInput = new JTextField(10);
		center.add(directorInput);
		directorInput.addActionListener(new directorInputListener());
		
		return center;
	}
	
	JPanel createSouth() {
		JPanel south = new JPanel();
		south.setLayout(new FlowLayout());
		JButton btnAdd = new JButton("Add DVD");
		south.add(btnAdd);
		btnAdd.addActionListener(new btnAddListener());
		return south;
	}
	
	private class btnAddListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, cost, length, director);
			store.addMedia(dvd);
		}
	}
	
	private class directorInputListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			director = directorInput.getText();
		}
	}
	
	private class lengthInputListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			length = Integer.parseInt(lengthInput.getText());
		}
	}
		
	public static void main(String[] args) {
		new AddDigitalVideoDiscToStoreScreen(new Store(), new Cart());
	}

}
