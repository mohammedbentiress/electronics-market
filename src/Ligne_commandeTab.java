import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.AbstractTableModel;

public class Ligne_commandeTab extends AbstractTableModel {
	private Object[][] Tab;
	int i=0;
	public Ligne_commandeTab() {
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
			 ResultSet rs=st.executeQuery("select * from lignedescommandes");
				while(rs.next())
				 {
					 int id= rs.getInt(1);
					 String cin=rs.getString(2);
					 String cds= rs.getString(3);
					 Double prix=rs.getDouble(4);
					 Date date=rs.getDate(5);
					 Tab[i][0]=id;
					 Tab[i][1]=cin;
					 Tab[i][2]=cds;
					 Tab[i][3]=prix;
					 Tab[i][4]=date;
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
		// TODO Auto-generated method stub
		return Tab[row][col];
	}
	public String getColumnName(int col)
	{
	String ch="";
	switch(col)
	{
		case 0: return "Numero";
		case 1: return "CIN_Client";
		case 2: return "Commandes";
		case 3: return "Prix";
		case 4: return "Date";
		}
		return ch;
		}
}
