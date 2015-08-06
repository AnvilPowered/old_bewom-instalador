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
	
	public static String version = "v1.3c ALPHA";
	
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
		
		chckbxPixelmon.setSelected(true);
		chckbxPixelmon.setBounds(6, 98, 97, 23);
		frmInstaladorBewom.getContentPane().add(chckbxPixelmon);
		
		JLabel lblVa = new JLabel(version);
		lblVa.setHorizontalAlignment(SwingConstants.CENTER);
		lblVa.setEnabled(false);
		lblVa.setBounds(368, 123, 128, 23);
		frmInstaladorBewom.getContentPane().add(lblVa);
		
		btnNewButton.setBounds(368, 153, 128, 24);
		frmInstaladorBewom.getContentPane().add(btnNewButton);
		
		chckbxOptifine.setSelected(true);
		chckbxOptifine.setBounds(6, 123, 97, 23);
		frmInstaladorBewom.getContentPane().add(chckbxOptifine);
		progressBar.setStringPainted(true);
		
		progressBar.setBounds(0, 213, 506, 14);
		progressBar.setValue(0);
		progressBar.setForeground(new Color(51, 204, 0));
		frmInstaladorBewom.getContentPane().add(progressBar);
		
		frmtdtxtfldSda.setBounds(6, 153, 352, 24);
		frmtdtxtfldSda.setText(System.getenv("APPDATA") + "\\.minecraft");
		if(SO.contains("mac")){
			
			frmtdtxtfldSda.setText(System.getProperty("user.home") + "/Library/Application Support/minecraft");
			
		}
		frmInstaladorBewom.getContentPane().add(frmtdtxtfldSda);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("assets/logo.png")); 
		
		JLabel panel = new JLabel();
		panel.setBounds(10, 11, 486, 105);
		panel.setIcon(icon);
		frmInstaladorBewom.getContentPane().add(panel);
		
		lblDescargandoPixelmon.setHorizontalAlignment(SwingConstants.CENTER);
//		lblDescargandoPixelmon.setEnabled(false);
		lblDescargandoPixelmon.setBounds(6, 188, 490, 14);
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
