package io.github.incplusplus.classpathfixer.ij;

import io.github.incplusplus.classpathfixer.GeneralXmlUtils;
import io.github.incplusplus.classpathfixer.ij.module.Module;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static io.github.incplusplus.classpathfixer.GeneralUtils.inputStreamToString;

public final class IntelliJUtils extends GeneralXmlUtils
{
	public static Module getIJModuleForXml(File fileContainingXml) throws IOException
	{
		String rawXml = inputStreamToString(new FileInputStream(fileContainingXml));
		return getIJModuleForXML(rawXml);
	}
	
	public static Module getIJModuleForXML(String rawXml) throws IOException
	{
		return getForXml(rawXml,Module.class);
	}
}
