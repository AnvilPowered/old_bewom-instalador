package es.bewom;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
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
	public static JCheckBox chckbxPixelmon = new JCheckBox("Pixelmon (Versi\u00F3n 4.0.8)");
	public static JFormattedTextField frmtdtxtfldSda = new JFormattedTextField();
	public static JButton btnNewButton = new JButton("Instalar");
	@SuppressWarnings("rawtypes")
	public static JComboBox comboBox = new JComboBox();
	public static JTextField txtg = new JTextField();
	
	public static String version = "1.1.0";
	
	public static String SO = System.getProperty("os.name").toLowerCase();
	
	public static JCheckBox showLauncher = new JCheckBox("Mantener el launcher de minecraft abierto");
	public static JTextField resWidth;
	public static JTextField resHeight;
	
	public static JLabel lblMbDeRam = new JLabel("RAM m\u00E1xima");
	public static JLabel lblResolucionInicial = new JLabel("Resolucion de la ventana de minecraft");
	
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
	@SuppressWarnings("unchecked")
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
		
		frmInstaladorBewom.setBounds(width/2 - w/2, height/2 - h/2, 610, 280);
		frmInstaladorBewom.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInstaladorBewom.getContentPane().setLayout(null);
		chckbxPixelmon.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxPixelmon.setBounds(6, 104, 306, 23);
		chckbxPixelmon.setForeground(new Color(51, 51, 51));
		chckbxPixelmon.setBackground(new Color(255, 255, 255));
		
		chckbxPixelmon.setSelected(true);
		frmInstaladorBewom.getContentPane().add(chckbxPixelmon);
		progressBar.setBounds(-4, 64, 612, 4);
				
		progressBar.setBackground(new Color(0, 0, 0));
		frmInstaladorBewom.getContentPane().add(progressBar);
		progressBar.setValue(0);
		progressBar.setForeground(new Color(207, 50, 50));
		progressBar.setBackground(new Color(51, 51, 51));
		progressBar.setBorder(BorderFactory.createEmptyBorder());
		
		JLabel lblVa = new JLabel(version);
		lblVa.setBounds(470, 191, 128, 23);
		lblVa.setForeground(new Color(51, 51, 51));
		lblVa.setHorizontalAlignment(SwingConstants.CENTER);
		frmInstaladorBewom.getContentPane().add(lblVa);
		btnNewButton.setBounds(470, 220, 128, 24);
		btnNewButton.setForeground(new Color(51, 51, 51));
		frmInstaladorBewom.getContentPane().add(btnNewButton);
		frmtdtxtfldSda.setBounds(6, 220, 461, 24);
		frmtdtxtfldSda.setBackground(Color.WHITE);
		frmtdtxtfldSda.setText(System.getenv("APPDATA") + "\\.minecraft");
		if(SO.contains("mac")){
			frmtdtxtfldSda.setText(System.getProperty("user.home") + "/Library/Application Support/minecraft");
		} else if(SO.contains("nux")){
			frmtdtxtfldSda.setText("~/.minecraft/");
		}
		frmInstaladorBewom.getContentPane().add(frmtdtxtfldSda);
				
		JLabel panel = new JLabel();
		panel.setBounds(0, 0, 604, 64);
		panel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.setIcon(new ImageIcon(BewomPack.class.getResource("/es/bewom/assets/logo_simple.png")));
		frmInstaladorBewom.getContentPane().add(panel);
		lblDescargandoPixelmon.setBounds(6, 83, 588, 14);
		
		lblDescargandoPixelmon.setForeground(new Color(51, 51, 51));
		
		lblDescargandoPixelmon.setHorizontalAlignment(SwingConstants.CENTER);
				frmInstaladorBewom.getContentPane().add(lblDescargandoPixelmon);
		txtg.setBounds(6, 190, 60, 24);
		
		txtg.setText("1024");
		frmInstaladorBewom.getContentPane().add(txtg);
		txtg.setColumns(10);
		
		lblMbDeRam.setBounds(137, 191, 162, 22);
		lblMbDeRam.setForeground(new Color(51, 51, 51));
		frmInstaladorBewom.getContentPane().add(lblMbDeRam);
		comboBox.setBounds(72, 190, 60, 24);
		comboBox.setBackground(Color.WHITE);
		
		comboBox.setMaximumRowCount(2);
		comboBox.addItem("Mb");
		comboBox.addItem("Gb");
		frmInstaladorBewom.getContentPane().add(comboBox);
		
		resWidth = new JTextField();
		resWidth.setBounds(6, 160, 60, 24);
		resWidth.setText("1280");
		resWidth.setColumns(10);
		frmInstaladorBewom.getContentPane().add(resWidth);
		
		resHeight = new JTextField();
		resHeight.setBounds(72, 160, 60, 24);
		resHeight.setText("720");
		resHeight.setColumns(10);
		frmInstaladorBewom.getContentPane().add(resHeight);
		
		lblResolucionInicial.setBounds(137, 161, 321, 22);
		lblResolucionInicial.setForeground(new Color(51, 51, 51));
		frmInstaladorBewom.getContentPane().add(lblResolucionInicial);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 604, 64);
		panel_1.setBackground(new Color(255, 215, 0));
		frmInstaladorBewom.getContentPane().add(panel_1);
		showLauncher.setBounds(6, 130, 490, 23);
		
		showLauncher.setSelected(true);
		showLauncher.setForeground(new Color(51, 51, 51));
		showLauncher.setBackground(new Color(255, 255, 255));
		frmInstaladorBewom.getContentPane().add(showLauncher);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(btnNewButton.getModel().isArmed()){
					
					comboBox.setEnabled(false);
					txtg.setEnabled(false);
					chckbxPixelmon.setEnabled(false);
					frmtdtxtfldSda.setEnabled(false);
					btnNewButton.setEnabled(false);
					showLauncher.setEnabled(false);
					resWidth.setEnabled(false);
					resHeight.setEnabled(false);
					lblResolucionInicial.setEnabled(false);
					lblMbDeRam.setEnabled(false);
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
