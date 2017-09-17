package logic;

import static org.hamcrest.CoreMatchers.is;
import logic.Cart;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

public class CartTest {

	@Test
	public void getItemList_初期状態_itemListが空リストであること() {
		Assert.assertThat(new Cart().getItemList().size(), is(0));
	}

	@Test
	public void getItemList_ItemSetを1件追加_itemListの項目が追加した1件と一致すること() {
		Cart cart = new Cart();
		cart.push(new ItemSet(createItem(0, "testItem", 100, "テストです", null, null), 1));

		Assert.assertThat(cart.getItemList().size(), is(1));
		checkItemSet(cart.getItemList().get(0), 0, "testItem", 100 ,"テストです", null, null, 1);
	}

	/**
	 * ItemSetを検証するメソッド
	 * 
	 * @param itemSet 登録されたItemSet
	 * @param itemId itemId(期待値)
	 * @param itemName itemName(期待値)
	 * @param price price(期待値)
	 * @param description description(期待値)
	 * @param pictureUrl pictureUrl(期待値)
	 * @param picture picture(期待値)
	 * @param quantity quantity(期待値)
	 */
	private void checkItemSet(ItemSet itemSet, Integer itemId, String itemName, Integer price, String description, String pictureUrl, MultipartFile picture, Integer quantity) {
		Assert.assertThat(itemSet.getItem().getItemId(), is(itemId));
		Assert.assertThat(itemSet.getItem().getItemName(), is(itemName));
		Assert.assertThat(itemSet.getItem().getDescription(), is(description));
		Assert.assertThat(itemSet.getItem().getPictureUrl(), is(pictureUrl));
		Assert.assertThat(itemSet.getItem().getPicture(), is(picture));
		Assert.assertThat(itemSet.getQuantity(), is(quantity));
	}

	/**
	 * Item作成メソッド
	 * 
	 * @param itemId
	 * @param itemName
	 * @param price
	 * @param description
	 * @param pictureUrl
	 * @param picture
	 * @return 作成されたItem
	 */
	private Item createItem(Integer itemId, String itemName, Integer price, String description, String pictureUrl, MultipartFile picture) {
		Item item = new Item();
		item.setItemId(itemId);
		item.setItemName(itemName);
		item.setPrice(price);
		item.setDescription(description);
		item.setPictureUrl(pictureUrl);
		item.setPicture(picture);

		return item;
	}
}
