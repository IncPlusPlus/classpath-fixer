package io.github.incplusplus.classpathfixer.ec.classpath;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.github.incplusplus.classpathfixer.ec.classpath.classpathentry.ClasspathEntry;

import java.util.List;

@JacksonXmlRootElement(localName = "classpath")
public class Classpath
{
	@JacksonXmlProperty(localName = "classpathentry")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	List<ClasspathEntry> classpathEntryList;
	
	public List<ClasspathEntry> getClasspathEntryList()
	{
		return classpathEntryList;
	}
	
	public void setClasspathEntryList(List<ClasspathEntry> classpathEntryList)
	{
		this.classpathEntryList = classpathEntryList;
	}
}
