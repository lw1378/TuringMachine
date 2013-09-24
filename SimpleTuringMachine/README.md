The simple sandbox is written with java code
Running with terminal: java SimpleTuringMachine [yourCodeName].lw
The file must end with .lw
And inside you do NOT need to write main method, but you need to write a init() to 
run the code instead.
Method sample:

[variables] yourVar = someValue;
[function] void init() {
    //your code is here
}

If you want to throw an exception, just use the throwExc, and you cannot use "+-*/", instead you should use "add()", "minus()", "multiply()", "divide". And some basic sorting methods are also provided, including bubble sort, inserting sort, selection sort, merge sort, quick sort, and heap sort. And some basic triangle methods are provided, like sin, cos, tan. 
You cannot import other package, and currently arguments are not supported, neither for the system input.
Some file operations are supported, and given some params which can help to decide the specific ways.
Also the net I/O is not supported now.