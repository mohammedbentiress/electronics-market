import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Facturation extends JFrame implements ActionListener,MouseListener{

	private JPanel contentPane;
	private Ligne_commandeTab tab;
	private JTable jtb;
	private JTextField textField_facture;
	private JTextField textField_cin;
	private JTextField textField_cds;
	private JTextField textField_prx;
	private JTextField textField_date;
	private JButton btnImprimer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Facturation frame = new Facturation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Facturation() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(65, 105, 225));
		panel.setBounds(0, 0, 1284, 108);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Facturation");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 28));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setLabelFor(lblNewLabel);
		lblNewLabel.setBounds(555, 32, 399, 51);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("");
		Image iret2=new ImageIcon(this.getClass().getResource("return.png")).getImage();
		btnNewButton_1.setToolTipText("Retour vers Menu");
		btnNewButton_1.setIcon(new ImageIcon(iret2));
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
		
		JLabel label = new JLabel("");
		Image i7=new ImageIcon(this.getClass().getResource("Facture.png")).getImage();
		label.setIcon(new ImageIcon(i7));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(576, 20, 102, 63);
		panel.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(0, 0, 255));
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Infos sur la facture", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		panel_2.setBounds(31, 130, 541, 520);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Num\u00E9ro de Facture:");
		lblNewLabel_1.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		lblNewLabel_1.setBounds(34, 61, 135, 37);
		panel_2.add(lblNewLabel_1);
		
		textField_facture = new JTextField();
		textField_facture.setBounds(179, 65, 218, 29);
		panel_2.add(textField_facture);
		textField_facture.setColumns(10);
		
		JLabel lblCinDeClient = new JLabel("CIN de Client:");
		lblCinDeClient.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		lblCinDeClient.setBounds(34, 134, 135, 37);
		panel_2.add(lblCinDeClient);
		
		textField_cin = new JTextField();
		textField_cin.setColumns(10);
		textField_cin.setBounds(179, 142, 218, 29);
		panel_2.add(textField_cin);
		
		JLabel lblCommandes = new JLabel("Commandes");
		lblCommandes.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		lblCommandes.setBounds(34, 211, 135, 37);
		panel_2.add(lblCommandes);
		
		textField_cds = new JTextField();
		textField_cds.setColumns(10);
		textField_cds.setBounds(179, 219, 218, 29);
		panel_2.add(textField_cds);
		
		JLabel lblPrixTotale = new JLabel("Prix totale:");
		lblPrixTotale.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		lblPrixTotale.setBounds(34, 298, 135, 37);
		panel_2.add(lblPrixTotale);
		
		textField_prx = new JTextField();
		textField_prx.setColumns(10);
		textField_prx.setBounds(179, 306, 218, 29);
		panel_2.add(textField_prx);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		lblDate.setBounds(34, 381, 135, 37);
		panel_2.add(lblDate);
		
		textField_date = new JTextField();
		textField_date.setColumns(10);
		textField_date.setBounds(179, 389, 218, 29);
		panel_2.add(textField_date);
		
		btnImprimer = new JButton("Imprimer");
		Image i8=new ImageIcon(this.getClass().getResource("printer.png")).getImage();
		btnImprimer.setIcon(new ImageIcon(i8));
		btnImprimer.setForeground(Color.WHITE);
		btnImprimer.setFont(new Font("Arial", Font.BOLD, 13));
		btnImprimer.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255)));
		btnImprimer.setBackground(new Color(65, 105, 225));
		btnImprimer.setBounds(276, 451, 121, 36);
		panel_2.add(btnImprimer);
		
		btnImprimer.addActionListener(this);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tableau des commandes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		panel_1.setBounds(593, 189, 653, 296);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		tab= new Ligne_commandeTab();
		jtb= new JTable(tab);
		
		jtb.addMouseListener(this);
		
		JScrollPane scrollPane = new JScrollPane(jtb);
		scrollPane.setBounds(10, 64, 632, 199);
		panel_1.add(scrollPane);
		
		
		
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 487);
		setSize(1300,700);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnImprimer) {
			String str="";
			str+="Facture:\t"+textField_facture.getText()+"\n";
			str+="Client:\t"+textField_cin.getText()+"\n";
			str+="Nméro de commande:"+textField_cds.getText()+"\n";
			str+="Prix TTC:\t"+textField_prx.getText()+"\n";
			str+="Date:\t"+textField_date.getText();
			JOptionPane.showMessageDialog(null,str);
		}
	}

	

	@Override
	public void mouseClicked(MouseEvent arg) {
		// TODO Auto-generated method stub
		if(arg.getSource()==jtb) {
			textField_facture.setText(""+tab.getValueAt(jtb.getSelectedRow(),0));
			textField_cin.setText((String)tab.getValueAt(jtb.getSelectedRow(),1));
			textField_cds.setText(""+tab.getValueAt(jtb.getSelectedRow(),2));
			textField_prx.setText(""+tab.getValueAt(jtb.getSelectedRow(),3));
			textField_date.setText(""+tab.getValueAt(jtb.getSelectedRow(),4));
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}