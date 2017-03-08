namespace PerformTasks
{
    using System;
    using System.IO;
    using System.Linq;
    using System.Linq.Expressions;
    using MassDefect.Data;
    using Newtonsoft.Json;

    public class Program
    {
        public static void Main(string[] args)
        {
            MassDefectContext context = new MassDefectContext();

//            ExportPlanetsWhichAreNotAnomalyOrigins(context);

//            ExportPeopleWhichHaveNotBeenVictims(context);

            ExportTopAnomaly(context);
        }

        private static void ExportTopAnomaly(MassDefectContext context)
        {
            int maxCount = context.Anomalies
                .Select(oa => oa.Victims.Count)
                .ToList()
                .OrderByDescending(oa => oa)
                .FirstOrDefault();

            var topAnomaly = context.Anomalies
                .Where(a => a.Victims.Count == maxCount)
                .Select(a => new
                {
                    id = a.Id,
                    originPlanet = new {name = a.OriginPlanet.Name},
                    teleportPlanet = new {name = a.TeleportPlanet.Name},
                    victimsCount = a.Victims.Count
                });

            var anomalyAsJson = JsonConvert.SerializeObject(topAnomaly, Formatting.Indented);
            File.WriteAllText("../../../results/anomaly.json", anomalyAsJson);

        }

        private static void ExportPeopleWhichHaveNotBeenVictims(MassDefectContext context)
        {
            var notVictims = context.Persons
                .Where(p => !p.Anomalies.Any())
                .Select(p => new
                {
                    name = p.Name,
                    homePlanet = new { name = p.HomePlanet.Name }
                });


            var peopleAsJson = JsonConvert.SerializeObject(notVictims, Formatting.Indented);
            File.WriteAllText("../../../results/people.json", peopleAsJson);
        }

        private static void ExportPlanetsWhichAreNotAnomalyOrigins(MassDefectContext context)
        {
            var exportedPlanets = context.Planets
                .Where(pl => !pl.OriginAnomalies.Any())
                .Select(pl => new
                {
                    name = pl.Name
                });

            var planetsAsJson = JsonConvert.SerializeObject(exportedPlanets, Formatting.Indented);
            File.WriteAllText("../../../results/planets.json", planetsAsJson);
        }
    }
}
