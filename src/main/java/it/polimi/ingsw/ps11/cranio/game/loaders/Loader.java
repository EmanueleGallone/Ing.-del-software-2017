package it.polimi.ingsw.ps11.cranio.game.loaders;

import java.io.IOException;

public abstract class Loader {
	
	private final static String DEFAULT_FILE_PATH = "";
	private String filePath;
	
	public Loader() {
		filePath = DEFAULT_FILE_PATH;
	}
	
	public Loader(String filePath) {
		this.filePath = filePath;
	}
	
	public String getFilePath() {
		return filePath;
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public abstract Object load() throws IOException;
}
