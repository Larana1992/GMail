package core.helpers.pages;

import static pages.gmail.elements.GMailLetterElements.*;
import static core.helpers.pages.GMailAddFileToNotWebWindow.addFile;
import pages.base.CorePage;
import core.Config;

public class GMailLetterHelper extends CorePage{
	public void fillInField(int userNumber) {
		getTxtRecipient().sendKeys(Config.getRecipient().get(userNumber));
		getTxtSubject().sendKeys(Config.getSubject().get(userNumber));
		getTxtTextArea().sendKeys(Config.getText().get(userNumber));
	}

	public void fillFieldsAndFile(int userNumber) {
		fillInField(userNumber);
		getBtnFile().click();
		addFile();
	}

	public void sendLetter() {
		getBtnSend().click();
	}
}