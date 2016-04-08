package com.gaadi.sfa.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.util.Log;

import javax.net.ssl.HttpsURLConnection;

public class HttpConnection {
	public String readUrl(String mapsApiDirectionsUrl) throws IOException {
		String data = "";
		InputStream iStream = null;
		HttpsURLConnection urlConnection = null;
		try {
			URL url = new URL(mapsApiDirectionsUrl);
			urlConnection = (HttpsURLConnection) url.openConnection();
			urlConnection.connect();
			iStream = urlConnection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					iStream));
			StringBuffer sb = new StringBuffer();
			String line = "";
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			data = sb.toString();
			br.close();
		} catch (Exception e) {
			Logger.e("Exception while reading url", e.toString());
		} finally {
			iStream.close();
			urlConnection.disconnect();
		}
		return data;
	}

}
