package io.github.incplusplus.classpathfixer.ec;

import io.github.incplusplus.classpathfixer.GeneralXmlUtils;
import io.github.incplusplus.classpathfixer.ImlClasspathPair;
import io.github.incplusplus.classpathfixer.ec.classpath.Classpath;
import io.github.incplusplus.classpathfixer.ec.classpath.classpathentry.ClasspathEntry;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static io.github.incplusplus.classpathfixer.GeneralUtils.inputStreamToString;

public final class EclipseUtils extends GeneralXmlUtils
{
	public static Classpath getECClasspathForXML(File fileContainingXml) throws IOException
	{
		String rawXml = inputStreamToString(new FileInputStream(fileContainingXml));
		return getECClasspathForXML(rawXml);
	}
	
	public static Classpath getECClasspathForXML(String rawXml) throws IOException
	{
		return getForXml(rawXml,Classpath.class);
	}
	
	public static List<File> getBundleJarsUsedInEclipseClasspath(ImlClasspathPair originalPair)
	{
		List<ClasspathEntry> classpathEntries = originalPair.getClassPath().getClasspathEntriesWithPrefixedLibs();
		List<String> libraryStrings = classpathEntries.stream()
				//Get the path entry from each ClasspathEntry
				.map(ClasspathEntry::getPath)
				//Put that path into context
				.map(classpathEntryRelativeString -> originalPair.getClassPathLocation()
						.getParent()
						.concat(File.separator)
						.concat(classpathEntryRelativeString))
				.collect(Collectors.toList());
		//Return these paths as constructed File instances
		return libraryStrings.stream().map(File::new).collect(Collectors.toList());
	}
}
