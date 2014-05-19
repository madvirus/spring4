package net.madvirus.spring4.chap13.store.model;

public class ItemNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer itemId;

	public ItemNotFoundException(Integer itemId) {
		super("not found item: id=" + itemId);
		this.itemId = itemId;
	}

	public Integer getItemId() {
		return itemId;
	}

}
