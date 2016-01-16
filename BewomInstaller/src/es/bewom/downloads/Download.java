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
import es.bewom.Downloads;
import es.bewom.util.Down;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class Download extends Thread {
		
	public URL website;
	public double fileSize;
		
	@Override
	public void run() {
		
		for (Down dw : Downloads.downs) {
			
			if(dw != null){
				DownloadProgress dpixel = new DownloadProgress();
				
				try {
					
					BewomPack.lblDescargandoPixelmon.setText("Descargando " + dw.getNameFile() + " . . .");
					
					File fios = new File(Downloads.directoryPath + dw.getFolderSave() + dw.getNameFile());
					if(fios.exists()){
						fios.delete();
					}
					
					File kdir = new File(Downloads.directoryPath + dw.getFolderSave());
					if(!kdir.exists()){
						kdir.mkdirs();						
					}
					
					BewomPack.progressBar.setIndeterminate(false);
					
					website = new URL(dw.getUrlDownload());
					URLConnection conn = website.openConnection();
					fileSize = conn.getContentLength();
					conn.getInputStream().close();
					
					System.out.println(conn.getContentLength() + "-" + Downloads.directoryPath + dw.getFolderSave() + dw.getNameFile());
					
					dpixel.set(fileSize, Downloads.directoryPath + dw.getFolderSave() + dw.getNameFile());
					dpixel.start();
					
					ReadableByteChannel rbc = Channels.newChannel(website.openStream());
					FileOutputStream fos = new FileOutputStream(Downloads.directoryPath + dw.getFolderSave() + dw.getNameFile());
					fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
					fos.close();
					
					if(dw.getNameFile().equals("libs.zip")){
						
						BewomPack.lblDescargandoPixelmon.setText("Descomprimiendo " + dw.getNameFile() + " . . .");
						unZipIt(Downloads.directoryPath + dw.getFolderSave() + dw.getNameFile(), Downloads.directoryPath + dw.getFolderSave());
						
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
		BewomPack.chckbxPixelmon.setEnabled(true);
		BewomPack.frmtdtxtfldSda.setEnabled(true);
		BewomPack.btnNewButton.setEnabled(true);
		BewomPack.showLauncher.setEnabled(true);
		
		BewomPack.checkRAM.setEnabled(true);
		if(BewomPack.checkRAM.isSelected()){
			BewomPack.RAMType.setEnabled(true);
			BewomPack.RAM.setEnabled(true);
			BewomPack.lblMbDeRam.setEnabled(true);
		}
		
		BewomPack.checkResolution.setEnabled(true);
		if(BewomPack.checkResolution.isSelected()){
			BewomPack.resHeight.setEnabled(true);
			BewomPack.resWidth.setEnabled(true);
			BewomPack.lblResolucionInicial.setEnabled(true);
		}
		
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
