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
	
	public static String server = "http://bewom.es/instalador/";
	
	public static String profileJson = "bewom.json";
	
	public static String pixelmon = "Pixelmon";
	public static String optifine = "OptiFine";
	public static String screen = "CustomScreen";
	public static String minebikes = "minebike";
	public static String money = "moneybitch";
	
	public static String configPixelmon = "pixelmon.cfg";
	public static String configScreen= "custom_screen.cfg";
	
	public static String forgeLibs = "libs.zip";
	
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
			
			String profile = "\"bewom_" + BewomPack.version + "\": {\"name\": \"bewom_" + BewomPack.version + "\",\"gameDir\": \"" + dir.replace("\\", "\\\\")  +"\",\"lastVersionId\": \"bewom\" , \"javaArgs\": \"-Xmx2G -XX:+UseConcMarkSweepGC -XX:+CMSIncrementalMode -XX:-UseAdaptiveSizePolicy -Xmn512M\"},";
			
			text = part1 + profile + part2 + "bewom_" + BewomPack.version + part3;
			
			FileWriter write = new FileWriter(nDir + "/launcher_profiles.json");
			write.write(text);
			write.close();
			
		}
		
		//Load versions
		BewomPack.lblDescargandoPixelmon.setText("Comprobando versiones . . .");
		
		pixelmon = URLConnectionReader.getText(server + "mods/" + "pixelmon.php");
		Downloads.optifine = URLConnectionReader.getText(server + "mods/" + "optifine.php");
		screen = URLConnectionReader.getText(server + "mods/" + "screen.php");
		minebikes = URLConnectionReader.getText(server + "mods/" + "bikes.php");
		money = URLConnectionReader.getText(server + "mods/" + "money.php");
		
		if(pixelmon != null && Downloads.optifine != null && screen != null){
			
			//Download mods	
			List<String> files = new ArrayList<String>();
			List<String> folder = new ArrayList<String>();
			List<String> direct = new ArrayList<String>();
			
			if(BewomPack.chckbxPixelmon.isSelected()){
				
				files.add(pixelmon);
				folder.add("/mods/");
				direct.add(dir);
				
			}
			
			if(BewomPack.chckbxOptifine.isSelected()){
				
				files.add(Downloads.optifine);
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
			
			
			//Borrar mods no correctos!
			BewomPack.lblDescargandoPixelmon.setText("Borrando mods incorrectos. . .");
			String[] fil = {pixelmon, Downloads.optifine, screen};
			File f = new File(dir + "/mods/");
			String[] ffiles = f.list();
			
			if(f.length() != 0){
				
				for (int l = 0; l < ffiles.length; l++) {
					
					File m = new File(f, ffiles[l]);
					int k = 3;
					
					for (int i = 0; i < 3; i++) {
						
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
			
			BewomPack.lblDescargandoPixelmon.setText("Creando archvio de configuración /custom_screen.cfg . . .");
			FileWriter write = new FileWriter(dir + "/config/custom_screen.cfg");
			write.write(version);
			write.close();
			
			
			
			BewomPack.lblDescargandoPixelmon.setText("Empezando descargas . . .");
			Download download = new Download();
			download.set(server, files, folder, direct);
			download.start();
			
		} else {
			
			BewomPack.lblDescargandoPixelmon.setText("Hay problemas con la conexión a la red!");
			BewomPack.progressBar.setIndeterminate(false);
			BewomPack.progressBar.setValue(0);
			BewomPack.chckbxOptifine.setEnabled(true);
			BewomPack.chckbxPixelmon.setEnabled(true);
			BewomPack.frmtdtxtfldSda.setEnabled(true);
			BewomPack.btnNewButton.setEnabled(true);
			
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
