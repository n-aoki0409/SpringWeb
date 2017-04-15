package controller;

import java.util.HashMap;
import java.util.List;
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
public class IndexController {

	@Autowired
	private Shop shopService;

	@RequestMapping(method = RequestMethod.GET, value = "/index/index")
	public ModelAndView index(HttpSession session) {

		// 商品一覧情報を取得
		List<Item> itemList = this.shopService.getItemList();

		// モデルの作成
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemList", itemList);

		// 戻り値となるModelAndViewインスタンスを作成
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(model);

		User loginUser = (User) session.getAttribute(WebConstants.USER_KEY);
		if (loginUser != null) {
			modelAndView.addObject("loginUser", loginUser);
		}

		return modelAndView;
	}
}