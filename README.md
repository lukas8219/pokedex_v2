# PokeDex - @lukas8219
 
PokeDex WebApp - Feb, 2021.

## Technologies

### Language and Main frameWork : Java - SpringBoot, SpringCloud and Eureka Discovery.
### Database: MongoDatabase Community
### Architecture: Microservices
### Libraries used - PokeLibrary(handmade).

## MicroServices

1. PokemonData Service :heavy_check_mark:
2.  PokemonList Service :heavy_check_mark:
3. EvolutionChain Service :heavy_check_mark:
4. Discovery Server(Eureka Server) :heavy_check_mark:
5. Client Service. :heavy_check_mark:

### PokemonData Service

**INPUT**
Pokemon ID.

**OUTPUT**
JSON with
* Pokemon Name (String)
* Pokemon ID (String)
* All 6 Status (HasMap of String to Integer)
* Pokemon Type ( ArrayList of Strings)
* Evolutions (List of Pokemon - null by default calling the Service)
* Icon URL (String)
* Weight (Int)
* Height (Int)
* Abilities (ArrayList of String)

### EvolutionChain Service

**INPUT** : Pokemon ID

**OUTPUT**:
JSON mapping of the Evolution Chain object.
This JSON contains the fields:

* ID - with the Evolution Chain ID
* Evolutions - with an Array of ID's relative to the subsequent pokemon evolution.

### Pokemon List Service

**INPUT** : There are two possible inputs. A single ID input, or a ID followed by a Key "?size=".

**OUTPUT** : 

If theres is no Key, a default list consisting of the previous, current and next Pokemon(relative to the input ID) is outputed as JSON objec containing the fields:

* Size = pretty self-explanatory
* pokemonList : an Array of ListItem object( with the fields Name and URL). This URL sends the client to PokemonData Service and retrieves the Pokemon Data.

If there is a Key, the list consists of all Pokemons after the ID. of Size N, arranged the same way as before.

### PokeDex Client

This client has all inputs and its the integration of all microservices, facilitating all the job. There is a Cache only in the Client.

* Api LINKs
 * /{id}
 * /list/{id}
 * /list/{id}?size=N
 
 **The ID input retrieves the Pokemon with the evolutionary chain.**
 
 
 #That's all for the moment! Thank you for Reading!
