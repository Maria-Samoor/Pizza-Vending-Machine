# Pizza Vending Machine
## Project Description 
This project is about mixing ingredients to make great and delicious Pizzas. Your design should employ Object Oriented Design Concepts whenever needed. The following guidelines help you specify the system main objects and its relationships:

The ingredients for making a Pizza can be mozzarella cheese, salt, flour, yeast, tomatoes, garlic, onion, pizza sauce, and oregano. Each of the ingredients has a name, weight, and amount of calories it contains. A Mixer is used to make the Pizza dough, the pizza dough has 3 different sizes; small, medium, and large, and can be deep dish or pan, and pizza dough is poured into pans. Ingredients are then added to the pan, The Pizza Pan can tell you a few useful information; the total amount of calories the Pizza contains, its size, and its pan. The pan has a size, so you need to be careful not to exceed its capacity when adding the Pizza dough. Each pizza slice has a Capacity and can tell about its content calories.

●	Using the mixer, make pizza dough

●	Pour pizza dough into a pan, if the pan size does not fit the dough, the pan throws an Exception

●	Add ingredients to the pizza dough in the pan, if the ingredients weights exceed the recommended weight for each ingredient, the Pan will throw an exception.

●	The Pan will Bake the mixture, and after that: 


       o	The Pan can tell the final size and ingredients of the Pizza.

       o	The Pan can tell the total calories it has

       o	The Pan cuts the pizza into slices, each slice calories is known.

●	Modify the constructor of the classes you created so it will take a logger object that implements interface Logger which have has one method (log(String))

●	At this point the system is supposed to be working using standard input/output (Console application)

●	Save the System objects’ data permanently into files.

●	Load the saved data from the files and create the corresponding objects to hold these data.
