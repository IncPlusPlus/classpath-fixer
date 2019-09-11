package io.github.incplusplus.classpathfixer.module.component.content;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.github.incplusplus.classpathfixer.module.component.content.classpathentry.ExcludeFolder;
import io.github.incplusplus.classpathfixer.module.component.content.classpathentry.SourceFolder;

@JacksonXmlRootElement(localName = "content")
public class Content
{
	@JacksonXmlProperty(isAttribute = true)
	String url;
	@JacksonXmlProperty(localName = "sourceFolder")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	SourceFolder[] sourceFolders;
	@JacksonXmlProperty(localName = "excludeFolder")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	ExcludeFolder[] excludeFolders;
	@JacksonXmlProperty(localName = "excludePattern")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	ExcludePattern[] excludePatterns;
	
	public String getUrl()
	{
		return url;
	}
	
	public void setUrl(String url)
	{
		this.url = url;
	}
	
	public SourceFolder[] getSourceFolders()
	{
		return sourceFolders;
	}
	
	public void setSourceFolders(SourceFolder[] sourceFolders)
	{
		this.sourceFolders = sourceFolders;
	}
	
	public ExcludeFolder[] getExcludeFolders()
	{
		return excludeFolders;
	}
	
	public void setExcludeFolders(ExcludeFolder[] excludeFolders)
	{
		this.excludeFolders = excludeFolders;
	}
	
	public ExcludePattern[] getExcludePatterns()
	{
		return excludePatterns;
	}
	
	public void setExcludePatterns(ExcludePattern[] excludePatterns)
	{
		this.excludePatterns = excludePatterns;
	}
}
