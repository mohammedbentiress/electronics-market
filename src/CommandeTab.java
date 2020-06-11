import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.AbstractTableModel;

public class CommandeTab extends AbstractTableModel {
	private Object[][] Tab;
	int i=0;
	public CommandeTab() {
		Tab=new Object[100][100];
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			 Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Application?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
			 Statement st=c.createStatement();
			 ResultSet rs=st.executeQuery("select * from commande");
				while(rs.next())
				 {
					 int id= rs.getInt(1);
					 String cin=rs.getString(2);
					 int code= rs.getInt(3);
					 Double prix=rs.getDouble(4);
					 int qte=rs.getInt(5);
					 Tab[i][0]=id;
					 Tab[i][1]=cin;
					 Tab[i][2]=code;
					 Tab[i][3]=prix;
					 Tab[i][4]=qte;
					 i++;
				 }
				c.close();
			}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return i;
	}

	@Override
	public Object getValueAt(int row, int col) {
		return Tab[row][col];
	}
	public boolean isCellEditable(int row,int col)
	 {
		 return true;
	 }
	 public void setValueAT(Object o,int row,int col)
	 {
		 Tab[row][col]=o;
		 fireTableCellUpdated(row,col);
	 }
	public String getColumnName(int col)
	{
	String ch="";
	switch(col)
	{
		case 0: return "Numero";
		case 1: return "CIN_Client";
		case 2: return "Code_Produit";
		case 3: return "Prix";
		case 4: return "Quantite";
		}
		return ch;
		}
	public void removeRow(int row)
	{
		for(int j=0;j<=5;j++)
			Tab[row][j]="";
		fireTableRowsDeleted(row,row);
	}
	public void addRow(Object obj,int row,int col)
	{
		fireTableRowsInserted(row,row);
		Tab[row][col]=obj;
		if(col==4)i++;
	}
}
