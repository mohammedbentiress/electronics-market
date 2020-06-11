import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Client_Fournisseur extends JFrame implements ActionListener {
	public static  Connection c;
	public static  Statement st;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			 c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Application?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
			 st=c.createStatement();
		 }
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client_Fournisseur frame = new Client_Fournisseur();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private JPanel contentPane;
	private JTextField textField_cin;
	private JTextField textField_nom;
	private JTextField textField_email;
	private JTextField textField_recher;
	private JTextField textField_prenom;
	private JTextField textField_tele;
	JButton btnSupprimer,btnModifier,btnAjouter,btnEnregister,btnRechercherPar;
	JComboBox comboBox;
	JTable jtb,jtb_1;
	private ClientTab tab;
	private FournisseurTab tab_1;
	private JTextField textField_adresse;
	/**
	 * Create the frame.
	 */
	public Client_Fournisseur() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(65, 105, 225));
		panel.setBounds(0, 0, 1284, 108);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion Clients /Fournisseur");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 28));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setLabelFor(lblNewLabel);
		lblNewLabel.setBounds(522, 32, 399, 51);
		panel.add(lblNewLabel);
		

		JButton btnNewButton_1 = new JButton("");
		Image iret3=new ImageIcon(this.getClass().getResource("return.png")).getImage();
		btnNewButton_1.setToolTipText("Retour vers Menu");
		btnNewButton_1.setIcon(new ImageIcon(iret3));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu m=new Menu();
				m.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBackground(new Color(65, 105, 225));
		btnNewButton_1.setBounds(0, 0, 23, 108);
		panel.add(btnNewButton_1);
		Image i1=new ImageIcon(this.getClass().getResource("customer.png")).getImage();
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(i1));
		label.setBounds(457, 11, 73, 72);
		panel.add(label);
		

		btnAjouter = new JButton("Ajouter");
		Image i2=new ImageIcon(this.getClass().getResource("ajouter.png")).getImage();
		btnAjouter.setIcon(new ImageIcon(i2));
		btnAjouter.setFont(new Font("Arial", Font.BOLD, 12));
		btnAjouter.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255)));
		btnAjouter.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnAjouter.setBackground(new Color(65, 105, 225));
		btnAjouter.setForeground(new Color(255, 255, 255));
		btnAjouter.setToolTipText("Ajouter un nouveau produit \u00E0 la table");
		btnAjouter.setBounds(29, 131, 127, 36);
		getContentPane().add(btnAjouter);
		btnAjouter.addActionListener(this);
		
		btnModifier = new JButton("Modifier\r\n");
		btnModifier.setToolTipText("Modifier un produit de la table");
		Image i3=new ImageIcon(this.getClass().getResource("modifier.png")).getImage();
		btnModifier.setIcon(new ImageIcon(i3));
		btnModifier.setFont(new Font("Arial", Font.BOLD, 12));
		btnModifier.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255)));
		btnModifier.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnModifier.setBackground(new Color(65, 105, 225));
		btnModifier.setForeground(new Color(255, 255, 255));
		btnModifier.setBounds(166, 131, 127, 36);
		getContentPane().add(btnModifier);
		btnModifier.addActionListener(this);
		
	    btnSupprimer = new JButton("Supprimer\r\n");
		btnSupprimer.setToolTipText("Supprimer un produit de la table");
		btnSupprimer.addActionListener(this);
		Image i4=new ImageIcon(this.getClass().getResource("delete.png")).getImage();
		btnSupprimer.setIcon(new ImageIcon(i4));
		btnSupprimer.setFont(new Font("Arial", Font.BOLD, 12));
		btnSupprimer.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255)));
		btnSupprimer.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnSupprimer.setBackground(new Color(65, 105, 225));
		btnSupprimer.setForeground(new Color(255, 255, 255));
		btnSupprimer.setBounds(303, 131, 127, 36);
		getContentPane().add(btnSupprimer);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(0, 0, 255));
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Infos sur Client", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		panel_2.setBounds(29, 178, 401, 472);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		
		
		
		JLabel lblId = new JLabel("Client/Fournisseur:");
		lblId.setFont(new Font("Arial", Font.BOLD, 12));
		lblId.setBounds(20, 29, 106, 21);
		panel_2.add(lblId);
		
		textField_cin = new JTextField();
		textField_cin.setBackground(new Color(255, 255, 255));
		textField_cin.setColumns(10);
		textField_cin.setBounds(136, 77, 233, 31);
		panel_2.add(textField_cin);
		
		textField_nom = new JTextField();
		textField_nom.setBackground(new Color(255, 255, 255));
		textField_nom.setColumns(10);
		textField_nom.setBounds(136, 131, 233, 31);
		panel_2.add(textField_nom);
		
		JLabel lblCode = new JLabel("CIN:");
		lblCode.setFont(new Font("Arial", Font.BOLD, 12));
		lblCode.setBounds(20, 82, 106, 21);
		panel_2.add(lblCode);
		
		JLabel lblNomProduit = new JLabel("Nom :");
		lblNomProduit.setFont(new Font("Arial", Font.BOLD, 12));
		lblNomProduit.setBounds(20, 135, 106, 21);
		panel_2.add(lblNomProduit);
		
		comboBox = new JComboBox();
		comboBox.addItem("Client");
		comboBox.addItem("Fournisseur");
		
		comboBox.setEditable(true);
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(136, 25, 106, 31);
		panel_2.add(comboBox);
						
		JLabel lblCatgorie = new JLabel("Pr\u00E9nom :");
		lblCatgorie.setFont(new Font("Arial", Font.BOLD, 12));
		lblCatgorie.setBounds(20, 191, 106, 21);
		panel_2.add(lblCatgorie);
		
		btnEnregister = new JButton("Enregister");
		Image i6=new ImageIcon(this.getClass().getResource("register.png")).getImage();
		btnEnregister.setIcon(new ImageIcon(i6));
		btnEnregister.setForeground(Color.WHITE);
		btnEnregister.setFont(new Font("Arial", Font.BOLD, 12));
		btnEnregister.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255)));
		btnEnregister.setBackground(new Color(65, 105, 225));
		btnEnregister.setAlignmentX(0.5f);
		btnEnregister.setBounds(242, 425, 127, 36);
		panel_2.add(btnEnregister);
		
		btnEnregister.addActionListener(this);
		textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBackground(Color.WHITE);
		textField_email.setBounds(136, 246, 233, 31);
		panel_2.add(textField_email);
		
		JLabel lblDescription = new JLabel("Email :");
		lblDescription.setFont(new Font("Arial", Font.BOLD, 12));
		lblDescription.setBounds(20, 250, 106, 21);
		panel_2.add(lblDescription);
		
		JLabel lblQuantit = new JLabel("Telephone :");
		lblQuantit.setFont(new Font("Arial", Font.BOLD, 12));
		lblQuantit.setBounds(20, 308, 106, 21);
		panel_2.add(lblQuantit);
		
		JLabel lblPrix = new JLabel("Adresse:");
		lblPrix.setFont(new Font("Arial", Font.BOLD, 12));
		lblPrix.setBounds(20, 365, 106, 21);
		panel_2.add(lblPrix);
		
		textField_prenom = new JTextField();
		textField_prenom.setColumns(10);
		textField_prenom.setBackground(Color.WHITE);
		textField_prenom.setBounds(136, 187, 233, 31);
		panel_2.add(textField_prenom);
		
		textField_tele = new JTextField();
		textField_tele.setColumns(10);
		textField_tele.setBackground(Color.WHITE);
		textField_tele.setBounds(136, 304, 233, 31);
		panel_2.add(textField_tele);
		
		textField_adresse = new JTextField();
		textField_adresse.setColumns(10);
		textField_adresse.setBackground(Color.WHITE);
		textField_adresse.setBounds(136, 361, 233, 31);
		panel_2.add(textField_adresse);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tableau de Produits", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		panel_1.setBounds(468, 178, 789, 472);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		tab=new	ClientTab();
		jtb=new JTable(tab);
		
		JScrollPane scrollPane = new JScrollPane(jtb);
		scrollPane.setBounds(28, 52, 737, 213);
		panel_1.add(scrollPane);
		
		tab_1=new FournisseurTab();
		jtb_1=new JTable(tab_1);
		JScrollPane scrollPane_1 = new JScrollPane(jtb_1);
		scrollPane_1.setBounds(28, 276, 737, 185);
		panel_1.add(scrollPane_1);
		
		btnRechercherPar = new JButton("Rechercher par :");
		Image i5=new ImageIcon(this.getClass().getResource("search.png")).getImage();
		btnRechercherPar.setIcon(new ImageIcon(i5));
		btnRechercherPar.setToolTipText("Rechercher un client par champs");
		btnRechercherPar.setForeground(Color.WHITE);
		btnRechercherPar.setFont(new Font("Arial", Font.BOLD, 12));
		btnRechercherPar.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255)));
		btnRechercherPar.setBackground(new Color(65, 105, 225));
		btnRechercherPar.setAlignmentX(0.5f);
		btnRechercherPar.setBounds(468, 131, 152, 36);
		getContentPane().add(btnRechercherPar);
		
		btnRechercherPar.addActionListener(this);
		
		String[] chmps= {"CIN","Nom","Prénom"};
		JComboBox comboBox_3 = new JComboBox(chmps);
		comboBox_3.setEditable(true);
		comboBox_3.setBackground(Color.WHITE);
		comboBox_3.setBounds(649, 135, 187, 31);
		getContentPane().add(comboBox_3);
		
		textField_recher = new JTextField();
		textField_recher.setColumns(10);
		textField_recher.setBackground(Color.WHITE);
		textField_recher.setBounds(861, 135, 187, 31);
		getContentPane().add(textField_recher);
		
		
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 487);
		setSize(1300,700);
		
	}
	@Override
	public void actionPerformed(ActionEvent arg) {
		String vr=(String) comboBox.getSelectedItem();
		if(arg.getSource()==btnSupprimer) {
			if(vr.equals("Client")){
				int row =jtb.getSelectedRow();
				String cin=(String) tab.getValueAt(row,0);
				tab.removeRow(row);
				try {
					st.executeUpdate("DELETE FROM clients WHERE CIN='"+cin+"'");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(vr.equals("Fournisseur")) {
				int row =jtb_1.getSelectedRow();
				String cin=(String) tab_1.getValueAt(row,0);
				tab_1.removeRow(row);
				try {
					st.executeUpdate("DELETE FROM fournisseur WHERE CIN='"+cin+"'");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if(arg.getSource()==btnAjouter) {
			String cin=textField_cin.getText();
			String nom=textField_nom.getText();
			String prenom=textField_prenom.getText();
			String email=textField_email.getText();
			String tele=textField_tele.getText();
			String adresse=textField_adresse.getText();
			if(vr.equals("Client")){
				if(!cin.equals("")&&!nom.equals("")&&!prenom.equals("")&&!email.equals("")&&!tele.equals("")&&!adresse.equals("")) {
					tab.addRow(cin,tab.getRowCount(),0);
					tab.addRow(nom,tab.getRowCount(),1);
					tab.addRow(prenom,tab.getRowCount(),2);
					tab.addRow(email,tab.getRowCount(),3);
					tab.addRow(tele,tab.getRowCount(),4);
					tab.addRow(adresse,tab.getRowCount(),5);
					try {
						st.executeUpdate("INSERT INTO clients VALUES('"+cin+"','"+nom+"','"+prenom+"','"+email+"','"+tele+"','"+adresse+"')");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					textField_cin.setText("");
					textField_nom.setText("");
					textField_prenom.setText("");
					textField_email.setText("");
					textField_tele.setText("");
					textField_adresse.setText("");
				}
			}
			else if(vr.equals("Fournisseur")) {
				if(!cin.equals("")&&!nom.equals("")&&!prenom.equals("")&&!email.equals("")&&!tele.equals("")&&!adresse.equals("")) {
					tab_1.addRow(cin,tab_1.getRowCount(),0);
					tab_1.addRow(nom,tab_1.getRowCount(),1);
					tab_1.addRow(prenom,tab_1.getRowCount(),2);
					tab_1.addRow(email,tab_1.getRowCount(),3);
					tab_1.addRow(tele,tab_1.getRowCount(),4);
					tab_1.addRow(adresse,tab_1.getRowCount(),5);
					try {
						st.executeUpdate("INSERT INTO fournisseur VALUES('"+cin+"','"+nom+"','"+prenom+"','"+email+"','"+tele+"','"+adresse+"')");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					textField_cin.setText("");
					textField_nom.setText("");
					textField_prenom.setText("");
					textField_email.setText("");
					textField_tele.setText("");
					textField_adresse.setText("");
				}
			}
		}
		if(arg.getSource()==btnModifier) {
			if(vr.equals("Client")) {
				textField_cin.setText((String)tab.getValueAt(jtb.getSelectedRow(),0));
				textField_nom.setText((String)tab.getValueAt(jtb.getSelectedRow(),1));
				textField_prenom.setText((String)tab.getValueAt(jtb.getSelectedRow(),2));
				textField_email.setText((String)tab.getValueAt(jtb.getSelectedRow(),3));
				textField_tele.setText((String)tab.getValueAt(jtb.getSelectedRow(),4));
				textField_adresse.setText((String)tab.getValueAt(jtb.getSelectedRow(),5));
			}
			else if(vr.equals("Fournisseur")) {
				textField_cin.setText((String)tab_1.getValueAt(jtb_1.getSelectedRow(),0));
				textField_nom.setText((String)tab_1.getValueAt(jtb_1.getSelectedRow(),1));
				textField_prenom.setText((String)tab_1.getValueAt(jtb_1.getSelectedRow(),2));
				textField_email.setText((String)tab_1.getValueAt(jtb_1.getSelectedRow(),3));
				textField_tele.setText((String)tab_1.getValueAt(jtb_1.getSelectedRow(),4));
				textField_adresse.setText((String)tab_1.getValueAt(jtb_1.getSelectedRow(),5));
			}
		}
		if(arg.getSource()==btnEnregister) {
			String cin=textField_cin.getText();
			String nom=textField_nom.getText();
			String prenom=textField_prenom.getText();
			String email=textField_email.getText();
			String tele=textField_tele.getText();
			String adresse=textField_adresse.getText();
			if(vr.equals("Client")) {
				tab.addRow(cin,jtb.getSelectedRow(),0);
				tab.addRow(nom,jtb.getSelectedRow(),1);
				tab.addRow(prenom,jtb.getSelectedRow(),2);
				tab.addRow(email,jtb.getSelectedRow(),3);
				tab.addRow(tele,jtb.getSelectedRow(),4);
				tab.addRow(adresse,jtb.getSelectedRow(),5);
				try {
					st.executeUpdate("UPDATE clients SET cin ='"+cin+"',nom='"+nom+"',prénom='"+prenom+"',email='"+email+"',telephone='"+tele+"',adresse='"+adresse+"' WHERE cin='"+cin+"'");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else if(vr.equals("Fournisseur")) {
				tab_1.addRow(cin,jtb_1.getSelectedRow(),0);
				tab_1.addRow(nom,jtb_1.getSelectedRow(),1);
				tab_1.addRow(prenom,jtb_1.getSelectedRow(),2);
				tab_1.addRow(email,jtb_1.getSelectedRow(),3);
				tab_1.addRow(tele,jtb_1.getSelectedRow(),4);
				tab_1.addRow(adresse,jtb_1.getSelectedRow(),5);
				try {
					st.executeUpdate("UPDATE fournisseur SET cin ='"+cin+"',nom='"+nom+"',prenom='"+prenom+"',email='"+email+"',telephone='"+tele+"',adresse='"+adresse+"' WHERE cin='"+cin+"'");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if(arg.getSource()==btnRechercherPar) {
			String cin=textField_recher.getText();
			System.out.println(cin);
			if(!cin.equals("")) {
				if(vr.equals("Client")) {
					for(int i=0;i<tab.getRowCount();i++)
						if(tab.getValueAt(i,0).equals(cin)) {
							textField_cin.setText((String)tab.getValueAt(i,0));
							textField_nom.setText((String)tab.getValueAt(i,1));
							textField_prenom.setText((String)tab.getValueAt(i,2));
							textField_email.setText((String)tab.getValueAt(i,3));
							textField_tele.setText((String)tab.getValueAt(i,4));
							textField_adresse.setText((String)tab.getValueAt(i,5));
						}
				}
				else if(vr.equals("Fournisseur"))
					for(int i=0;i<tab_1.getRowCount();i++)
						if(tab_1.getValueAt(i,0).equals(cin)) {
							textField_cin.setText((String)tab_1.getValueAt(i,0));
							textField_nom.setText((String)tab_1.getValueAt(i,1));
							textField_prenom.setText((String)tab_1.getValueAt(i,2));
							textField_email.setText((String)tab_1.getValueAt(i,3));
							textField_tele.setText((String)tab_1.getValueAt(i,4));
							textField_adresse.setText((String)tab_1.getValueAt(i,5));
						}
			}
		}
	}
}
