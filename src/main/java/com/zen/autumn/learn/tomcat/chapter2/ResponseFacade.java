package com.zen.autumn.learn.tomcat.chapter2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;

public class ResponseFacade implements ServletResponse {

	private ServletResponse response;

	public ResponseFacade(Response response) {
		this.response = response;
	}

	public void flushBuffer() throws IOException {
		response.flushBuffer();
	}

	public int getBufferSize() {
		return response.getBufferSize();
	}

	public String getCharacterEncoding() {
		return response.getCharacterEncoding();
	}

	public Locale getLocale() {
		return response.getLocale();
	}

	public ServletOutputStream getOutputStream() throws IOException {
		return response.getOutputStream();
	}

	public PrintWriter getWriter() throws IOException {
		return response.getWriter();
	}

	public boolean isCommitted() {
		return response.isCommitted();
	}

	public void reset() {
		response.reset();
	}

	public void resetBuffer() {
		response.resetBuffer();
	}

	public void setBufferSize(int size) {
		response.setBufferSize(size);
	}

	public void setContentLength(int length) {
		response.setContentLength(length);
	}

	public void setContentType(String type) {
		response.setContentType(type);
	}

	public void setLocale(Locale locale) {
		response.setLocale(locale);
	}

	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCharacterEncoding(String charset) {
		// TODO Auto-generated method stub

	}

	public void setContentLengthLong(long len) {
		// TODO Auto-generated method stub

	}

}