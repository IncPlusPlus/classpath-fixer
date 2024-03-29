package io.github.incplusplus.classpathfixer.ij.module.component.content.classpathentry;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "sourceFolder")
public class SourceFolder extends AbstractClasspathEntry
{
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JacksonXmlProperty(isAttribute = true)
	String type;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JacksonXmlProperty(isAttribute = true)
	String isTestSource;
	
	public String getType()
	{
		return type;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	
	public String getIsTestSource()
	{
		return isTestSource;
	}
	
	public void setIsTestSource(String isTestSource)
	{
		this.isTestSource = isTestSource;
	}
}
