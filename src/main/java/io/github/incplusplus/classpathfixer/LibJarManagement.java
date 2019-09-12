package io.github.incplusplus.classpathfixer;

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
	
	public static List<File> getBundleJarsUsedInEclipseClasspath(ImlClasspathPair originalPair)
	{
		List<ClasspathEntry> classpathEntries = originalPair.getClassPath().getClasspathEntriesWithPrefixedLibs();
		List<String> libraryStrings = classpathEntries.stream()
				//Get the path entry from each ClasspathEntry
				.map(ClasspathEntry::getPath)
				//Put that path into context
				.map(classpathEntryRelativeString -> originalPair.getClassPathLocation()
//						.getParent()
						.getAbsolutePath().concat(classpathEntryRelativeString))
				.collect(Collectors.toList());
		//Return these paths as constructed File instances
		return libraryStrings.stream().map(File::new).collect(Collectors.toList());
	}
}