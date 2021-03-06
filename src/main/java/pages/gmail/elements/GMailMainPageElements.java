package pages.gmail.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import pages.base.CorePage;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.CheckBox;
import ru.yandex.qatools.htmlelements.element.Link;
import static org.openqa.selenium.By.xpath;

public class GMailMainPageElements extends CorePage {

	public static final String DELETE_BUTTON = "((//div[@gh]//div[@style=''])[1]/div)[last()]";
	public static final String SELECT_ALL_LETTERS_CHECKBOX = "//div[@gh]//div[@role='presentation']/parent::span";
	public static final String ALL_LETTERS_LIST = "//div[@style='']//table//div[@role='checkbox']";
	public static final String CREATE_NEW_LETTER_BUTTON = "(//div[@role='button'])[6]";
	public static final String POPUP_MENU_BUTTON = "(//a[@aria-haspopup='true'])[3]";
	public static final String EXIT_BUTTON = "//div[2]/div[3]/div[2]/a";
	public static final String TO_SPAM_BUTTON = "(//div[2]/div[1]/div/div[2]/div[2]/div/div)[1]";
	public static final String INBOX_LINK = "((//div[@role='navigation'])//a)[1]";
	public static final String STARRED_LINK = "(//div[@id]/div/div[1]/span/a)[2]";
	public static final String MORE_BUTTON = "//span[@role='button']/span[1]";
	public static final String SPAM_FOLDER_LINK = "(//div[@id]/div/div[1]/span/a)[8]";
	public static final String CHANGE_THEME_BUTTON = "//span[text()='Выберите тему']";
	public static final By LETTER_SENT_MESSAGE_BUTTON = xpath("//span[@id='link_vsm']");
	public static final By PROGRESS_BAR = xpath("//div[@role='progressbar']");
	public static final String SPAM_CONFIRM_BUTTON = "//button/following-sibling::button";

	@FindBy(xpath = DELETE_BUTTON)
	private static Button btnDeleteAllLetters;

	@FindBy(xpath = SELECT_ALL_LETTERS_CHECKBOX)
	private static CheckBox chbSelectAllLetter;

	@FindBy(xpath = ALL_LETTERS_LIST)
	private static List<Button> lstBtnAllLetters;

	@FindBy(xpath = SPAM_CONFIRM_BUTTON)
	private static Button btnSpanConfirm;

	@FindBy(xpath = CREATE_NEW_LETTER_BUTTON)
	private static Button btnNewLetter;

	@FindBy(xpath = POPUP_MENU_BUTTON)
	private static Button btnPopupMenu;

	@FindBy(xpath = EXIT_BUTTON)
	private static Button btnExit;

	@FindBy(xpath = TO_SPAM_BUTTON)
	private static Button btnToSpam;

	@FindBy(xpath = STARRED_LINK)
	private static Link lnkStarred;

	@FindBy(xpath = INBOX_LINK)
	private static Link lnkInbox;

	@FindBy(xpath = CHANGE_THEME_BUTTON)
	private static Button btnThemes;

	@FindBy(xpath = MORE_BUTTON)
	private static Link lnkMore;

	@FindBy(xpath = SPAM_FOLDER_LINK)
	private static Link lnkSpamFolder;

	public static CheckBox getChbSelectAllLetter() {
		return chbSelectAllLetter;
	}

	public static Button getBtnDeleteAllLetter() {
		return btnDeleteAllLetters;
	}

	public static List<Button> getLstBtnAllLetters() {
		return lstBtnAllLetters;
	}

	public static Button getBtnPopupMenu() {
		return btnPopupMenu;
	}

	public static Button getBtnExit() {
		return btnExit;
	}

	public static Button getBtnNewLetter() {
		return btnNewLetter;
	}

	public static Button getBtnToSpam() {
		return btnToSpam;
	}

	public static Link getLnkStarred() {
		return lnkStarred;
	}

	public static Button getBtnThemes() {
		return btnThemes;
	}

	public static Button getBtnSpanConfirm() {
		return btnSpanConfirm;
	}

	public static Link getLnkMore() {
		return lnkMore;
	}

	public static Link getLnkInbox() {
		return lnkInbox;
	}

	public static Link getLnkSpamFolder() {
		return lnkSpamFolder;
	}

}