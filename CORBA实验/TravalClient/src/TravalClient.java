
import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

public class TravalClient extends JFrame implements ActionListener{
	
	
	public TravalClient() {
		// TODO Auto-generated constructor stub
		init();
		Dimension frameDimension = new Dimension(500,400);
		this.setSize(frameDimension);
		this.setTitle("TravalSystem");
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenDimension.width - frameDimension.width)/2,
				(screenDimension.height - frameDimension.height)/2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setLayout(new GridLayout(1, 1));
		
		JTabbedPane tabbedPane = new JTabbedPane();
		HotelPanel hotelPanel = new HotelPanel();
		tabbedPane.add("¾ÆµêÔ¤¶©", hotelPanel);
		tabbedPane.setSelectedIndex(0);
		
		TicketPanel ticketPanel = new TicketPanel();
		tabbedPane.add("³µÆ±Ô¤¶©", ticketPanel);
		
		OrderPanel orderPanel = new OrderPanel();
		tabbedPane.add("ÎÒµÄ¶©µ¥", orderPanel);	
		
		
		this.add(tabbedPane);		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String args[]){
		TravalClient travalClient = new TravalClient();
	}

}
