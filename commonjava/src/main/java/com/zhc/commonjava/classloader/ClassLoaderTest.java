package com.zhc.commonjava.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.util.ClassUtils;

public class ClassLoaderTest {

	public static void main(String[] args) throws IOException {
		String locationPath = "spring/log/log4j.properties";
		ClassLoader loader = new ClassLoader() {
		};
		URL urls = loader.getResource(locationPath);
		System.out.println("url: "+urls);
	}
	
	public static Set<Resource> doFindAllClassPathResources(String path) throws IOException {
		Set<Resource> result = new LinkedHashSet<Resource>(16);
		ClassLoader cl = ClassUtils.getDefaultClassLoader();
		Enumeration<URL> resourceUrls = (cl != null ? cl.getResources(path) : ClassLoader.getSystemResources(path));
		while (resourceUrls.hasMoreElements()) {
			URL url = resourceUrls.nextElement();
			System.out.println("url: "+url);
			result.add(convertClassLoaderURL(url));
		}
		return result;
	}
	protected static Resource convertClassLoaderURL(URL url) {
		return new UrlResource(url);
	}
}
