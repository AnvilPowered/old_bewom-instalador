package es.bewom.downloads;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import es.bewom.BewomPack;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class Download extends Thread {
	
	public String server;
	public String[] file;
	public String[] folder;
	public String[] directory;
	
	public URL website;
	public double fileSize;
	
	public void set(String s, String[] f, String[] t, String[] d){
		
		this.server = s;
		this.file = f;
		this.folder = t;
		this.directory = d;
		
	}
	
	@Override
	public void run() {
		
		for (int i = 0; i < file.length; i++) {
			
			if(file[i] != null){
				
				DownloadProgress dpixel = new DownloadProgress();
				
				try {
					
					BewomPack.lblDescargandoPixelmon.setText("Descargando " + file[i] + " . . .");
					
					File fios = new File(directory[i] + folder[i] + file[i]);
					if(fios.exists()){
						fios.delete();
					}
					
					File kdir = new File(directory[i] + folder[i]);
					if(!kdir.exists()){
						kdir.mkdirs();						
					}
					
					BewomPack.progressBar.setIndeterminate(false);
					
					website = new URL(server + folder[i] + file[i]);
					URLConnection conn = website.openConnection();
					fileSize = conn.getContentLength();
					conn.getInputStream().close();
					
					dpixel.set(fileSize, directory[i] + folder[i] + file[i]);
					dpixel.start();
					
					ReadableByteChannel rbc = Channels.newChannel(website.openStream());
					FileOutputStream fos = new FileOutputStream(directory[i] + folder[i] + file[i]);
					fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
					fos.close();
					
					if(file[i].equals("libs.zip")){
						
						BewomPack.lblDescargandoPixelmon.setText("Descomprimiendo " + file[i] + " . . .");
						unZipIt(directory[i] + folder[i] + file[i], directory[i] + folder[i]);
						
					}
					
					BewomPack.progressBar.setIndeterminate(true);
					
					dpixel.interrupt();
					
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}		
			
		}
		
		BewomPack.lblDescargandoPixelmon.setText("Listo para jugar!");
		BewomPack.progressBar.setIndeterminate(false);
		BewomPack.progressBar.setValue(0);
		BewomPack.chckbxOptifine.setEnabled(true);
		BewomPack.chckbxPixelmon.setEnabled(true);
		BewomPack.frmtdtxtfldSda.setEnabled(true);
		BewomPack.btnNewButton.setEnabled(true);
		
	}
	
	  public void unZipIt(String zipFile, String outputFolder){
		  
		  ZipFile zip;
		try {
			zip = new ZipFile(zipFile);
			zip.extractAll(outputFolder);
		} catch (ZipException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	  }

}
