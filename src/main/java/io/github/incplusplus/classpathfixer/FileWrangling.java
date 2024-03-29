package io.github.incplusplus.classpathfixer;

import io.github.incplusplus.classpathfixer.ec.EclipseUtils;
import io.github.incplusplus.classpathfixer.ec.classpath.Classpath;
import io.github.incplusplus.classpathfixer.ij.IntelliJUtils;
import io.github.incplusplus.classpathfixer.ij.module.Module;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.jar.Attributes;
import java.util.jar.JarInputStream;
import java.util.jar.Manifest;
import java.util.stream.Collectors;

public class FileWrangling
{
	public static ImlClasspathPair getImlClasspathPairAtDir(File baseDir) throws IOException
	{
		List<File> classpathFiles = Arrays.stream(Objects.requireNonNull(baseDir.listFiles()))
				.filter(file -> file.getName().equalsIgnoreCase(".classpath"))
				.collect(Collectors.toList());
		//if this fails, something has gone horribly wrong.
		assert classpathFiles.size()<=1;
		
		List<File> projectFiles = Arrays.stream(Objects.requireNonNull(baseDir.listFiles()))
				.filter(file -> file.getName().endsWith(".iml"))
				.collect(Collectors.toList());
		//if this fails, something has gone horribly wrong.
		assert projectFiles.size()<=1;
		
		if(classpathFiles.size()==1 && projectFiles.size()==1)
		{
			System.out.println("Found Eclipse .classpath file at " + classpathFiles.get(0));
			System.out.println("Along with...");
			System.out.println("Likely associated IntelliJ .iml file at " + projectFiles.get(0));
		}
		else
		{
			throw new RuntimeException("There was no pair found of both types of file!");
		}
		Classpath classpath = EclipseUtils.getECClasspathForXML(classpathFiles.get(0));
		Module project = IntelliJUtils.getIJModuleForXml(projectFiles.get(0));
		return new ImlClasspathPair(classpath, classpathFiles.get(0), project, projectFiles.get(0));
	}

	public static List<File> getJarsFromManifestInJar(File jarFile) throws IOException
	{
		JarInputStream jarStream = new JarInputStream(new FileInputStream(jarFile));
		Manifest mf = jarStream.getManifest();
		Attributes attributes = mf.getMainAttributes();
		String classpath = attributes.getValue("Class-Path");
		List<String> classPathStrings = Arrays.asList(classpath.split(" "));
		List<String> fullClassPathStrings = classPathStrings.stream()
				//filter out any blank entries
				.filter(s -> !s.isEmpty())
				//Resolve the absolute file location of the JARs referenced in the Class-Path
				.map(s -> jarFile.getParent()
						.concat(File.separator)
						.concat(s)).collect(Collectors.toList());
		return fullClassPathStrings.stream().map(File::new).collect(Collectors.toList());
	}
}
