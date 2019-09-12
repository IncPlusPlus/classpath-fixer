package io.github.incplusplus.classpathfixer;

import io.github.incplusplus.classpathfixer.ec.EclipseUtils;
import io.github.incplusplus.classpathfixer.ec.classpath.Classpath;
import io.github.incplusplus.classpathfixer.ij.IntelliJUtils;
import io.github.incplusplus.classpathfixer.ij.module.Module;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
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
		return new ImlClasspathPair(classpath,project);
	}
}
