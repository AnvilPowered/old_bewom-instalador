package es.bewom.downloads;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import es.bewom.BewomPack;

public class DownloadProgress extends Thread {

	public double p;
	public String dirFile;

	public void set(double p, String dirFile) {
		this.p = p;
		this.dirFile = dirFile;
	}

	@Override
	public void run() {

		File fios = new File(dirFile);
		while (true) {
			int progress = (int) Math.round(((100 / p) * fios.length()));

			if (progress >= 100) {
				break;
			}

			Runnable run = new Runnable() {

				@Override
				public void run() {
					BewomPack.progressBar.setValue(progress);
				};
			};
			try {
				SwingUtilities.invokeAndWait(run);
			} catch (InvocationTargetException | InterruptedException e) {
				e.printStackTrace();
			}

		}
		this.interrupt();
	}

}
