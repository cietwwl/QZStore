package com.ks.logic.service;

import com.ks.access.Transaction;

public interface ServerService {

	/**
	 * 一次性加载
	 */
	@Transaction
	void singleLoad();
}
