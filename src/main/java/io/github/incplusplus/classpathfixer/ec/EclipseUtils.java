package io.github.incplusplus.classpathfixer.ec;

import io.github.incplusplus.classpathfixer.GeneralXmlUtils;
import io.github.incplusplus.classpathfixer.ec.classpath.Classpath;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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
}
