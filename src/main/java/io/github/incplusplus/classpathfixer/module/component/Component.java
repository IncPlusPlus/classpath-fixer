package io.github.incplusplus.classpathfixer.module.component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.github.incplusplus.classpathfixer.module.component.content.Content;
import io.github.incplusplus.classpathfixer.module.component.orderentry.OrderEntry;
import io.github.incplusplus.classpathfixer.module.component.output.Output;

import java.util.List;

@JacksonXmlRootElement(localName = "component")
public class Component
{
	@JacksonXmlProperty(isAttribute = true)
	String name;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	Output output;
	@JacksonXmlProperty(localName = "content")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	List<Content> contentList;
	@JacksonXmlProperty(localName = "orderEntry")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	List<OrderEntry> orderEntries;
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public Output getOutput()
	{
		return output;
	}
	
	public void setOutput(Output output)
	{
		this.output = output;
	}
	
	public List<Content> getContentList()
	{
		return contentList;
	}
	
	public void setContentList(List<Content> contentList)
	{
		this.contentList = contentList;
	}
	
	public List<OrderEntry> getOrderEntries()
	{
		return orderEntries;
	}
	
	public void setOrderEntries(List<OrderEntry> orderEntries)
	{
		this.orderEntries = orderEntries;
	}
}
