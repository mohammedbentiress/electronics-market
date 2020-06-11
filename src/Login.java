import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.CompoundBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomDutilisateur;
	private JPasswordField pwdMotDePasse;
	JLabel lblNomDutilisateur,lblMotDePasse;

	public Login(String name) {
		super(name);
		setForeground(new Color(255, 255, 255));
		getContentPane().setBackground(new Color(245, 245, 245));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(65, 105, 225));
		panel.setBounds(0, 0, 418, 561);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		Image iall=new ImageIcon(this.getClass().getResource("all.png")).getImage();
		label_1.setIcon(new ImageIcon(iall));
		label_1.setBounds(10, 11, 398, 355);
		panel.add(label_1);
		
		JLabel lblMagasinDquipementlectroniques = new JLabel("magasin d'\u00E9quipement \u00E9lectroniques");
		lblMagasinDquipementlectroniques.setVerticalAlignment(SwingConstants.BOTTOM);
		lblMagasinDquipementlectroniques.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblMagasinDquipementlectroniques.setForeground(new Color(255, 250, 250));
		lblMagasinDquipementlectroniques.setHorizontalAlignment(SwingConstants.CENTER);
		lblMagasinDquipementlectroniques.setBounds(41, 416, 338, 57);
		panel.add(lblMagasinDquipementlectroniques);
		
		JLabel lblOrdinateursEtMatriel = new JLabel("Ordinateurs et Mat\u00E9riel informatique, T\u00E9l\u00E9phones Portables..");
		lblOrdinateursEtMatriel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblOrdinateursEtMatriel.setFont(new Font("Yu Gothic", Font.PLAIN, 9));
		lblOrdinateursEtMatriel.setForeground(new Color(255, 215, 0));
		lblOrdinateursEtMatriel.setBounds(51, 470, 324, 30);
		panel.add(lblOrdinateursEtMatriel);
		
		JLabel lblGestionDeVente = new JLabel("Gestion de vente et achat d'un :");
		lblGestionDeVente.setVerticalAlignment(SwingConstants.BOTTOM);
		lblGestionDeVente.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionDeVente.setForeground(new Color(255, 250, 250));
		lblGestionDeVente.setFont(new Font("Yu Gothic Medium", Font.BOLD, 22));
		lblGestionDeVente.setBounds(20, 381, 376, 57);
		panel.add(lblGestionDeVente);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 245, 245));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "IDENTIFICATION", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(65, 105, 225)));
		panel_1.setBounds(500, 101, 410, 385);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		txtNomDutilisateur = new JTextField();
		txtNomDutilisateur.setBackground(new Color(245, 245, 245));
		txtNomDutilisateur.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(123, 104, 238)));
		txtNomDutilisateur.setBounds(61, 103, 296, 44);
		panel_1.add(txtNomDutilisateur);
		txtNomDutilisateur.setColumns(10);
		
		pwdMotDePasse = new JPasswordField();
		pwdMotDePasse.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(123, 104, 238)));
		pwdMotDePasse.setBackground(new Color(245, 245, 245));
		pwdMotDePasse.setBounds(61, 209, 296, 44);
		panel_1.add(pwdMotDePasse);
		
		lblNomDutilisateur = new JLabel("Nom d'utilisateur :");
		lblNomDutilisateur.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		lblNomDutilisateur.setForeground(new Color(105, 105, 105));
		lblNomDutilisateur.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNomDutilisateur.setBounds(61, 52, 121, 40);
		panel_1.add(lblNomDutilisateur);
		
		lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		lblMotDePasse.setForeground(new Color(105, 105, 105));
		lblMotDePasse.setVerticalAlignment(SwingConstants.BOTTOM);
		lblMotDePasse.setBounds(61, 158, 121, 40);
		panel_1.add(lblMotDePasse);
		
		JButton btnNewButton = new JButton("Se connecter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNomDutilisateur.getText().equals("admin") && pwdMotDePasse.getText().equals("admin")) {
					Menu m=new Menu();
					m.setVisible(true);
					setVisible(false);
				}
				else if(!(txtNomDutilisateur.getText().equals("admin") && pwdMotDePasse.getText().equals("admin"))) {
					JOptionPane.showMessageDialog(null, "Les champs entrés ne sont pas valides,Veuilez réssayer encore une fois");
					pwdMotDePasse.setText(""); txtNomDutilisateur.setText("");
				}
			}
		});
		btnNewButton.setBorder(new CompoundBorder());
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setBounds(61, 310, 296, 44);
		panel_1.add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		Image iconx=new ImageIcon(this.getClass().getResource("conx.png")).getImage();
		label.setIcon(new ImageIcon(iconx));
		label.setBounds(678, 58, 46, 43);
		getContentPane().add(label);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 487);
		this.setVisible(true);
		setSize(999,600);
		
	}

	public void actionPerformed(ActionEvent e) {
		Menu M=new Menu();
		M.setVisible(true);
		this.setEnabled(false);
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login("Gestion de Vente et Achat d'un magasin d'équipements éléctroniques");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
