package controller;

import javax.servlet.http.HttpSession;

import logic.Cart;
import logic.Shop;
import logic.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import utils.WebConstants;
import exception.CartEmptyException;
import exception.LoginRequiredException;

@Controller
public class EndController {

	@Autowired
	private Shop shopService;

	@RequestMapping(method = RequestMethod.GET, value = "/end/end")
	public ModelAndView end(HttpSession session) {

		// ログインを確認
		User loginUser = (User) session.getAttribute(WebConstants.USER_KEY);
		if (loginUser == null) {
			throw new LoginRequiredException("ログインしていません。");
		}

		// カートの状態を確認
		Cart cart = (Cart) session.getAttribute(WebConstants.CART_KEY);
		if (cart == null || cart.isEmpty()) {
			throw new CartEmptyException("カートが空です。");
		}

		// 売上データ記録
		this.shopService.checkout(loginUser, cart);

		// カート情報削除
		cart.clearAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("loginUser", loginUser);
		return modelAndView;
	}
}