package pages.base;

public interface MainPage <T extends CorePage> {

	public <T extends MainPage> T createFillAndSendNewLetter(int userNumber);
	public <T extends MainPage> T skipAll();
	public <T extends MainPage> T createFillAndNewLetterWithFile(int userNumber);
	public <T extends LoginPage> T logOut();
	public <T extends MainPage> T markLetterAsASpam(int userNumber);
	public <T extends MainPage> T dragLetterToStarredFolder(int userNumber);
	public <T extends MainPage> T checkThatLetterPresentInStarredFolder(int userNumber);
	public <T extends MainPage> T checkThatLetterContainFile(int userNumber);
	public <T extends ThemesPage> T navigateToThemesPage();
	public <T extends MainPage> T navigateToSpamFolder();
	public <T extends MainPage> T checkThatLetterInSpamFolder(int userNumber);
}
