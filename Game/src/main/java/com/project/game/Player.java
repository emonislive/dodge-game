package com.project.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player extends GameObject{

    Handler handler;
    
    public Player(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
    }
    
    @Override
    public void tick() {
        x += velX;
        y += velY;
        
        x = Game.clamp(x, 0, Game.WIDTH -37);
        y = Game.clamp(y, 0, Game.HEIGHT -60);
        
        handler.addObject(new Trail(x, y, ID.Trail, Color.white, 32 ,32, 0.09f, handler));
        
        collision();
        
    }
    
    private void collision(){  // health decrease (damage taken)
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i); // tempObject now basic enemy
            
            if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy){
                if(getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 2;
                }
            }
        }
    }

    @Override
    public void render(Graphics g) { 
        Graphics2D g2d = (Graphics2D) g;
        
        g.setColor(Color.white); // object color
        g.fillRect(x, y, 32, 32); // object size
   
    }

    @Override
    public Rectangle getBounds() {
        
        return new Rectangle(x, y, 32, 32);
        
    }
    
}
