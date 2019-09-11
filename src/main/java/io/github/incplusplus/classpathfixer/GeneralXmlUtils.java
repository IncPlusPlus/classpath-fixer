package io.github.incplusplus.classpathfixer;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

import java.io.IOException;

public abstract class GeneralXmlUtils
{
	private static JacksonXmlModule xmlModule;
	protected static XmlMapper xmlMapper;
	
	static
	{
		xmlModule = new JacksonXmlModule();
		xmlModule.setDefaultUseWrapper(false);
		
		xmlMapper = new XmlMapper(xmlModule);
		xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
		xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
	}
	
	public static <T> T getForXml(String rawXml, Class<T> desiredClass) throws IOException
	{
		return xmlMapper.readValue(rawXml,desiredClass);
	}
}
