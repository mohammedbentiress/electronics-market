import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;

public class Stock extends JFrame {

	 JPanel contentPane,paneltitle,info_p,table_p;
	 JTextField code_txt,nomp_txt,search_txt,prix_txt,remise_txt;
	 JLabel lblNewLabel,label,id_label,code_label,nomp_label,categ_label,descr_label,quant_label,prix_label,remise_label,four_label;
	 JButton btnNewButton_1,ajout_p,modify_p,delete_p,search_p,register_p;
	 JComboBox categ_box,id_box,quant_box,four_box,search_box;
	 JTable table_produit;
	 JTextArea textArea;
	 DefaultTableModel mp=new DefaultTableModel();
	 Connection cp;
	 Statement stp;
	 ResultSet rsp;
	 static int row_p,currentrow_p;

 /** Constructeur  */
public Stock() {
	// BASE DE DONNEE
	
			// nommer les colonnes 
			mp.addColumn("ID");
			mp.addColumn("Code");
			mp.addColumn("N.Produit");
			mp.addColumn("Désignation");
			mp.addColumn("Quantité");
			mp.addColumn("Prix");
			mp.addColumn("Remise(%)");
			mp.addColumn("Catégorie");
			mp.addColumn("Fournisseur");
			
			
			//connexion base donnee
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			 try {
				 cp=DriverManager.getConnection("jdbc:mysql://localhost/application?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
				 stp=cp.createStatement();
				 rsp=stp.executeQuery("select * from produits");
					while(rsp.next())
					 {
						mp.addRow(new Object[]{ rsp.getInt("id"),rsp.getInt("code"),rsp.getString("produit"),rsp.getString("designation"),rsp.getInt("quantite"),rsp.getFloat("prix"),rsp.getDouble("remise"),rsp.getString("categorie"),rsp.getString("fournisseur")});
					 }
				}
			 catch (SQLException e) {
					e.printStackTrace();
				}
			 
	
	    /** Content pane */
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		/** Panel du titre */
		paneltitle = new JPanel();
		paneltitle.setBackground(new Color(65, 105, 225));
		paneltitle.setBounds(0, 0, 1284, 108);
		getContentPane().add(paneltitle);
		paneltitle.setLayout(null);
		
		/** Label du titre */
		lblNewLabel = new JLabel("Stock de Produits");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 28));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setLabelFor(lblNewLabel);
		lblNewLabel.setBounds(522, 32, 399, 51);
		paneltitle.add(lblNewLabel);
		
