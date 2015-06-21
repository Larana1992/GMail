package pages.gmail.elements;

import org.openqa.selenium.support.FindBy;
import pages.base.CorePage;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class GMailLoginPageElements extends CorePage {
	public static final String USER_LOGIN_TEXT_INPUT = "//input[@id='Email']";
	public static final String PASSWORD_TEXT_INPUT = "//input[@id='Passwd']";
	public static final String ACCOUNT_CHOOSER_USER_BUTTON = "//a[@id='account-chooser-link']";
	public static final String NEXT_BUTTON = "//input[@id='next']";
	public static final String SING_IN_BUTTON = "//input[@id='signIn']";
	public static final String ADD_ACCOUNT_BUTTON = "//a[@id='account-chooser-add-account']";

	@FindBy(xpath = USER_LOGIN_TEXT_INPUT)
	private static TextInput txtLogin;

	@FindBy(xpath = PASSWORD_TEXT_INPUT)
	private static TextInput txtPasword;

	@FindBy(xpath = NEXT_BUTTON)
	private static Button btnNext;

	@FindBy(xpath = SING_IN_BUTTON)
	private static Button btnSignIn;

	@FindBy(xpath = ACCOUNT_CHOOSER_USER_BUTTON)
	private static Button btnChooseUser;

	@FindBy(xpath = ADD_ACCOUNT_BUTTON)
	private static Button btnAdd;

	public static TextInput getTxtUserLogin() {
		return txtLogin;
	}

	public static TextInput getTxtUserPassword() {
		return txtPasword;
	}

	public static Button getBtnNext() {
		return btnNext;
	}

	public static Button getBtnSignIn() {
		return btnSignIn;
	}

	public static Button getBtnChooseUser() {
		return btnChooseUser;
	}

	public static Button getBtnAdd() {
		return btnAdd;
	}
}