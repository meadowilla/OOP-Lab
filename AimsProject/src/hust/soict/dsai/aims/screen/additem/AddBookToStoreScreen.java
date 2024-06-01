package hust.soict.dsai.aims.screen.additem;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen{

	private List<String> authors;
	private JTextField authorInput;

	
	public AddBookToStoreScreen(Store store, Cart cart) {
		super(store, cart);
	}

	@Override
	JPanel createCenter() {
		JPanel center = new JPanel();

		center.setLayout(new GridLayout(5, 2, 2, 2));
		
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
		
		center.add(new JLabel("Enter author: "));
		authorInput = new JTextField(10);
		center.add(authorInput);
		authorInput.addActionListener(new authorInputListener());
		
		return center;
	}
	
	JPanel createSouth() {
		JPanel south = new JPanel();
		south.setLayout(new FlowLayout());
		JButton btnAdd = new JButton("Add Book");
		south.add(btnAdd);
		btnAdd.addActionListener(new btnAddListener());
		return south;
	}
	
	private class btnAddListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			Book book = new Book(id, title, category, cost);
			store.addMedia(book);
			for (String author: authors) {
				book.addAuthor(author);
			}
//			System.out.println("Add Book successfully!");
//			store.print();
		}
	}
	
	private class authorInputListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			authors = new ArrayList<String>(
					Arrays.asList(authorInput.getText().split(",")));
		}
	}
		
	public static void main(String[] args) {
		new AddBookToStoreScreen(new Store(), new Cart());
	}

}
