package hust.soict.dsai.aims.screen;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.LimitExceededException;
import javax.swing.JDialog;
import javax.swing.JLabel;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class ButtonListener implements ActionListener{
	private Cart cart;
	private Store store;
	private Media media;
	
//	public ButtonListener(Cart cart, Media media,Store store) {
//		this.cart=cart;
//		this.media=media;
//		this.store=store;
//	}
	
	public ButtonListener(Cart cart, Media media) {
		this.cart=cart;
		this.media=media;
	}
	
	public ButtonListener(Store store, Media media) {
		this.store=store;
		this.media=media;
	}
	
	public ButtonListener(Cart cart) {
		this.cart=cart;
	}
	
	public ButtonListener(Store store) {
		this.store=store;
	}
	public ButtonListener(Store store, Cart cart) {
		this.store=store;
		this.cart=cart;
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if (button.equals("Add to cart")) {
			try {
				cart.addMedia(media);
				JDialog addCart = new JDialog();
				addCart.setLayout(new FlowLayout());
				addCart.add(new JLabel("Add to cart successfully"));
				addCart.setTitle("Add  to cart");
				addCart.setSize(500,100);
				addCart.setVisible(true);
				addCart.setLocationRelativeTo(null);
			} catch (LimitExceededException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (button.equals("Play")) {
//			Playable m = (Playable) media;
//			m.play();
			Disc m = (Disc) media;
		
			JDialog play = new JDialog();
			play.setLayout(new FlowLayout());
//			Media
			JLabel title = new JLabel("Playing "+ m.getTitle()+", length is "+m.getLength());
			play.add(title);
			play.setLocationRelativeTo(null);
			
			play.setTitle("Play");
			play.setSize(500,100);
			play.setVisible(true);
		}
		else if (button.equals("View cart")) {
			new CartScreen(cart, store);
		}
		else if (button.equals("View store")) {
			new StoreScreen(store);
		}
		else if (button.equals("Add DVD")) {
			new AddDigitalVideoDiscToStoreScreen(store, cart);
		}
		else if (button.equals("Add CD")) {
			new AddCompactDiscToStoreScreen(store, cart);
		}
		else if (button.equals("Add Book")) {
			new AddBookToStoreScreen(store, cart);
		}
	}
}
