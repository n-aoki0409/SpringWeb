package controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import logic.Item;
import logic.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(method = RequestMethod.GET, value = "/item/index")
	public ModelAndView index() {

		// 商品一覧情報を取得
		List<Item> itemList = this.itemService.getItemList();

		// モデルの作成
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemList", itemList);

		// 戻り値となるModelAndViewインスタンスを作成
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addAllObjects(model);

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/item/search")
	public ModelAndView search(String itemName) {
		if (itemName == null || itemName.equals("")) {
			// 検索商品名が空の場合、商品全件を返す
			return this.index();
		}

		List<Item> itemList = this.itemService.getItemByItemName(itemName);
		if (itemList == null || itemList.isEmpty()) {
			// 検索商品名が空の場合、商品全件を返す
			return this.index();
		}

		// 戻り値となるModelAndViewインスタンスを作成
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("itemList", itemList);

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/item/create")
	public ModelAndView create() {
		ModelAndView modelAndView = new ModelAndView("add");
		modelAndView.addObject(new Item());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/item/register")
	public ModelAndView register(@Valid Item item, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("add");
			modelAndView.getModel().putAll(bindingResult.getModel());
			return modelAndView;
		}
		this.itemService.entryItem(item);
		return this.index();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/item/edit")
	public ModelAndView edit(Integer itemId) {
		ModelAndView modelAndView = new ModelAndView("update");
		Item item = this.itemService.getItemByItemId(itemId);
		modelAndView.addObject(item);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/item/update")
	public ModelAndView update(@Valid Item item, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("update");
			modelAndView.getModel().putAll(bindingResult.getModel());
			return modelAndView;
		}
		this.itemService.updateItem(item);
		return this.index();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/item/confirm")
	public ModelAndView confirm(Integer itemId) {
		ModelAndView modelAndView = new ModelAndView("delete");
		Item item = this.itemService.getItemByItemId(itemId);
		modelAndView.addObject(item);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/item/delete")
	public ModelAndView delete(Item item) {
		this.itemService.deleteItem(item);
		return this.index();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/item/image")
	public void image(Integer itemId, HttpServletResponse response) {
		response.setContentType("image/jpeg");
		InputStream picture = null;
		OutputStream os = null;
		BufferedInputStream bis = null;
		try {
			picture = this.itemService.getPicture(itemId);
			os = response.getOutputStream();
			bis = new BufferedInputStream(picture);
			int data;
			while ((data = bis.read()) != -1) {
				os.write(data);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (picture != null) {
					picture.close();
					os.close();
					bis.close();
				}
			} catch (IOException e) {
				// closeできなかっただけなので無視する
			}

		}
	}
}