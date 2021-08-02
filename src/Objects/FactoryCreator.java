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
public abstract class FactoryCreator {
 public abstract Vehicle getPlaneFactory(String name,int x,int y);   
 public abstract Vehicle getProjectileFactory(String name,int x,int y); 

}
