package es.bewom;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JProgressBar;
import javax.swing.JFormattedTextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class BewomPack {

	private JFrame frmInstaladorBewom;
	
	public static  JLabel lblDescargandoPixelmon = new JLabel("Cierra el launcher de minecraft y el juego!");
	public static JProgressBar progressBar = new JProgressBar();
	
	public static JCheckBox chckbxOptifine = new JCheckBox("Optifine (No recomendado, puede causar problemas)");
	public static JCheckBox chckbxPixelmon = new JCheckBox("Pixelmon (Versión 4.0.7)");
	public static JFormattedTextField frmtdtxtfldSda = new JFormattedTextField();
	public static JButton btnNewButton = new JButton("Instalar");
	public static JComboBox comboBox = new JComboBox();
	public static JTextField txtg = new JTextField();
	
	public static String version = "1.0 PRE-RELEASE";
	
	public static String SO = System.getProperty("os.name").toLowerCase();
	
	public static JCheckBox showLauncher = new JCheckBox("Mantener el launcher abierto.");
	public static JTextField resWidth;
	public static JTextField resHeight;
	private final JPanel panel_2 = new JPanel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BewomPack window = new BewomPack();
					window.frmInstaladorBewom.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BewomPack() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmInstaladorBewom = new JFrame();
		frmInstaladorBewom.setAlwaysOnTop(true);
		frmInstaladorBewom.setResizable(false);
		frmInstaladorBewom.getContentPane().setBackground(new Color(255, 255, 255));
		frmInstaladorBewom.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("assets/logo_simple.png")));
		frmInstaladorBewom.setTitle("Instalador bewom");
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		
		int h = 256;
		int w = 512;
		
		frmInstaladorBewom.setBounds(width/2 - w/2, height/2 - h/2, 610, 353);
		frmInstaladorBewom.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInstaladorBewom.getContentPane().setLayout(null);
		chckbxPixelmon.setForeground(new Color(51, 51, 51));
		chckbxPixelmon.setBackground(new Color(255, 255, 255));
		
		chckbxPixelmon.setSelected(true);
		chckbxPixelmon.setBounds(6, 88, 306, 23);
		frmInstaladorBewom.getContentPane().add(chckbxPixelmon);
		
		JLabel lblVa = new JLabel(version);
		lblVa.setForeground(new Color(51, 51, 51));
		lblVa.setHorizontalAlignment(SwingConstants.CENTER);
		lblVa.setBounds(466, 206, 128, 23);
		frmInstaladorBewom.getContentPane().add(lblVa);
		btnNewButton.setForeground(new Color(51, 51, 51));
		
		btnNewButton.setBounds(466, 240, 128, 24);
		frmInstaladorBewom.getContentPane().add(btnNewButton);
		chckbxOptifine.setBackground(new Color(255, 255, 255));
		chckbxOptifine.setForeground(new Color(51, 51, 51));
		chckbxOptifine.setBounds(6, 114, 490, 23);
		frmInstaladorBewom.getContentPane().add(chckbxOptifine);
		progressBar.setStringPainted(true);
		
		progressBar.setBounds(0, 300, 604, 24);
		progressBar.setValue(0);
		progressBar.setForeground(new Color(207, 50, 50));
		frmInstaladorBewom.getContentPane().add(progressBar);
		frmtdtxtfldSda.setBackground(Color.WHITE);
		
		frmtdtxtfldSda.setBounds(6, 240, 450, 24);
		frmtdtxtfldSda.setText(System.getenv("APPDATA") + "\\.minecraft");
		if(SO.contains("mac")){
			frmtdtxtfldSda.setText(System.getProperty("user.home") + "/Library/Application Support/minecraft");
		} else if(SO.contains("nux")){
			frmtdtxtfldSda.setText("~/.minecraft/");
		}
		frmInstaladorBewom.getContentPane().add(frmtdtxtfldSda);
				
		JLabel panel = new JLabel();
		panel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.setBounds(0, 0, 604, 64);
		panel.setIcon(new ImageIcon(BewomPack.class.getResource("/es/bewom/assets/logo_simple.png")));
		frmInstaladorBewom.getContentPane().add(panel);
		
		lblDescargandoPixelmon.setForeground(new Color(51, 51, 51));
		
		lblDescargandoPixelmon.setHorizontalAlignment(SwingConstants.CENTER);
//		lblDescargandoPixelmon.setEnabled(false);
		lblDescargandoPixelmon.setBounds(6, 275, 588, 14);
		frmInstaladorBewom.getContentPane().add(lblDescargandoPixelmon);
		
		txtg.setText("1536");
		txtg.setBounds(6, 205, 60, 24);
		frmInstaladorBewom.getContentPane().add(txtg);
		txtg.setColumns(10);
		
		JLabel lblMbDeRam = new JLabel("RAM m\u00E1xima");
		lblMbDeRam.setForeground(new Color(51, 51, 51));
		lblMbDeRam.setBounds(146, 206, 162, 22);
		frmInstaladorBewom.getContentPane().add(lblMbDeRam);
		comboBox.setBackground(Color.WHITE);
		
		comboBox.setMaximumRowCount(2);
		comboBox.setBounds(76, 205, 60, 24);
		comboBox.addItem("Mb");
		comboBox.addItem("Gb");
		frmInstaladorBewom.getContentPane().add(comboBox);
		
		resWidth = new JTextField();
		resWidth.setText("1600");
		resWidth.setColumns(10);
		resWidth.setBounds(6, 170, 60, 24);
		frmInstaladorBewom.getContentPane().add(resWidth);
		
		resHeight = new JTextField();
		resHeight.setText("900");
		resHeight.setColumns(10);
		resHeight.setBounds(76, 170, 60, 24);
		frmInstaladorBewom.getContentPane().add(resHeight);
		
		JLabel lblResolucionInicial = new JLabel("Resolucion de la ventana");
		lblResolucionInicial.setForeground(new Color(51, 51, 51));
		lblResolucionInicial.setBounds(146, 170, 162, 22);
		frmInstaladorBewom.getContentPane().add(lblResolucionInicial);
		
		showLauncher.setSelected(true);
		showLauncher.setForeground(new Color(51, 51, 51));
		showLauncher.setBackground(new Color(255, 255, 255));
		showLauncher.setBounds(6, 140, 490, 23);
		frmInstaladorBewom.getContentPane().add(showLauncher);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(38, 114, 179));
		panel_1.setBounds(0, 0, 604, 64);
		frmInstaladorBewom.getContentPane().add(panel_1);
		panel_2.setBackground(new Color(51, 51, 51));
		panel_2.setBounds(0, 61, 604, 8);
		
		frmInstaladorBewom.getContentPane().add(panel_2);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(btnNewButton.getModel().isArmed()){
					
					comboBox.setEnabled(false);
					txtg.setEnabled(false);
					chckbxPixelmon.setEnabled(false);
					chckbxOptifine.setEnabled(false);
					frmtdtxtfldSda.setEnabled(false);
					btnNewButton.setEnabled(false);
					showLauncher.setEnabled(false);
					resWidth.setEnabled(false);
					resHeight.setEnabled(false);
					lblDescargandoPixelmon.setText("Empezando la instalación...");
					progressBar.setIndeterminate(true);
					
					try {
						Downloads.download(frmtdtxtfldSda.getText());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				
			}
		});
		
		
		
	}
}
