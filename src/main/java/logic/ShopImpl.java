package logic;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopImpl implements Shop {

	@Autowired
	private ItemCatalog itemCatalog;

	@Autowired
	private UserCatalog userCatalog;

	@Autowired
	private SaleCatalog saleCatalog;

	public Cart getCart() {
		return new Cart();
	}

	public Integer calculateTotalAmount(List<ItemSet> itemList) {
		// 合計金額
		int totalAmount = 0;
		for (ItemSet itemSet : itemList) {
			int price = itemSet.getItem().getPrice().intValue();
			int quantity = itemSet.getQuantity().intValue();
			totalAmount = totalAmount + (price * quantity);
		}
		return new Integer(totalAmount);
	}

	public void checkout(User user, Cart cart) {
		// 売上情報作成
		Sale sale = createSale(user, cart);
		// 売上情報を登録
		entrySale(sale);
	}

	public List<Item> getItemList() {
		return this.itemCatalog.getItemList();
	}

	public Item getItemByItemId(Integer itemId) {
		return this.itemCatalog.getItemByItemId(itemId);
	}

	public User getUserByUserIdAndPassword(String userId, String password) {
		return this.userCatalog.getUserByUserIdAndPassword(userId, password);
	}

	public void entryUser(User user) {
		this.userCatalog.entryUser(user);
	}

	private void entrySale(Sale sale) {
		this.saleCatalog.entrySale(sale);
	}

	private Sale createSale(User user, Cart cart) {
		// 売上情報作成
		Sale sale = new Sale();
		sale.setSaleId(getNewSaleId());
		sale.setUser(user);
		Timestamp currentTime = getCurrentTime();
		sale.setUpdateTime(currentTime);

		// カートの商品種類分売上明細情報を作成
		List<ItemSet> itemList = cart.getItemList();
		for (int i = 0; i < itemList.size(); i++) {
			ItemSet itemSet = (ItemSet) itemList.get(i);
			// 売上明細IDは 1 番から設定
			int saleLineId = i + 1;
			SaleLine saleLine = createSaleLine(sale, saleLineId, itemSet, currentTime);
			sale.addSaleLine(saleLine);
		}
		return sale;
	}

	private Integer getNewSaleId() {
		return this.saleCatalog.getNewSaleId();
	}

	private Timestamp getCurrentTime() {
		return new Timestamp(Calendar.getInstance().getTimeInMillis());
	}

	private SaleLine createSaleLine(Sale sale, int saleLineId, ItemSet itemSet, Timestamp currentTime) {
		return new SaleLine(sale, new Integer(saleLineId), itemSet, currentTime);
	}
}