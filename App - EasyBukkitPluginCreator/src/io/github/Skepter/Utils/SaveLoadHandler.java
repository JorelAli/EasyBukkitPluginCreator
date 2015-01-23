package io.github.Skepter.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveLoadHandler {

	/** Saves an object to a file */
	public static void save(final Object obj, final File file) throws Exception {
		final ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file, true));
		oos.writeObject(obj);
		oos.flush();
		oos.close();
	}

	/** Loads an object from a file */
	public static Object load(final File file) throws Exception {
		final ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		final Object result = ois.readObject();
		ois.close();
		return result;
	}

}
