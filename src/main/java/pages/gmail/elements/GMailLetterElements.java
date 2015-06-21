package pages.gmail.elements;

import org.openqa.selenium.support.FindBy;
import pages.base.CorePage;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

@FindBy(xpath = "//div")
public class GMailLetterElements extends CorePage {

	public static final String RECIPIENT_TEXT_INPUT = "(//div/input/following-sibling::textarea)[1]";
	public static final String SUBJECT_TEXT_INPUT = "//input[@name='subjectbox']";
	public static final String TEXT_TEXT_INPUT = "//table/tbody/tr/td[2]/div[2]/div";
	public static final String ADD_FILE_BUTTON = "//div[@command='Files']//div[@id]";
	public static final String SEND_BUTTON = "//table/tbody/tr/td[1]/div/div[@role='button']";

	@FindBy(xpath = RECIPIENT_TEXT_INPUT)
	private static TextInput txtRecipient;

	@FindBy(xpath = SUBJECT_TEXT_INPUT)
	private static TextInput txtSubject;

	@FindBy(xpath = TEXT_TEXT_INPUT)
	private static TextInput txtText;

	@FindBy(xpath = ADD_FILE_BUTTON)
	private static Button btnFile;

	@FindBy(xpath = SEND_BUTTON)
	private static Button btnSend;

	public static TextInput getTxtRecipient() {
		return txtRecipient;
	}

	public static TextInput getTxtSubject() {
		return txtSubject;
	}

	public static TextInput getTxtTextArea() {
		return txtText;
	}

	public static Button getBtnFile() {
		return btnFile;
	}

	public static Button getBtnSend() {
		return btnSend;
	}
}
