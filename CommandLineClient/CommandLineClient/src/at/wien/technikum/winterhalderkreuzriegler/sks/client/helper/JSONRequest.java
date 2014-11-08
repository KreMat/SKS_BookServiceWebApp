package at.wien.technikum.winterhalderkreuzriegler.sks.client.helper;

import java.io.IOException;

import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;

public class JSONRequest {
	
	public static void sendJSONRequest(String url, Object value) {
		StringEntity entity = new StringEntity(new Gson().toJson(value),
				ContentType.create("application/json", Consts.UTF_8));

		HttpPost post = new HttpPost(url);
		post.setHeader("Content-type", "application/json");
		post.setEntity(entity);

		try {
			HttpResponse response = new DefaultHttpClient().execute(post);
			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK && response.getStatusLine().getStatusCode() != HttpStatus.SC_NO_CONTENT) {
				throw new IllegalStateException("HttpStatusCode: " + response.getStatusLine().getStatusCode() + " Reason: " + response.getStatusLine().getReasonPhrase());
			}
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}

}
