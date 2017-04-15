package logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ItemSet> itemList = new ArrayList<ItemSet>();

	public List<ItemSet> getItemList() {
		return this.itemList;
	}

	public boolean isEmpty() {
		if (this.itemList == null || this.itemList.isEmpty()) {
			return true;
		}
		return false;
	}

	public void push(ItemSet pushedItemSet) {
		// 追加商品がカートに既に存在するかを確認するフラグ
		boolean itemExistInCart = false;

		// 追加された商品の商品IDを取得
		Item pushedItem = pushedItemSet.getItem();
		int pushedItemId = pushedItem.getItemId().intValue();

		// カートの商品の数だけループ
		for (ItemSet cartItemSet : this.itemList) {

			// カート内の商品の商品IDを取得
			Item cartItem = cartItemSet.getItem();
			int cartItemId = cartItem.getItemId().intValue();

			if (cartItemId == pushedItemId) {
				// 同一IDの商品がカートに存在する場合、数量のみ加算
				cartItemSet.addQuantity(pushedItemSet.getQuantity());
				// 追加商品がカート内に既に存在した
				itemExistInCart = true;
				break;
			}
		}

		if (!itemExistInCart) {
			// カートに同一商品がなかったので追加
			this.itemList.add(pushedItemSet);
		}
	}

	public void clearAll() {
		this.itemList = new ArrayList<ItemSet>();
	}
}