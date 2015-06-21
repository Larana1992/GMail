package core.helpers.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import core.Config;
import static core.helpers.generalhelpers.WaiterHelpers.*;

public class GMailAddFileToNotWebWindow {

	public static void addFile() {
		try {
			String path = new java.io.File(Config.getFilePath())
					.getAbsolutePath();
			StringSelection ss = new StringSelection(path);
			Toolkit.getDefaultToolkit().getSystemClipboard()
					.setContents(ss, null);
			Robot robot = new Robot();
			action();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			delay(1000);
			action();
			delay(5000);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public static void action() {
		try {
			Robot okRobot = new Robot();
			okRobot.keyPress(KeyEvent.VK_ENTER);
			okRobot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
}
