
/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

/**
 * This class runs a world that contains a bug and a rock, added at random
 * locations. Click on empty locations to add additional actors. Click on
 * populated locations to invoke methods on their occupants. <br />
 * To build your own worlds, define your own actors and a runner class. See the
 * BoxBugRunner (in the boxBug folder) for an example. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class HomingBugTests
{
    public static void main(String[] args)
    {
    	 
		basic();
		basicRev();
		singleBlock();
		lineBlock();
		diagBlock();
		uBlock();

    }
    
    public static void basic(){
    	 ActorWorld world = new ActorWorld();
    	 Flower target=new Flower();
         world.add(new Location(1,3),target);
         
         
         Bug b=new MuHomingBugFloodFill(target.getLocation());
         world.add(new Location(0,0), b); 
         world.show();
    }
    

    public static void basicRev(){
    	 ActorWorld world = new ActorWorld();
    	 Flower target=new Flower();
         world.add(new Location(2,0),target);
          
         Bug b=new MuHomingBugFloodFill(target.getLocation());
         world.add(new Location(0,3), b); 
         world.show();
    }
    

    public static void singleBlock(){
    	 ActorWorld world = new ActorWorld();
    	 Flower target=new Flower();
         world.add(new Location(0,0),target);
         world.add(new Location(0,1),new Rock());
         
         
         Bug b=new MuHomingBugFloodFill(target.getLocation());
         world.add(new Location(0,3), b); 
         world.show();
    }
    

    public static void lineBlock(){
    	 ActorWorld world = new ActorWorld();
    	 Flower target=new Flower();
         world.add(new Location(1,4),target);
         
         world.add(new Location(0,2),new Rock());
         world.add(new Location(1,2),new Rock());
         world.add(new Location(2,2),new Rock());
             
         
         Bug b=new MuHomingBugFloodFill(target.getLocation());
         world.add(new Location(0,0), b); 
         world.show();
    }
    

    public static void diagBlock(){
    	 ActorWorld world = new ActorWorld();
    	 Flower target=new Flower();
         world.add(new Location(0,0),target);
         
         world.add(new Location(0,1),new Rock());
         world.add(new Location(1,2),new Rock());
         world.add(new Location(2,3),new Rock());
             
         
         Bug b=new MuHomingBugFloodFill(target.getLocation());
         world.add(new Location(0,3), b); 
         world.show();
    }
    

    public static void uBlock(){
    	 ActorWorld world = new ActorWorld();
    	 Flower target=new Flower();
         world.add(new Location(1,4),target);
         
         world.add(new Location(0,1),new Rock());
         world.add(new Location(0,2),new Rock());
         world.add(new Location(0,3),new Rock());
         
         world.add(new Location(1,3),new Rock());
         
         world.add(new Location(2,1),new Rock());
           world.add(new Location(2,2),new Rock());
         world.add(new Location(2,3),new Rock());
         
             
         
         Bug b=new MuHomingBugFloodFill(target.getLocation());
        world.add(new Location(1,2), b); 
         world.show();
    }
}
