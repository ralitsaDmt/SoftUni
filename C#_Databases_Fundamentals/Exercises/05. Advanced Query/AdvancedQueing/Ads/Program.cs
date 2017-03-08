using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ads
{
    class Program
    {
        static void Main(string[] args)
        {
            AdsEntities context = new AdsEntities();

            //DataFromRealtedTables(context);

            PlayWithToList(context);

        }

        private static void PlayWithToList(AdsEntities context)
        {
            var ads = context.Ads
                .ToList()
                .Where(a => a.AdStatus.Status.Equals("Published"))
                .Select(a => new
                {
                    title = a.Title,
                    category = a.Category.Name,
                    town = a.Town.Name,
                    date = a.Date
                })
                .ToList()
                .OrderBy(a => a.date);

            Console.WriteLine(ads);
        }

        private static void DataFromRealtedTables(AdsEntities context)
        {
            // Without include = 1 query
            //            var ads = context.Ads.Select(a => new 
            //            {
            //                title = a.Title,
            //                status = a.AdStatus.Status,
            //                category = a.Category.Name,
            //                town = a.Town.Name,
            //                user = a.AspNetUser.Name
            //            });
            //


            // With include - 1 query

            var ads = context.Ads.Include("Categories")
                .Include("AdStatuses")
                .Include("Towns")
                .Include("AspNetUsers")
                .Select(a => new
                {
                    title = a.Title,
                    status = a.AdStatus.Status,
                    category = a.Category.Name,
                    town = a.Town.Name,
                    user = a.AspNetUser.Name
                });

                foreach (var ad in ads)
                {
                    Console.WriteLine(ad.title);
                    Console.WriteLine(ad.status);
                    Console.WriteLine(ad.category);
                    Console.WriteLine(ad.town);
                    Console.WriteLine(ad.user);
                    Console.WriteLine("-----------------");
                }
        }
    }
}
