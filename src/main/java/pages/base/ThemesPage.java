package pages.base;

public interface ThemesPage<T extends CorePage> {
	public <T extends ThemesPage> T chooseRandomTheme();
}
