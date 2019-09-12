package io.github.incplusplus.classpathfixer;

import io.github.incplusplus.classpathfixer.ec.classpath.Classpath;
import io.github.incplusplus.classpathfixer.ij.module.Module;

import java.io.File;
import java.io.IOException;

import static io.github.incplusplus.classpathfixer.FileWrangling.getImlClasspathPairAtDir;

class Logic
{
	static void performDependencyUpdate(File baseDir) throws IOException
	{
		ImlClasspathPair pair = getImlClasspathPairAtDir(baseDir);
		Classpath classPath = pair.getClassPath();
		Module module = pair.getModule();
		
		//TODO more implementation to come
	}
}
