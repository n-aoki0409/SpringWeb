package logic;

import static org.hamcrest.CoreMatchers.is;
import logic.Cart;

import org.junit.Assert;
import org.junit.Test;

public class CartTest {

	@Test
	public void getItemList_初期状態_itemListが空リストであること() {
		Assert.assertThat(new Cart().getItemList().size(), is(0));
	}
}
