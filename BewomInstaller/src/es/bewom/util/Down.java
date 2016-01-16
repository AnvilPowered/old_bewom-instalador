package es.bewom.util;

public class Down {
	
	private String nameFile	;
	private String urlDownload;
	private String folderSave;
	
	public Down(String nameFile, String urlDownload, String folderSave) {
		super();
		this.nameFile = nameFile;
		this.urlDownload = urlDownload;
		this.folderSave = folderSave;
	}

	public String getNameFile() {
		return nameFile;
	}

	public String getUrlDownload() {
		return urlDownload;
	}

	public String getFolderSave() {
		return folderSave;
	}
	

	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}

	public void setUrlDownload(String urlDownload) {
		this.urlDownload = urlDownload;
	}

	public void setFolderSave(String folderSave) {
		this.folderSave = folderSave;
	}
	
	
	
}
