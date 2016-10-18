using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;

namespace _001_Demo_Lab
{
    class DemoLab
    {
        private static object process;

        static void Main(string[] args)
        {
            var downloader = new WebClient();
            downloader.DownloadFile("http://www.introprogramming.info/wp-content/uploads/2015/10/Intro-CSharp-Book-v2015.pdf", "book.pdf");
            Process.Start("book.pdf");

            //var rnd = new Random();
            //for (int i = 0; i < 100; i++)
            //{
            //    Console.WriteLine(rnd.Next(100, 201));
            //}

            //DateTime peterBirthday = new DateTime(2016, 06, 07);
            //DateTime mariaBirthday = new DateTime(2007, 02, 21);
            //Console.WriteLine(peterBirthday);
            //Console.WriteLine(mariaBirthday);

            //var result = peterBirthday.Subtract(mariaBirthday);
            //Console.WriteLine(result.Duration());
        }
    }
}
