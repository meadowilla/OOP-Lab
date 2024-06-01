package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
	private Cart cart;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private ToggleGroup filterCategory;
    
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;
    
    @FXML
    private Button btnPlaceOrder;
    
    @FXML
    private MenuItem itemViewStore;
    
    @FXML
    private MenuItem itemViewCart;
    
    @FXML
    private MenuItem itemAddBook;
    
    @FXML
    private MenuItem itemAddCD;
    
    @FXML
    private MenuItem itemAddDVD;
    
    
    
    public CartScreenController(Cart cart) {
    	super();
    	this.cart = cart;
    }
    
    @FXML
    private void initialize() { // don't know why create initialize method
    	
    	colMediaTitle.setCellValueFactory(
    			new PropertyValueFactory<Media, String>("title"));
    	colMediaCategory.setCellValueFactory(
    			new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(
    			new PropertyValueFactory<Media, Float>("cost"));
    	
    	tblMedia.setItems(this.cart.getItemOrdered());
    	
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(
    			new ChangeListener<Media>() {
    				
    				@Override
    				public void changed(ObservableValue<? extends Media> observable, Media oldValue,
    						Media newValue) {
    					if (newValue != null) {
    						updateButtonBar(newValue);
    					}
    				}
    			});
    }

    private void updateButtonBar(Media media) {
    	btnRemove.setVisible(true);
    	if (media instanceof Playable) {
    		btnPlay.setVisible(true);
    	}
    	else {
    		btnPlay.setVisible(false);
    	}
    }
    

    void btnPlayPressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	if (media instanceof Playable) {
    		((Playable) media).play();
    	}
    }
    
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    }
    
    void btnPlaceOrderPressed(ActionEvent event) {
    	
    }
    
    void itemViewStorePressed(ActionEvent event) {
    	
    }
    
    void itemViewCartPressed(ActionEvent event) {
    	
    }
    
}
