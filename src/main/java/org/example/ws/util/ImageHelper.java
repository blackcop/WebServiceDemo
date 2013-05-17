package org.example.ws.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImageHelper {

	public static final String FILE_URL_PREFIX = "image/";

	public static final String getFileUrl() {
		String fileurl = ImageHelper.getWebInfPath(ImageHelper.class);
		System.out.println(fileurl.toString());
		fileurl = fileurl + ImageHelper.FILE_URL_PREFIX;
		return fileurl;
	}

	public static byte[] getImage(String uri) {
		File file = new File(uri);
		byte[] b = null;
		if (file != null) {
			try {
				FileInputStream fis = new FileInputStream(file);
				if (fis != null) {
					int len = fis.available();
					b = new byte[len];
					fis.read(b);
					fis.close();
				}
			} catch (FileNotFoundException e) {
				Logger.getLogger("ImageHelper").log(Level.INFO,
						"file is not found");
			} catch (IOException e) {
				Logger.getLogger("ImageHelper").log(Level.INFO, "ioException");
			}
		}
		return b;
	}

	public static void storeImage(byte[] b, String name) {
		try {
			File f = new File(name);
			if (!f.exists()) {
				f.createNewFile();
				f.setWritable(true);
			}
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(b);
			fos.flush();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getWebInfPath(Class<?> c) {
		URL url = c.getProtectionDomain().getCodeSource().getLocation();
		System.out.println(url.toString());
		String path = url.toString();
		int index = path.indexOf("WEB-INF");

		if (index == -1) {
			index = path.indexOf("classes");
		}

		if (index == -1) {
			index = path.indexOf("bin");
		}

		path = path.substring(0, index);

		if (path.startsWith("zip")) {// 当class文件在war中时，此时返回zip:D:/...这样的路径
			path = path.substring(4);
		} else if (path.startsWith("file")) {// 当class文件在class文件中时，此时返回file:/D:/...这样的路径
			path = path.substring(6);
		} else if (path.startsWith("jar")) {// 当class文件在jar文件里面时，此时返回jar:file:/D:/...这样的路径
			path = path.substring(10);
		}
		try {
			path = URLDecoder.decode(path, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return path;
	}
}
