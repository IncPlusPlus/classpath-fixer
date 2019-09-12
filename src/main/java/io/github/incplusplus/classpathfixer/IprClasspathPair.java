package io.github.incplusplus.classpathfixer;

import io.github.incplusplus.classpathfixer.ec.classpath.Classpath;
import io.github.incplusplus.classpathfixer.ij.module.Module;

/**
 * This is just an easy way to return both a .classpath and .ipr from one method
 */
public class IprClasspathPair
{
	private final Classpath classPath;
	private final Module module;
	
	public IprClasspathPair(Classpath classPath, Module module) {
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
