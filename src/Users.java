import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Rectangle;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Users extends JFrame {
	
	// Les composants de la fênetre
	JTextField search_word,txt_name1,txt_name2,txt_pwd,txt_username;
	JButton Ajout_user,Retour,modify_user,delete_user,register_user,search_user;
    JTable table_user;
    JLabel title_user,label,name_user,id_user,prenom_user,password_user,username,erreur;
    JPanel chmps_panel,table_panel,paneltitle;
    DefaultTableModel mu=new DefaultTableModel();
    Connection cu;
    Statement stu;
    ResultSet rsu;
    JComboBox id_box,champs;
    static int row_u;
    static int currentrow_u;

	
	    // Constructeur de la fênetre
	    public Users() {
	 
		
		// GRAPHIQUE 
	    	
	    // fênetre
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		// Panel de titre
		paneltitle = new JPanel();
		paneltitle.setBackground(new Color(65, 105, 225));
		paneltitle.setBounds(0, 0, 1284, 108);
		paneltitle.setLayout(null);
		getContentPane().add(paneltitle);

		
		// Label titre 
		 title_user = new JLabel("Utilisateurs/Caissiers");
		title_user.setBackground(new Color(255, 255, 255));
		title_user.setAlignmentX(Component.CENTER_ALIGNMENT);
		title_user.setFont(new Font("Cambria", Font.BOLD, 28));
		title_user.setForeground(new Color(255, 255, 255));
		title_user.setHorizontalTextPosition(SwingConstants.CENTER);
		title_user.setHorizontalAlignment(SwingConstants.CENTER);
		title_user.setBounds(530, 32, 399, 51);
		paneltitle.add(title_user);
		
		// Boutton de retour 
		 Retour = new JButton("");
		Image iret5=new ImageIcon(this.getClass().getResource("return.png")).getImage();
		Retour.setToolTipText("Retour vers Menu");
		Retour.setIcon(new ImageIcon(iret5));
		Retour.setBackground(new Color(65, 105, 225));
		Retour.setBounds(0, 0, 23, 108);
		paneltitle.add(Retour);
		
		
		
		// fonctionnenement de bouton de retour
		Retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu menu=new Menu();
				setVisible(false);
				menu.setVisible(true);
			}
		});
		
		// Label d'icon
	    label = new JLabel("");
		Image i21=new ImageIcon(this.getClass().getResource("customer.png")).getImage();
		label.setIcon(new ImageIcon(i21));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(492, 11, 102, 72);
		paneltitle.add(label);
		
		
	// BASE DE DONNEE
		
		// nommer les colonnes 
		mu.addColumn("ID");
		mu.addColumn("Nom");
		mu.addColumn("Prénom");
		mu.addColumn("Nom d'utilisateur");
		mu.addColumn("Mot de passe");
		
		//connexion base donnee
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 try {
			 cu=DriverManager.getConnection("jdbc:mysql://localhost/application?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
			 stu=cu.createStatement();
			 rsu=stu.executeQuery("select * from users");
			 User u;
				while(rsu.next())
				 {
					mu.addRow(new Object[]{ rsu.getInt("ID"),rsu.getString("Nom"),rsu.getString("Prenom"),rsu.getString("Username"),rsu.getInt("Password")});
				 }
			}
		 catch (SQLException e) {
				e.printStackTrace();
			}
		 
		 
		 // Panel contenant la table
	    table_panel = new JPanel();
		table_panel.setLayout(null);
		table_panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Table des Utilisateurs ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		table_panel.setBackground(Color.WHITE);
		table_panel.setBounds(468, 178, 789, 472);
		getContentPane().add(table_panel);
		
		// Table avec le modele
		table_user = new JTable();
		table_user.setModel(mu);
		
		// retourner la ligne séléctionée dans la table
		table_user.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent arg0) {
				try {
					row_u=table_user.getSelectedRow();
				
					} catch (Exception e) {
				    e.printStackTrace();
							}
						}
					});
		
		
		// ajouter table au scroll pane puis au panel
		JScrollPane scroll_user = new JScrollPane();
		scroll_user.setBounds(29, 43, 725, 399);
		scroll_user.setViewportView(table_user);
	     table_panel.add(scroll_user);

		
		// bouton ajouter user
		 Ajout_user = new JButton("Ajouter");
		Image i22=new ImageIcon(this.getClass().getResource("ajouter.png")).getImage();
		 Ajout_user.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	    int id=(Integer)id_box.getSelectedItem();
		 		String nom=txt_name1.getText();
				String prenom=txt_name2.getText();
				String nuser=txt_username.getText();
				String puser=txt_pwd.getText();
				
				if(!nom.equals("") && !prenom.equals("") && !nuser.equals("") && !puser.equals("")) {
					if(id>currentrow_u) {
					try {
						stu.executeUpdate("insert into users(ID,Nom,Prenom,Username,Password) values('"+id+"','"+nom+"','"+prenom+"','"+nuser+"','"+puser+"')");
						JOptionPane.showMessageDialog(null,"Utilisateur bien ajouté");
						UpdateTable();
						txt_name1.setText("");txt_name2.setText("");txt_username.setText("");txt_pwd.setText("");id_box.setSelectedIndex(0);
						
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null,e1.getMessage());
					}	
				}
					else if(id<currentrow_u) {
						JOptionPane.showMessageDialog(null,"L'ID est unique et inchangeable");
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"*Vous devez remplir tous les champs");
				}
				
			}		
		 });
		Ajout_user.setIcon(new ImageIcon(i22));
		Ajout_user.setFont(new Font("Arial", Font.BOLD, 12));
		Ajout_user.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255)));
		Ajout_user.setAlignmentX(Component.CENTER_ALIGNMENT);
		Ajout_user.setBackground(new Color(65, 105, 225));
		Ajout_user.setForeground(new Color(255, 255, 255));
		Ajout_user.setToolTipText("Ajouter un nouveau produit \u00E0 la table");
		Ajout_user.setBounds(29, 131, 127, 36);
		getContentPane().add(Ajout_user);
		
		
		//bouton modifier
		modify_user = new JButton("Modifier\r\n");
		Image i23=new ImageIcon(this.getClass().getResource("modifier.png")).getImage();
		// fonctionnement du bouton modifier:récupération de la ligne séléctionée et l'afficher dans les champs 
		modify_user.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				deplace(row_u);

			}
		});
		modify_user.setToolTipText("Modifier un produit de la table");
		modify_user.setIcon(new ImageIcon(i23));
		modify_user.setFont(new Font("Arial", Font.BOLD, 12));
		modify_user.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255)));
		modify_user.setAlignmentX(Component.CENTER_ALIGNMENT);
		modify_user.setBackground(new Color(65, 105, 225));
		modify_user.setForeground(new Color(255, 255, 255));
		modify_user.setBounds(166, 131, 127, 36);
		getContentPane().add(modify_user);
		
		
		// suppression boutton
		delete_user = new JButton("Supprimer\r\n");
		Image i24=new ImageIcon(this.getClass().getResource("delete.png")).getImage();
		delete_user.setToolTipText("Supprimer un produit de la table");
		delete_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					stu.executeUpdate("DELETE FROM users WHERE ID='"+mu.getValueAt(row_u,0)+"'");
					JOptionPane.showMessageDialog(null,"Utilisateur bien suprimé ");
					UpdateTable();
				} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,"Suppression impossible");
				}	
			}
		});
		delete_user.setIcon(new ImageIcon(i24));
		delete_user.setFont(new Font("Arial", Font.BOLD, 12));
		delete_user.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255)));
		delete_user.setAlignmentX(Component.CENTER_ALIGNMENT);
		delete_user.setBackground(new Color(65, 105, 225));
		delete_user.setForeground(new Color(255, 255, 255));
		delete_user.setBounds(303, 131, 127, 36);
		getContentPane().add(delete_user);
		
		
		// Panel pour champs
	    chmps_panel = new JPanel();
		chmps_panel.setForeground(new Color(0, 0, 255));
		chmps_panel.setBackground(new Color(255, 255, 255));
		chmps_panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Infos sur Utilisateurs", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		chmps_panel.setBounds(39, 178, 401, 472);
		getContentPane().add(chmps_panel);
		chmps_panel.setLayout(null);
		
		
		// Label ID
		id_user = new JLabel("ID :");
		id_user.setFont(new Font("Arial", Font.BOLD, 12));
		id_user.setBounds(20, 66, 106, 21);
		chmps_panel.add(id_user);
		
		// champ pour nom 
		txt_name1 = new JTextField();
		txt_name1.setBackground(new Color(255, 255, 255));
		txt_name1.setColumns(10);
		txt_name1.setBounds(136, 131, 233, 31);
		chmps_panel.add(txt_name1);
		
		// champ pour prenom
		txt_name2 = new JTextField();
		txt_name2.setBackground(new Color(255, 255, 255));
		txt_name2.setColumns(10);
		txt_name2.setBounds(136, 203, 233, 31);
		chmps_panel.add(txt_name2);
		
		//label pour nom
		name_user = new JLabel("Nom :");
		name_user.setFont(new Font("Arial", Font.BOLD, 12));
		name_user.setBounds(20, 135, 106, 21);
		chmps_panel.add(name_user);
		
		//label pour prenom
		prenom_user = new JLabel("Pr\u00E9nom :");
		prenom_user.setFont(new Font("Arial", Font.BOLD, 12));
		prenom_user.setBounds(20, 207, 106, 21);
		chmps_panel.add(prenom_user);
		
		//id cambobox
		id_box = new JComboBox();
		for(Integer i=1;i<=10;i++) {
			id_box.addItem(i);
		}
		id_box.setEditable(true);
		id_box.setBackground(new Color(255, 255, 255));
		id_box.setBounds(137, 62, 51, 31);
		chmps_panel.add(id_box);
		
		// password label
		password_user = new JLabel("Mot de passe :");
		password_user.setFont(new Font("Arial", Font.BOLD, 12));
		password_user.setBounds(20, 351, 106, 21);
		chmps_panel.add(password_user);
		
		//username label
		username = new JLabel("Nom utilisateur :");
		username.setFont(new Font("Arial", Font.BOLD, 12));
		username.setBounds(20, 276, 106, 21);
		chmps_panel.add(username);
		
		// bouton pour enregistrer modification
		register_user = new JButton("Enregister");
		Image i26=new ImageIcon(this.getClass().getResource("register.png")).getImage();
		register_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom=txt_name1.getText();
				String prenom=txt_name2.getText();
				String nuser=txt_username.getText();
				String puser=txt_pwd.getText();
				int id=id_box.getSelectedIndex()+1;
				
				if(!nom.equals("") && !prenom.equals("") && !nuser.equals("") && !puser.equals("")) {
					if(id_box.getSelectedIndex()==row_u) {
						if(JOptionPane.showConfirmDialog(null, "Confirmer La modification","Confirmer",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
					try {
						stu.executeUpdate("UPDATE users SET Nom='"+nom+"',Prenom='"+prenom+"',Username='"+nuser+"',Password='"+puser+"' where ID="+id);
						UpdateTable();
						txt_name1.setText("");txt_name2.setText("");txt_username.setText("");txt_pwd.setText("");id_box.setSelectedIndex(0);
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					
				}
						else {
							txt_name1.setText("");txt_name2.setText("");txt_username.setText("");txt_pwd.setText("");id_box.setSelectedIndex(0);

						}
						}
					else {
						JOptionPane.showMessageDialog(null, "L'ID est unique et inchangeable");
					}
						
					}
				else {
					JOptionPane.showMessageDialog(null,"*Vous devez remplir tous les champs");
	
				}
			}
		});
		register_user.setIcon(new ImageIcon(i26));
		register_user.setForeground(Color.WHITE);
		register_user.setFont(new Font("Arial", Font.BOLD, 12));
		register_user.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255)));
		register_user.setBackground(new Color(65, 105, 225));
		register_user.setAlignmentX(0.5f);
		register_user.setBounds(242, 389, 127, 36);
		chmps_panel.add(register_user);
		
		// text de saisi password
		txt_pwd = new JTextField();
		txt_pwd.setColumns(10);
		txt_pwd.setBackground(Color.WHITE);
		txt_pwd.setBounds(136, 347, 233, 31);
		chmps_panel.add(txt_pwd);
		
		// texte de saisi username
		txt_username = new JTextField();
		txt_username.setColumns(10);
		txt_username.setBackground(Color.WHITE);
		txt_username.setBounds(136, 277, 233, 31);
		chmps_panel.add(txt_username);
		
		
		// boutton de recherche
		search_user = new JButton("Rechercher par :");
		Image i25=new ImageIcon(this.getClass().getResource("search.png")).getImage();
		search_user.setIcon(new ImageIcon(i25));
		search_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s=search_word.getText();
				String ch=champs.getSelectedItem().toString();
				mu.setRowCount(0); // vider la table pour afficher que la ligne rechérchée 
				switch(ch) {
				case "Nom": 
					try {
						rsu=stu.executeQuery("select *from users where Nom='"+s+"'");
						while(rsu.next())
						 {
						mu.addRow(new Object[]{ rsu.getInt("ID"),rsu.getString("Nom"),rsu.getString("Prenom"),rsu.getString("Username"),rsu.getString("Password")});
						 }
						if(mu.getRowCount()==0) {JOptionPane.showMessageDialog(null, "Utilisateur introuvable");UpdateTable(); search_word.setText("");}

					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case "Prenom":
					try {
						rsu=stu.executeQuery("select *from users where Prenom='"+s+"'");
						while(rsu.next())
						 {
						mu.addRow(new Object[]{ rsu.getInt("ID"),rsu.getString("Nom"),rsu.getString("Prenom"),rsu.getString("Username"),rsu.getString("Password")});
						 }
						if(mu.getRowCount()==0) {JOptionPane.showMessageDialog(null, "Utilisateur introuvable");UpdateTable(); search_word.setText("");}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case "Username":
					try {
						rsu=stu.executeQuery("select *from users where Username='"+s+"'");
						while(rsu.next())
						 {
						mu.addRow(new Object[]{ rsu.getInt("ID"),rsu.getString("Nom"),rsu.getString("Prenom"),rsu.getString("Username"),rsu.getString("Password")});
						 }
						if(mu.getRowCount()==0) {JOptionPane.showMessageDialog(null, "Utilisateur introuvable");UpdateTable(); search_word.setText("");}

					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
					
				}
				}
				
			}
		);
		search_user.setToolTipText("Rechercher un produit par champs");
		search_user.setForeground(Color.WHITE);
		search_user.setFont(new Font("Arial", Font.BOLD, 12));
		search_user.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255)));
		search_user.setBackground(new Color(65, 105, 225));
		search_user.setAlignmentX(0.5f);
		search_user.setBounds(468, 131, 152, 36);
		getContentPane().add(search_user);
		
		// Champs pour recherche
		String[] chmps= {"Nom","Prenom","Username"};
		champs = new JComboBox(chmps);
		champs.setEditable(true);
		champs.setBackground(Color.WHITE);
		champs.setBounds(649, 135, 187, 31);
		getContentPane().add(champs);
		
		// saisi pour la recherche d'un utilisateur
		search_word = new JTextField();
		search_word.setColumns(10);
		search_word.setBackground(Color.WHITE);
		search_word.setBounds(861, 135, 187, 31);
		getContentPane().add(search_word);
		
	    
		
		
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 487);
		setSize(1300,700);
		setVisible(true);
		
		// méthode pour actualiser à chaque fois la table lors de louverture de la fênetre
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent arg0) {
				mu.setRowCount(0);
				//connexion base donnee
				 try {
					 rsu=stu.executeQuery("select * from users");
					 User u;
						while(rsu.next())
						 {
							mu.addRow(new Object[]{ rsu.getInt("ID"),rsu.getString("Nom"),rsu.getString("Prenom"),rsu.getString("Username"),rsu.getString("Password")});
						 }
					}
				 catch (SQLException e) {
						e.printStackTrace();
					}
				    currentrow_u=mu.getRowCount();
					table_user.setModel(mu);
			}
		});

		
		 
	}
	public void deplace(int i) {
		try {
			id_box.setSelectedItem((Integer)mu.getValueAt(i,0));
			txt_name1.setText(mu.getValueAt(i,1).toString());
			txt_name2.setText(mu.getValueAt(i,2).toString());
			txt_username.setText(mu.getValueAt(i,3).toString());
			txt_pwd.setText(mu.getValueAt(i,4).toString());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erreur de déplacement");;
		}
		
		
	}

	
	public void UpdateTable() {
		// BASE DE DONNEE
		mu.setRowCount(0);
		//connexion base donnee
		 try {
			 rsu=stu.executeQuery("select * from users");
				while(rsu.next())
				 {
					mu.addRow(new Object[]{ rsu.getInt("ID"),rsu.getString("Nom"),rsu.getString("Prenom"),rsu.getString("Username"),rsu.getString("Password")});
				 }
			}
		 catch (SQLException e) {
				e.printStackTrace();
			}
			table_user.setModel(mu);
			

		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Users frame = new Users();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	}
	

