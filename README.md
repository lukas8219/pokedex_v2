# PokeDex
 
PokeDex WebApp designed with Microservices architecture.

## MicroServices

1. PokemonData Service :heavy_check_mark:
2.  PokemonList Service
3. EvolutionChain Service
4. Discovery Server(Eureka Server)
5. Client Service.

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
