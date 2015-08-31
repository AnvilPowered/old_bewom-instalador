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

public class BewomPack {

	private JFrame frmInstaladorBewom;
	
	public static  JLabel lblDescargandoPixelmon = new JLabel("Cierra el launcher de minecraft y el juego!");
	public static JProgressBar progressBar = new JProgressBar();
	
	public static JCheckBox chckbxOptifine = new JCheckBox("Optifine");
	public static JCheckBox chckbxPixelmon = new JCheckBox("Pixelmon");
	public static JFormattedTextField frmtdtxtfldSda = new JFormattedTextField();
	public static JButton btnNewButton = new JButton("Instalar");
	
	public static String version = "1.3.1 BETA";
	
	public static String SO = System.getProperty("os.name").toLowerCase();
	
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
		frmInstaladorBewom.getContentPane().setBackground(new Color(35, 35, 35));
		frmInstaladorBewom.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("assets/logo_simple.png")));
		frmInstaladorBewom.setTitle("Instalador bewom");
		frmInstaladorBewom.setResizable(false);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		
		int h = 256;
		int w = 512;
		
		frmInstaladorBewom.setBounds(width/2 - w/2, height/2 - h/2, w, h);
		frmInstaladorBewom.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInstaladorBewom.getContentPane().setLayout(null);
		chckbxPixelmon.setForeground(new Color(255, 255, 255));
		chckbxPixelmon.setBackground(new Color(35, 35, 35));
		
		chckbxPixelmon.setSelected(true);
		chckbxPixelmon.setBounds(6, 87, 97, 23);
		frmInstaladorBewom.getContentPane().add(chckbxPixelmon);
		
		JLabel lblVa = new JLabel(version);
		lblVa.setForeground(new Color(255, 255, 255));
		lblVa.setHorizontalAlignment(SwingConstants.CENTER);
		lblVa.setEnabled(false);
		lblVa.setBounds(368, 42, 128, 23);
		frmInstaladorBewom.getContentPane().add(lblVa);
		
		btnNewButton.setBounds(368, 143, 128, 24);
		frmInstaladorBewom.getContentPane().add(btnNewButton);
		chckbxOptifine.setBackground(new Color(35, 35, 35));
		chckbxOptifine.setForeground(new Color(255, 255, 255));
		
		chckbxOptifine.setSelected(true);
		chckbxOptifine.setBounds(6, 113, 97, 23);
		frmInstaladorBewom.getContentPane().add(chckbxOptifine);
		progressBar.setStringPainted(true);
		
		progressBar.setBounds(0, 203, 506, 24);
		progressBar.setValue(0);
		progressBar.setForeground(new Color(207, 50, 50));
		frmInstaladorBewom.getContentPane().add(progressBar);
		
		frmtdtxtfldSda.setBounds(6, 143, 352, 24);
		frmtdtxtfldSda.setText(System.getenv("APPDATA") + "\\.minecraft");
		if(SO.contains("mac")){
			frmtdtxtfldSda.setText(System.getProperty("user.home") + "/Library/Application Support/minecraft");
		} else if(SO.contains("nux")){
			frmtdtxtfldSda.setText("~/.minecraft/");
		}
		frmInstaladorBewom.getContentPane().add(frmtdtxtfldSda);
				
		JLabel panel = new JLabel();
		panel.setBounds(6, 21, 490, 44);
		panel.setIcon(new ImageIcon(BewomPack.class.getResource("/es/bewom/assets/logo.png")));
		frmInstaladorBewom.getContentPane().add(panel);
		lblDescargandoPixelmon.setForeground(new Color(255, 255, 255));
		
		lblDescargandoPixelmon.setHorizontalAlignment(SwingConstants.CENTER);
//		lblDescargandoPixelmon.setEnabled(false);
		lblDescargandoPixelmon.setBounds(6, 178, 490, 14);
		frmInstaladorBewom.getContentPane().add(lblDescargandoPixelmon);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(btnNewButton.getModel().isArmed()){
					
					chckbxPixelmon.setEnabled(false);
					chckbxOptifine.setEnabled(false);
					frmtdtxtfldSda.setEnabled(false);
					btnNewButton.setEnabled(false);
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
