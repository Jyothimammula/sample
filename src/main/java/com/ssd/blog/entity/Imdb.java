package com.ssd.blog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="imdb_top_1000")
public class Imdb {
	
	/*
	 * # Poster_Link, Series_Title, Released_Year, Certificate, Runtime, Genre,
	 * IMDB_Rating, Overview, Meta_score, Director, Star1, Star2, Star3, Star4,
	 * No_of_Votes, Gross 'https://m.media-amazon.com/images/M/
	 * MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU
	 * @._V1_UX67_CR0,0,67,98_AL_.jpg', 'The Shawshank Redemption', '1994', 'A',
	 * '142 min', 'Drama', '9.3', 'Two imprisoned men bond over a number of years,
	 * finding solace and eventual redemption through acts of common decency.',
	 * '80', 'Frank Darabont', 'Tim Robbins', 'Morgan Freeman', 'Bob Gunton',
	 * 'William Sadler', '2343110', '28,341,469'
	 * 
	 */
	
	@Lob
	private String certificate;

	@Lob
	private String director;

	@Lob
	private String genre;

	@Lob
	private String gross;

	private double IMDB_Rating;

	private int meta_score;

	private int no_of_Votes;

	@Lob
	private String overview;

	@Lob
	private String poster_Link;

	private int released_Year;

	@Lob
	private String runtime;

	@Lob
	@Id
	private String series_Title;

	@Lob
	private String star1;

	@Lob
	private String star2;

	@Lob
	private String star3;

	@Lob
	private String star4;

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getGross() {
		return gross;
	}

	public void setGross(String gross) {
		this.gross = gross;
	}

	public double getIMDB_Rating() {
		return IMDB_Rating;
	}

	public void setIMDB_Rating(double iMDB_Rating) {
		IMDB_Rating = iMDB_Rating;
	}

	public int getMeta_score() {
		return meta_score;
	}

	public void setMeta_score(int meta_score) {
		this.meta_score = meta_score;
	}

	public int getNo_of_Votes() {
		return no_of_Votes;
	}

	public void setNo_of_Votes(int no_of_Votes) {
		this.no_of_Votes = no_of_Votes;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getPoster_Link() {
		return poster_Link;
	}

	public void setPoster_Link(String poster_Link) {
		this.poster_Link = poster_Link;
	}

	public int getReleased_Year() {
		return released_Year;
	}

	public void setReleased_Year(int released_Year) {
		this.released_Year = released_Year;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getSeries_Title() {
		return series_Title;
	}

	public void setSeries_Title(String series_Title) {
		this.series_Title = series_Title;
	}

	public String getStar1() {
		return star1;
	}

	public void setStar1(String star1) {
		this.star1 = star1;
	}

	public String getStar2() {
		return star2;
	}

	public void setStar2(String star2) {
		this.star2 = star2;
	}

	public String getStar3() {
		return star3;
	}

	public void setStar3(String star3) {
		this.star3 = star3;
	}

	public String getStar4() {
		return star4;
	}

	public void setStar4(String star4) {
		this.star4 = star4;
	}

	public Imdb(String certificate, String director, String genre, String gross, double iMDB_Rating, int meta_score,
			int no_of_Votes, String overview, String poster_Link, int released_Year, String runtime,
			String series_Title, String star1, String star2, String star3, String star4) {
		super();
		this.certificate = certificate;
		this.director = director;
		this.genre = genre;
		this.gross = gross;
		IMDB_Rating = iMDB_Rating;
		this.meta_score = meta_score;
		this.no_of_Votes = no_of_Votes;
		this.overview = overview;
		this.poster_Link = poster_Link;
		this.released_Year = released_Year;
		this.runtime = runtime;
		this.series_Title = series_Title;
		this.star1 = star1;
		this.star2 = star2;
		this.star3 = star3;
		this.star4 = star4;
	}

	public Imdb() {
		super();
	}
	
	


}
