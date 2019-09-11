package io.github.incplusplus.classpathfixer.ec.classpath.classpathentry.attr;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "attribute")
public class Attribute
{
	@JacksonXmlProperty(isAttribute = true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	String name;
	@JacksonXmlProperty(isAttribute = true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	String value;
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getValue()
	{
		return value;
	}
	
	public void setValue(String value)
	{
		this.value = value;
	}
}
