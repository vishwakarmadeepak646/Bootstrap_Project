package com.sunilos.p4.exception;

/**
 * RecordNotFoundException thrown when a record not found occurred
 * 
 * @author Deepak Vishwakarma
 * @version 1.0
 * @Copyright (c) Rays EdTech
 * 
 */

public class RecordNotFoundException extends RuntimeException {

	/**
	 * @param msg error message
	 */
	public RecordNotFoundException(String msg) {
		super(msg);

	}
}
