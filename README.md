# SimpleAndFactorial

</br>
</br>
The task was the next:</br>
User enter the path to the file and 3(three) threads start to work.</br>
First thread fills the file with random numbers. The other 2 threads are waiting for the first one to complete.</br>
When file completely filled, second thread looks for prime numbers from file and third calculate factorial from numbers of file.</br>
Each thread, from last 2, should writes the results of its operation into separate file.</br>
In Main method I have to show statistic about execution result of those threads.</br>
</br>
</br>
Program operating conditions.</br>
1. Path to file has to be absolut, example D:\Projects\Java\SimpleAndFactorial\src\main\resources\example.txt.</br>
2. If path to file has incorrect input -> program will stop to work.</br>
3. If directory and/or subdirectories are absence they will be created. Files will be created too. </br>
4. Be carefull! The files with prime numbers and factorials have name prime.txt & factorial.txt. Don't give the main file name from last 2.</br>
5. Random numbers pick up from the range 1 - 20. Integer type. Factorial numbers have a long type.</br>
</br>
</br>
Test of program.</br>
1. Input incorrect absolut path. Example D:\Projects\Java\impleAndFactorial\src\main\resources.</br>
Program will show you an error. Incorrect path.</br>
2. Input correct absolut path YourPath\SimpleAndFactorial\src\main\resources.</br>
Example D:\Projects\Java\SimpleAndFactorial\src\main\resources\example.txt.</br>
Program catch it. Path correct.</br>
3. Enter quantity of random numbers - f.</br>
Program will show you an error. Incorrect type of input data.</br>
4. Enter quantity of random numbers - 0. Or either, you can enter - -5.</br>
Program will show you an error. Length of array should be more than 0.</br>
5. Enter quantity of random numbers. For example - 10.</br>
Program will show you the contents of file with random numbers, file with prime numbers and file with factorial numbers.</br>
3 files in folder near main file (point 2) were created. You can check them with Windows Explorer.
