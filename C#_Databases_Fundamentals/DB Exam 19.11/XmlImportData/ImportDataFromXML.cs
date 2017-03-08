namespace XmlImportData
{
    using System;
    using System.Linq;
    using System.Net;
    using System.Xml.Linq;
    using System.Xml.XPath;
    using MassDefect.Data;
    using MassDefect.Models;

    public class ImportDataFromXML
    {
        private const string NewAnomaliesPath = "../../../datasets/new-anomalies.xml";

        public static void Main(string[] args)
        {
            var xml = XDocument.Load(NewAnomaliesPath);
            var anomalies = xml.XPathSelectElements("anomalies/anomaly");

            MassDefectContext context = new MassDefectContext();
            foreach (XElement anomaly in anomalies)
            {
                ImportAnomalyAndVictims(anomaly, context);
            }
        }

        private static void ImportAnomalyAndVictims(XElement anomalyNode, MassDefectContext context)
        {
            var originPlanetName = anomalyNode.Attribute("origin-planet");
            var teleportPlanetName = anomalyNode.Attribute("teleport-planet");

            if (originPlanetName == null || teleportPlanetName == null)
            {
                Console.WriteLine("Error: Invalid data.");
                return;
            }

            var anomalyEntity = new Anomaly
            {
                OriginPlanet = GetPlanetByName(originPlanetName.Value, context),
                TeleportPlanet = GetPlanetByName(teleportPlanetName.Value, context)
            };

            if (anomalyEntity.OriginPlanet == null || anomalyEntity.TeleportPlanet == null)
            {
                Console.WriteLine("Error: Invalid data.");
                return;
            }

            context.Anomalies.Add(anomalyEntity);

            var victims = anomalyNode.XPathSelectElements("victims/victim");
            foreach (XElement victim in victims)
            {
                ImportVictim(victim, context, anomalyEntity);
            }
            context.SaveChanges();
            Console.WriteLine("Successfully imported anomaly.");
        }

        private static void ImportVictim(XElement victimNode, MassDefectContext context, Anomaly anomalyEntity)
        {
            var name = victimNode.Attribute("name");
            if (name == null)
            {
                return;
            }

            var personEntity = GetPersonByName(name.Value, context);
            if (personEntity == null)
            {
                return;
            }

            anomalyEntity.Victims.Add(personEntity);
        }

        private static Person GetPersonByName(string name, MassDefectContext context)
        {
            return context.Persons.FirstOrDefault(p => p.Name == name);
        }

        private static Planet GetPlanetByName(string originPlanetName, MassDefectContext context)
        {
            return context.Planets.FirstOrDefault(p => p.Name == originPlanetName);
        }
    }
}
