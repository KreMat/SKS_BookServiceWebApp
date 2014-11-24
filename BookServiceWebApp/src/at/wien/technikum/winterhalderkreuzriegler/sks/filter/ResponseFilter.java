package at.wien.technikum.winterhalderkreuzriegler.sks.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.ext.Provider;

@Provider
public class ResponseFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext request,
			ContainerResponseContext response) throws IOException {
		response.getHeaders().add("Access-Control-Allow-Origin", "*");
		response.getHeaders().add("Access-Control-Allow-Headers", "Authorization"); 
		System.out.println("CORS");
		CacheControl cacheControl = new CacheControl();
		cacheControl.setNoCache(false);
		response.getHeaders().add("Cache-Control", cacheControl);
	}

}