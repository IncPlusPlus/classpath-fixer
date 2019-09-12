package io.github.incplusplus.classpathfixer;

import io.github.incplusplus.classpathfixer.ec.classpath.Classpath;
import io.github.incplusplus.classpathfixer.ij.module.Module;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static io.github.incplusplus.classpathfixer.FileWrangling.getImlClasspathPairAtDir;
import static io.github.incplusplus.classpathfixer.LibJarManagement.getBundleJarsUsedInEclipseClasspath;

class Logic
{
	static void performDependencyUpdate(File baseDir) throws IOException
	{
		ImlClasspathPair pair = getImlClasspathPairAtDir(baseDir);
		Classpath classPath = pair.getClassPath();
		Module module = pair.getModule();
		
		//clear currently listed dependencies
		module.clearDefaultComponentDependencies();
		//get the prefixed JARs from the eclipse classpath file
		List<File> bundleJars = getBundleJarsUsedInEclipseClasspath(pair);
		System.out.println("oof");
		//TODO more implementation to come
	}
}
