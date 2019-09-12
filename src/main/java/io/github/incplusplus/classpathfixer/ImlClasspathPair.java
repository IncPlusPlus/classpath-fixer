package io.github.incplusplus.classpathfixer;

import io.github.incplusplus.classpathfixer.ec.classpath.Classpath;
import io.github.incplusplus.classpathfixer.ij.module.Module;

/**
 * This is just an easy way to return both a .classpath and .iml from one method
 */
public class ImlClasspathPair
{
	private final Classpath classPath;
	private final Module module;
	
	public ImlClasspathPair(Classpath classPath, Module module) {
		this.classPath = classPath;
		this.module = module;
	}
	
	public Classpath getClassPath()
	{
		return classPath;
	}
	
	public Module getModule()
	{
		return module;
	}
}
