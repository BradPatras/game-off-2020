# Game Off 2020 | Moonshot 🚀
[Game Jam Homepage](https://itch.io/jam/game-off-2020)

> Game Off is an annual game jam, where participants spend the month of November creating games based on a secret theme. Participate individually, or as a team. Use whatever game engines, libraries, and languages you like.
>
> The theme for this year’s Game Off is MOONSHOT.


I know almost nothing about game development so this'll be interesting 🤷 

## The short of it
The idea I settled on is a gravity/physics based game where you try to launch a spaceship from a planetary orbit to a lunar orbit with little to no assists.  
I'm thinking about having a mathematics component where the mass, distance, velocity, etc. numbers are available to you so you would hypothetically be able to nail it if you wanted to do the math. Or you can just wing it 🤙

It could have randomly generated levels where the masses of the planet and moon change, requiring you to adjust your launch strategy.

A challenge will also be fitting this kind of game on a phone screen.  It would be easiest to keep the game camera static with just the planet and the moon in frame, but I imagine that getting to the lunar orbit might require the ship going far off to the left/right of the screen.  So I may also try to zoom or pan the camera to follow the ship while it's in transit.

I also haven't decided how to handle the controls, it could be a one-shot deal where you choose how much power to use before the launch then your're locked in, or maybe the player has retro/prograde thruster control and fuel to worry about

## Dev Log

I'm most comfortable in Android, so I'm going to use libGDX as my game engine.  I'm relying pretty heavily on tutorials to get all the basics set up.  I'm using the Ashley and Box2D libraries within the libGDX family.

### References/Resources
[Full Ashley Example](https://www.gamedevelopment.blog/full-libgdx-game-tutorial-entities-ashley/)

### Ashley
Ashley is an Entity framework developed by the people at libGDX and from my brief looks into it, I like how clean it makes the code.  

### Box2D
I haven't looked into this much yet but from what I understand, it makes handling collisions easier.
