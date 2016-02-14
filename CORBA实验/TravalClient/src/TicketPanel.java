import javax.sql.rowset.serial.SerialArray;
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

public class TicketPanel extends JPanel implements ActionListener{
	JLabel deptLabel,destLabel,deptTimeLabel,numLabel;
	JTextField deptTextField,destTextField,deptTimeTextField,numTextField;
	JButton searchButton,orderButton;
	JTable ticketTable;
	JPanel orderPanel;
	DefaultTableModel tableModel;
	JScrollPane ticketScrollPane;
	
	int id,price,remains,num;
	String name,departure,destination,startTime,stopTime;
	
	public TicketPanel() {
		// TODO Auto-generated constructor stub
		this.setLayout(new BorderLayout());
		
		Container upContainer = new Container();
		upContainer.setLayout(new GridBagLayout());
		
		deptLabel = new JLabel("出发地 ");
		destLabel = new JLabel("目的地 ");
		deptTextField = new JTextField(10);
		deptTextField.addActionListener(this);
		destTextField = new JTextField(10);
		destTextField.addActionListener(this);		
		deptTimeLabel = new JLabel("                出发时间  ");
		deptTimeTextField = new JTextField(10);
		deptTimeTextField.addActionListener(this);
		searchButton = new JButton("搜索");
		searchButton.addActionListener(this);
		
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		upContainer.add(deptLabel,constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 0;
		upContainer.add(deptTextField,constraints);
		
		constraints.gridx = 2;
		constraints.gridy = 0;
		upContainer.add(deptTimeLabel,constraints);
		
		constraints.gridx = 3;
		constraints.gridy = 0;
		upContainer.add(deptTimeTextField,constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		upContainer.add(destLabel,constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 1;
		upContainer.add(destTextField,constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 4;
		constraints.anchor = GridBagConstraints.LINE_END;
		upContainer.add(searchButton,constraints);
		
		this.add(upContainer, BorderLayout.NORTH);
		
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
		tableModel.addColumn("剩余");
		/*TableColumn column = ticketTable.getColumnModel().getColumn(0);
		column.setMaxWidth(50);		
		column = ticketTable.getColumnModel().getColumn(1);
		column.setMaxWidth(50);
		column = ticketTable.getColumnModel().getColumn(3);
		column.setMaxWidth(50);
		column = ticketTable.getColumnModel().getColumn(4);
		column.setMaxWidth(50);
		column = ticketTable.getColumnModel().getColumn(5);
		column.setMaxWidth(60);
		*/
		ListSelectionModel secSelectionModel = ticketTable.getSelectionModel();
		secSelectionModel.addListSelectionListener(
				new  ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						// TODO Auto-generated method stub
						//id = Integer.parseInt((String)tableModel.getValueAt(hotelTable.getSelectedRow(), 0));
						id = (int)tableModel.getValueAt(ticketTable.getSelectedRow(), 0);						
						name = (String)tableModel.getValueAt(ticketTable.getSelectedRow(), 1);
						departure = (String)tableModel.getValueAt(ticketTable.getSelectedRow(), 2);
						destination = (String)tableModel.getValueAt(ticketTable.getSelectedRow(), 3);
						startTime = (String)tableModel.getValueAt(ticketTable.getSelectedRow(), 4);
						stopTime = (String)tableModel.getValueAt(ticketTable.getSelectedRow(), 5);
						price = (int)tableModel.getValueAt(ticketTable.getSelectedRow(), 6);
						remains = (int)tableModel.getValueAt(
								ticketTable.getSelectedRow(), 7);
						/*System.out.println(id+" "+destination+" "+hotelName+" "+type
								+" "+date+" "+price+" "+remains);*/
					}
					
				});
		ticketScrollPane = new JScrollPane(ticketTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		ticketScrollPane.setPreferredSize(new Dimension(450,100));
		ticketScrollPane.revalidate();
		
		numLabel = new JLabel("数量: ");
		numTextField = new JTextField(30);
		numTextField.setText("1");
		orderButton = new JButton("预订");
		orderButton.addActionListener(this);
		orderPanel = new JPanel();
		orderPanel.add(numLabel);
		orderPanel.add(numTextField);
		orderPanel.add(orderButton, -1);
		
		this.add(ticketScrollPane,BorderLayout.CENTER);
		this.add(orderPanel,BorderLayout.SOUTH);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		TicketClient ticketClient = new TicketClient();
		String user = "default";
		
		if(obj == searchButton){
			//System.out.println("搜索车票!!!");
			String departure = deptTextField.getText();
			String destination = destTextField.getText();
			String startTime = deptTimeTextField.getText();
			
			ArrayList<TicketItem> ticketInfo;
			ticketInfo = ticketClient.dealTicketInfo(departure, destination, startTime, user);
			for(TicketItem h : ticketInfo){
				/*System.out.println(h.Id+" "+h.Destination+" "+h.Name+
						" "+h.Type+" "+h.price+" "+h.Remains+" "+h.date);
						*/
				Object[] item = {h.Id, h.Name, h.Departure, h.Destination, h.StartTime, h.ArriveTime,
						h.Price, h.Remains};
				tableModel.addRow(item);
			}
		} else if(obj == orderButton){
			num = Integer.parseInt(numTextField.getText());
			int isSuccess = ticketClient.order(id,name,departure,destination,startTime,stopTime,price,num,user);
			if(isSuccess == 1){
				JOptionPane.showConfirmDialog(this, "成功预订车票: "+name+",数量: "+num,"提示",
						JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showConfirmDialog(this, "预订车票: "+name+"失败!","提示",
						JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}

}
