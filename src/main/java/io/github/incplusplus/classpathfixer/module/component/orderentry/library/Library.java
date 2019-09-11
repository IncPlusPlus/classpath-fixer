package io.github.incplusplus.classpathfixer.module.component.orderentry.library;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.github.incplusplus.classpathfixer.module.component.orderentry.library.content.Classes;
import io.github.incplusplus.classpathfixer.module.component.orderentry.library.content.Javadoc;
import io.github.incplusplus.classpathfixer.module.component.orderentry.library.content.Sources;

@JacksonXmlRootElement(localName = "library")
public class Library
{
	@JsonInclude(JsonInclude.Include.NON_NULL)
	LibraryProperties properties;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JacksonXmlProperty(isAttribute = true)
	String type;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JacksonXmlProperty(isAttribute = true)
	String name;
	@JacksonXmlProperty(localName = "CLASSES")
	Classes classes;
	@JacksonXmlProperty(localName = "JAVADOC")
	Javadoc javadoc;
	@JacksonXmlProperty(localName = "SOURCES")
	Sources sources;
	
	public Classes getClasses()
	{
		return classes;
	}
	
	public void setClasses(Classes classes)
	{
		this.classes = classes;
	}
	
	public Javadoc getJavadoc()
	{
		return javadoc;
	}
	
	public void setJavadoc(Javadoc javadoc)
	{
		this.javadoc = javadoc;
	}
	
	public Sources getSources()
	{
		return sources;
	}
	
	public void setSources(Sources sources)
	{
		this.sources = sources;
	}
	
	public LibraryProperties getProperties()
	{
		return properties;
	}
	
	public void setProperties(LibraryProperties properties)
	{
		this.properties = properties;
	}
	
	public String getType()
	{
		return type;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
}
