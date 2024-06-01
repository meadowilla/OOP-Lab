package hust.soict.dsai.aims.screen.additem;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame{
	Store store;
	Cart cart;
	
	int id;
	String title;
	String category;
	float cost;
	
	JTextField idInput;
	JTextField titleInput;
	JTextField categoryInput;
	JTextField costInput;
	
	public AddItemToStoreScreen(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		cp.add(createSouth(), BorderLayout.SOUTH);
		
		setVisible(true);
		setTitle("Store");
		setSize(250, 250);
	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenu smUpdateStore = new JMenu("Update Store");
		smUpdateStore.add(new JMenuItem("Add Book"));
		smUpdateStore.add(new JMenuItem("Add CD"));
		smUpdateStore.add(new JMenuItem("Add DVD"));
		
		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View Store"));
		menu.add(new JMenuItem("View Cart"));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	abstract JPanel createCenter();
	
	abstract JPanel createSouth();
	
	class idInputListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			id = Integer.parseInt(idInput.getText());
		}
	}
	
	class titleInputListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			title = titleInput.getText();
		}
	}
	
	class categoryInputListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			category = categoryInput.getText();
		}
	}
	
	class costInputListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			cost = Float.parseFloat(costInput.getText());
		}
	}
}
