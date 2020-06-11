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
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;

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

public class Facture extends JFrame implements ActionListener{
	public static Connection  c;
	public static Statement st;
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
					Facture frame = new Facture();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private JPanel contentPane;
	private CommandeTab tab;
	JFormattedTextField formattedTextField_cin,formattedTextField_code,formattedTextField_prix,formattedTextField_qte,formattedTextField_recherch;
	JButton ajouter,btnModifier,btnSupprimer,btnRechercherPar,btnEnregistrer;
	JTable jtb;
	JComboBox comboBox;
	/**
	 * Create the frame.
	 */
	public Facture() {
		
		NumberFormat cdformat=NumberFormat.getNumberInstance();
		NumberFormat prxformat=NumberFormat.getNumberInstance();
		NumberFormat qteformat=NumberFormat.getNumberInstance();
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setLayout(null);
		
		cdformat.setMinimumIntegerDigits(4);
		cdformat.setMaximumIntegerDigits(4);
		cdformat.setMaximumFractionDigits(0);
		cdformat.setMaximumFractionDigits(0);
		
		prxformat.setMinimumIntegerDigits(1);
		prxformat.setMaximumIntegerDigits(6);
		prxformat.setMaximumFractionDigits(3);
		prxformat.setMaximumFractionDigits(0);
		
		qteformat.setMinimumIntegerDigits(1);
		qteformat.setMaximumIntegerDigits(2);
		qteformat.setMaximumFractionDigits(0);
		qteformat.setMaximumFractionDigits(0);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(65, 105, 225));
		panel.setBounds(0, 0, 1284, 108);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Achat et Commande");
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
		btnNewButton_1.setToolTipText("Retour vers Menu");
		Image iret1=new ImageIcon(this.getClass().getResource("return.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(iret1));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu m=new Menu();
				m.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBackground(new Color(65, 105, 225));
		btnNewButton_1.setBounds(0, 0, 25, 108);
		panel.add(btnNewButton_1);
		
		JLabel label = new JLabel("");
		Image i9=new ImageIcon(this.getClass().getResource("order.png")).getImage();
		label.setIcon(new ImageIcon(i9));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(498, 20, 102, 63);
		panel.add(label);
		
		ajouter = new JButton("Ajouter");
		Image i10=new ImageIcon(this.getClass().getResource("ajouter.png")).getImage();
		ajouter.setIcon(new ImageIcon(i10));
		ajouter.setFont(new Font("Arial", Font.BOLD, 12));
		ajouter.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255)));
		ajouter.setAlignmentX(Component.CENTER_ALIGNMENT);
		ajouter.setBackground(new Color(65, 105, 225));
		ajouter.setForeground(new Color(255, 255, 255));
		ajouter.setToolTipText("Ajouter un nouveau produit \u00E0 la table");
		ajouter.setBounds(29, 131, 127, 36);
		getContentPane().add(ajouter);
		ajouter.addActionListener(this);
		
		btnModifier = new JButton("Modifier\r\n");
		Image i11=new ImageIcon(this.getClass().getResource("modifier.png")).getImage();
		btnModifier.setToolTipText("Modifier un produit de la table");
		btnModifier.setIcon(new ImageIcon(i11));
		btnModifier.setFont(new Font("Arial", Font.BOLD, 12));
		btnModifier.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255)));
		btnModifier.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnModifier.setBackground(new Color(65, 105, 225));
		btnModifier.setForeground(new Color(255, 255, 255));
		btnModifier.setBounds(166, 131, 127, 36);
		getContentPane().add(btnModifier);
		btnModifier.addActionListener(this);
		
		btnSupprimer = new JButton("Supprimer\r\n");
		Image i12=new ImageIcon(this.getClass().getResource("delete.png")).getImage();
		btnSupprimer.setToolTipText("Supprimer un produit de la table");
		btnSupprimer.addActionListener(this);
		btnSupprimer.setIcon(new ImageIcon(i12));
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
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Infos sur la facture", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		panel_2.setBounds(29, 189, 401, 461);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblId = new JLabel("Commande :");
		lblId.setFont(new Font("Arial", Font.BOLD, 12));
		lblId.setBounds(10, 39, 106, 21);
		panel_2.add(lblId);
		
		
		JLabel lblCode = new JLabel("CIN du client :");
		lblCode.setFont(new Font("Arial", Font.BOLD, 12));
		lblCode.setBounds(10, 87, 106, 21);
		panel_2.add(lblCode);
		
		JLabel lblNomProduit = new JLabel("Code de produit:");
		lblNomProduit.setFont(new Font("Arial", Font.BOLD, 12));
		lblNomProduit.setBounds(10, 147, 106, 21);
		panel_2.add(lblNomProduit);
		
		comboBox = new JComboBox();
		for(int i=1;i<=20;i++) {
			comboBox.addItem((Integer)i);
		}
		comboBox.setEditable(true);
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(123, 35, 64, 31);
		panel_2.add(comboBox);

		
		formattedTextField_prix = new JFormattedTextField(prxformat);
		formattedTextField_prix.setBounds(123, 187, 233, 31);
		panel_2.add(formattedTextField_prix);
		
		formattedTextField_qte = new JFormattedTextField(qteformat);
		formattedTextField_qte.setBounds(123, 237, 233, 31);
		panel_2.add(formattedTextField_qte);
		
		btnEnregistrer = new JButton("Enregistrer");
		Image i14=new ImageIcon(this.getClass().getResource("register.png")).getImage();
		btnEnregistrer.setIcon(new ImageIcon(i14));
		btnEnregistrer.setForeground(Color.WHITE);
		btnEnregistrer.setFont(new Font("Arial", Font.BOLD, 12));
		btnEnregistrer.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255)));
		btnEnregistrer.setBackground(new Color(65, 105, 225));
		btnEnregistrer.setAlignmentX(0.5f);
		btnEnregistrer.setBounds(228, 312, 127, 36);
		panel_2.add(btnEnregistrer);
		btnEnregistrer.addActionListener(this);

		
		JLabel lblDescription = new JLabel("Prix :");
		lblDescription.setFont(new Font("Arial", Font.BOLD, 12));
		lblDescription.setBounds(20, 191, 106, 21);
		panel_2.add(lblDescription);
		
		JLabel lblPrix = new JLabel("Quantite :");
		lblPrix.setFont(new Font("Arial", Font.BOLD, 12));
		lblPrix.setBounds(20, 241, 106, 21);
		panel_2.add(lblPrix);
		
		formattedTextField_code = new JFormattedTextField(cdformat);
		formattedTextField_code.setBounds(123, 143, 233, 31);
		panel_2.add(formattedTextField_code);
		
		formattedTextField_cin = new JFormattedTextField();
		formattedTextField_cin.setBounds(123, 83, 233, 31);
		panel_2.add(formattedTextField_cin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tableau des commandes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		panel_1.setBounds(468, 178, 789, 472);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		tab=new CommandeTab();
		jtb=new JTable(tab);
		JScrollPane scrollPane = new JScrollPane(jtb);
		scrollPane.setBounds(28, 67, 733, 372);
		panel_1.add(scrollPane);
		
		btnRechercherPar = new JButton("Rechercher par :");
		Image i13=new ImageIcon(this.getClass().getResource("search.png")).getImage();
		btnRechercherPar.setIcon(new ImageIcon(i13));
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
		
		formattedTextField_recherch = new JFormattedTextField(qteformat);
		formattedTextField_recherch.setBounds(879, 135, 233, 31);
		getContentPane().add(formattedTextField_recherch);
		
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 487);
		setSize(1300,700);
	
	}
	@Override
	public void actionPerformed(ActionEvent arg) {
		if(arg.getSource()==btnSupprimer) {
			int row =jtb.getSelectedRow();
			int num=(int) tab.getValueAt(row,0);
			tab.removeRow(row);
			try {
				st.executeUpdate("DELETE FROM commande WHERE id="+num+"");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(arg.getSource()==ajouter) {
			int num=(int)comboBox.getSelectedItem();
			String cin=formattedTextField_cin.getText();
			int code=((Number)formattedTextField_code.getValue()).intValue();
			double prix=((Number)formattedTextField_prix.getValue()).doubleValue();
			int qte=((Number)formattedTextField_qte.getValue()).intValue();
			tab.addRow(num,tab.getRowCount(),0);
			tab.addRow(cin,tab.getRowCount(),1);
			tab.addRow(code,tab.getRowCount(),2);
			tab.addRow(prix,tab.getRowCount(),3);
			tab.addRow(qte,tab.getRowCount(),4);
			try {
				st.executeUpdate("INSERT INTO commande VALUES("+num+",'"+cin+"',"+code+","+prix+","+qte+")");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			formattedTextField_cin.setText("");
			formattedTextField_code.setText("");
			formattedTextField_prix.setText("");
			formattedTextField_qte.setText("");
		}
		if(arg.getSource()==btnModifier) {
			comboBox.setSelectedItem((int)tab.getValueAt(jtb.getSelectedRow(),0));
			formattedTextField_cin.setText((String)tab.getValueAt(jtb.getSelectedRow(),1));
			formattedTextField_code.setValue(tab.getValueAt(jtb.getSelectedRow(),2));
			formattedTextField_prix.setValue(tab.getValueAt(jtb.getSelectedRow(),3));
			formattedTextField_qte.setValue(tab.getValueAt(jtb.getSelectedRow(),4));
		}
		if(arg.getSource()==btnEnregistrer) {
			int num=(int)comboBox.getSelectedItem();
			String cin=formattedTextField_cin.getText();
			int code=((Number)formattedTextField_code.getValue()).intValue();
			double prix=((Number)formattedTextField_prix.getValue()).doubleValue();
			int qte=((Number)formattedTextField_qte.getValue()).intValue();
			tab.addRow(num,jtb.getSelectedRow(),0);
			tab.addRow(cin,jtb.getSelectedRow(),1);
			tab.addRow(code,jtb.getSelectedRow(),2);
			tab.addRow(prix,jtb.getSelectedRow(),3);
			tab.addRow(qte,jtb.getSelectedRow(),4);
			try {
				st.executeUpdate("UPDATE commande SET ID ="+num+",cin_client='"+cin+"',code_produit="+code+",prix_t="+prix+",quantite="+qte+" WHERE ID="+num);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(arg.getSource()==btnRechercherPar) {
			int num=((Number)formattedTextField_recherch.getValue()).intValue();
			String str=num+"";
			if(num>0 &&!str.equals("")) {
				for(int i=0;i<tab.getRowCount();i++)
					if(tab.getValueAt(i,0).equals(num)) {
						comboBox.setSelectedItem((int)tab.getValueAt(i,0));
						formattedTextField_cin.setValue(tab.getValueAt(i,1));
						formattedTextField_code.setValue(tab.getValueAt(i,2));
						formattedTextField_prix.setValue(tab.getValueAt(i,3));
						formattedTextField_qte.setValue(tab.getValueAt(i,4));
					}
			}
		}
	}
}
