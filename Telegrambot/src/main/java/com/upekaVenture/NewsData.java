package com.upekaVenture;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewsData {

	public List<String> getUrlOfImage() {
		return urlOfImage;
	}

	public void setUrlOfImage(List<String> urlOfImage) {
		this.urlOfImage = urlOfImage;
	}

	public List<String> getTitlleOfNews() {
		return titlleOfNews;
	}

	public void setTitlleOfNews(List<String> titlleOfNews) {
		this.titlleOfNews = titlleOfNews;
	}

	public List<String> getUrlOfNews() {
		return urlOfNews;
	}

	public void setUrlOfNews(List<String> urlOfNews) {
		this.urlOfNews = urlOfNews;
	}

	@JsonProperty("Url of Image")
	private List<String> urlOfImage;
	@JsonProperty("Titlle of news")
	private List<String> titlleOfNews;
	@JsonProperty("Url of News")
	private List<String> urlOfNews;
}
