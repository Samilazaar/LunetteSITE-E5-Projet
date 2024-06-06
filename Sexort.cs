using System;
using System.io;


String line;
try 
{
    StreamReader sr = new StreamReader ("sexort.rtf");
    line = sr.Readline();
    while (line != null)

{
    Console.WriteLine(line)
    line = sr.Readline();

}
sr.Close();
Console.Readline();
}
catch (Exception e)
{
    Console.WriteLine("Exception: " + e.Message);
}
finally
{
    Console.WriteLine("Executing finally block");
}
