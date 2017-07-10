package it.polimi.ingsw.ps11.model;

import java.io.File;

public class FileRegistry {

	public static final String root = "settings" + File.separatorChar;
	public static final String board = root + "board";
	public static final String cards = root + "cards" + File.separatorChar;
	public static final String timers_lobby = root + "timers"+ File.separatorChar + "lobby";
	public static final String timers_turn = root + "timers" + File.separatorChar + "turn";
	public static final String view_commands =root + "view" + File.separatorChar + "commands";
	public static final String login_registry = root +"login"+ File.separatorChar +"register";
	public static final String player = root + "player";
	public static final String church = root + "church" + File.separatorChar + "church";
	public static final String leaderCards = cards + "leaderCards";
	public static final String excommunication = root + "church" + File.separatorChar + "excommunication";
	public static final String endActions = root + "actions" + File.separatorChar + "defaultEndActions";
	public static final String default_tiles = root + "tiles";
	
}
