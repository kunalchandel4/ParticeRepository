package sample;

import java.util.List;

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

	private List<String> urlOfImage;

	private List<String> titlleOfNews;

	private List<String> urlOfNews;
}
