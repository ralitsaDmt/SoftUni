using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _14.Integer_to_Hex_and_Binary
{
    class IntegerToHexAndBinary
    {
        static void Main(string[] args)
        {            
            int num = int.Parse(Console.ReadLine());
            string binary = Convert.ToString(num, 2);
            string hexadecimal = Convert.ToString(num, 16).ToUpper();
                        
            Console.WriteLine(hexadecimal);
            Console.WriteLine(binary);
        }
    }
}
