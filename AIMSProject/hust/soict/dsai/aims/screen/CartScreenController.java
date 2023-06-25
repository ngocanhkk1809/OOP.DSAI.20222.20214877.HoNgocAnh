package hust.soict.dsai.aims.screen;


import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class CartScreenController {
	private Cart cart;
	private Store store;
	
	@FXML
	private MenuItem addBook;

	@FXML
	private MenuItem addCD;

	@FXML
	private MenuItem addDVD;
	    
	@FXML
	private TableColumn<Media, Float> colMediaCost;

	@FXML
	private TableColumn<Media, String> colMediaTitle;

	@FXML
	private TableColumn<Media, String> colMediacategory;

	@FXML
	private ToggleGroup filterCategory;

	@FXML
	private TableView<Media> tblMedia;
	
	@FXML
	private Button btnPlay;

	@FXML
	private Button btnRemove;
	
	@FXML
	private Button btnPlaceOrder;
	
	@FXML
	void btnPlaceOrderPressed(ActionEvent event) {
		cart.empty();
		totalCost.setText("0 $");
	}
	
	@FXML
    private Label totalCost;
	
	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
		totalCost.setText(cart.totalCost()+" $");
	}
	
	@FXML
	void btnPlayPressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		Disc disc =(Disc) media;
		JDialog play = new JDialog();
		play.setLayout(new FlowLayout());
//		Media
		JLabel title = new JLabel("Playing "+ media.getTitle()+", length is "+disc.getLength());
		play.add(title);
		play.setLocationRelativeTo(null);
		
		play.setTitle("Play");
		play.setSize(500,100);
		play.setVisible(true);
	}
	
	@FXML
	private MenuItem viewStore;
	
	@FXML
	void viewStorePressed(ActionEvent event) {
		new StoreScreen(store);
	}
	
	@FXML
    void addBookChosen(ActionEvent event) {
		new AddBookToStoreScreen(store, cart);
    }
	
	@FXML
    void addCDChosen(ActionEvent event) {
		new AddCompactDiscToStoreScreen(store, cart);
    }
	
	@FXML
    void addDVDChosen(ActionEvent event) {
		new AddDigitalVideoDiscToStoreScreen(store, cart);
    }
	
	public CartScreenController(Cart cart,Store store) {
		super();
		this.cart=cart;
		this.store=store;
	}
	
	@FXML
	private void initialize() {
		 
		 colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media,String>("title"));
		 colMediacategory.setCellValueFactory(new PropertyValueFactory<Media,String>("category"));
		 colMediaCost.setCellValueFactory(new PropertyValueFactory<Media,Float>("cost"));
		 tblMedia.setItems(this.cart.getItemsOrdered());
		 
		 totalCost.setText(cart.totalCost()+" $");
		 
		 btnPlay.setVisible(false);
		 btnRemove.setVisible(false);
		 
		 tblMedia.getSelectionModel().selectedItemProperty().addListener(
				 new ChangeListener<Media>() {
					 @Override
					 public void changed(ObservableValue<? extends Media> observable,Media oldValue,Media newValue) {
						 if (newValue!=null) {
							 updateButtonBar(newValue);
						 }
					 }
					 void updateButtonBar(Media media) {
						 btnRemove.setVisible(true);
						 if (media instanceof Playable) {
							 btnPlay.setVisible(true);
						 }else {
							 btnPlay.setVisible(false);
						 }
					 }
				});
	 }
}
