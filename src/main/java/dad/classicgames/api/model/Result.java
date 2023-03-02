package dad.classicgames.api.model;

import java.util.List;

public class Result {

	private List<Item> items;
	private Integer count;
	private String cursor;
	private String previous;
	private Integer total;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getCursor() {
		return cursor;
	}

	public void setCursor(String cursor) {
		this.cursor = cursor;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	@Override
	public String toString() {
		return "Result [items=" + items.size() + ", count=" + count + ", cursor=" + cursor + ", previous=" + previous
				+ ", total=" + total + "]";
	}

}
