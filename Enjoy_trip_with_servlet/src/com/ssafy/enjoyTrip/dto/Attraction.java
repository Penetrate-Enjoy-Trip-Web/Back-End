package com.ssafy.enjoyTrip.dto;

public class Attraction {
	private String contentId;
	//attraction_description
	private String overview;
	
	//attraction_info
	private String content_type_id;
	private String title;
	private String addr1;
	private String zipcode;
	private String first_image;
	private String first_image2;
	private String sido_code;
	private String latitude;
	private String longitude;
                                            
	//sido                                  
	private String sido_name;

	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getContent_type_id() {
		return content_type_id;
	}

	public void setContent_type_id(String content_type_id) {
		this.content_type_id = content_type_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getFirst_image() {
		return first_image;
	}

	public void setFirst_image(String first_image) {
		this.first_image = first_image;
	}

	public String getFirst_image2() {
		return first_image2;
	}

	public void setFirst_image2(String first_image2) {
		this.first_image2 = first_image2;
	}

	public String getSido_code() {
		return sido_code;
	}

	public void setSido_code(String sido_code) {
		this.sido_code = sido_code;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getSido_name() {
		return sido_name;
	}

	public void setSido_name(String sido_name) {
		this.sido_name = sido_name;
	}
	
}                                           
