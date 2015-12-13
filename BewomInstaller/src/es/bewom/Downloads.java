package es.bewom;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import es.bewom.downloads.Download;

public class Downloads {
	
	public static String server 			= "http://bewom.es/instalador/";
	
	public static String profileJson 		= "bewom.json";
	
	public static String pixelmon 			= "Pixelmon";
	public static String screen 			= "CustomScreen";
	public static String minebikes 		= "minebike";
	public static String money 			= "moneybitch";
	public static String evs_ivs 			= "evs-ivs";
	
	public static String minimapa			= "blocks";
	public static String iChunUtil			= "iChunUtil";
	
	public static String configPixelmon 	= "pixelmon.hocon";
	public static String configScreen		= "custom_screen.cfg";
	
	public static String forgeLibs 		= "libs.zip";
	
	public static BufferedReader br;
	
	public static void download(String nDir) throws Exception{
		
		String dir = nDir + "/bewom/";
		
		br = new BufferedReader( new FileReader(nDir + "/launcher_profiles.json"));
		
		String text  = "";
		String line = "";
		
		while((line = br.readLine()) != null){
			text += line;
		}
		
		if(!text.contains("bewom_" + BewomPack.version)){
			
			int i = text.substring(text.indexOf("\"profiles\""), text.length()).indexOf("{") + text.indexOf("\"profiles\"") + 1;
			
			int j = text.substring(text.indexOf("\"selectedProfile\""), text.length()).indexOf(":") + text.indexOf("\"selectedProfile\"") + 3;
			int k = j + text.substring(j, text.length()).indexOf("\"");
			
			String part1 = text.substring(0, i);
			String part2 = text.substring(i, j);
			String part3 = text.substring(k, text.length());
						
			String ramm = "";
			
			if(BewomPack.checkRAM.isSelected()){
				
				String ram = BewomPack.RAM.getText();
				if(BewomPack.RAMType.getSelectedItem().equals("Gb")){
					ram += "G";
				} else {
					ram += "M";
				}
				
				ramm = ", \"javaArgs\": \"-Xmx" + ram +" -XX:+UseConcMarkSweepGC -XX:+CMSIncrementalMode -XX:-UseAdaptiveSizePolicy -Xmn512M\"";
				
			}
			
			String resolution = "";
			
			if(BewomPack.checkResolution.isSelected()){
				
				int width = 1600;
				if(!BewomPack.resWidth.getText().isEmpty()){
					width = Integer.parseInt(BewomPack.resWidth.getText());
				}
				int height = 900;
				if(!BewomPack.resHeight.getText().isEmpty()){
					height = Integer.parseInt(BewomPack.resHeight.getText());
				}
				
				resolution = ", \"resolution\": {\"width\": " + width + ", \"height\": " + height + "}";
				
			}
			
			String show = "keep the launcher open";
			if(!BewomPack.showLauncher.isSelected()){
				show = "hide launcher and re-open when game closes";
			}
			
			String profile = "\"bewom_" + BewomPack.version + "\": {\"name\": \"bewom_" + BewomPack.version + "\",\"gameDir\": \"" + dir.replace("\\", "\\\\")  +"\",\"lastVersionId\": \"bewom\" " + ramm + resolution + ", \"launcherVisibilityOnGameClose\": \"" + show + "\"},";
			
			text = part1 + profile + part2 + "bewom_" + BewomPack.version + part3;
			
			FileWriter write = new FileWriter(nDir + "/launcher_profiles.json");
			write.write(text);
			write.close();
			
		}
		
		//Load versions
		BewomPack.lblDescargandoPixelmon.setText("Comprobando versiones . . .");
		
		pixelmon 	= URLConnectionReader.getText(server + "mods/" + "pixelmon.php");
		screen 		= URLConnectionReader.getText(server + "mods/" + "screen.php");
		minebikes 	= URLConnectionReader.getText(server + "mods/" + "bikes.php");
		money 		= URLConnectionReader.getText(server + "mods/" + "money.php");
		evs_ivs		= URLConnectionReader.getText(server + "mods/" + "evs-ivs.php");
		
		minimapa 	= URLConnectionReader.getText(server + "mods/" + "blocks.php");
		iChunUtil	= URLConnectionReader.getText(server + "mods/" + "iChunUtil.php");
		
		if(pixelmon != null && screen != null){
			
			//Download mods	
			List<String> files = new ArrayList<String>();
			List<String> folder = new ArrayList<String>();
			List<String> direct = new ArrayList<String>();
			
			if(BewomPack.chckbxPixelmon.isSelected()){
				
				files.add(pixelmon);
				folder.add("/mods/");
				direct.add(dir);
				
			}
			
			files.add(screen);
			folder.add("/mods/");
			direct.add(dir);
			
			files.add(minebikes);
			folder.add("/mods/");
			direct.add(dir);
			
			files.add(money);
			folder.add("/mods/");
			direct.add(dir);
			
			files.add(evs_ivs);
			folder.add("/mods/");
			direct.add(dir);
			
			files.add(minimapa);
			folder.add("/mods/");
			direct.add(dir);
			
			files.add(iChunUtil);
			folder.add("/mods/");
			direct.add(dir);
			
			//Borrar mods no correctos!
			BewomPack.lblDescargandoPixelmon.setText("Borrando mods incorrectos. . .");
			String[] fil = {pixelmon, screen};
			File f = new File(dir + "/mods/");
			String[] ffiles = f.list();
			
			if(f.length() != 0){
				
				for (int l = 0; l < ffiles.length; l++) {
					
					File m = new File(f, ffiles[l]);
					int k = fil.length;
					
					for (int i = 0; i < fil.length; i++) {
						
						if(!m.getName().equals(fil[i])){
							
							k--;
							
						}
						
					}
					if(k == 0){
						BewomPack.lblDescargandoPixelmon.setText("Borrando mod incorrecto " + m.getName() + " . . .");
						m.delete();
					}
					
				}
				
			}
			
			//download bewom profile
			
			files.add(profileJson);
			folder.add("/versions/bewom/");
			direct.add(nDir);
			
			//download config
			
			files.add(configPixelmon);
			folder.add("/config/");
			direct.add(dir);
			
			//download libs
			
			files.add(forgeLibs);
			folder.add("/");
			direct.add(nDir);
			
			File writeFile = new File(dir + "/config/");
			
			if(!writeFile.exists()){
				BewomPack.lblDescargandoPixelmon.setText("Creando directorio /config/. . .");
				writeFile.mkdirs();
			}
			
			String version = "# Configuration file \n \n general { \n # Este campo no debe ser modificado, solo el instalador lo puede cambiar [default: 0.0.0] \n S:\"Version del Pack\"=" + BewomPack.version + "\n }";
			
			BewomPack.lblDescargandoPixelmon.setText("Creando archvio de configuraci�n /custom_screen.cfg . . .");
			FileWriter write = new FileWriter(dir + "/config/custom_screen.cfg");
			write.write(version);
			write.close();
			
			
			
			BewomPack.lblDescargandoPixelmon.setText("Empezando descargas . . .");
			Download download = new Download();
			download.set(server, files, folder, direct);
			download.start();
			
		} else {
			
			BewomPack.lblDescargandoPixelmon.setText("Hay problemas con la conexi�n a la red!");
			BewomPack.progressBar.setIndeterminate(false);
			BewomPack.progressBar.setValue(0);
			BewomPack.chckbxPixelmon.setEnabled(true);
			BewomPack.frmtdtxtfldSda.setEnabled(true);
			BewomPack.btnNewButton.setEnabled(true);
			BewomPack.showLauncher.setEnabled(true);
			BewomPack.lblResolucionInicial.setEnabled(true);
			BewomPack.lblMbDeRam.setEnabled(true);
			
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
				
	}
	

	static class URLConnectionReader {
		public static String getText(String url) {
			try {
				URL website = new URL(url);
				URLConnection connection = website.openConnection();
		        BufferedReader in = new BufferedReader(
		                                new InputStreamReader(
		                                    connection.getInputStream()));
		
		        StringBuilder response = new StringBuilder();
		        String inputLine;
		
		        while ((inputLine = in.readLine()) != null) 
		            response.append(inputLine);
		
		        in.close();
		
		        return response.toString();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
	    }
	}
	
}
