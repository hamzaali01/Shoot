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
public class ProjectileFactory extends FactoryCreator {

    @Override
    public Vehicle getPlaneFactory(String name,int x,int y) {
        return null;
    }

    @Override
    public Vehicle getProjectileFactory(String name,int x,int y) {
        if(name.equalsIgnoreCase("PLAYERFIRE")){   
            PlayerFire bullet = new PlayerFire("src/Sprites/PlayerFire/", x, y);
            return bullet;
        }
        else if(name.equalsIgnoreCase("ENEMYFIRE")){
             EnemyFire bullet = new EnemyFire("src/Sprites/EnemyFire/", x, y);
            return bullet;
        }
        return null;
    }
    }
