package io.github.incplusplus.classpathfixer;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static io.github.incplusplus.classpathfixer.Logic.performDependencyUpdate;

public class Main
{
	/*
	TODO currently only works for the basedir that contains a project
	  does not yet recurse
	*/
	
	/*
	TODO add more things that synchronize.
	  i.e. implement functionality that will look at <classpathentry including...> to figure out what directories
	  should be excluded
	*/
	public static void main(String[] args) throws IOException
	{
//		String raw = "<classpathentry kind=\"con\" path=\"org.eclipse.buildship.core.gradleclasspathcontainer\">\n" +
//				"\t<attributes>\n" +
//				"\t\t<attribute name=\"module\" value=\"true\"/>\n" +
//				"\t</attributes>\n" +
//				"</classpathentry>";
		
		if (args.length != 1)
		{
			System.out.println("[ERROR]: There must be a single argument" +
					" provided containing the base of the path whose " +
					"subdirectories contain .classpath files.");
			System.out.print("Provided input : ");
			System.out.println(Arrays.toString(args));
		}
		else
		{
			File baseDir = new File(args[0]);
			if (!baseDir.exists() || !baseDir.isDirectory() || baseDir.isFile())
			{
				System.out.println("[ERROR]: Given path either doesn't exist" +
						" or isn't a directory. Provided path is below.");
				System.out.println(args[0]);
				System.out.println("The path that this input resolved to is below.");
				System.out.println(baseDir.getAbsolutePath());
			}
			else
			{
				performDependencyUpdate(baseDir);
			}
		}
	}
}
