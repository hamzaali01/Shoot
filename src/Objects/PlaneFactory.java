/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;



/**
 *
 * @author HP
 */
public class PlaneFactory extends FactoryCreator {

    @Override
    public Vehicle getPlaneFactory(String name, int x,int y) {
        if(name.equalsIgnoreCase("FIGHTER")){   
            Fighter fighter = new Fighter("src/Sprites/FighterSprite/",x, y);
            return fighter;
        }
        else if(name.equalsIgnoreCase("BOMBER")){
             Bomber bomber = new Bomber("src/Sprites/B-17/Type-1/Animation/",x, y);
             return bomber;
        }
        return null;
    }

    @Override
    public Vehicle getProjectileFactory(String name,int x,int y) {
    return null;
    }
    
}
