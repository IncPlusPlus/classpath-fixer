package io.github.incplusplus.classpathfixer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

import java.io.IOException;
import java.util.Collection;

public class UnknownPropertyWarning extends DeserializationProblemHandler
{
	@Override
	public boolean handleUnknownProperty(DeserializationContext ctxt, JsonParser _parser, JsonDeserializer<?> deser, Object beanOrClass, String propertyName) throws IOException
	{
		Collection<Object> propIds = (deser == null) ? null : deser.getKnownPropertyNames();
		UnrecognizedPropertyException exception = UnrecognizedPropertyException.from(_parser,
				beanOrClass, propertyName, propIds);
		System.out.println("[WARNING]: Encountered unknown property while deserializing!");
		System.out.println(exception);
		_parser.skipChildren();
		return true;
	}
}
