package com.qa.test.utils;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

import com.qa.test.base.TestBase;

public class TestCleanUp extends TestBase {

	public static void clearTempFolder() throws IOException {
		ArrayList<String> loc = new ArrayList<String>();
		String currentDir = System.getProperty("user.dir");
		loc.add(currentDir + File.separator + "src" + File.separator + "test" + File.separator + "resources");

		try {
			for (String lc : loc) {
				File file = new File(lc);
				FileUtils.cleanDirectory(file);
			}
		} catch (IOException e) {
// Do nothing since we do not worry about the files that cannot be deleted
// Include exception handler logic if you want to
		}
	}

}
