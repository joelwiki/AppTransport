

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class transportFra extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -221774984266295261L;
	private static JFrame frame;
	private int heures ;
	private int minutes ;
	protected static JLabel lblMaupertuis;
	protected static JLabel lblJeanMace;
	
	protected static JLabel lblLGM;
	protected static JLabel lblPremol;

	protected Calendar cal =  Calendar.getInstance();
	
	static JLabel lblHeures;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				try 
				{
					//Lancement en thread de la fenetre
					Runnable runnable1 = new transportFra();
					Thread t = new Thread(runnable1);
					t.start();
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 480, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		ImageIcon icon = new ImageIcon("c1.jpg");

		JLabel lblProchainPassage = new JLabel("Prochains passages : ");
		lblProchainPassage.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		lblProchainPassage.setBounds(177, 0, 199, 25);
		frame.getContentPane().add(lblProchainPassage);

		JLabel lblArrtAiguinardshexagone = new JLabel("Arr\u00EAt Aiguinards-Hexagone :");
		lblArrtAiguinardshexagone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblArrtAiguinardshexagone.setBounds(133, 22, 243, 28);
		frame.getContentPane().add(lblArrtAiguinardshexagone);

		JLabel lblMeylanmaupertuis = new JLabel("Meylan-Maupertuis");
		lblMeylanmaupertuis.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 13));
		lblMeylanmaupertuis.setForeground(Color.RED);
		lblMeylanmaupertuis.setBounds(97, 61, 136, 14);
		frame.getContentPane().add(lblMeylanmaupertuis);

		JLabel lblGrenobleCitJean = new JLabel("Grenoble Cit\u00E9 Jean Mac\u00E9");
		lblGrenobleCitJean.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 13));
		lblGrenobleCitJean.setForeground(Color.BLUE);
		lblGrenobleCitJean.setBounds(267, 61, 167, 14);
		frame.getContentPane().add(lblGrenobleCitJean);

		JLabel lblMeylanLyceDu = new JLabel("Meylan Lyc\u00E9e du Gr\u00E9sivaudan");
		lblMeylanLyceDu.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 13));
		lblMeylanLyceDu.setForeground(Color.RED);
		lblMeylanLyceDu.setBounds(83, 144, 174, 14);
		frame.getContentPane().add(lblMeylanLyceDu);

		JLabel lblPoisatPrmol = new JLabel("Poisat Pr\u00E9mol");
		lblPoisatPrmol.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 13));
		lblPoisatPrmol.setForeground(Color.BLUE);
		lblPoisatPrmol.setBounds(267, 144, 97, 14);
		frame.getContentPane().add(lblPoisatPrmol);

		JLabel lblC1 = new JLabel("");
		File fichierC1= new File("C:/Users/joel/workspace/Transport_V0.02/images/c1.jpg");
		Image imgc1 = new ImageIcon(""+fichierC1).getImage();
		lblC1.setIcon(new ImageIcon(imgc1));
		lblC1.setBounds(10, 60, 59, 63);
		frame.getContentPane().add(lblC1);

		JLabel lblLigne13 = new JLabel("");
		Image l13 = new ImageIcon("C:/Users/joel/workspace/Transport_V0.02/images/l13.jpg").getImage();
		lblLigne13.setIcon(new ImageIcon(l13));
		lblLigne13.setBounds(10, 144, 59, 55);
		frame.getContentPane().add(lblLigne13);

		lblMaupertuis = new JLabel("Aucun Passage dans l'imm\u00E9diat");
		lblMaupertuis.setBounds(83, 86, 186, 14);
		frame.getContentPane().add(lblMaupertuis);

		lblJeanMace = new JLabel("Aucun Passage dans l'imm\u00E9diat");
		lblJeanMace.setBounds(267, 86, 199, 14);
		frame.getContentPane().add(lblJeanMace);

		lblLGM = new JLabel("Aucun Passage dans l'imm\u00E9diat");
		lblLGM.setBounds(77, 169, 211, 14);
		frame.getContentPane().add(lblLGM);

		lblPremol = new JLabel("Aucun Passage dans l'imm\u00E9diat");
		lblPremol.setBounds(267, 169, 199, 14);
		frame.getContentPane().add(lblPremol);



		JLabel lblLigne42 = new JLabel("");
		Image l42 = new ImageIcon("C:/Users/joel/workspace/Transport_V0.02/images/l42.jpg").getImage();
		lblLigne42.setIcon(new ImageIcon(l42));
		lblLigne42.setBounds(20, 210, 69, 60);
		frame.getContentPane().add(lblLigne42);

		JLabel lblArrtPlaceDe = new JLabel("Arr\u00EAt Place de la Louisane :");
		lblArrtPlaceDe.setBounds(158, 201, 239, 14);
		frame.getContentPane().add(lblArrtPlaceDe);

		JLabel lblMeylanLaDtourbe = new JLabel("Meylan La D\u00E9tourbe");
		lblMeylanLaDtourbe.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 13));
		lblMeylanLaDtourbe.setForeground(Color.RED);
		lblMeylanLaDtourbe.setBounds(83, 218, 150, 14);
		frame.getContentPane().add(lblMeylanLaDtourbe);

		JLabel lblLaTroncheGrand = new JLabel("La Tronche Grand Sablon");
		lblLaTroncheGrand.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 13));
		lblLaTroncheGrand.setForeground(Color.BLUE);
		lblLaTroncheGrand.setBounds(267, 218, 167, 14);
		frame.getContentPane().add(lblLaTroncheGrand);




		JLabel label = new JLabel("");
		label.setBounds(33, 11, 46, 14);
		frame.getContentPane().add(label);

		lblHeures = new JLabel("Il est : ");
		lblHeures.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		lblHeures.setBounds(10, 11, 132, 14);
		frame.getContentPane().add(lblHeures);
	}

	@Override
	public void run() 
	{
		this.initialize();
		this.frame.setVisible(true);
		//Lancement en thread des horaires du c1
		Runnable transportC1MAJ = new horairesC1(lblMaupertuis,lblJeanMace, frame);
		Thread thread2 =new Thread(transportC1MAJ);
		thread2.start();
		frame.repaint();
		
		Runnable transportLigne13Maj = new horairesL13(lblLGM,lblPremol,frame);
		Thread tL13 = new Thread(transportLigne13Maj);
		tL13.start();
		frame.repaint();
	
		Runnable heures =new majHeures(lblHeures,frame);
		Thread threadHeures = new Thread(heures);
		threadHeures.start();
		frame.repaint();

	}
}
