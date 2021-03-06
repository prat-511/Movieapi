package com.mov;

import java.util.List;

public class Movie {
	int vote_count;
	int id;
	String video;
	double vote_average;
	String title;
	double popularity;
	String poster_path;
	String original_language;
	String original_title;
	String backdrop_path;
	String adult;
	String overview;
	String release_date;
    List<Integer> genre_ids;
	public Movie(int vote_count, int id, String video, double vote_average, String title, double popularity,
			String poster_path, String original_language, String original_title, String backdrop_path, String adult,
			String overview, String release_date, List<Integer> genre_ids) {
		super();
		this.vote_count = vote_count;
		this.id = id;
		this.video = video;
		this.vote_average = vote_average;
		this.title = title;
		this.popularity = popularity;
		this.poster_path = poster_path;
		this.original_language = original_language;
		this.original_title = original_title;
		this.backdrop_path = backdrop_path;
		this.adult = adult;
		this.overview = overview;
		this.release_date = release_date;
		this.genre_ids = genre_ids;
	}
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Result [vote_count=" + vote_count + ", id=" + id + ", video=" + video + ", vote_average=" + vote_average
				+ ", title=" + title + ", popularity=" + popularity + ", poster_path=" + poster_path
				+ ", original_language=" + original_language + ", original_title=" + original_title + ", backdrop_path="
				+ backdrop_path + ", adult=" + adult + ", overview=" + overview + ", release_date=" + release_date
				+ ", genre_ids=" + genre_ids + "]";
	}
	public int getVote_count() {
		return vote_count;
	}
	public void setVote_count(int vote_count) {
		this.vote_count = vote_count;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public double getVote_average() {
		return vote_average;
	}
	public void setVote_average(double vote_average) {
		this.vote_average = vote_average;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPopularity() {
		return popularity;
	}
	public void setPopularity(double popularity) {
		this.popularity = popularity;
	}
	public String getPoster_path() {
		return poster_path;
	}
	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}
	public String getOriginal_language() {
		return original_language;
	}
	public void setOriginal_language(String original_language) {
		this.original_language = original_language;
	}
	public String getOriginal_title() {
		return original_title;
	}
	public void setOriginal_title(String original_title) {
		this.original_title = original_title;
	}
	public String getBackdrop_path() {
		return backdrop_path;
	}
	public void setBackdrop_path(String backdrop_path) {
		this.backdrop_path = backdrop_path;
	}
	public String getAdult() {
		return adult;
	}
	public void setAdult(String adult) {
		this.adult = adult;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public List<Integer> getGenre_ids() {
		return genre_ids;
	}
	public void setGenre_ids(List<Integer> genre_ids) {
		this.genre_ids = genre_ids;
	}
}
