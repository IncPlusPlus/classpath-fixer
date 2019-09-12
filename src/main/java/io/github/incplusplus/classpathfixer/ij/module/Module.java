package io.github.incplusplus.classpathfixer.ij.module;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.github.incplusplus.classpathfixer.ij.module.component.Component;
import io.github.incplusplus.classpathfixer.ij.module.component.orderentry.OrderEntry;

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
	
	public void clearDefaultComponentDependencies()
	{
		List<Component> theoreticalOneComponentList = component.stream()
				.filter(component1 -> component1.getName()
						.equalsIgnoreCase("NewModuleRootManager"))
				.collect(Collectors.toList());
//		There's a horrible problem if this assert fails
		assert theoreticalOneComponentList.size() == 1;
		
		Component baseComponent = theoreticalOneComponentList.get(0);
		List<OrderEntry> everythingButLibs = baseComponent.getOrderEntries().stream()
				.filter(orderEntry -> !orderEntry.getType()
						.equalsIgnoreCase("module-library"))
				.collect(Collectors.toList());
		
		baseComponent.setOrderEntries(everythingButLibs);
	}
}
