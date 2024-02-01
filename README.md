# Maze
James Bond has a top-secret mission. He must enter a maze and find some treasures. In this homework, you should help him, and you are expected to create a maze solver algorithm. Lucky for you, you have a map of the mazes. These maps contain 3 groups of characters:
- Walls are represented with “+”, “-“, and “|” characters. When you see one of these characters, you cannot go any further.
- Available paths are represented with lower case characters such as “a”, “b”, “c” and etc. When you see one of these characters, you can move forward.
- Treasures are represented with capital “E” characters. When you see this character, this means that you can find a path successfully.

For the above maze, there are 3 “E” characters, and all are reachable. Therefore, you should print all paths according to increasing order of paths lengths. You should read the maze file name from console.
The output for the above maze is as follows. Please check your program with this input as well as the others that you will create. Note that we will use other input when grading your assignments. 

Also, note that maze can contain a path that has a loop as shown in the following maze with a red box. For this case, your algorithm shouldn't get stuck in the loop. Therefore, you should avoid visiting already 
visited path.
