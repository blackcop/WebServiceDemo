package org.example.ws.util;

import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

public class CustomJsonProvider extends JacksonJaxbJsonProvider {

    public CustomJsonProvider(){
    	//可以定制jackson处理json的方式
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(
				org.codehaus.jackson.map.DeserializationConfig.Feature.UNWRAP_ROOT_VALUE,
				true);
		mapper.configure(
				org.codehaus.jackson.map.SerializationConfig.Feature.WRAP_ROOT_VALUE,
				true);
		_mapperConfig.setMapper(mapper);
		_mapperConfig.getConfiguredMapper().setAnnotationIntrospector(new JaxbAnnotationIntrospector());
    }
}