		/** Boutton de retour */
		btnNewButton_1 = new JButton("");
		Image iret4=new ImageIcon(this.getClass().getResource("return.png")).getImage();
		btnNewButton_1.setToolTipText("Retour vers Menu");
		btnNewButton_1.setIcon(new ImageIcon(iret4));
		btnNewButton_1.setBackground(new Color(65, 105, 225));
		btnNewButton_1.setBounds(0, 0, 23, 108);
		paneltitle.add(btnNewButton_1);
		/** Fonctionnement du bouton retour */
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu m=new Menu();
				m.setVisible(true);
				setVisible(false);	
			}
		});
		
		/** Label d'icon */
		label = new JLabel("");
		Image i15=new ImageIcon(this.getClass().getResource("stock.png")).getImage();
		label.setIcon(new ImageIcon(i15));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(513, 11, 102, 72);
		paneltitle.add(label);
		
		
		/** Bouton d'ajout dun produit */
		ajout_p = new JButton("Ajouter");
		Image i16=new ImageIcon(this.getClass().getResource("ajouter.png")).getImage();
		ajout_p.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id=(Integer)id_box.getSelectedItem();
				int code=Integer.parseInt(code_txt.getText());
				String nomp=nomp_txt.getText();
				String categ=categ_box.getSelectedItem().toString();
				String descr=textArea.getText();
				int quant=(Integer)quant_box.getSelectedItem();
				float prix=Float.parseFloat(prix_txt.getText());
				double remise=Double.parseDouble(remise_txt.getText());
				String fourn=four_box.getSelectedItem().toString();
				if(code!=0 && !remise_txt.getText().equals("") && prix!=0 && !prix_txt.getText().equals("") && !descr.equals("") && !nomp.equals("")) {
					if(id>currentrow_p) {
					try {
							stp.executeUpdate("insert into produits(id,code,produit,designation,quantite,prix,remise,categorie,fournisseur) values('"+id+"','"+code+"','"+nomp+"','"+descr+"','"+quant+"','"+prix+"','"+remise+"','"+categ+"','"+fourn+"')");
							JOptionPane.showMessageDialog(null,"Utilisateur bien ajouté");
							UpdateTable();
							nomp_txt.setText("");textArea.setText("");prix_txt.setText("");remise_txt.setText("");id_box.setSelectedIndex(0);categ_box.setSelectedIndex(0);code_txt.setText("");quant_box.setSelectedIndex(0);four_box.setSelectedIndex(0);
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(null,e1.getMessage()); 
						}
					}
					else if(id<currentrow_p) {
						JOptionPane.showMessageDialog(null,"L'ID est unique et inchangeable");
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Vous devez remplir tous les champs");
				}
			
			}
		});
		ajout_p.setIcon(new ImageIcon(i16));
		ajout_p.setFont(new Font("Arial", Font.BOLD, 12));
		ajout_p.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255)));
		ajout_p.setAlignmentX(Component.CENTER_ALIGNMENT);
		ajout_p.setBackground(new Color(65, 105, 225));
		ajout_p.setForeground(new Color(255, 255, 255));
		ajout_p.setToolTipText("Ajouter un nouveau produit \u00E0 la table");
		ajout_p.setBounds(29, 131, 127, 36);
		getContentPane().add(ajout_p);
		
		
		/** Bouton de modification d'un prodit */
		modify_p = new JButton("Modifier\r\n");
		modify_p.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deplace(row_p);
			}
		});
		modify_p.setToolTipText("Modifier un produit de la table");
		Image i17=new ImageIcon(this.getClass().getResource("modifier.png")).getImage();
		modify_p.setIcon(new ImageIcon(i17));
		modify_p.setFont(new Font("Arial", Font.BOLD, 12));
		modify_p.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255)));
		modify_p.setAlignmentX(Component.CENTER_ALIGNMENT);
		modify_p.setBackground(new Color(65, 105, 225));
		modify_p.setForeground(new Color(255, 255, 255));
		modify_p.setBounds(166, 131, 127, 36);
		getContentPane().add(modify_p);
		
		
		/** Boutton de suppression d'un produit */
		delete_p = new JButton("Supprimer\r\n");
		Image i18=new ImageIcon(this.getClass().getResource("delete.png")).getImage();
		delete_p.setToolTipText("Supprimer un produit de la table");
		delete_p.setIcon(new ImageIcon(i18));
		delete_p.setFont(new Font("Arial", Font.BOLD, 12));
		delete_p.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255)));
		delete_p.setAlignmentX(Component.CENTER_ALIGNMENT);
		delete_p.setBackground(new Color(65, 105, 225));
		delete_p.setForeground(new Color(255, 255, 255));
		delete_p.setBounds(303, 131, 127, 36);
		getContentPane().add(delete_p);
		delete_p.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "Confirmer la Suppression","Confirmer",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
				try {
					stp.executeUpdate("DELETE FROM produits WHERE id='"+mp.getValueAt(row_p,0)+"'");
					JOptionPane.showMessageDialog(null,"Utilisateur bien suprimé ");
					UpdateTable();
				} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,e.getMessage());
				}
				}
			}
		});
		
		/** Panel des champs du produits */
		info_p = new JPanel();
		info_p.setForeground(new Color(0, 0, 255));
		info_p.setBackground(new Color(255, 255, 255));
		info_p.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Infos sur Produit", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		info_p.setBounds(29, 178, 401, 472);
		getContentPane().add(info_p);
		info_p.setLayout(null);
		
		/** Label ID */
		id_label = new JLabel("ID :");
		id_label.setFont(new Font("Arial", Font.BOLD, 12));
		id_label.setBounds(20, 40, 106, 21);
		info_p.add(id_label);
		
	    /** Textfield pour code */
		code_txt = new JTextField();
		code_txt.setBackground(new Color(255, 255, 255));
		code_txt.setColumns(10);
		code_txt.setBounds(136, 77, 233, 31);
		info_p.add(code_txt);
		
	    /** Textfield pour nom */
		nomp_txt = new JTextField();
		nomp_txt.setBackground(new Color(255, 255, 255));
		nomp_txt.setColumns(10);
		nomp_txt.setBounds(136, 119, 233, 31);
		info_p.add(nomp_txt);
		
		/** Label code */
		code_label = new JLabel("Code :");
		code_label.setFont(new Font("Arial", Font.BOLD, 12));
		code_label.setBounds(20, 82, 106, 21);
		info_p.add(code_label);
		
		/** Label Nom produit */
		nomp_label = new JLabel("Nom Produit :");
		nomp_label.setFont(new Font("Arial", Font.BOLD, 12));
		nomp_label.setBounds(20, 124, 106, 21);
		info_p.add(nomp_label);
		
		/** ComboBox pour ID */
		id_box = new JComboBox();
		for(int i=1;i<=20;i++) {
			id_box.addItem((Integer)i);
		}
		id_box.setEditable(true);
		id_box.setBackground(new Color(255, 255, 255));
		id_box.setBounds(136, 35, 51, 31);
		info_p.add(id_box);
		
		/** ComboBox Catégorie */
		String[] cat= {"Smartphone","SSD","Gaming","Speakers","PC portable"};
		categ_box = new JComboBox(cat);
		categ_box.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		categ_box.setBackground(new Color(255, 255, 255));
		categ_box.setBounds(136, 161, 233, 31);
		info_p.add(categ_box);
		
		/** Label de catégorie */
		categ_label = new JLabel("Cat\u00E9gorie :");
		categ_label.setFont(new Font("Arial", Font.BOLD, 12));
		categ_label.setBounds(20, 166, 106, 21);
		info_p.add(categ_label);
		
		/** ComboBox de quantité */
		quant_box = new JComboBox();
		quant_box.setEditable(true);
		quant_box.setBackground(Color.WHITE);
		quant_box.setBounds(136, 245, 51, 31);
		info_p.add(quant_box);
		for(Integer i=1;i<=50;i++) {
			quant_box.addItem(i);
		}
		
		/** TextField pour prix */
		prix_txt = new JTextField();
		prix_txt.setBounds(136, 287, 233, 31);
		info_p.add(prix_txt);
		
		/** TextField pour remise */
		remise_txt = new JTextField();
		remise_txt.setBounds(136, 329, 233, 31);
		info_p.add(remise_txt);
		
		/** ComboBox pour fournisseur */
		four_box = new JComboBox();
		four_box.setBackground(Color.WHITE);
		four_box.setBounds(136, 371, 233, 31);
		info_p.add(four_box);
		
		/** Boutton pour enregistrer les modifications */
		register_p = new JButton("Enregister");
		Image i19=new ImageIcon(this.getClass().getResource("register.png")).getImage();
		register_p.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id=(Integer)id_box.getSelectedItem();
				int code=Integer.parseInt(code_txt.getText());
				String nomp=nomp_txt.getText();
				String categ=categ_box.getSelectedItem().toString();
				String descr=textArea.getText();
				int quant=(Integer)quant_box.getSelectedItem();
				float prix=Float.parseFloat(prix_txt.getText());
				double remise=Double.parseDouble(remise_txt.getText());
				String fourn=four_box.getSelectedItem().toString();
				
				
			if(code!=0 && !remise_txt.getText().equals("") && prix!=0 && !prix_txt.getText().equals("") && !descr.equals("") && !nomp.equals("")) {
				if(id==(Integer)mp.getValueAt(row_p,0)) {
					if(JOptionPane.showConfirmDialog(null, "Confirmer La modification","Confirmer",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
			try {
				stp.executeUpdate("UPDATE produits SET code='"+code+"',produit='"+nomp+"',categorie='"+categ+"',designation='"+descr+"',quantite='"+quant+"',prix='"+prix+"',remise='"+remise+"',fournisseur='"+fourn+"' where id="+id);
				UpdateTable();
				nomp_txt.setText("");textArea.setText("");prix_txt.setText("");remise_txt.setText("");id_box.setSelectedIndex(0);categ_box.setSelectedIndex(0);code_txt.setText("");quant_box.setSelectedIndex(0);four_box.setSelectedIndex(0);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					
				}
					else {
				nomp_txt.setText("");textArea.setText("");prix_txt.setText("");remise_txt.setText("");id_box.setSelectedIndex(0);categ_box.setSelectedIndex(0);code_txt.setText("");quant_box.setSelectedIndex(0);four_box.setSelectedIndex(0);
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
		register_p.setIcon(new ImageIcon(i19));
		register_p.setForeground(Color.WHITE);
		register_p.setFont(new Font("Arial", Font.BOLD, 12));
		register_p.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255)));
		register_p.setBackground(new Color(65, 105, 225));
		register_p.setAlignmentX(0.5f);
		register_p.setBounds(242, 425, 127, 36);
		info_p.add(register_p);
		
		/** Label pour description du produit */
		descr_label = new JLabel("Description :");
		descr_label.setFont(new Font("Arial", Font.BOLD, 12));
		descr_label.setBounds(20, 208, 106, 21);
		info_p.add(descr_label);
		
		/** Label pour quantité */
		quant_label = new JLabel("Quantit\u00E9 :");
		quant_label.setFont(new Font("Arial", Font.BOLD, 12));
		quant_label.setBounds(20, 253, 106, 21);
		info_p.add(quant_label);
	
		
		/** Label pour prix */
		prix_label = new JLabel("Prix :");
		prix_label.setFont(new Font("Arial", Font.BOLD, 12));
		prix_label.setBounds(20, 292, 106, 21);
		info_p.add(prix_label);
		
		/** Label pour remise */
		remise_label = new JLabel("Remise :");
		remise_label.setFont(new Font("Arial", Font.BOLD, 12));
		remise_label.setBounds(20, 334, 106, 21);
		info_p.add(remise_label);
		
		/** Label pour fournisseur */
		four_label = new JLabel("Fournisseur :");
		four_label.setFont(new Font("Arial", Font.BOLD, 12));
		four_label.setBounds(20, 376, 106, 21);
		info_p.add(four_label);
		
		textArea = new JTextArea();
		textArea.setRows(5);
		textArea.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textArea.setBounds(136, 203, 233, 31);
		info_p.add(textArea);
		
		/** Panel contenant la table des produits */
		table_p = new JPanel();
		table_p.setBackground(new Color(255, 255, 255));
		table_p.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tableau de Produits", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		table_p.setBounds(468, 178, 789, 472);
		getContentPane().add(table_p);
		table_p.setLayout(null);
		/** Table des pproduits */
		table_produit=new JTable();
		table_produit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				try {
					row_p=table_produit.getSelectedRow();
					
				
					} catch (Exception e) {
				    e.printStackTrace();
							}
						
			}
		});
		table_produit.setModel(mp);
		// ajouter table au scroll pane puis au panel
		JScrollPane scroll_p = new JScrollPane();
		scroll_p.setBounds(29, 43, 725, 399);
		scroll_p.setViewportView(table_produit);
        table_p.add(scroll_p);
		
		
		/** Boutton pour rechercher un produit */
		search_p = new JButton("Rechercher par :");
		Image i20=new ImageIcon(this.getClass().getResource("search.png")).getImage();
		search_p.setIcon(new ImageIcon(i20));
		search_p.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				String s=search_txt.getText();
				String ch=search_box.getSelectedItem().toString();
				mp.setRowCount(0); // vider la table pour afficher que la ligne rechérchée 
				switch(ch) {
				case "ID": 
					try {
						rsp=stp.executeQuery("select *from produits where id='"+Integer.parseInt(s)+"'");
						while(rsp.next())
						 {
					mp.addRow(new Object[]{ rsp.getInt("id"),rsp.getInt("code"),rsp.getString("produit"),rsp.getString("designation"),rsp.getInt("quantite"),rsp.getDouble("prix"),rsp.getDouble("remise"),rsp.getString("categorie"),rsp.getString("fournisseur")});

						 }
						if(mp.getRowCount()==0) {JOptionPane.showMessageDialog(null, "Produit introuvable");UpdateTable();search_txt.setText("");}

					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case "Code":
					try {
						rsp=stp.executeQuery("select *from produits where code='"+Integer.parseInt(s)+"'");
						while(rsp.next())
						 {
						mp.addRow(new Object[]{ rsp.getInt("id"),rsp.getInt("code"),rsp.getString("produit"),rsp.getString("designation"),rsp.getInt("quantite"),rsp.getDouble("prix"),rsp.getDouble("remise"),rsp.getString("categorie"),rsp.getString("fournisseur")});
						 }
						if(mp.getRowCount()==0) {JOptionPane.showMessageDialog(null, "Utilisateur introuvable");UpdateTable();search_txt.setText("");}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case "Catégorie":
					try {
						rsp=stp.executeQuery("select *from produits where categorie='"+s+"'");
						while(rsp.next())
						 {
						mp.addRow(new Object[]{ rsp.getInt("id"),rsp.getInt("code"),rsp.getString("produit"),rsp.getString("designation"),rsp.getInt("quantite"),rsp.getDouble("prix"),rsp.getDouble("remise"),rsp.getString("categorie"),rsp.getString("fournisseur")});
						 }
						if(mp.getRowCount()==0) {JOptionPane.showMessageDialog(null, "Utilisateur introuvable");UpdateTable();search_txt.setText("");}

					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				}
			}
		});
		search_p.setToolTipText("Rechercher un produit par champs");
		search_p.setForeground(Color.WHITE);
		search_p.setFont(new Font("Arial", Font.BOLD, 12));
		search_p.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255)));
		search_p.setBackground(new Color(65, 105, 225));
		search_p.setAlignmentX(0.5f);
		search_p.setBounds(468, 131, 152, 36);
		getContentPane().add(search_p);
		
		/** ComboBox pour recherche */
		String[] chmps= {"ID","Code","Catégorie"};
		search_box = new JComboBox(chmps);
		search_box.setEditable(true);
		search_box.setBackground(Color.WHITE);
		search_box.setBounds(649, 135, 187, 31);
		getContentPane().add(search_box);
		
		/** textField pour mot rechérché */
		search_txt = new JTextField();
		search_txt.setColumns(10);
		search_txt.setBackground(Color.WHITE);
		search_txt.setBounds(861, 135, 187, 31);
		getContentPane().add(search_txt);
		
		/** ContentPane */
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 487);
		setSize(1300,700);
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent arg0) {
				mp.setRowCount(0);
				//connexion base donnee
				 try {
					 rsp=stp.executeQuery("select * from produits");
						while(rsp.next())
						 {
						 mp.addRow(new Object[]{ rsp.getInt("id"),rsp.getInt("code"),rsp.getString("produit"),rsp.getString("designation"),rsp.getInt("quantite"),rsp.getDouble("prix"),rsp.getDouble("remise"),rsp.getString("categorie"),rsp.getString("fournisseur")});

						 }
						currentrow_p=mp.getRowCount();
						 }
					
				 catch (SQLException e) {
						e.printStackTrace();
					}
					table_produit.setModel(mp);
					for(int i=0;i<=8;i++) {
						four_box.addItem(mp.getValueAt(i,8));
					}
			
		
	
}
			});
		}
		
 public void deplace(int i) {
	try {
		id_box.setSelectedItem((Integer)mp.getValueAt(i,0));
		code_txt.setText(mp.getValueAt(i,1).toString());
		nomp_txt.setText(mp.getValueAt(i,2).toString());
		textArea.setText(mp.getValueAt(i,3).toString());
		quant_box.setSelectedItem((Integer)mp.getValueAt(i,4));
		categ_box.setSelectedItem(mp.getValueAt(i,7).toString());
		prix_txt.setText(mp.getValueAt(i,5).toString());
		remise_txt.setText(mp.getValueAt(i,6).toString());
		four_box.setSelectedItem(mp.getValueAt(i,8));
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Erreur de déplacement");;
	}
	
	
} 
public void UpdateTable() {
	mp.setRowCount(0);
	 try {
		 rsp=stp.executeQuery("select * from produits");
			while(rsp.next())
			 {
			  mp.addRow(new Object[]{ rsp.getInt("id"),rsp.getInt("code"),rsp.getString("produit"),rsp.getString("designation"),rsp.getInt("quantite"),rsp.getDouble("prix"),rsp.getDouble("remise"),rsp.getString("categorie"),rsp.getString("fournisseur")});
			 }
		}
	 catch (SQLException e) {
			e.printStackTrace();
		}
		table_produit.setModel(mp);
	
}
/** Lancement de la fênetre */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stock frame = new Stock();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
