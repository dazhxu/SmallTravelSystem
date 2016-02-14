import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import HotelInfoApp.HotelInfoPackage.HotelItem;
import TicketInfoApp.TicketInfoPackage.TicketItem;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class OrderPanel extends JPanel implements ActionListener{
	JButton hotelButton,ticketButton;
	JTable hotelTable,ticketTable;
	DefaultTableModel tableModel;
	JScrollPane orderScrollPane;

	public OrderPanel() {
		// TODO Auto-generated constructor stub		
		hotelButton = new JButton("查看酒店订单");
		hotelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		hotelButton.addActionListener(this);
		ticketButton = new JButton("查看车票订单");
		ticketButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		ticketButton.addActionListener(this);		
		this.add(hotelButton);
		this.add(ticketButton);		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		String user = "default";
		
		if(obj == hotelButton){
			System.out.println("查看酒店订单!!!");
			if(ticketTable != null)
				this.remove(ticketTable);
			
			hotelTable = new JTable();
			JTableHeader tableHeader = hotelTable.getTableHeader();
			tableModel = (DefaultTableModel) hotelTable.getModel();
			tableModel.addColumn("序号");
			tableModel.addColumn("目的地");
			tableModel.addColumn("酒店名");
			tableModel.addColumn("类型");
			tableModel.addColumn("价格");
			tableModel.addColumn("数量");
			tableModel.addColumn("日期");
			TableColumn column = hotelTable.getColumnModel().getColumn(0);
			column.setMaxWidth(50);		
			column = hotelTable.getColumnModel().getColumn(1);
			column.setMaxWidth(50);
			column = hotelTable.getColumnModel().getColumn(3);
			column.setMaxWidth(50);
			column = hotelTable.getColumnModel().getColumn(4);
			column.setMaxWidth(50);
			column = hotelTable.getColumnModel().getColumn(5);
			column.setMaxWidth(60);
			
			orderScrollPane = new JScrollPane(hotelTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			orderScrollPane.setPreferredSize(new Dimension(450,280));
			orderScrollPane.revalidate();
			this.add(orderScrollPane);
			this.revalidate();
			
			HotelClient hotelClient = new HotelClient();
			ArrayList<HotelItem> hotelItems = new ArrayList<HotelItem>();
			hotelItems = hotelClient.getOrder(user);
			for(HotelItem h : hotelItems){
				/*System.out.println(h.Id+" "+h.Destination+" "+h.Name+
						" "+h.Type+" "+h.price+" "+h.Remains+" "+h.date);
						*/
				Object[] item = {h.Id, h.Destination, h.Name, h.Type, h.price, h.Remains, h.date};
				tableModel.addRow(item);
			}
			
		}
		else if(obj == ticketButton){			
			System.out.println("查看车票订单!!!");
			if(hotelTable != null)
				this.remove(hotelTable);
			ticketTable = new JTable();
			JTableHeader tableHeader = ticketTable.getTableHeader();
			tableModel = (DefaultTableModel) ticketTable.getModel();
			tableModel.addColumn("序号");
			tableModel.addColumn("名称");
			tableModel.addColumn("出发地");
			tableModel.addColumn("目的地");
			tableModel.addColumn("出发时间");
			tableModel.addColumn("到达时间");
			tableModel.addColumn("价格");
			tableModel.addColumn("数量");
			orderScrollPane = new JScrollPane(ticketTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			orderScrollPane.setPreferredSize(new Dimension(450,280));
			orderScrollPane.revalidate();
			this.add(orderScrollPane);
			this.revalidate();
			
			TicketClient ticketClient = new TicketClient();
			ArrayList<TicketItem> ticketItems = new ArrayList<TicketItem>();
			ticketItems = ticketClient.getOrder(user);
			
			for(TicketItem h : ticketItems){
				/*System.out.println(h.Id+" "+h.Destination+" "+h.Name+
						" "+h.Type+" "+h.price+" "+h.Remains+" "+h.date);
						*/
				Object[] item = {h.Id, h.Name, h.Departure, h.Destination, h.StartTime, h.ArriveTime,
						h.Price, h.Remains};
				tableModel.addRow(item);
			}
		}
	}

}
