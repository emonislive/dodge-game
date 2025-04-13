package com.project.game;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
    
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    
    public void tick(){
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);         //getting the object id
            
            tempObject.tick();
        }
    }
    // renders all the objects of the game
    public void render(Graphics g){
        for(int i = 0 ; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            
            tempObject.render(g);
        }
    }
    
    public void clearEnemys(){
          for(int i = 0 ; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            
            if(tempObject.getId() == ID.Player){
                object.clear();
                if(Game.gameState != Game.STATE.End)
                addObject(new Player(tempObject.getX(),tempObject.getY(), ID.Player, this));
            }
        }
     }

// add & remove object from the link list
    public void addObject(GameObject object){
        this.object.add(object);
    }
    public void removeObject(GameObject object){
        this.object.remove(object);
    }
}
