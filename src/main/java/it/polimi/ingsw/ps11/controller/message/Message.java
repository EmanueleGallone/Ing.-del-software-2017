package it.polimi.ingsw.ps11.controller.message;

import java.io.Serializable;

public interface Message extends Serializable {

	public void accept(MessageRecognizer recognizer);
}
