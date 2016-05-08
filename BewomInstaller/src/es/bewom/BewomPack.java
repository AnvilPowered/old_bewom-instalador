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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import es.bewom.Downloads.URLConnectionReader;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.SystemColor;

public class BewomPack {

	private JFrame frmInstaladorBewom;
	
	public static JLabel lblDescargandoPixelmon = new JLabel("Abre una vez el launcher de minecraft y cierralo antes de empezar la instalaci\u00F3n!");
	public static JProgressBar progressBar = new JProgressBar();
	public static JCheckBox chckbxPixelmon = new JCheckBox("Pixelmon versi\u00F3n 4.2.5");
	public static JFormattedTextField frmtdtxtfldSda = new JFormattedTextField();
	public static JButton btnNewButton = new JButton("Instalar");
	@SuppressWarnings("rawtypes")
	public static JComboBox RAMType = new JComboBox();
	public static JTextField RAM = new JTextField();
	public static JCheckBox checkResolution = new JCheckBox("");
	public static JCheckBox checkRAM = new JCheckBox("");
	
	public static String version = "2.0.2";
	
	public static String SO = System.getProperty("os.name").toLowerCase();
	
	public static JCheckBox showLauncher = new JCheckBox("Mantener el launcher de minecraft abierto");
	public static JTextField resWidth;
	public static JTextField resHeight;
	
	public static JLabel lblMbDeRam = new JLabel("RAM m\u00E1xima");
	public static JLabel lblResolucionInicial = new JLabel("Resolucion de la ventana de minecraft");
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JButton btnNewButton_1 = new JButton("Descargar");
	private final JLabel lblHttpbewomesinstalador = new JLabel("http://bewom.es/instalador/");
	
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
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		
		String v = URLConnectionReader.getText("http://bewom.es/instalador/config/version.cfg");
		
		if(!v.equalsIgnoreCase(version)){
			panel_1.setVisible(false);
			panel_2.setVisible(true);
			progressBar.setIndeterminate(true);
		} else {
			panel_1.setVisible(true);
			panel_2.setVisible(false);
		}
		
