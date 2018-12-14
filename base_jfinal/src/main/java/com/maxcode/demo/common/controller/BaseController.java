/**
 * 请勿将俱乐部专享资源复制给其他人，保护知识产权即是保护我们所在的行业，进而保护我们自己的利益
 * 即便是公司的同事，也请尊重 JFinal 作者的努力与付出，不要复制给同事
 * 
 * 如果你尚未加入俱乐部，请立即删除该项目，或者现在加入俱乐部：http://jfinal.com/club
 * 
 * 俱乐部将提供 jfinal-club 项目文档与设计资源、专用 QQ 群，以及作者在俱乐部定期的分享与答疑，
 * 价值远比仅仅拥有 jfinal club 项目源代码要大得多
 * 
 * JFinal 俱乐部是五年以来首次寻求外部资源的尝试，以便于有资源创建更加
 * 高品质的产品与服务，为大家带来更大的价值，所以请大家多多支持，不要将
 * 首次的尝试扼杀在了摇篮之中
 */

package com.maxcode.demo.common.controller;


import com.jfinal.core.Controller;
import com.maxcode.demo.common.model.Account;


/**
 * 基础控制器，方便获取登录信息
 *
 * 注意：
 * 需要 LoginSessionInterceptor 配合，该拦截器使用
 * setAttr("loginAccount", ...) 事先注入了登录账户
 * 否则即便已经登录，该控制器也会认为没有登录
 *
 */
public class BaseController extends Controller {

	private Account loginAccount = null;

	/*@NotAction
	public Account getLoginAccount() {
		if (loginAccount == null) {
			loginAccount = getAttr(LoginService.loginAccountCacheName);
			if (loginAccount != null && ! loginAccount.isStatusOk()) {
				throw new IllegalStateException("当前用户状态不允许登录，status = " + loginAccount.getStatus());
			}
		}
		return loginAccount;
	}

	@NotAction
	public boolean isLogin() {
		return getLoginAccount() != null;
	}

	@NotAction
	public boolean notLogin() {
		return !isLogin();
	}

	*//**
	 * 获取登录账户id
	 * 确保在 FrontAuthInterceptor 之下使用，或者 isLogin() 为 true 时使用
	 * 也即确定已经是在登录后才可调用
	 *//*
	@NotAction
	public int getLoginAccountId() {
		return getLoginAccount().getId();
	}*/
}

