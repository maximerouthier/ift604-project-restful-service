package restfulservice;

import java.util.*;

import common.*;

public class Database {
  private List<Action> actionList;
  
  public Database() {
    actionList = new ArrayList<Action>();
    
    setTestData();
  }
  
  public synchronized List<Action> getActionList() {
    List<Action> clone = new ArrayList<Action>();
    for (Action action : actionList) {
      clone.add(action.clone());
    }
    return clone;
  }
  
  public synchronized Action getAction(String id) {
    for (Action action : actionList) {
      if (action.getId().equals(id)) {
        return action.clone();
      }
    }
    return null;
  }
  
  public synchronized boolean addAction(Action action) {
    Action clonedAction = action.clone();
    
    if (actionList.contains(clonedAction)) {
      return false;
    }
    actionList.add(clonedAction);
    return true;
  }
  
  public synchronized boolean updateAction(Action update) {
    Action clonedUpdate = update.clone();
    
    if (actionList.remove(clonedUpdate)) {
      actionList.add(clonedUpdate);
      return true;
    }
    
    return false;
  }
  
  private void setTestData() {
    Action action1 = new Action("Ecrire une lettre d'amour", "Ecrire une lettre d'amour", 80);
    Action action2 = new Action("Preparer un bain romantique surprise", "Preparer un bain romantique surprise", 60);
    Action action3 = new Action("Preparer un petit dejeuner au lit", "Preparer un petit dejeuner au lit", 30);
    Action action4 = new Action("Preparer un diner aux chandelles surprise", "Preparer un diner aux chandelles surprise", 60);
    Action action5 = new Action("Offrir une carte d'amour geante", "Offrir une carte d'amour geante", 50);
    Action action6 = new Action("Laisser des petits mots amoureux un peu partout dans la maison", "Laisser des petits mots amoureux un peu partout dans la maison", 40);
    actionList.add(action1);
    actionList.add(action2);
    actionList.add(action3);
    actionList.add(action4);
    actionList.add(action5);
    actionList.add(action6);
  }
}
