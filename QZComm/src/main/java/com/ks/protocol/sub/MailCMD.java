package com.ks.protocol.sub;

public interface MailCMD {
	/**查询邮件*/
	short QUERY_MAIL = 1;
	/**查看邮件*/
	short VIEW_MAIL = 2;
	/**收取附件*/
	short COLLECT_ADJUNCT = 3;
	/**新邮件*/
	short NEW_MAIL = 4;
	/**删除邮件*/
	short DELETE_MAIL = 5;
}
