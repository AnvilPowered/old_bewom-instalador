package es.bewom.downloads;

import java.io.File;

import es.bewom.BewomPack;

public class DownloadProgress extends Thread {
	
	public double p;
	public String dirFile;
	
	public void set(double p, String dirFile){
		
		this.p = p;
		this.dirFile = dirFile;
		
	}
	
	@Override
	public void run() {
		
		File fios = new File(dirFile);
		
		while (true){
			
			int progress = (int) ((100/p) * fios.length());
			
			BewomPack.progressBar.setValue(progress);
			
			if(progress >= 99){
				
				this.interrupt();
				break;
				
			}
			
		}
		
	}

}