		frmInstaladorBewom.setBounds(width/2 - w/2, height/2 - h/2, 538, 284);
		frmInstaladorBewom.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInstaladorBewom.getContentPane().setLayout(null);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 83, 512, 161);
		
		frmInstaladorBewom.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		chckbxPixelmon.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxPixelmon.setBounds(0, 21, 450, 23);
		panel_1.add(chckbxPixelmon);
		chckbxPixelmon.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxPixelmon.setForeground(new Color(51, 51, 51));
		chckbxPixelmon.setBackground(new Color(255, 255, 255));
		
		chckbxPixelmon.setSelected(true);
		
		JLabel lblVa = new JLabel(version);
		lblVa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVa.setBounds(390, 108, 122, 23);
		panel_1.add(lblVa);
		lblVa.setForeground(new Color(51, 51, 51));
		lblVa.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewButton.setBounds(390, 137, 122, 24);
		panel_1.add(btnNewButton);
		btnNewButton.setForeground(new Color(51, 51, 51));
		frmtdtxtfldSda.setBounds(0, 137, 380, 24);
		panel_1.add(frmtdtxtfldSda);
		frmtdtxtfldSda.setBackground(Color.WHITE);
		frmtdtxtfldSda.setText(System.getenv("APPDATA") + "\\.minecraft");
		lblDescargandoPixelmon.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescargandoPixelmon.setBounds(0, 0, 512, 14);
		panel_1.add(lblDescargandoPixelmon);
		
		lblDescargandoPixelmon.setForeground(new Color(51, 51, 51));
		
		lblDescargandoPixelmon.setHorizontalAlignment(SwingConstants.CENTER);
		RAM.setForeground(SystemColor.desktop);
		RAM.setBounds(21, 107, 60, 24);
		panel_1.add(RAM);
		
		int ra = Math.round((Runtime.getRuntime().maxMemory() / 1048576f));
		
		RAM.setText(ra + "");
		RAM.setColumns(10);
		lblMbDeRam.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMbDeRam.setBounds(161, 108, 272, 22);
		panel_1.add(lblMbDeRam);
		lblMbDeRam.setForeground(new Color(51, 51, 51));
		lblMbDeRam.setEnabled(false);
		RAMType.setForeground(SystemColor.desktop);
		RAMType.setEditable(true);
		RAMType.setFont(new Font("Tahoma", Font.PLAIN, 11));
		RAMType.setBounds(91, 107, 60, 24);
		panel_1.add(RAMType);
		RAMType.setBackground(Color.WHITE);
				
		RAMType.setMaximumRowCount(2);
		RAMType.addItem("Mb");
		RAMType.addItem("Gb");
		
		resWidth = new JTextField();
		resWidth.setBounds(21, 77, 60, 24);
		panel_1.add(resWidth);
		resWidth.setText("1280");
		resWidth.setColumns(10);
		resWidth.setEnabled(false);
		
		resHeight = new JTextField();
		resHeight.setBounds(91, 77, 60, 24);
		panel_1.add(resHeight);
		resHeight.setText("720");
		resHeight.setColumns(10);
		resHeight.setEnabled(false);
		lblResolucionInicial.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblResolucionInicial.setBounds(161, 78, 272, 22);
		panel_1.add(lblResolucionInicial);
		lblResolucionInicial.setForeground(new Color(51, 51, 51));
		lblResolucionInicial.setEnabled(false);
		showLauncher.setFont(new Font("Tahoma", Font.PLAIN, 11));
		showLauncher.setBounds(0, 47, 452, 23);
		panel_1.add(showLauncher);
		
		showLauncher.setSelected(true);
		showLauncher.setForeground(new Color(51, 51, 51));
		showLauncher.setBackground(new Color(255, 255, 255));
		checkResolution.setBounds(0, 78, 21, 23);
		panel_1.add(checkResolution);
		
		checkResolution.setForeground(new Color(51, 51, 51));
		checkResolution.setBackground(Color.WHITE);
		
		checkResolution.setSelected(false);
		checkRAM.setBounds(0, 108, 21, 23);
		panel_1.add(checkRAM);
		
		checkRAM.setForeground(new Color(51, 51, 51));
		checkRAM.setBackground(Color.WHITE);
		
		checkRAM.setSelected(true);
		
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
		panel_2.setBounds(10, 83, 512, 161);
		frmInstaladorBewom.getContentPane().add(panel_2);
		
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				es.bewom.util.Util.openWebPage("http://bewom.es/instalador/");
			}
		});
		btnNewButton_1.setBounds(110, 90, 292, 23);
		
		panel_2.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("La versi\u00F3n de este launcher esta obsoleta, descarga la nueva haciendo click abajo...");
		lblNewLabel.setBounds(10, 11, 510, 23);
		panel_2.add(lblNewLabel);
		lblHttpbewomesinstalador.setBounds(10, 31, 510, 23);
		
		panel_2.add(lblHttpbewomesinstalador);
		progressBar.setBounds(-4, 64, 540, 6);
				
		progressBar.setBackground(new Color(0, 0, 0));
		frmInstaladorBewom.getContentPane().add(progressBar);
		progressBar.setValue(0);
		progressBar.setForeground(new Color(207, 50, 50));
		progressBar.setBackground(new Color(51, 51, 51));
		progressBar.setBorder(BorderFactory.createEmptyBorder());
		if(SO.contains("mac")){
			frmtdtxtfldSda.setText(System.getProperty("user.home") + "/Library/Application Support/minecraft");
		} else if(SO.contains("nux")){
			frmtdtxtfldSda.setText("~/.minecraft/");
		}
				
		JLabel panel = new JLabel();
		panel.setBounds(0, 0, 534, 64);
		panel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.setIcon(new ImageIcon(BewomPack.class.getResource("/es/bewom/assets/logo_simple.png")));
		frmInstaladorBewom.getContentPane().add(panel);
		
		JLabel label_background = new JLabel();
		label_background.setIcon(new ImageIcon(BewomPack.class.getResource("/es/bewom/assets/grad.png")));
		label_background.setBackground(Color.RED);
		label_background.setBounds(0, 0, 534, 64);
		
		frmInstaladorBewom.getContentPane().add(label_background);
		
		JPanel panel_background = new JPanel();
		panel_background.setBounds(0, 0, 534, 64);
		panel_background.setBackground(new Color(255, 255, 153));
		frmInstaladorBewom.getContentPane().add(panel_background);	
		
	}
}
