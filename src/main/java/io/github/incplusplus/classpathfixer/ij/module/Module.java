package io.github.incplusplus.classpathfixer.ij.module;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.github.incplusplus.classpathfixer.ij.module.component.Component;

@JacksonXmlRootElement(localName = "module")
public class Module
{
	@JacksonXmlProperty(isAttribute = true)
	String type;
	@JacksonXmlProperty(isAttribute = true)
	String version;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	Component component;
	
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
	
	public Component getComponent()
	{
		return component;
	}
	
	public void setComponent(Component component)
	{
		this.component = component;
	}
}
