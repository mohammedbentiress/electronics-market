import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setForeground(new Color(255, 255, 255));
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JButton btnStockDeProduits = new JButton("Stock de produits");
		btnStockDeProduits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Stock s=new Stock();
				s.setVisible(true);
			    setVisible(false);
				
			}
		});
		btnStockDeProduits.setHorizontalTextPosition(SwingConstants.CENTER);
		Image istock=new ImageIcon(this.getClass().getResource("stock.png")).getImage();
		btnStockDeProduits.setIcon(new ImageIcon(istock));
		btnStockDeProduits.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnStockDeProduits.setVerticalAlignment(SwingConstants.BOTTOM);
		btnStockDeProduits.setForeground(Color.WHITE);
		btnStockDeProduits.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		btnStockDeProduits.setBorder(new CompoundBorder());
		btnStockDeProduits.setBackground(new Color(65, 105, 225));
		btnStockDeProduits.setBounds(140, 106, 342, 149);
		getContentPane().add(btnStockDeProduits);
		
		JButton btnAchatEtCommande = new JButton("Achat et Commande");
		Image iorder=new ImageIcon(this.getClass().getResource("order.png")).getImage();
		btnAchatEtCommande.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAchatEtCommande.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAchatEtCommande.setIcon(new ImageIcon(iorder));
		btnAchatEtCommande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Facture ff=new Facture();
				ff.setVisible(true);
				setVisible(false);
			}
		});
		btnAchatEtCommande.setVerticalAlignment(SwingConstants.BOTTOM);
		btnAchatEtCommande.setForeground(Color.WHITE);
		btnAchatEtCommande.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		btnAchatEtCommande.setBorder(new CompoundBorder());
		btnAchatEtCommande.setBackground(new Color(65, 105, 225));
		btnAchatEtCommande.setBounds(492, 106, 350, 149);
		getContentPane().add(btnAchatEtCommande);
		
		JButton btnClientsfournisseurs = new JButton("Clients/Fournisseurs");
		Image icl=new ImageIcon(this.getClass().getResource("customer.png")).getImage();
		btnClientsfournisseurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Client_Fournisseur c=new Client_Fournisseur();
				c.setVisible(true);
				setVisible(false);
			}
		});
		btnClientsfournisseurs.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnClientsfournisseurs.setIcon(new ImageIcon(icl));
		btnClientsfournisseurs.setHorizontalTextPosition(SwingConstants.CENTER);
		btnClientsfournisseurs.setVerticalAlignment(SwingConstants.BOTTOM);
		btnClientsfournisseurs.setForeground(Color.WHITE);
		btnClientsfournisseurs.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		btnClientsfournisseurs.setBorder(new CompoundBorder());
		btnClientsfournisseurs.setBackground(new Color(65, 105, 225));
		btnClientsfournisseurs.setBounds(434, 266, 408, 149);
		getContentPane().add(btnClientsfournisseurs);
		
		JButton btnUtilisateurs = new JButton("Utilisateurs/Caissiers");
		Image iuser=new ImageIcon(this.getClass().getResource("cashier.png")).getImage();
		btnUtilisateurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Users u=new Users();
				u.setVisible(true);
				setVisible(false);
				
			}
		});
		btnUtilisateurs.setHorizontalTextPosition(SwingConstants.CENTER);
		btnUtilisateurs.setIcon(new ImageIcon(iuser));
		btnUtilisateurs.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnUtilisateurs.setVerticalAlignment(SwingConstants.BOTTOM);
		btnUtilisateurs.setForeground(Color.WHITE);
		btnUtilisateurs.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		btnUtilisateurs.setBorder(new CompoundBorder());
		btnUtilisateurs.setBackground(new Color(65, 105, 225));
		btnUtilisateurs.setBounds(140, 426, 389, 111);
		getContentPane().add(btnUtilisateurs);
		
		JButton btnDconexion = new JButton("D\u00E9conexion ");
		Image iexit=new ImageIcon(this.getClass().getResource("logout.png")).getImage();
		btnDconexion.setBorder(new CompoundBorder());
		btnDconexion.setIcon(new ImageIcon(iexit));
		btnDconexion.setBackground(new Color(65, 105, 225));
		btnDconexion.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnDconexion.setVerticalAlignment(SwingConstants.BOTTOM);
		btnDconexion.setForeground(new Color(255, 255, 255));
		btnDconexion.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		btnDconexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l=new Login("Gestion de Vente et Achat d'un magasin d'équipements éléctroniques");
				l.setVisible(true);
				setVisible(false);
			}
		});
		btnDconexion.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDconexion.setBounds(539, 426, 303, 111);
		getContentPane().add(btnDconexion);
		
		JButton btnFacturation = new JButton("Facturation");
		Image ifact=new ImageIcon(this.getClass().getResource("Facture.png")).getImage();
		btnFacturation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Facturation f=new Facturation();
				f.setVisible(true);
				setVisible(false);
			}
		});
		btnFacturation.setIcon(new ImageIcon(ifact));
		btnFacturation.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnFacturation.setVerticalAlignment(SwingConstants.BOTTOM);
		btnFacturation.setHorizontalTextPosition(SwingConstants.CENTER);
		btnFacturation.setForeground(Color.WHITE);
		btnFacturation.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		btnFacturation.setBorder(new CompoundBorder());
		btnFacturation.setBackground(new Color(65, 105, 225));
		btnFacturation.setBounds(140, 266, 284, 150);
		getContentPane().add(btnFacturation);
		
		JLabel lblMenu = new JLabel("MENU");
		lblMenu.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(65, 105, 225), new Color(248, 248, 255), new Color(65, 105, 225), new Color(248, 248, 255)));
		lblMenu.setFont(new Font("Yu Gothic UI", Font.BOLD, 33));
		lblMenu.setForeground(new Color(65, 105, 225));
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setBounds(254, 11, 457, 68);
		getContentPane().add(lblMenu);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setVisible(true);
		setSize(999,600);
		}
}
