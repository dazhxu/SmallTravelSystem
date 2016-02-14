import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import HotelInfoApp.HotelInfoPackage.HotelItem;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;


public class HotelPanel extends JPanel implements ActionListener{
	JLabel destLabel,inLabel,outLabel,typeLabel,numLabel;
	JTextField destTextField,inTextField,outTextField,numTextField;
	JComboBox typeComboBox;
	JButton searchButton,orderButton;
	JTable hotelTable;
	JTableHeader tableHeader;
	JScrollPane hotelScrollPane;
	JPanel orderPanel;
	DefaultTableModel tableModel;
	
	int id,price,remains,num;
	String destination,hotelName,type,date;
	
	public HotelPanel() {
		// TODO Auto-generated constructor stub
		this.setLayout(new BorderLayout());
		
		Container upContainer = new Container();
		upContainer.setLayout(new GridBagLayout());
		
		destLabel = new JLabel("目的地     ");
		destTextField = new JTextField(25);
		destTextField.addActionListener(this);
		
		inLabel = new JLabel("入住日期 ");
		inTextField = new JTextField(8);
		inTextField.addActionListener(this);
		
		outLabel = new JLabel("             退房日期 ");
		outTextField = new JTextField(8);
		outTextField.addActionListener(this);
		
		typeLabel = new JLabel("酒店类型 ");
		typeComboBox = new JComboBox();
		typeComboBox.insertItemAt("不限", 0);
		typeComboBox.setSelectedIndex(0);	
		typeComboBox.addActionListener(this);
		searchButton = new JButton("搜索");
		searchButton.addActionListener(this);
		
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		upContainer.add(destLabel,constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 4;
		constraints.gridheight = 1;
		upContainer.add(destTextField,constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		upContainer.add(inLabel,constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 1;
		upContainer.add(inTextField,constraints);
		
		constraints.gridx = 2;
		constraints.gridy = 1;
		upContainer.add(outLabel,constraints);
		
		constraints.gridx = 3;
		constraints.gridy = 1;
		upContainer.add(outTextField,constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		upContainer.add(typeLabel,constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.insets = new Insets(0, 0, 0, 0);
		upContainer.add(typeComboBox,constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 4;
		constraints.anchor = GridBagConstraints.LINE_END;
		upContainer.add(searchButton,constraints);

		this.add(upContainer,BorderLayout.NORTH);
		
		hotelTable = new JTable();
		JTableHeader tableHeader = hotelTable.getTableHeader();
		tableModel = (DefaultTableModel) hotelTable.getModel();
		tableModel.addColumn("序号");
		tableModel.addColumn("目的地");
		tableModel.addColumn("酒店名");
		tableModel.addColumn("类型");
		tableModel.addColumn("价格");
		tableModel.addColumn("剩余房间");
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
		
		ListSelectionModel secSelectionModel = hotelTable.getSelectionModel();
		secSelectionModel.addListSelectionListener(
				new  ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						// TODO Auto-generated method stub
						//id = Integer.parseInt((String)tableModel.getValueAt(hotelTable.getSelectedRow(), 0));
						id = (int)tableModel.getValueAt(hotelTable.getSelectedRow(), 0);
						destination = (String)tableModel.getValueAt(hotelTable.getSelectedRow(), 1);
						hotelName = (String)tableModel.getValueAt(hotelTable.getSelectedRow(), 2);
						type = (String)tableModel.getValueAt(hotelTable.getSelectedRow(), 3);
						date = (String)tableModel.getValueAt(hotelTable.getSelectedRow(), 6);
						price = (int)tableModel.getValueAt(
								hotelTable.getSelectedRow(), 4);
						remains = (int)tableModel.getValueAt(
								hotelTable.getSelectedRow(), 5);
						/*System.out.println(id+" "+destination+" "+hotelName+" "+type
								+" "+date+" "+price+" "+remains);*/
					}
					
				});
		
		
		hotelScrollPane = new JScrollPane(hotelTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		hotelScrollPane.setPreferredSize(new Dimension(450,100));
		hotelScrollPane.revalidate();
		
		numLabel = new JLabel("数量: ");
		numTextField = new JTextField(30);
		numTextField.setText("1");
		orderButton = new JButton("预订");
		orderButton.addActionListener(this);
		orderPanel = new JPanel();
		orderPanel.add(numLabel);
		orderPanel.add(numTextField);
		orderPanel.add(orderButton, -1);
		
		this.add(hotelScrollPane,BorderLayout.CENTER);
		this.add(orderPanel,BorderLayout.SOUTH);
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object object = e.getSource();
		
		HotelClient hotelClient = new HotelClient();
		String user = "default";
		
		if(object == searchButton){
			String destination = destTextField.getText();
			String inData = inTextField.getText();
			String outData = outTextField.getText();
			String type = typeComboBox.getSelectedItem().toString();
			
			//System.out.println(destination+" "+inData+" "+outData+" "+type);
			ArrayList<HotelItem> hotelInfo;
			hotelInfo = hotelClient.dealHotelInfo(destination, inData, outData, type,user);
			
			for(HotelItem h : hotelInfo){
				/*System.out.println(h.Id+" "+h.Destination+" "+h.Name+
						" "+h.Type+" "+h.price+" "+h.Remains+" "+h.date);
						*/
				Object[] item = {h.Id, h.Destination, h.Name, h.Type, h.price, h.Remains, h.date};
				tableModel.addRow(item);
			}
		}
		else if(object == orderButton){
			//System.out.println("hello-------------");
			num = Integer.parseInt(numTextField.getText());
			int isSuccess = hotelClient.order(id,destination,hotelName,type,date,num,user);
			if(isSuccess == 1){
				JOptionPane.showConfirmDialog(this, "成功预订酒店: "+hotelName+",数量: "+num,"提示",
						JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showConfirmDialog(this, "预订酒店: "+hotelName+"失败!","提示",
						JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}

}
