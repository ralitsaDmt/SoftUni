namespace JsonImportData
{
    using System;
    using System.Collections;
    using System.Collections.Generic;
    using System.IO;
    using System.Linq;
    using MassDefect.Data;
    using MassDefect.Models;
    using ModelsDTO;
    using Newtonsoft.Json;

    public class ImportDataFromJSON
    {
        private const string SolarSystemPath = "../../../datasets/solar-systems.json";

        private const string StarsPath = "../../../datasets/stars.json";

        private const string PlanetsPath = "../../../datasets/planets.json";

        private const string PersonsPath = "../../../datasets/persons.json";

        private const string AnomaliesPath = "../../../datasets/anomalies.json";

        private const string AnomalyVictimsPath = "../../../datasets/anomaly-victims.json";

        public static void Main(string[] args)
        {
            ImportSolarSystems();
            ImportStars();
            ImportPlanets();
            ImportPersons();
            ImportAnomalies();
            ImportAnomalyVictims();

        }

        private static void ImportAnomalyVictims()
        {
            MassDefectContext context = new MassDefectContext();
            var json = File.ReadAllText(AnomalyVictimsPath);
            var anomalyVictims = JsonConvert.DeserializeObject<IEnumerable<AnomalyVictimsDTO>>(json);

            foreach (AnomalyVictimsDTO anomalyVictim in anomalyVictims)
            {
                if (anomalyVictim.Id == null || anomalyVictim.Person == null)
                {
                    Console.WriteLine("Error: Invalid data.");
                    continue;
                }

                var anomalyEntity = GetAnomalyById(anomalyVictim.Id, context);
                var personEntity = GetPersonByName(anomalyVictim.Person, context);

                if (anomalyEntity == null || personEntity == null)
                {
                    Console.WriteLine("Error: Invalid data.");
                    continue;
                }
                
                anomalyEntity.Victims.Add(personEntity);

            }

            context.SaveChanges();
        }

        private static Person GetPersonByName(string person, MassDefectContext context)
        {
            return context.Persons.FirstOrDefault(p => p.Name == person);
        }

        private static Anomaly GetAnomalyById(int id, MassDefectContext context)
        {
            return context.Anomalies.Find(id);
        }

        private static void ImportAnomalies()
        {
            MassDefectContext context = new MassDefectContext();
            var json = File.ReadAllText(AnomaliesPath);
            var anomalies = JsonConvert.DeserializeObject<IEnumerable<AnomalyDTO>>(json);

            foreach (AnomalyDTO anomaly in anomalies)
            {
                if (anomaly.OriginPlanet == null || anomaly.TeleportPlanet == null)
                {
                    Console.WriteLine("Error: Invalid data.");
                    continue;
                }

                var anomalyEntity = new Anomaly()
                {
                    OriginPlanet = GetPlanetByName(anomaly.OriginPlanet, context),
                    TeleportPlanet = GetPlanetByName(anomaly.TeleportPlanet, context)
                };

                if (anomalyEntity.OriginPlanet == null || anomalyEntity.TeleportPlanet == null)
                {
                    Console.WriteLine("Error: Invalid data.");
                    continue;
                }

                context.Anomalies.Add(anomalyEntity);
                Console.WriteLine($"Successfully imported anomaly.");
            }

            context.SaveChanges();
        }

        private static void ImportPersons()
        {
            MassDefectContext context = new MassDefectContext();
            var json = File.ReadAllText(PersonsPath);
            var persons = JsonConvert.DeserializeObject<IEnumerable<PersonDTO>>(json);

            foreach (PersonDTO person in persons)
            {
                if (person.Name == null || person.HomePlanet == null)
                {
                    Console.WriteLine("Error: Invalid data.");
                    continue;
                }

                var personEntity = new Person()
                {
                    Name = person.Name,
                    HomePlanet = GetPlanetByName(person.HomePlanet, context)
                };

                if (personEntity.HomePlanet == null)
                {
                    Console.WriteLine("Error: Invalid data.");
                    continue;
                }

                context.Persons.Add(personEntity);
                Console.WriteLine($"Successfully imported person entity {personEntity.Name}.");
            }

            context.SaveChanges();
        }

        private static Planet GetPlanetByName(string homePlanet, MassDefectContext context)
        {
            return context.Planets.FirstOrDefault(p => p.Name == homePlanet);
        }

        private static void ImportPlanets()
        {
            MassDefectContext context = new MassDefectContext();
            var json = File.ReadAllText(PlanetsPath);
            var planets = JsonConvert.DeserializeObject<IEnumerable<PlanetDTO>>(json);

            foreach (PlanetDTO planet in planets)
            {
                if (planet.Name == null ||
                    planet.Sun == null ||
                    planet.SolarSystem == null)
                {
                    Console.WriteLine("Error: Invalid data.");
                    continue;
                }

                var planetEntity = new Planet()
                {
                    Name = planet.Name,
                    Sun = GetSunByName(planet.Sun, context),
                    SolarSystem = GetSolarSystemByName(planet.SolarSystem, context)
                };

                if (planet.Sun == null || planet.SolarSystem == null)
                {
                    Console.WriteLine("Error: Invalid data.");
                    continue;
                }

                context.Planets.Add(planetEntity);
                Console.WriteLine($"Successfully imported planet entity {planetEntity.Name}.");
            }

            context.SaveChanges();
        }

        private static Star GetSunByName(string sun, MassDefectContext context)
        {
            return context.Stars.FirstOrDefault(s => s.Name == sun);
        }

        private static void ImportStars()
        {
            MassDefectContext context = new MassDefectContext();
            var json = File.ReadAllText(StarsPath);
            var stars = JsonConvert.DeserializeObject<IEnumerable<StarDTO>>(json);

            foreach (StarDTO star in stars)
            {
                if (star.Name == null || star.SolarSystem == null)
                {
                    Console.WriteLine("Error: Invalid data.");
                    continue;
                }

                var starEntity = new Star()
                {
                    Name = star.Name,
                    SolarSystem = GetSolarSystemByName(star.SolarSystem, context)
                };

                if (starEntity.SolarSystem == null)
                {
                    Console.WriteLine("Error: Invalid data.");
                    continue;
                }

                context.Stars.Add(starEntity);
                Console.WriteLine($"Successfully imported star entity {starEntity.Name}.");
            }

            context.SaveChanges();
        }

        private static SolarSystem GetSolarSystemByName(string solarSystem, MassDefectContext context)
        {
            return context.SolarSystems.FirstOrDefault(ss => ss.Name == solarSystem);
        }

        private static void ImportSolarSystems()
        {
            MassDefectContext context = new MassDefectContext();
            var json = File.ReadAllText(SolarSystemPath);
            var solarSystems = JsonConvert.DeserializeObject<IEnumerable<SolarSystemDTO>>(json);

            foreach (SolarSystemDTO solarSystem in solarSystems)
            {
                if (solarSystem.Name == null)
                {
                    Console.WriteLine("Error: Invalid data.");
                    continue;
                }

                var solarSystemEntity = new SolarSystem
                {
                    Name = solarSystem.Name
                };

                context.SolarSystems.Add(solarSystemEntity);
                Console.WriteLine($"Successfully imported solar system entity {solarSystemEntity.Name}.");
            }

            context.SaveChanges();
        }
    }
}
