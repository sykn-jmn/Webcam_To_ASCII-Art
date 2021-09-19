# Webcam_To_ASCII-Art
converts frames from webcam into ASCII characters
# Webcam To ASCII Art
**Run Application**

Run the `main` method in the UnoApp class or use the following command in the terminal:
## Sample Output


## Core Domain

The core game logic is built according to [official uno rules](https://en.wikipedia.org/wiki/Uno_(card_game)#Official_rules).

### Uno Card

Cards are value objects, i.e. immutable. The following card types are available in Uno: 
* Number Card
* Skip Action Card
* Reverse Action Card
* Draw Two Action Card
* Wild Color Card
* Wild Draw Four Card

Initially wild cards don't have a color. When drawn, a new value object is created with the chosen color. 

![card-uml](./doc/cards.png)

### Player

`Player` is an entity which contains a list of hand cards to play.

`PlayerRoundIterator` manages the players and switches turn as if the players are in a round table.

![player-uml](./doc/player.png)

### Game

`Game` is the aggregate which maintains the state of **players**, **draw pile** and **discard pile** as the cards are played. 

![game-uml](./doc/game.png)

### Domain Events

`Game` aggregate produces domain events using `DomainEventPublisher`.

Subscribers can register for these events and handle them accordingly. 

![events-uml](./doc/events.png)
