

public class itemMenu {
	
	
	private int listID = 0;
	private boolean endOfBranch = true;
	private int selectedValue = 0;
	private String title = "";
	private String[] SelectList;
	private itemMenu[] nextItemMenu;
	
	public itemMenu(String title, String[] selectList, itemMenu[] nextItemMenu) {
		super();
		this.title = title;
		this.SelectList = selectList; // Lista de strings
		this.nextItemMenu = nextItemMenu; // lista de proximos objetos
		this.endOfBranch = false;
	}

	public itemMenu(String title, String[] selectList) {
		super();
		this.title = title;
		this.SelectList = selectList; // Lista de strings
		this.endOfBranch = true;
		this.nextItemMenu = new itemMenu[selectList.length];
		for(int i = 0; i < selectList.length; i++ ){
			this.nextItemMenu[i] = null;
		}
		
	}

	
	public int getListID() {
		return listID;
	}
	protected void setListID(int listID) {
		this.listID = listID;
	}

	public int getSelectedValue() {
		return selectedValue;
	}

	public void setSelectedValue(int selectedValue) {
		this.selectedValue = selectedValue;
	}
	

	public boolean isEndOfBranch() {
		return endOfBranch;
	}

	public String getTitle() {
		return title;
	}

	public String[] getSelectList() {
		return SelectList;
	}

	public itemMenu[] getNextItemMenu() {
		return nextItemMenu;
	} 
	

}
