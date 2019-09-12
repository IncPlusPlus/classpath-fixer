package io.github.incplusplus.classpathfixer.ij.module;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.github.incplusplus.classpathfixer.ImlClasspathPair;
import io.github.incplusplus.classpathfixer.ij.module.component.Component;
import io.github.incplusplus.classpathfixer.ij.module.component.orderentry.OrderEntry;
import io.github.incplusplus.classpathfixer.ij.module.component.orderentry.library.Library;
import io.github.incplusplus.classpathfixer.ij.module.component.orderentry.library.content.Classes;
import io.github.incplusplus.classpathfixer.ij.module.component.orderentry.library.content.root.Root;

import java.io.File;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@JacksonXmlRootElement(localName = "module")
public class Module
{
	@JacksonXmlProperty(isAttribute = true)
	String type;
	@JacksonXmlProperty(isAttribute = true)
	String version;
	@JacksonXmlProperty(localName = "component")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	List<Component> component;
	
	public String getType()
	{
		return type;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	
	public String getVersion()
	{
		return version;
	}
	
	public void setVersion(String version)
	{
		this.version = version;
	}
	
	public List<Component> getComponent()
	{
		return component;
	}
	
	public void setComponent(List<Component> component)
	{
		this.component = component;
	}
	
	private Component getDefaultComponent()
	{
		List<Component> theoreticalComponentSingletonList = component.stream()
				.filter(component1 -> component1.getName()
						.equalsIgnoreCase("NewModuleRootManager"))
				.collect(Collectors.toList());
//		There's a horrible problem if this assert fails
		assert theoreticalComponentSingletonList.size() == 1;
		return theoreticalComponentSingletonList.get(0);
	}
	
	public void clearDefaultComponentDependencies()
	{
		Component baseComponent = getDefaultComponent();
		List<OrderEntry> everythingButLibs = baseComponent.getOrderEntries().stream()
				.filter(orderEntry -> !orderEntry.getType()
						.equalsIgnoreCase("module-library"))
				.collect(Collectors.toList());
		baseComponent.setOrderEntries(everythingButLibs);
	}
	
	/**
	 * Adds a JAR as a compile-time and exported dependency in the default
	 * module for IntelliJ. Usually this is called NewModuleRootManager.
	 * @param jarFile The single JAR to add as a dependency
	 * @param parentPair The {@link ImlClasspathPair} that contains this IntelliJ module
	 */
	public void addDefaultComponentDependency(File jarFile, ImlClasspathPair parentPair)
	{
		String rootUrl = addPathFormattingForLibraryRoot(jarFile, parentPair);
		Component baseComponent = getDefaultComponent();
		List<OrderEntry> allOrderEntries = baseComponent.getOrderEntries();
		OrderEntry thisParticularJar = orderEntryLibForRootUrl(rootUrl);
		allOrderEntries.add(thisParticularJar);
		baseComponent.setOrderEntries(allOrderEntries);
	}
	
	private OrderEntry orderEntryLibForRootUrl(String rootUrl)
	{
		Root root = new Root();
		root.setUrl(rootUrl);
		
		Classes classes = new Classes();
		classes.setRoots(Collections.singletonList(root));
		
		Library library = new Library();
		library.setClasses(classes);
		
		OrderEntry output = new OrderEntry();
		output.setType("module-library");
		output.setExported("");
		output.setLibrary(library);
		return output;
	}
	
	private String addPathFormattingForLibraryRoot(File jarFile, ImlClasspathPair parentPair)
	{
		String jarPathPrefix = "jar://";
		String moduleDirVariable = "$MODULE_DIR$/";
		String typicalRootPathEnding = "!/";
		Path pathToJarDependency = jarFile.toPath();
		Path pathToModule = parentPair.getModulePathLocation().getParentFile().toPath();
		Path jarPathRelativeToModule = pathToModule.relativize(pathToJarDependency);
		String relativePath = convertToForwardSlashes(jarPathRelativeToModule.toString());
		if(!relativePath.endsWith(".jar"))
		{
			throw new RuntimeException("A JAR dependency path did not end in '.jar'. " +
					"This is a problem because we need to be able to append '!' and then '/'");
		}
		return jarPathPrefix+moduleDirVariable+relativePath+typicalRootPathEnding;
	}
	
	private String convertToForwardSlashes(String stringWithBackslashes)
	{
		return stringWithBackslashes.replaceAll("\\\\","/");
	}
}
