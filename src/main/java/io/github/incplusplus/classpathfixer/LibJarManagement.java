package io.github.incplusplus.classpathfixer;

import io.github.incplusplus.classpathfixer.ec.classpath.Classpath;
import io.github.incplusplus.classpathfixer.ec.classpath.classpathentry.ClasspathEntry;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public final class LibJarManagement
{
	private static String jarNamePrefix = "bundle";
	
	/**
	 *
	 * @param prefix the prefix to expect for bundle jars.
	 *               Any JAR seen that starts with this will
	 *               be counted as a jar to expand.
	 */
	public static void setJarNamePrefix(String prefix)
	{
		jarNamePrefix = prefix;
	}
	
	public static String getJarNamePrefix()
	{
		return jarNamePrefix;
	}
	
	public static List<File> getBundleJarsUsedIn(Classpath eclipseClasspath)
	{
		List<ClasspathEntry> classpathEntries = eclipseClasspath.getLibraries();
		List<String> libraryStrings = classpathEntries.stream().map(ClasspathEntry::getPath).collect(Collectors.toList());
		return libraryStrings.stream().map(File::new).collect(Collectors.toList());
	}
}
