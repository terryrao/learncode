package org.raowei.test.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ClassUtils {

	/**
	 * 获得同一包中有的interface 的所有实现类
	 * 
	 * @param c
	 * @return
	 */
	public static List<Class<?>> getAllClassesByInterface(Class<?> c) {
		List<Class<?>> list = new ArrayList<Class<?>>();
		String packageName = c.getPackage().getName();
		List<Class<?>> allClasses = null;;

		if (c.isInterface()) {
			//获得该包及该包下所有的子类
			try {
				allClasses = getClasses(packageName);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			 //判断是不是同一个接口
			 for (int i = 0; i < allClasses.size(); i++) {
				 if (c.isAssignableFrom(allClasses.get(i))) {
					list.add(allClasses.get(i));
				}
			 }
		}

		return list;
	}

	public static List<Class<?>> getClasses(String packageName) throws IOException, ClassNotFoundException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		String path = packageName.replace(".", "/");
		List<File> dirs = new ArrayList<File>();
			Enumeration<URL> resources = classLoader.getResources(path);
			while (resources.hasMoreElements()) {
				URL resourceUrl = resources.nextElement();
				dirs.add(new File(resourceUrl.getFile()));
			}
		List<Class<?>> classes = new ArrayList<Class<?>>();
		for (File file : dirs) {
			classes.addAll(findClasses(file, packageName));
		}
		return classes;
	}

	public static List<Class<?>> findClasses(File dir, String packageName) throws ClassNotFoundException {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		if (dir.isFile()) {
			return classes;
		}

		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				assert !file.getName().contains(".");
				classes.addAll(findClasses(file, packageName + "." + file.getName()));
			} else if (file.getName().endsWith(".class")) {
				Class<?> cls = Class.forName(packageName + "." + file.getName().substring(0, file.getName().length() - 6));
				if (!cls.isInterface()) {
					classes.add(cls);
				}
			}
		}
		return classes;
	}
	
}
