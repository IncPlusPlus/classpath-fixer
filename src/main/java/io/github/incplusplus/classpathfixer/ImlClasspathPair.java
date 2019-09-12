package io.github.incplusplus.classpathfixer;

import io.github.incplusplus.classpathfixer.ec.classpath.Classpath;
import io.github.incplusplus.classpathfixer.ij.module.Module;

import java.io.File;

/**
 * This is just an easy way to return both a .classpath and .iml from one method
 */
public class ImlClasspathPair
{
	private final Classpath classPath;
	private final File classPathLocation;
	private final Module module;
	private final File modulePathLocation;
	
	public ImlClasspathPair(Classpath classPath, File classPathLocation, Module module, File modulePathLocation) {
		this.classPath = classPath;
		this.classPathLocation = classPathLocation;
		this.module = module;
		this.modulePathLocation = modulePathLocation;
	}
	
	public Classpath getClassPath()
	{
		return classPath;
	}
	
	public File getClassPathLocation()
	{
		return classPathLocation;
	}
	
	public Module getModule()
	{
		return module;
	}
	
	public File getModulePathLocation()
	{
		return modulePathLocation;
	}
}
