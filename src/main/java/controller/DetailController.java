package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import logic.Item;
import logic.Shop;
import logic.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import utils.WebConstants;

@Controller
public class DetailController {

	@Autowired
	private Shop shopService;

	@RequestMapping(method = RequestMethod.GET, value = "/detail/detail")
	public ModelAndView handleRequestInternal(Integer itemId, HttpSession session) {

		// 選択された商品IDから商品情報を取得
		Item item = this.shopService.getItemByItemId(itemId);

		// モデルの作成
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("item", item);

		// 戻り値となるModelAndViewインスタンスを作成
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(model);

		// ログインユーザを取得
		User loginUser = (User) session.getAttribute(WebConstants.USER_KEY);
		if (loginUser != null) {
			modelAndView.addObject("loginUser", loginUser);
		}
		return modelAndView;
	}
}