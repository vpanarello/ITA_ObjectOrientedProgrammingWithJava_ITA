import java.util.ArrayList;

public class MenuSelecao {
	
	public MenuSelecao() {
		super();
	}

	private itemMenu lastReference;
	
	private boolean selecting = true;
	
	private ArrayList<itemMenu> SubMenu = new ArrayList<>();
	
	public itemMenu addSubMenu(itemMenu list, int listID) {
		this.lastReference = list;
		list.setListID(listID);
		SubMenu.add(list);
		return list;
	}
		
		/* Mecanica dos Menus */
		
	
	public String printHeaderLine(){
		String str = this.printHeader();
		String outStr = "";
		
		for(int i = 0; i < str.length(); i++){
			outStr = outStr + "-";
		}
		return outStr;
	}
		
	public String printHeader(){
		return this.lastReference.getListID() + "- " +this.lastReference.getTitle();
	}
	
	public String printMenu(){
		String[] strArray = this.lastReference.getSelectList();
		
		String  returnString = "";
		int i = 1;
		for (String str : strArray){
			returnString = returnString + i + ") "+ str + '\n';
			i++;
		}
		return returnString;
	}
	public void doMenuSelection(int selectedValue){
		
		int menuSize = this.lastReference.getNextItemMenu().length;
		
		if(selectedValue > 0 && selectedValue <= menuSize){
			
			this.lastReference.setSelectedValue(selectedValue);
			
			if (this.lastReference.isEndOfBranch()){
				this.lastReference = this.SubMenu.get(this.SubMenu.size() - 1);
				this.selecting = false;
			}else{
				this.lastReference = this.lastReference.getNextItemMenu()[selectedValue - 1];				
			}
			
		}
		
	}
	public boolean isSelecting(){
		return this.selecting;
	}
	
public int[] getSelectionsList(){
		
		int[] retValue = new int[this.SubMenu.size()];
		
		for(int i = 0; i < this.SubMenu.size(); i++){
			retValue[i] = SubMenu.get(i).getSelectedValue();
		}
		return retValue;
	}
	
public itemMenu[] getObjSequenceList(){
		
		itemMenu[] retValue = new itemMenu[this.SubMenu.size()];
		
		for(int i = 0; i < this.SubMenu.size(); i++){
			retValue[i] = SubMenu.get(i);
		}
		return retValue;
	}
	
/*	public void testMethod(){
		
		 for(int i = 0; i < this.SubMenu.size(); i++){
			 System.out.print(i);
			 System.out.println(this.SubMenu.get(i).getTitle());
			 System.out.println(this.SubMenu.get(i).isEndOfBranch());
	}
	
 }*/
}
