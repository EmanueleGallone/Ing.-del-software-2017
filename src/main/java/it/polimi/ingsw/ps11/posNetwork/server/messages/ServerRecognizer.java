package it.polimi.ingsw.ps11.posNetwork.server.messages;

public interface ServerRecognizer {
	public void execute(DefaultServerMessage command);

	public void execute(StampaBlu stampaBlu);
}
