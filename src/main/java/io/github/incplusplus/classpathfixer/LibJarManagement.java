package io.github.incplusplus.classpathfixer;

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
}