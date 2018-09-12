//Made by Trey Carey | 9.11.18

public class applicationSettings {
	
	static String name = "Lower Thirds SDV";
	static double versionNumber = 1.0;
	
	public static String getApplicationName() {
		String applicationName = name + " " + versionNumber;
		return applicationName;
	}
	
}
