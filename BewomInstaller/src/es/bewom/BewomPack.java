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
	
	public static JLabel lblDescargandoPixelmon = new JLabel("Cierra el launcher de minecraft y el juego!");
	public static JProgressBar progressBar = new JProgressBar();
	public static JCheckBox chckbxPixelmon = new JCheckBox("Pixelmon (Versi\u00F3n 4.1.1)");
	public static JFormattedTextField frmtdtxtfldSda = new JFormattedTextField();
	public static JButton btnNewButton = new JButton("Instalar");
	@SuppressWarnings("rawtypes")
	public static JComboBox RAMType = new JComboBox();
	public static JTextField RAM = new JTextField();
	public static JCheckBox checkResolution = new JCheckBox("");
	public static JCheckBox checkRAM = new JCheckBox("");
	
	public static String version = "1.4.0";
	
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
		
		frmInstaladorBewom.setBounds(width/2 - w/2, height/2 - h/2, 540, 280);
		frmInstaladorBewom.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInstaladorBewom.getContentPane().setLayout(null);
		chckbxPixelmon.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxPixelmon.setBounds(6, 104, 450, 23);
		chckbxPixelmon.setForeground(new Color(51, 51, 51));
		chckbxPixelmon.setBackground(new Color(255, 255, 255));
		
		chckbxPixelmon.setSelected(true);
		frmInstaladorBewom.getContentPane().add(chckbxPixelmon);
		progressBar.setBounds(-4, 64, 540, 6);
				
		progressBar.setBackground(new Color(0, 0, 0));
		frmInstaladorBewom.getContentPane().add(progressBar);
		progressBar.setValue(0);
		progressBar.setForeground(new Color(207, 50, 50));
		progressBar.setBackground(new Color(51, 51, 51));
		progressBar.setBorder(BorderFactory.createEmptyBorder());
		
		JLabel lblVa = new JLabel(version);
		lblVa.setBounds(396, 191, 128, 23);
		lblVa.setForeground(new Color(51, 51, 51));
		lblVa.setHorizontalAlignment(SwingConstants.CENTER);
		frmInstaladorBewom.getContentPane().add(lblVa);
		btnNewButton.setBounds(396, 220, 128, 24);
		btnNewButton.setForeground(new Color(51, 51, 51));
		frmInstaladorBewom.getContentPane().add(btnNewButton);
		frmtdtxtfldSda.setBounds(6, 220, 380, 24);
		frmtdtxtfldSda.setBackground(Color.WHITE);
		frmtdtxtfldSda.setText(System.getenv("APPDATA") + "\\.minecraft");
		if(SO.contains("mac")){
			frmtdtxtfldSda.setText(System.getProperty("user.home") + "/Library/Application Support/minecraft");
		} else if(SO.contains("nux")){
			frmtdtxtfldSda.setText("~/.minecraft/");
		}
		frmInstaladorBewom.getContentPane().add(frmtdtxtfldSda);
				
		JLabel panel = new JLabel();
		panel.setBounds(0, 0, 534, 64);
		panel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.setIcon(new ImageIcon(BewomPack.class.getResource("/es/bewom/assets/logo_simple.png")));
		frmInstaladorBewom.getContentPane().add(panel);
		lblDescargandoPixelmon.setBounds(6, 83, 530, 14);
		
		lblDescargandoPixelmon.setForeground(new Color(51, 51, 51));
		
		lblDescargandoPixelmon.setHorizontalAlignment(SwingConstants.CENTER);
				frmInstaladorBewom.getContentPane().add(lblDescargandoPixelmon);
		RAM.setBounds(27, 190, 60, 24);
		
		RAM.setText("1536");
		frmInstaladorBewom.getContentPane().add(RAM);
		RAM.setColumns(10);
		
		lblMbDeRam.setBounds(167, 191, 142, 22);
		lblMbDeRam.setForeground(new Color(51, 51, 51));
		frmInstaladorBewom.getContentPane().add(lblMbDeRam);
		RAMType.setBounds(97, 190, 60, 24);
		RAMType.setBackground(Color.WHITE);
		
		RAMType.setMaximumRowCount(2);
		RAMType.addItem("Mb");
		RAMType.addItem("Gb");
		frmInstaladorBewom.getContentPane().add(RAMType);
		
		resWidth = new JTextField();
		resWidth.setBounds(27, 160, 60, 24);
		resWidth.setText("1280");
		resWidth.setColumns(10);
		frmInstaladorBewom.getContentPane().add(resWidth);
		
		resHeight = new JTextField();
		resHeight.setBounds(97, 160, 60, 24);
		resHeight.setText("720");
		resHeight.setColumns(10);
		frmInstaladorBewom.getContentPane().add(resHeight);
		
		lblResolucionInicial.setBounds(167, 161, 272, 22);
		lblResolucionInicial.setForeground(new Color(51, 51, 51));
		frmInstaladorBewom.getContentPane().add(lblResolucionInicial);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 534, 64);
		panel_1.setBackground(new Color(51, 51, 204));
		frmInstaladorBewom.getContentPane().add(panel_1);
		showLauncher.setBounds(6, 130, 452, 23);
		
		showLauncher.setSelected(true);
		showLauncher.setForeground(new Color(51, 51, 51));
		showLauncher.setBackground(new Color(255, 255, 255));
		frmInstaladorBewom.getContentPane().add(showLauncher);
		
		checkResolution.setForeground(new Color(51, 51, 51));
		checkResolution.setBackground(Color.WHITE);
		checkResolution.setBounds(6, 161, 21, 23);
		frmInstaladorBewom.getContentPane().add(checkResolution);
		
		checkRAM.setForeground(new Color(51, 51, 51));
		checkRAM.setBackground(Color.WHITE);
		checkRAM.setBounds(6, 191, 21, 23);
		frmInstaladorBewom.getContentPane().add(checkRAM);
		
		checkRAM.setSelected(false);
		RAM.setEnabled(false);
		RAMType.setEnabled(false);
		lblMbDeRam.setEnabled(false);
		
		checkResolution.setSelected(false);
		resWidth.setEnabled(false);
		resHeight.setEnabled(false);
		lblResolucionInicial.setEnabled(false);
		
		checkResolution.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(checkResolution.isSelected()){
					
					resWidth.setEnabled(true);
					resHeight.setEnabled(true);
					lblResolucionInicial.setEnabled(true);
					
				} else {
					
					resWidth.setEnabled(false);
					resHeight.setEnabled(false);
					lblResolucionInicial.setEnabled(false);
					
				}
				
			}
			
		});
		
		checkRAM.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(checkRAM.isSelected()){
					
					RAM.setEnabled(true);
					RAMType.setEnabled(true);
					lblMbDeRam.setEnabled(true);
					
				} else {
					
					RAM.setEnabled(false);
					RAMType.setEnabled(false);
					lblMbDeRam.setEnabled(false);
					
				}
				
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(btnNewButton.getModel().isArmed()){
					
					chckbxPixelmon.setEnabled(false);
					frmtdtxtfldSda.setEnabled(false);
					btnNewButton.setEnabled(false);
					showLauncher.setEnabled(false);
					lblDescargandoPixelmon.setText("Empezando la instalación...");
					progressBar.setIndeterminate(true);
					
					lblResolucionInicial.setEnabled(false);
					checkRAM.setEnabled(false);
					RAMType.setEnabled(false);
					RAM.setEnabled(false);
					
					lblMbDeRam.setEnabled(false);
					checkResolution.setEnabled(false);
					resHeight.setEnabled(false);
					resWidth.setEnabled(false);
					
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
