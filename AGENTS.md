# Coding instructions


## Functions

Create small functions. Each small step should be a separate function.
For example, finding something in a list, or initializing a data class, or asserting a precondition.
When you find a class that is unexpected or not implemented, log a warning or throw an exception. 
Do not silently ignore cases that are not implemented.

## Names

Do not abbreviate words in class, method or variable names 
unless the abbreviation is more common than the full term.
2-letter abbreviations are almost always nonobvious and should be avoided.
Never cut off words in names to save space.

Good abbreviations: HTTP, JSON, ESDL, CAPEX, OPEX.

Bad abbreviations:

- Day ahead (DA)
- Conf (configuration)
- Env (environment)
- GC (grid connection)

Use compound names to clarify meaning and intent. 

Good compound names:

- rootAsset
- defaultSetting

## Comments

A class or its most important method usually should have a comment.

Comments should not explain things that are obvious 
from the class or method name, parameter names, 
exception messages or log messages.

Rather it should explain the background:

- in which context is this class needed
- what assumptions are made that are not possible to check in the code
- what do the parameters represent, how did they come into existence

## Specific instructions for the LUX ESDL project.

When reading the ESDL, do not use the generic eContents() 
or any other method that returns EObject.

Do not try to set all properties of a GridConnection (GC), GridNode, or EnergyAsset (EA).
Set only the properties that can be derived from the ESDL or that you are sure of are necessary.
