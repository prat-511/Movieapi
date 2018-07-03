package com.mov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import org.codehaus.jackson.map.ObjectMapper;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import java.io.InputStream;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mov.*;

public class App {
	static ArrayList movielist2017 = new ArrayList();
	static ArrayList tvlist2017 = new ArrayList();
	static ArrayList moviestarlist2017 = new ArrayList();
	static ArrayList tvstarlist2017 = new ArrayList();
	static ArrayList overalllist = new ArrayList();
	public static void main(String[] args)  {
		try {
			
			  movielist2017 = movie2017(); 
			  System.out.println(movielist2017.size());
			  System.out.println(movielist2017);
			  tvlist2017 = tv2017();
			  System.out.println(tvlist2017.size());
			  System.out.println(tvlist2017);
			  moviestarlist2017 =  moviestars2017();
			  System.out.println(moviestarlist2017);
			  tvstarlist2017 =  tvstars2017();
			//  System.out.println(tvstarlist2017);
			 Collections.sort(tvstarlist2017);
			 Collections.sort(moviestarlist2017);
			 System.out.println("***** TV***********");
			 System.out.println(tvstarlist2017);
			 System.out.println("*****Movie***********");
			 System.out.println(moviestarlist2017);
			 for(int i=0; i <tvstarlist2017.size(); i++ )
			 {
	if(moviestarlist2017.contains(tvstarlist2017.get(i)))
	{
		overalllist.add(tvstarlist2017.get(i));	
	}
			
		 }
			 System.out.println(overalllist);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList movie2017() throws Exception {
		ArrayList<String> movielistname = new ArrayList();
		ArrayList movielist = new ArrayList();
		try {
			int totalpage;
			String inline = "";
			JSONParser parser = new JSONParser();
			String URI = "https://api.themoviedb.org/3/discover/movie?api_key=606aaffd7ca10f0b80804a1f0674e4e1&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&primary_release_year=2017&primary_release_date.gte=2017-07-01&primary_release_date.lte=2017-07-31&release_date.gte=2017-07-01&release_date.lte=2017-07-31";
			URL url1 = new URL(URI);
			HttpURLConnection conn1 = (HttpURLConnection) url1.openConnection();
			conn1.setRequestMethod("GET");
			conn1.connect();
			int responsecode1 = conn1.getResponseCode();
			if (responsecode1 != 200 && responsecode1 != 429) {
				System.out.println("Try later");
				throw new RuntimeException("HttpResponseCode: " + responsecode1);
			} else {
				InputStream content = (InputStream) conn1.getInputStream();
				BufferedReader in = new BufferedReader(new InputStreamReader(content));
				StringBuffer response = new StringBuffer();
				String inputLine;
				InputStream content1 = (InputStream) conn1.getInputStream();
				BufferedReader in1 = new BufferedReader(new InputStreamReader(content));
				JSONObject myResponse = (JSONObject) parser.parse(in1.readLine());
				Long totalpagesL = (Long) myResponse.get("total_pages");
				System.out.println(totalpagesL.toString());
				System.out.println(myResponse.get("total_results"));
				totalpage = totalpagesL.intValue();
			}
			for (int p = 1; p <= totalpage; p++) {
				String U = URI +"&page="+p;
				//System.out.println(U);
				URL url = new URL(U);
				System.out.println(url);
				Thread.sleep(300);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.connect();
				int responsecode = conn.getResponseCode();
				if (responsecode != 200 && responsecode != 429) {
					System.out.println("Try later");
					throw new RuntimeException("HttpResponseCode: " + responsecode);
				} else {
					InputStream content = (InputStream) conn.getInputStream();
					System.out.println(content);
					BufferedReader in = new BufferedReader(new InputStreamReader(content));
					System.out.println(in);
					ObjectMapper mapper = new ObjectMapper();
					JSONObject jobj = (JSONObject) parser.parse(in.readLine());
					JSONArray jsonarr = (JSONArray) jobj.get("results");
					for (Object arrayElement : jsonarr) {
						JSONObject project = (JSONObject) arrayElement;
						String jsonstring = project.toString();
						Movie movie = mapper.readValue(jsonstring, Movie.class);
						int inte = movie.id;
						System.out.println(inte);
						movielist.add(inte);	
						System.out.println(movie.title);
						movielistname.add(movie.title);
						
					
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movielist;
	}

	public static ArrayList tv2017() throws Exception {
		ArrayList<String> tvlistname = new ArrayList();
		ArrayList tvlist = new ArrayList();
		try {
			int totalpage;
			String inline = "";
			JSONParser parser = new JSONParser();
			String URI = "https://api.themoviedb.org/3/discover/tv?api_key=606aaffd7ca10f0b80804a1f0674e4e1&language=en-US&sort_by=popularity.desc&air_date.gte=2017-07-01&air_date.lte=2017-07-31&first_air_date.gte=2017-07-01&first_air_date.lte=2017-07-31&first_air_date_year=2017&timezone=America%2FNew_York&include_null_first_air_dates=false";
			URL url1 = new URL(URI);
			HttpURLConnection conn1 = (HttpURLConnection) url1.openConnection();
			conn1.setRequestMethod("GET");
			conn1.connect();
			int responsecode1 = conn1.getResponseCode();
			if (responsecode1 != 200 && responsecode1 != 429) {
				System.out.println("Try later");
				throw new RuntimeException("HttpResponseCode: " + responsecode1);
			} else {
				InputStream content = (InputStream) conn1.getInputStream();
				BufferedReader in = new BufferedReader(new InputStreamReader(content));
				StringBuffer response = new StringBuffer();
				String inputLine;
				InputStream content1 = (InputStream) conn1.getInputStream();
				BufferedReader in1 = new BufferedReader(new InputStreamReader(content));
				JSONObject myResponse = (JSONObject) parser.parse(in1.readLine());
				Long totalpagesL = (Long) myResponse.get("total_pages");				
				System.out.println(totalpagesL.toString());
				System.out.println(myResponse.get("total_results"));
				totalpage = totalpagesL.intValue();
			}
			for (int p = 1; p <= totalpage; p++) {
				String U = URI + "&page=" + p;
				System.out.println(U);
				URL url = new URL(U);
				Thread.sleep(300);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.connect();
				int responsecode = conn.getResponseCode();
				if (responsecode != 200 && responsecode != 429) {
					System.out.println("Try later");
					throw new RuntimeException("HttpResponseCode: " + responsecode);
				} else {
					InputStream content = (InputStream) conn.getInputStream();
					BufferedReader in = new BufferedReader(new InputStreamReader(content));
					ObjectMapper mapper = new ObjectMapper();
					JSONObject jobj = (JSONObject) parser.parse(in.readLine());
					JSONArray jsonarr = (JSONArray) jobj.get("results");
					for (Object arrayElement : jsonarr) {
						JSONObject project = (JSONObject) arrayElement;
						String jsonstring = project.toString();
						Tv tv = mapper.readValue(jsonstring, Tv.class);
						int integer = tv.id;
						System.out.println(integer);
						tvlist.add(integer);
						System.out.println(tv.name);
						tvlistname.add(tv.name);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tvlist;
	}

	
	  public static ArrayList moviestars2017() throws Exception { 
		  ArrayList<String> moviestarnamelist = new ArrayList();
			ArrayList moviestaridlist = new ArrayList();
		 try { 
				
				String inline = "";
				JSONParser parser = new JSONParser();
				String URI = "https://api.themoviedb.org/3/movie/";			
				String API = "/credits?api_key=606aaffd7ca10f0b80804a1f0674e4e1";	
				for (int movieid = 0; movieid < movielist2017.size(); movieid++) {
					String U = URI + movielist2017.get(movieid) + API;
					//System.out.println(U);
					URL url = new URL(U);
					Thread.sleep(300);
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setRequestMethod("GET");
					conn.connect();
					int responsecode = conn.getResponseCode();
					if (responsecode != 200 && responsecode != 429) {
						System.out.println("Try later");
						throw new RuntimeException("HttpResponseCode: " + responsecode);
					} else {
						InputStream content = (InputStream) conn.getInputStream();
						BufferedReader in = new BufferedReader(new InputStreamReader(content));
						ObjectMapper mapper = new ObjectMapper();
						JSONObject jobj = (JSONObject) parser.parse(in.readLine());
						System.out.println("Movie_id " +jobj.get("id"));
						JSONArray jsonarr = (JSONArray) jobj.get("cast");
						for (Object arrayElement : jsonarr) {
							JSONObject project = (JSONObject) arrayElement;
							String jsonstring = project.toString();
							CastMovie castmovie = mapper.readValue(jsonstring, CastMovie.class);
							int integer = castmovie.id;
							moviestaridlist.add(integer);
							System.out.println(integer);
							moviestarnamelist.add(castmovie.name);
							System.out.println(castmovie.name);
							//System.out.println(Arrays.toString(moviestarnamelist));
						}
					}
				}
		 }
				catch (Exception e) { e.printStackTrace(); }
		return moviestaridlist;
	  
	  
	  }
	  
	  public static ArrayList tvstars2017() throws Exception { 
		  ArrayList<String> tvstarnamelist = new ArrayList();
			ArrayList tvstaridlist = new ArrayList();
		 try { 
				
				String inline = "";
				JSONParser parser = new JSONParser();
				String URI = "https://api.themoviedb.org/3/tv/";			
				String API = "/credits?api_key=606aaffd7ca10f0b80804a1f0674e4e1";	
				for (int tvid = 0; tvid < tvlist2017.size(); tvid++) {
					String U = URI + tvlist2017.get(tvid) + API;
					//System.out.println(U);
					URL url = new URL(U);
					Thread.sleep(300);
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setRequestMethod("GET");
					conn.connect();
					int responsecode = conn.getResponseCode();
					if (responsecode != 200 && responsecode != 429) {
						System.out.println("Try later");
						throw new RuntimeException("HttpResponseCode: " + responsecode);
					} else {
						InputStream content = (InputStream) conn.getInputStream();
						BufferedReader in = new BufferedReader(new InputStreamReader(content));
						ObjectMapper mapper = new ObjectMapper();
						JSONObject jobj = (JSONObject) parser.parse(in.readLine());
						System.out.println("tv_id " +jobj.get("id"));
						JSONArray jsonarr = (JSONArray) jobj.get("cast");
						for (Object arrayElement : jsonarr) {
							JSONObject project = (JSONObject) arrayElement;
							String jsonstring = project.toString();
							Casttv casttv = mapper.readValue(jsonstring, Casttv.class);
							int integer = casttv.id;
							tvstaridlist.add(integer);
							System.out.println(integer);
							tvstarnamelist.add(casttv.name);
							System.out.println(casttv.name);
							//System.out.println(Arrays.toString(moviestarnamelist));
						}
					}
				}
		 }
				catch (Exception e) { e.printStackTrace(); }
		return tvstaridlist;
	  
	  
	  }
	  
}
	 

