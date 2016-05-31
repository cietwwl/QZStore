package com.game.constant;

public class WebConstant {
	/**超级管理员*/
	public static final int USER_GROUP_TYPE_ADMIN = 1;
	/**普通管理员*/
	public static final int USER_GROUP_TYPE_COMMON = 2;
	
	/**权限（菜单管理-添加/修改菜单项）*/
	public static final int JURISDICTION_ID_MODIFY_MENU = 101001;
	/**权限（菜单管理-停用菜单项）*/
	public static final int JURISDICTION_ID_STOP_MENU = 101002;
	/**权限（菜单管理-删除菜单项）*/
	public static final int JURISDICTION_ID_DELETE_MENU = 101003;
	/**权限（用户管理-添加/修改用户）*/
	public static final int JURISDICTION_ID_MODIFY_USER = 102001;
	/**权限（用户管理-删除用户）*/
	public static final int JURISDICTION_ID_DELETE_USER = 102002;
	/**权限（用户组管理-添加/修改用户组）*/
	public static final int JURISDICTION_ID_MODIFY_USER_GROUP = 103001;
	/**权限（用户组管理-删除用户组）*/
	public static final int JURISDICTION_ID_DELETE_USER_GROUP = 103002;
	/**权限（权限管理-添加/修改权限）*/
	public static final int JURISDICTION_ID_MODIFY_JURISDICTION = 104001;
	/**权限（权限管理-删除权限）*/
	public static final int JURISDICTION_ID_DELETE_JURISDICTION = 104002;
	/**权限（请求权限管理-添加/修改权限）*/
	public static final int JURISDICTION_ID_MODIRY_REQUEST_JURISDICTION = 105001;
	/**权限（请求权限管理-删除权限）*/
	public static final int JURISDICTION_ID_DELETE_REQUEST_JURISDICTION = 105002;

	/**权限（服务器管理-添加服务器）*/
	public static final int JURISDICTION_ID_ADD_SERVER = 201001;
	/**权限（服务器管理-删除服务器）*/
	public static final int JURISDICTION_ID_DELETE_SERVER = 201002;
	/**权限（服务器管理-修改服务器）*/
	public static final int JURISDICTION_ID_MODIFY_SERVER = 201003;
	/**权限（服务器管理-停服）*/
	public static final int JURISDICTION_ID_STOP_SERVER = 201004;
	/**权限（服务器管理-重载缓存）*/
	public static final int JURISDICTION_ID_LOAD_GAME_CACHE = 201005;
	/**权限（请求权限管理-添加/修改渠道）*/
	public static final int JURISDICTION_ID_MODIFY_PARTNER = 202001;
	/**权限（请求权限管理-删除渠道）*/
	public static final int JURISDICTION_ID_DELETE_PARTNER = 202002;
	/**权限（请求权限管理-添加web刷新）*/
	public static final int JURISDICTION_ID_MODIFY_WEB_REFRESH = 203001;
	/**权限（请求权限管理-删除web刷新）*/
	public static final int JURISDICTION_ID_DELETE_WEB_REFRESH = 203002;
	/**权限（请求权限管理-web刷新）*/
	public static final int JURISDICTION_ID_REFRESH_WEB_CACHE = 203003;
	
	/**权限（玩家管理-禁言/封号）*/
	public static final int JURISDICTION_ID_BAN_PLAYER = 301001;
	
	/**权限（GM管理-修改玩家信息）*/
	public static final int JURISDICTION_ID_GM_MODIFY_PLAYER = 401001;
	/**权限（邮件申请-提交邮件申请）*/
	public static final int JURISDICTION_ID_SUBMIT_MAIL_APPLY = 402001;
	/**权限（邮件审核-审核邮件申请）*/
	public static final int JURISDICTION_ID_AUDITING_MAIL_APPLY = 403001;
	/**权限（邮件审核-删除邮件申请）*/
	public static final int JURISDICTION_ID_DELETE_MAIL_APPLY = 403002;
	/**权限（邮件审核-刷新发放状态）*/
	public static final int JURISDICTION_ID_FLUSH_MAIL_STATE = 403003;
	/**权限（邮件管理-删除系统邮件）*/
	public static final int JURISDICTION_ID_DELETE_SYSMAIL = 404001;
	/**权限（生成cdkey）*/
	public static final int JURISDICTION_ID_GENERATE_CDKEY = 405001;
	/**权限（激活cdkey）*/
	public static final int JURISDICTION_ID_ACTIVITED_CDKEY = 406001;
	/**权限（删除cdkey）*/
	public static final int JURISDICTION_ID_DELETE_CDKEY = 406002;
	/**权限（删除cdkey）*/
	public static final int JURISDICTION_ID_DOWNLOAD_CDKEY = 406003;
	/**权限（充值订单管理-订单发货）*/
	public static final int JURISDICTION_ID_BILL_RESEND = 407001;
	
	
}
