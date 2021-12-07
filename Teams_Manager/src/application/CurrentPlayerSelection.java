package application;

public final class CurrentPlayerSelection {
	private String selection;
	private final static CurrentPlayerSelection INSTANCE = new CurrentPlayerSelection();
	
	private CurrentPlayerSelection() {
		
	}
	
	public static CurrentPlayerSelection getInstance() {
		return INSTANCE;
	}

	public String getSelection() {
		return this.selection;
	}

	public void setSelection(String selection) {
		this.selection = selection;
	}
	
	
}
