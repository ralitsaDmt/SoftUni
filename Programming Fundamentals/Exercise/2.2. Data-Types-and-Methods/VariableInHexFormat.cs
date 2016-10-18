using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.Variable_in_Hex_Format
{
    class VariableInHexFormat
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            input = input.Substring(2);
            int toDecimal = Convert.ToInt32(input, 16);
            Console.WriteLine(toDecimal);
        }
    }
}
