package com.ks.logic.creator;

import com.ks.exception.ExceptionUtil;
import com.ks.exceptions.GameException;

public class GameExceptionCreator {
	public static void main(String args[]) throws Exception{
		ExceptionUtil.createExceptionXMLFile(new GameException(), "E:/qz/Public/error/");
		ExceptionUtil.createAs3ExceptionClass(new GameException(), "E:/qz/Public/as/");
	}
}
                                                  