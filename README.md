# Picasso

An application that allows the user to create expressions that
evaluate to colors and then eventually to images.

See the specification for Picasso on the course web site,
or use our helpful Javadocs!


___

## Implemented extensions:

- Extension 0  
	- Indented note on extension explaining its functionality  
	- Indented note on extension about the `function` code  
<br>

- Extension 1: Generating unique images from strings (Taylor)
	- My extension allows strings of any length to be put into the expression box in the GUI. The code will take that string and 
	get its hashCode. This hash code will be used iteratively to choose both a deterministic function from a list of functions and an
	operator from a list of operators. It does this by taking, for example, hashCode % FunctionList.length, and then choosing the 
	function at that index. Then, the hashCode is divided by 2 and the process repeats. Each of the functions and the operators chosen 
	are then concatenated to the expression iteratively, until we have a string that looks something like "0 + perlinColor(x, y) - 
	log(x) * clamp(y)....". This expression is then parsed and made into an expression tree, which is then evaluated like every other 
	expression tree. Since each hashCode is the same for a particular string, this is deterministic yet produces some incredibly 
	unique and cool pictures. The extension is fairly easy to use: in the expression box of the GUI, use quotation marks around any 
	string. Foe example, try "computer science" or  "<your name>". If the string, for example, is "foo.jpg", the image displayed will 
	be the image found in the  images directory. But, if the string cannot be mapped to a path for an image, it will create an image 
	for you!
<br>

- Extension 2  
<br>

- Extension 3  

___

## Authors:  
	
	- AbdelRahman AboEitta
	- August Donovan
	- Taylor Tucker
	- Will Medick
	- Danny Kung

___ 

August referenced this [markdown guide](https://www.markdownguide.org/basic-syntax/) to create this README.