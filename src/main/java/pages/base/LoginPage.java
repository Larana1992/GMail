package pages.base;

public interface LoginPage<T extends CorePage> {

	<T extends MainPage> T logIn(int userNumber);
}
