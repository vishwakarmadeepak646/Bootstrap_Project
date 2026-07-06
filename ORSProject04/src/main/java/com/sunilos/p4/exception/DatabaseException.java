package com.sunilos.p4.exception;

/**
 * DatabaseException is propogated by DAO classes when an unhandled Database
 * exception occurred
 * 
 * @author Deepak Vishwakarma
 * @version 1.0
 * @Copyright (c) Rays EdTech
 * 
 */

public class DatabaseException extends RuntimeException {

	/**
	 * @param msg : Error message
	 */
	public DatabaseException(String msg) {
		super(msg);
	}
}
