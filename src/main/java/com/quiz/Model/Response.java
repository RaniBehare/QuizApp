package com.quiz.Model;

public class Response {

	private Integer id;
	private String response;
	public Response(Integer id, String response) {
		super();
		this.id = id;
		this.response = response;
	}
	public Integer getId() {
		return id;
	}
	public String getResponse() {
		return response;
	}
}
