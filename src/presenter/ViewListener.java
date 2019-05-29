package presenter;
/**
 * Provides methods to notify on user interaction
 */
public interface ViewListener {
	public void onButtonClicked(String button);
	
	public void getTextFieldValue(String text);
	
	public void getRowId(String text);
}
