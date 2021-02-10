# PokeDex
 
PokeDex WebApp designed with Microservices architecture.

#MicroServices

PokemonData Service
PokemonList Service
EvolutionChain Service
Discovery Server(Eureka Server)
Client Service.

#PokemonData Service

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

#EvolutionChain Service
