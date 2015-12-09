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
    Action action1 = new Action(
      "id1",
      "description1",
      1
    );
    
    Action action2 = new Action(
      "id2",
      "description2",
      2
    );
    
    Action action3 = new Action(
      "id3",
      "description3",
      3
    );
    
    actionList.add(action1);
    actionList.add(action2);
    actionList.add(action3);
  }
}
