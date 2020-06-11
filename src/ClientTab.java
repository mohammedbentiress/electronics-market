import javax.swing.table.AbstractTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientTab extends AbstractTableModel{
	private Object[][] Tab;
	int i=0;
	public ClientTab() {
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
			 ResultSet rs=st.executeQuery("select * from clients");
				while(rs.next())
				 {
					 String cin= rs.getString(1);
					 String nom=rs.getString(2);
					 String prenom= rs.getString(3);
					 String email= rs.getString(4);
					 String tele=rs.getString(5);
					 String adresse=rs.getString(6);
					 Tab[i][0]=cin;
					 Tab[i][1]=nom;
					 Tab[i][2]=prenom;
					 Tab[i][3]=email;
					 Tab[i][4]=tele;
					 Tab[i][5]=adresse;
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
		return 6;
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
		 fireTableDataChanged();
	 }
	public String getColumnName(int col)
	{
	String ch="";
	switch(col)
	{
		case 0: return "CIN";
		case 1: return "Nom";
		case 2: return "Prénom";
		case 3: return "Email";
		case 4: return "Telephone";
		case 5: return "Adresse";
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
		if(col==5)i++;
	}

	public Object[][] getTab() {
		return Tab;
	}

	public void setTab(Object[][] tab) {
		Tab = tab;
	}
}
